package jwd.prodavnica.model;

import java.util.StringTokenizer;

import jwd.prodavnica.file.RacunFile;
import jwd.prodavnica.ui.VoziloUi;



public class Stavka {
	
	public static int counter = 1;
	
 protected int sifraStavke;
 protected Racun racun;
 protected Vozilo vozilo;
 
	public Stavka() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stavka(Racun racun, Vozilo vozilo) {
		super();
		this.sifraStavke = counter ++;
		this.racun = racun;
		this.vozilo = vozilo;
	}
	
	
	

	public Stavka(String text){
		
		StringTokenizer st = new StringTokenizer(text, "|");
		
		while(st.hasMoreTokens()){
			
			sifraStavke = Integer.parseInt(st.nextToken());
			String sifraRacuna = st.nextToken();
			racun = RacunFile.pretrgaRacunaPosifri(sifraRacuna);
			String sifraVozila = st.nextToken();
			vozilo = VoziloUi.pretrgaVozilaPoSifri(sifraVozila);
			
			racun.getStavkeRecuna().add(this);
		}
			
	}
	
	public String toFile(){
		
		return sifraStavke + "|" + racun.getSifraRacuna() + "|" +vozilo.getSifra();
	}

	@Override
	public String toString() {
		return "Stavka [sifraStavke=" + sifraStavke + ", racun=" + racun.getSifraRacuna()
				+ ", vozilo=" + vozilo.getSifra() + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((racun == null) ? 0 : racun.hashCode());
		result = prime * result + sifraStavke;
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
		Stavka other = (Stavka) obj;
		if (racun == null) {
			if (other.racun != null)
				return false;
		} else if (!racun.equals(other.racun))
			return false;
		if (sifraStavke != other.sifraStavke)
			return false;
		return true;
	}
	
	


	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Stavka.counter = counter;
	}

	public int getSifraStavke() {
		return sifraStavke;
	}

	public void setSifraStavke(int sifraStavke) {
		this.sifraStavke = sifraStavke;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}
	
	




 
 
	

}
