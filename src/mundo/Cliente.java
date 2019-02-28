package mundo;

public class Cliente extends Thread {


	public int id ;
	private Buffer buff ;
	private int maxMensajes;

	public Cliente(int pId, Buffer pBuff, int pNumMensajes)
	{
		this.id = pId ;
		this.buff = pBuff ;
		this.maxMensajes = pNumMensajes ;
	}

	public void run()
	{
		
		int numeroMensajes = (int)(Math.random()*100)% maxMensajes;
		if(numeroMensajes == 0)
		{
			numeroMensajes = 1;
		}
		System.out.println("Soy el cliente con id: " + id+ " y tengo que enviar "+ numeroMensajes);
		for(int i =0 ; i< numeroMensajes ; i++)
		{
			int num = (int)(Math.random()*100) ;

			Mensaje msj = new Mensaje(num) ;

			System.out.println("Se envío el Mensaje " + msj.getMsj() + " por el cliente con id= " + id);
			
			synchronized (msj) {

				try {
					buff.almacenar(msj);
					msj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		buff.saleCliente();
		System.out.println("Sali y soy el cliente con id = " +id);

	}


}
