package call;

public class Soldado extends Personaje {
	private String tipoSoldado;
	
	

	public Soldado(int casillaUbicado, String tipoSoldado) {
		super(casillaUbicado);
		this.tipoSoldado = tipoSoldado;
	}



	

	public String getTipoSoldado() {
		return tipoSoldado;
	}





	public void setTipoSoldado(String tipoSoldado) {
		this.tipoSoldado = tipoSoldado;
	}


}
