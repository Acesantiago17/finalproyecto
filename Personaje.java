package call;

public  class Personaje implements Golpeador,Tanque,Medico {	
	private int casillaUbicado;

	public int getCasillaUbicado() {
		return casillaUbicado;
	}

	public Personaje(int casillaUbicado) {
		super();
		this.casillaUbicado = casillaUbicado;
	}

	public void setCasillaUbicado(int casillaUbicado) {
		this.casillaUbicado = casillaUbicado;
	}

	@Override
	public void ResisitirDosAtaques() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GolpearDosVeces() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RevivirUnPersonaje() {
		// TODO Auto-generated method stub
		
	}


	
} 
