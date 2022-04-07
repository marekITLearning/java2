package sk.itlearning.java2.d.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		File f = new File("C:/devel/subor.txt");
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try (FileWriter fw = new FileWriter(f, true);) {
			fw.append("Riadok 1\n");
			fw.append("Riadok 2\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
