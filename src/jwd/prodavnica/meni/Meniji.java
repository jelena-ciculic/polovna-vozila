package jwd.prodavnica.meni;

import jwd.prodavnica.file.KategorijaFile;
import jwd.prodavnica.ui.BiciklUi;
import jwd.prodavnica.ui.KategorijaUi;
import jwd.prodavnica.ui.MotociklUi;
import jwd.prodavnica.ui.PutnickoVoziloUi;
import jwd.prodavnica.ui.RacunUi;
import jwd.prodavnica.ui.VoziloUi;
import jwd.prodavnica.utility.Utility;

public class Meniji {
	
public static void pocetniMeniZaProdavce(){
		
		System.out.println("Opcija 1 - Unos, brisanje i izmena podataka");
		System.out.println("Opcija 2 - Pregled");
		System.out.println("Opcija 3 - Pretraga podataka");
		System.out.println("Opcija 4 - Sortiranje");
		System.out.println("Opcija 5 - Izdavanje racuna");
		System.out.println("Opcija 0 - Izlaz");
	}
	
public static void pocetniMeniZaMenadzere(){
		System.out.println("Unesi broj opcije: ");
		System.out.println("Opcija 1 - Unos, brisanje i izmena podataka");
		System.out.println("Opcija 2 - Pregled podataka");
		System.out.println("Opcija 3 - Pretraga podataka");
		System.out.println("Opcija 4 - Sortiranje");
		System.out.println("Opcija 5 - Racuni");
		System.out.println("Opcija 0 - Izlaz");
	}

public static void  unosIzmenaBrisanjeMeni(){
	
	System.out.println("Opcija 1 - Unos podataka");
	System.out.println("Opcija 2 - Izmena podataka");
	System.out.println("Opcija 3 - Brisanje podataka");
	System.out.println("Opcija 0 - Izlaz");
	
}

public static void unosMeni(){
	
	System.out.println("Opcija 1 - Dodavanje nove kategorije");
	System.out.println("Opcija 2 - Dodavanje novog bicikla");
	System.out.println("Opcija 3 - Dodavanje novog motocikla");
	System.out.println("Opcija 4 - Dodavanje novog putnickog vozila");
	System.out.println("Opcija 0 - Izlaz");
	
}

public static void izmenaMeni(){
	
	System.out.println("Opcija 1 -Izmena kategorije");
	System.out.println("Opcija 2 -Izmena bicikla");
	System.out.println("Opcija 3 -Izmena motocikla");
	System.out.println("Opcija 4 -Izmena putnickog vozila");
	System.out.println("Opcija 0 - Izlaz");
	
}

public static void brisanjeMeni(){
	
	System.out.println("Opcija 1 -Brisanje kategorije");
	System.out.println("Opcija 2 -Brisanje bicikla");
	System.out.println("Opcija 3 -Brisanje motocikla");
	System.out.println("Opcija 4 -Brisanje putnickog vozila");
	System.out.println("Opcija 0 - Izlaz");
	
}

public static void pregledMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pregled svih kategorija");
	System.out.println("Opcija 2 - Pregled obrisanih kategorija");
	System.out.println("Opcija 3 - Pregled postojecih kategorija");
	System.out.println("Opcija 4 - Pregled svih vozila");
	System.out.println("Opcija 5 - Pregled obrisanih vozila");
	System.out.println("Opcija 6 - Pregled neobrisanih vozila");
	System.out.println("Opcija 7 - Pregled prodatih vozila");
	System.out.println("Opcija 8 - Pregled vozila na lageru");
	System.out.println("Opcija 0 - Izlaz");
	
	
}

public static void pretragaMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pretraga - kategorije");
	System.out.println("Opcija 2 - Pretraga - sva vozila");
	System.out.println("Opcija 3 - Pretraga - Bicikli ");
	System.out.println("Opcija 4 - Ptretraga - Motocikli");
	System.out.println("Opcija 5 - Pretraga - Putnicka vozila");
	
	
	
}

