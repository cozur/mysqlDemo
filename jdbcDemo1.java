import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class jdbcDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.����mysql����
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/myjava";
		String user = "root";//���ݿ��˺�
		String password = "";//���ݿ�����
		
		try {
//			Driver mysql = new Driver();
			
			String sql = "select * from student;";	
//			String sql = "insert student values(5,'zhang',123,27,'f');";
			Class.forName("com.mysql.jdbc.Driver");//ע������
			conn = DriverManager.getConnection(url,user,password);
			if(conn!=null)
				System.out.println("���ӳɹ���");
			else
				System.out.println("����ʧ�ܣ�");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
//			int result = stmt.executeUpdate(sql);
//			if(result>0)
//				System.out.println("���ִ�гɹ���");
//			else
//				System.out.println("���ִ��ʧ�ܣ�");

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
