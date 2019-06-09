package proyecto1u2;

public class Motor {
	
	int SaludMotor;
	
	public int calcularSaludMotor (String combustible, double kmRecorridos, double vel_actual ) {

		if(combustible.equals("Nuclear")){
			if(kmRecorridos > 1000 && vel_actual > 100) {
				System.out.println("calcularSaludMotor: " + vel_actual );

				SaludMotor = 0;
			}
			else {
				SaludMotor = 100;
			}
		}
		else if(combustible.equals("Disel")) {
			if(kmRecorridos > 1000 && vel_actual > 200 ) {
				System.out.println("calcularSaludMotor: " + vel_actual );

				SaludMotor = 0;
			}
			else {
				SaludMotor = 100;
			}
		}
		else if(combustible.equals("Biodisel")) {

			if(kmRecorridos > 1000 && vel_actual > 300 ) {
				System.out.println("calcularSaludMotor: " + vel_actual );

				SaludMotor = 0;
			}
			else {
				SaludMotor = 100;
			}
			
	
		}
		
		return SaludMotor;
	}

}
