package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import conexao.BancoDados;

public class DestinoServic {
	
	Destino destino = new Destino();
	Scanner sc = new Scanner(System.in);

	
	public void adicionar(){
		
		System.out.println("Digite o nome do destino: ");
		destino.setNome(sc.nextLine());
		System.out.println("Digite o valor: ");
		destino.setValor(sc.nextDouble());
		System.out.println("Digite uma descrição: ");
		 String descricao = sc.nextLine();
		 destino.setDescricao(descricao);
		destino.setDescricao(sc.nextLine());
		
		String sql = "INSERT INTO Destino(nome,valor,descricao) VALUES(?,?,?)";
		
		Connection conn  = null;
		PreparedStatement psmt = null;
		
		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,destino.getNome());
			psmt.setDouble(2,destino.getValor());
			psmt.setString(3,destino.getDescricao());
			
			psmt.execute();
			System.out.println("Destino cadastrato com sucesso!! ");
			
			conn.close();
			psmt.close();

		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void deletar() {
		
		System.out.println("Digite o id do destino: ");
		destino.setId(sc.nextInt());
		
		String sql = "DELETE FROM Destino where id = ?";
		
		Connection conn  = null;
		PreparedStatement psmt = null;
		
		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setInt(1,destino.getId());

			psmt.execute();
			System.out.println("Deletado com sucesso!! ");
			
			conn.close();
			psmt.close();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	
	public void atualizar() {
		
		System.out.println("Digite o id de destino: ");
		destino.setId(sc.nextInt());
		System.out.println("Digite o nome: ");
		sc.nextLine();
		destino.setNome(sc.nextLine());
		System.out.println("Digite o valor: ");
		destino.setValor(sc.nextDouble());
		System.out.println("Digite uma descrição: ");
		destino.setDescricao(sc.nextLine());
		
		String sql = "UPDATE Destino set nome = ?,valor = ?,descricao = ? where id = ?";
		
		Connection conn  = null;
		PreparedStatement psmt = null;
		
		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,destino.getNome());
			psmt.setDouble(2,destino.getValor());
			psmt.setString(3,destino.getDescricao());
			psmt.setInt(4,destino.getId());

			psmt.execute();
			System.out.println("Atualizado com sucesso!! ");
			
			conn.close();
			psmt.close();
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
	}

	public static List<Destino> listar() {

		String sql = "SELECT * FROM Destino";

		List<Destino> destinos = new ArrayList<Destino>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			rset = psmt.executeQuery();

			while (rset.next()) {
				Destino destino = new Destino();

				destino.setNome(rset.getString("nome"));
				destino.setValor(rset.getDouble("valor"));
				destino.setDescricao(rset.getString("descricao"));
				destinos.add(destino);
			}

			conn.close();
			psmt.close();
			rset.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
			return destinos;
	}
}
