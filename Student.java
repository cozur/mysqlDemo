//学生类
public class Student {
	private int id;//学生ID号
	private String user;//学生名字
	private String password;//密码
	private int age;//年龄
	private String gender;//性别
	
	Student()
	{
		
	}
	Student(int id,String user,String password,int age,String gender)
	{
		this.id = id;
		this.user = user;
		this.password = password;
		this.age =age;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
