package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EscrituraCSV {

	public static void EscritorCSV(String file) {

		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out=new PrintWriter(new FileWriter(file, true)); // con true hago append
			System.out.println("tipee algo, y presione CTRL-Z para salir");
			
			String s;
			while((s=in.readLine()) !=null) {
				out.println(s);
			}
			in.close();	
			out.close();
			
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void AnadirArticulo(String file,ShoppingArticle[] nuevo) {
		int fila=nuevo[0].getNUMATRIBUTOS();
		int longitud = nuevo.length; 
		
		
		try {
			//BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out=new PrintWriter(new FileWriter(file, false)); // con true hago append
			//System.out.println("tipee algo, y presione CTRL-Z para salir");
						
			// RECORDAD añadir si el numero de atributos del shoppingArticle es distinto de 4.
			for (int i = 0; i< fila; i++) {
				for (int j=0 ; j < longitud; j++ ) {
					if(j == 0 && i == 0) {
						out.print("nombre");						
					}else if(i == 0) {
						out.print(";" + nuevo[j].getNombre());
					}else if(j == 0 && i == 1) {
						out.print("precio");						
					}else if(i == 1) {
						out.print(";" + nuevo[j].getPrecio());
					
					}else if(j == 0 && i == 2) {
						out.print("categoria");	
					}else if( i == 2) {
						out.print(";" + nuevo[j].getCategoria());
					
					}if(j == 0 && i == 3) {
						out.print("unidad");						
					}else if( i == 3) {
						out.print(";" + nuevo[j].getUnidad());
					}
						
				}
				out.print("\n");	
			}
			out.close();
			
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	
}
