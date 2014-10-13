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
	// 创建静态全局变量
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
		// insert(); //插入添加记录
		// update(); //更新记录数据
		// query();
		// delete("\'Gernet\'"); //删除记录
		// query(); //查询记录并显示
	}

	public static void searchBook(String isbn, List<book> list) {
		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		String result = new String();
		try {
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			String sql = "select * from Book where ISBN='" + isbn + "'";
			ResultSet rs = st.executeQuery(sql);
			book b;
			while (rs.next()) { // 判断是否还有下一个数据
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

			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void findBook(String title,List<book> list,author au){
		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		String result = new String();
		try {
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			String sql = "select * from Book where Title='" + title + "'";
			ResultSet rs = st.executeQuery(sql);
			book b;
			b = new book();
			if (rs.next()) { // 判断是否还有下一个数据
				
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
			if (rs.next()) { // 判断是否还有下一个数据
				au.id = rs.getInt("AuthorID");
				au.name=rs.getString("Name");
				au.age=rs.getString("Age");
				au.country=rs.getString("Country");
			}
			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void searchAuthor(String authorname, List<book> list,author au) {
		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		String result = new String();
		try {
			String sql = "select * from Author where Name='" + authorname + "'"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			ResultSet rs = st.executeQuery(sql);
			int id = 0;
			while (rs.next()) { // 判断是否还有下一个数据
				au.id = rs.getInt("AuthorID");
				au.name=rs.getString("Name");
				au.age=rs.getString("Age");
				au.country=rs.getString("Country");
			}
			id=au.id;
			sql = "select * from Book where AuthorID='" + id + "'";
			rs = st.executeQuery(sql);
			book b;
			while (rs.next()) { // 判断是否还有下一个数据
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

			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/* 查询数据库，输出符合要求的记录的情况 */
	public static void queryAll(List<author> list) {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		String result = new String();
		try {
			String sql = "select * from Author "; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			author man;
			while (rs.next()) { // 判断是否还有下一个数据
				man = new author();
				man.id = rs.getInt("AuthorID");
				man.name = rs.getString("Name");
				man.age = rs.getString("Age");
				man.country = rs.getString("Country");
				System.out.println(man.id + " " + man.name + " " + man.age
						+ " " + man.country);
				list.add(man);
			}
			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteBook(String isbn) {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		try {
			String sql = "delete from Book where ISBN='" + isbn + "'"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			st.execute(sql);
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String addBook(String authorname,String i, String t, String pd,
			String p, String pr,info s) {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		
		
		try {

			
			String sql = "select * from Book where ISBN='" + i + "'"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			ResultSet rs = st.executeQuery(sql);
			String tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp=new String();
				tmp = rs.getString("ISBN");
				if(tmp.equals(i)){
					return "isbn fail";
				}
			}
			
			
			
			sql = "select * from Author where Name='" + authorname + "'"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			rs = st.executeQuery(sql);
			int id = 0;
			while (rs.next()) { // 判断是否还有下一个数据
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
					+ "','" + pr + "')"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

			st.execute(sql);
			conn.close(); // 关闭数据库连接
			return "success";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			s.str=e.getMessage();
			return "fail";
		}
	}

	public static String editBook(String isbn, int authorid, String title, String publishdate,
			String publisher, String price) {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		try {
			String sql = "update Book set AuthorID='"+authorid+"',Title='"+title+"',PublishDate='"+publishdate+"',Publisher='"+publisher+"',Price='"+price+"' where ISBN='"+isbn+"'"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

			st.execute(sql);
			conn.close(); // 关闭数据库连接
			return "success";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public static String insert(int id, String name, String age,
			String country,info s) {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		System.out.println(country);
		try {
			
			String sql = "select * from Author where AuthorID='" + id + "'"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			ResultSet rs = st.executeQuery(sql);
			String tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				return "id fail";
			}
			
			
			
			
			
			sql = "insert into Author(AuthorID,Name,Age,Country) values('"
					+ id + "','" + name + "','" + age + "','" + country + "')"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

			st.execute(sql);
			conn.close(); // 关闭数据库连接
			return "success";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			s.str=e.getMessage();
			return "fail";
		}
	}

	/* 获取数据库连接的函数 */
	
	public static Connection getConnection() {
		Connection con = null; // 创建用于连接数据库的Connection对象
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

			con = DriverManager.getConnection(
					"jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_libraryofwd", "053lklk5no", "y2jxilxk45wm2lx20551wwhhm0yh534h1l43k0zj");// 创建数据连接
																			// "root"为用户名，123456为密码

		} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return con; // 返回所建立的数据库连接

	}
	
	
	public static Connection getConnectiona() {
		Connection con = null; // 创建用于连接数据库的Connection对象
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/BookDB", "root", "123456");// 创建数据连接
																			// "root"为用户名，123456为密码

		} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return con; // 返回所建立的数据库连接

	}
}
