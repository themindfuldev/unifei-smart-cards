package smartsystem;


/**
 * Representa uma aplicação que terá suas preferências gerenciadas.
 * 
 * @author Tiago
 */
public class Aplicacao extends No
{
	/**
	 * Indica se a aplicação está ativa.
	 */
	private boolean ativa;
	/**
	 * Identificador da aplicação.
	 */
	private byte id;
	/**
	 * Nome da aplicação.
	 */
	private byte[] nome;
	/**
	 * Lista de preferências da aplicação.
	 */
	private ListaLigada listaPreferencias;

	/**
	 * Construtor.
	 * 
	 * @param id
	 * @param nome
	 * @param ativa
	 */
	public Aplicacao(byte id, byte[] nome, boolean ativa)
	{
		this.ativa = ativa;
		this.id = id;
		this.nome = nome;

		listaPreferencias = new ListaLigada();
	}

	public boolean getAtiva()
	{
		return ativa;
	}

	public byte getId()
	{
		return id;
	}

	public byte[] getNome()
	{
		return nome;
	}

	public void setAtiva(boolean ativa)
	{
		this.ativa = ativa;
	}

	public void setNome(byte[] nome)
	{
		this.nome = nome;
	}

	public ListaLigada getListaPreferencias()
	{
		return listaPreferencias;
	}

}
