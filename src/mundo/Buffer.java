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
		buff = new ArrayList<Mensaje>();
		lleno = new Object();
		vacio = new Object();
		cantidadClientes = numClientes ;
	}


	public void almacenar(Mensaje pMsj) {

		synchronized (lleno) {
			while(buff.size() == n)
			{
				try {
					System.out.println("Buffer lleno");
					lleno.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		synchronized (this) {
			buff.add(pMsj) ;
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
