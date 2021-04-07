<%--
  Created by IntelliJ IDEA.
  User: adventure
  Date: 2021/3/23
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.cuit.exam.domain.Admin" %>
<%@ page import="cn.cuit.exam.dao.StudentDao" %>
<%@ page import="cn.cuit.exam.domain.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.cuit.exam.domain.User" %>
<%@ page import="cn.cuit.exam.util.Major" %>
<%@ page import="cn.cuit.exam.domain.PageBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<c:if test="${empty sessionScope.user}">--%>
<%--    &lt;%&ndash;        用户登录成功后才可访问该页面&ndash;%&gt;--%>
<%--    <c:redirect url="/login_tip.html"></c:redirect>--%>
<%--</c:if>--%>

<html lang="en">
<head>
    <title>高等院校考试计划安排系统-管理端</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script></head>
<body>
<c:set var="rows" value="10"></c:set><!-- 默认一页记录条数-->

<div align="center">
    <form class="form-inline" style="margin: 30px 30px" action="${pageContext.request.contextPath}/studentData">
        <div class="form-group">
            <label for="major_query">专业: </label>
            <select class="form-control major_class" id="major_query" name="major" style="width: 200px; margin-right: 20px">
                <option>${condition.major[0]}</option>
            </select>
        </div>
        <div class="form-group">
            <label for="grade_query">年级</label>
            <input type="text" class="form-control" id="grade_query" name="grade" value="${condition.grade[0]}" style="width: 80px; margin-right: 20px">
        </div>
        <div class="form-group">
            <label for="classname_query">班级</label>
            <input type="text" class="form-control" id="classname_query" name="className" value="${condition.className[0]}" style="width: 80px; margin-right: 20px">
        </div>
        <div class="form-group">
            <label for="sname_query">姓名</label>
            <input type="text" class="form-control" id="sname_query" name="sname" value="${condition.sname[0]}" style="width: 80px; margin-right: 20px">
        </div>
        <div class="form-group">
            <label for="sno_query">学号</label>
            <input type="text" class="form-control" id="sno_query" name="sno" value="${condition.sno[0]}" style="width: 100px; margin-right: 20px">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>

    <div class="center-block" >
        <table border="1" class="table table-hover" style="vertical-align: middle; text-align: center; background: #bcf0ec; margin-left: 50px;  width: 650px; border-style: solid; border-color: white">
            <tr style="background-color: rgb(129, 219, 219); height: 40px;">
                <td><input type="checkbox"></td>
                <td>姓名</td>
                <td>学号</td>
                <td>密码</td>
                <td>班级</td>
                <td>专业</td>
                <td>修改</td>
            </tr>

            <c:forEach items="${requestScope.pageBean.list}" var="st" varStatus="vs">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${st.sname}</td>
                    <td>${st.username}</td>
                    <td>${st.password}</td>
                    <td>${st.className}</td>
                    <td>${st.major}</td>
                    <td><a onclick="getMajors()" data-toggle="modal" data-target="#myModal" data-username=${st.username} data-sname=${st.sname}
                           data-password=${st.password} data-classname=${st.className} data-major=${st.major}>修改</a></td>

                </tr>
            </c:forEach>
        </table>
    </div>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <%-- 第一页时 不可点击上一页按钮--%>
            <c:if test="${pageBean.currentPage == 1}">
                <li class="disabled">   <a onclick="return false;"
            </c:if>
            <c:if test="${pageBean.currentPage != 1}">
                <li>   <a
            </c:if>
                        href="${pageContext.request.contextPath}/studentData?currentPage=${pageBean.currentPage-1}&rows=${rows}&major=${condition.major[0]}&grade=${condition.grade[0]}&className=${condition.className[0]}&sname=${condition.sname[0]}&sno=${condition.sno[0]}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach begin="1" end="${pageBean.totalPage}" var="index">
                <li><a href="${pageContext.request.contextPath}/studentData?currentPage=${index}&rows=${rows}&major=${condition.major[0]}&grade=${condition.grade[0]}&className=${condition.className[0]}&sname=${condition.sname[0]}&sno=${condition.sno[0]}">${index}</a></li>
            </c:forEach>

                <%-- 最后一页时 不可点击下一页按钮--%>
                <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                <li class="disabled">   <a onclick="return false;"
            </c:if>
            <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                <li>   <a
            </c:if>
                        href="${pageContext.request.contextPath}/studentData?currentPage=${pageBean.currentPage+1}&rows=${rows}&major=${condition.major[0]}&grade=${condition.grade[0]}&className=${condition.className[0]}&sname=${condition.sname[0]}&sno=${condition.sno[0]}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            &nbsp;&nbsp;共${pageBean.totalCount}条记录&nbsp;|&nbsp;共${pageBean.totalPage}页
        </ul>
    </nav>

