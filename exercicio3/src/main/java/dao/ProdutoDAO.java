package dao;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends DAO {
	public ProdutoDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Produto produto) {
		boolean status = false;
		try {  
			String sql = "INSERT INTO produto (codigo, nome, tipo) "
				       + "VALUES ("+produto.getCodigo()+ ", '" + produto.getNome() + "', '"  
				       + produto.getTipo() + "');";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Produto get(int codigo) {
		Produto produto = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE codigo=" + codigo;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	produto = new Produto(rs.getInt("codigo"), rs.getString("nome"), rs.getString("tipo"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
		
	public List<Produto> get() {
		return get("");
	}

	public List<Produto> getOrderByCodigo() {
		return get("codigo");		
	}
	
	public List<Produto> getOrderByNome() {
		return get("nome");		
	}
	
	public List<Produto> getOrderByTipo() {
		return get("tipo");		
	}
	
	private List<Produto> get(String orderBy) {	
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Produto u = new Produto(rs.getInt("codigo"), rs.getString("nome"), rs.getString("tipo"));
	            produtos.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	public boolean update(Produto produto) {
		boolean status = false;
		try {  
			String sql = "UPDATE produto SET nome = '" + produto.getNome() + "', tipo = '"  
				       + produto.getTipo() + "'"
					   + " WHERE codigo = " + produto.getCodigo();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM produto WHERE codigo = " + codigo;
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}