public static void pretragaKategorijeMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pretraga kategorije po sifri");
	System.out.println("Opcija 2 - Pretraga kategorjie po nazivu");
	
}

public static void pretragaSvihVozilaMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pretraga vozila po sifri");
	System.out.println("Opcija 2 - Pretraga vozila po nazivu");
	System.out.println("Opcija 3 - Pretraga vozila po kategoriji");
	System.out.println("Opcija 4 - Pretraga vozila po opsegu cene");
				
}

public static void pretragaBiciklMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pretraga  po sifri");
	System.out.println("Opcija 2 - Pretraga  po nazivu");
	System.out.println("Opcija 3 - Pretraga  po kategoriji");
	System.out.println("Opcija 4 - Pretraga  po opsegu cene");
	System.out.println("Opcija 5 - Pretraga  po broju brzina");
	
	
}

public static void pretragaMotociklMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pretraga  po sifri");
	System.out.println("Opcija 2 - Pretraga  po nazivu");
	System.out.println("Opcija 3 - Pretraga  po kategoriji");
	System.out.println("Opcija 4 - Pretraga  po opsegu cene");
	System.out.println("Opcija 5 - Pretraga  po kubikazi motora");
	
	
}

public static void pretragaPutnickoVoziloMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pretraga  po sifri");
	System.out.println("Opcija 2 - Pretraga  po nazivu");
	System.out.println("Opcija 3 - Pretraga  po kategoriji");
	System.out.println("Opcija 4 - Pretraga  po opsegu cene");
	System.out.println("Opcija 5 - Pretraga  po kubikazi motora");
	System.out.println("Opcija 6 - Pretraga  po tipu goriva");
	System.out.println("Opcija 7 - Pretraga  po broju vrata");
	
	
}


public static void sortiranjeMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - sortiranje vozila po nazivu rastuce");
	System.out.println("Opcija 2 - sortiranje vozila po nazivu opadajuce");
	System.out.println("Opcija 3 - sortiranje vozila po ceni rastuce");
	System.out.println("Opcija 4 - sortiranje vozila po ceni opadajuce");
	
	
}

public static void racuniMenadzeriMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 - Pregled svih racuna bez stavki");
	System.out.println("Opcija 2 - Pregled svih racuna po datumu");
	System.out.println("Opcija 3 - Pregled pojedinacnog racuna sa stavkama");
	System.out.println("Opcija 4 - Izvestaj o ukupnoj prodaji");
	
	
}

public static void racuniProdavciMeni(){
	
	System.out.println("Unesi broj opcije: ");
	System.out.println("Opcija 1 -Formiranje racuna");
		
}




