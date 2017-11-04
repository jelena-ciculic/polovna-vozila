package jwd.prodavnica.model;

public abstract class Vozilo {
	
	protected String sifra;
	protected String naslovOglasa;
	protected double cena;
	protected Kategorija kategorijaVozila;
	protected String opis;
	protected boolean stanje;
	protected boolean obrisan;
	
	public Vozilo() {
		super();
		this.stanje=false;
		this.obrisan=false;
	}
	public Vozilo(String sifra, String naslovOglasa, double cena,
			Kategorija kategorijaVozila,String opis, boolean stanje,boolean obrisan) {
		super();
		this.sifra = sifra;
		this.naslovOglasa = naslovOglasa;
		this.cena = cena;
		this.kategorijaVozila = kategorijaVozila;
		this.opis= opis;
		this.stanje = stanje;
		this.obrisan = obrisan;
	}
	
	
	@Override
	public String toString() {
		return 
				this.getSifra() + "|" + this.getNaslovOglasa() + "|" + this.getCena() + "|" 
				+ this.getKategorijaVozila().getSifraKategorije() +
				"|" + this.getOpis()+ "|"
				+( (this.isStanje()==false)?"na lageru":"prodat") + "|"
				+ ((this.isObrisan()==false)?"neobrisan":"obrisan");
	}
	
	public String toFile(){
		return sifra + "|" + naslovOglasa + "|" + cena + "|" + 
				kategorijaVozila.getSifraKategorije() + "|" + opis + "|" + stanje + "|" + obrisan;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
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
		Vozilo other = (Vozilo) obj;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaslovOglasa() {
		return naslovOglasa;
	}
	public void setNaslovOglasa(String naslovOglasa) {
		this.naslovOglasa = naslovOglasa;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public Kategorija getKategorijaVozila() {
		return kategorijaVozila;
	}
	public void setKategorijaVozila(Kategorija kategorijaVozila) {
		this.kategorijaVozila = kategorijaVozila;
	}
	public boolean isStanje() {
		return stanje;
	}
	public void setStanje(boolean stanje) {
		this.stanje = stanje;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public boolean isObrisan() {
		return obrisan;
	}
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	public static int compareCena(double cena1, double cena2){
		
		if((cena1-cena2)>0)
			return 1;
		if((cena1-cena2)<0)
			return -1;
		else
			return 0;
		
	}
	
	

	
	

}
