package mundo;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;



public class Main {

	private static final String filePath = "./data/archivo.txt";

	public static void main(String[] args)
	{
		int clientes = 0;
        int servidores = 0;
        int nClientes = 0;
        int buffer = 0 ;
		//-----------------------------------------------------
		// Metodo para leer el archivo
		//-----------------------------------------------------
		 String cadena;
	        FileReader f;
			try {
				f = new FileReader(filePath);
				 BufferedReader b = new BufferedReader(f);
			        if((cadena = b.readLine())!=null && cadena.contains(":")) {
			            clientes = Integer.parseInt(cadena.split(":")[1]);
			        }
			        if((cadena = b.readLine())!=null && cadena.contains(":")) {
			            servidores= Integer.parseInt(cadena.split(":")[1]);
			        }
			        if((cadena = b.readLine())!=null && cadena.contains(":")) {
			            nClientes= Integer.parseInt(cadena.split(":")[1]);
			        }
			        if((cadena = b.readLine())!=null && cadena.contains(":")) {
			            buffer= Integer.parseInt(cadena.split(":")[1]);
			        }
			        b.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Fallo leyendo el archivo");
			}
	        
		
		ArrayList<Cliente> listaClie = new ArrayList<Cliente>();
		ArrayList<Servidor> listaSer = new ArrayList<Servidor>();
		
		Buffer  buff = new Buffer(buffer, 20) ;				
		
		for( int j = 0 ; j < clientes ; j++ )
		{
			Cliente nuevillo = new Cliente(j, buff, nClientes) ;
			listaClie.add(nuevillo) ;
		}
		for( int k = 0 ; k < servidores; k++ )
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
