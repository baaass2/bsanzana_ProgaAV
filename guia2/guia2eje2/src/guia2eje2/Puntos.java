package guia2eje2;

public class Puntos {
	
	
	public int Revision(int puntosj1, int puntoscpu) {
		int end = 0;
		
		if(puntosj1 < puntoscpu) {
			puntosj1 = puntosj1 + 2;
			if(puntosj1 == puntoscpu) {
				end = 1;
			}
			else {
				end = 0;
			}
			
		}
		else if(puntosj1 > puntoscpu) {
			puntoscpu = puntoscpu + 2;
			if(puntosj1 == puntoscpu) {
				end = 1;
			}
			else {
				end = 0;
			}
			
		}
		else {
			end = 0;
		}
		
		return end;
		
	}

}
