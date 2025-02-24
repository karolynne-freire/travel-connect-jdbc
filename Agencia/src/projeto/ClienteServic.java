package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conexao.BancoDados;

public class ClienteServic {
	
	Cliente cliente = new Cliente();
	Scanner sc = new Scanner(System.in);


	
	public void adicionar(){
		
		System.out.println("Digite o nome: ");
		cliente.setNome(sc.nextLine());
		System.out.println("Digite o cpf: ");
		cliente.setCpf(sc.nextLine());
		
		String sql = "INSERT INTO Cliente(nome,cpf) VALUES(?,?)";
		
		Connection conn  = null;
		PreparedStatement psmt = null;
		
		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,cliente.getNome());
			psmt.setString(2,cliente.getCpf());
			
			psmt.execute();
			System.out.println("Cliente cadastrato com sucesso!! ");
			
			conn.close();
			psmt.close();

		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void deletar() {
		
		System.out.println("Digite o id do cliente: ");
		cliente.setId(sc.nextInt());
		
		String sql = "DELETE FROM Cliente where id = ?";
		
		Connection conn  = null;
		PreparedStatement psmt = null;
		
		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setInt(1,cliente.getId());

			psmt.execute();
			System.out.println("Deletado com sucesso!! ");
			
			conn.close();
			psmt.close();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	
	public void atualizar() {
		
		System.out.println("Digite o id do cliente: ");
		cliente.setId(sc.nextInt());
		System.out.println("Digite o nome: ");
		sc.nextLine();
		cliente.setNome(sc.nextLine());
		System.out.println("Digite o CPF: ");
		cliente.setCpf(sc.nextLine());
		
		String sql = "UPDATE Cliente set nome = ?,cpf = ? where id = ?";
		
		Connection conn  = null;
		PreparedStatement psmt = null;
		
		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,cliente.getNome());
			psmt.setString(2,cliente.getCpf());
			psmt.setInt(3,cliente.getId());

			psmt.execute();
			System.out.println("Atualizado com sucesso!! ");
			
			conn.close();
			psmt.close();
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
	}

	public static List<Cliente> listar() {

		String sql = "SELECT * FROM Cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			rset = psmt.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();

				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getString("cpf"));
				clientes.add(cliente);
			}

			conn.close();
			psmt.close();
			rset.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
			return clientes;
	}
}
