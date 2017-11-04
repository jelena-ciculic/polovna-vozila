package jwd.prodavnica.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import jwd.prodavnica.ui.KorisnikUi;
import jwd.prodavnica.utility.Utility;

public class Racun {
	
	protected String sifraRacuna;
	protected Korisnik prodavac;
	protected Date datumVreme;
	protected double ukupnaCena;
	protected ArrayList<Stavka> stavkeRecuna = new ArrayList<Stavka>();
	
	
	
	
	
	public Racun() {
		super();
		// TODO Auto-generated constructor stub
		this.stavkeRecuna = new ArrayList<Stavka>();
	}





	public Racun(String sifraRacuna, Korisnik prodavac, Date datumVreme,
			double ukupnaCena) {
		super();
		this.sifraRacuna = sifraRacuna;
		this.prodavac = prodavac;
		this.datumVreme = datumVreme;
		this.ukupnaCena = ukupnaCena;
		this.stavkeRecuna = new ArrayList<Stavka>();
	}





	public Racun(String sifraRacuna, Korisnik prodavac, Date datumVreme) {
		super();
		this.sifraRacuna = sifraRacuna;
		this.prodavac = prodavac;
		this.datumVreme = datumVreme;
		this.ukupnaCena =0;
		this.stavkeRecuna  = new ArrayList<Stavka>();
	}

	public Racun (String text){
		
		StringTokenizer st = new StringTokenizer(text, "|");
		
		while(st.hasMoreTokens()){
			sifraRacuna = st.nextToken();
			String korIme = st.nextToken();
			prodavac = KorisnikUi.pretragaPoKorisnickomImenu(korIme);
			String datumString = st.nextToken();
			datumVreme = Utility.ocitajDatum(datumString);
			ukupnaCena = Double.parseDouble(st.nextToken());
			
					
			
		}
	}
	
	public String toFile(){
		
		return sifraRacuna+"|"+prodavac.getKorisnickoIme()+"|"+Utility.konvertujDatumUString(datumVreme)+"|"+ukupnaCena;
	}




	@Override
	public String toString() {
		return "Racun [sifraRacuna=" + sifraRacuna + ", prodavac=" + prodavac
				+ ", datumVreme=" + datumVreme + ", ukupnaCena=" + ukupnaCena
				+ ", stavkeRecuna=" + stavkeRecuna + "]";
	}
	
	
	public String toStringBezStavki(){
		
		return sifraRacuna  + "|Prodavac: "  + prodavac.getKorisnickoIme() +
				"|" + Utility.konvertujDatumUString(datumVreme)+ "|" +ukupnaCena;
	}


	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sifraRacuna == null) ? 0 : sifraRacuna.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Racun other = (Racun) obj;
		if (sifraRacuna == null) {
			if (other.sifraRacuna != null)
				return false;
		} else if (!sifraRacuna.equals(other.sifraRacuna))
			return false;
		return true;
	}





	public String getSifraRacuna() {
		return sifraRacuna;
	}





	public void setSifraRacuna(String sifraRacuna) {
		this.sifraRacuna = sifraRacuna;
	}





	public Korisnik getProdavac() {
		return prodavac;
	}





	public void setProdavac(Korisnik prodavac) {
		this.prodavac = prodavac;
	}





	public Date getDatumVreme() {
		return datumVreme;
	}





	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}





	public double getUkupnaCena() {
		return ukupnaCena;
	}





	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}





	public ArrayList<Stavka> getStavkeRecuna() {
		return stavkeRecuna;
	}





	public void setStavkeRecuna(ArrayList<Stavka> stavkeRecuna) {
		this.stavkeRecuna = stavkeRecuna;
	}
	
	public  double ukupnaCena(){
		
		double retVal = 0;
		for (Stavka stavka : this.getStavkeRecuna()) {
			retVal+=stavka.getVozilo().getCena();
		}
		
		return retVal;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	

}
