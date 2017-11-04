package jwd.prodavnica.ui;


import java.util.ArrayList;



import java.util.Collections;
import java.util.List;

import jwd.prodavnica.file.BiciklFile;
import jwd.prodavnica.file.MotociklFile;
import jwd.prodavnica.file.PutnickoVoziloFile;
import jwd.prodavnica.model.Bicikl;
import jwd.prodavnica.model.Motocikl;
import jwd.prodavnica.model.PutinckoVozilo;
import jwd.prodavnica.model.Vozilo;
import jwd.prodavnica.utility.CenaKomparator;
import jwd.prodavnica.utility.NazivKomparator;
import jwd.prodavnica.utility.Utility;



public  class VoziloUi {
	
	
public static ArrayList<Vozilo> svaVozila  = new ArrayList<Vozilo>();
	
	public static void dodajUListuVozila(){
		svaVozila.clear();
		svaVozila.addAll(BiciklFile.sviBicikli);
		svaVozila.addAll(MotociklFile.sviMotocikli);
		svaVozila.addAll(PutnickoVoziloFile.putnickaVozila);
		
	
	}
	
	public static void ispisSvihVozila(){
		
		for (Vozilo voz : svaVozila) {
			System.out.println(voz);
		}
	}
	
	public static void ispisSvihPostojecihNepostojecihVozila(boolean trueFalse){
		
		for (Vozilo v : svaVozila) {
			if(v.isObrisan()==trueFalse){
				System.out.println(v);
			}
			
		}
	}
	
	public static void ispisSvihObrisanihVozila(){
		
		ispisSvihPostojecihNepostojecihVozila(true);
	}
	
	
	public static void ispisSvihNeobrisanihVozila(){
			
			ispisSvihPostojecihNepostojecihVozila(false);
		}
	
	
	public static void ispisSvihProdatihNeprodatihVozila(boolean trueFalse){
		
		for (Vozilo v : svaVozila) {
			if(v.isStanje()==trueFalse){
				System.out.println(v);
			}
		}
	}
	
	public static void ispisSvihVozilaNaLageru(){
		ispisSvihProdatihNeprodatihVozila(false);
	}
	
	public static void ispisSvihProdatihVozila(){
		ispisSvihProdatihNeprodatihVozila(true);
		
	}
	
	
	public static void dodajUPojedinacneListe(){
		
		BiciklFile.sviBicikli.clear();
		MotociklFile.sviMotocikli.clear();
		PutnickoVoziloFile.putnickaVozila.clear();
		
		for (Vozilo vozilo : svaVozila) {
			if(vozilo instanceof Bicikl){
				BiciklFile.sviBicikli.add((Bicikl)vozilo);
			}
			
			if(vozilo instanceof Motocikl){
				MotociklFile.sviMotocikli.add((Motocikl)vozilo);
			}
			
			if(vozilo instanceof PutinckoVozilo){
				PutnickoVoziloFile.putnickaVozila.add((PutinckoVozilo)vozilo);
			}
		}
	}
	
	public static void promeniStanjeVozila(){
		
		System.out.print("Unesite sifru vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(pretrgaVozilaPoSifri(sifra)==null){
			System.out.println("Za unetu sifru ne postoji vozilo u evidenciji!");
			System.out.print("Unesite ponovo sifru:");
			sifra = Utility.ocitajTekst();
			
		}
		
		Vozilo  voz = pretrgaVozilaPoSifri(sifra);
		
		char odluka = Utility.ocitajOdlukuOPotvrdi("da li zelite da oznacite vozilo kao prodato?(unesite  Y ili N");
		
		if(odluka=='Y'){
			
			voz.setStanje(true);
		}
		
		if(odluka=='N'){
			voz.setStanje(false);
		}
		
		/*
		PolovnaVozilaApi.reload();
		
		PolovnaVozilaApi.sacuvajPodatke();
		
		*/
		
		
	
	}
	
	public static Vozilo pretrgaVozilaPoSifri(String sifra){
		
		Vozilo retVal = null;
		for (Vozilo voz : svaVozila) {
			if(voz.getSifra().equalsIgnoreCase(sifra)){
				retVal = voz;
			}
		}
		
		return retVal;
	}
	
	//pretraga po sifri i stanju prodaje
	public static Vozilo pretragaVozilaPoSifri(String sifra, boolean trueFalse){
		
		Vozilo retVal=null;
		
		for (Vozilo v : svaVozila) {
			
			if(v.getSifra().equalsIgnoreCase(sifra) && v.isStanje()==trueFalse){
				retVal = v;
			}
		}
		
		return retVal;
		
		
	}
	
