package exercicio1;

import java.util.Scanner;

class SomarDoisNumeros {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]) {
		// declaracao de variaveis
		int a, 
			b, 
			soma;
		
		// le numeros
		System.out.print("Digite um número: ");
		a = input.nextInt();
		System.out.print("Digite um número: ");
		b = input.nextInt();
		
		// faz a soma
		soma = a + b;
		
		// mostra na tela;
		System.out.print("Soma: " + soma);

	}
}