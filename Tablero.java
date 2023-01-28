package call;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
	private int cantidadCasillas;
	private int cantidadPersonajes;
	private int cantidadJugadores;
	private List<Personaje> listaPersonajes = new ArrayList<>(); // agregacion
	private List<Jugador> listaJugadores= new ArrayList<>(); // agregacion
	
	
	
	public void agregarPersonajes() {
		
	}
	public void agregarJugador(Jugador jugador) {
		listaJugadores.add(jugador);
		
	}
	public void agregarJugadores() {
		
		
	}
	public int getCantidadCasillas() {
		return cantidadCasillas;
	}
	public Tablero(int cantidadCasillas, int cantidadPersonajes, int cantidadJugadores) {
		super();
		this.cantidadCasillas = cantidadCasillas;
		this.cantidadPersonajes = cantidadPersonajes;
		this.cantidadJugadores = cantidadJugadores;
	}
	@Override
	public String toString() {
		return "Tablero [cantidadCasillas=" + cantidadCasillas + ", cantidadPersonajes=" + cantidadPersonajes
				+ ", cantidadJugadores=" + cantidadJugadores + "]";
	}
	public void setCantidadCasillas(int cantidadCasillas) {
		this.cantidadCasillas = cantidadCasillas;
	}
	public int getCantidadPersonajes() {
		return cantidadPersonajes;
	}
	public void setCantidadPersonajes(int cantidadPersonajes) {
		this.cantidadPersonajes = cantidadPersonajes;
	}
	public int getCantidadJugadores() {
		return cantidadJugadores;
	}
	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
	public void mostrarJugadoresPersonajes() {
		System.out.println("JUGADORES Y TROPAS");		
			System.out.print("Ejercio del jugador 1 ");
			System.out.println(listaJugadores.get(0).getNombre()+" :");			
			listaJugadores.get(0).mostrarListaPersonajes();
		
				
			
			//ejercito jugador 2
			System.out.print("\n\nEjercio del jugador 2 ");
			System.out.println(listaJugadores.get(1).getNombre()+" :");
			listaJugadores.get(1).mostrarListaPersonajesZombies();
			
								
			
	}

}
