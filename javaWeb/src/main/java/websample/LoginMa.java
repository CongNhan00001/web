package websample;

/**
 * Java入門 ログイン処理クラス.<br/>
 * 今回は親クラスとして使用.
 */
public class LoginMa {

	/**
	 * 指定されたIDとパスワードに紐づくユーザ情報を返却します.
	 * @param id	ID
	 * @param pass	パスワード
	 * @return ユーザ情報
	 */
	public LoginUB getUserData(String id, String pass) {
		
		LoginUB bean = new LoginUB();
		
		// 引数のIDとパスワードを判定
		if("adm".equals(id) && "password".equals(pass)) {
			
			// IDがweb01の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("nhan");
			// Beanに年齢を設定
			bean.setAge(17);
			
		} else if ("nhan".equals(id) && "password".equals(pass)) {
			
			// IDがweb02の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("CongNhan");
			// Beanに年齢を設定
			bean.setAge(10);
			
		} else {
			
			// IDが合致しない場合はnullを代入
			bean = null;
		}
		
		return bean;
	}
}