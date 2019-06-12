package proyecto22;

public class Random {

	//(N-M+1)+M) M<N random en intervalo//
	int nrandom; 
	String material;
	String combustible;
	
	public int randomizador(int opcion) {
		if(opcion == 1) {
			nrandom = (int) Math.floor(Math.random()*(10000000)+1000000);
		}
		else if(opcion == 2) {
			nrandom = (int) Math.floor(Math.random()*(3)+1);
		}
		else if(opcion == 3) {
			nrandom = (int) Math.floor(Math.random()*(2)+1);
		}

		
		return nrandom;
			
	}
	
	public String tipoMaterial (int opcion) {
		
		if(opcion == 1) {
			material = "Plastico";
		}
		else if(opcion == 2) {
			material = "Madera";
		}
		else if(opcion == 3) {
			material = "Metal";
		}
		return material;
	}
	
	public String tipoCombustible (int opcion) {
		
		if(opcion == 1) {
			combustible = "Biodisel";
		}
		else if(opcion == 2) {
			combustible = "Nuclear";
		}
		else if(opcion == 3) {
			combustible = "Disel";
		}
		return combustible;
	}
	
	


}
