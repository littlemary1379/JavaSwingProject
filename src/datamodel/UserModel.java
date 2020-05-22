package datamodel;

public class UserModel {
	public static String ID;
	static String pwd;
	static Integer age;
	static String username;
	static String email;
	static String tel;
	static String userclass;

	@SuppressWarnings("static-access")
	public void user(String ID, String pwd, int age, String name, String email, String tel, String userclass) {
		this.ID=ID;
		this.pwd=pwd;
		this.age=age;
		this.username=name;
		this.email=email;
		this.tel=tel;
		this.userclass=userclass;
		
	}

	public static String getID() {
		return ID;
	}

	public static void setID(String iD) {
		ID = iD;
	}

	public static String getPwd() {
		return pwd;
	}

	public static void setPwd(String pwd) {
		UserModel.pwd = pwd;
	}

	public static Integer getAge() {
		return age;
	}

	public static void setAge(Integer age) {
		UserModel.age = age;
	}

	public static String getName() {
		return username;
	}

	public static void setName(String name) {
		UserModel.username = name;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		UserModel.email = email;
	}

	public static String getTel() {
		return tel;
	}

	public static void setTel(String tel) {
		UserModel.tel = tel;
	}

	public static String getUserclass() {
		return userclass;
	}

	public static void setUserclass(String userclass) {
		UserModel.userclass = userclass;
	}
}
