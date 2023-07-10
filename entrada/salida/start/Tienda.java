package start;

import java.util.ArrayList;

import model.Categorias;
import model.EscrituraCSV;
import model.LecturaCSV;
import model.ShoppingArticle;

public class Tienda {
	//Atributos Globales
	private static final String DIRRESBASEDATOS="C:\\Users\\Juancarlos.URREA-ECH\\Documents\\proyectoEclipse\\JavaIntermedio";
	
	//funciones
	private static ShoppingArticle[] cincoMascaros(ShoppingArticle[] lista) {
		ShoppingArticle[] articulosCaros = new ShoppingArticle[5];
		ShoppingArticle caro;
		boolean encontrado=false;
		
		lista = OrdenaPrecio(lista);
		
		for(int i= 0; i < 5;i++) {
			articulosCaros[i]= lista[i];
			
		}
		
		return  articulosCaros;
	}
	
	private static ShoppingArticle frutaMasVarata(ShoppingArticle[] lista) {
		ShoppingArticle barata= null;
				
		for(int i= 0; i < lista.length;i++) {
			if (lista[i].getCategoria() == Categorias.FRUTA ) {
				if (barata == null) {
					barata = lista[i];
				}else{
					if(barata.comparePrecioMismaCat(lista[i],Categorias.FRUTA) == 1) {
						barata = lista[i];
					}
				}
			}
		}
		
		
		return barata;
	}
	
	private static ArrayList<ShoppingArticle> vegetalMasCaro(ShoppingArticle[] lista) {
		ArrayList<ShoppingArticle> articulosCaros = new ArrayList<ShoppingArticle>();
		ShoppingArticle caro = null;
		int comparador=0;	
		
		for(int i= 0; i < lista.length;i++) {
			if (lista[i].getCategoria() == Categorias.VEGETAL ) {
				if( caro == null) {
					caro = lista[i];
				}else {
					comparador = caro.comparePrecioMismaCat(lista[i], Categorias.VEGETAL);
					if (comparador != 0) {
						if(comparador == 2 ) {
							caro = lista[i];			
						}
					}
				}
			}
		}
		articulosCaros.add(caro);
		
		
		
		for(int i= 0; i < lista.length;i++) {
			comparador = caro.comparePrecioMismaCat(lista[i], Categorias.VEGETAL);
			if ( comparador == 3 && !caro.getNombre().contains(lista[i].getNombre()) ) {
				articulosCaros.add(lista[i]);
			}
		}
		
		
		
		return  articulosCaros;
	}
	
	public static ArrayList<ShoppingArticle> separaCategoria(ShoppingArticle[] lista, Categorias tipo) {
		ArrayList<ShoppingArticle> separados = new ArrayList<ShoppingArticle>();
		
		for( int i = 0; i <lista.length;i++ ) {
			if (lista[i].getCategoria() == tipo) {
				separados.add(lista[i]);
			}
		}
		
		
		return separados;
	}
	
	public static ShoppingArticle[] OrdenaPrecio(ShoppingArticle[] lista) {
		ShoppingArticle comodin= new ShoppingArticle();
		
		for(int i =0; i < lista.length;i++)
			for (int j=i; j <lista.length-1;j++ ) {
				if ( !lista[i].compareCaro(lista[j+1])) {
					comodin = lista[i];
					lista[i] =lista[j+1];
					lista[j+1]= comodin;
				}
			}
		
		return lista;
	}
	
	//Metodo Main
	public static void main(String[] args) {
		final String NOMARCHIVO="\\shopping.csv";
		//Atributos
		int numArticulos=0;
		ShoppingArticle[] misProductos;
		ShoppingArticle articulo = new ShoppingArticle();
		ArrayList<ShoppingArticle> vegetalesCaros;
		ArrayList<ShoppingArticle> frutas;
		
		
		//LecturaCSV.LectorCSV(DIRRESBASEDATOS);
		
		//Asignacion
		numArticulos = LecturaCSV.NumProductos(DIRRESBASEDATOS+NOMARCHIVO);
		misProductos = new ShoppingArticle[numArticulos];
		misProductos = LecturaCSV.LectorCSV(DIRRESBASEDATOS+NOMARCHIVO);
		
		for (ShoppingArticle shoppingArticle : misProductos) {
			System.out.println("Nombre: " + shoppingArticle.getNombre() +
					"\nCategoria: " + shoppingArticle.getCategoria() +
					"\nPrecio: " + shoppingArticle.getPrecio() + 
					"\nUnidad:  " + shoppingArticle.getUnidad());
		}
		
	//Ejercicios	
		articulo = frutaMasVarata(misProductos);

		System.out.println("\n\nLa fruta mas barata\nNombre: " + articulo.getNombre() +
								"\nCategoria: " + articulo.getCategoria() +
								"\nPrecio: " + articulo.getPrecio() + 
								"\nUnidad:  " + articulo.getUnidad());
		
	
		//Vegetales mas baratos
		vegetalesCaros = vegetalMasCaro(misProductos);
	
		System.out.println("\nVegetal mas caro:\n");
		for (ShoppingArticle shoppingArticle : vegetalesCaros) {
			shoppingArticle.ImprimeDatos();
		}
		
		
		frutas = separaCategoria(misProductos, Categorias.FRUTA);
		
		System.out.println("\nFrutas:\n");
		for (ShoppingArticle shoppingArticle : frutas) {
			shoppingArticle.ImprimeDatos();
		}
		
			
		EscrituraCSV.AnadirArticulo(DIRRESBASEDATOS+"\\frutas.csv",cincoMascaros(misProductos));
		
		//EscrituraCSV.EscritorCSV(DIRRESBASEDATOS);
	}
}
