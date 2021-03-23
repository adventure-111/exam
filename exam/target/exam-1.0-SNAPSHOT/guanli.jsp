<%@ page import="cn.cuit.exam.domain.Admin" %>
<%@ page import="cn.cuit.exam.domain.School" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>高等院校考试计划安排系统-管理端</title>
    <style>
        * {
			margin: 0;
			padding: 0;
			font-family: 仿宋;
		    font-size: x-large; 
		}
        h3{
            padding-top: 15px;
        }
        .list_dt { 
            border: 1px darkcyan solid;
            background-color: rgb(72, 194, 194);
            width:248px;
            height: 60px;
            text-align: center;
            vertical-align: middle;
            border-radius: 5px;
            color: rgb(233, 222, 222); 
			cursor: pointer; 
			overflow: hidden; 
			text-overflow: ellipsis; 
			white-space: nowrap; 
			position: relative; 
			border-bottom: 1px solid #464646; 
		}
        .list_dt:hover {
	        background-color: rgb(104, 178, 180);
            color: white;
	    }
        #open { 
            background: rgb(104, 178, 180);
        }
        .list_dd { 
            display: none; 
        }
        .list_li { 
            border: 1px darkcyan solid;
            background-color: #b3f6f8;
            width:248px;
            height: 30px;
            text-align: center;
            vertical-align: middle;
            border-radius: 5px;
            color: rgb(27, 131, 134);
            cursor: pointer; 
            border-bottom: 1px solid #6b6b6b; 
        }
        .list_li:hover { 
            background: #10484d; 
        }
        .borders{
            border: 1px #5ba3af solid; border-radius: 10px; margin-left: 300px; height: 30px; width: 1100px; margin-top: 10px;
        }
        .borders_flag{
            float: left; margin-top: 7px; font-size: small; font-weight: 800; margin-left: 15px; color: rgb(39, 90, 87);
        }
        .borders_list{
            background: lightcoral; height: 20px; width: 60px; margin-left: 100px; margin-top: 4px;
        }
        .div_tables{

        }
        #exam_time_div{
            display: none;
        }
    </style>
</head>

<body style="background: url(./img/bottom_login.png) no-repeat center 0px;
background-position: center 0; background-size: cover;">
    <div style="height: 60px; background-color: rgb(26, 97, 97); vertical-align: middle;">
        <div style="float: left; height: 60px;width: 550px;">
            <h1 style="color: white; font-family: 楷体;padding-left: 30px; padding-top: 10px;  font-size: xx-large;">
                高等院校考试计划安排系统-管理端
            </h1>
        </div>
        <div style="float: right; margin-left: 200px; height: 60px; width:350px;">
            <div style="margin-top: 30px; float: left; height: 30px; width: 200px; ">
                <span style="font-size: small; font-weight: 800; color:white;">
                    ${sessionScope.user.username} (
                    <%
                        String school = ((Admin)session.getAttribute("user")).getSchool();
                        out.print(new School().getName(school));
                    %>
                    )
                </span>
            </div>
            <div style="float: left; margin-top: 30px; background-color: #124136; height: 30px;width: 80px;">
                <a style="font-size: medium; padding-left: 6px; font-weight: 700; color: white; cursor: pointer;" href="/exam/updatePwd">
                    修改密码
                </a>
            </div>
            <div style="float: left; height: 30px; width: 15px;"></div>
            <div style="float: left; margin-top: 30px; background-color: #124136; height: 30px;width: 50px;">
                <a style="font-size: medium; padding-left: 6px; font-weight: 700; padding-left: 8px; color: white; cursor: pointer; "; href="/login.html">退出</a>
            </div>
        </div>
       
    </div>
     <dl class="list_dl" style="float: left; width: 250px; height: 800px; background-color:rgb(11, 161, 161)">
        <div style="width: 250px; height: 100px;"></div>
        <dt class="list_dt">
            <h3>基础数据维护</h3>
        </dt>
        <dd class="list_dd">
            <ul>
                <li class="list_li" id="class_data">课程数据</li>
                <li class="list_li" id="place_data">考场数据</li>
                <li class="list_li" id="student_data">学生数据</li>
                <li class="list_li" id="teacher_data">教师数据</li>
            </ul>
        </dd>
        <dt class="list_dt">
            <h3>考试安排</h3>
        </dt>
        <dd class="list_dd">
            <ul>
                <li class="list_li" id="exam_time">考试时间安排</li>
                <li class="list_li" id="exam_place">考试地点安排</li>
                <li class="list_li" id="exam_teacher">监考教师设置</li>
                <li class="list_li" id="exam_arrange">考试安排总览</li>
            </ul>
        </dd>
    </dl>
    <!--初始右界面显示-->
    <p id="right_default" style="text-align: center; font-size: 40px; font-weight: 800;">欢迎使用高等院校考试计划安排系统</p>
    <!--基础数据维护-->
    <!--课程数据-->
    <!--<div class="borders">
        <span class="borders_flag">功能按钮</span>
        <div class="borders_list"></div>
    </div>-->
    <!--考试安排-->
    <!--考试时间安排-->
    <div id="exam_time_div">
        <div class="borders">
            <span class="borders_flag">考试时间段</span>
        </div>
        <div class="borders">
            <span class="borders_flag">条件查询</span>
        </div>
        <table border="1" style="vertical-align: middle; text-align: center; float: left; background: #bcf0ec; margin-left: 50px; height: 550px; width: 650px; margin-top: 10px;border-style: solid; border-color: white">
            <tr style="background-color: rgb(129, 219, 219); height: 40px;">
                <td>课程代码</td>
                <td>课程名</td>
                <td>人数</td>
                <td>考试日期</td>
                <td>考试时间</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
        </table>
    </div>
    
</body>
<script src="./js/jquery-3.5.1.js"></script>
<script>
    $(".list_dt").on("click",function () {  
        $('.list_dd').stop();
        $(this).siblings("dt").removeAttr("id");
        if($(this).attr("id")=="open"){
            $(this).removeAttr("id").siblings("dd").slideUp();
        }else{
            $(this).attr("id","open").next().slideDown().siblings("dd").slideUp();
        }
    });
    $("#class_data").on("click",function(){
        $("#right_default").css("display","none");
    })
    $("#exam_time").on("click",function(){
        $("#right_default").css("display","none");
        $("#exam_time_div").css("display","block");
    })
</script>
</html>