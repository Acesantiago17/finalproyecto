package call;

public class Zombies extends Personaje{
	private String tipoZombie;

	public Zombies(int casillaUbicado, String tipoZombie) {
		super(casillaUbicado);
		this.tipoZombie = tipoZombie;
	}

	public String getTipoZombie() {
		return tipoZombie;
	}

	public void setTipoZombie(String tipoZombie) {
		this.tipoZombie = tipoZombie;
	}

	@Override
	public String toString() {
		return "Zombies [tipoZombie=" + tipoZombie + "]";
	}	
	
}
