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
		boolean acierto = false;
		
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
		
		for (int i = 0; i < palabra.length(); i++) {
			palabraArray[i] = palabra.charAt(i);
			newArray[i] = palabra.charAt(i);
		}
		
		Arrays.fill(newArray, '_'); //Sustituye las letras de cada posición por _
		
		for (int i = vidas.length - 1; i >= 0 ; i--) { //Contador de vidas
			System.out.println("");
			System.out.println(vidas[i]);
			
			for (int ii = 1; ii <= tj; ii++) {
				System.out.println("Turno para el jugador " + ii);
				
				for (int j = 0; j < newArray.length; j++) {
					System.out.print(newArray[j]);
				}
				
				System.out.println("");
				System.out.println("");
				System.out.print("Introduce una letra: ");
					String letra = s.nextLine();
					
				char[] letraArray = new char[ii + 1]; //Usa la posición de ii. Si no se suma 1 a su posición, el programa da error y no deja continuar
				letraArray[ii] = letra.toUpperCase().charAt(0);
				
				for (int j = 0; j < palabraArray.length; j++) { //Cuenta cada posición del array sin _
					for (int k = 0; k < letraArray.length; k++) { //Cuenta la posición de las letras introducidas para intentar adivinar la palabra.
						if (letraArray[k] == palabraArray[j]) { //Compara cada letra de letraArray buscando si es igual que la introducida en palabraArray
							newArray[j] = letraArray[k]; //En caso de que lo sea, sustituye el _ en esa posición dentro de newArray donde se encuetra la palabra coicidente.
						}
					}
				}
				
				for (int j = 0; j < newArray.length; j++) { //La finalidad de este bucle es revisar que todos los carácteres de newArray sean letras, y no _
					if (newArray[j] != '_'); { //Si la posición de newArray no es un _, cambia el estado de "acierto" a true
						acierto = true;
					}
					if (newArray[j] == '_') { //En cambio, si detecta alguna posición donde sí contenga _, el estado de "acierto" permanece en false. 
						acierto = false;
					}
				}
				
				if (acierto) { //En caso de haber acertado todas las letras, muestra la palabra completa y muestra un mensaje de enhorabuena.
					for (int j = 0; j < newArray.length; j++) {
						System.out.print(newArray[j]);
					}
					System.out.println("");
					System.out.println("★★★★★★★★★★★");
					System.out.println(" ¡VICTORIA! ");
					System.out.println("★★★★★★★★★★★");
					break;
				}
				
			}
			
			if (i == 0 && !acierto) { //Si no se han descubierto todas las palabras a tiempo, el juego finaliza y muestra un mensaje de derrota.
				System.out.println("");
				System.out.println("xxxxxxxxxxxx");
				System.out.println(" DERROTA... ");
				System.out.println("xxxxxxxxxxxx");
			}
			
			if (acierto) { //Si se gana, se cierra el juego.
				break;
			}
		}
	}
}
