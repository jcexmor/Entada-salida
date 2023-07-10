package model;

import java.util.ArrayList;

//Clase que da estructura al objeto que representa un articulo para la tienda
public class ShoppingArticle {
	// atributos
	private String nombre;
	private Categorias categoria;
	private double precio;
	private int unidad;
	private final int NUMATRIBUTOS=4;
	
	// metodos propios
	
	public void ImprimeDatos(String text) {
		System.out.println(text +this.getNombre() +
				"\nCategoria: " + this.getCategoria() +
				"\nPrecio: " + this.getPrecio() + 
				"\nUnidad:  " + this.getUnidad() +"\n");

	}
	public void ImprimeDatos() {
		System.out.println(this.getNombre() +
				"\nCategoria: " + this.getCategoria() +
				"\nPrecio: " + this.getPrecio() + 
				"\nUnidad:  " + this.getUnidad()+"\n");

	}

	// Valores a debolver en la variable caro --> 0:distinta ctegoria   1: this mas caro   2: this menos caro  3: iguales
	public int comparePrecioMismaCat( ShoppingArticle otro , Categorias categoria) {
		int caro=1;
		
		if (this.categoria != categoria && this.categoria != otro.categoria) {
			caro=0;
		}else if (this.precio < otro.precio ) {
			caro=2;
		}else if(this.precio == otro.precio){
			caro=3;
		}
		
		return caro;
	}
	
	public boolean compareCaro( ShoppingArticle otro) {
		boolean caro = true;
		
		if (this.precio < otro.precio)
			caro= false;
		
		return caro;
	}

	// metodos Get/Set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getUnidad() {
		return unidad;
	}
	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}
	public int getNUMATRIBUTOS() {
		return NUMATRIBUTOS;
	}

	
	
}
