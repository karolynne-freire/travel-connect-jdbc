package projeto;

import java.util.Scanner;

public class Contato {

	private Integer id;
	private String nome;
	private String email;

	public Contato() {
	}

	public Contato(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void menu(){
		Scanner sc = new Scanner(System.in);		
		Boolean quadro = true;
		
		do {
			System.out.println("");
			System.out.println(" ----Banco de contato----- ");
			System.out.print("|-----------------------|\n");
			System.out.println("|0 -------- Sair -------|");
			System.out.println("|1 --- Inserir contato--|");
			System.out.println("|2 --Atualizar contato--|");
			System.out.println("|3 ---Deletar contato---|");
			System.out.println("|4 ---Listar contato----| ");
			System.out.print("|-----------------------|\n");
			System.out.println("  Digite um numero de 1 à 4: ");
			int opcao = sc.nextInt();
			ContatoServic contatoServic = new ContatoServic();
			
			switch(opcao) {
			case 0 :
			quadro = false;
			System.out.println("Banco de contato Finalizado");
			break;
			case 1:
				contatoServic.adicionar();
				break;
			case 2:
				contatoServic.atualizar();
				break;
			case 3:
				contatoServic.deletar();
				break;
			case 4:
				contatoServic.listar();
				for(Contato c: ContatoServic.listar()) {
					System.out.println("Contatos: " + "Nome: " + c.getNome() + ", Email: " + c.getEmail());
				}
				break;
			default:
				System.out.println("Opção invalida, digite numero entre 1 à 4");
				break;
			}
		}while(quadro);	
	}
}
