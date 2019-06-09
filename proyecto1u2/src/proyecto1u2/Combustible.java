package proyecto1u2;

public class Combustible {
	
	String combustible;
	double efecto;
	int velocidad;

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
	
	public double efectoDegradacion (String combustible, double vel_actual) {
		
		if(combustible.equals("Nuclear")){
			efecto = (vel_actual*(0.5));
		}
		else if(combustible.equals("Disel")) {
			efecto = (vel_actual*(0.25));

		}
		else if(combustible.equals("Biodisel")) {
			efecto = (vel_actual*(0.10));

		}
		return efecto;
	}
	
	public double velocidadInicial (String combustible){
		
		if(combustible.equals("Nuclear")){
			velocidad = 20;
		}
		else if(combustible.equals("Disel")) {
			velocidad = 10;

		}
		else if(combustible.equals("Biodisel")) {
			velocidad = 5;

		}
		return velocidad;
	}

}
