package proyecto1u2;

public class Animador {
	
	public void Locucion (int opcion, int matricula, String combustible, double vel_actual, double kmRec, int estadoAlas ) {
		
		System.out.println("|播音员播音员播音员播音员播音员播音员播音员播音员|");
		if(opcion == 1) {
			System.out.println("Locutor: Ohh no! la Nave "+matricula+" le ha explotado el motor"
					+ " iba a una velocidad "+vel_actual+" y su avance es "+kmRec+" km."
							+ " Y viene en camino la ambulancia");	
			
		}
		else if(opcion == 2) {
			System.out.println("Locutor: Ohh no! la Nave "+matricula+" tiene una "+estadoAlas+"% de Degradacion en las Alas"
					+ " la ambulancia va en camino.");
		}
		System.out.println("|播音员播音员播音员播音员播音员播音员播音员播音员|");

	}
}
