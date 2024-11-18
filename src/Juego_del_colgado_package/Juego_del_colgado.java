package Juego_del_colgado_package;

import java.util.Scanner;

public class Juego_del_colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner (System.in);
		
		//Declaración de variables
		int tj = 0; //Total de jugadores
		int tr = 0; //Total de rondas
		String palabra = "";
		String p = "";
				
		System.out.println("|---------------------------|");
		System.out.println("|   El juego del ahorcado   |");
		System.out.println("|---------------------------|");
		
		while(true) { //Bucle que impide la introducción de numeros inválidos
			System.out.println("");
			System.out.print("Indica el numero de jugadores (Mínimo 2): ");
				tj = s.nextInt();
			if (tj >= 2) {break;} //Al poner un número válido, sale del bucle para seguir la instrucción después de dicho bucle.
			System.out.println("¡NUMERO INVÁLIDO!");
		}
		
		while(true) { //Bucle que impide la introducción de numeros inválidos
			System.out.println("");
			System.out.print("Indica el numero de rondas: ");
				tr = s.nextInt();
			if (tr >= 1) {break;} //Al poner un número válido, sale del bucle para seguir la instrucción después de dicho bucle.
			System.out.println("¡NUMERO INVÁLIDO!");
		}
		
		String x = s.nextLine(); //String que permite que en el siguiente se pueda realizar.
		
		System.out.println("");
		System.out.println("Introduce la palabra a adivinar:");
			palabra = s.nextLine(); //Guarda la palabra a adivinar
			p = palabra.toUpperCase(); //Pasa todo el texto a mayúsculas
			p = palabra.replaceAll("[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ]", "□"); //censura todas las letras a □
		
		for (int i = 0; i < tr; i++) {
			
			for (int ii = 0; ii < tj; ii++) {
				System.out.print("Turno para el jugador " + ii);
				System.out.print(palabra);
				
				System.out.println("");
				System.out.print("Introduce un letra: ");
					String letra = s.nextLine();
				
			}
		}
		
		
		
		
	}

}
