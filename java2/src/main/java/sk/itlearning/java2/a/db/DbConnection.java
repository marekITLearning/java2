package sk.itlearning.java2.a.db;

import java.math.BigDecimal;
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
			c = DriverManager.getConnection("jdbc:postgresql:java", "postgres", "sa");
			s = c.createStatement();
			rs = s.executeQuery("select * from zakaznik");
			while (rs.next()) {
				Obcan o = new Obcan(rs.getString("zakid"), rs.getString("name"));
				o.setKredit(rs.getBigDecimal("kredit"));
				System.out.println(o);
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

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql:zakaznik","postgres", "sa");
			Statement stmt = connection.createStatement();
			ResultSet rs2 = stmt.executeQuery("select * from public.zakaznik")) {
			while (rs2.next()) {
				Obcan o = new Obcan("11", rs2.getString("name"));
				o.setKredit(new BigDecimal(rs2.getDouble("kredit")));
				System.out.println(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nepodarilo sa pripojit na databazu");
		}

	}

}
