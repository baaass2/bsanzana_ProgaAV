package proyecto1u2;

public class Alas {
	
	double efecto;
	int degradacion;

	public double efectoDegradacion (String material, double vel_actual, double degradacion) {
		if(degradacion < 70) {
			
			if(material.equals("plastico")){
				efecto = (vel_actual*(0.1));
			}
			else if(material.equals("Madera")) {
				efecto = (vel_actual*(0.05));
	
			}
			else if(material.equals("Metal")) {
				efecto = (vel_actual*(0.02));
	
			}
		}
		else {
			efecto = 0;
		}
		return efecto;
	}
	
	
	public int calcularDegradacion (double vel_actual, int estadoAlas) {
		
		if(vel_actual < 50){
			degradacion = estadoAlas - 2;
		}
		else if(vel_actual >= 50 && vel_actual < 100) {
			degradacion = estadoAlas - 10 ;
		}
		else if(vel_actual >= 100) {
			degradacion = estadoAlas - 20;
		}
		return degradacion;
	}


}
