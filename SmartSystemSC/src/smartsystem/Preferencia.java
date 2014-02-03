package smartsystem;


/**
 * Representa uma preferência de uma aplicação.
 * 
 * @author Tiago
 */
public class Preferencia extends No
{
	/**
	 * Identificador da preferência.
	 */
	private byte id;
	/**
	 * Nome da preferência.
	 */
	private byte[] nome;
	/**
	 * Valor da preferência.
	 */
	private byte[] valor;

	/**
	 * Construtor.
	 * 
	 * @param id
	 * @param nome
	 * @param valor
	 */
	public Preferencia(byte id, byte[] nome, byte[] valor)
	{
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public byte getId()
	{
		return id;
	}

	public byte[] getNome()
	{
		return nome;
	}

	public byte[] getValor()
	{
		return valor;
	}

	public void setValor(byte[] valor)
	{
		this.valor = valor;
	}

}
