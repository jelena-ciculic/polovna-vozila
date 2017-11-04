
package jwd.prodavnica.api;




import jwd.prodavnica.file.BiciklFile;
import jwd.prodavnica.file.KategorijaFile;
import jwd.prodavnica.file.KorisnikFile;
import jwd.prodavnica.file.MotociklFile;
import jwd.prodavnica.file.PutnickoVoziloFile;
import jwd.prodavnica.file.RacunFile;
import jwd.prodavnica.meni.Meniji;
import jwd.prodavnica.model.Korisnik;
import jwd.prodavnica.ui.KorisnikUi;
import jwd.prodavnica.ui.VoziloUi;
import jwd.prodavnica.utility.Utility;

public class PolovnaVozilaApi {

	public static void ucitajPodatke(){
		
		KorisnikFile.readFromFile();
		KategorijaFile.readFromFile();
		BiciklFile.readFromFile();
		MotociklFile.readFromFile();
		PutnickoVoziloFile.readFromFile();
		RacunFile.readFromFile();
	
	
	}
	
	public static void sacuvajPodatke(){
		
		KorisnikFile.writeTofile();
		KategorijaFile.writeToFile();
		BiciklFile.writeToFile();
		MotociklFile.writeToFile();
		PutnickoVoziloFile.writeToFile();
		RacunFile.writeToFile();
	
	}
	
	public static void reload(){
		VoziloUi.dodajUListuVozila();
		VoziloUi.dodajUPojedinacneListe();
	}
	
	
	public static void main(String[] args) {
		
		
		ucitajPodatke();
		VoziloUi.dodajUListuVozila();
		
		
		
	
		System.out.println("*************************************");
		System.out.println("--------PRODAVNICA POLOVNIH VOZILA----------");
		System.out.println("*************************************");
		
		Korisnik logovaniKorisnik = KorisnikUi.prijavaNaSisitem();
		
		System.out.println("DOBRODOSLI!!! " +logovaniKorisnik.getKorisnickoIme());
		
		String opcija = "";
		
		if(logovaniKorisnik.getUloga().equals("prodavac")){
			
			while(!opcija.equals("0")){
				
				Meniji.pocetniMeniZaProdavce();
				opcija= Utility.ocitajTekst();
				switch (opcija) {
				case "0":
					System.out.println("Izlaz iz programa!");
					break;
				case "1":
					Meniji.unosIzmenaBrisanje();
					break;
				case "2":
					Meniji.pregled();
					break;
				case "3":
					Meniji.pretraga();
					break;
				case "4":
					Meniji.sortiranje();
					break;
				case "5":
					Meniji.racuniProdavci();
					break;
				default:
					System.out.println("Nepostojeca opcija!");
					break;
				}
				
			}
		}
		
		
		if(logovaniKorisnik.getUloga().equals("menadzer")){
					
					while(!opcija.equals("0")){
						
						Meniji.pocetniMeniZaMenadzere();
						opcija= Utility.ocitajTekst();
						switch (opcija) {
						case "0":
							System.out.println("Izlaz iz programa!");
							break;
						case "1":
							Meniji.unosIzmenaBrisanje();
							break;
						case "2":
							Meniji.pregled();
							break;
						case "3":
							Meniji.pretraga();
							break;
						case "4":
							Meniji.sortiranje();
							break;
						case "5":
							Meniji.racuniMenadzeri();
							break;
						default:
							System.out.println("Nepostojeca opcija!");
							break;
						}
						
					}
				}
		
		
		
		VoziloUi.dodajUPojedinacneListe();
		sacuvajPodatke();
		
			
	
	}

}
