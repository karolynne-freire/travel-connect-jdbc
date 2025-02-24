package projeto;

import java.util.Scanner;

public class Destino {

	private Integer id;
	private String nome;
	private Double valor;
	private String descricao;

	
	
	
	
	
	public Destino() {
	
	}


	public Destino(String nome, Double valor, String descricao) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public void menu(){
		Scanner sc = new Scanner(System.in);		
		Boolean quadro = true;
		
		do {
			System.out.println("");
			System.out.println(" ----Banco de destino----- ");
			System.out.print("|-----------------------|\n");
			System.out.println("|0 -------- Sair -------|");
			System.out.println("|1 --- Inserir destino--|");
			System.out.println("|2 --Atualizar destino--|");
			System.out.println("|3 ---Deletar destino---|");
			System.out.println("|4 ---Listar destino----| ");
			System.out.print("|-----------------------|\n");
			System.out.println("  Digite um numero de 1 à 4: ");
			int opcao = sc.nextInt();
			DestinoServic destinoServic = new DestinoServic();
			
			switch(opcao) {
			case 0 :
			quadro = false;
			System.out.println("Banco de destino Finalizado");
			break;
			case 1:
				destinoServic.adicionar();
				break;
			case 2:
				destinoServic.atualizar();
				break;
			case 3:
				destinoServic.deletar();
				break;
			case 4:
				destinoServic.listar();
				for(Destino c: DestinoServic.listar()) {
					System.out.println("Destinos: " + "Nome: " + c.getNome() + ", Data de inicio: " + ", Valor: R$ " + c.getValor() + ", Descrição:" + c.getDescricao());
				}
				break;
			default:
				System.out.println("Opção invalida, digite numero entre 1 à 4");
				break;
			}
		}while(quadro);
		

	}

}
