$(document).ready(function () {

    /**
     * 登陆面板注册按钮点击动作：隐藏登陆面板，显示注册面板
     */
    $("#login-regist-button").click(function () {
        $("#login-panel").css("display","none");
        $("#register-panel").css("display","block");
    });

    /**
     * 注册面板登陆按钮点击动作：隐藏注册面板，显示登陆面板
     */
    $("#regist-login-button").click(function () {
        $("#login-panel").css("display","block");
        $("#register-panel").css("display","none");
    });

    /**
     * 注册面板注册按钮点击动作：注册
     */
    $("#regist-regist-button").click(function () {
        let username = $("#user-name-label").val();
        let password = $("#password-label").val();
        if (isEmpty(username) || isEmpty(password)) {
            alertWarning("注册失败！用户名或密码不能为空!");
        } else {
            let data = {"userName": username, "password": password};
            $.ajax({
                method: "POST",
                url: "/back/regist",
                data: data,
                dataType: "json",
                success: function (r) {
                    let message = r.msg + r.result;
                    alertWarning(message);
                    // window.location.href="/back/login";
                }
            });
        }
    });

   /**
    * 检测对象是否是空对象(不包含任何可读属性)。
    * 方法既检测对象本身的属性，也检测从原型继承的属性(因此没有使hasOwnProperty)。
    * @param obj    待检测的值
    * ""
    * " "
    * null
    * undefined
    * []
    * {}
    * NaN
    */
    function isEmpty(obj) {
       // 只能用 === 运算来测试某个值是否是未定义的
       if (obj === undefined) {
           return true;
       }
       // 等同于 obj === undefined || obj === null
       if (obj == null) {
           return true;
       }
       // String    
       // "",null,undefined
       if (obj === "" || obj == null || obj === undefined) {
           return true;
       }
       // "",null,undefined,NaN
       if (!obj) {
           return true;
       }
       // "",null,undefined
       if (!$.trim(obj)) {
           return true;
       }
       // Array
       // "",[]
       if (obj.length === 0) {
           return true;
       }
       // "",[]
       if (!obj.length) {
           return true;
       }
       // Object {}
       // 普通对象使用 for...in 判断，有 key 即为 false
       if ($.isEmptyObject(obj)) {
           return true;
       }
       return false;
    }

});