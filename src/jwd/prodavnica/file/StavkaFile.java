package jwd.prodavnica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jwd.prodavnica.model.Stavka;
import jwd.prodavnica.utility.Utility;

public class StavkaFile {
	
	public static ArrayList<Stavka> sveStavke = new ArrayList<Stavka>();
	
	
	public static void ispisSvihStavki(){
		for (Stavka stavka : sveStavke) {
			System.out.println(stavka);
		}
	}
	
	
	public static void writeToFile(){
		try {
			
			String path = Utility.getRelativePath("stavke.txt");
			File file = new File(path);
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (Stavka stavka : sveStavke) {
				out.println(stavka.toFile());
			}
			
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void readFromFile(){
		
		try {
			
			sveStavke.clear();
			String path = Utility.getRelativePath("stavke.txt");
			File file = new File(path);
			
			if(file.exists()){
				
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String line;
				
				while((line=in.readLine())!=null){
					
					Stavka stavka = new Stavka(line);
					sveStavke.add(stavka);
				}
				
				in .close();
					
			}else{
				
				System.out.println("Ne postoji fajl!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Stavka pronadjiStavku(String sifraRacuna, int sifraStavke){
		
		Stavka retVal = null;
		
		for (Stavka stavka : sveStavke) {
			if(stavka.getRacun().getSifraRacuna().equalsIgnoreCase(sifraRacuna) && stavka.getSifraStavke()==sifraStavke){
				retVal = stavka;
				break;
			}
		}
		
		return retVal;
	}
	
	public List<Stavka> pronadjiSveStavkeRacuna(String sifraRacuna){
		
		List<Stavka> retVal = new ArrayList<Stavka>();
		
		for (Stavka stavka : sveStavke) {
			if(stavka.getRacun().getSifraRacuna().equals(sifraRacuna)){
				retVal.add(stavka);
			}
		}
		
		return retVal;
	}

}
