package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;
import br.sceweb.servico.ConfiguraDB;
/**
 * Este script de teste verifica o comportamento do caso de uso UC01CadastrarEmpresa
 * @author professor
 * @version 1.0
 *
 */
public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static ConfiguraDB configuraDB;
	static ConfiguraDB configuraDB1;
	
	/**
	 * Metodo que configura o ambiente para o teste
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String url = "jdbc:mysql://localhost/sceweb";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "";
		configuraDB = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	/**
	 * ID - CT01UC01FBCadastra_com_sucesso
	 * Objetivo - verificar o comportamento do sistema na inclusao de empresa com 
	 * sucesso
	 * Pré-condiçao - O cnpj 89424232000180 nao esta cadastrado.
	 */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		String url = "jdbc:mysql://localhost/sceweb";
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	/**
	 * Testa o valor do CNPJ para ser invalido
	 */
	@Test
	public void CT02UC01FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ invalido.",empresa.setCnpj("89424"));
	}
	
	/**
	 * Teste um valor de CNPJ já Cadastrado
	 */
	@Test
	public void CT03UC01FBCadastra_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	
	/**
	 * Tenta realizar um cadastro invalido
	 */
	@Test
	public void CT04UC01FBCadastra_db_invalido() {
		String url = "jdbc:mysql://localhost/sceweb1";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		configuraDB1 = new ConfiguraDB(url, driver,usuario,senha);
		empresaDAO = new EmpresaDAO(configuraDB);
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
		
	}
	
	/**
	 * Desfaz alterações feitas (executa após teste)
	 * @throws Exception
	 */
	@After
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}



