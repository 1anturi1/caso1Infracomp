package mundo;

public class Servidor extends Thread {


	public int id ;

	private Buffer buff ;

	public Servidor(int pId, Buffer pBuff)
	{
		this.id = pId ;
		this.buff = pBuff ;
	}

	public void run()
	{	
		
		
		while (true)
		{
			Mensaje msj = buff.responder() ;
			if(msj==null)
			{
				this.yield();
			}
			else
			{
				synchronized (msj) {
					msj.setRta();
					msj.notify();
					System.out.println("Mensaje " + msj.getMsj() +" respondido por el servidor con el id: " + id);
					this.yield();
				}

			}
			
			if(buff.getCantidadClientes()== 0)
			{
				break ;
			}
			
		}


	}

}
