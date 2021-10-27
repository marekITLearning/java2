package sk.itlearning.java2.d.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToFile {

	public static void main(String[] args) {
		File f = new File("C:/devel/subor.txt");

		File tmp = new File("C:/devel/subor1.txt");

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}

		if (!tmp.exists()) {
			try {
				tmp.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}

		try (InputStream in = new BufferedInputStream(new FileInputStream(f));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(tmp))) {
			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		f.setReadOnly();

		try (FileWriter fw = new FileWriter(tmp, true);) {
			fw.write("Nejaky text\n");
			f.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Files.move(tmp.toPath(), Paths.get("C:/devel/subor.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
