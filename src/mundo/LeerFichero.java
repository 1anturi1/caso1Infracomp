package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero 
{
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        int clientes = 0;
        int servidores = 0;
        int nClientes = 0;
        int buffer = 0 ;
        BufferedReader b = new BufferedReader(f);
        if((cadena = b.readLine())!=null && cadena.contains(":")) {
            System.out.println(cadena.split(":")[1]);
            clientes = Integer.parseInt(cadena.split(":")[1]);
        }
        if((cadena = b.readLine())!=null && cadena.contains(":")) {
            System.out.println(cadena.split(":")[1]);
            servidores= Integer.parseInt(cadena.split(":")[1]);
        }
        if((cadena = b.readLine())!=null && cadena.contains(":")) {
            System.out.println(cadena.split(":")[1]);
            nClientes= Integer.parseInt(cadena.split(":")[1]);
        }
        if((cadena = b.readLine())!=null && cadena.contains(":")) {
            System.out.println(cadena.split(":")[1]);
            buffer= Integer.parseInt(cadena.split(":")[1]);
        }
        b.close();
        System.out.println(clientes +" "+ servidores +" "+ nClientes +" "+ buffer);
    }

    public static void main(String[] args) throws IOException {
        muestraContenido("./data/archivo.txt");
    }
}
