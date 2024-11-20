package Juego_del_colgado_package;

import java.util.Scanner;

public class Juego_del_colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner (System.in);
		
		//Declaración de variables
		int tj = 0; //Total de jugadores
		String[] vidas = {"❤️", "❤️❤️", "❤️❤️❤️", "❤️❤️❤️❤️", "❤️❤️❤️❤️❤️", "❤️❤️❤️❤️❤️❤️"};
		String palabra = "";
		String p = "";
				
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
			palabra = s.nextLine(); //Guarda la palabra a adivinar
			palabra = palabra.toUpperCase(); //Pasa todo el texto a mayúsculas
			p = palabra.replaceAll("[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ]", "_ "); //censura todas las letras por "_"
		
		for (int i = vidas.length - 1; i >= 0 ; i--) { //Contador de vidas
			System.out.println("");
			System.out.println(vidas[i]);
			
			for (int ii = 1; ii <= tj; ii++) {
				System.out.println("Turno para el jugador " + ii);
				System.out.println(p);
				
				System.out.println("");
				System.out.print("Introduce una letra: ");
					String letra = s.nextLine();
					letra = letra.toUpperCase();
					
					for (int iii = 0; iii < palabra.length(); iii++) {
						char cpalabra = palabra.charAt(iii);
						char cletra = letra.charAt(0);
						
						if (cletra == cpalabra) {
							
							String P = "(?i)(?![" + cletra + "])\\w";
							p = palabra.replaceAll(P, " _");
							System.out.println("¡Acertaste!");
							System.out.println("");
						}
						
					}
				
				
			}
			
		}
		
	}

}
