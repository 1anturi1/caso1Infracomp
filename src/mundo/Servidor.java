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
					System.out.println("Mensaje " + msj.getMsj() +" respondido por el servidor con el id: " + id);
					msj.notify();
					
				}

			}
			
			if(buff.getCantidadClientes()== 0)
			{
				System.out.println("El servidor con id "+id+ " se despide dado que no hay mas clientes");
				break ;
			}
			
		}


	}

}
