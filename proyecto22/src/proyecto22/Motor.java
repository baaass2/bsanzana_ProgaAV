package proyecto22;

public class Motor {
	
	private int saludMotor;
	private String tipoCombustible;
	
	
	public double efectoCombustible (String tipoCombustible, double velocidad) {
		double efecto=1;
		
		if(tipoCombustible.equals("Nuclear")){
			efecto = (velocidad*(0.5));
		}
		else if(tipoCombustible.equals("Disel")) {
			efecto = (velocidad*(0.25));

		}
		else if(tipoCombustible.equals("Biodisel")) {
			efecto = (velocidad*(0.10));

		}
		return efecto;
	}
	
	public double velocidadInicial (String combustible){
		double velocidad;
		
		if(combustible.equals("Nuclear")){
			velocidad = 20;
		}
		else if(combustible.equals("Disel")) {
			velocidad = 10;

		}
		else if(combustible.equals("Biodisel")) {
			velocidad = 5;
		}
		else {
			velocidad = 0;
		}
		return velocidad;
	}
	
	public int calcularSaludMotor (double velocidad, String tipoCombustible, int saludMotor) {
		int saludMotor_final = saludMotor;
		
		if(tipoCombustible.equals("Nuclear")){
			if(velocidad >= 90) {
				saludMotor_final = saludMotor - 10;
			}
			else {
				saludMotor_final = saludMotor;
			}
		}
		else if(tipoCombustible.equals("Disel")) {
			if(velocidad >= 100 ) {
				saludMotor_final = saludMotor - 5;
			}
			else {
				saludMotor_final = saludMotor;
			}
		}
		else if(tipoCombustible.equals("Biodisel")) {

			if(velocidad >= 110 ) {
				saludMotor_final = saludMotor - 1;

			}
			else {
				saludMotor_final = saludMotor;
			}
			
	
		}
		
		return saludMotor_final;
	}
	
	
	
	
	
	
	public int getSaludMotor() {
		return saludMotor;
	}
	public void setSaludMotor(int saludMotor) {
		this.saludMotor = saludMotor;
	}
	public String getTipoCombustible() {
		return tipoCombustible;
	}
	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	
	

}
