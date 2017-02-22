import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo2 {
	
	static final String url = "jdbc:mysql://localhost:3306/school";//数据库连接地址
	static final String user = "root";//数据库账号
	static final String password = "";//数据库密码
	
	static Connection conn = null;//建立数据库的连接
	static Statement stmt = null;//建立statement对象，用来执行SQL语句
	static ResultSet rs = null;//查询结果集
	
	jdbcDemo2()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");//注册驱动
			conn =DriverManager.getConnection(url, user, password);//2.建立连接	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询语句方法
	public void query()
	{
		//select * from student;
		StringBuffer sql = new StringBuffer("select * from student;");
		try
		{
			stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql.toString());
			while(rs.next())
				{
				   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				}
			System.out.println("查询成功！");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
//			destroyResource();
		}
		
	}
	
	//查询语句方法
		public void query(int item,Object content)
		{
			//select * from student where 'item' = 'content';
			StringBuffer sql = new StringBuffer("select * from student where ");
			
			switch(item)
			{
			case 1:
				sql.append("id")
				.append("= ")
				.append(content)
				.append(";");
				break;
			case 2:
				sql.append("user")
				.append("= '")
				.append(content)
				.append("';");
				break;
			case 3:
				sql.append("password")
				.append("= '")
				.append(content)
				.append("';");
				break;
			case 4:
				sql.append("age")
				.append("= ")
				.append(content)
				.append(";");
				break;
			case 5:
				sql.append("gender")
				.append("= '")
				.append(content)
				.append("';");
				break;
			default:
				sql.delete(22, 28);
				sql.append(";");
				System.out.println("没有找到符合的对象!");
			
			}
			try
			{
				stmt = conn.createStatement();
				 rs = stmt.executeQuery(sql.toString());
				while(rs.next())
					{
					   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
					}
				System.out.println("查询成功！");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				
//				destroyResource();
			}
			
		}
	//插入语句方法
	public void insert(Student stu)
	{
		//insert into student value (id,user,password,age,gender);
		StringBuffer sql = new StringBuffer("insert into student values (");
		sql.append(stu.getId())
		.append(",'")
		.append(stu.getUser())
		.append("','")
		.append(stu.getPassword())
		.append("',")
		.append(stu.getAge())
		.append(",'")
		.append(stu.getGender())
		.append("');");
		try
		{
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql.toString());
			if(r!=0)
				System.out.println("添加成功！");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
//			destroyResource();
		}
	}
	

	//删除语句方法
	public void delete(int item,Object content)
	{
		//delete from student where 'item' = 'content';
		StringBuffer sql = new StringBuffer("delete from student where ");
		
		switch(item)
		{
		case 1:
			sql.append("id")
			.append("= ")
			.append(content)
			.append(";");
			break;
		case 2:
			sql.append("user")
			.append("= '")
			.append(content)
			.append("';");
			break;
		case 3:
			sql.append("password")
			.append("= '")
			.append(content)
			.append("';");
			break;
		case 4:
			sql.append("age")
			.append("= ")
			.append(content)
			.append(";");
			break;
		case 5:
			sql.append("gender")
			.append("= '")
			.append(content)
			.append("';");
			break;
		default:
			sql.delete(20, 26);
			sql.append(";");
		
		}
		try
		{
			stmt = conn.createStatement();
			 int rs = stmt.executeUpdate(sql.toString());
			 if(rs!=0)
				 System.out.println("删除成功！");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
//			destroyResource();
		}
	}
	
	//释放资源
	public void destroyResource()
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
				rs=null;
			}
			if(stmt!=null)
			{
				stmt.close();
				stmt=null;
			}
			if(conn!=null)
			{
				conn.close();
				conn=null;
			}
			System.out.println("资源已释放！");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		Student stu1 = new Student(1,"zhangsan","123123",26,"m");
		Student stu2 = new Student(2,"lisi","333123",25,"f");
		jdbcDemo2 ob = new jdbcDemo2();
//		ob.insert(stu1);
//		ob.insert(stu2);
		ob.query();
//		ob.query(2,"lisi");
//		ob.delete(1,1);
//		ob.delete(2,"lisi");
		ob.destroyResource();

	}

}
