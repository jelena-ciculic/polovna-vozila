package jwd.prodavnica.model;

import java.util.StringTokenizer;

import jwd.prodavnica.ui.KategorijaUi;

public class Motocikl extends Vozilo {
	
	
	protected int kubikaza;
	protected String snagaMotora;
	protected String tipGoriva;
	
	public Motocikl() {
		super();
		
	}
	public Motocikl(String sifra, String naslovOglasa, double cena,
			Kategorija kategorijaVozila, String opis, boolean stanje,
			boolean obrisan,int kubikaza, String snagaMotora, String tipGoriva) {
		super(sifra, naslovOglasa, cena, kategorijaVozila, opis, stanje, obrisan);
		this.kubikaza  = kubikaza;
		this.snagaMotora  = snagaMotora;
		this.tipGoriva = tipGoriva;
		
	}
	
	public Motocikl(String text){
		
		StringTokenizer st = new StringTokenizer(text, "|");
		
		while(st.hasMoreTokens()){
			sifra = st.nextToken();
			naslovOglasa = st.nextToken();
			cena = Double.parseDouble(st.nextToken());
			String sifraKategorije = st.nextToken();
			//
			kategorijaVozila=KategorijaUi.pronadjiPoSifri(sifraKategorije);
			opis = st.nextToken();
			stanje = Boolean.parseBoolean(st.nextToken());
			obrisan = Boolean.parseBoolean(st.nextToken());
			kubikaza = Integer.parseInt(st.nextToken());
			snagaMotora = st.nextToken();
			tipGoriva = st.nextToken();
		}
	}
	
	public String toFile(){
		
		String retVal = super.toFile();
		
		return retVal + "|" + kubikaza + "|" + snagaMotora + "|" + tipGoriva;
	}
	@Override
	public String toString() {
		
		String retVal = super.toString();
		
		return  retVal + "|" + kubikaza + "|" + snagaMotora + "|" + tipGoriva;
	}
	
	
	
	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}
	public int getKubikaza() {
		return kubikaza;
	}
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}
	public String getSnagaMotora() {
		return snagaMotora;
	}
	public void setSnagaMotora(String snagaMotora) {
		this.snagaMotora = snagaMotora;
	}
	public String getTipGoriva() {
		return tipGoriva;
	}
	public void setTipGoriva(String tipGoriva) {
		this.tipGoriva = tipGoriva;
	}
	
	
	
	
	
	

}
