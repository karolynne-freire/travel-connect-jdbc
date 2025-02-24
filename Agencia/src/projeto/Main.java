package projeto;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Boolean quadro = true;

		do {
			System.out.println("");
			System.out.println(" ----Agencia de turismo----- ");
			System.out.print("|----------------------------|\n");
			System.out.println("|0 -------- Finalizar -------|");
			System.out.println("|1 --------  Destino --------|");
			System.out.println("|2 -------- Cliente ---------|");
			System.out.println("|3 -------- Promoção --------|");
			System.out.println("|4 -------- Contato ---------| ");
			System.out.print("|----------------------------|\n");
			System.out.println("  Digite um numero de 1 à 4: ");
			int opcao = sc.nextInt();
			Contato contato = new Contato();
			Cliente cliente = new Cliente();
			Destino destino = new Destino();
			Promocao promocao = new Promocao();

			switch (opcao) {
			case 0:
				quadro = false;
				System.out.println("Programa finalizado, até breve!");
				break;
			case 1:
				destino.menu();
				break;
			case 2:
				cliente.menu();
				break;
			case 3:
				promocao.menu();
				break;
			case 4:
				contato.menu();
				break;
			default:
				System.out.println("Opção invalida, digite numero entre 1 à 4");
				break;
			}
		} while (quadro);

	}
}
