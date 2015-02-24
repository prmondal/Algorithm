package com.learning.algorithm.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FIleReader {

	public static void main(String[] args) throws IOException {
		/*FileReader fs = null;
		
		try {
			fs = new FileReader("test.txt");
			
			BufferedReader br = new BufferedReader(fs);
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			fs.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			
			e.printStackTrace();
		}*/
		
		Scanner sc = new Scanner(new File("test.txt"));
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine().trim();
			
			System.out.println(line);
		}
	}

}
