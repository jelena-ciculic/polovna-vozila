package jwd.prodavnica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jwd.prodavnica.model.Motocikl;
import jwd.prodavnica.utility.Utility;

public class MotociklFile {
	
	public static ArrayList<Motocikl> sviMotocikli = new ArrayList<Motocikl>();
	
	
	public static void ispisSvihMotocikala(){
		
		for (Motocikl moto : sviMotocikli) {
			System.out.println(moto);
		}
	}
	
	public static void writeToFile(){
		try {
			
			String path = Utility.getRelativePath("motocikli.txt");
			File file = new File(path);
			
			if(!file.exists()){
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (Motocikl moto : sviMotocikli) {
				out.println(moto.toFile());
			}
			
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readFromFile(){
		
		try {
			
			sviMotocikli.clear();
			
			String path = Utility.getRelativePath("motocikli.txt");
			File file = new File(path);
			
			if(file.exists()){
				
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String line;
				
				while((line = in.readLine())!=null){
					
					Motocikl moto= new Motocikl(line);
					sviMotocikli.add(moto);
				}
				
				in.close();
				
			}else{
				System.out.println("Nije pronadjen fajl!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Motocikl pretragaPoSifri(String sifra){
		
		Motocikl retVal = null;
		
		for (Motocikl moto : sviMotocikli) {
			if(moto.getSifra().equals(sifra)){
				retVal = moto;
				break;
			}
		}
		
		return retVal;
	}
	
		

	
	public static List<Motocikl> pretragaPoKubikazi( int min, int max){
		
		List<Motocikl> retVal = new ArrayList<Motocikl>();
		
		for (Motocikl motocikl : sviMotocikli) {
			if(motocikl.getKubikaza()>=min && motocikl.getKubikaza() <=max){
				retVal.add(motocikl);
			}
		}
		
		return retVal;
	}

}
