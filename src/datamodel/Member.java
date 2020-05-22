package datamodel;

import lombok.Data;
@Data
public class Member {
	private String userid;
	private String pwd;
	private String age;
	private String name;
	private String email;
	private String tel;

	
	public Member() {
	
	}
	
	public Member(String userid, String pwd, String age, String name, String email, String tel) {	
		this.userid = userid;
		this.pwd = pwd;
		this.age = age;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}


	
	

}