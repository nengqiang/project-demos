//success   成功
//info      信息
//warning   警告
//danger    错误！
function alertBox(type, msg, showTime, callBack) {
    let divCss = "alert alert-" + type + " alert-dismissable";
    if (showTime == null) showTime = 2000;
    let divAlertBox;
    if ($("#divAlertBox").length != 0) {
        $("#divAlertBox span").text(msg);
        divAlertBox = $("#divAlertBox");
        divAlertBox.removeClass().addClass(divCss).slideDown(300);
        box(divAlertBox);
    } else {
        divAlertBox = $("<div id='divAlertBox' style='display:none;position:fixed;z-index:9999;' class='" + divCss + "'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button><span>" + msg + "</span></div>");
        $("body").append(divAlertBox);
        divAlertBox.slideDown(300);
        box(divAlertBox);
    }
    setTimeout(function () {
        divAlertBox.fadeOut(500);
        if (callBack != null) {
            callBack();
        }
    }, showTime);
}

function alertSuccess(msg, showTime, callBack) {
    alertBox("success", msg, showTime, callBack);
}

function alertInfo(msg, showTime, callBack) {
    alertBox("info", msg, showTime, callBack);
}

function alertWarning(msg, showTime, callBack) {
    alertBox("warning", msg, showTime, callBack);
}

function alertDanger(msg, showTime, callBack) {
    alertBox("danger", msg, showTime, callBack);
}

// 必传入回掉函数
function confirmBox(type, msg, callBack) {
    let divConfirmBoxCover;
    let divCss = "alert alert-" + type;
    let divConfirmBox;
    if ($("#divConfirmBox").length != 0) {
        divConfirmBoxCover = $("#divConfirmBoxCover");
        divConfirmBoxCover.show();
        $("#divConfirmBox span").text(msg);
        divConfirmBox = $("#divConfirmBox");
        divConfirmBox.removeClass().addClass(divCss).slideDown(1000);
        divConfirmBox.find("button:first")[0].onclick = callBack;
        box(divConfirmBox);
    } else {
        divConfirmBoxCover = $("<div id='divConfirmBoxCover' style='position:fixed;top:0px;left:0px;z-index:9998;width:100%;height:100%;'><div>");
        divConfirmBox = $("<div id='divConfirmBox' style='display:none;position:fixed;z-index:9999;' class='" + divCss + "'><span>" + msg + "</span><br/></div>");
        let btnYes = $("<button style='margin-top:20px;margin-right:50px;' type='button' class='btn btn-warning'>确定</button>");
        let btnNo = $("<button style='margin-top:20px;float:right;' type='button' class='btn btn-primary'  onclick='confirmBoxHide()'>取消</button>");
        btnYes[0].onclick = callBack;
        divConfirmBox.append(btnYes).append(btnNo);
        $("body").append(divConfirmBox).append(divConfirmBoxCover);
        divConfirmBox.slideDown(1000);
        box(divConfirmBox);
    }
}

function confirmSuccess(msg, callBack) {
    confirmBox("success", msg, callBack);
}

function confirmInfo(msg, callBack) {
    confirmBox("info", msg, callBack);
}

function confirmWarning(msg, callBack) {
    confirmBox("warning", msg, callBack);
}

function confirmDanger(msg, callBack) {
    confirmBox("danger", msg, callBack);
}

function confirmBoxHide() {
    $("#divConfirmBox").fadeOut(1000);
    $("#divConfirmBoxCover").hide();
}

function box(jqObj) {
    // 获取DIV为‘box’的盒子
    let oBox = jqObj[0];
    // 获取元素自身的宽度
    let L1 = oBox.clientWidth;
    // 获取元素自身的高度
    let H1 = oBox.clientHeight;
    // 获取实际页面的left值。（页面宽度减去元素自身宽度/2）
    let Left = (document.documentElement.clientWidth - L1) / 2;
    // 获取实际页面的top值。（页面宽度减去元素自身高度/2）[自己微调位置]
    // let top = (document.documentElement.clientHeight - H1) / 4;
    let top = 50;
    oBox.style.left = Left + 'px';
    oBox.style.top = top + 'px';
}