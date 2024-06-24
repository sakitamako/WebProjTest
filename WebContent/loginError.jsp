<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        <title>LoginError</title>
    </head>
    <body>
        <!-- welcome.jspファイルの送信ボタン押した次の画面がこれ、下記が表示される、エラーだった時該当なしと -->
        <!-- strutsファイルにアクションして処理結果を表示する -->
        <h1>エラーが発生しました</h1>
        <br>
        <h3>ログインできません。</h3>

        <s:if test='(loginDTOList.get(0).color_name)=="該当なし"'>
            該当しませんでした。
        </s:if>
        <br>
        <table>
            <tbody>
                <tr>
                    <th>Color_Name</th>
                    <th>Color_number</th>
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