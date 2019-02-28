package mundo;


import java.util.ArrayList;



public class Main {

	private static final String filePath = "./data/archivo.json";

	public static void main(String[] args)
	{
		
		ArrayList<Cliente> listaClie = new ArrayList<Cliente>();
		ArrayList<Servidor> listaSer = new ArrayList<Servidor>();
		
		Buffer  buff = new Buffer(3, 20) ;				
		
		for( int j = 0 ; j < 20 ; j++ )
		{
			Cliente nuevillo = new Cliente(j, buff, 10) ;
			listaClie.add(nuevillo) ;
		}
		for( int k = 0 ; k < 4 ; k++ )
		{
			Servidor nuevilloSer = new Servidor(k, buff);
			listaSer.add(nuevilloSer) ;
		}

		for( int j = 0 ; j < listaClie.size() ; j++ )
		{
			listaClie.get(j).start();
		}
		for( int j = 0 ; j < listaSer.size() ; j++ )
		{
			listaSer.get(j).start();
		}
		
		
		
	}


}
