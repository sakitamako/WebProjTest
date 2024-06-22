package com.diworksdev.webprojtest.action;

import com.diworksdev.webprojtest.dao.LoginDAO;
import com.diworksdev.webprojtest.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginColor extends ActionSupport {

	//フィールド変数
	//JSPから受け取る値、ここではnameとpassword を定義
	//※必ずJSPでの定義と同じ名前にする
	private String color_name;
	private String color_number;

	//メソッド名は「execute」
	//管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {

		//メソッドの戻り値「ret」 String ret = ERROR; を定義し、初期値としてERRORを代入
		String ret = ERROR;

		System.out.println(color_name);
		System.out.println(color_number);

		//②LoginDAOとLoginDTOのインスタンス化
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		//JSPから送られてきたnameとpasswordを引数として、
		//LoginDAOクラスのselectメソッドを呼び出す
		//その後、DAOで取得した結果をLoginDTOに代入する
		dto = dao.select(color_name, color_number);

		//aとbが共にtrueの時に処理を実行するそうでない場合はエラー
		if (this.color_name.equals(dto.getColor_name()) && this.color_number.equals(dto.getColor_number())) {

			ret = SUCCESS;

		} else {

			ret = ERROR;
		}

		//retに入った値を呼び出し元であるActionクラスに渡す
		return ret;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、usernameフィールドの値をActionに渡す
	public String getColor_name() {
		return color_name;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のDTO usernameフィールドに格納
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、passwordフィールドの値をActionに渡す
	public String getColor_number() {
		return color_number;
	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のDTO passwordフィールドに格納
	public void setColor_number(String color_number) {
		this.color_number = color_number;

	}

}