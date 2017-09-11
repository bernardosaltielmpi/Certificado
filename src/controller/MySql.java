package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Midia;

public class MySql {
	
	
	public static void getInsereMidia(String descricao, int quantidade, double custo, double valor_venda, double valor_comissao_contador) throws SQLException {
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into midia (descricao,quantidade,custo, valor_venda, valor_comissao_contador) values ('"+descricao+"','"+quantidade+"','"+custo+"','"+valor_venda+"','"+valor_comissao_contador+"')");
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
	}
	
	public static Midia buscaMidia (int id) throws SQLException {
		
		Midia m = new Midia();
		Connection connection = Database.getConnection();
		
		Statement statement = connection.createStatement();
		
//		PreparedStatement stmt = connection.prepareStatement("select * from midia where id ="+id);
//		ResultSet resultSet = stmt.executeQuery();
		
		boolean resultado = statement.execute("select * from midia where id ="+id);
		if (resultado == false) {
			JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * MIDIA");
		}else {
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			m.setId(resultSet.getInt("id"));
			m.setDescricao(resultSet.getString("descricao"));
			m.setQuantidade(resultSet.getInt("quantidade"));
			m.setCusto(resultSet.getDouble("custo"));
			m.setPreco_venda(resultSet.getDouble("valor_venda"));
			m.setValor_comissao(resultSet.getDouble("valor_comissao_contador"));
			
		}
		
		return m;
			
		
	}

	public static void editaMidia(Midia midiaEditar) throws SQLException {
		
		int id = midiaEditar.getId();
		String descricao = midiaEditar.getDescricao();
		int quantidade = midiaEditar.getQuantidade();
		double custo = midiaEditar.getCusto();
		double preco = midiaEditar.getPreco_venda();
		double comissao = midiaEditar.getValor_comissao();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("UPDATE midia SET descricao = '"+descricao+"', quantidade = '"+quantidade+"', custo = '"+custo+"', valor_venda= '"+preco+"', valor_comissao_contador = '"+comissao+"' WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
	}

	public static void removeMidia(Midia m) throws SQLException {
		
		int id = m.getId();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("DELETE FROM midia WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
		
	}
	
	
}
