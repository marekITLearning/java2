package sk.itlearning.java2.d.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class WriteToFile {

	public static void main(String[] args) {
		File f = new File("C:/devel/test");

		if (!f.exists()) {
			f.mkdirs();
		}

		f = Paths.get(f.getPath(), "subor.txt").toFile();

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Nepodarilo sa vytovorit subor.");
			}
		}

		try (FileWriter fw = new FileWriter(f, true);) {
			for (int i = 0; i < 10; i++) {
				fw.append("Riadok " + i + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
