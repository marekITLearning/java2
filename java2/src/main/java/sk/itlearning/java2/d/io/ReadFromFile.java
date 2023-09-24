package sk.itlearning.java2.d.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFromFile {

	public static void main(String[] args) {
		File f = new File("C:/devel/test/subor.txt");

		if (!f.exists()) {
			return;
		}

		// using try-with-resource to get automatic close of BufferedReader
		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			List<String> lines = Files.readAllLines(f.toPath());
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Files.lines");
		try {
			List<String> lines = Files.lines(f.toPath()).map(p -> p.toUpperCase()).collect(Collectors.toList());
			lines.forEach(r -> System.out.println(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Stream");
		try {
			Files.lines(f.toPath()).parallel().map(p -> p.toUpperCase()).forEach(l -> System.out.println(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Stream");
		try {
			Files.lines(f.toPath()).parallel().map(String::toUpperCase).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
