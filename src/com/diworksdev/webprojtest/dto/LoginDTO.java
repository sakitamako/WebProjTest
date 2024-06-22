package com.diworksdev.webprojtest.dto;

//DTOクラスは、DAOがDBから取得した値をActionへ戻す時、値を格納するのに利用されるファイル
public class LoginDTO {

	//テーブルから取得するデータに対応したフィールド変数を宣言
	private String color_name;
	private String color_number;

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、usernameフィールドの値をActionに渡す
	public String getColor_name() {
		return color_name;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のusernameフィールドに格納
	public void setColor_name(String color_name) {
		this.color_name = color_name;

	}

	//Actionクラスから呼び出され、passwordフィールドの値をActionに渡す
	public String getColor_number() {
		return color_number;

	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のpasswordフィールドに格納
	public void setColor_number(String color_number) {
		this.color_number = color_number;

	}

}

