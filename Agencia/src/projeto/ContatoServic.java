package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conexao.BancoDados;

public class ContatoServic {

	Contato contato = new Contato();
	Scanner sc = new Scanner(System.in);

	public void adicionar() {

		System.out.println("Digite o nome para contato: ");
		contato.setNome(sc.nextLine());
		System.out.println("Digite o email para contato: ");
		contato.setEmail(sc.nextLine());

		String sql = "INSERT INTO Contato(nome,email) VALUES(?,?)";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, contato.getNome());
			psmt.setString(2, contato.getEmail());

			psmt.execute();
			System.out.println("Contato cadastrato com sucesso!! ");

			conn.close();
			psmt.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void deletar() {

		System.out.println("Digite o id de contato: ");
		contato.setId(sc.nextInt());

		String sql = "DELETE FROM Contato where id = ?";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, contato.getId());

			psmt.execute();
			System.out.println("Deletado com sucesso!! ");

			conn.close();
			psmt.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void atualizar() {

		System.out.println("Digite o id de contato: ");
		contato.setId(sc.nextInt());
		System.out.println("Digite o nome: ");
		sc.nextLine();
		contato.setNome(sc.nextLine());
		System.out.println("Digite o email: ");
		contato.setEmail(sc.nextLine());

		String sql = "UPDATE Contato set nome = ?,email = ? where id = ?";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, contato.getNome());
			psmt.setString(2, contato.getEmail());
			psmt.setInt(3, contato.getId());

			psmt.execute();
			System.out.println("Atualizado com sucesso!! ");

			conn.close();
			psmt.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static List<Contato> listar() {

		String sql = "SELECT * FROM Contato";

		List<Contato> contatos = new ArrayList<Contato>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;

		try {
			conn = BancoDados.createConnection();
			psmt = conn.prepareStatement(sql);
			rset = psmt.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();

				contato.setNome(rset.getString("nome"));
				contato.setEmail(rset.getString("email"));
				contatos.add(contato);
			}

			conn.close();
			psmt.close();
			rset.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
			return contatos;
	}
}
