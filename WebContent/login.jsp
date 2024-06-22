<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
    <!-- welcome.jspで入力した名前とパスワードはstrutsファイルの処理結果によってどちらかのファイルに表示される -->
        <s:property value="color_name"/>さん、ようこそ！！！
    </body>
</html>