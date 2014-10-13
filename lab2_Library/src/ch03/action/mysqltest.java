package ch03.action;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class mysqltest {
	// ������̬ȫ�ֱ���
	static Connection conn;

	static Statement st;

	private String driver = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "123456";

	public static void main(String[] args) {
		mysqltest sql = new mysqltest();
	}

	public mysqltest() {
		// query();
		// insert(); //������Ӽ�¼
		// update(); //���¼�¼����
		// query();
		// delete("\'Gernet\'"); //ɾ����¼
		// query(); //��ѯ��¼����ʾ
	}

	public static void searchBook(String isbn, List<book> list) {
		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		String result = new String();
		try {
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			String sql = "select * from Book where ISBN='" + isbn + "'";
			ResultSet rs = st.executeQuery(sql);
			book b;
			while (rs.next()) { // �ж��Ƿ�����һ������
				b = new book();
				b.authorID = rs.getInt("AuthorID");
				b.isbn = rs.getString("ISBN");
				b.title = rs.getString("Title");
				b.publishDate = rs.getString("PublishDate");
				b.publisher = rs.getString("Publisher");
				b.price = rs.getString("Price");
				// System.out.println(man.id+" "+man.name+" "+man.age+" "+man.country);
				list.add(b);
			}

			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void findBook(String title,List<book> list,author au){
		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		String result = new String();
		try {
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			String sql = "select * from Book where Title='" + title + "'";
			ResultSet rs = st.executeQuery(sql);
			book b;
			b = new book();
			if (rs.next()) { // �ж��Ƿ�����һ������
				
				b.authorID = rs.getInt("AuthorID");
				b.isbn = rs.getString("ISBN");
				b.title = rs.getString("Title");
				b.publishDate = rs.getString("PublishDate");
				b.publisher = rs.getString("Publisher");
				b.price = rs.getString("Price");
				// System.out.println(man.id+" "+man.name+" "+man.age+" "+man.country);
				list.add(b);
			}
			sql = "select * from Author where AuthorID='" + b.authorID + "'";
			rs = st.executeQuery(sql);
			if (rs.next()) { // �ж��Ƿ�����һ������
				au.id = rs.getInt("AuthorID");
				au.name=rs.getString("Name");
				au.age=rs.getString("Age");
				au.country=rs.getString("Country");
			}
			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchAuthor(String authorname, List<book> list,author au) {
		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		String result = new String();
		try {
			String sql = "select * from Author where Name='" + authorname + "'"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			ResultSet rs = st.executeQuery(sql);
			int id = 0;
			while (rs.next()) { // �ж��Ƿ�����һ������
				au.id = rs.getInt("AuthorID");
				au.name=rs.getString("Name");
				au.age=rs.getString("Age");
				au.country=rs.getString("Country");
			}
			id=au.id;
			sql = "select * from Book where AuthorID='" + id + "'";
			rs = st.executeQuery(sql);
			book b;
			while (rs.next()) { // �ж��Ƿ�����һ������
				b = new book();
				b.authorID = rs.getInt("AuthorID");
				b.isbn = rs.getString("ISBN");
				b.title = rs.getString("Title");
				b.publishDate = rs.getString("PublishDate");
				b.publisher = rs.getString("Publisher");
				b.price = rs.getString("Price");
				// System.out.println(man.id+" "+man.name+" "+man.age+" "+man.country);
				if(list!=null){
					list.add(b);
				}
				
			}

			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/* ��ѯ���ݿ⣬�������Ҫ��ļ�¼����� */
	public static void queryAll(List<author> list) {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		String result = new String();
		try {
			String sql = "select * from Author "; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			author man;
			while (rs.next()) { // �ж��Ƿ�����һ������
				man = new author();
				man.id = rs.getInt("AuthorID");
				man.name = rs.getString("Name");
				man.age = rs.getString("Age");
				man.country = rs.getString("Country");
				System.out.println(man.id + " " + man.name + " " + man.age
						+ " " + man.country);
				list.add(man);
			}
			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteBook(String isbn) {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "delete from Book where ISBN='" + isbn + "'"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			st.execute(sql);
			conn.close(); // �ر����ݿ�����
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String addBook(String authorname,String i, String t, String pd,
			String p, String pr,info s) {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		
		
		try {

			
			String sql = "select * from Book where ISBN='" + i + "'"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			ResultSet rs = st.executeQuery(sql);
			String tmp;
			while (rs.next()) { // �ж��Ƿ�����һ������
				tmp=new String();
				tmp = rs.getString("ISBN");
				if(tmp.equals(i)){
					return "isbn fail";
				}
			}
			
			
			
			sql = "select * from Author where Name='" + authorname + "'"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			rs = st.executeQuery(sql);
			int id = 0;
			while (rs.next()) { // �ж��Ƿ�����һ������
				id = rs.getInt("AuthorID");
			}
			if(id==0){
				return "fail";
			}
			if(String.valueOf(id).equals("")){
				return "fail";
			}
			
			
			
			
			
			sql = "insert into Book(ISBN,AuthorID,Title,PublishDate,Publisher,Price) values('"
					+ i
					+ "','"
					+ id
					+ "','"
					+ t
					+ "','"
					+ pd
					+ "','"
					+ p
					+ "','" + pr + "')"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

			st.execute(sql);
			conn.close(); // �ر����ݿ�����
			return "success";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			s.str=e.getMessage();
			return "fail";
		}
	}

	public static String editBook(String isbn, int authorid, String title, String publishdate,
			String publisher, String price) {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "update Book set AuthorID='"+authorid+"',Title='"+title+"',PublishDate='"+publishdate+"',Publisher='"+publisher+"',Price='"+price+"' where ISBN='"+isbn+"'"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

			st.execute(sql);
			conn.close(); // �ر����ݿ�����
			return "success";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public static String insert(int id, String name, String age,
			String country,info s) {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		System.out.println(country);
		try {
			
			String sql = "select * from Author where AuthorID='" + id + "'"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����
			ResultSet rs = st.executeQuery(sql);
			String tmp;
			while (rs.next()) { // �ж��Ƿ�����һ������
				return "id fail";
			}
			
			
			
			
			
			sql = "insert into Author(AuthorID,Name,Age,Country) values('"
					+ id + "','" + name + "','" + age + "','" + country + "')"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

			st.execute(sql);
			conn.close(); // �ر����ݿ�����
			return "success";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			s.str=e.getMessage();
			return "fail";
		}
	}

	/* ��ȡ���ݿ����ӵĺ��� */
	
	public static Connection getConnection() {
		Connection con = null; // ���������������ݿ��Connection����
		try {
			Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������

			con = DriverManager.getConnection(
					"jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_libraryofwd", "053lklk5no", "y2jxilxk45wm2lx20551wwhhm0yh534h1l43k0zj");// ������������
																			// "root"Ϊ�û�����123456Ϊ����

		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��" + e.getMessage());
		}
		return con; // ���������������ݿ�����

	}
	
	
	public static Connection getConnectiona() {
		Connection con = null; // ���������������ݿ��Connection����
		try {
			Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/BookDB", "root", "123456");// ������������
																			// "root"Ϊ�û�����123456Ϊ����

		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��" + e.getMessage());
		}
		return con; // ���������������ݿ�����

	}
}
