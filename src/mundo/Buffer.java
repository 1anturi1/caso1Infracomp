package mundo;

import java.util.ArrayList;


public class Buffer {

	private ArrayList<Mensaje> buff;
	private int n;
	Object lleno;
	Object vacio;
	public int cantidadClientes ;

	public Buffer(int n, int numClientes) 
	{
		this.n = n;
		buff = new ArrayList<Mensaje>(n);
		lleno = new Object();
		vacio = new Object();
		cantidadClientes = numClientes ;
	}


	public void almacenar(Mensaje pMsj) {

		synchronized (lleno) {
			
			while(buff.size() == n)
			{
				try {
					System.out.println("El mensaje "+ pMsj.msj +" fue mandado a dormir porque el buffer está lleno");
					lleno.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		synchronized (this) {
			buff.add(pMsj) ;
			System.out.println("El mensaje "+ pMsj.msj +" fue añadido");
		}
		synchronized (vacio) {
			vacio.notify();
		}


	}

	public Mensaje responder() {

		Mensaje i = null ;

		synchronized (this) {
			if(buff.size() != 0)
			{
				
				i = buff.remove(0) ;
				System.out.println("El mensaje "+ i.msj +" fue retirado del buffer");
			}
		}		
		synchronized (lleno) {
			lleno.notify();
		}

		return i ;
	}

	
	public void saleCliente()
	{
		cantidadClientes -- ;
		
	}

	/**
	 * @return the cantidadClientes
	 */
	public int getCantidadClientes() {
		return cantidadClientes;
	}

}
