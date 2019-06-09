package proyecto1u2;

import java.util.ArrayList;

public class Carrera {
	
	private ArrayList<Nave> naves = new ArrayList();

	int nrand; // variable aux
	String sng; // variable aux
	int largoPista = 1500; //km
	int carreraEnd=0;
	int puesto=0;
		
	Random rand = new Random();
	Combustible cbtible = new Combustible(); 
	Material mrial = new Material(); 
	Alas alas1 = new Alas();
	Motor motor1 = new Motor();
	Ambulancia ambulancia = new Ambulancia();
	Animador animador1 = new Animador();

	
	Carrera(){

			ensamblarNaves();
			presentacionNaves();
			while(carreraEnd != 1 ) {
				calcularDegradacion();
				revisarDegradacion();
				carreraEnd = velocidadNaves();
				mostrarInformacion();
				 try {
		                Thread.sleep(5000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				 volver_aCarrera();

			}
			premiacion();

		}
	
	public void ensamblarNaves() {
		
		for(int i=0; i<2; i++) {
			Nave nave2 = new Nave();
			nrand = rand.randomizador(1);
			nave2.setMatricula(nrand);
			nrand = rand.randomizador(2);
			sng = cbtible.tipoCombustible(nrand);
			nave2.setCombustible(sng);
			nrand = (int) cbtible.velocidadInicial(sng);
			nave2.setVel_actual(nrand);
			nrand = rand.randomizador(2);
			sng = mrial.tipoMaterial(nrand);
			nave2.setTipo_alas(sng);
			nave2.setKmRecorridos(0);
			nave2.setPuesto(0);
			nave2.setEstadoAlas(100);
			nave2.setEstadoMotor(100);
			nave2.setDondeEsta("Carrera");


			Incribirse(nave2);
		}
	}

	public void Incribirse(Nave nave) {
		
		naves.add(nave);
	}
	
	
	public void presentacionNaves() {
		
		System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");
		for (Nave i: naves) {
			System.out.println("Nave: "+i.getMatricula());
			System.out.println("tipo de Combustible: "+i.getCombustible());
			System.out.println("Estado de motor: "+i.getEstadoMotor());
			System.out.println("tipo de Alas: "+i.getTipo_alas());
			System.out.println("% de Degradacion de Alas: " + i.getEstadoAlas());
			System.out.println("Vel. actual: "+i.getVel_actual()+ " km/5s");
			System.out.println("KmRecorridos: "+ i.getKmRecorridos());
			System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");
		}
	}
	
	public void calcularDegradacion() {

		String combustible;
		int estadoAlas;
		int estadoMotor;
		double kmRecorridos;
		double vel_actual;
	
		for (Nave i: naves) {
			if(i.getPuesto() == 0) {
				combustible = i.getCombustible();
				vel_actual = i.getVel_actual();
				estadoAlas = i.getEstadoAlas();
				estadoMotor = i.getEstadoMotor();
				kmRecorridos = i.getKmRecorridos();
				estadoAlas = alas1.calcularDegradacion(vel_actual, estadoAlas);
				estadoMotor = motor1.calcularSaludMotor(combustible, kmRecorridos, vel_actual);
				i.setEstadoAlas(estadoAlas);
				i.setEstadoMotor(estadoMotor);
				
			}
			
		}
	}
	
	public void revisarDegradacion() {

		
		int estadoAlas;
		int estadoMotor;
		int matricula;
		double velocidad;
		double vel_actual;
		double kmRecorridos;
		String combustible;
		
		for (Nave i: naves) {
			
			matricula = i.getMatricula();
			kmRecorridos = i.getKmRecorridos();
			vel_actual = i.getVel_actual();
			combustible = i.getCombustible();
			estadoAlas = i.getEstadoAlas();
			
			if(i.getPuesto() == 0 && i.getEstadoMotor() == 0) {
				animador1.Locucion(1, matricula, combustible, vel_actual, kmRecorridos, estadoAlas);
				i.setDondeEsta("Ambulancia");
				estadoMotor = ambulancia.Reparacion("Motor");
				i.setEstadoMotor(estadoMotor);
				velocidad = cbtible.velocidadInicial(combustible);
				i.setVel_actual(velocidad);
				
			}
			if(i.getPuesto() == 0 && i.getEstadoAlas() <= 20) {
				animador1.Locucion(2, matricula, combustible, vel_actual, kmRecorridos, estadoAlas);
				estadoAlas = ambulancia.Reparacion("Alas");
				i.setDondeEsta("Ambulancia");
				i.setEstadoAlas(estadoAlas);
				velocidad = cbtible.velocidadInicial(combustible);
				i.setVel_actual(velocidad);
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
		int carreraEnd=0;
		
		String material;
		String combustible;
				
		for (Nave i: naves) {
			if(i.getPuesto() == 0 && i.getDondeEsta() == "Carrera") {
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
				
				if(kmRecorridos_actual >= largoPista){
					puesto = puesto + 1; 
					i.setPuesto(puesto);			
				}
			}
		}
		if(puesto == 2) {
			carreraEnd = 1;
		}

		return carreraEnd;
	}
	

	public void mostrarInformacion() {
		
		for (Nave i: naves) { 
			System.out.println("--------------------------------------");
			if(i.getPuesto() == 0) {
				System.out.println("Nave: "+i.getMatricula());
				System.out.println("Estado motor: "+i.getEstadoMotor());
				System.out.println("¿Donde esta?: "+i.getDondeEsta());
				System.out.println("% de Degradacion de Alas: " + i.getEstadoAlas());
				System.out.println("Vel_actual: "+i.getVel_actual()+ " km/5s");
				System.out.println("KmRecorridos: "+ i.getKmRecorridos());
				System.out.println("--------------------------------------");
			}
		}
	}
	
	public void volver_aCarrera() {
		
		for (Nave i: naves) { 
			if(i.getPuesto() == 0 && i.getDondeEsta() == "Ambulancia") {

					i.setDondeEsta("Carrera");
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
				System.out.println("Cuarto lugar Nave: "+i.getMatricula());		
			}	
		}
		System.out.println("木木木木木木木木木木木木木木木木木木木木木木木木");

	}
}
