package proyecto22;
import java.util.ArrayList;

public class Carrera {
	
	private ArrayList<Nave> naves = new ArrayList();
	public int puestoCarrera = 0;
	
	Carrera(){
		Ambulancia ambulancia = new Ambulancia ();
		Pista pista = new Pista();
		Locutor locutor =  new Locutor();
		
		ensamblarNaves();
		presentacionNaves();
		
		while(puestoCarrera != 2) {
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
					i.getOd().setAceleracion(0);
				}
				if(saludMotor != saludMotor_reparado) {
					i.setDondeEsta("Ambulancia");
					i.getOd().setVel_actual(0);
					i.getOd().setAceleracion(0);

				}
				
				if(i.getPuestoCarrera() == 0 && i.getDondeEsta() == "Carrera") {
					double aceleracion;
					double velocidad;
					double velocidad_final;
					double kmRecorridos;
					double kmRecorridos_final;
					int saludMotor_final;
					int estadoAlas_final;
					String tipoAlas;
					String tipoCombustible;
					
					matricula = i.getMatricula();
					aceleracion = i.getOd().getAceleracion();
					velocidad = i.getOd().getVel_actual();
					saludMotor = i.getMotor().getSaludMotor();
					kmRecorridos = i.getOd().getKmRecorridos();
					estadoAlas = i.getAlas().getEstadoAlas();
					tipoAlas = i.getAlas().getTipoAlas();
					tipoCombustible = i.getMotor().getTipoCombustible();
					
					//CALCULAR VELOCIDAD + EFECTOS
					velocidad_final = i.calcularEfectos(velocidad, estadoAlas, tipoAlas, tipoCombustible);
					i.getOd().setVel_actual(velocidad_final);
					
					//CALCULAR ACELERACION
					aceleracion=i.getOd().calcularAceleracion(velocidad_final, velocidad);
					i.getOd().setAceleracion(aceleracion);
					
					// CALCULAR RECORRIDO
					kmRecorridos_final = i.getOd().calcularRecorrido(velocidad_final, kmRecorridos);
					i.getOd().setKmRecorridos(kmRecorridos_final);
					imprimirRecorridoGrafico(kmRecorridos_final, matricula);
					//REVISAR SI PASO LA META
					if(kmRecorridos_final >= pista.getLargoPista()) {
						puestoCarrera = puestoCarrera + 1;
						i.setPuestoCarrera(puestoCarrera);
						System.out.println("LA NAVE: "+i.getMatricula()+" HA LLEGADO A LA META");
					}
					
					//CALCULAR DEGRADACIONES ELEMENTOS (ALAS Y MOTOR)
					
					estadoAlas_final = i.calcularDegradacionAlas(velocidad_final, tipoAlas, estadoAlas);
					i.getAlas().setEstadoAlas(estadoAlas_final);
					
					saludMotor_final= i.calcularSaludMotor(velocidad_final, tipoCombustible, saludMotor);
					i.getMotor().setSaludMotor(saludMotor_final);
					locutor.recibirInformacion(naves);
				}
			}
			//try {
                //Thread.sleep(5000);
            //} catch (InterruptedException e) {
                //e.printStackTrace();
            //}
			volver_aCarrera();
		}
		premiacion();
	}

	public void ensamblarNaves() {
		int nrand;
		double velocidad;
		String material;
		String combustible;
		
		for(int i=0; i<2; i++) {
			Nave nave1 = new Nave();
			nrand = randomizador(1);
			nave1.setMatricula(nrand);
			nave1.setPuestoCarrera(0);
			nave1.setDondeEsta("Carrera");
			nrand = randomizador(2);
			material = tipoMaterial(nrand);
			nrand = randomizador(2);
			combustible = tipoCombustible(nrand);
			nave1.getMotor().setTipoCombustible(combustible);
			velocidad = nave1.getMotor().velocidadInicial(combustible);
			nave1.getOd().setVel_actual(velocidad);
			nave1.getOd().setAceleracion(velocidad);
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

		String estadoAlas = " ";
		String saludMotor = " ";
		String matricula = " ";
		String velocidad = " ";
		String aceleracion = " ";
		String recorrido = " ";
		String t_combustible= " ";
		String t_alas=" ";
		
		for (Nave i: naves) {
			matricula= matricula + i.getMatricula()+ "     ";
			saludMotor= saludMotor + i.getMotor().getSaludMotor()+ "          ";
			estadoAlas= estadoAlas + i.getAlas().getEstadoAlas()+ "          ";
			velocidad= velocidad + i.getOd().getVel_actual()+ "          ";
			aceleracion= aceleracion + i.getOd().getAceleracion()+ "          ";
			recorrido= recorrido + i.getOd().getKmRecorridos()+ "          ";
			t_combustible = t_combustible + i.getMotor().getTipoCombustible()+ "      ";
			t_alas = t_alas + i.getAlas().getTipoAlas()+ "      ";
		}
		System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛PRESENTACION船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");

		System.out.println("Nave:                  "+matricula);
		System.out.println("Tipo de Alas           "+t_alas);
		System.out.println("Tipo de Combustible    "+t_combustible);
		System.out.println("Salud Motor:           "+saludMotor);
		System.out.println("% Degradacion en Alas: "+estadoAlas);
		System.out.println("Vel de arranque km/5s:  "+velocidad);
		System.out.println("Aceleracion:           "+aceleracion);
		System.out.println("Recorrido:             "+recorrido);

		System.out.println("船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛船赛");

	}	
	
	public void imprimirRecorridoGrafico(double kmRecorrido_final, int matricula) {
		int cantidadCamino=0;
		String dibujo = "";
		
		cantidadCamino = (int) (kmRecorrido_final/10);
		for (int i=0; i<= cantidadCamino; i++) {
			dibujo = dibujo + "|";
		}
		System.out.println(dibujo+matricula);
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
		}
		System.out.println("木木木木木木木木木木木木木木木木木木木木木木木木");

	}
	
	public int randomizador(int opcion) {
		int nrandom = 1;
		
		if(opcion == 1) {
			nrandom = (int) Math.floor(Math.random()*(10000000)+1000000);
		}
		else if(opcion == 2) {
			nrandom = (int) Math.floor(Math.random()*(3)+1);
		}
		else if(opcion == 3) {
			nrandom = (int) Math.floor(Math.random()*(2)+1);
		}	
		return nrandom;	
	}
	
	public String tipoMaterial (int opcion) {
		String material = null;
		if(opcion == 1) {
			material = "Plastico";
		}
		else if(opcion == 2) {
			material = "Madera";
		}
		else if(opcion == 3) {
			material = "Metal";
		}
		return material;
	}
	
	public String tipoCombustible (int opcion) {
		String combustible = null;
		if(opcion == 1) {
			combustible = "Biodisel";
		}
		else if(opcion == 2) {
			combustible = "Nuclear";
		}
		else if(opcion == 3) {
			combustible = "Disel";
		}
		return combustible;
	}
	
	
	
	

}
