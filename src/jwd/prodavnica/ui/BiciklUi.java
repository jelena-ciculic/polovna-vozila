package jwd.prodavnica.ui;


import java.util.ArrayList;
import java.util.List;

import jwd.prodavnica.api.PolovnaVozilaApi;
import jwd.prodavnica.file.BiciklFile;
import jwd.prodavnica.model.Bicikl;
import jwd.prodavnica.model.Kategorija;
import jwd.prodavnica.model.Vozilo;
import jwd.prodavnica.utility.Utility;

public class BiciklUi {
	
	
	public static void ispisiSveBicikle(){
		BiciklFile.ispisSvihBiciklova();
	}
	
	
	
	
	
	public  static Bicikl pretragaPoSifri(String sifra){
		
		
		
		return BiciklFile.pretragaBicikalaPoSifri(sifra);
	}
	
	
	
	public  static Bicikl pretragaPoSifri(String sifra,boolean trueFalse){
		
			return BiciklFile.pretragaBicikalaPoSifri(sifra,trueFalse);
	}
	
	
	
	public  static void pretragaBicikalaPosifri(){
		
		System.out.print("Sirfa vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(pretragaPoSifri(sifra)==null){
			System.out.print("Ne postoji vozilo za unetu sifru!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
			Bicikl b =pretragaPoSifri(sifra);
		
		System.out.println(b);
		
	}
	
	
	public static void pretragaBicikalaPoNazivu(){
		
		System.out.println("Unesite naziv bicikla: ");
		String naziv = Utility.ocitajTekst();
		
		List<Vozilo> retVal = VoziloUi.pretragaPoNazivuVozila(naziv);
		List<Vozilo> lista  = new ArrayList<Vozilo>();
		
		if(retVal.size()!=0){
			
			
			for (Vozilo vozilo : retVal) {
				if(vozilo instanceof Bicikl)
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
	
	public static void pretragaBicikalaPoKategoriji(){
		
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
				if(vozilo instanceof Bicikl)
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
	
	public static void pretragaPoOpseguCene(){
		
		System.out.print("Unesite pocetnu cenu:");
		double cenaMin = Utility.ocitajRealanBroj();
		
		System.out.print("Unesite krajnju cenu:");
		double cenaMax = Utility.ocitajRealanBroj();
		
		List<Vozilo> retVal = VoziloUi.pretragaVozilaPoOpseguCene(cenaMin,cenaMax);
		List<Vozilo> lista = new ArrayList<Vozilo>();
		
		if(retVal.size()!=0){
			
			
			for (Vozilo vozilo : retVal) {
				if(vozilo instanceof Bicikl)
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
	
	public static void pretragaPoBrojuBrzina(){
		
		List<Bicikl> list;
		
		System.out.print("Unesite minimalan broj brzina:");
		int min = Utility.ocitajCeoBroj();
		
		System.out.print("Unesite maksimalan broj brzina:");
		int max = Utility.ocitajCeoBroj();
		
		list = BiciklFile.pretragaPoBrojuBrzina(min, max);
		
		if(list==null || list.isEmpty())
			System.out.println("Nema pronadjenih vozila!");
		else{
			for (Bicikl bicikl : list) {
				System.out.println(bicikl);
			}
		}
		
		
	}
	

	public  static void dodajBicikl(){
		
		ispisiSveBicikle();
		
		System.out.print("Sifra vozila:");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretrgaVozilaPoSifri(sifra)!=null){
			System.out.print("Za unetu sifru vec postoji vozilo u evidenciji!");
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
	
		System.out.print("Broj brzina: ");
		int brojBrzina = Utility.ocitajCeoBroj();
		
		Bicikl b = new Bicikl(sifra, naslovOglasa, cena, kat, opis, stanje, obrisan, brojBrzina);
		
		boolean provera = BiciklFile.sviBicikli.add(b);
		
		
		if(provera)
			System.out.println("uspesno ste dodali novi bicikl");
		else
			System.out.println("Doslo je do greske!");
		
		BiciklFile.writeToFile();
		PolovnaVozilaApi.reload();
		
		
			
		
	}
	
	public  static void izmeniBicikl(){
		
		ispisiSveBicikle();
		
		System.out.print("Sirfa vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretragaVozilaPoSifri(sifra,false)==null){
			System.out.print("Ne postoji vozilo za unetu sifru!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
		Bicikl b = null;
		if(VoziloUi.pretragaVozilaPoSifri(sifra, false) instanceof Bicikl){
			
			 b=(Bicikl) VoziloUi.pretragaVozilaPoSifri(sifra, false);
			
		}
		
		System.out.println(b);
		
		izmenaBicikla(b);
		
		
		
		/*
		
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
		
	
		System.out.print("Novi Broj brzina: ");
		int brojBrzina = Utility.ocitajCeoBroj();
		
		b.setNaslovOglasa(naslovOglasa);
		b.setCena(cena);
		b.setKategorijaVozila(kat);
		b.setBrojBrzina(brojBrzina);
		*/
		BiciklFile.writeToFile();
		PolovnaVozilaApi.reload();
		
		

	
		
	}
	
	public static void obrisiBicikl(){
		
		ispisiSveBicikle();
		
		System.out.print("Sirfa vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretrgaVozilaPoSifri(sifra)==null){
			System.out.print("Ne postoji vozilo za unetu sifru!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
		Bicikl b = null;
		
		if(VoziloUi.pretrgaVozilaPoSifri(sifra) instanceof Bicikl){
				b = pretragaPoSifri(sifra);
		}
		
		b.setObrisan(true);
		BiciklFile.writeToFile();
		PolovnaVozilaApi.reload();
		System.out.println(b);
		
		
	}
	
	
	public static void izmenaBicikla(Bicikl b){
		
		ispisiOpcije();
		
		String opcija = "";
		
		while(!opcija.equals("0")){
			
			 opcija=Utility.ocitajTekst();
			 
			 switch (opcija) {
			 case "0":
				 System.out.println("Izlaz");
				 break;
			case "1":
				izmenaNaslovaOglasa(b);
				break;
			case "2":
				izmenaCeneBicikla(b);
				break;
			case "3":
				izmenaKategorijeBicikla(b);
				break;
			case "4":
				izmenaOpisaBicikla(b);
				break;
			case "5":
				izmenaBrojaBrzina(b);
				break;
			default:
				break;
			}
			
			
			
		}
		
		
	}
	
	public static void ispisiOpcije(){
		
		System.out.println("Odaberite stavku oglasa koju zelite da izmenite");
		System.out.println("Opcija 1 - Naslov oglasa");
		System.out.println("Opcija 2  - Cena");
		System.out.println("Opcija 3 - Kategorija bicikla");
		System.out.println("Opcija 4 - Opis");
		System.out.println("Opcija 5 - Broj brzina");
		
		
	}
	
	public static void izmenaNaslovaOglasa(Bicikl b){
		
		System.out.println("Tekuci naslov: " + b.getNaslovOglasa());
		
		System.out.print("Unesite novi naslov");
		String naslovOglasa = Utility.ocitajTekst();
		
		
		b.setNaslovOglasa(naslovOglasa);
		
		System.out.println("Unesite 0 da zavrsite izmenu");
	}
	
	public static void izmenaCeneBicikla(Bicikl b){
		
		System.out.println("Tekuca cena: " + b.getCena());
		
		System.out.print("Unesi novu cenu");
		
		double novaCena  = Utility.ocitajRealanBroj();
		b.setCena(novaCena);
		System.out.println("Unesite 0 da zavrsite izmenu");
	}
	
	public static void izmenaKategorijeBicikla(Bicikl b){
		
		System.out.println("Tekuca kategorija; " + b.getKategorijaVozila().getSifraKategorije()
				+ " " + b.getKategorijaVozila().getNaziv());
		
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
		b.setKategorijaVozila(kat);
		System.out.println("Ukucajte 0 da zavrsite izmenu");
		
		
	}
		public static void izmenaOpisaBicikla(Bicikl b){
			
			System.out.println("Tekuci opis: " + b.getOpis());
			
			System.out.print("Unesite novi opis");
			String noviOpis = Utility.ocitajTekst();
			
			
			b.setOpis(noviOpis);
			
			System.out.println("Unesite 0 da zavrsite izmenu");
		}
		
		
		public static void izmenaBrojaBrzina(Bicikl b){
			
			System.out.println("Tekuci broj brzina: " + b.getBrojBrzina());
			
			System.out.print("Unesite novi broj brzina");
			int brBrzina = Utility.ocitajCeoBroj();
			
			
			b.setBrojBrzina(brBrzina);
			
			System.out.println("Unesite 0 da zavrsite izmenu");
		}
		
		

	
	

	
	
	

	
	
}
