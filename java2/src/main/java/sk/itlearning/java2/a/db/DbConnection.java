package sk.itlearning.java2.a.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql:zakaznik","postgres", "sa");
			Statement stmt = connection.createStatement();
			ResultSet rs2 = stmt.executeQuery("select * from public.zakaznik")) {
			while (rs2.next()) {
				String rodneCislo = rs2.getString("zakid");
				String meno = rs2.getString("name");
				BigDecimal kredit = BigDecimal.valueOf(rs2.getDouble("kredit"));
				Obcan o = new Obcan(rodneCislo, meno);
				o.setKredit(kredit);
				System.out.println(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nepodarilo sa pripojit ku databaze");
		}

	}

}
