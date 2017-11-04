package jwd.prodavnica.utility;

import java.util.Comparator;

import jwd.prodavnica.model.Vozilo;

public class NazivKomparator implements Comparator<Vozilo> {
	
	protected int direction;
	

	@Override
	public int compare(Vozilo v1, Vozilo v2) {
		
		int retVal =v1.getNaslovOglasa().compareTo(v2.getNaslovOglasa()); 
		
		
		
		return retVal*direction;
	}


	public NazivKomparator(int direction) {
		if(direction !=1 && direction !=-1){
			direction = 1;
		}
		this.direction = direction;
	}

}
