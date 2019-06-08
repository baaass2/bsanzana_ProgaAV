package proyecto1u2;

public class Random {

	//(N-M+1)+M) M<N random en intervalo//
	int nrandom; 
	
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


}
