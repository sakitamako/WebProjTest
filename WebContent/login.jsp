<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        <title>LOGIN</title>
    </head>
    <body>
        <s:property value="LoginDTOList.get(0).color_name"/>さん、ようこそ！
        <br>
        <table>
            <tbody>
                <tr>
                    <th>ColorName</th>
                    <th>ColorNumber</th>
                </tr>
                <s:iterator value="loginDTOList">
                    <tr>
                        <td><s:property value="color_name"/></td>
                        <td><s:property value="color_number"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>