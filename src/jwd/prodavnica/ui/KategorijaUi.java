package jwd.prodavnica.ui;

import java.util.List;

import jwd.prodavnica.file.KategorijaFile;
import jwd.prodavnica.model.Kategorija;
import jwd.prodavnica.utility.Utility;

public class KategorijaUi {
	
	
	public static void ispisiSveKategorije(){
		KategorijaFile.ispisSvihKategorija();
	}
	
	public static void ispisiSveNeobrisaneKategorije(){
		KategorijaFile.ispisSvihKategorija(false);
	}
	
	public static void ispisiSveObrisaneKategorije(){
		KategorijaFile.ispisSvihKategorija(true);
	}
	
	public static Kategorija pronadjiPoSifri(String sifra){
		
		Kategorija kat = KategorijaFile.pretragaKategorijePoSifri(sifra);
		return kat;
		
	}
	
	public static Kategorija pronadjiPoSifri(String sifra, boolean trueFalse){
		
		return KategorijaFile.pretragaKategorijePoSifri(sifra, trueFalse);
	}
	
	public static void pronadjiPoSifri(){
		
		System.out.print("Unesi sifru kategorije: ");
		String sifra  = Utility.ocitajTekst();
		
		while(pronadjiPoSifri(sifra)==null){
			System.out.println("Kategorija sa tom sifrom ne postoji u evidenciji!");
			System.out.print("Unesi sifru kategorije: ");
			sifra=Utility.ocitajTekst();
		}
		
		Kategorija kat = pronadjiPoSifri(sifra);
		
		if(kat==null)
		System.out.println("Nije pronadjena kategorija za unetu sifru");
		else
		System.out.println(kat);
		
	}
	
	public static List<Kategorija> pronadjiPoNazivu(String naziv){
		
		List<Kategorija> list;
		
		list = KategorijaFile.pretragaKategorijePoNazivu(naziv);
		
		return list;
	}
	
	public static void pronadjiPoNazivu(){
		
		System.out.print("Unesi naziv kategorije: ");
		String naziv = Utility.ocitajTekst();
		
		 List<Kategorija> list = pronadjiPoNazivu(naziv);
		
		if(list==null || list.isEmpty())
			System.out.println("Nije pronadjena kategorija za uneti naziv");
		else{
			
			for (Kategorija kategorija : list) {
				System.out.println(kategorija);
			}
		}
		
	}
	
	
	
	public static void dodajKategoriju(){
		
	ispisiSveKategorije();
	
	System.out.print("Unesi sifru kategorije: ");
		String sifra  = Utility.ocitajTekst();
		
		while(pronadjiPoSifri(sifra)!=null){
			
			System.out.println("Kategorija sa tom sifrom vec postoji!");
			System.out.print("Unesi sifru kategorije: ");
			sifra=Utility.ocitajTekst();
		}
		
		
		System.out.print("Unesi naziv: ");
		String naziv  = Utility.ocitajTekst();
		
		System.out.print("Unesi opis: ");
		String opis  = Utility.ocitajTekst();
		boolean obrisano = false;
		
		char odluka = Utility.ocitajOdlukuOPotvrdi("da li zelite da unesete i nad-kategoriju?");
		
		Kategorija nadKat;
		Kategorija kat;
		
		if( odluka=='Y'){
			
			System.out.print("Unesi sifru kategorije: ");
			String sifraNadKategorije  = Utility.ocitajTekst();
			
			while(pronadjiPoSifri(sifraNadKategorije)==null){
				System.out.println("Kategorija sa tom sifrom ne postoji!");
				System.out.print("Unesi sifru kategorije: ");
				sifraNadKategorije=Utility.ocitajTekst();
			}
			
			 nadKat =pronadjiPoSifri(sifraNadKategorije);
			  kat = new Kategorija(sifra, naziv, opis, nadKat,obrisano);
			  KategorijaFile.sveKategorije.add(kat);
			
		
		}
		
		if( odluka=='N'){
			nadKat=null;
			kat = new Kategorija(sifra, naziv, opis, nadKat,obrisano);
			KategorijaFile.sveKategorije.add(kat);
			
		}
		
		
	}
	
	public static void izmeniKategoriju(){
		
		ispisiSveNeobrisaneKategorije();
		
		System.out.print("Unesi sifru kategorije: ");
		String sifra  = Utility.ocitajTekst();
		
		while(pronadjiPoSifri(sifra,false)==null){
			System.out.println("Kategorija sa tom sifrom ne postoji!");
			System.out.print("Unesi sifru kategorije: ");
			sifra=Utility.ocitajTekst();
		}
		
		Kategorija kat = pronadjiPoSifri(sifra);
		System.out.println(kat);
		
		System.out.print("Unesi  novi naziv: ");
		String naziv  = Utility.ocitajTekst();
		
		System.out.print("Unesi  novi opis: ");
		String opis  = Utility.ocitajTekst();
		
		char odluka = Utility.ocitajOdlukuOPotvrdi("da li zelite da izmenite i nad-kategoriju?");
		
		Kategorija nadKat;
		if( odluka=='Y'){
			
			char odluka1 = Utility.ocitajOdlukuOPotvrdi("da li zelite da ponistite nad-kategoriju?");
			
			if(odluka1=='Y'){
				nadKat =null;
				kat.setNaziv(naziv);
				kat.setOpis(opis);
				kat.setNadKategorija(nadKat);
						
			}
			
			if(odluka1=='N'){
			
			
			
			System.out.print("Unesi sifru kategorije: ");
			String sifraNadKategorije  = Utility.ocitajTekst();
			
			while(pronadjiPoSifri(sifraNadKategorije)==null){
				System.out.println("Kategorija sa tom sifrom ne postoji!");
				System.out.print("Unesi sifru kategorije: ");
				
			sifraNadKategorije=Utility.ocitajTekst();
			}
			
			
			nadKat = pronadjiPoSifri(sifraNadKategorije);
			
			kat.setNaziv(naziv);
			kat.setOpis(opis);
			kat.setNadKategorija(nadKat);
			
		
		}
			
		}
		if(odluka=='N'){
			kat.setNaziv(naziv);
			kat.setOpis(opis);
		}
		
			
	}
	
	public static void obrisiKategoriju(){
		
		ispisiSveKategorije();
		
		System.out.print("Unesi sifru kategorije: ");
		String sifra  = Utility.ocitajTekst();
		
		while(pronadjiPoSifri(sifra)==null){
			System.out.println("Kategorija sa tom sifrom ne postoji!");
			System.out.print("Unesi sifru kategorije: ");
			sifra=Utility.ocitajTekst();
		}
		
		
		Kategorija kat  = pronadjiPoSifri(sifra);
		
		kat.setObrisano(true);
		
		System.out.println(kat);
		
		
		
	}

}
