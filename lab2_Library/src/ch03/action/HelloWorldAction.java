package ch03.action;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {

	private String message;
	private int id;
	private String result;
	private String name;
	private String age;
	private String country;
	private info s;
	
	
	public void setS(info s){
		this.s=s;
	}
	public info getS(){
		return this.s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	
	
	
	public String getMessage() {
		return message;
	}

	public String execute() throws Exception {
		mysqltest sql = new mysqltest();
		if(sql.insert(id,name,age,country,s).equals("success")){
			message = "Add successfully!!";
			return SUCCESS;
		}
		else{
			message = "fail to insert!!";
			return ERROR;
		}
		
	}
}


