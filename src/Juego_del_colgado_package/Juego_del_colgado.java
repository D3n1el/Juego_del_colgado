package Juego_del_colgado_package;

import java.util.Arrays;
import java.util.Scanner;

public class Juego_del_colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner (System.in);
		
		//Declaración de variables
		int tj = 0; //Total de jugadores
		String[] vidas = {"❤️", "❤️❤️", "❤️❤️❤️", "❤️❤️❤️❤️", "❤️❤️❤️❤️❤️", "❤️❤️❤️❤️❤️❤️"};
		
		System.out.println("|---------------------------|");
		System.out.println("|   El juego del ahorcado   |");
		System.out.println("|---------------------------|");
		
		while(true) { //Bucle que impide la introducción de numeros inválidos
			System.out.println("");
			System.out.print("Indica el numero de jugadores (Mínimo 2, Máximo 10): ");
				tj = s.nextInt();
			if (tj >= 2 && tj <= 10) {break;} //Al poner un número válido, sale del bucle para seguir la instrucción después de dicho bucle.
			System.out.println("¡NUMERO INVÁLIDO!");
		}
		
		String x = s.nextLine(); //String que permite que en el siguiente se pueda realizar.
		
		System.out.println("");
		System.out.print("Introduce la palabra a adivinar: ");
			String palabra = s.nextLine();
			palabra = palabra.toUpperCase();
			
		char[] palabraArray = new char[palabra.length()];
		char[] newArray = new char[palabra.length()];
		String[] strArray = new String[palabra.length()];
		
		for (int i = 0; i < palabra.length(); i++) {
			palabraArray[i] = palabra.charAt(i);
		}
		
			Arrays.fill(palabraArray, '_');
		
		
		for (int i = vidas.length - 1; i >= 0 ; i--) { //Contador de vidas
			System.out.println("");
			System.out.println(vidas[i]);
			
			for (int ii = 0; ii <= tj; ii++) {
				System.out.println("Turno para el jugador " + (ii + 1));
				
				for (int j = 0; j < palabraArray.length; j++) {
					System.out.print(palabraArray[j]);
				}
				
				System.out.println("");
				System.out.println("");
				System.out.print("Introduce una letra: ");
					String letra = s.nextLine();
					
					
					
				for (int j = 0; j < palabra.length(); j++) { //Cuenta cada letra del texto original	
					if (letra.charAt(0) == palabraArray[j]) {
						palabraArray[j] = letra.charAt(0);
					}
				}
						
			}
			
		}
		
	}

}
