package jwd.prodavnica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import jwd.prodavnica.model.Kategorija;
import jwd.prodavnica.utility.Utility;

public class KategorijaFile {
	
	public static ArrayList<Kategorija> sveKategorije = new ArrayList<Kategorija>();
	
	
	public static void ispisSvihKategorija(){
		for (Kategorija kat : sveKategorije) {
			System.out.println(kat);
		}
	}
	
	public static void ispisSvihKategorija(boolean trueFalse){
		
		for (Kategorija kat : sveKategorije) {
			if(kat.isObrisano()==trueFalse){
				System.out.println(kat);
			}
		}
		
	}
	
	
	public static  void writeToFile(){
		
		try {
			
			String path = Utility.getRelativePath("kategorije.txt");
			File file = new File(path);
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (Kategorija kat : sveKategorije) {
				if(kat.getNadKategorija()==null){
					out.println(kat.getSifraKategorije()+"|"+kat.getNaziv()+
							"|"+kat.getOpis()+"|"+ null+ "|" + kat.isObrisano());
				}else{
					
					out.println(kat.getSifraKategorije()+"|"+kat.getNaziv()+
							"|"+kat.getOpis()+"|"+kat.getNadKategorija().getSifraKategorije()+ "|" + kat.isObrisano());
				}
			}
			
			out.flush();
			out.close();
		
			
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
		
	}
	
	

	
	public static void readFromFile(){
	
		try {
			
			sveKategorije.clear();
			
			String path = Utility.getRelativePath("kategorije.txt");
			File file = new File(path);
			
			if(file.exists()){
				BufferedReader in = new BufferedReader(new FileReader(file));
				
				String text;
				
				while((text=in.readLine())!=null){
					
					StringTokenizer st = new StringTokenizer(text, "|");
					while(st.hasMoreTokens()){
						String sifra = st.nextToken();
						String naziv = st.nextToken();
						String opis = st.nextToken();
						String sifraKategorije = st.nextToken();
						Kategorija nadKat = pretragaKategorijePoSifri(sifraKategorije);
						boolean obrisano  = Boolean.parseBoolean(st.nextToken());
						
						Kategorija kat = new Kategorija(sifra, naziv, opis, nadKat,obrisano);
						sveKategorije.add(kat);
					}
					
		
					
				}
				in.close();
			}else{
				System.out.println("Ne postoji fajl!");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}

		public static Kategorija pretragaKategorijePoSifri(String sifra){
			
			Kategorija retVal = null;
			for (Kategorija kat : sveKategorije) {
				if(kat.getSifraKategorije().equals(sifra)){
					retVal = kat;
					break;
				}
			}
			
			return retVal;
			
		
		}
		
		public static Kategorija pretragaKategorijePoSifri(String sifra, boolean trueFalse){
			
			Kategorija retVal = null;
			
			for (Kategorija kat : sveKategorije) {
				
				if(kat.getSifraKategorije().equals(sifra) && kat.isObrisano()==trueFalse){
					retVal  = kat;
					break;
				}
			}
			
			return retVal;
		}
		
		public static List<Kategorija> pretragaKategorijePoNazivu(String naziv){
			
			List<Kategorija> retVal = new ArrayList<Kategorija>();
			
			for (Kategorija kategorija : sveKategorije) {
				if(kategorija.getNaziv().contains(naziv)){
					retVal.add(kategorija);
				}
			}
			
			return retVal;
		}
			
		
		
		

}
