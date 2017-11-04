package jwd.prodavnica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import jwd.prodavnica.model.Korisnik;
import jwd.prodavnica.utility.Utility;


public class KorisnikFile {
	
	public static ArrayList<Korisnik> sviKorisnici = new ArrayList<Korisnik>();
	
	public static void writeTofile(){
		
		String path = Utility.getRelativePath("korisnici.txt");
		File file = new File(path);
		
		if(!file.exists()){
			try {
				file.createNewFile();
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			
			for (Korisnik korisnik : sviKorisnici) {
				out.println(korisnik.getKorisnickoIme()+ "|" +korisnik.getLozinka()+"|" +korisnik.getPrezime()+"|"
								+korisnik.getPrezime()+"|"+ korisnik.getUloga());
			}
			
			out.flush();
			out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	public  static void readFromFile(){
		
		try {
			
			sviKorisnici.clear();
			
			String path = Utility.getRelativePath("korisnici.txt");
			File file = new File(path);
			
			if(file.exists()){
				
				BufferedReader in  = new BufferedReader(
						new FileReader(file));
				
				String text;
			
				
				while((text = in.readLine()) !=null){
					StringTokenizer st = new StringTokenizer(text, "|");
					while (st.hasMoreTokens()) {
						String korisnickoIme = st.nextToken();
						String lozinka  = st.nextToken();
						String ime = st.nextToken();
						String prezime = st.nextToken();
						String uloga = st.nextToken();
						
						Korisnik korisnik = new Korisnik(korisnickoIme, lozinka, ime, prezime, uloga);
						sviKorisnici.add(korisnik);
						
					}
				}
				
				
				
				in.close();
			}else{
				System.out.println("Ne postoji fajl!");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
	}
	
	public static Korisnik pretragaKorisnika(String korisnickoIme, String lozinka){
		
		Korisnik retVal = null;
		for (Korisnik korisnik : sviKorisnici) {
			if(korisnik.getKorisnickoIme().equals(korisnickoIme) && korisnik.getLozinka().equals(lozinka)){
				retVal = korisnik;
				break;
			}
		}
		
		return retVal;
	}
	
	public static Korisnik pretragaPoKorisnickomImenu(String korisnickoIme){
		
		Korisnik retVal = null;
		for (Korisnik kor : sviKorisnici) {
			if(kor.getKorisnickoIme().equals(kor.getKorisnickoIme())){
				retVal = kor;
				break;
			}		
		}
		
		return retVal;
		
		
	}
}
