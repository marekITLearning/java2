package sk.itlearning.java2.d.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class MainJson {

	public static void main(String[] args) {
		Kniha[] zoznamKnih;
		try {
			zoznamKnih = new Gson().fromJson(new FileReader(new File("C:/devel/knihy.json")), Kniha[].class);
			
			for (Kniha k : zoznamKnih) {
				System.out.println(k.getAutor());
			}
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
