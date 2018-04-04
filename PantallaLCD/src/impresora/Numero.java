package impresora;

import java.util.ArrayList;
import java.util.Collections;

/* Clase que representa un número size,dígitos*/
public class Numero {
	
	// Atributo que guarda el número de filas del número
	private int filas;
	// Atributo que guarda el número de columnas del número
	private int columnas;
	// Atributo que llega de consola referente al size de los dígitos
	private int size;
	//Cadena con los dígitos que deben ser impresos en LCD
	private String numeros;

/* Constructor de la clase, recibe por parámetro el size y la cadena String con los dígitos */
	public Numero(int size,String numeros){
		filas=(size*2)+3;
		columnas=size+2;
		this.numeros=numeros;
		this.size=size;

	}

	public int darSize(){
		return filas;
	}

	public String darNumeros(){
		return numeros;
	}

	/* Método que retorna una lista con cada dígito de la cadena String numeros */
	public ArrayList<Integer> darListaNumeros(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		String[] strings=numeros.split("");
		for(int i=0;i<strings.length;i++){
			int nuevo=Integer.parseInt(strings[i]);
			lista.add(nuevo);
		}
		return lista;
	}

	/*Método que retorna una cadena String con todos los dígitos solicitados (de un solo número)de forma LCD */
	public String imprimirNumeros(){
		// lcd es una lista que va a guardar las cadenas String de cada fila del número en conjunto
		ArrayList<String> lcd = new ArrayList<String>();
		String espacio=" ";
		String vertical= "|";
		String horizontal="_";
		ArrayList<Integer> numeros = darListaNumeros();
		String combinacion1=" _";
		String combinacion2="|_";
		String combinacion3=" _|";
		int j=filas;
		int medio=(int)(filas/2)+1;
		int primo = 2*(size-1) + 1;
		// Se hace un recorrido por el número de filas, para ir formando cada fila
		while(j!=0){
			//String fila va a ir guardando la forma en que se dibuja cada número en esa fila, por lo tanto, se debe ir concatenando para no perder ningún número
			String fila="";
			//Se debe recorrer el conjunto de números para ir pintando cada número en la fila actual
			for(int i=0;i<numeros.size();i++){
				int numero = numeros.get(i);
				// Se va tomando cada número y según el caso se pinta | y _ para formarlo
				if(numero==0){
					// Cuando j es igual a filas significa que estamos en la primera fila (de arriba hacia abajo)
					if(j==filas){
						// En este caso estamos concatenando la combinacion 1, es decir, " _" para lograr la primera fila del 0.
						// Dependiendo del tamaño, se concatenan size veces la combinación, esto para respetar el número de columnas que debe tener el número
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio+espacio;
					}
				//Para respetar el número de filas necesarias, no se dibuja nada en las dos últimas filas (de arriba hacia abajo)
					else if(j==3){
						if(size>1){
							fila+=combinacion2+String.join("", Collections.nCopies(columnas-4, combinacion1))+combinacion3+espacio;}
						else{
							fila+=combinacion2+vertical+espacio;}
					}
					else if(j!=1 && j!=2){
						fila+=vertical+String.join("", Collections.nCopies(primo, espacio))+vertical+espacio;
					}
				}
				//Se realiza este procedimiento para todos los números, adicionando | o _ según sesa el caso para lograr el resultado final
				//Para evitar revisar cada caso, se utiliza else if
				else if(numero==1){
					if(j==filas || j==2){
						fila+=espacio+espacio;}
					else if(j!=1){
						fila+=vertical+espacio;
					}
				}
				else if(numero==2){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio+espacio;
					}
					else if(j==medio+1){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+vertical+espacio;
					}
					else if(j==3){
						fila+=combinacion2+String.join("", Collections.nCopies(size-1, combinacion1))+espacio+espacio;
					}
					else if(j>medio+1){
						fila+=String.join("", Collections.nCopies(size*2, espacio))+vertical+espacio;
					}
					else if(j<medio+1 && j>3){
						fila+=vertical+String.join("", Collections.nCopies((size*2)+1, espacio));
					}

				}
				else if(numero==3){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio+espacio;
					}
					else if(j==medio+1 || j==3){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+vertical+espacio;
					}
					else if(j>3){
						fila+=String.join("", Collections.nCopies(primo+1, espacio))+vertical+espacio;
					}
				}
				else if(numero==4){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(columnas, espacio))+espacio;
					}
					else if(j==medio+1){
						fila+=vertical+String.join("", Collections.nCopies(size, horizontal))+vertical+espacio;
					}
					else if(j>medio+1 ){
						fila+=vertical+String.join("", Collections.nCopies(size, espacio))+vertical+espacio;
					}
					else if(j>=3 && j<medio+1){
						fila+=String.join("", Collections.nCopies(size+1, espacio))+vertical+espacio;
					}
				}
				else if(numero==5){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio;
					}
					else if(j==medio+1){
						fila+=combinacion2+String.join("", Collections.nCopies(size-1, combinacion1))+espacio;
					}
					else if(j==3){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+vertical;
					}
					else if(j>medio+1){
						fila+=vertical+String.join("", Collections.nCopies(size*2, espacio));
					}
					else if(j<medio+1 && j>3){
						fila+=String.join("", Collections.nCopies(size*2, espacio))+vertical;
					}
				}
				else if(numero==6){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio+espacio;
					}
					else if(j==medio+1){
						fila+=combinacion2+String.join("", Collections.nCopies(size-1, combinacion1))+espacio+espacio;
					}
					else if(j==3){
						fila+=combinacion2+String.join("", Collections.nCopies(size-1, combinacion1))+vertical+espacio;
					}
					else if(j>medio+1){
						fila+=vertical+String.join("", Collections.nCopies(size*2, espacio))+espacio;
					}
					else if(j<medio+1 && j>3){
						fila+=vertical+String.join("", Collections.nCopies((size*2)-1, espacio))+vertical+espacio;
					}
				}
				else if(numero==7){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio+espacio;}
					else if(j==2){
						fila+=String.join("", Collections.nCopies(size, espacio))+espacio;
					}
					else if(j!=1){
						fila+=String.join("", Collections.nCopies(primo+1, espacio))+vertical+espacio;
					}
				}
				else if(numero==8){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio;
					}
					else if(j==medio+1 || j==3){
						fila+=combinacion2+String.join("", Collections.nCopies(size-1 ,combinacion1))+vertical;
					}
					else if(j>3){
						fila+=vertical+String.join("", Collections.nCopies(primo, espacio))+vertical;
					}

				}
				else if(numero==9){
					if(j==filas){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+espacio+espacio;
					}
					else if(j==medio+1){
						fila+=combinacion2+String.join("", Collections.nCopies(size-1, combinacion1))+vertical+espacio;
					}
					else if(j==3){
						fila+=String.join("", Collections.nCopies(size, combinacion1))+vertical+espacio;
					}
					else if(j>medio+1){
						fila+=vertical+String.join("", Collections.nCopies(primo, espacio))+vertical+espacio;
					}
					else if(j>3){
						fila+=String.join("", Collections.nCopies(primo+1, espacio))+vertical+espacio;
					}
				}
			}
			//De esta forma obtenemos una fila y la agregamos a la lista lcd
			lcd.add(fila);
			//Para continuar con el recorrido disminuimos en 1 la variable j
			j=j-1;
		}
		//Al terminar de imprimir todas las lineas unimos todas las filas o cadenas de String para cada fila en una sola variable y utilizamos \n para saltar a cada fila.
		String respuesta="";
		//Debido a la solución planteada
		for(int i=0;i<lcd.size()-2;i++){
			//Se realiza esta condición para evitar tener más de una línea entre dos números solicitados simultáneamente
			if(i==lcd.size()-3){
				respuesta+=lcd.get(i);
			}
			else
			respuesta+=lcd.get(i) + "\n";
		}
		return respuesta;
	}
}