	public static void pretragaVozilaPoSifri(){
		
		System.out.print("Unesite sifru vozila:");
		String sifra = Utility.ocitajTekst();
		
		Vozilo v = pretrgaVozilaPoSifri(sifra);
		
		if(v==null)
			System.out.println("Nije pronadjeno vozilo za unetu sifru");
		else
			System.out.println(v);
	}
	
	public static List<Vozilo> pretragaPoNazivuVozila(String naziv){
		
		List<Vozilo> retVal = new ArrayList<Vozilo>();
		
		for (Vozilo vozilo : svaVozila) {
			if(vozilo.getNaslovOglasa().contains(naziv)){
				retVal.add(vozilo);
			}
		}
		
		return retVal;
	}
	
	public static void pretragaPoNazivuVozila(){
			
			List<Vozilo> retVal=null;
			
			System.out.print("Unesite naziv vozila: ");
			String naziv = Utility.ocitajTekst();
			
			retVal = pretragaPoNazivuVozila(naziv);
			
			if(retVal==null || retVal.isEmpty())
				System.out.println("Za uneti naziv nije pronadjeno ni jedno vozilo");
			else{
				
				for (Vozilo vozilo : retVal) {
					System.out.println(vozilo);
				}
			}
			
				
		
		}
	
	public static List<Vozilo> pretragaPoKategorijiVozila(String sifraKategorije){
		
		List<Vozilo> retVal = new ArrayList<Vozilo>();
		
		for (Vozilo vozilo : svaVozila) {
			if(vozilo.getKategorijaVozila().getSifraKategorije().contains(sifraKategorije)){
				retVal.add(vozilo);
				
			}
		}
		
		return retVal;
	}
	
	
	public static void pretragaPoKategorijiVozila(){
		
		KategorijaUi.ispisiSveKategorije();
		
		List<Vozilo> list = null;
		
		System.out.print("Unesi sifru kategorije: ");
		String sifra = Utility.ocitajTekst();
		while(KategorijaUi.pronadjiPoSifri(sifra)==null){
			System.out.println("Ne postoji kategorija sa tom sifrom!");
			System.out.println("Unesite ponovo sifru:");
			sifra = Utility.ocitajTekst();
		}
		
		list = pretragaPoKategorijiVozila(sifra);
		
		if(list ==null || list.isEmpty())
			System.out.println("Nije pronadjeno ni jedon vozilu za tu kategoriji!");
		else{
			for (Vozilo vozilo : list) {
				System.out.println(vozilo);
			}
		}
	}
	
	
	public static List<Vozilo> pretragaVozilaPoOpseguCene(double min,double max){
		
		List<Vozilo> retVal = new ArrayList<Vozilo>();
		
		for (Vozilo vozilo : svaVozila) {
			
			if(vozilo.getCena()>=min && vozilo.getCena() <= max){
				retVal.add(vozilo);
			}
		}
		
		return retVal;
		
		
	}
	
	public static void pretragaVozilaPoOpseguCene(){
		
		List<Vozilo> list;
		
		System.out.print("Unesite pocetnu cenu:");
		
		double minCena = Utility.ocitajRealanBroj();
		
		System.out.print("Unesite krajnju cenu:");
		
		double maxCena = Utility.ocitajRealanBroj();
		
		list  = pretragaVozilaPoOpseguCene(minCena, maxCena);
		
		if(list==null || list.isEmpty())
			System.out.println("Nema rezultata za unete cene");
		else{
			
			for (Vozilo vozilo : list) {
				System.out.println(vozilo);
			}
		}
			
		
	}
	
	public static void sortirajVozilaPoNazivuRastuce(){
		
		Collections.sort(svaVozila,new NazivKomparator(1));
		ispisSvihVozila();
	}
	
	public static void sortirajVozilaPoNazivuOpadajuce(){
		
		Collections.sort(svaVozila,new NazivKomparator(-1));
		ispisSvihVozila();
	}
	
	public static void sortirajVozilaPoCeniRastuce(){
		Collections.sort(svaVozila, new CenaKomparator(1));
		ispisSvihVozila();
	}
	
	public static void sortirajVozilaPoCeniOpadajuce(){
		Collections.sort(svaVozila, new CenaKomparator(-1));
		ispisSvihVozila();
	}
	
	

	


		
	}


