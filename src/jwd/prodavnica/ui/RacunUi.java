package jwd.prodavnica.ui;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import jwd.prodavnica.api.PolovnaVozilaApi;
import jwd.prodavnica.file.RacunFile;
import jwd.prodavnica.file.StavkaFile;
import jwd.prodavnica.model.Korisnik;
import jwd.prodavnica.model.Racun;
import jwd.prodavnica.model.Stavka;
import jwd.prodavnica.model.Vozilo;
import jwd.prodavnica.utility.Utility;

public class RacunUi {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	

	public static void formirajRacun(){
		
		StavkaFile.readFromFile();
		RacunFile.readFromFileDatumi();
		
		System.out.print("Korisnicko ime:");
		String korIme = Utility.ocitajTekst();
		
		while(KorisnikUi.pretragaPoKorisnickomImenu(korIme)==null){
			
			System.out.println("Ne postoji korisnik sa tim imenom u evidenciji");
			System.out.print("Korisnicko ime:");
			korIme = Utility.ocitajTekst();
		}
		
		Korisnik prodavac = KorisnikUi.pretragaPoKorisnickomImenu(korIme);
		
		System.out.println("Sifra racuna: ");
		String sifraRacuna = Utility.ocitajTekst();
		
		while(RacunFile.pretrgaRacunaPosifri(sifraRacuna)!=null){
			
			System.out.println("Racun sa tom sifrom vec postoji");
			System.out.println("Sifra racuna: ");
			sifraRacuna = Utility.ocitajTekst();
		}
		
		Date datumVreme = new Date();
		
		
		Racun   r = new Racun(sifraRacuna, prodavac, datumVreme);
		
		boolean prekid = false;
		
		while(prekid == false){
			
			VoziloUi.ispisSvihVozilaNaLageru();
			
			System.out.println("Unesi sifru vozila koje zelis da dodas  u racun(ili prekid za kraj unosa)");
			String sifra = Utility.ocitajTekst();
			
			if(sifra.equalsIgnoreCase("prekid")){
				if(r.getStavkeRecuna().size()==0){
					prekid= false;
				}else{
					prekid = true;
				}
			}else{
				
				while(VoziloUi.pretragaVozilaPoSifri(sifra, false)==null){
					
					System.out.println("Nepostojeca sifra");
					System.out.println("Unesite sifru vozila");
					sifra=Utility.ocitajTekst();
				}
				
				Vozilo v = VoziloUi.pretragaVozilaPoSifri(sifra, false);
				Stavka s = new Stavka(r, v);
				r.getStavkeRecuna().add(s);


			}
								
		}
		
		double ukupnaCena = r.ukupnaCena();
		
		r.setUkupnaCena(ukupnaCena);
		
		RacunFile.sviRacuni.add(r);
		RacunFile.writeToFile();
		
		PolovnaVozilaApi.reload();
		
		
		
		for (Stavka st : r.getStavkeRecuna()) {
			StavkaFile.sveStavke.add(st);
			StavkaFile.writeToFile();
		}
		
		Racun racun = RacunFile.pretrgaRacunaPosifri(r.getSifraRacuna());
		
		if(racun!=null){
			
			izmeniStanjeProdaje(r);
			System.out.println(racun);
			System.out.println("Uspesno ste formirali racun");
		}else{
			System.out.println("Greska pri unosu podataka");
		}
		
		
		String datumString = sdf.format(datumVreme);
		
		RacunFile.datumiProdaje.add(datumString);
		RacunFile.writeToFileDatumi();
		
		
		
	}
	
	public static void izmeniStanjeProdaje(Racun r){
		
		
			for (Stavka st : r.getStavkeRecuna()) {
				
				Vozilo v = VoziloUi.pretrgaVozilaPoSifri(st.getVozilo().getSifra());
				v.setStanje(true);
			}
		
		
		PolovnaVozilaApi.reload();
	}
	
	
	public static void ispisSvihRacunaBezStavki(){
		
		RacunFile.ispisSvihRacuna();
	}
	
	public static void pregledRacunaSaStavkama(){
		
		StavkaFile.readFromFile();
		
		System.out.println("Unesite sifru racuna");
		String sifra = Utility.ocitajTekst();
		
		while(RacunFile.pretrgaRacunaPosifri(sifra)==null){
			System.out.println("Nije pronadjen racun pod tom sifrom");
			System.out.println("Unesite ponovo sifru");
			sifra = Utility.ocitajTekst();
		}
		
		
		Racun racun = RacunFile.pretrgaRacunaPosifri(sifra);
		
		System.out.printf("%-20s %20s\n", "Racun:" + racun.getSifraRacuna(),
				"Prodavac:" +racun.getProdavac().getIme());
		System.out.println("===============================================");
		System.out.printf("%-10s %-20s %-10s\n","#","VOZILO","CENA");
		System.out.println("-----------------------------------------------");
		for (Stavka st : racun.getStavkeRecuna()) {
			
			System.out.printf("%-10d %-20s %-10.2f\n", st.getSifraStavke(),
					st.getVozilo().getNaslovOglasa(),st.getVozilo().getCena());
			
		}
		System.out.println("-----------------------------------------------");
		
		System.out.printf("%-30s %-12.2f\n", "Ukupno:", racun.getUkupnaCena());
		System.out.println("===============================================");
		System.out.printf("%-22s %-20s\n",
				"Racun izdat:", Utility.konvertujDatumUString(racun.getDatumVreme()));
	}
	
	
	public static void izvestajProdaje(){
		
		Map<String, Double> ukupnaProdaja = RacunFile.ukupnaProdajaPoDanima();
		
		if(ukupnaProdaja==null || ukupnaProdaja.isEmpty())
			System.out.println("Nisu pronadjeni rezultati");
		else{
			System.out.println("Izvestaj o prodaji:");
			System.out.println("----------------------------------------");
			System.out.printf("%-15s %-15s\n", "DATUM", "UKUPNA ZARADA");
			System.out.println("----------------------------------------");
			for (String	dan : ukupnaProdaja.keySet()) {
				
				System.out.printf("%-15s  %-15.2f\n", dan, ukupnaProdaja.get(dan));
			}
		}
	}
	
	public static void pretragaRacunaPoDatumu(){
		
		System.out.println("Unesite datum u formatu: dd.MM.yyyy");
		String datumS = Utility.ocitajTekst();
		
		List<Racun> racuni = RacunFile.pretragaRacunaPoDatumu(datumS);
		
		if(racuni.isEmpty() || racuni==null){
			System.out.println("Nisu pronadjeni racuni za uneti datum!");
			
		}else{
			
			for (Racun racun : racuni) {
				System.out.println(racun.toStringBezStavki());
			}
		}
	}
	
	


}