public static void unosIzmenaBrisanje(){
	
	
	unosIzmenaBrisanjeMeni();
	String opcija = Utility.ocitajTekst();
	
	
		switch (opcija) {
		case "0":
			System.out.println("Izlaz iz programa!");
			break;
		case "1":
			
			unos();
			
			break;

		case "2":
			izmena();
			
			break;
		case "3":
			
			brisanje();
			
			break;
		default:
			System.out.println("Nepostojeca opcija");
			break;
		}
	
}

	public static void unos(){
		
		unosMeni();
		String opcija = Utility.ocitajTekst();
		
		
		
			switch (opcija) {
			case "0":
				System.out.println("Izlaz!");
				break;
			case "1":
				KategorijaUi.dodajKategoriju();
				KategorijaFile.writeToFile();
				break;
			case "2":
				BiciklUi.dodajBicikl();
				break;
			case "3":
				MotociklUi.dodajMotocikl();
				break;
				
			case "4":
				PutnickoVoziloUi.dodajNovoPutnickoVozilo();
				break;
	
	
			default:
				System.out.println("Nepostojeca opcija");
				break;
			}
		
	}
	
	public static void izmena(){
		
		izmenaMeni(); 
		String opcija = Utility.ocitajTekst();
		
	
		
			switch (opcija) {
			case "0":
				System.out.println("Izlaz!");
				break;
			case "1":
				KategorijaUi.izmeniKategoriju();
				break;
			case "2":
				BiciklUi.izmeniBicikl();
				break;
			case "3":
				MotociklUi.izmeniMotocikl();
				break;
			case "4":
				PutnickoVoziloUi.izmeniPutnickoVozilo();
				break;
	
			default:
				System.out.println("Nepostojeca opcija");
				break;
			}
		
	}

	public static void brisanje(){
		
		brisanjeMeni();
		String opcija = Utility.ocitajTekst();
		
		
		
			switch (opcija) {
			case "0":
				System.out.println("Izlaz!");
				break;
			case "1":
				KategorijaUi.obrisiKategoriju();
				break;
			case "2":
				BiciklUi.obrisiBicikl();
				break;
			case "3":
				MotociklUi.brisanjeMotocikla();
				break;
			case "4":
				PutnickoVoziloUi.brisanjePutnickogVozila();
				break;
	
			default:
				System.out.println("Nepostojeca opcija");
				break;
			}
		
	}
	
	public static void pregled(){
			
			pregledMeni();
			String opcija = Utility.ocitajTekst();
			
			
			
				switch (opcija) {
				case "0":
					System.out.println("Izlaz!");
					break;
				case "1":
					KategorijaUi.ispisiSveKategorije();
					break;
				case "2":
					KategorijaUi.ispisiSveObrisaneKategorije();
					break;
				case "3":
					KategorijaUi.ispisiSveNeobrisaneKategorije();
					break;
				case "4":
					VoziloUi.ispisSvihVozila();
					break;
				case "5":
					VoziloUi.ispisSvihObrisanihVozila();
					break;

				case "6":
					VoziloUi.ispisSvihNeobrisanihVozila();
					break;
				case "7":
					VoziloUi.ispisSvihProdatihVozila();
					break;
				case "8":
					VoziloUi.ispisSvihVozilaNaLageru();
					break;

				default:
					System.out.println("Nepostojeca opcija");
					break;
				}
			
		}
	
	
	
	public static void pretraga(){
		
		pretragaMeni();
		String opcija = Utility.ocitajTekst();
		
		
			switch (opcija) {
			case "0":
				System.out.println("Izlaz!");
				break;
			case "1":
				pretragaKategorije();
				break;
			case "2":
				pretragaSvaVozila();
				break;
			case "3":
				pretragaBicikl();
				break;
			case "4":
				pretragaMotocikl();
			
				break;
			case "5":
				pretragaPutnickoVozilo();
				
				break;


			default:
				System.out.println("Nepostojeca opcija");
				break;
			}
		
		
	}
	
	public static void pretragaKategorije(){
			
			pretragaKategorijeMeni();
			String opcija = Utility.ocitajTekst();
			
			
				switch (opcija) {
				case "0":
					System.out.println("Izlaz!");
					break;
				case "1":
					KategorijaUi.pronadjiPoSifri();
					break;
				case "2":
					KategorijaUi.pronadjiPoNazivu();
					break;
				
				default:
					System.out.println("Nepostojeca opcija");
					break;
				}
			
		}
	
	public static void pretragaSvaVozila(){
		
		pretragaSvihVozilaMeni();;
		String opcija = Utility.ocitajTekst();
		
		
			switch (opcija) {
			case "0":
				System.out.println("Izlaz!");
				break;
			case "1":
				VoziloUi.pretragaVozilaPoSifri();
				break;
			case "2":
				VoziloUi.pretragaPoNazivuVozila();
				break;
			case "3":
				VoziloUi.pretragaPoKategorijiVozila();
				break;
			case "4":
				VoziloUi.pretragaVozilaPoOpseguCene();
				break;
			default:
				System.out.println("Nepostojeca opcija");
				break;
			}
		
	}
	
