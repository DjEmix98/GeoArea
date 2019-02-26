package it.objectmethod.geo.controllodati;

import it.objectmethod.geo.domain.Citta;

public class ControlloDati {

	public static boolean controlloDati(Citta citta)
	{
		boolean check = true;

		if(citta.getCountryCode().isEmpty()
				||citta.getDistrict().isEmpty()||citta.getNome().isEmpty())
		{
			check = false;
		}
		System.out.println("check ="+check);
		return check;
	}
}
