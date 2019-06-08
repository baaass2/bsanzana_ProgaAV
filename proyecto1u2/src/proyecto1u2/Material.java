package proyecto1u2;

public class Material {
	
	String material;

	public String tipoMaterial (int opcion) {
		
		if(opcion == 1) {
			material = "plastico";
		}
		else if(opcion == 2) {
			material = "Madera";
		}
		else if(opcion == 3) {
			material = "Metal";
		}
		return material;
	}

}

