package ch03.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class BookManager implements Action {
	public String isbn = new String();
	public List<book> lst;
	public String message;
	public int authorid;
	public String title;
	public String pubdate;
	public String publisher;
	public String price;
	public String authorname;
	public String age;
	public String country;
	public author au=new author();
	private info s;
	public List<author> aulst;
	
	
	
	
	
	
	public void setLst(List<book> lst){
		this.lst=lst;
	}
	public List<book> getLst(){
		return this.lst;
	}
	public List<author>getAulst(){
		return aulst;
	}
	public void setAulst(List<author> aulst){
		this.aulst=aulst;
	}
	
	
	public void setS(info s){
		this.s=s;
	}
	public info getS(){
		return this.s;
	}

	public void setAu(author au){
		this.au=au;
	}
	public author getAu(){
		return this.au;
	}
	
	
	public int getAuthorid() {
		return this.authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorname() {
		return this.authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public String execute() throws Exception {
		/*
		 * mysqltest sql=new mysqltest(); System.out.println(isbn);
		 * sql.deleteBook(isbn); // TODO Auto-generated method stub
		 */
		return SUCCESS;
	}

	public String delBook() throws Exception {
		mysqltest sql = new mysqltest();
		System.out.println(isbn);
		sql.deleteBook(isbn);
		message = "Delete successfully!!!";
		// TODO Auto-generated method stub
		System.out.println(authorname);
		System.out.println(authorname);
		System.out.println(authorname);
		System.out.println(authorname);
		return "delete book";
	}

	public String showBook() throws Exception {
		lst = new ArrayList<book>();
		mysqltest sql = new mysqltest();
		sql.searchAuthor(authorname,null,au);
		sql.searchBook(isbn, lst);
		// TODO Auto-generated method stub
		return "search book";
	}
	public String findBook() throws Exception {
		lst = new ArrayList<book>();
		mysqltest sql = new mysqltest();
		sql.findBook(title,lst,au);
		// TODO Auto-generated method stub
		return "find book";
	}
	
	

	public String edit() {
		lst = new ArrayList<book>();
		mysqltest sql = new mysqltest();
		sql.searchBook(isbn, lst);
		return "edit";
	}

	public String editBook() throws Exception {
		mysqltest sql = new mysqltest();
		if (sql.editBook(isbn, authorid, title, pubdate, publisher, price)
				.equals("success")) {
			message = "Edit successfully!!";
		} else {
			message = "Fail to edit!!";
		}
		return "edit book";
	}

	public String addBook() throws Exception {
		mysqltest sql = new mysqltest();
		s=new info();
		String tmp=new String();
		tmp=sql.addBook(authorname, isbn, title, pubdate, publisher, price,s);
		if (tmp.equals("success")) {
			message = "Add successfully!!";
			return "add book success";
		} 
		else if (tmp.equals("isbn fail")){
			message = "This ISBN has already existed!!";
			return "isbn error";
		}
		else{
			message="The author doesn't locate in the database. Please add the author first!!";
			return "add book error";
		}
	}

	public String addAuthorAndBook() throws Exception {
		mysqltest sql = new mysqltest();
		if (sql.insert(authorid, authorname, age, country,s).equals("success")) {
			s=new info();
			if (sql.addBook(authorname, isbn, title, pubdate, publisher, price,null)
					.equals("success")) {
				message = "Add successfully!!";
				return "add book success";
			} else {
				message = "The AuthorID has already existed!!";
				return "add book error";
			}
		}
		else{
			message = "The AuthorID has already existed!!";
			return "add book error";
		}
	}
	public String searchAuthor() throws Exception {
		lst=new ArrayList<book>();
		mysqltest sql=new mysqltest();
		sql.searchAuthor(authorname,lst,au);
		// TODO Auto-generated method stub
		return "search author";
	}
	
	
	public String addAuthor() throws Exception {
		mysqltest sql = new mysqltest();
		s=new info();
		if(sql.insert(authorid,authorname,age,country,s).equals("success")){
			message = "Add successfully!!";
			return "add author success";
		}
		else{
			message = "The AuthorID has already existed!!";
			return "add author error";
		}
		
		
	}
	
	public String showAll() throws Exception {
		mysqltest sql=new mysqltest();
		aulst=new ArrayList<author>();
		System.out.println("no problem here");
		sql.queryAll(aulst);
		System.out.println("no problem here");
		// TODO Auto-generated method stub
		return "show all";
	}

}

class author{
	public int id= 0;
	public String name=new String();
	public String age=new String();
	public String country=new String();
}

class book{
	public String isbn;
	public String title;
	public int authorID;
	public String publisher;
	public String publishDate;
	public String price;
}
class info{
	public String str=new String();
}
/*Book Manager.java has been modified by me here*/
