$(document).ready(function () {

    // 初始化当前页码
    let pageNumber = 1;
    $("#query").click(function () {
        queryThirdTool();
    });

    $("#query-accurate").click(function () {
        queryThirdToolAccurate();
    });

    const pageLabel = $("#page-label");
    $("#previous").click(function () {
        if (pageNumber > 1) {
            pageNumber--;
            changePageLabel(pageNumber);
            queryThirdTool();
        }
    });

    $("#next").click(function () {
        pageNumber++;
        changePageLabel(pageNumber);
        queryThirdTool();
    });

    const suspensionBoxWrapper = $("#suspension-box-wrapper");
    $("#create").click(function () {
        $("#prompt").html("添加");
        suspensionBoxWrapper.fadeIn(300);
    });

    $("#edit-sure-button").click(function () {
        let toolName = $("#tool-name").val();
        let toolType = $("#tool-type-selector option:selected").val();
        let link = $("#link-address").val();
        if (isEmpty(toolName) || isEmpty(link)) {
            alertWarning("操作失败！工具名称或链接地址不能为空!");
        } else {
            let data = {"toolName": toolName, "toolType": toolType, "link": link};
            $.ajax({
                method: "POST",
                // url: "/back/createThirdTool",
                data: data,
                dataType: "json",
                success: function (r) {
                    if (r.code === 0) {
                        alertInfo(r.msg + " " + r.result)
                    } else {
                        alertWarning(r.msg);
                    }
                }
            });
        }

        // 模拟点击了取消按钮以隐藏悬浮框
        $("#edit-cancel-button").trigger("click");
    });

    $("#edit-cancel-button").click(function () {
        // 内容清空
        $("#tool-name").val("");
        $("#link-address").val("");
        suspensionBoxWrapper.fadeOut(200);
    });

    // 初始化显示当前页码
    pageLabel.append("当前第" + pageNumber + "页");

    /**
     * 查询第三方工具，limit (pageNumber - 1) * pageSize, pageNumber * pageSize
     */
    function queryThirdTool() {
        // 先清空
        $("#table-body").html("");
        let pageSize = $("#size-selector option:selected").text();
        let data = {"pageNumber": pageNumber, "pageSize": pageSize};
        $.ajax({
            method: "POST",
            url: "/back/queryThirdTool",
            data: data,
            dataType: "json",
            success: function(r) {
                if (r.code === 0) {
                    let result = r.result;
                    for (let i = 0; i < result.length; i++) {
                        let data = result[i];
                        $("#table-body").append(createRow(data, i));
                    }
                } else {
                    alertWarning(r.msg);
                }
            }
        });
    }

    /**
     * 根据工具名关键字筛选查询第三方工具
     */
    function queryThirdToolAccurate() {
        // 先清空
        $("#table-body").html("");
        let pageSize = $("#size-selector option:selected").text();
        let toolName = $("#tool-name-value").val();
        let data = {"toolNameLike": toolName, "pageNumber": pageNumber, "pageSize": pageSize};
        $.ajax({
            method: "POST",
            url: "/back/queryThirdToolAccurate",
            data: data,
            dataType: "json",
            success: function(r) {
                if (r.code === 0) {
                    let result = r.result;
                    for (let i = 0; i < result.length; i++) {
                        let data = result[i];
                        $("#table-body").append(createRow(data, i));
                    }
                } else {
                    alertWarning(r.msg);
                }
            }
        });
    }

    /**
     * 显示当前页码
     * @param number    页码
     */
    function changePageLabel(number) {
        pageLabel.html("当前第" + number + "页");
    }

    /**
     * 创建一个 table 的一行，并填入给定数据
     * @param data              给定数据
     * @param serial            序号，用以给编辑按钮添加 id
     * @returns {HTMLElement}   <tr></tr>
     */
    function createRow(data, serial) {
        let row = document.createElement("tr");
        row.className = "table-tr";

        let idCell = document.createElement("td");
        idCell.className = "code-td";
        idCell.innerHTML = data.id;
        row.appendChild(idCell);

        let nameCell = document.createElement("td");
        nameCell.innerHTML = data.toolName;
        row.appendChild(nameCell);

        let typeCell = document.createElement("td");
        typeCell.innerHTML = queryToolType(data.type);
        row.appendChild(typeCell);

        let linkCell = document.createElement("td");
        linkCell.className = "link-td";
        linkCell.innerHTML = data.link;
        row.appendChild(linkCell);

        let createDateCell = document.createElement("td");
        createDateCell.innerHTML = formatDateTime(data.createDate);
        row.appendChild(createDateCell);

        let lastUpdateDateCell = document.createElement("td");
        lastUpdateDateCell.innerHTML = formatDateTime(data.lastUpdateDate);
        row.appendChild(lastUpdateDateCell);

        let editCell = document.createElement("td");
        editCell.className = "edit-td";
        let editDiv = document.createElement("div");
        editDiv.className = "edit-button edit-act";
        editDiv.id = "edit" + serial;
        editDiv.innerHTML = "编辑";
        let deleteDiv = document.createElement("div");
        deleteDiv.className = "edit-button delete-act";
        deleteDiv.id = "delete" + serial;
        deleteDiv.innerHTML = "删除";
        editCell.appendChild(editDiv);
        editCell.appendChild(deleteDiv);
        row.appendChild(editCell);
        return row;
    }

    /**
     * 工具类型 Integer 映射 String
     * @param type          工具类型 Integer 类型
     * @returns {string}    工具类型 String 类型
     */
    function queryToolType(type) {
        if (type === 1) {
            return "生活常用";
        }
        if (type === 2) {
            return "教育学习";
        }
        if (type === 3) {
            return "办公辅助";
        }
        if (type === 4) {
            return "图片视频";
        }
        if (type === 5) {
            return "网络工具";
        }
        if (type === 6) {
            return "程序开发";
        }
        return "未知类型";
    }

    /**
     * 时间戳转时间串
     * @param timestamp     时间戳
     * @returns {string}    字符串
     */
    function formatDateTime(timestamp) {
        let date = new Date(timestamp);
        let y = date.getFullYear();
        let m = date.getMonth() + 1;
        m = m < 10 ? ('0' + m) : m;
        let d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        let h = date.getHours();
        h = h < 10 ? ('0' + h) : h;
        let minute = date.getMinutes();
        let second = date.getSeconds();
        minute = minute < 10 ? ('0' + minute) : minute;
        second = second < 10 ? ('0' + second) : second;
        return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
    }

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