package sk.itlearning.java2.a.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sk.itlearning.java1.h.zakaznik.Obcan;

public class DbConnection {

	public static void main(String[] args) {

		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql:java","postgres", "sa");
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from public.\"Zakaznik\"");
			while (rs.next()) {
				Obcan o = new Obcan(rs.getString("id"), rs.getString("name"));
				o.setKredit(new BigDecimal(rs.getDouble("kredit")));
				System.out.println(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nepodarilo sa pripojit na databazu");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

				}
			}
		}

	}

}
