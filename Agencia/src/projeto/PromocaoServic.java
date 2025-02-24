package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conexao.BancoDados;

public class PromocaoServic {
	

	Destino destino = new Destino();
	Promocao promocao = new Promocao();
	Scanner sc = new Scanner(System.in);

	public void adicionar() {

		System.out.println("Digite o id do Destino: ");
		destino.setId(sc.nextInt());
		System.out.println("Digite o desconto: ");
		promocao.setDesconto(sc.nextInt());

		String sql = "INSERT INTO Promocao(id_destino,desconto) VALUES(?,?)";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, destino.getId());
			psmt.setInt(2, promocao.getDesconto());

			psmt.execute();
			System.out.println("Promocao cadastrata com sucesso!! ");

			conn.close();
			psmt.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void deletar() {

		System.out.println("Digite o id da promoção: ");
		promocao.setId(sc.nextInt());

		String sql = "DELETE FROM Promocao where id = ?";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, promocao.getId());

			psmt.execute();
			System.out.println("Deletado com sucesso!! ");

			conn.close();
			psmt.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void atualizar() {
		
		System.out.println("Digite o id da Promoção: ");
		promocao.setId(sc.nextInt());
		System.out.println("Digite o id do Destino: ");
		destino.setId(sc.nextInt());
		System.out.println("Digite o desconto: ");
		promocao.setDesconto(sc.nextInt());

		String sql = "UPDATE Promocao set id_destino = ?, desconto = ? where id = ?";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, destino.getId());
			psmt.setInt(2, promocao.getDesconto());
			psmt.setInt(3, promocao.getId());

			psmt.execute();
			System.out.println("Atualizado com sucesso!! ");

			conn.close();
			psmt.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static List<Promocao> listar() {

		String sql = "SELECT * FROM Promocao";

		List<Promocao> promocoes = new ArrayList<Promocao>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			rset = psmt.executeQuery();

			while (rset.next()) {
				Promocao promocao= new Promocao();
				
				promocao.setId(rset.getInt("id"));
				promocao.setDesconto(rset.getInt("desconto"));
				promocoes.add(promocao);
			}

			conn.close();
			psmt.close();
			rset.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
			return promocoes;
	}

}
