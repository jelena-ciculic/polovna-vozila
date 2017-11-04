package jwd.prodavnica.model;

import java.util.StringTokenizer;


import jwd.prodavnica.ui.KategorijaUi;

public class Bicikl extends Vozilo {
	
	protected int brojBrzina;
	

	

	public Bicikl(String sifra, String naslovOglasa, double cena,
			Kategorija kategorijaVozila, String opis, boolean stanje, boolean obrisan, int brojBrzina) {
		super(sifra, naslovOglasa, cena, kategorijaVozila, opis, stanje,obrisan);
		this.brojBrzina = brojBrzina; 
		
	}
	
	public Bicikl(String text){
		
	StringTokenizer st = new StringTokenizer(text,"|");
	while(st.hasMoreTokens()){
		sifra = st.nextToken();
		naslovOglasa = st.nextToken();
		cena = Double.parseDouble((st.nextToken()));
		String sifraKategorije = st.nextToken();
		kategorijaVozila = KategorijaUi.pronadjiPoSifri(sifraKategorije);
		opis = st.nextToken();
		stanje = Boolean.parseBoolean(st.nextToken());
		obrisan = Boolean.parseBoolean(st.nextToken());
		brojBrzina = Integer.parseInt(st.nextToken());
		
	}
		
				
	}
	
	

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		
		String retVal = super.toString();
		
		return retVal + "|" + brojBrzina;
	}
	
	public String toFile(){
		
		String retVal = super.toFile();
		
		return retVal+"|"+brojBrzina;
	}

	public int getBrojBrzina() {
		return brojBrzina;
	}

	public void setBrojBrzina(int brojBrzina) {
		this.brojBrzina = brojBrzina;
	}
	
	
	
	


	

	
	
	
	


	
	
	
	
	

}
