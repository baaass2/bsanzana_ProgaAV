package proyecto22;

public interface Vehiculo {
	
	public double calcularEfectos(double velocidad, int estadoAlas, String tipoAlas, String tipoCombustible);
	public int calcularDegradacionAlas(double velocidad, String tipoAlas, int estadoAlas);
	public int calcularSaludMotor(double velocidad, String tipoCombustible, int saludMotor);


}
