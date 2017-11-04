package jwd.prodavnica.model;

import java.util.StringTokenizer;

public class Korisnik {
	
	private String korisnickoIme;
	private String lozinka;
	private String ime;
	private String prezime;
	private String uloga;
	public Korisnik() {
		super();
		
	}
	public Korisnik(String korisnickoIme, String lozinka, String ime,
			String prezime, String uloga) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.uloga = uloga;
	}
	
	
	public Korisnik(String text){
		
		StringTokenizer st = new StringTokenizer("|");
		while(st.hasMoreTokens()){
			korisnickoIme = st.nextToken();
			lozinka=st.nextToken();
			ime=st.nextToken();
			prezime=st.nextToken();
			uloga=st.nextToken();
			
		}
	}
	
	public String tofile(){
		return korisnickoIme+ "|" +lozinka+"|" +ime +"|" +prezime+"|"+ uloga;
	}
	@Override
	public String toString() {
		return "Korisnik [korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", uloga=" + uloga + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((korisnickoIme == null) ? 0 : korisnickoIme.hashCode());
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
		Korisnik other = (Korisnik) obj;
		if (korisnickoIme == null) {
			if (other.korisnickoIme != null)
				return false;
		} else if (!korisnickoIme.equals(other.korisnickoIme))
			return false;
		return true;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	
	
	

}
