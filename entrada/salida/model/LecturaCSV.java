package model;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class LecturaCSV {
	
	
// Lee un archivo pasandole la dirrecion.
	//para este proyecto tambien se optiene el numero de productos por medio del metodo NumProductos(file)
	//
	public static ShoppingArticle[] LectorCSV(String file) {
		ShoppingArticle[] lista= new ShoppingArticle[NumProductos(file)];
		String text;
		String s;
		int fila=0;
		 try {
			FileInputStream fs= new FileInputStream(file);
			DataInputStream ds=new DataInputStream(fs);
			
			while(true) {
				
				s=ds.readLine();
				if(s==null)break;
				StringTokenizer st= new StringTokenizer(s, ";");
				//System.out.println("tokens: " + st.countTokens());
				int cols=st.countTokens();
				text = st.nextToken();
				
				for(int i=0; i<cols-1;i++) {
					
					if(fila == 0) {
						lista[i] = new ShoppingArticle();
					}
					if(fila == 0) {
						text = st.nextToken();
						lista[i].setNombre(text);
					}else if(fila == 1) {
						text = st.nextToken();
						lista[i].setPrecio(Double.parseDouble(text));
					}else if(fila ==2) {
						text = st.nextToken();
						if (text.contains("fruta")) {
							lista[i].setCategoria(Categorias.FRUTA);
						}else
							lista[i].setCategoria(Categorias.VEGETAL);
					}else if(fila == 3) {
						text = st.nextToken();
						lista[i].setUnidad(Integer.parseInt(text));
					}
						
				}
	
				
		//		System.out.println();
				fila++;
			}
			fs.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		 
		return lista;
	}

//Metodo para calcular el numero de productos
	public static int NumProductos(String file ) {	
		int numArticle=0;
		String s;

		 try {
			FileInputStream fs= new FileInputStream(file);
			DataInputStream ds=new DataInputStream(fs);	
	
			s=ds.readLine();
			
			StringTokenizer st= new StringTokenizer(s, ";");
			numArticle=st.countTokens()-1;

			fs.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return numArticle;
	}
 	  
}
