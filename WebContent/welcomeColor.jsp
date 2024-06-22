<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>WELCOME</title>
    </head>
    <body>
        色と番号を入力してください。
        <s:form action="LoginColor">
            <s:textfield name="color_name" label="色" />
            <s:password name="color_number" label="番号" />
            <s:submit value="送信"/>
        </s:form>
    </body>
</html>