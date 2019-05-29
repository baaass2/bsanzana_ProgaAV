package guia2e1;
import java.util.Scanner;

public class Menu {
	
	String opc;
	String jugador;
	String mano;	
	String [] opciones = new String[4];
	
	Juego jugador1 = new Juego();
	Juego jugador2 = new Juego();
	private String [] elementos;

	
	void imprimir_menu(){
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<4; i++) {
			if(i==0) {
				jugador = "Jugador 1";
				mano = "Derecha";
			}
			else if(i==1) {
				jugador = "Jugador 2";
				mano = "Derecha";			
			}
			else if(i==2) {
				jugador = "Jugador 1";
				mano = "Izquerda";			
			}
			else if(i==3) {
				jugador = "Jugador 2";
				mano = "Izquerda";			
			}
			
			System.out.println("-----------TURNO DE " +jugador+ " Mano a jugar: "+mano+" -----------\n");
			System.out.println("1) Tijera\n"
					+ "2) Papel\n"
					+ "3) Piedra\n");
			System.out.println("-------------------------------------------------------------------\n");

			System.out.println("Elija opción 1, 2 ó 3\n");
			opc = sc.nextLine();
			opciones[i] = opc;
		}
		sc.close();
	}
	
	void setear_jugadores(){
		
		jugador1.setMano_derecha(opciones[0]);
		jugador2.setMano_derecha(opciones[1]);
		jugador1.setMano_izquerda(opciones[2]);
		jugador2.setMano_izquerda(opciones[3]);
		
		String mdj1 = jugador1.getMano_derecha();
		String mdj2 =  jugador2.getMano_derecha();
		String resultado_md = condiciones(mdj1, mdj2);
		String mij1 = jugador1.getMano_izquerda();
		String mij2 = jugador2.getMano_izquerda();
		String resultado_mi = condiciones(mij1, mij2);
		
		
		if(resultado_md == resultado_mi && resultado_md != "0") {
			System.out.printf("GANADOR EL JUGADOR "+resultado_md);
		}
		else if(resultado_mi == "0" && resultado_md == "0") {
			System.out.printf("EMPATE \n");
		}
		else if(resultado_mi == "1" && resultado_md == "0") {
			System.out.printf("GANADOR EL JUGADOR "+resultado_mi);
		}
		else if(resultado_mi == "0" && resultado_md == "2") {
			System.out.printf("GANADOR EL JUGADOR "+resultado_md);
		}
		else {
			System.out.printf("EMPATE \n");
		}


	}
	
	public String condiciones(String manoj1, String manoj2) {
		String resultado = null;
		elementos = new String[] {"Tijera", "Piedra", "Papel"};
		
		if(manoj1.equals("1")){
			manoj1 = elementos[0];
		}
		else if(manoj1.equals("2")) {
			manoj1 = elementos[1];
		}
		else if(manoj1.equals("3")){
			manoj1 = elementos[2];
		}
		if(manoj2.equals("1")) {
			manoj2 = elementos[0];
		}
		else if(manoj2.equals("2")) {
			manoj2 = elementos[1];
		}
		else if(manoj2.equals("3")){
			manoj2 = elementos[2];
		}	
		
		if(manoj1 == manoj2) {
			resultado = "0";
		}
		else if(manoj1.equals("Tijera") && manoj2.equals("Papel")) {
			resultado = "1";
		}
		else if(manoj1.equals("Tijera") && manoj2.equals("Piedra")) {
			resultado = "2";
		}
		else if(manoj1.equals("Papel") && manoj2.equals("Tijera")) {
			resultado = "2";
		}
		else if(manoj1.equals("Papel") && manoj2.equals("Piedra")) {
			resultado = "1";
		}
		else if(manoj1.equals("Piedra") && manoj2.equals("Tijera"))       {
			resultado = "1";
		}
		else if(manoj1.equals("Piedra") && manoj2.equals("Papel")) {
			resultado = "2";
		}
		return resultado;

	}

	

}
