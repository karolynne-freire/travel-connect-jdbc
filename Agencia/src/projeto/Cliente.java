package projeto;

import java.util.Scanner;

public class Cliente {

	private Integer id;
	private String nome;
	private String cpf;

	public Cliente() {

	}

	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void menu(){
		Scanner sc = new Scanner(System.in);		
		Boolean quadro = true;
		
		do {
			System.out.println("");
			System.out.println(" ----Banco de cliente----- ");
			System.out.print("|-----------------------|\n");
			System.out.println("|0 -------- Sair -------|");
			System.out.println("|1 --- Inserir cliente--|");
			System.out.println("|2 --Atualizar cliente--|");
			System.out.println("|3 ---Deletar cliente---|");
			System.out.println("|4 ---Listar cliente----| ");
			System.out.print("|-----------------------|\n");
			System.out.println("  Digite um numero de 1 à 4: ");
			int opcao = sc.nextInt();
			ClienteServic clienteServic = new ClienteServic();
			
			switch(opcao) {
			case 0 :
			quadro = false;
			System.out.println("Banco de cliente Finalizado");
			break;
			case 1:
				clienteServic.adicionar();
				break;
			case 2:
				clienteServic.atualizar();
				break;
			case 3:
				clienteServic.deletar();
				break;
			case 4:
				clienteServic.listar();
				for(Cliente c: ClienteServic.listar()) {
					System.out.println("Clientes: " + "Nome: " + c.getNome() + ", CPF: " + c.getCpf());
				}
				break;
			default:
				System.out.println("Opção invalida, digite numero entre 1 à 4");
				break;
			}
		}while(quadro);
		

	}
}
