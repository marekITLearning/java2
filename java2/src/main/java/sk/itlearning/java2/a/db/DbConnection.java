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

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql:java2","postgres", "sa");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from public.zakaznik")) {
			while (rs.next()) {
				Obcan o = new Obcan(rs.getString("id"), rs.getString("name"));
				o.setKredit(new BigDecimal(rs.getDouble("kredit")));
				System.out.println(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nepodarilo sa pripojit na databazu");
		}
	}

}
