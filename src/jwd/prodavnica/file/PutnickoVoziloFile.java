package jwd.prodavnica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jwd.prodavnica.model.PutinckoVozilo;
import jwd.prodavnica.utility.Utility;




public class PutnickoVoziloFile {
	
	public static ArrayList<PutinckoVozilo> putnickaVozila=new ArrayList<PutinckoVozilo>();
	
	
	public static void ispisSvihVozila(){
		for (PutinckoVozilo pv : putnickaVozila) {
			System.out.println(pv);
		}
		
	}
	
	public static void writeToFile(){
		try {
			
			String path = Utility.getRelativePath("putnickaVozila.txt");
			File file = new File(path);
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (PutinckoVozilo	pv:putnickaVozila) {
				out.println(pv.toFile());
			}
			
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readFromFile(){
		
		try {
			putnickaVozila.clear(); 
			String path = Utility.getRelativePath("putnickaVozila.txt");
			File file = new File(path);
			
			if(file.exists()){
				
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String line;
				
				while((line = in.readLine())!=null){
					
					PutinckoVozilo pv = new PutinckoVozilo(line);
					putnickaVozila.add(pv);
				}
				
				in.close();
				
			}else{
				System.out.println("Ne postoji fajl!");
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static PutinckoVozilo pretragaPoSifriVozila(String sifra){
		
		PutinckoVozilo retVal = null;
		
		for (PutinckoVozilo pv : putnickaVozila) {
			if(pv.getSifra().equals(sifra)){
				retVal  = pv;
				break;
			}
		}
		
		return retVal;
		
	}
	
	public static List<PutinckoVozilo> pretragaPoKubikaziMotora( int min, int max){
		
		List<PutinckoVozilo>retVal = new ArrayList<PutinckoVozilo>();
		for (PutinckoVozilo putinckoVozilo : putnickaVozila) {
			if(putinckoVozilo.getKubikaza()>= min && putinckoVozilo.getKubikaza()<=max){
				retVal.add(putinckoVozilo);
			}
		}
		
		return retVal;
		
	}
	
	public static List<PutinckoVozilo> pretragaPoTipuGoriva(String tipGoriva){
		
		List<PutinckoVozilo> retVal = new ArrayList<PutinckoVozilo>();
		for (PutinckoVozilo putinckoVozilo : putnickaVozila) {
			if(putinckoVozilo.getTipGoriva().equalsIgnoreCase(tipGoriva)){
				retVal.add(putinckoVozilo);
			}
		}
		
		return retVal;
		
	}
	
	public static List<PutinckoVozilo> pretragaPoBrojuVrata(int brVrata){
		List<PutinckoVozilo> retVal = new ArrayList<PutinckoVozilo>();
		for (PutinckoVozilo putinckoVozilo : putnickaVozila) {
			if(putinckoVozilo.getBrojVrata()==brVrata){
				retVal.add(putinckoVozilo);
			}
		}
		
		return retVal;
		
	}

}
