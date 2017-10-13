<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <%--此处是应用禁止缓存--%>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <meta name="description" content="我的工具套装">
    <meta name="Keywords" content="mykits 工具 套装">

    <base href="<%=request.getContextPath()%>/">
    <title>我的组件库</title>

    <link rel="stylesheet" href="/css/common.css"/>
    <link rel="stylesheet" href="/css/main.css"/>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/html5.js"></script>
</head>
<body>
<div class="content content-wrapper">
    <%--页头--%>
    <tiles:insertAttribute name="layout-header"></tiles:insertAttribute>
    <%--中间左侧--%>
    <%--<tiles:insertAttribute name="layout-sidebar"></tiles:insertAttribute>--%>
    <%--中间部分动态变化的内容--%>
    <tiles:insertAttribute name="layout-content"></tiles:insertAttribute>
    <%--页脚--%>
    <tiles:insertAttribute name="layout-footer"></tiles:insertAttribute>
</div>
</body>
</html>