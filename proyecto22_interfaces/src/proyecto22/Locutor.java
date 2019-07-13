package proyecto22;

import java.util.ArrayList;

public class Locutor {
	
	int[] arrayMatricula =new int[2];
	int indice = 0;
	
	public void recibirInformacion(ArrayList<Nave> naves) {
		int matricula = 0;
		
		for (Nave i: naves) {
			matricula = i.getMatricula();
			arrayMatricula[indice] = matricula;
			indice = indice + 1;
		}
		indice = 0;
		
		for (int i=0; i<2; i++) {
			System.out.println("Locutor: "+arrayMatricula[i]);
		}
		
		
		
	}	
	

}
