package Test;

import java.sql.*;
import java.util.ArrayList;

public class connect {
	public static int addPatient(String name,int age,String email) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");  
		String dbName = "jdbc:mysql://patient1.cyanibet2pws.us-east-2.rds.amazonaws.com:3306/patient";
	    Connection con = DriverManager.getConnection(dbName,"Madhav","Madhav123");
	    String query="insert into `patient`(`name`,`age`,`email`) values(?,?,?)";
	    PreparedStatement st = con.prepareStatement(query);
	    st.setString(1,name);
	    st.setInt(2,age);
	    st.setString(3,email);
	    int count=st.executeUpdate();
	    st.close();
	    con.close();
	    return count;
	}
	public static ArrayList<String> getPatient() throws Exception{
		ArrayList<String> arr=new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver");  
		String dbName = "jdbc:mysql://patient1.cyanibet2pws.us-east-2.rds.amazonaws.com:3306/patient";
		Connection con = DriverManager.getConnection(dbName,"Madhav","Madhav123");
	    Statement st=con.createStatement();
	    ResultSet rs=st.executeQuery("Select * from patient");
	    while(rs.next())
        {
           String stu="{ \"id\" : "+rs.getInt(1)+ ",\"name\" : \""+rs.getString(2)+"\", \"age\" :"+rs.getInt(3)+", \"email\" :\""+rs.getString(4)+"\" }";
           arr.add(stu);
        }
		return arr;
	}
}
