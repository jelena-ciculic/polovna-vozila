
package jwd.prodavnica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import jwd.prodavnica.model.Racun;
import jwd.prodavnica.utility.Utility;

public class RacunFile {
	
	public static ArrayList<Racun> sviRacuni = new ArrayList<Racun>();
	public static TreeSet<String> datumiProdaje = new TreeSet<String>();
	
	
	public static void ispisSvihRacunaBezStavki(){
		
		for (Racun rac : sviRacuni) {
			System.out.println(rac.toStringBezStavki());
		}
	}
	
	public static void ispisSvihRacuna(){
		for (Racun rac : sviRacuni) {
			System.out.println(rac.toStringBezStavki());
		}
	}
	
public static void ispisSvihDatuma(){
		
		for (String datum : datumiProdaje) {
			System.out.println(datum);
		}
	}
	
	public static void writeToFile(){
		
		try {
			
			String path = Utility.getRelativePath("racuni.txt");
			File file = new File(path);
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (Racun racun : sviRacuni) {
				out.println(racun.toFile());
			}
			
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readFromFile(){
		
		try {
			
			sviRacuni.clear();
			String path = Utility.getRelativePath("racuni.txt");
			File file = new File(path);
			
			if(file.exists()){
				
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String line;
				
				while((line=in.readLine())!=null){
					
					Racun racun = new Racun(line);
					sviRacuni.add(racun);
				}
				
				in.close();
				
			}else{
				System.out.println("Ne postoji fajl!");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
public static void writeToFileDatumi(){
		
		try {
			
			String path = Utility.getRelativePath("datumi.txt");
			File file = new File(path);
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (String datum : datumiProdaje) {
				out.println(datum);
			}
			
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readFromFileDatumi(){
		
		try {
			
			datumiProdaje.clear();
			
			String path = Utility.getRelativePath("datumi.txt");
			File file = new File(path);
			
			if(file.exists()){
				
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String line;
				
				while((line=in.readLine())!=null){
					
					datumiProdaje.add(line);
				}
				
				in.close();
				
			}else{
				System.out.println("Ne postoji fajl");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static Racun pretrgaRacunaPosifri(String sifra){
		
		Racun retVal = null;
		
		for (Racun rac : sviRacuni) {
			if(rac.getSifraRacuna().equals(sifra)){
				retVal = rac;
				break;
			}
		}
		
		return retVal;
	}
	
	public static Map<String, Double> ukupnaProdajaPoDanima(){
		
		readFromFileDatumi();
		
		Map<String, Double> retVal = new TreeMap<String, Double>();
		
		for (String datumS : datumiProdaje) {
				double ukupnaZarada = 0;
			for (Racun racun : sviRacuni) {
				if(Utility.konvertujDatumUString(racun.getDatumVreme()).startsWith(datumS)){
					ukupnaZarada+=racun.getUkupnaCena();
					
				}
			}
			
			retVal.put(datumS, ukupnaZarada);
			
		}
		
		return retVal;
		
	}
	
	public static List<Racun> pretragaRacunaPoDatumu(String datum){
		
		List<Racun> retVal = new ArrayList<Racun>();
		
		for (Racun racun : sviRacuni) {
			
			if(Utility.konvertujDatumUString(racun.getDatumVreme()).startsWith(datum)){
				
				retVal.add(racun);
			}
		}
		
		return retVal;		
		
	}
	

}
