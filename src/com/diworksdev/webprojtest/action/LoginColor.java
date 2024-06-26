package com.diworksdev.webprojtest.action;

import java.util.List;

import com.diworksdev.webprojtest.dao.LoginDAO;
import com.diworksdev.webprojtest.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginColor extends ActionSupport {

	//フィールド変数
	//JSPから受け取る値、ここではnameとpassword を定義
	//※必ずJSPでの定義と同じ名前にする
	private String color_name;
	private String color_number;

	//List： 複数の要素の順番を保持する。配列という入れ物の中に入れることができる要素の数、要素の数は，ゼロを含む正の整数、配列の中に格納された値
	//インデックスを利用して要素にアクセスするため、配列の代わりとして利用することができます。
	//配列の場合、宣言時に必要な個数を指定する必要がありましたが、List では後から要素数を変更出来るのが特徴です。
	//このクラス・変数・変数名＝インスタンス化（コピーしたものを代入）
	private List<LoginDTO> LoginDTOList;
//	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();

	//メソッド名は「execute」
	//管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {

		//メソッドの戻り値「ret」 String ret = ERROR; を定義し、初期値としてERRORを代入
		String ret = ERROR;

		//出力、表示
		System.out.println(color_name);
		System.out.println(color_number);

		//②インスタンス化
		//DAOと会話するためのコード
		LoginDAO dao = new LoginDAO();

		//JSPから送られてきたnameとnumberを引数として、
		//LoginDAOクラスのselectメソッドを呼び出す、31行目
		//select文でデータベースからデータを引き出してLoginDTOListに代入している
		LoginDTOList = dao.select(color_name, color_number);

		//aとbが共にtrueの時に処理を実行するそうでない場合はエラー
		//this.とはこのクラスのインスタンスのフィールド(変数)であることを表す。
		//何かのインスタンス同士が「同じ」かを調べるメソッド=equals、イコールズ？
		//ユーザーが入力した（color_name）と(color_number)が、DTOからもってきた値（dto.getColor_name()）と(dto.getColor_number())とともにtrueの場合SUCCESS。
		if (this.color_name.equals(LoginDTOList.get(0).getColor_name()) && this.color_number.equals(LoginDTOList.get(0).getColor_number())) {

			ret = SUCCESS;

		} else {

			ret = ERROR;

		}

		//if文の処理結果
		//retに入った値を呼び出し元であるActionクラスに渡す
		return ret;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//get は値を取得、set は登録
	//この記述コメントアウトして下記のsetColor_nameだけでもエラー表示なく実行できた
	public String getColor_name() {
		return color_name;

	}

	//JSPでユーザーが入力したnameとnumberの値がそれぞれ格納される
	//次画面に値を引き渡すサイトの場合、getter必要です。後々の不具合を防ぐため.
	//getterとsetterは両方書くようにする
	//この記述ないとエラー出る、jspファイルからこのクラスに送られてきたcolor_nameをセットして表示しているため
	public void setColor_name(String color_name) {
		this.color_name = color_name;

	}

	public String getColor_number() {
		return color_number;

	}

	public void setColor_number(String color_number) {
		this.color_number = color_number;

	}

	//上記のgetColor_nameと同じようにコメントアウトしてみたらエラーは出ないけどnameやnumberの表示が空になった
	//サーバーから送られてきたデータが保持されているので全てのクラスのLoginDTOListに格納された値を持ってきているから必要な記述
	public List<LoginDTO> getLoginDTOList() {
		return LoginDTOList;

	}

	//login.jspファイルで表示するためにsetしなければならないため必要な記述
	public void setLoginDTOList(List<LoginDTO> loginDTOList) {
		LoginDTOList = loginDTOList;

	}

}
