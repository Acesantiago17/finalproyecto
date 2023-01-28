package call;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jugador {
	public static Scanner sc = new Scanner(System.in);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Personaje> getListaPersonajes() {
		return listaPersonajes;
	}

	public void setListaPersonajes(List<Personaje> listaPersonajes) {
		this.listaPersonajes = listaPersonajes;
	}

	private String nombre;
	private List<Personaje> listaPersonajes = new ArrayList<>();

	public Jugador(String nombre, List<Personaje> listaPersonajes) {
		super();
		this.nombre = nombre;
		this.listaPersonajes = listaPersonajes;
	}

	public Jugador(String nombre2) {
		this.nombre = nombre2;
	}

	public void agregarPersonajes(int cantidadJugadores) {
		// agregarmos 6 personajes 1 tanque que resiste 2 ataques
		int cantidadTanques = 1;
		int cantidadMedicos = 1;
		int cantidadGolpeadores = 1;

		listaPersonajes.add(new Soldado(0, "tanque"));
		listaPersonajes.add(new Soldado(0, "medico"));
		listaPersonajes.add(new Soldado(0, "golpeador"));

		for (int i = 0; i < (cantidadJugadores - 3); i++) {
			// generamos el resto de soldados normales
			Soldado aux = new Soldado(0, null);
			listaPersonajes.add(aux);
		}

		// medico revive a un personaje
		// Golpeador tiene 2 atques

	}

	public void agregarPersonajesZombies(int cantidadPersonajes) {
		// agregarmos 6 personajes 1 tanque que resiste 2 ataques
		int cantidadTanques = 1;
		int cantidadMedicos = 1;
		int cantidadGolpeadores = 1;

		listaPersonajes.add(new Zombies(0, "tanque"));
		listaPersonajes.add(new Zombies(0, "medico"));
		listaPersonajes.add(new Zombies(0, "golpeador"));

		for (int i = 0; i < (cantidadPersonajes - 3); i++) {
			// generamos el resto de Zombiess normales
			Zombies aux = new Zombies(0, null);
			listaPersonajes.add(aux);
		}
	}

	public void mostrarListaPersonajes() {
		for (Personaje personaje : listaPersonajes) {
			Soldado s = (Soldado) personaje;
			System.out.println(s.getTipoSoldado() + " ubicado en la casilla " + s.getCasillaUbicado());

		}

	}

	public void mostrarListaPersonajesZombies() {
		for (Personaje personaje : listaPersonajes) {
			Zombies s = (Zombies) personaje;
			System.out.println(s.getTipoZombie() + " ubicado en la casilla " + s.getCasillaUbicado());

		}

	}

	public void desplegarTropasUbicacionEstrategica(int cantidadCasillas) {
		int i = 1;
		boolean valido = false;
		int ubicacion = 0;
		System.out.println("ingrese un valor entre 1 y " + cantidadCasillas);
		for (Personaje personaje : listaPersonajes) {
			Soldado s = (Soldado) personaje;

			do {

				System.out.println("ubicacion soldado " + s.getTipoSoldado() + " :>");
				ubicacion = sc.nextInt();
				if (ubicacion > 0 && ubicacion <= cantidadCasillas) {
					// validamos que no este asignada ya esa casilla

					for (Personaje personaje2 : listaPersonajes) {
						if (ubicacion == personaje2.getCasillaUbicado()) {
							System.out.println("casilla ocupada elija otra...");

							valido = false;
							break;
						} else {
							valido = true;
						}
					}
				} else {
					System.out.println("Ingrese una casilla valida -_- ....");
					valido = false;
				}
			} while (!valido);
			s.setCasillaUbicado(ubicacion);
			// System.out.println(s.getTipoSoldado() +" ubicado en la casilla "+
			// s.getCasillaUbicado());
		}

	}

	public void desplegarTropasUbicacionEstrategicaZombies(int cantidadCasillas) {
		int i = 1;
		boolean valido = false;
		int ubicacion = 0;
		for (Personaje personaje : listaPersonajes) {
			Zombies s = (Zombies) personaje;

			do {
				System.out.println("ingrese un valor entre 1 y " + cantidadCasillas);
				System.out.println("ubicacion Zombies " + s.getTipoZombie() + " :>");
				ubicacion = sc.nextInt();
				if (ubicacion > 0 && ubicacion <= cantidadCasillas) {
					// validamos que no este asignada ya esa casilla

					for (Personaje personaje2 : listaPersonajes) {
						Zombies s2 = (Zombies) personaje2;
						if (ubicacion == personaje2.getCasillaUbicado()) {
							System.out.println("casilla ocupada elija otra...");
							valido = false;
						} else {
							valido = true;
						}
					}
				} else {
					System.out.println("Ingrese una casilla valida -_- ....");
					valido = false;
				}
			} while (!valido);
			s.setCasillaUbicado(ubicacion);
			// System.out.println(s.getTipoZombies() +" ubicado en la casilla "+
			// s.getCasillaUbicado());
		}

	}

	public boolean atacaCasilla(Jugador victima) {

		System.out.println("que casilla desea atacar:>");
		int casillaAtacada = sc.nextInt();

		boolean ataqueAcertado = false;
		for (int i = 0; i < victima.listaPersonajes.size(); i++) {
			if (casillaAtacada == victima.listaPersonajes.get(i).getCasillaUbicado()) { // si atacas una casilla donde
																						// hay enemigo
				// ataque acertado
				ataqueAcertado = true;
				victima.listaPersonajes.get(i).setCasillaUbicado(0);
				Zombies z = (Zombies) victima.listaPersonajes.get(i);
				System.out.println("Booom head Shot, has eliminado a un Zombie " + z.getTipoZombie());
				victima.listaPersonajes.remove(i);		
				break;		
			} else {
				ataqueAcertado = false;				
			}

		}
		if (ataqueAcertado) {
			System.out.println("ataque acertado..");
		}else {
			System.out.println("ataque fallido..");
		}
	
		Soldado s1;
		int opc = 0;
		boolean selecion = false;
		System.out.println("Quieres usar alguna skill de tus personajes? ");
		do {
			for (int i = 0; i < this.listaPersonajes.size() - 3; i++) {
				s1 = (Soldado) this.listaPersonajes.get(i);
				System.out.println((i + 1) + ". " + s1.getTipoSoldado());
			}
			System.out.println("4. No");
			opc = sc.nextInt();
			if(opc ==4)			{
				opc= -1;
				break;
			}
			if (opc < 0 || opc > this.listaPersonajes.size() - 3) {
				System.out.println("Elija opcion valida");
				selecion = false;
			} else {
				selecion = true;
			}
			opc = opc-1;
		} while (!selecion);

		// ejecutamos la opcion selecionada		
		if(opc >= 0) {
			System.out.println("EJECUTAR PODERES");
			s1 = (Soldado) listaPersonajes.get(opc);
			if(s1.getTipoSoldado() =="tanque"){
				System.out.println("Resistiras el proximo ataque");
			}else{
				if(s1.getTipoSoldado() =="medico"){
					System.out.println("Reviviras a un Aliado ,seleciona cual:");
					for (int i = 0; i < this.listaPersonajes.size(); i++) {
						s1 = (Soldado) this.listaPersonajes.get(i);
						System.out.println((i + 1) + ". " + s1.getTipoSoldado());
					}
					opc = sc.nextInt();
					opc= opc-1;

				}else{
					System.out.println("El poder del golpeador te permite realizar ataque nuevamente");
					atacaCasilla(victima);
				}
			}
		}
	

		if (victima.listaPersonajes.size() == 0) {
			System.out.println("EL GANADOR ES " + this.getNombre());
			sc.nextLine();
			return true;
		} else {
			System.out.println("Presione ENTER pàra cotinuar");
			sc.nextLine();
		}
		return false;

	}

	public boolean atacaCasillaZombie(Jugador victima) {
		System.out.println("que casilla desea atacar:>");
		int casillaAtacada = sc.nextInt();

		boolean ataqueAcertado = false;
		for (int i = 0; i < victima.listaPersonajes.size(); i++) {
			if (casillaAtacada == victima.listaPersonajes.get(i).getCasillaUbicado()) { // si atacas una casilla donde
																						// hay enemigo
				// ataque acertado
				ataqueAcertado = true;
				victima.listaPersonajes.get(i).setCasillaUbicado(0);
				Soldado s = (Soldado) victima.listaPersonajes.get(i);
				System.out.println("Booom head Shot, has eliminado a un Soldado" + s.getTipoSoldado());
				victima.listaPersonajes.remove(i);		
				break;		
			} else {
				ataqueAcertado = false;				
			}

		}
		if (ataqueAcertado) {
			System.out.println("ataque acertado..");
		}else {
			System.out.println("ataque fallido..");
		}

		Zombies s1;
		int opc = 0;
		boolean selecion = false;
		System.out.println("Quieres usar alguna skill de tus personajes? ");
		do {
			for (int i = 0; i < this.listaPersonajes.size() - 3; i++) {
				s1 = (Zombies) this.listaPersonajes.get(i);
				System.out.println((i + 1) + ". " + s1.getTipoZombie());
			}
			System.out.println("4. No");
			opc = sc.nextInt();
			if(opc ==4)			{
				opc= -1;
				break;
			}
			if (opc < 0 || opc > this.listaPersonajes.size() - 3) {
				System.out.println("Elija opcion valida");
				selecion = false;
			} else {
				selecion = true;
			}
			opc = opc-1;
		} while (!selecion);

		if(opc >= 0) {
			// ejecutamos la opcion selecionada		
			System.out.println("EJECUTAR PODERES");
			s1 = (Zombies) listaPersonajes.get(opc);
			if(s1.getTipoZombie() =="tanque"){
				System.out.println("Resistiras el proximo ataque");
			}else{
				if(s1.getTipoZombie() =="medico"){
					System.out.println("Reviviras a un Aliado ,seleciona cual:");
					for (int i = 0; i < this.listaPersonajes.size(); i++) {
						s1 = (Zombies) this.listaPersonajes.get(i);
						System.out.println((i + 1) + ". " + s1.getTipoZombie());
					}
					opc = sc.nextInt();
					opc= opc-1;

				}else{
					System.out.println("El poder del golpeador te permite realizar ataque nuevamente");
					atacaCasillaZombie(victima);
				}
			}
		}
		

		if (victima.listaPersonajes.size() == 0) {
			System.out.println("EL GANADOR ES " + this.getNombre());
			sc.nextLine();
			return true;
		} else {
			System.out.println("Presione ENTER pàra cotinuar");
			sc.nextLine();
		}
		return false;
	}
}
