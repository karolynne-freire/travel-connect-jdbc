package projeto;

import java.util.Scanner;

public class Promocao {
	
	private Integer id;
	private Integer desconto;
	
	
	
	public Promocao() {
	}
	public Promocao(Integer desconto) {
		super();
		this.desconto = desconto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDesconto() {
		return desconto;
	}
	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public void menu(){
		Scanner sc = new Scanner(System.in);		
		Boolean quadro = true;
		
		do {
			System.out.println("");
			System.out.println(" ----Banco de Promocao----- ");
			System.out.print("|-----------------------|\n");
			System.out.println("|0 -------- Sair -------|");
			System.out.println("|1 --- Inserir destino--|");
			System.out.println("|2 --Atualizar destino--|");
			System.out.println("|3 ---Deletar destino---|");
			System.out.println("|4 ---Listar destino----| ");
			System.out.print("|-----------------------|\n");
			System.out.println("  Digite um numero de 1 à 4: ");
			int opcao = sc.nextInt();
			PromocaoServic promocaoServic = new PromocaoServic();
			
			switch(opcao) {
			case 0 :
			quadro = false;
			System.out.println("Banco de destino Finalizado");
			break;
			case 1:
				promocaoServic.adicionar();
				break;
			case 2:
				promocaoServic.atualizar();
				break;
			case 3:
				promocaoServic.deletar();
				break;
			case 4:
				promocaoServic.listar();
				for(Promocao c: PromocaoServic.listar()) {
					System.out.println("Promocao: " + " ID da promoção: " + c.getId() + ", Desconto: " + c.getDesconto() + "%");
				}
				break;
			default:
				System.out.println("Opção invalida, digite numero entre 1 à 4");
				break;
			}
		}while(quadro);
		

	}


}
