package it.objectmethod.geo.checkparam;

public class OperatorValue {

	public static boolean valoreOperatore(String operatore) //true se � maggiore false se � minore
	{
		boolean bOperatore = true;
		try {
			if(operatore.compareToIgnoreCase("minore")==0)
			{
				return bOperatore = false;
			}
		}catch(java.lang.NullPointerException ex) {
			return bOperatore;
		}
		return bOperatore;
	}
}
