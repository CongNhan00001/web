package websample;

import java.io.Serializable;

public class LoginUserBean implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	private String id; 
	private String name;
	private int age;
	
	public LoginUserBean() {
		this.id="";
		this.name="";
		this.age=0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
