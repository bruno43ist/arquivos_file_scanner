package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a .csv file path: ");//reading the source file .csv
		String strPath =  sc.nextLine();
		sc.close();
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			
			String line = br.readLine();//reading first line of source file
			String array[] = new String[3];//array to split each line
			List<Product> products = new ArrayList<>();//list of products
			
			while(line != null) {//reading every line of source file
				array = line.split(",");//spliting every line between the lines
				String name = array[0];
				double price = Double.parseDouble(array[1]);
				int quantity = Integer.parseInt(array[2]);
				Product e = new Product(name, price, quantity);//creating new instanceof product
				products.add(e);//adding new product to the list
				line = br.readLine();//reading next line
			}
			
			System.out.println("End reading!");
			
			File file = new File(strPath);
			String foulderPath = file.getParent();//getting the foulder of source file
			boolean created = new File(foulderPath + "/out").mkdir();//creating the "/out" directory
			foulderPath = foulderPath + "/out/out.csv";//creating the file "out.csv"
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(foulderPath))){//writing at output file
				for(Product product : products) {//running every element of the list
					bw.write(product.getName() + "," + String.format("%.2f", product.totalValue()));//writing name + totalvalue
					bw.newLine();//adding a new line
				}
				System.out.println("End writing!");
				
			} catch(FileNotFoundException e) {//handling exceptions
				System.out.println("File not found! " + e.getMessage());
			} catch(IOException e) {
				System.out.println("Error! " + e.getMessage());
			}
			
		} catch(FileNotFoundException e) {//handling exceptions
			System.out.println("File not found! " + e.getMessage());
		} catch(IOException e) {
			System.out.println("Error! " + e.getMessage());
		}
		
	}

}
