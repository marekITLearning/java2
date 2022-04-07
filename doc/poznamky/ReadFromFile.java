package sk.itlearning.java2.d.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class ReadFromFile {

	String text;

	public static void main(String[] args) {
		File f = new File("C:\\devel\\subor.txt");

		if (!f.exists()) {
			return;
		}

//		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
//			String riadok;
//			while ((riadok = br.readLine()) != null) {
//				System.out.println(riadok);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		try {
			List<String> riadky2 = Files.readAllLines(Path.of("C:/devel/subor.txt"));
			riadky2.forEach(System.out::println);
			System.out.println("Pocet riadkov = " + riadky2.size());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Files.copy(Path.of("C:/devel/subor.txt"), Path.of("C:/devel/subor2.txt"),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Files.lines(Path.of("C:/devel/subor.txt")).filter(s -> !s.contains("3")).map(s -> s.toUpperCase())
					.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
