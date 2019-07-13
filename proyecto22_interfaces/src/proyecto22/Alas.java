package proyecto22;

public class Alas {
	
	private int estadoAlas;
	private String tipoAlas;
	
	
	public double efectoDegradacion (String material, double velocidad, int estadoAlas) {
		double efecto=0;
		
		if( estadoAlas < 70) {
			if(material.equals("Plastico")){
				efecto = (velocidad*(-0.1));
			}
			else if(material.equals("Madera")) {
				efecto = (velocidad*(-0.05));
	
			}
			else if(material.equals("Metal")) {
				efecto = (velocidad*(-0.02));
	
			}
		}
		
		else {
			efecto = 0;
		}
		
		return efecto;
	}
	
	public int calcularDegradacion (double velocidad, int estadoAlas) {
		int degradacion = 0;
		
		if(velocidad < 50){
			degradacion = estadoAlas - 2;
		}
		else if(velocidad >= 50 && velocidad < 100) {
			degradacion = estadoAlas - 10 ;
		}
		else if(velocidad >= 100) {
			degradacion = estadoAlas - 20;
		}
		return degradacion;
	}
	
	
	public int getEstadoAlas() {
		return estadoAlas;
	}
	public void setEstadoAlas(int estadoAlas) {
		this.estadoAlas = estadoAlas;
	}
	public String getTipoAlas() {
		return tipoAlas;
	}
	public void setTipoAlas(String tipoAlas) {
		this.tipoAlas = tipoAlas;
	}
	
	

}
