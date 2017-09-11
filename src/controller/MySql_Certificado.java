package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.Certificado;

public class MySql_Certificado {
	public static void getInsereCertificado(String descricao, int validade, double custo,
			double valor_comissao_contador, double valor_venda, double valor_a_vista) throws SQLException {

		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute(
				"insert into certificado (descricao,validade,custo, valor_venda, valor_comissao_contador, valor_a_vista) values ('"
						+ descricao + "','" + validade + "','" + custo + "','" + valor_venda + "','"
						+ valor_comissao_contador + "','" + valor_a_vista + "')");
		System.out.println("Teve algum erro? " + resultado);
		statement.close();
		connection.close();
	}

	public static void removeCertificado(Certificado c) throws SQLException {

		int id = c.getId();

		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("DELETE FROM certificado WHERE id = '" + id + "'");

		System.out.println("Teve algum erro? " + resultado);
		statement.close();
		connection.close();

	}
}
