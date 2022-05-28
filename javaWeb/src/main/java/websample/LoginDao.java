package websample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java入門 ログインDAOクラス.
 */
public class LoginDao {

	private Connection con = null;
	private ResultSet  rs  = null;
	private PreparedStatement ps = null;
	int r;
	
	/**
	 * データベースから指定されたIDとパスワードを使ってユーザ情報を検索します.
	 * @param id	ログインID
	 * @param pass	パスワード
	 * @return	ユーザ情報（ResultSet）
	 * @throws SQLException
	 */
	public ResultSet selectUser(String id, String pass) throws SQLException {
	
		try {
			
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			// データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", 
											  "root",
											  "TruongThiSen080201");
			// SQL文を生成
			ps = con.prepareStatement("select name, age from user where id = ? and pass = ?");
			
			// 生成したSQL文の「？」の部分にIDとパスワードをセット
			ps.setString(1, id);
			ps.setString(2, pass);
			
			// SQLを実行
			rs = ps.executeQuery();
			
		} catch(ClassNotFoundException ce) {
			
			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
		
		return rs;
	}
	public void updateUser(String id,String pass,String name, int age) throws SQLException {
		
		try {
			
			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			// データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", 
											  "root",
											  "TruongThiSen080201");
			
			// SQL文を生成
			ps = con.prepareStatement("insert into user (id, pass,name,age) values (?, ?, ?,?)");
			// SQL文に数量を設定
			ps.setString(1, id);
			// SQL文に商品IDを設定
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setInt(4, age);
			// SQLを実行
			
			
			r=ps.executeUpdate();
			
		} catch(ClassNotFoundException ce) {
			
			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
	}
	/**
	 * コネクションをクローズします.
	 */
	public void close() {
		
		try {
			
			// データベースとの接続を解除する
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
			
		} catch (SQLException se) {
			
			// データベースとの接続解除に失敗した場合
			se.printStackTrace();
		}
	}
}