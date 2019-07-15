package proyecto22;

public class Ambulancia {
	
	private String dondeEsta;
	
	public int reparacionAlas(int estadoAlas, int matricula) {
		int estadoAlas_final=estadoAlas;
		
		if(estadoAlas <= 20) {
			System.out.println("Esta en la ambuluancia, la nave: " +matricula);
			estadoAlas_final = 100;
		}
		
		return estadoAlas_final;
	}
	
	public int reparacionMotor(int saludMotor, int matricula) {
		int saludMotor_final = saludMotor;
		
		if(saludMotor <= 20) {
			System.out.println("Esta en la ambuluancia, la nave: " +matricula);
			saludMotor_final = 100;
		}
		
		return saludMotor_final;
	}

	public String getDondeEsta() {
		return dondeEsta;
	}

	public void setDondeEsta(String dondeEsta) {
		this.dondeEsta = dondeEsta;
	}
	
	

}
