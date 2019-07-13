package proyecto22;

public class Nave implements Vehiculo{
	
	private int matricula;
	private int puestoCarrera;
	private String dondeEsta;
	private Odometro od;
	private Alas alas;
	private Motor motor;
	
	Nave(){
		Odometro od = new Odometro();
		Alas alas = new Alas();
		Motor motor = new Motor();
		this.motor = motor;
		this.od = od;
		this.alas = alas;
		
	}
	
	public double calcularEfectos(double velocidad, int estadoAlas, String tipoAlas, String tipoCombustible) {
		double efectoAlas;
		double efectoCombustible;
		double velocidad_final;
		
		efectoAlas= alas.efectoDegradacion(tipoAlas, velocidad, estadoAlas);
		efectoCombustible = motor.efectoCombustible(tipoCombustible, velocidad);
		velocidad_final = od.calcularVelocidad(efectoAlas, efectoCombustible, velocidad);
		
		return velocidad_final;
	}
	public int calcularDegradacionAlas(double velocidad, String tipoAlas, int estadoAlas) {
		int estadoAlas_final;
		
		estadoAlas_final = alas.calcularDegradacion(velocidad, estadoAlas);
		
		return estadoAlas_final;
	}
	public int calcularSaludMotor(double velocidad, String tipoCombustible, int saludMotor) {
		int saludMotor_final;
		
		saludMotor_final = motor.calcularSaludMotor(velocidad, tipoCombustible, saludMotor);
		return saludMotor_final;
	}
	
	
	
	
	public Motor getMotor() {
		return motor;
	}

	public Alas getAlas() {
		return alas;
	}

	public Odometro getOd() {
		return od;
	}

	
	public int getPuestoCarrera() {
		return puestoCarrera;
	}

	public void setPuestoCarrera(int puestoCarrera) {
		this.puestoCarrera = puestoCarrera;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getDondeEsta() {
		return dondeEsta;
	}

	public void setDondeEsta(String dondeEsta) {
		this.dondeEsta = dondeEsta;
	}
}
