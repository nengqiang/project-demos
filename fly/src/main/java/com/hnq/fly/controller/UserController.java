package com.hnq.fly.controller;

import com.hnq.fly.annotation.LogAnnotation;
import com.hnq.fly.model.bo.UserBO;
import com.hnq.fly.model.request.UserPageRequest;
import com.hnq.fly.model.response.PageDataResponse;
import com.hnq.fly.model.vo.UserVO;
import com.hnq.fly.service.UserService;
import com.hnq.fly.util.UserUtils;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关接口
 *
 * @author henengqiang
 * @date 2020/3/16
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @LogAnnotation
    @PostMapping
    @PreAuthorize("hasAuthority('sys:user:add')")
    public UserVO saveUser(@RequestBody UserBO reqUser) {
        UserBO user = userService.getUserByUsername(reqUser.getUsername());
        if (user != null) {
            throw new IllegalArgumentException(reqUser.getUsername() + "已存在");
        }

        return BeanUtils.convert(userService.saveUser(reqUser), UserVO.class);
    }

    @LogAnnotation
    @PutMapping
    @PreAuthorize("hasAnyAuthority('sys:user:add')")
    public UserVO updateUser(@RequestBody UserBO reqUser) {
        return BeanUtils.convert(userService.updateUser(reqUser), UserVO.class);
    }

    @LogAnnotation
    @PutMapping(params = "headImgUrl")
    public void updateHeadImgUrl(String headImgUrl) {
        UserBO user = UserUtils.getLoginUser();
        assert user != null;
        user.setHeadImgUrl(headImgUrl);

        userService.updateUser(user);
        log.debug("{}修改了头像", user.getUsername());
    }

    @LogAnnotation
    @PutMapping("/{username}")
    @PreAuthorize("hasAnyAuthority('sys:user:password')")
    public void changePassword(@PathVariable String username, String oldPwd, String newPwd) {
        userService.changePassword(username, oldPwd, newPwd);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('sys:user:query')")
    public PageDataResponse<UserVO> listUsers(UserPageRequest request) {
        PageDataResponse<UserBO> data = userService.listUsers(request);
        return new PageDataResponse<>(data.getTotal(), BeanUtils.convert(data.getData(), UserVO.class));
    }

    @GetMapping("/current")
    public UserVO currentUser() {
        return BeanUtils.convert(UserUtils.getLoginUser(), UserVO.class);
    }

    @GetMapping("/{userNo}")
    @PreAuthorize("hasAnyAuthority('sys:user:query')")
    public UserVO user(@PathVariable Long userNo) {
        return BeanUtils.convert(userService.getUserByUserNo(userNo), UserVO.class);
    }

}
