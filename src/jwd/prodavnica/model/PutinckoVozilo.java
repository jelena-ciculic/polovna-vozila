package jwd.prodavnica.model;

import java.util.ArrayList;
import java.util.StringTokenizer;

import jwd.prodavnica.ui.KategorijaUi;

public class PutinckoVozilo extends Vozilo {
	
	protected int kubikaza;
	protected String snagaMotora;
	protected String tipGoriva;
	protected String marka;
	protected String model;
	protected int brojVrata;
	protected ArrayList<String> oprema = new ArrayList<String>();
	
	public PutinckoVozilo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PutinckoVozilo(String sifra, String naslovOglasa, double cena,
			Kategorija kategorijaVozila, String opis, boolean stanje,boolean obrisan, 
			int kubikaza, String snagaMotora, String tipGoriva,
			String marka, String model, int brojVrata, ArrayList<String>oprema) {
		super(sifra, naslovOglasa, cena, kategorijaVozila, opis, stanje, obrisan);
		
		this.kubikaza = kubikaza;
		this.snagaMotora = snagaMotora;
		this.tipGoriva = tipGoriva;
		this.marka = marka;
		this.model = model;
		this.brojVrata = brojVrata;
		this.oprema  = oprema;
		
	}
	
	
	public PutinckoVozilo(String text){
		
		StringTokenizer st = new StringTokenizer(text,"|");
		
		String opremaString =null;
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
			marka = st.nextToken();
			model = st.nextToken();
			brojVrata = Integer.parseInt(st.nextToken());
			opremaString =st.nextToken();
		}
		
		StringTokenizer st1 = new StringTokenizer(opremaString, ";");
			//ArrayList<String> listaOpreme   = new ArrayList<String>();
		while(st1.hasMoreTokens()){
			oprema.add(st1.nextToken());
		}
		
		//oprema = listaOpreme;
		
		
		
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
		return  retVal + "|" + kubikaza + "|" + snagaMotora + "|" +
				tipGoriva + "|" + marka + "|" + model + "|" +brojVrata + "|" + oprema;
	}
	
	
	public String toFile(){
		
		String s1 = super.toFile();
		String s2 = s1 +  "|" + kubikaza + "|" + snagaMotora + "|" +
				tipGoriva + "|" + marka + "|" + model + "|" +brojVrata + "|";
		String s3 = "";
		for (String oprema  : this.getOprema()) {
			s3+=oprema+";";
		}
		
		return s2+s3;
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
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getBrojVrata() {
		return brojVrata;
	}
	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}
	public ArrayList<String> getOprema() {
		return oprema;
	}
	public void setOprema(ArrayList<String> oprema) {
		this.oprema = oprema;
	}
	
	
	
	
	
	

}
