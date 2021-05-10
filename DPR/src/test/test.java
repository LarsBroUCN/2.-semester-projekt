package test;

import static org.junit.Assert.*;

import java.sql.DriverManager;
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
		ResultSet rs = s.executeQuery("select * from notifications where status = 'pending'");
		System.out.println(rs);
		while(rs.next()) {
		System.out.println("NotifikationsID: " + rs.getString(1) + " \n" + "Rabat: " + rs.getString(2) + 
							" \n" + "Note: " + rs.getString(3) + " \n" + "Status: " + rs.getString(4) + 
							" \n" + "BatchID: " + rs.getInt(5));
		
		
		}
				
		//lukkes kun 1 gang pr program
		s.close();
		con.close();
	}

}