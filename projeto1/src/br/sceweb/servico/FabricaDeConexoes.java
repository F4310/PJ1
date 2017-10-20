package br.sceweb.servico;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

/**
 * Está classe realiza a conexão com O BANCO DE DA DADOS
 * @author Lab103
 * @version 1.0
 */
public class FabricaDeConexoes {

	String url = "jdbc:mysql://localhost/sceweb";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root";
	String senha = "alunofatec";

	/**
	 * Cconfigura os parametros para conexão com o banco de dados
	 * @param configura
	 */
	public FabricaDeConexoes(ConfiguraDB configura) {
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}

	/**
	 * metodo vazio
	 */
	public FabricaDeConexoes() {

	}

	/**
	 * Este metodo faz de fato a conexão
	 * @return status da conexão
	 */
	public Connection getConnection() {
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (CommunicationsException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}
