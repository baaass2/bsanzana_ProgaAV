package guia2eje2;
import java.util.Scanner;

public class Juego {
	
	String dir;
	String jugador = "Turno de Jugador 1";
	String cpu1 = "Turno de CPU";
	int turnoj = 0;
	int marcador = 0;
	int tiro;
	int ener = 0;
	int turno = 0;
	int end = 0;
	int salir = 0;
	int sacante = 0;

	
	
	
	Jugador jugador1 = new Jugador();
	Jugador cpu = new Jugador();
	Random rand = new Random();
	Tiro quepaso = new Tiro();
	Puntos revision = new Puntos();
	
	public void Setear_marcador() {
		jugador1.setMarcador(0);
		cpu.setMarcador(0);
	}
	
	public void Empezar() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Tie Break Jugador 1 vs CPU\n");
		System.out.println("Jugador 1 Seleccione lanzamiento: \n"
				+ "a) Izquerda\n"
				+ "s) Centro\n"
				+ "d) Derecha\n");
		dir = sc.nextLine();
		tiro = rand.randomizador(2);
		marcador = quepaso.QuePaso(tiro);
		end = marcadorgeneral(marcador, 1);
		
		while(end != 1) {
			while(turnoj < 2 && end != 1) {
				sacante = 0;
				System.out.println("CPU está efectuando tiro\n");
				tiro = rand.randomizador(2);
				marcador = quepaso.QuePaso(tiro);
				end = marcadorgeneral(marcador, sacante);
				turnoj = turnoj + 1;
			}
			turnoj = 0;
			
			while(turnoj < 2 && end != 1) {
				sacante = 1;
				System.out.println("Jugador 1 Seleccione lanzamiento: \n"
						+ "a) Izquerda\n"
						+ "s) Centro\n"
						+ "d) Derecha\n");
				dir = sc.nextLine();
				tiro = rand.randomizador(2);
				marcador = quepaso.QuePaso(tiro);
				end = marcadorgeneral(marcador, sacante);
				turnoj = turnoj + 1;
			}
			turnoj = 0;			
		}
		
		
		sc.close();	
	}
	
	public int marcadorgeneral(int marcador, int turno) {
		System.out.println("El marcador "+marcador);

		int end = 0;
		int puntosj1 = jugador1.getMarcador();
		int puntoscpu = cpu.getMarcador();

		if(turno == 0) {
			puntoscpu = puntoscpu + marcador;
			if(puntoscpu < 0) {
				puntoscpu = 0;
			}
			cpu.setMarcador(puntoscpu);
			System.out.println("El marcador de cpu: "+ cpu.getMarcador());

		}
		else if(turno == 1) {
			puntosj1 = puntosj1 + marcador;
			if(puntosj1 < 0) {
				puntosj1 = 0;
			}
			jugador1.setMarcador(puntosj1);
			System.out.println("El marcador de j1: "+jugador1.getMarcador());

		}
		
		puntosj1 = jugador1.getMarcador();
		puntoscpu = cpu.getMarcador();
		
		end = revision.Revision(puntosj1, puntoscpu);
		
		
		return end;
		
		
	}

}
