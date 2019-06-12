package proyecto22;
import java.util.ArrayList;

public class Carrera {
	
	private ArrayList<Nave> naves = new ArrayList();
	public int largoPista = 1000;
	public int puestoCarrera = 0;
	
	Random rand = new Random();
	Ambulancia ambulancia = new Ambulancia ();
	
	Carrera(){
		ensamblarNaves();
		presentacionNaves();
		
		while(puestoCarrera != 4) {
			for (Nave i: naves) {
				
				int estadoAlas;
				int saludMotor;
				int matricula;
				estadoAlas = i.getAlas().getEstadoAlas();
				saludMotor = i.getMotor().getSaludMotor();
				matricula = i.getMatricula();
				
				// POSIBLE REPARACIONES.
				int saludMotor_reparado;
				int estadoAlas_reparado;
				estadoAlas_reparado = ambulancia.reparacionAlas(estadoAlas, matricula);
				i.getAlas().setEstadoAlas(estadoAlas_reparado);
				saludMotor_reparado = ambulancia.reparacionMotor(saludMotor, matricula);
				i.getMotor().setSaludMotor(saludMotor_reparado);
	
				//ESTO QUIERE DECIR QUE SE HIZO REPARACION POR ENDE LA VELOCIDAD PARTE DE 0.
				if(estadoAlas != estadoAlas_reparado ) {
					i.setDondeEsta("Ambulancia");
					i.getOd().setVel_actual(0);
				}
				if(saludMotor != saludMotor_reparado) {
					i.setDondeEsta("Ambulancia");
					i.getOd().setVel_actual(0);
				}
				
				if(i.getPuestoCarrera() == 0 && i.getDondeEsta() == "Carrera") {
					double velocidad;
					double kmRecorridos;
					double kmRecorridos_final;
					int saludMotor_final;
					int estadoAlas_final;
					String tipoAlas;
					String tipoCombustible;
					
					velocidad = i.getOd().getVel_actual();
					saludMotor = i.getMotor().getSaludMotor();
					kmRecorridos = i.getOd().getKmRecorridos();
					estadoAlas = i.getAlas().getEstadoAlas();
					tipoAlas = i.getAlas().getTipoAlas();
					tipoCombustible = i.getMotor().getTipoCombustible();
					
					//CALCULAR VELOCIDAD + EFECTOS
					velocidad = i.calcularEfectos(velocidad, estadoAlas, tipoAlas, tipoCombustible);
					i.getOd().setVel_actual(velocidad);
					
					// CALCULAR RECORRIDO
					
					kmRecorridos_final = i.getOd().calcularRecorrido(velocidad, kmRecorridos);
					i.getOd().setKmRecorridos(kmRecorridos_final);
					//REVISAR SI PASO LA META
					if(kmRecorridos_final >= largoPista) {
						puestoCarrera = puestoCarrera + 1;
						i.setPuestoCarrera(puestoCarrera);
					}
					
					//CALCULAR DEGRADACIONES ELEMENTOS (ALAS Y MOTOR)
					
					estadoAlas_final = i.calcularDegradacionAlas(velocidad, tipoAlas, estadoAlas);
					i.getAlas().setEstadoAlas(estadoAlas_final);
					
					saludMotor_final= i.calcularSaludMotor(velocidad, tipoCombustible, saludMotor);
					i.getMotor().setSaludMotor(saludMotor_final);

				}
			}
			//try {
             //   Thread.sleep(5000);
            //} catch (InterruptedException e) {
             //   e.printStackTrace();
           // }
			mostrarInformacion();
			volver_aCarrera();
		}
		premiacion();
	}

	public void ensamblarNaves() {
		int nrand;
		double velocidad;
		String material;
		String combustible;
		
		for(int i=0; i<4; i++) {
			Nave nave1 = new Nave();
			nrand = rand.randomizador(1);
			nave1.setMatricula(nrand);
			nave1.setPuestoCarrera(0);
			nave1.setDondeEsta("Carrera");
			nrand = rand.randomizador(2);
			material = rand.tipoMaterial(nrand);
			nrand = rand.randomizador(2);
			combustible = rand.tipoCombustible(nrand);
			nave1.getMotor().setTipoCombustible(combustible);
			velocidad = nave1.getMotor().velocidadInicial(combustible);
			nave1.getOd().setVel_actual(velocidad);
			nave1.getMotor().setSaludMotor(100);
			nave1.getAlas().setTipoAlas(material);
			nave1.getAlas().setEstadoAlas(100);
			nave1.getOd().setKmRecorridos(0);
			
			
			Incribirse(nave1);
		}
	}

	public void Incribirse(Nave nave) {
		
		naves.add(nave);
	}
	
	public void presentacionNaves() {
		
		System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");
		for (Nave i: naves) {
			System.out.println("Nave: "+i.getMatricula());
			System.out.println("Salud Motor: "+i.getMotor().getSaludMotor());
			System.out.println("Tipo de Combustible: "+i.getMotor().getTipoCombustible());
			System.out.println("Tipo de Alas: "+ i.getAlas().getTipoAlas());
			System.out.println("% Degradacion en Alas: "+ i.getAlas().getEstadoAlas());
			System.out.println("Vel_actual: "+i.getOd().getVel_actual());
			System.out.println("Recorrido: "+i.getOd().getKmRecorridos());

			System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");
		}
	}
	
	public void mostrarInformacion() {
		
		String estadoAlas = " ";
		String saludMotor = " ";
		String matricula = " ";
		String velocidad = " ";
		String recorrido = " ";
		
		for (Nave i: naves) {
			matricula= matricula + i.getMatricula()+ "     ";
			saludMotor= saludMotor + i.getMotor().getSaludMotor()+ "     ";
			estadoAlas= estadoAlas + i.getAlas().getEstadoAlas()+ "     ";
			velocidad= velocidad + i.getOd().getVel_actual()+ "     ";
			recorrido= recorrido + i.getOd().getKmRecorridos()+ "     ";
		}
		System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");

		System.out.println("Nave: "+matricula);
		System.out.println("Salud Motor: "+saludMotor);
		System.out.println("% Degradacion en Alas: "+estadoAlas);
		System.out.println("Vel_actual: "+velocidad);
		System.out.println("Recorrido: "+recorrido);

		System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");

	}
	
	public void volver_aCarrera() {
		double velocidad;
		String combustible;
		for (Nave i: naves) { 
			if(i.getPuestoCarrera() == 0 && i.getDondeEsta() == "Ambulancia") {
					i.setDondeEsta("Carrera");
					combustible = i.getMotor().getTipoCombustible();
					velocidad = i.getMotor().velocidadInicial(combustible);
					i.getOd().setVel_actual(velocidad);
			}
		}
	}
	
	public void premiacion() {
		System.out.println("木木木木木木木木木木木木木木木木木木木木木木木木");

		for (Nave i: naves) {
			if(i.getPuestoCarrera() == 1) {
				System.out.println("Primer lugar Nave: "+i.getMatricula());
			}
			else if(i.getPuestoCarrera() == 2) {
				System.out.println("Segundo lugar Nave: "+i.getMatricula());				
			}
			else if(i.getPuestoCarrera() == 3) {
				System.out.println("Tercer lugar Nave: "+i.getMatricula());				
			}
			else if(i.getPuestoCarrera() == 4) {
				System.out.println("Cuarto lugar Nave: "+i.getMatricula());		
			}
		}
		System.out.println("木木木木木木木木木木木木木木木木木木木木木木木木");

	}
	

}
