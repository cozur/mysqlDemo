//ѧ����
public class Student {
	private int id;//ѧ��ID��
	private String user;//ѧ������
	private String password;//����
	private int age;//����
	private String gender;//�Ա�
	
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
