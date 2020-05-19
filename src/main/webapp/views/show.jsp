<%--
  Created by IntelliJ IDEA.
  User: ROG
  Date: 2020/5/19
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Hello World</title>
    <script src="/js/jquery-3.5.1.min.js"></script>
</head>

<script type="text/javascript">
    //加载初始化数据
    $("#button").click(function () {
        $.ajax({
            url:'/show',
            data:{"id":${id}},
            datatype:'json',
            type:'get',
            success:function(e){

            },
        });
    });

    function getMyDate(str) {
        var oDate = new Date(str),
            oYear = oDate.getFullYear(),
            oMonth = oDate.getMonth()+1,
            oDay = oDate.getDate(),
            oHour = oDate.getHours(),
            oMin = oDate.getMinutes(),
            oSen = oDate.getSeconds(),
            oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay) +' '+ addZero(oHour) +':'+
                addZero(oMin) +':'+addZero(oSen);
        return oTime;
    }

    //补零操作
    function addZero(num){
        if(parseInt(num) < 10){
            num = '0'+num;
        }
        return num;
    }


    function send(e) {
        $.ajax({
            url:'/show',
            data:{"id":e},
            datatype:'json',
            type:'get',
            success:function(res){
                console.log(res);
                //将数据显示在页面上
                var str = "";
                str +="<table border=\"1\" cellspacing=\"0\"><thead><tr><th>login_id</th><th>user_id</th><th>登陆时间</th><th>登陆IP</th></tr></thead><tbody>";
                //遍历数据
                $.each(res.obj,function(index,element){
                    str +="<tr><td>"+element['login_id']+"</td><td>"+element['user_id']+"</td><td>"+getMyDate(element['login_time'])+"</td><td>"+element['login_ip']+"</td></tr>";
                })
                //遍历完成之后
                str +="</tbody></table>";
                //将表格添加到body中
                $('body').append(str);
            }
        })
    }

</script>

<body>
    <h3>登录成功</h3>
    ${id}
    <button id="button" onclick="send(${id})">查看登录记录</button>
</body>
</html>
