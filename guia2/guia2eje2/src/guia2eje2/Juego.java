package guia2eje2;
import java.util.Scanner;

public class Juego {
	
	String dir;
	String lanzar;
	int turnoj = 0;
	int marcador = 0;
	int tiro;
	int ener = 0;
	int menosener = 0;
	int enerenemigo = 0;
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
	public void Setear_energia(int turno) {
		if (turno == 2) {
			ener = rand.randomizador(1);
			jugador1.setEnergia(ener);
			ener = rand.randomizador(1);
			cpu.setEnergia(ener);
		}
		else if (turno == 1) {
			ener = rand.randomizador(1);
			jugador1.setEnergia(ener);
		}
		else if (turno == 0) {
			ener = rand.randomizador(1);
			cpu.setEnergia(ener);
		}
	}
	
	public void Empezar() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Tie Break Jugador 1 vs CPU\n");
		System.out.println("Jugador 1 Seleccione lanzamiento: \n"
				+ "a) Izquerda\n"
				+ "s) Centro\n"
				+ "d) Derecha\n");
		System.out.println("Energia de comienzo j1: "+ jugador1.getEnergia());
		dir = sc.nextLine();
		System.out.println("!!W PARA LANZAR¡¡");
		lanzar = sc.nextLine();
		tiro = rand.randomizador(2);
		marcador = quepaso.QuePaso(tiro);
		controlenergia(marcador, 1);
		end = marcadorgeneral(marcador, 1);
		
		while(end != 1) {
			while(turnoj < 2 && end != 1) {
				sacante = 0;
				System.out.println("CPU está efectuando tiro\n");
				tiro = rand.randomizador(2);
				marcador = quepaso.QuePaso(tiro);
				if(marcador == 0) {
					enerenemigo = jugador1.getEnergia();
					if(enerenemigo == 0) {
						marcador = 1;
					}
				}
				else{
					controlenergia(marcador, sacante);
				}
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
				System.out.println("!!W PARA LANZAR¡¡");
				lanzar = sc.nextLine();
				tiro = rand.randomizador(2);
				marcador = quepaso.QuePaso(tiro);
				if(marcador == 0) {
					enerenemigo = cpu.getEnergia();
					if(enerenemigo == 0) {
						marcador = 1;
					}
				}
				else {
					controlenergia(marcador, sacante);
				}
				end = marcadorgeneral(marcador, sacante);
				turnoj = turnoj + 1;
			}
			turnoj = 0;			
		}
		
		
		sc.close();	
	}
	
	public int marcadorgeneral(int marcador, int turno) {

		int end = 0;
		int puntosj1 = jugador1.getMarcador();
		int puntoscpu = cpu.getMarcador();

		if(turno == 0) {
			puntoscpu = puntoscpu + marcador;
			if(puntoscpu < 0) {
				puntoscpu = 0;
			}
			cpu.setMarcador(puntoscpu);
			System.out.println("Energia actual de cpu: "+ cpu.getEnergia());
			System.out.println("Puntos de cpu: "+ cpu.getMarcador());

		}
		else if(turno == 1) {
			puntosj1 = puntosj1 + marcador;
			if(puntosj1 < 0) {
				puntosj1 = 0;
			}
			jugador1.setMarcador(puntosj1);
			System.out.println("Energia actual de j1: "+ jugador1.getEnergia());
			System.out.println("Puntos de j1: "+jugador1.getMarcador());

		}
		
		puntosj1 = jugador1.getMarcador();
		puntoscpu = cpu.getMarcador();
		
		end = revision.Revision(puntosj1, puntoscpu);
		
		
		return end;
		
	}
	
	public void controlenergia(int marcador, int turno) {
		int ener;
		int menosener;

		if (turno == 1) {
			if(marcador < 0) {
				ener = jugador1.getEnergia();
				menosener = rand.randomizador(3);
				ener = ener - menosener;
				jugador1.setEnergia(ener);

			}
			else if(marcador ==  1){
				Setear_energia(turno);
			}
		}
		else if (turno == 0) {
			if(marcador < 0) {
				ener = cpu.getEnergia();
				menosener = rand.randomizador(3);
				ener = ener - menosener;
				cpu.setEnergia(ener);

			}
			else if(marcador ==  1){
				Setear_energia(turno);
			}
		}

	}

}