public static void pretragaBicikl(){
		
		pretragaBiciklMeni();
		String opcija = Utility.ocitajTekst();
		
		
			switch (opcija) {
			case "0":
				System.out.println("Izlaz!");
				break;
			case "1":
				BiciklUi.pretragaBicikalaPosifri();
				break;
			case "2":
				BiciklUi.pretragaBicikalaPoNazivu();
				break;
			case "3":
				BiciklUi.pretragaBicikalaPoKategoriji();
				break;
			case "4":
				BiciklUi.pretragaPoOpseguCene();
				break;
			case "5":
				BiciklUi.pretragaPoBrojuBrzina();
				break;
			default:
				System.out.println("Nepostojeca opcija");
				break;
			}
		
	}


public static void pretragaMotocikl(){
	
	pretragaMotociklMeni();
	String opcija = Utility.ocitajTekst();
	
	
		switch (opcija) {
		case "0":
			System.out.println("Izlaz!");
			break;
		case "1":
			MotociklUi.pretragaPoSifriMotocikla();
			break;
		case "2":
			MotociklUi.pretragaPoNazivuMotocikla();
			break;
		case "3":
			MotociklUi.pretragaPoKategorijiMotocikla();
			break;
		case "4":
			MotociklUi.pretragaPoOpseguCeneMotocikli();
			break;
		case "5":
			MotociklUi.pretragaMotocikalaPoKubikazi();
			break;
		default:
			System.out.println("Nepostojeca opcija");
			break;
		}
	
}

public static void pretragaPutnickoVozilo(){
	
	pretragaPutnickoVoziloMeni();
	String opcija = Utility.ocitajTekst();
	
	
		switch (opcija) {
		case "0":
			System.out.println("Izlaz!");
			break;
		case "1":
			PutnickoVoziloUi.pretragaPoSifriPutnickogVozila();
			break;
		case "2":
			PutnickoVoziloUi.pretragaPoNazivuPutnickogVozila();
			break;
		case "3":
			PutnickoVoziloUi.pretragaPoKategorijiPutnickogVozila();
			break;
		case "4":
			PutnickoVoziloUi.pretragaPoOpseguCenePutnickogVozila();
			break;
		case "5":
			PutnickoVoziloUi.pretragaPoKubikazi();
			break;
		case "6":
			PutnickoVoziloUi.pretragaPoTipuGoriva();
			break;
		case "7":
			PutnickoVoziloUi.pretragaPoBrojuVrata();
			break;
		default:
			System.out.println("Nepostojeca opcija");
			break;
		}
	
}

public static void sortiranje(){
	
	sortiranjeMeni();
	String opcija = Utility.ocitajTekst();
	
	
		switch (opcija) {
		case "0":
			System.out.println("Izlaz!");
			break;
		case "1":
			VoziloUi.sortirajVozilaPoNazivuRastuce();
			break;
		case "2":
			VoziloUi.sortirajVozilaPoNazivuOpadajuce();
			break;
		case "3":
			VoziloUi.sortirajVozilaPoCeniRastuce();
			break;
		case "4":
			VoziloUi.sortirajVozilaPoCeniOpadajuce();
			break;
	
		default:
			System.out.println("Nepostojeca opcija");
			break;
		}
	
}

public static void racuniProdavci(){
	
	racuniProdavciMeni();
	String opcija = Utility.ocitajTekst();
	
	
		switch (opcija) {
		case "0":
			System.out.println("Izlaz!");
			break;
		case "1":
			RacunUi.formirajRacun();
			break;
		default:
			System.out.println("Nepostojeca opcija");
			break;
		}
	
}

public static void racuniMenadzeri(){
	
	racuniMenadzeriMeni();
	String opcija = Utility.ocitajTekst();
	
	
		switch (opcija) {
		case "0":
			System.out.println("Izlaz!");
			break;
		case "1":
			RacunUi.ispisSvihRacunaBezStavki();
			break;
		case "2":
			RacunUi.pretragaRacunaPoDatumu();
			break;
		case "3":
			RacunUi.pregledRacunaSaStavkama();
			break;
		case "4":
			RacunUi.izvestajProdaje();
			break;
		default:
			System.out.println("Nepostojeca opcija");
			break;
		}
	
}


	
	



}
