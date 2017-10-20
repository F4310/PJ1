package br.sceweb.servico;

/**
 * Está classe Configura a conexão com o banco de dados
 * @author Lab103
 * @version 1.0
 *
 */
public class ConfiguraDB {
	String url = "";
	String driver = "";
	String usuario = "";
	String senha = "";
	
	/**
	 * Este metodo configura os parametros para conexão com o banco
	 * @param url
	 * @param driver
	 * @param usuario
	 * @param senha
	 */
	public ConfiguraDB(String url, String driver, String usuario, String senha) {
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	/**
	 * Este medoto pega o valor URL
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Este metodo pega o valor Driver
	 * @return driver
	 */
	public String getDriver() {
		return driver;
	}
	
	/**
	 * Este metodo pega o valor de usuario
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * Este metodo pega o valor de senha
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	
}