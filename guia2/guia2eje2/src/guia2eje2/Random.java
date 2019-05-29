package guia2eje2;

public class Random {

	//(N-M+1)+M) M<N random en intervalo//
	int nrandom; 
	
	public int randomizador(int opcion) {
		if(opcion == 1) {
			nrandom = (int) Math.floor(Math.random()*(6)+5);
		}
		else if(opcion == 2) {
			nrandom = (int) Math.floor(Math.random()*(4)+1);
		}
		else if(opcion == 3) {
			nrandom = (int) Math.floor(Math.random()*(2)+1);
		}

		
		return nrandom;
			
	}


}
