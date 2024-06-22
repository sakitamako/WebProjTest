package com.diworksdev.webprojtest.action;

import com.diworksdev.webprojtest.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginColor extends ActionSupport {

	private String color_name;
	private String color_number;

	public String execute() {

		String color = ERROR;

		System.out.println(color_name);
		System.out.println(color_number);

		LoginDAO dao = new LoginDAO();

		if (this.color_name.equals(dto.getColor_name()) && this.color_number.equals(dto.getColor_number())) {

			color = SUCCESS;

		} else {

			color = ERROR;

		}

		//戻り値
		//retに入った値を呼び出し元であるActionクラスに渡す
		return color;

	}

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

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、passwordフィールドの値をActionに渡す
	public String getColor_number() {
		return color_number;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のpasswordフィールドに格納
	public void setColor_number(String color_number) {
		this.color_number = color_number;

	}

}

