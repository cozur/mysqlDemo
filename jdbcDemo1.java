import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class jdbcDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.加载mysql驱动
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/myjava";
		String user = "root";//数据库账号
		String password = "";//数据库密码
		
		try {
//			Driver mysql = new Driver();
			
			String sql = "select * from student;";	
//			String sql = "insert student values(5,'zhang',123,27,'f');";
			Class.forName("com.mysql.jdbc.Driver");//注册驱动
			conn = DriverManager.getConnection(url,user,password);
			if(conn!=null)
				System.out.println("连接成功！");
			else
				System.out.println("连接失败！");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
//			int result = stmt.executeUpdate(sql);
//			if(result>0)
//				System.out.println("语句执行成功！");
//			else
//				System.out.println("语句执行失败！");

			while(rs.next())
			{
//				System.out.println(rs.getString(0));
				System.out.print(rs.getInt("id")+" ");
				System.out.print(rs.getString("name")+" ");
				System.out.print(rs.getString("password")+" ");
				System.out.print(rs.getInt("age")+" ");
				System.out.print(rs.getString("gender")+" ");
				System.out.println("");		
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
