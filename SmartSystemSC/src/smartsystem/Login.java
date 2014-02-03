package smartsystem;


/**
 * Representa um login com permissão de acesso ao sistema.
 * 
 * @author Tiago
 */
public class Login extends No
{
	/**
	 * Id do login.
	 */
	protected byte[] id;
	/**
	 * Senha do login.
	 */
	protected byte[] senha;
	/**
	 * Modulo que o login corresponderá.
	 */
	protected IModulo modulo;

	/**
	 * Construtor.
	 * 
	 * @param nome
	 * @param senha
	 */
	public Login(byte[] nome, byte[] senha)
	{
		super();
		this.id = nome;
		this.senha = senha;
	}

	byte[] getId()
	{
		return id;
	}

	void setId(byte[] nome)
	{
		this.id = nome;
	}

	byte[] getSenha()
	{
		return senha;
	}

	void setSenha(byte[] senha)
	{
		this.senha = senha;
	}

	IModulo getModulo()
	{
		return modulo;
	}

}
