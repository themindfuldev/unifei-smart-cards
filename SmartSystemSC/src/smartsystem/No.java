package smartsystem;


/**
 * Nó genérico de uma lista ligada simples.
 * 
 * @author Tiago
 * @see ListaLigada
 */
public class No
{
	/**
	 * Próximo nó da lista.
	 */
	private No proximoNo;

	/**
	 * @return O próximo nó da lista.
	 */
	No getProximoNo()
	{
		return proximoNo;
	}

	/**
	 * Define o próximo nó da lista.
	 * 
	 * @param proximoNo
	 */
	void setProximoNo(No proximoNo)
	{
		this.proximoNo = proximoNo;
	}
}
