package jwd.prodavnica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jwd.prodavnica.model.Bicikl;
import jwd.prodavnica.utility.Utility;

public class BiciklFile {
	
	public static ArrayList<Bicikl> sviBicikli = new ArrayList<Bicikl>();
	
	
	public static void ispisSvihBiciklova(){
		
		for (Bicikl bicikl : sviBicikli) {
			System.out.println(bicikl);
		}
	}
	
	public static void writeToFile(){
		
		try {
			
			String path= Utility.getRelativePath("bicikli.txt");
			File file =new File(path);
			
			
			if(!file.exists()){
				
				file.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (Bicikl bicikl : sviBicikli) {
				
				out.println(bicikl.toFile());
			}
			
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readFromFile(){
		
		
		try {
			
			sviBicikli.clear();
			
			String path= Utility.getRelativePath("bicikli.txt");
			File file =new File(path);
			
			if(file.exists()){
				
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String line;
				
				while((line = in.readLine())!=null){
					
					Bicikl b = new Bicikl(line);
					sviBicikli.add(b);
				}
				
				in.close();
				
			}else{
				System.out.println("Ne postoji fajl!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Bicikl pretragaBicikalaPoSifri(String sifra){
		
		Bicikl retVal = null;
		
		for (Bicikl bicikl : sviBicikli) {
			
			if(bicikl.getSifra().equals(sifra)){
				retVal   = bicikl;
				break;
			}
		}
		
		return retVal;
	}
	
	public static Bicikl pretragaBicikalaPoSifri(String sifra, boolean trueFalase){
		
		Bicikl retVal = null;
		for (Bicikl bicikl : sviBicikli) {
			if(bicikl.getSifra().equals(sifra) && bicikl.isStanje()==trueFalase){
				retVal=bicikl;
				break;
			}
		}
		
		return retVal;
	}
	
	
	public static List<Bicikl> pretragaPoBrojuBrzina(int min, int max){
		
		List<Bicikl> retVal = new ArrayList<Bicikl>();
		
		for (Bicikl bicikl : sviBicikli) {
			if(bicikl.getBrojBrzina() >= min && bicikl.getBrojBrzina()<= max){
				retVal.add(bicikl);
			}
		}
		
		return retVal;
	}

}
