package proyecto1u2;

import java.util.ArrayList;

public class Carrera {
	
	private ArrayList<Nave> naves = new ArrayList();

	int nrand;
	String sng;
	int largoPista = 500; //km
	int ganador=0;
	int puesto=0;

	
	Random rand = new Random();
	Combustible cbtible = new Combustible(); 
	Material mrial = new Material(); 
	Alas alas1 = new Alas();

	
	Carrera(){

			ensamblarNaves();
			while(ganador != 1 ) {
				revisarDegradacion();
				ganador = velocidadNaves();
				mostrarParticipantes();
				 try {
		                Thread.sleep(5000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }

			}
			premiacion();

		}
	
	public void ensamblarNaves() {
		
		for(int i=0; i<4; i++) {
			Nave nave2 = new Nave();
			nrand = rand.randomizador(1);
			nave2.setMatricula(nrand);
			nrand = rand.randomizador(2);
			sng = cbtible.tipoCombustible(nrand);
			nave2.setCombustible(sng);
			nrand = rand.randomizador(2);
			sng = mrial.tipoMaterial(nrand);
			nave2.setTipo_alas(sng);
			nave2.setVel_actual(40);
			nave2.setKmRecorridos(0);
			nave2.setPuesto(0);
			nave2.setEstadoAlas(100);

			Incribirse(nave2);
		}
	}

	public void Incribirse(Nave nave) {
		
		naves.add(nave);
	}
	
	public void revisarDegradacion() {
		double vel_actual;
		int estadoAlas;
		
		for (Nave i: naves) {
			if(i.getPuesto() == 0) {
				vel_actual = i.getVel_actual();
				estadoAlas = i.getEstadoAlas();
				estadoAlas = alas1.calcularDegradacion(vel_actual, estadoAlas);
				i.setEstadoAlas(estadoAlas);
				
			}
			
		}
	}
	
	public int velocidadNaves() {
		
		double vel_actual;
		double kmRecorridos_actual;
		double kmRecorridos_pasados;
		double efecto_alas;
		double efecto_combustible;
		double efecto_total;
		double estadoAlas;
		int ganador=0;
		
		String material;
		String combustible;
				
		for (Nave i: naves) {
			if(i.getPuesto() == 0) {
				vel_actual = i.getVel_actual();
				material = i.getTipo_alas();
				combustible = i.getCombustible();
				estadoAlas = i.getEstadoAlas();
				efecto_alas = alas1.efectoDegradacion(material, vel_actual, estadoAlas);
				efecto_combustible = cbtible.efectoDegradacion(combustible, vel_actual);
				efecto_total = efecto_combustible - efecto_alas;
				vel_actual = vel_actual + efecto_total;
				i.setVel_actual(vel_actual);
				kmRecorridos_pasados = i.getKmRecorridos();
				kmRecorridos_actual = vel_actual + kmRecorridos_pasados;  
				i.setKmRecorridos(kmRecorridos_actual);
				
				if(kmRecorridos_actual >= 500){
					puesto = puesto + 1; 
					i.setPuesto(puesto);			
				}
			}
		}
		if(puesto == 4) {
			ganador = 1;
		}

		return ganador;
	}
	
	public void mostrarParticipantes() {
		
		for (Nave i: naves) { 
			if(i.getPuesto() == 0) {
				System.out.println("--------------------------------------");
				System.out.println("Nave: "+i.getMatricula());
				//System.out.println(i.getCombustible());
				//System.out.println(i.getTipo_alas());
				System.out.println("porcentaje de degradacion: " + i.getEstadoAlas());
				System.out.println("Vel_actual: "+i.getVel_actual());
				System.out.println("KmRecorridos: "+ i.getKmRecorridos());
				System.out.println("--------------------------------------");


			}
		}
	}

	public void premiacion() {
		System.out.println("木木木木木木木木木木木木木木木木木木木木木木木木");

		for (Nave i: naves) {
			if(i.getPuesto() == 1) {
				System.out.println("Primer lugar Nave: "+i.getMatricula());
			}
			else if(i.getPuesto() == 2) {
				System.out.println("Segundo lugar Nave: "+i.getMatricula());				
			}
			else if(i.getPuesto() == 3) {
				System.out.println("Tercer lugar Nave: "+i.getMatricula());				
			}
			else if(i.getPuesto() == 4) {
				System.out.println("Cuarto lugar Nsave: "+i.getMatricula());		
			}	
		}
		System.out.println("木木木木木木木木木木木木木木木木木木木木木木木木");

	}
}
