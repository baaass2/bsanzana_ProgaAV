package guia2eje2;

public class Tiro {
	
	int punto = 0;
	
	public int QuePaso(int tiro) {
	
		if(tiro == 1){
			System.out.println("La pelota cayó dentro de la "
					+ "cancha, por lo que se sigue jugando.\n");
			punto = 0;
		}
		else if(tiro == 2){
			System.out.println("Se quedó la pelota en la red "
					+ "y pierde el punto el jugador que falló.\n");
			punto = -1;
		}
		else if(tiro == 3){
			System.out.println("La pelota cayó fuera de la cancha "
					+ "y pierde el punto el jugador que falló.\n");
			punto = -1;
		}
		else if(tiro == 4){
			System.out.println("Tiro ganador, el jugador que "
					+ "efectuó el tiro gana el punto\n");
			punto = 1;
		}
		
		return punto;
	}

}