</div>

<!-- 模态框 修改学生信息 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改学生信息
                </h4>
            </div>

            <div class="modal-body form-group">
                <form method="post" action="${pageContext.request.contextPath}/UpdateStudent">
<%--                    修改后的响应地址--%>
                    <input type="hidden" name="url" value="/studentData?currentPage=${pageBean.currentPage}&rows=${rows}&major=${condition.major[0]}&grade=${condition.grade[0]}&className=${condition.className[0]}&sname=${condition.sname[0]}&sno=${condition.sno[0]}">
                    <input type="hidden" name="username" id="username">
                    <input type="hidden" name="school" value="${sessionScope.user.school}">
                    <div class="form-group">
                        <label for="username" class="control-label" style="float: left" disabled="">学号:</label>
                        <input type="text" class="form-control" id="username1" style="width: 300px; margin: 10px 50px; " disabled>
                    </div>
                    <div class="form-group">
                        <label for="sname" class="control-label" style="float: left">姓名:</label>
                        <input type="text" class="form-control" name="sname" id="sname" style="width: 300px; margin: 10px 50px;">
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label" style="float: left">密码:</label>
                        <input type="text" class="form-control" name="password" id="password" style="width: 300px; margin: 10px 50px;">
                    </div>
                    <div class="form-group">
                        <label for="major" class="control-label" style="float: left">专业: </label>
                        <select class="form-control major_class" id="major" name="major" style="width: 300px; margin: 10px 50px;">
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="classname" class="control-label" style="float: left">班级: </label>
                        <input type="text" class="form-control" name="classname" id="classname" style="width: 300px; margin: 10px 50px;">
                    </div>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="submit" class="btn btn-primary"> 提交更改</button>
            </div>

            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script type="text/javascript">
    // 修改功能模态框 文本框传值
    $("#myModal").on("show.bs.modal", function (e) {
        $("#username").val($(e.relatedTarget).data("username") )
        $("#username1").val($(e.relatedTarget).data("username") )
        $('#password').val($(e.relatedTarget).data("password"))
        $('#sname').val($(e.relatedTarget).data("sname"))
        $('#classname').val($(e.relatedTarget).data("classname"))
        // $('#major').text($(e.relatedTarget).data("major"))
        Major = $(e.relatedTarget).data("major")
    } )


    $(function () {
        // 去掉文本框所有拼写检查
        $("input[type='text'],textarea").attr('spellcheck',false);
        getMajors_query();
    })

    // 修改功能（专业）下拉菜单
    getMajors = function() {
        $.get(
        "${pageContext.request.contextPath}/SelectMajor",
            {school : "${sessionScope.user.school}"},
        function(data) {
            var html = "<option value='"+Major+"'>"+Major+"</option> ";
            $.each(data, function(i, major) { // 遍历json数组应该将data 放在里面
                if ( Major!= major.name )
                    html += "<option value='"+major.name+"'>"+major.name+"</option> ";
            })
            $('#major').html(html);
        },
        "json"
        )
    }

    // 查询功能（专业）下拉菜单
    getMajors_query = function() {
        $.get(
            "${pageContext.request.contextPath}/SelectMajor",
            {school : "${sessionScope.user.school}"},
            function(data) {
                if ( "${condition.major[0]}" != "" )
                    var html = "<option value='${condition.major[0]}'>${condition.major[0]}</option> ";
                else
                    var html = "<option value=''></option> ";
                $.each(data, function(i, major) { // 遍历json数组应该将data 放在里面
                    if ( "${condition.major[0]}"!= major.name )
                        html += "<option value='"+major.name+"'>"+major.name+"</option> ";
                })
                $('#major_query').html(html);
            },
            "json"
        )
    }

    // 查询功能（年级）下拉菜单
    getGrades_query = function() {
        $.get(
            "${pageContext.request.contextPath}/SelectGrade",
            {school : "${sessionScope.user.school}"},
            function (data) {

            },
            "json"
        )
    }
</script>


</body>
</html>
