package proyecto1u2;

public class Nave {
	
	private int matricula;
	private double vel_actual;
	private double kmRecorridos;
	private String combustible;
	private String tipo_alas;
	private int estadoAlas; // porcentaje de degradacion 
	private int puesto;
	
	
	
	
	public int getEstadoAlas() {
		return estadoAlas;
	}

	public void setEstadoAlas(int estadoAlas) {
		this.estadoAlas = estadoAlas;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public double getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public double getVel_actual() {
		return vel_actual;
	}

	public void setVel_actual(double vel_actual) {
		this.vel_actual = vel_actual;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getTipo_alas() {
		return tipo_alas;
	}

	public void setTipo_alas(String tipo_alas) {
		this.tipo_alas = tipo_alas;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
