package com.diworksdev.webprojtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.webprojtest.dto.LoginDTO;
import com.diworksdev.webprojtest.util.DBConnector;


public class LoginDAO {

	public String color_name;
	public String color_number;

	//①クラス、メソッドの定義
	//LoginDTO型を最後に呼び出し元に渡すので、LoginDTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る
	public LoginDTO select(String color_name,String color_number) {

		//②DBConnectorのインスタンス化
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		//Connectionは特定のデータベースとの接続
		DBConnector db = new DBConnector();

		//③getConnectionの呼び出し（DBと接続する）
		Connection con = db.getConnection();

		//LoginDTOのインスタンス化
		LoginDTO dto = new LoginDTO();

		//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため）
		//SELECT データを抽出する
		//＊ テーブルに含まれる項目全て
		//FROM 〇〇 〇〇という名前のテーブルからデータを選択する
		//WHERE ＜条件＞抽出条件を指定
		//usersに入っているデータuser_name=? password = ?に入る条件を満たしたデータがsqlに代入される
		String sql = "select * from color where color_name=? and color_number=?";

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			//定義したSQL文の1番目の?にActionから送られたname、
			//2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement ps = con.prepareStatement(sql);

			//⑥sql文の?に入れる値をsetする
			ps.setString(1, color_name);
			ps.setString(2, color_number);

			//⑦executeQuery()/executeUpdate()で実行
			//（select文の場合はexectuteQuery()を使う）
			// select文のSQL文を実行するメソッドで戻り値はResultSet
			ResultSet rs = ps.executeQuery();

			//ここでは2つのことをしている
			//下に1行ずらすこと
			//データが存在していれば戻り値を true で返す・存在しなければ falseで返す
			if (rs.next()) {

				//⑧結果の処理（select文で取得した値をDTOに格納）
				//select文でDBから取得した情報をString型に変換してDTOクラスに格納
				//LoginDTOクラスのsetName、setPassword（setter）を利用
				dto.setColor_name(rs.getString("color_name"));
				dto.setColor_number(rs.getString("color_number"));

			//falseの場合下記
			} else {

				//⑧結果の処理（select文で取得した値をDTOに格納）
				//select文でDBから取得した情報をString型に変換してDTOクラスに格納
				//LoginDTOクラスのsetName、setPassword（setter）を利用
				dto.setColor_name("該当なし");
				dto.setColor_number("該当なし");
			}

		//処理中にSQL関連のエラーが発生した際に実行する処理
		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//try.catchはjavaの例外処理のための構文
		try {

			//⑨con.close()で接続を切る
			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			con.close();

		//処理中にSQL関連のエラーが発生した際に実行する処理
		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch (SQLException e) {
			e.printStackTrace();

		}

		//dtoに入った値を呼び出し元であるActionクラスに渡す
		return dto;

	}

}
