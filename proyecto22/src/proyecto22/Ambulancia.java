package proyecto22;

public class Ambulancia {
	
	
	public int reparacionAlas(int estadoAlas, int matricula) {
		int estadoAlas_final=estadoAlas;
		
		if(estadoAlas <= 20) {
			System.out.println("ESTA EN AL AMBULANCIA LA NAVE: " +matricula);
			estadoAlas_final = 100;
		}
		
		return estadoAlas_final;
	}
	
	public int reparacionMotor(int saludMotor, int matricula) {
		int saludMotor_final = saludMotor;
		
		if(saludMotor <= 20) {
			System.out.println("ESTA EN AL AMBULANCIA LA NAVE: " +matricula);
			saludMotor_final = 100;
		}
		
		return saludMotor_final;
	}

}
