package proyecto22;

import java.util.ArrayList;

public class Locutor {
	
	int[] arrayMatricula =new int[2];
	double[] arrayVelocidad =new double[2];
	double[] arrayRecorrido =new double[2];
	int[] arrayPuesto =new int[2];


	int indice = 0;
	
	public void recibirInformacion(ArrayList<Nave> naves) {
		int matricula = 0;
		int puesto = 0;
		double velocidad = 0;
		double recorrido = 0;
		
		
		for (Nave i: naves) {
			matricula = i.getMatricula();
			puesto = i.getPuestoCarrera();
			velocidad = i.getOd().getVel_actual();
			recorrido = i.getOd().getKmRecorridos();
			
			arrayMatricula[indice] = matricula;
			arrayPuesto[indice] = puesto;
			arrayVelocidad[indice] = velocidad;
			arrayRecorrido[indice] = recorrido;
			indice = indice + 1;
		}
		indice = 0;		
	}	
	
	public void Locucion(int tiempo) {
		int diferenciaVelocidad = (int) (arrayVelocidad[0]-arrayVelocidad[1]);
		int diferenciaRecorrido = (int) (arrayRecorrido[0]-arrayRecorrido[1]);
		int distanciaMetaN0 = (int) (1000 - arrayRecorrido[0]);
		int distanciaMetaN1 = (int) (1000 - arrayRecorrido[1]);

		if(arrayPuesto[0] == 0 && arrayPuesto[1] == 0) {
			if(tiempo <= 5) {
				if(diferenciaRecorrido > 0) {
					System.out.println("Locutor: Comienza la partida y la nave "+arrayMatricula[0]+" va primero");
				}
				else if (diferenciaRecorrido < 0){
					System.out.println("Locutor: Comienza la partida y la nave "+arrayMatricula[1]+" va primero");
				}
				else if(diferenciaRecorrido == 0){
					
					System.out.println("Locutor: Comienza la partida y las naves van a la misma distancia del punto de partida");
				}
				if (diferenciaRecorrido > -1 && diferenciaRecorrido < 1) {
					System.out.println("Locutor: Es una diferencia de solo metros!!" );
				}
			}
			
			else if(tiempo <= 10) {
				if(diferenciaVelocidad > 0) {
					System.out.println("Locutor: La nave "+arrayMatricula[0]+" va con una velocidad superior");
				}
				else if (diferenciaVelocidad < 0){
					System.out.println("Locutor: La nave "+arrayMatricula[1]+" va con una velocidad superior");
				}
				else if(diferenciaVelocidad == 0){
					
					System.out.println("Locutor: las naves van a la misma velocidad");
				}
			}
			
			else if(tiempo <= 15) {
				System.out.println("Las naves "+arrayMatricula[0]+" y "+arrayMatricula[1]+" les falta para llegar a la meta "
						+ distanciaMetaN0+"km"+ " y "+distanciaMetaN1+"km"+ " respectivamente.");
			}
			else if (tiempo <=20) {
				if(diferenciaVelocidad > 0) {
					double razonVelocidad = (arrayVelocidad[0]/arrayVelocidad[1]);
					System.out.println("Locutor: !WOOOW! La nave "+arrayMatricula[0]+" va con una velocidad X"+razonVelocidad+" en razon"
							+ "con la nave contraria");
				}
				else if (diferenciaVelocidad < 0){
					double razonVelocidad = (double) (arrayVelocidad[1]/arrayVelocidad[0]);
					System.out.println("Locutor: !WOOOW! La nave "+arrayMatricula[1]+" va con una velocidad x"+razonVelocidad+" en razon"
							+" con la nave contraria");
				}
				else if(diferenciaVelocidad == 0){
					System.out.println("Locutor: las naves van a la misma velocidad");
				}
			}
			else if (tiempo <=25) {
				if(diferenciaRecorrido > 0) {
					System.out.println("Locutor: La nave "+arrayMatricula[0]+" va con una ventaja de "+diferenciaRecorrido+"km.");
				}
				else if (diferenciaRecorrido < 0){
					System.out.println("Locutor: La nave "+arrayMatricula[1]+" va con una ventaja de "+(-1*diferenciaRecorrido)+"km.");
				}
				else if(diferenciaRecorrido == 0){
					System.out.println("Locutor: Las naves van a la misma distancia.");
				}
			}
			else if(tiempo >= 60) {
				System.out.println("Todavia no hay ganadores pero estamos en los últimos kilometros, es una carrera reñida.");
			}
		}
		else if(arrayPuesto[0] != 0 || arrayPuesto[1] != 0) {
			
			if(tiempo >= 60 && tiempo <= 70) {
				if(arrayPuesto[0] == 0) {
					System.out.println("Locutor: Es una pena pero sacará 2do lugar la nave "+arrayMatricula[0]+" y le falta "
							+ distanciaMetaN0+"km para llegar a la meta.");
				}
				else if(arrayPuesto[1] == 0) {
					System.out.println("Locutor: Es una pena pero sacará 2do lugar la nave "+arrayMatricula[1]+" y le falta "
							+ distanciaMetaN1+"km para llegar a la meta.");
				}
			}
			
			if(tiempo > 70) {
				if(arrayPuesto[0] == 0) {
					System.out.println("Locutor: Le falta tan poco a la nave "+arrayMatricula[0]+" solo "
							+ distanciaMetaN0+"km para llegar a la meta.");
				}
				else if(arrayPuesto[1] == 0) {
					System.out.println("Locutor: Le falta tan poco a la nave "+arrayMatricula[1]+" solo "
							+ distanciaMetaN1+"km para llegar a la meta.");
				}
			}
		}
	}

}
