package proyecto1u2;

public class Ambulancia {

	int saludElemento;
	
	
	public int Reparacion (String elemento) {
		
		if(elemento.equals("Motor")){
			System.out.println("CMMMM CONCHEMARE");

			saludElemento = 100;
		}
		else if(elemento.equals("Alas")) {
			saludElemento = 100;

		}

		return saludElemento;
	}
	
	

}
