package jwd.prodavnica.ui;

import jwd.prodavnica.file.KorisnikFile;
import jwd.prodavnica.model.Korisnik;
import jwd.prodavnica.utility.Utility;


public class KorisnikUi {
	
	public static Korisnik prijavaNaSisitem(){
		
		System.out.println("Unesite korisnicko ime");
		String korisnickoIme =Utility.ocitajTekst();
		System.out.println("Unesite lozinku: ");
		String lozinka = Utility.ocitajTekst();
		
		while(KorisnikFile.pretragaKorisnika(korisnickoIme, lozinka)==null){
			System.out.println("Korisnicko ime ili lozinka nisu ispravni!");
			System.out.println("Unesite ponovo podatke:");
			System.out.print("Korisnicko Ime: ");
			korisnickoIme = Utility.ocitajTekst();
			System.out.print("Lozinka ");
			lozinka = Utility.ocitajTekst();
		}
		
		Korisnik korisnik = KorisnikFile.pretragaKorisnika(korisnickoIme, lozinka);
		return korisnik;
		
	}
	
	
	public static Korisnik pretragaPoKorisnickomImenu(String ime){
		
		return KorisnikFile.pretragaPoKorisnickomImenu(ime);
	}

}
