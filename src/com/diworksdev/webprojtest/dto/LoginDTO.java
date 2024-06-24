package com.diworksdev.webprojtest.dto;

//DTOクラスは、DAOがDBから取得した値をActionへ戻す時、値を格納するのに利用されるファイル
public class LoginDTO {

	//テーブルから取得するデータに対応したフィールド変数を宣言
	//このクラス・変数・変数名
	private String color_name;
	private String color_number;

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、nameフィールドの値をActionに渡す
	//get は値を取得、set は登録
	public String getColor_name() {
		return color_name;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のDTO nameフィールドに格納
	public void setColor_name(String color_name) {
		this.color_name = color_name;

	}

	//Actionクラスから呼び出され、numberフィールドの値をActionに渡す
	public String getColor_number() {
		return color_number;

	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のDTO numberフィールドに格納
	public void setColor_number(String color_number) {
		this.color_number = color_number;

	}

}

