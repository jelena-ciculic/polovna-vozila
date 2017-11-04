package jwd.prodavnica.utility;

import java.util.Comparator;

import jwd.prodavnica.model.Vozilo;

public class CenaKomparator implements Comparator<Vozilo> {
	
	protected int direction;
	
	

	public CenaKomparator(int direction) {
		
		if(direction!=1 && direction !=-1){
			direction=1;
		}
		this.direction = direction;
	}



	@Override
	public int compare(Vozilo o1, Vozilo o2) {
		
		int retVal = Vozilo.compareCena(o1.getCena(), o2.getCena());
		return retVal * direction;
	}

}
