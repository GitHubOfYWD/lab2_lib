package ch03.action;

import java.util.ArrayList;

import java.util.List;

import com.opensymphony.xwork2.Action;

public class showallAction implements Action {
	public List<author> lst;
	public List<author>getLst(){
		return lst;
	}
	public void setLst(List<author> lst){
		this.lst=lst;
	}
	
	
	
	public String execute() throws Exception {
		mysqltest sql=new mysqltest();
		lst=new ArrayList<author>();
		System.out.println("no problem here");
		sql.queryAll(lst);
		this.setLst(lst);
		System.out.println("no problem here");
		// TODO Auto-generated method stub
		return "success";
	}

}