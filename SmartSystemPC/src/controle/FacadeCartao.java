package controle;

import smartsystem.IGerente;
import smartsystem.IModulo;
import smartsystem.IPrincipal;
import smartsystem.IUsuario;

import com.sun.javacard.clientlib.ApduIOCardAccessor;
import com.sun.javacard.clientlib.CardAccessor;
import com.sun.javacard.rmiclientlib.JCRMIConnect;

/**
 * Facade de acesso a um cartão.
 * 
 * @author Tiago
 */
public class FacadeCartao
{
	/**
	 * Recurso de acesso ao cartão.
	 */
	private CardAccessor ca;
	/**
	 * Interface inicial de comunicação com o cartão.
	 */
	private IPrincipal principal;
	/**
	 * Modulo atual.
	 */
	private IGerente gerente;
	
	private IUsuario usuario;
	
	private byte tipo;

	/**
	 * Construtor.
	 * 
	 * @throws Exception
	 */
	public FacadeCartao() throws Exception
	{
		// Instancia os recursos para o acesso.
		ca = new ApduIOCardAccessor();
		JCRMIConnect jcRMI = new JCRMIConnect(ca);

		// Seleciona a aplicação
		byte[] appAID = new byte[]
		{ 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x00, 0x00 };
		byte[] sw = jcRMI.selectApplet(appAID, JCRMIConnect.REF_WITH_CLASS_NAME);

		if (sw[0] == 0x6d && sw[1] == 0x00)
			throw new Exception("Nao foi possivel selecionar a aplicacao.");

		// Obtém a interface de comunicação.
		principal = (IPrincipal) jcRMI.getInitialReference();
	}

	/**
	 * Tenta realizar login no cartão.
	 * 
	 * @param nome
	 * @param senha
	 * @return Se a operação teve sucesso.
	 */
	public boolean fazerLogin(String nomeStr, String senhaStr) throws Exception
	{
		// Declaração de variáveis
		boolean retorno;

		byte[] nome = nomeStr.getBytes();
		byte[] senha = senhaStr.getBytes();
		
		// Tenta fazer login
		IModulo modulo = (IModulo) principal.fazerLogin(nome, senha);

		if (modulo != null)
		{
			retorno = true;
			
			tipo = modulo.getTipo();
			
			switch (tipo)
			{
				case IModulo.GERENTE:
					gerente = (IGerente) modulo.getModulo();
					usuario = null;
					break;
					
				case IModulo.USUARIO:
					usuario = (IUsuario) modulo.getModulo();
					gerente = null;
					break;
			}
		}
		else
			retorno = false;

		return retorno;
	}

	/**
	 * Libera os recursos.
	 */
	public void sair()
	{
		try
		{
			ca.closeCard();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean alterarSenha(String antigaSenhaStr, String novaSenhaStr) throws Exception
	{
		// Declaração de variáveis
		boolean retorno = false;

		byte[] antigaSenha = antigaSenhaStr.getBytes();
		byte[] novaSenha = novaSenhaStr.getBytes();
		
		// Tenta fazer login
		switch (tipo)
		{
			case IModulo.GERENTE:
				retorno = gerente.alterarSenha(antigaSenha, novaSenha);
				break;
				
			case IModulo.USUARIO:
				retorno = usuario.alterarSenha(antigaSenha, novaSenha);
				break;
		}
		
		return retorno;
	}

	public byte getTipo()
	{
		return tipo;
	}
	
	public boolean definirUsuario(String nomeStr) throws Exception
	{
		// Declaração de variáveis
		boolean retorno;

		byte[] nome = nomeStr.getBytes();
		
		// Tenta fazer login
		retorno = gerente.definirUsuario(nome);

		return retorno;
	}
	
	public boolean isUsuarioAtivo() throws Exception
	{
		return gerente.isUsuarioAtivo();
	}

	public String inserirAplicacao(String nomeStr) throws Exception
	{ 
		byte[] nome = nomeStr.getBytes();

		return Byte.toString(gerente.inserirAplicacao(nome));
	}

}
