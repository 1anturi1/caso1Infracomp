package mundo;

public class Mensaje {

	
	public int msj ;
	
	public int rta ;
	
	public boolean respondido ;
	
	public Mensaje( int pMsj)
	{
		this.msj = pMsj ;
		this.respondido = false ;
	}

	/**
	 * @return the msj
	 */
	public int getMsj() {
		return msj;
	}


	/**
	 * @return the rta
	 */
	public int getRta() {
		return rta;
	}

	/**
	 * @param rta the rta to set
	 */
	public void setRta() {
		rta = msj+1 ;
		
	}

	/**
	 * @return the respondido
	 */
	public boolean isRespondido() {
		return respondido;
	}


	/**
	 * @param msj the msj to set
	 */
	public void setMsj(int msj) {
		this.msj = msj;
	}
	
	
	
	
	
	
}
