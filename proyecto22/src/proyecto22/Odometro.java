package proyecto22;

public class Odometro {
	
	private double vel_actual;
	private double Aceleracion;
	private double kmRecorridos;
	
	
	public double calcularVelocidad (double efectoAlas, double efectoCombustible, double velocidad) {
		
		double velocidad_final;
		double efectoTotal;
		
		efectoTotal = efectoCombustible + efectoAlas;
		
		velocidad_final = velocidad + efectoTotal;
		
		return velocidad_final;
		
	}
	
	public double calcularRecorrido (double velocidad, double kmRecorridos) {
		double kmRecorridos_final = 0;
		
		kmRecorridos_final = velocidad + kmRecorridos;
		
		return kmRecorridos_final;
	}
	
	public double calcularAceleracion (double velocidad_final, double velocidad_inicial) {
		
		double aceleracion;
		
		
		
		return aceleracion;
		
	}
	
	
	public double getAceleracion() {
		return Aceleracion;
	}

	public void setAceleracion(double aceleracion) {
		this.Aceleracion = aceleracion;
	}

	public double getVel_actual() {
		return vel_actual;
	}
	public void setVel_actual(double vel_actual) {
		this.vel_actual = vel_actual;
	}
	public double getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

}
