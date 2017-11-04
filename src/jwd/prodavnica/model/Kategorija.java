package jwd.prodavnica.model;

public class Kategorija {
	
	protected String sifraKategorije;
	protected String naziv;
	protected String opis;
	protected Kategorija nadKategorija;
	protected  boolean obrisano;
	
	public Kategorija() {
		super();
		this.obrisano = false;
		// TODO Auto-generated constructor stub
	}
	public Kategorija(String sifraKategorije, String naziv, String opis,
			Kategorija nadKategorija,boolean obrisano) {
		super();
		this.sifraKategorije = sifraKategorije;
		this.naziv = naziv;
		this.opis = opis;
		this.nadKategorija = nadKategorija;
		this.obrisano = obrisano;
		
	}
	
	
	@Override
	public String toString() {
		if(nadKategorija == null){
			
			return sifraKategorije + "|" + naziv + "|" + opis+ "|" + ((obrisano==false)?"neobrisana":"obrisana");
		}else{
			
			return sifraKategorije + "|" + naziv + "|" + opis + 
					" Nadkategorija: [ " + nadKategorija.getSifraKategorije() + "|" +
					nadKategorija.getNaziv() + ((obrisano==false)?"neobrisana":"obrisana")
					+ " ]";
		}
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sifraKategorije == null) ? 0 : sifraKategorije.hashCode());
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
		Kategorija other = (Kategorija) obj;
		if (sifraKategorije == null) {
			if (other.sifraKategorije != null)
				return false;
		} else if (!sifraKategorije.equals(other.sifraKategorije))
			return false;
		return true;
	}
	public String getSifraKategorije() {
		return sifraKategorije;
	}
	public void setSifraKategorije(String sifraKategorije) {
		this.sifraKategorije = sifraKategorije;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Kategorija getNadKategorija() {
		return nadKategorija;
	}
	public void setNadKategorija(Kategorija nadKategorija) {
		this.nadKategorija = nadKategorija;
	}
	public boolean isObrisano() {
		return obrisano;
	}
	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}
	
	
	
	
	
	

}
