package br.com.bfg.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import com.mysql.jdbc.PreparedStatement;
import br.com.bfg.database.ConnectionDatabase;
import br.com.bfg.model.Conta;

public class ContaDao {


	public static void create(Conta conta) throws SQLException  {
		
		String query = 
				"INSERT INTO contas(numero, saldo, data_abertura, cliente) VALUES (?, ?, ?, ?); "
				+ "INSERT INTO cliente(cpf, nome, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionDatabase.createConnectionToMySQL();		
			pstm = (PreparedStatement) connection.prepareStatement(query);
			pstm.setInt(1, conta.getNumero());
			pstm.setFloat(2, conta.getSaldo());
			pstm.setDate(3, conta.getData_abertura().getTime());
			pstm.setLong(4, conta.getCliente().getCpf());
			
			pstm.setLong(5, conta.getCliente().getCpf());
			pstm.setString(6, conta.getCliente().getNome());
			pstm.setString(7, conta.getCliente().getData_nascimento());
			pstm.setLong(8, conta.getCliente().getTelefone());
			pstm.setString(9, conta.getCliente().getEmail());
			

			pstm.execute();
			
			System.out.println("Conta criada com sucesso: " + conta.getNumero() + " - " + conta.getCliente().getNome());
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (connection != null) {
					connection.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
}
