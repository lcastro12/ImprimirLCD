package impresora;

import java.io.IOException;
import java.util.Scanner;
//Clase principal que recibe los números a imprimir
public class ImpresorLCD {
	

	public static void main(String args[]) throws IOException{
		
		 Scanner scan= new Scanner(System.in);
	        System.out.print("Ingresa los números que deseas imprimir en pantalla LCD \n");
	        try{
	        	//Se utiliza un while y un boolean para terminar el programa cuando el usuario coloque 0,0
	        	boolean continuar=true;
	        	while(continuar){
	        	// s va a guardar el número size,dígitos ingresado
	        	String s = scan.next();
	        		if(s.equals("0,0")){
	        			continuar=false;
	        		}
	        		//Realizamos split para obtener el tamaño y la cadena de String con los dígitos
	        		String[] numero = s.split(",");
	        		int size = Integer.parseInt(numero[0]);
	        		// Creamos un objeto Numero y le mandamos por parámetro los valores requeridos
	        		Numero numeroAImprimir = new Numero(size,numero[1]);
	        		
	        	String respuesta="";
	        	//Le pedimos al numero que nos retorne su cadena en LCD
	        	respuesta=numeroAImprimir.imprimirNumeros() ;
	        	//La mostramos por consola.
	        	System.out.println(respuesta);
	        	}
	        	//Cuando se ingresó 0,0 se debe detener el programa
	        	scan.close();
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }
	}

}
