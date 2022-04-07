package sk.itlearning.java2.a.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) {

		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = DriverManager.getConnection("jdbc:postgresql:java2", "postgres", "sa");
			s = c.createStatement();
			rs = s.executeQuery("select * from zakaznik");
			while (rs.next()) {
				String zakid = rs.getString("zakid");
				System.out.println(zakid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (s != null) {
					s.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Tu ma pokracovat");
	}

}
