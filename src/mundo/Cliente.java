package mundo;

public class Cliente extends Thread {


	public int id ;
	private Buffer buff ;
	private int numMensajes;

	public Cliente(int pId, Buffer pBuff, int pNumMensajes)
	{
		this.id = pId ;
		this.buff = pBuff ;
		this.numMensajes = pNumMensajes ;
	}

	public void run()
	{

		
		for(int i =0 ; i< numMensajes ; i++)
		{
			int num = (int)(Math.random()*100) ;

			Mensaje msj = new Mensaje(num) ;

			System.out.println("Mensaje " + msj.getMsj() + " depositado por el cliente con id= " + id);

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

	}


}
