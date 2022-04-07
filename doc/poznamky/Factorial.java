package sk.itlearning.java2.e.override;

import java.io.File;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(faktorial(3));

		MutableNumber pocet = new MutableNumber();

		spocitajSubory(new File("C:/devel"), pocet);

		System.err.println(pocet.value);
	}

	static public long faktorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * faktorial(n - 1);
		}
	}

	static void spocitajSubory(File f, MutableNumber pocet) {
		if (f.isDirectory()) {
			File[] filesInDir = f.listFiles();
			if (filesInDir != null) {
				for (File inner : filesInDir) {
					spocitajSubory(inner, pocet);
				}
			}
		} else {
			pocet.value++;
		}
	}

	private static class MutableNumber {
		long value;
	}

}
