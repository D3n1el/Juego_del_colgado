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
		String P = "";
				
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
		
		System.out.println("Introduce la palabra a adivinar:");
			palabra = s.nextLine();
			palabra = palabra.toUpperCase();
			palabra = palabra.replaceAll("[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ]", "□");
		
	}

}
