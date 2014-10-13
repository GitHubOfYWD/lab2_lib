package ch03.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class searchauthorAction implements Action {
	public String authorname;
	public List<book> lst;
	public author au=new author();
	
	public void setAu(author au){
		this.au=au;
	}
	public author getAu(){
		return this.au;
	}
	
	
	
	public void setLst(List<book> lst){
		this.lst=lst;
	}
	public List<book> getLst(){
		return this.lst;
	}
	
	
	public void setAuthorname(String authorname){
		this.authorname=authorname;
	}
	public String getAuthorname(){
		return this.authorname;
	}
	
	
	public String execute() throws Exception {
		lst=new ArrayList<book>();
		mysqltest sql=new mysqltest();
		sql.searchAuthor(authorname,lst,au);
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}