package com.learning.algorithm.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		
		/*Scanner sc = new Scanner(new File("test.txt"));
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine().trim();
			
			System.out.println(line);
		}*/
		
		File f = new File("test.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
		
		bw.write("Hello Prasdlklskdssenjit");
		
		bw.close();
	}

}
