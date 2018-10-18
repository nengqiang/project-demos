package com.hnq.blog.controller;

import com.hnq.blog.bean.Answer;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
public class AbstractController {

    public Answer<?> renderError(String msg) {
        Answer<Object> answer = new Answer<>();
        return answer.setCode(1).setMsg(msg);
    }

    public Answer<?> renderError(String msg, Object result) {
        Answer<Object> answer = new Answer<>();
        return answer.setCode(1).setMsg(msg).setResult(result);
    }

    public Answer<?> renderAnswer(Object result) {
        Answer<Object> answer = new Answer<>();
        return answer.setCode(0).setMsg("操作完成").setResult(result);
    }

    public Answer<?> renderAnswer(String msg, Object result) {
        Answer<Object> answer = new Answer<>();
        return answer.setCode(0).setMsg(msg).setResult(result);
    }

}
