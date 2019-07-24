package application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		File[] folders = path.listFiles(File::isDirectory);//lista pastas
		
		for(File foulder : folders) {
			System.out.println(foulder);
		}
		
		System.out.println();
		
		File[] files = path.listFiles(File::isFile); //lista arquivos 
		for(File file : files) {
			System.out.println(file);
		}
		
		boolean success = new File(strPath + "/criadoEclipse").mkdir();
		System.out.println("Directory created! " + success);

		
		sc.close();
	}

}
