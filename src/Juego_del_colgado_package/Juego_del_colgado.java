package Juego_del_colgado_package;

import java.util.Arrays;
import java.util.Scanner;

public class Juego_del_colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner (System.in);
		
		//Declaración de variables
		int tj = 0; //Total de jugadores
		int tr = 0; //Total de rondas
		int cv = 5; //Total de vidas
		boolean acierto = false; //Variable que detemrina si ha acertado la palabra entera
		boolean aciertoLetra = false; //Variable que detecta si ha acertado la letra correcta. 
		boolean ganador = false; //Variable que detecta quien ha ganado.
		boolean noEmpate = false; //Variable que asegura que no ha habido empate al finalizar la partida.
		String[] vidas = {"❤", "❤️❤️", "❤️❤️❤️", "❤️❤️❤️❤️", "❤️❤️❤️❤️❤️", "❤️❤️❤️❤️❤️❤️"}; //Las vidas
		
		System.out.println("|---------------------------|");
		System.out.println("|   EL JUEGO DEL AHORCADO   |");
		System.out.println("|---------------------------|");
		
		while(true) { //Bucle que impide la introducción de numeros inválidos
			System.out.println("");
			System.out.print("Indica el numero de jugadores (Mínimo 2, Máximo 10): ");
				tj = s.nextInt();
			if (tj >= 2 && tj <= 10) {break;} //Al poner un número válido, sale del bucle para seguir la instrucción después de dicho bucle.
			System.out.println("¡NUMERO INVÁLIDO!");
		}
		
		while(true) { //Bucle que impide la introducción de numeros inválidos
			System.out.println("");
			System.out.print("Indica el numero de rondas (Mínimo 1): ");
				tr = s.nextInt();
			if (tr >= 1) {break;} //Al poner un número válido, sale del bucle para seguir la instrucción después de dicho bucle.
			System.out.println("¡NUMERO INVÁLIDO!");
		}
		
		String x = s.nextLine(); //String que permite que en el siguiente se pueda realizar.
		
		System.out.println("");
		System.out.print("Introduce la palabra a adivinar: ");
			String palabra = s.nextLine();
			palabra = palabra.toUpperCase(); //Convierte la palabra a mayúsculas
			
		//La largada del array es la misma que la largada del texto original tipo String.
		char[] palabraArray = new char[palabra.length()]; //Declaración del array que contiene la palabra original dividida en letras.
		char[] newArray = new char[palabra.length()]; //Declaración del array que contiene la palabra censurada dividida en letras.
		int[] puntos = new int[tj]; //Array que cuenta los puntos de cada posición por jugador.
		
		for (int i = 0; i < palabra.length(); i++) { 
			palabraArray[i] = palabra.charAt(i); //Pasa cada carácter de la palabra original en el array que mantendrá las letras
			newArray[i] = palabra.charAt(i); //Pasa cada carácter de la palabra original en el array que sustituirá las letras por _
		}
		
		Arrays.fill(newArray, '_'); //Sustituye las letras de cada posición por _
		
		for (int i = 1; i <= tr; i++) { //Contador de rondas
			System.out.println("");
			System.out.println("RONDA " + i); //Muestra la rondas
			
			for (int ii = 0; ii < tj; ii++) { //Contador de jugadores
				System.out.println("");
				System.out.print("Turno para el jugador " + (ii + 1) + "  ~"); //Muestra el jugador
				
				aciertoLetra = false; //Cada vez que un jugador empieza un turno, el estado de aciertoLetra cambia a false.
				
					cv = 5; //Cada vez que un jugador empieza su turno, el contador de vidas se reinicia. 
				
					while (cv >= 0) {
						
						System.out.println("  " + vidas[cv]);
				
						for (int j = 0; j < newArray.length; j++) { //Muestra la palabra censurada
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
									aciertoLetra = true;
								}
							}
						}
						
						if (aciertoLetra) { //Si ha acertado la letra, manda un mensaje de enhorabuena.
							System.out.println("¡Acertaste!");

						} else if (!aciertoLetra) {
							System.out.print("Fallaste...  ~"); //Si ha fallado la letra, reduce el contador cv, que es el de la vida.
							cv--;
						}
						
						for (int j = 0; j < newArray.length; j++) { //La finalidad de este bucle es revisar que todos los carácteres de newArray sean letras, y no _
							if (newArray[j] == '_') { //En cambio, si detecta alguna posición donde sí contenga _, el estado de "acierto" permanece en false. 
								acierto = false;
								break;
							}
							if (newArray[j] != '_'); { //Si la posición de newArray no es un _, cambia el estado de "acierto" a true
								acierto = true;
							}
						}
						
						if (aciertoLetra) {System.out.println("Punto para el jugador " + (ii + 1)); puntos[ii]++; break;} //Con este break, el jugador que acaba de acertar finaliza su turno en la ronda. De esta forma, puede jugar ya el siguiente. Aparte, también suma 1 al contador de puntos del jugador y lo muestra.
					}
				
					if (acierto) { //En caso de haber acertado todas las letras, muestra la palabra completa y muestra un mensaje de enhorabuena.
						for (int j = 0; j < newArray.length; j++) {
							System.out.print(newArray[j]); //Muestra la palabra, ya adivinada
						}
						System.out.println("");
						System.out.println("");
						System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
						System.out.println(" ¡FELICIDADES, HABÉIS ADIVINADO LA PALABRA! ");
						System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
						break;
					}
			
			}
			
			System.out.println(""); //Muestra los puntos por cada jugador
			System.out.println("PUNTOS TOTALES");
			for (int ii = 0; ii < tj; ii++) { //Muestra los puntos de cada jugador
				System.out.println("Jugador " + (ii + 1)+ ": " + puntos[ii]);
			}
			
			if (acierto) {break;}
			
		}
		
		for (int j = 0; j < tj; j++) { //Por compara una puntuación de todos los jugadores, individualmente, con las del resto.
			for (int jj = 0; jj < tj; jj++) {
				if (puntos[j] > puntos[jj]) { //Realiza las comparaciones.
					ganador = true; //El jugador con más puntos es que mantenga el estado de la variable "ganador" hasta el final.
				} else { //De esta forma, si un jugador ha hecho más puntos que otro, pero menos que otro que acaba de comparar, entonces el estado de la variable ganador cambia a falso.
					ganador = false; 
				}
				if (ganador) { //Informa quién ha ganado más puntos
					System.out.println("");
					System.out.println("-----------------------------------------");
					System.out.println("  El jugador "+ (j + 1) +" ha conseguido más puntos");
					System.out.println("-----------------------------------------");
					noEmpate = true;
				}		
			}
		}
			
		if (!noEmpate) { //Si ha habido empate, muestra mensaje diciendo que han quedado empatados.
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("  Habéis quedado empatados");
			System.out.println("------------------------------");
		}
		
		if (!acierto) { //El mensaje que muestra en caso de derrota
			System.out.println("");
			System.out.println("   _______ ");
			System.out.println("   |/    O ");
			System.out.println("   |  ---|---");
			System.out.println("   |     |  ");
			System.out.println("   |    / \\");
			System.out.println("   |   /   \\ ");
			System.out.println("  ---");
		}
	}
}
