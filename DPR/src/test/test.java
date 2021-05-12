package test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import org.junit.Test;

import db.DBConnection;

public class test {

	@Test
	public void test() {
	
	}
	
	public static void main(String[] args) throws Exception {
		
		
		//opretter forbindelsen (køres kun 1 gang pr program)
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DBConnection.getInstance().getConnection();
		System.out.println("success");
		
		
		Statement s = con.createStatement();
		//ResultSet rs = s.executeQuery("select * from notifications where status = 'pending'");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ResultSet rs = s.executeQuery("select notifications.batchid_fk, notifications.status from notifications\r\n"
				+ " inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = 'discount'");
		
		System.out.println(rs);
		while(rs.next()) {
//		System.out.println("NotifikationsID: " + rs.getString(1) + " \n" + "Rabat: " + rs.getString(2) + 
//							" \n" + "Note: " + rs.getString(3) + " \n" + "Status: " + rs.getString(4) + 
//							" \n" + "BatchID: " + rs.getInt(5));
//		
		System.out.println("BatchID: " + rs.getString(1) + " \n" + "Status: " + rs.getString(2));
		
		}
				
		//lukkes kun 1 gang pr program
		s.close();
		con.close();
	}

}