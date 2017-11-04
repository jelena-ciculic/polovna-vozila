package jwd.prodavnica.ui;

import java.util.ArrayList;
import java.util.List;

import jwd.prodavnica.api.PolovnaVozilaApi;
import jwd.prodavnica.file.MotociklFile;
import jwd.prodavnica.model.Kategorija;
import jwd.prodavnica.model.Motocikl;
import jwd.prodavnica.model.Vozilo;
import jwd.prodavnica.utility.Utility;

public class MotociklUi {
	
	
	public static void ispisSvihMotocikala(){
		MotociklFile.ispisSvihMotocikala();
	}
	
	public static void dodajMotocikl(){
		
		ispisSvihMotocikala();
		
		System.out.print("Sifra vozila:");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretrgaVozilaPoSifri(sifra)!=null){
			System.out.print(" Za unetu sifru vec postoji vozilo u evidenciji!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
		System.out.print("Naslov oglasa:");
		String naslovOglasa = Utility.ocitajTekst();
		
		System.out.print("Cena: ");
		double cena = Utility.ocitajRealanBroj();
		
		
		KategorijaUi.ispisiSveNeobrisaneKategorije();
		System.out.println("Sifra kategorije: ");
		String sifraKategorije = Utility.ocitajTekst();
		
		while(KategorijaUi.pronadjiPoSifri(sifraKategorije)==null){
			
			System.out.println("Za unetu sifru nije pronadjena kategorija");
			System.out.println("Sifra kategorije: ");
			sifraKategorije = Utility.ocitajTekst();
		}
		
		Kategorija kat = KategorijaUi.pronadjiPoSifri(sifraKategorije);
		
		System.out.print("Opis: ");
		String opis = Utility.ocitajTekst();
		
		boolean stanje = false;
		
		boolean obrisan = false;
	
		System.out.print("Kubikaza: ");
		int kubikaza = Utility.ocitajCeoBroj();
		
		System.out.print("Snaga motora: ");
		String snagaMotora = Utility.ocitajTekst();
		
		System.out.print("Tip goriva: ");
		String tipGoriva = Utility.ocitajTekst();
		
		
		
		
		
		Motocikl moto = new Motocikl(sifra, naslovOglasa, cena,
				kat, opis, stanje, obrisan, kubikaza, snagaMotora, tipGoriva);
		
		boolean provera = MotociklFile.sviMotocikli.add(moto);
		
		
		if(provera)
			System.out.println("Uspesno ste dodali novi motocikl");
		else
			System.out.println("Doslo je do greske!");
		
		MotociklFile.writeToFile();
		PolovnaVozilaApi.reload();
		
		
		
	}
	
	public static void izmeniMotocikl(){
		
		ispisSvihMotocikala();
		
		System.out.print("Sirfa vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretragaVozilaPoSifri(sifra, false)==null){
			System.out.print("Ne postoji vozilo za unetu sifru!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
		Motocikl moto = null;
		
		if(VoziloUi.pretragaVozilaPoSifri(sifra, false) instanceof Motocikl){
				moto =(Motocikl)VoziloUi.pretragaVozilaPoSifri(sifra, false);
		}
		
		System.out.println(moto);
		
		System.out.print("Novi naslov oglasa:");
		String naslovOglasa = Utility.ocitajTekst();
		
		
		System.out.print("Nova cena: ");
		double cena = Utility.ocitajRealanBroj();
		
		
		KategorijaUi.ispisiSveNeobrisaneKategorije();
		
		System.out.print("Nova kategorija: ");
		
		String sifraKat = Utility.ocitajTekst();
		
		while(KategorijaUi.pronadjiPoSifri(sifraKat, false) ==null){
			KategorijaUi.ispisiSveNeobrisaneKategorije();
			System.out.println("Nepostojeca kategorija!");
			System.out.print("Unesite ponovo sifru kategorije: ");
			sifraKat= Utility.ocitajTekst();
		}
		
		Kategorija kat = KategorijaUi.pronadjiPoSifri(sifraKat, false);
		
		System.out.print("Opis: ");
		String opis = Utility.ocitajTekst();
		
		
		
	
		System.out.print("Kubikaza: ");
		int kubikaza = Utility.ocitajCeoBroj();
		
		System.out.print("Snaga motora: ");
		String snagaMotora = Utility.ocitajTekst();
		
		System.out.print("Tip goriva: ");
		String tipGoriva = Utility.ocitajTekst();
		
		moto.setNaslovOglasa(naslovOglasa);
		moto.setCena(cena);
		moto.setKategorijaVozila(kat);
		moto.setOpis(opis);
		moto.setKubikaza(kubikaza);
		moto.setSnagaMotora(snagaMotora);
		moto.setTipGoriva(tipGoriva);
		
	
		
		MotociklFile.writeToFile();
		PolovnaVozilaApi.reload();
		
		
		
	}
	
	public static void brisanjeMotocikla(){
		
		ispisSvihMotocikala();
		
		System.out.print("Sirfa vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretrgaVozilaPoSifri(sifra)==null){
			System.out.print("Ne postoji vozilo za unetu sifru!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
		Motocikl moto=null;
		
		if(VoziloUi.pretrgaVozilaPoSifri(sifra) instanceof Motocikl){
			
		 moto = (Motocikl)VoziloUi.pretrgaVozilaPoSifri(sifra);
		}

		moto.setObrisan(true);
		MotociklFile.writeToFile();
		PolovnaVozilaApi.reload();
		System.out.println(moto);
		
		
		
	}
	
	public static void pretragaPoSifriMotocikla(){
		
		System.out.print("Unesite sifru motocikla:");
		String sifra = Utility.ocitajTekst();
		
		while(MotociklFile.pretragaPoSifri(sifra)==null){
			System.out.println("Nije pronadjen motocikl za unetu sifru!");
			System.out.println("Unesite ponovo sifru:");
			sifra = Utility.ocitajTekst();
		}
		
		Motocikl moto = MotociklFile.pretragaPoSifri(sifra);
		
		System.out.println(moto);
	}
	
	public static void pretragaPoNazivuMotocikla(){
		
		System.out.println("Unesite naziv motocikla: ");
		String naziv = Utility.ocitajTekst();
		
		List<Vozilo> retVal = VoziloUi.pretragaPoNazivuVozila(naziv);
		List<Vozilo> lista  = new ArrayList<Vozilo>();
		
		if(retVal.size()!=0){
			
			
			for (Vozilo vozilo : retVal) {
				if(vozilo instanceof Motocikl)
				lista.add(vozilo);
			}
		}
		
		if(lista.size() !=0){
			for (Vozilo vozilo : lista) {
				System.out.println(vozilo);
			}
		}else{
			System.out.println("Nisu pronadjeni rezultati za uneti naziv");
		}
		
		
	}
	
	public static void pretragaPoKategorijiMotocikla(){
		
		KategorijaUi.ispisiSveKategorije();
		
		System.out.println("Unesi sifru kategorije: ");
		String sifra = Utility.ocitajTekst();
		
		while(KategorijaUi.pronadjiPoSifri(sifra)==null){
			
			System.out.println("Nije pronadjena karegorija!");
			System.out.print("Unesi sifru kategorije: ");
			 sifra = Utility.ocitajTekst();	
		}
		
		List<Vozilo> retVal = VoziloUi.pretragaPoKategorijiVozila(sifra);
		List<Vozilo> lista = new ArrayList<Vozilo>();
		
		if(retVal.size()!=0){
			
			
			for (Vozilo vozilo : retVal) {
				if(vozilo instanceof Motocikl)
				lista.add(vozilo);
			}
		}
		
		if(lista.size() !=0){
			for (Vozilo vozilo : lista) {
				System.out.println(vozilo);
			}
		}else{
			System.out.println("Nisu pronadjeni rezultati za unetu kategoriju!");
		}
			
		
	}
	
	
	public static void pretragaPoOpseguCeneMotocikli(){
		
		System.out.print("Unesite pocetnu cenu:");
		double cenaMin = Utility.ocitajRealanBroj();
		
		System.out.print("Unesite krajnju cenu:");
		double cenaMax = Utility.ocitajRealanBroj();
		
		List<Vozilo> retVal = VoziloUi.pretragaVozilaPoOpseguCene(cenaMin,cenaMax);
		List<Vozilo> lista = new ArrayList<Vozilo>();
		
		if(retVal.size()!=0){
			
			
			for (Vozilo vozilo : retVal) {
				if(vozilo instanceof Motocikl)
				lista.add(vozilo);
			}
		}
		
		if(lista.size() !=0){
			for (Vozilo vozilo : lista) {
				System.out.println(vozilo);
			}
		}else{
			System.out.println("Nisu pronadjeni rezultati za unete cene!");
		}
		
		
	}

	
	public static void pretragaMotocikalaPoKubikazi(){
		
		System.out.print("Unesite minimalnu kubikazu:");
		int minK = Utility.ocitajCeoBroj();
		
		System.out.print("Unesite maksimalnu kubikazu:");
		int maxK = Utility.ocitajCeoBroj();
		
		List<Motocikl> list = MotociklFile.pretragaPoKubikazi(minK, maxK);
		
		if(list==null || list.isEmpty())
			System.out.println("Nisu pronadjeni rezultati!");
		else{
			for (Motocikl motocikl : list) {
				System.out.println(motocikl);
			}
		}
		
	}

}
