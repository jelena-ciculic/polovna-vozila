package jwd.prodavnica.ui;

import java.util.ArrayList;






import java.util.List;

import jwd.prodavnica.api.PolovnaVozilaApi;
import jwd.prodavnica.file.PutnickoVoziloFile;
import jwd.prodavnica.model.Kategorija;
import jwd.prodavnica.model.PutinckoVozilo;
import jwd.prodavnica.model.Vozilo;
import jwd.prodavnica.utility.Utility;

public class PutnickoVoziloUi {
	
	
	public static PutinckoVozilo pretragaPoSifri(String sifra){
		
		return PutnickoVoziloFile.pretragaPoSifriVozila(sifra);
	}
	
	public static void dodajNovoPutnickoVozilo(){
		
		PutnickoVoziloFile.ispisSvihVozila();
		
		System.out.print("Sifra vozila:");
		String sifra = Utility.ocitajTekst();
		
		while(PutnickoVoziloFile.pretragaPoSifriVozila(sifra)!=null){
			System.out.println("Vozilo pod tom sifrom vec postoji");
			System.out.println("Unesite sifru: ");
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
		
		System.out.print("Marka vozila: ");
		String marka = Utility.ocitajTekst();
		
		System.out.print("Model vozila: ");
		String model = Utility.ocitajTekst();
		
		System.out.print("Broj vrata: ");
		int brojVrata = Utility.ocitajCeoBroj();
		
		ArrayList<String> listaOpreme = new ArrayList<String>();
		
		boolean prekid = false;
		while(prekid == false){
			
			System.out.println("Unesite stavku opreme(ili ukucajte prekid da zavrsite unos>>)");
			String odluka  = Utility.ocitajTekst();
		
			
			if(odluka.equalsIgnoreCase("prekid")){
				
				if(listaOpreme.size()==0){
					prekid=false;
				}else{
					prekid=true;
				}
			}
			
			else{
				
				listaOpreme.add(odluka);
			}
			
			
		}
		
		
		PutinckoVozilo pv = new PutinckoVozilo(sifra, naslovOglasa, cena, kat, opis, stanje, obrisan,
				kubikaza, snagaMotora, tipGoriva, marka, model, brojVrata, listaOpreme);
		
		boolean provera = PutnickoVoziloFile.putnickaVozila.add(pv);
		
		if(provera)
			System.out.println("Uspesno ste dodali vozilo");
		else
			System.out.println("Greska, podaci nisu uneti!");
		
		PutnickoVoziloFile.writeToFile();
		PolovnaVozilaApi.reload();
		
			
		
	}
	
	public static void izmeniPutnickoVozilo(){
		
		PutnickoVoziloFile.ispisSvihVozila();
		
		System.out.print("Sirfa vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretragaVozilaPoSifri(sifra, false)==null){
			System.out.print("Ne postoji vozilo za unetu sifru!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
		PutinckoVozilo pv =(PutinckoVozilo)VoziloUi.pretragaVozilaPoSifri(sifra, false);
		System.out.println(pv);
		
		System.out.print("Novi naslov oglasa:");
		String naslovOglasa = Utility.ocitajTekst();
		
		
		System.out.print("Nova cena: ");
		double cena = Utility.ocitajRealanBroj();
		
		
		KategorijaUi.ispisiSveNeobrisaneKategorije();
		
		System.out.print("Nova kategorija: ");
		
		String sifraKat = Utility.ocitajTekst();
		
		while(KategorijaUi.pronadjiPoSifri(sifraKat, false)==null){
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
		
		System.out.print("Marka vozila: ");
		String marka = Utility.ocitajTekst();
		
		System.out.print("Model vozila: ");
		String model = Utility.ocitajTekst();
		
		System.out.print("Broj vrata: ");
		int brojVrata = Utility.ocitajCeoBroj();
		
		//Izmena liste opreme vozila
		char odluka=Utility.ocitajOdlukuOPotvrdi("Da li zelite da izmenite opremu vozila?");
		
		if(odluka =='Y'){
			
			/*
			System.out.println("Unesite naziv opreme koju zelite da izmenite");
			String nazivOpreme = Utility.ocitajTekst();
			
			while(nazivOpreme.isEmpty()){
				
				System.out.println("Niste uneli naziv opreme");
				System.out.println("Unesite naziv opreme koju zelite da izmenite");
				nazivOpreme = Utility.ocitajTekst();
			}
			
			int indeks = pronadjiStavkuOpreme(nazivOpreme, pv.getOprema());
			
			System.out.println("Unesite novi naziv opreme:");
			String novaOprema = Utility.ocitajTekst();
			pv.getOprema().set(indeks, novaOprema);
			*/
			
			izmenaOpreme(pv);
			pv.setNaslovOglasa(naslovOglasa);
			pv.setCena(cena);
			pv.setKategorijaVozila(kat);
			pv.setOpis(opis);
			pv.setKubikaza(kubikaza);
			pv.setSnagaMotora(snagaMotora);
			pv.setTipGoriva(tipGoriva);
			pv.setMarka(marka);
			pv.setModel(model);
			pv.setBrojVrata(brojVrata);
			
			
			
		}
		
		if(odluka=='N'){
		
		pv.setNaslovOglasa(naslovOglasa);
		pv.setCena(cena);
		pv.setKategorijaVozila(kat);
		pv.setOpis(opis);
		pv.setKubikaza(kubikaza);
		pv.setSnagaMotora(snagaMotora);
		pv.setTipGoriva(tipGoriva);
		pv.setMarka(marka);
		pv.setModel(model);
		pv.setBrojVrata(brojVrata);
		
		}
		
		PutnickoVoziloFile.writeToFile();
		PolovnaVozilaApi.reload();
		
			
	}
	
	public static void brisanjePutnickogVozila(){
		
		PutnickoVoziloFile.ispisSvihVozila();
		
		System.out.print("Sirfa vozila: ");
		String sifra = Utility.ocitajTekst();
		
		while(VoziloUi.pretrgaVozilaPoSifri(sifra)==null){
			System.out.print("Ne postoji vozilo za unetu sifru!");
			System.out.print("Sirfa vozila: ");
			sifra = Utility.ocitajTekst();
		}
		
		PutinckoVozilo pv = (PutinckoVozilo)VoziloUi.pretrgaVozilaPoSifri(sifra);

		pv.setObrisan(true);
		PutnickoVoziloFile.writeToFile();
		PolovnaVozilaApi.reload();
		System.out.println(pv);
		
	}
	
	public static void pretragaPoSifriPutnickogVozila(){
		
		System.out.print("Sifra vozila");
		String sifra = Utility.ocitajTekst();
		
		PutinckoVozilo pv = PutnickoVoziloFile.pretragaPoSifriVozila(sifra);
		
		if(pv==null)
			System.out.println("Nije pronadjeno vozilo za uneti sifru!");
		else
			System.out.println(pv);
	}
	
	public static void pretragaPoNazivuPutnickogVozila(){
		
		System.out.println("Unesite naziv  putnickog vozila: ");
		String naziv = Utility.ocitajTekst();
		
		List<Vozilo> retVal = VoziloUi.pretragaPoNazivuVozila(naziv);
		List<Vozilo> lista  = new ArrayList<Vozilo>();
		
		if(retVal.size()!=0){
			
			
			for (Vozilo vozilo : retVal) {
				if(vozilo instanceof PutinckoVozilo)
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
	
	
	public static void pretragaPoKategorijiPutnickogVozila(){
		
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
				if(vozilo instanceof PutinckoVozilo)
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
	
	
	public static void pretragaPoOpseguCenePutnickogVozila(){
		
		System.out.print("Unesite pocetnu cenu:");
		double cenaMin = Utility.ocitajRealanBroj();
		
		System.out.print("Unesite krajnju cenu:");
		double cenaMax = Utility.ocitajRealanBroj();
		
		List<Vozilo> retVal = VoziloUi.pretragaVozilaPoOpseguCene(cenaMin,cenaMax);
		List<Vozilo> lista = new ArrayList<Vozilo>();
		
		if(retVal.size()!=0){
			
			
			for (Vozilo vozilo : retVal) {
				if(vozilo instanceof PutinckoVozilo)
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
	
	public static void pretragaPoKubikazi(){
		
		System.out.print("Unesite pocetnu kubikazu");
		
		int minKub = Utility.ocitajCeoBroj();
		
		System.out.print("Unesite krajnju kubikazu");
		
		int maxKub = Utility.ocitajCeoBroj();
		
		List<PutinckoVozilo> lista = PutnickoVoziloFile.pretragaPoKubikaziMotora(minKub, maxKub);
		
		if(lista.isEmpty() || lista==null){
			System.out.println("Nisu pronadjena vozila za unete vrednosti!");
		}else{
			
			for (PutinckoVozilo putinckoVozilo : lista) {
				System.out.println(putinckoVozilo);
			}
		}
		
		
	}
	
	public static void pretragaPoTipuGoriva(){
		
		System.out.print("Unesite naziv goriva");
		
		String gorivo = Utility.ocitajTekst();
		
		List<PutinckoVozilo> lista = PutnickoVoziloFile.pretragaPoTipuGoriva(gorivo);
		
		if(lista.isEmpty() || lista==null){
			System.out.println("Nisu pronadjena vozila za unetu vrednost!");
		}else{
			
			for (PutinckoVozilo putinckoVozilo : lista) {
				System.out.println(putinckoVozilo);
			}
		}
		
		
		
	}
	
	public static void pretragaPoBrojuVrata(){
		
		System.out.print("Unesite broj vrata");
		
		int brojVrata = Utility.ocitajCeoBroj();
		
		List<PutinckoVozilo> lista = PutnickoVoziloFile.pretragaPoBrojuVrata(brojVrata);
		
		if(lista.isEmpty() || lista==null){
			System.out.println("Nisu pronadjena vozila za unetu vrednost!");
		}else{
			
			for (PutinckoVozilo putinckoVozilo : lista) {
				System.out.println(putinckoVozilo);
			}
		}
		
	
		
	}
	
	public static int pronadjiStavkuOpreme(String ime, ArrayList<String> oprema){
		
		int indeks = -1;
		
		for(int i = 0; i <oprema.size(); i ++){
			
			if(oprema.get(i).equals(ime)){
				indeks = i;
			}
		}
		
		return indeks;
	}
	
	public static void izmenaOpreme(PutinckoVozilo pv){
		
		
		System.out.println("Izaberi opciju:");
		System.out.println("Opcija 1 - dodaj novu stavku opreme");
		System.out.println("Opcija 2 - ukloni stavku opreme");
		System.out.println("Opcija 3 - imeni postojecu opremu");
		System.out.println("Opcija 0 - Izlaz");
		
		String opcija = "";
		
		while(!opcija.equals("0")){
			
			opcija = Utility.ocitajTekst();
			
			switch (opcija) {
			case "1":
				dodajOpremu(pv);
				break;
				
			case "2":
				obrisiOpremu(pv);
				break;
			case "3":
				izmeniPostojecuStavkuOpreme(pv);
				
				break;

			default:
				System.out.println("Nepostojeca opcija!");
				break;
			}
		}
		
		
		
		
	}
	
	public static void dodajOpremu(PutinckoVozilo pv){
		
		
		for (String s : pv.getOprema()) {
			System.out.println(s);
		}
		
		boolean prekid = false;
		
		while(prekid == false){
			
			System.out.println("Unesite naziv nove opreme(ili ukucajte prekid da zavrsite unos>>)");
			String odluka  = Utility.ocitajTekst();
			if(odluka.equalsIgnoreCase("prekid")){
				prekid=true;
				System.out.println("Ukucajte 0 da zavrsite izmenu!");
			}else{
				
				pv.getOprema().add(odluka);
				
			}
		
		}
		
		
	}
	
	public static void obrisiOpremu(PutinckoVozilo pv){
		
		for (String oprema : pv.getOprema()) {
			System.out.println(oprema);
		}
		
		boolean prekid = false;
		while(prekid == false){
			System.out.println(
					"Unesi naziv opreme koju zelis da uklonis iz liste:(ili prekid za kraj>>)");
			String odluka = Utility.ocitajTekst();
			
			if(odluka.equalsIgnoreCase("prekid")){
				prekid=true;
				System.out.println("Ukucajte 0 da zavrsite izmenu!");
			}else{
				
				int index = pronadjiStavkuOpreme(odluka, pv.getOprema());
				 pv.getOprema().remove(index);
			}
		}
	}
	
	public static void izmeniPostojecuStavkuOpreme(PutinckoVozilo pv){
		
		for (String oprema : pv.getOprema()) {
			System.out.println(oprema);
		}
		
		boolean prekid = false;
		while(prekid == false){
			System.out.println(
					"Unesi naziv opreme koju zelis da uklonis iz liste:(ili prekid za kraj>>)");
			String odluka = Utility.ocitajTekst();
			
			if(odluka.equalsIgnoreCase("prekid")){
				prekid=true;
				System.out.println("Ukucajte 0 da zavrsite izmenu!");
			}else{
				
				int index = pronadjiStavkuOpreme(odluka, pv.getOprema());
				String novaOprema = "";
				while(novaOprema.isEmpty()){
				System.out.println("Unesi novi naziv opreme:");
				novaOprema = Utility.ocitajTekst();
				}
				 pv.getOprema().set(index, novaOprema);
			}
		}
		
	}

}
