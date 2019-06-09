package proyecto1u2;

import java.util.ArrayList;

public class Carrera {
	
	private ArrayList<Nave> naves = new ArrayList();

	int nrand; // variable aux
	String sng; // variable aux
	int largoPista = 2000; //km
	int carreraEnd=0;
	int puesto=0;
		
	Random rand = new Random();
	Combustible cbtible = new Combustible(); 
	Material mrial = new Material(); 
	Alas alas1 = new Alas();
	Motor motor1 = new Motor();
	Ambulancia ambulancia = new Ambulancia();

	
	Carrera(){

			ensamblarNaves();
			while(carreraEnd != 1 ) {
				calcularDegradacion();
				revisarDegradacion();
				carreraEnd = velocidadNaves();
				mostrarParticipantes();
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
			nrand = cbtible.velocidadInicial(sng);
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
		int velocidad;
		String combustible;
	
		for (Nave i: naves) {
			if(i.getPuesto() == 0 && i.getEstadoMotor() == 0) {
				System.out.println("Nave: "+i.getMatricula());
				combustible = i.getCombustible();
				i.setDondeEsta("Ambulancia");
				estadoMotor = ambulancia.Reparacion("Motor");
				i.setEstadoMotor(estadoMotor);
				velocidad = cbtible.velocidadInicial(combustible);
				i.setVel_actual(velocidad);
				
			}
			if(i.getPuesto() == 0 && i.getEstadoAlas() <= 20) {
				combustible = i.getCombustible();
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
	
	public void mostrarParticipantes() {
		
		for (Nave i: naves) { 
			if(i.getPuesto() == 0) {
				System.out.println("--------------------------------------");
				System.out.println("Nave: "+i.getMatricula());
				System.out.println("tio de Combustible: "+i.getCombustible());
				System.out.println("Esado moor: "+i.getEstadoMotor());
				System.out.println("dd esa: "+i.getDondeEsta());
				//System.out.println(i.getTipo_alas());
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
