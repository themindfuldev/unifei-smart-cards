package smartsystem;


/**
 * Lista ligada simples de <code>No</code>s.
 * 
 * @author Tiago
 * @see No
 */
public class ListaLigada
{
	/**
	 * Primeiro nó da lista.
	 */
	private No noPrimeiro;
	/**
	 * Tamanho da lista.
	 */
	private byte tamanho;

	/**
	 * Insere um nó no final da lista.
	 * 
	 * @param noNovo
	 * @return Se a operação obteve sucesso.
	 */
	public boolean inserirNoFinal(No noNovo)
	{
		return inserir(noNovo, tamanho);
	}

	/**
	 * Insere um nó em uma posição da lista.
	 * 
	 * @param noNovo
	 * @param posicao
	 * @return Se a operação obteve sucesso.
	 */
	public boolean inserir(No noNovo, byte posicao)
	{
		// Declaração de variáveis.
		No noIterador, noAuxiliar;
		byte contador;

		// Verifica condições de inserção.
		if (noNovo == null)
			return false;

		if (posicao > tamanho || posicao < 0)
			return false;

		// Inserção no início da lista.
		if (posicao == 0)
		{
			noNovo.setProximoNo(noPrimeiro);
			noPrimeiro = noNovo;

			tamanho++;
			return true;
		}

		// Inserção no meio da lista.
		noIterador = noPrimeiro;
		noAuxiliar = noIterador.getProximoNo();

		// // Percorre a lista até a posição e insere.
		for (contador = 1; noAuxiliar != null && contador <= posicao; contador++)
		{
			if (contador == posicao)
			{
				noIterador.setProximoNo(noNovo);
				noNovo.setProximoNo(noAuxiliar);

				tamanho++;
				return true;
			}

			noIterador = noAuxiliar;
			noAuxiliar = noAuxiliar.getProximoNo();
		}

		// // Realiza a inserção no final.
		if (noAuxiliar == null && contador == posicao)
		{
			noIterador.setProximoNo(noNovo);
			noNovo.setProximoNo(null);

			tamanho++;
			return true;
		}

		return false;
	}

	/**
	 * Remove um nó da lista.
	 * 
	 * @param noARemover
	 * @return Se a operação obteve sucesso.
	 */
	public boolean remover(No noARemover)
	{
		// Declaração de variáveis.
		No noIterador, noAuxiliar;
		byte contador;

		// Verifica condições de remoção.
		if (noARemover == null)
			return false;

		if (noARemover == noPrimeiro)
		{
			noPrimeiro = noPrimeiro.getProximoNo();

			tamanho--;
			return true;
		}

		// Remove o nó da lista.
		noIterador = noPrimeiro;

		// // Pesquisa o nó na lista, e remove.
		for (contador = 0; contador < tamanho; contador++)
		{
			if (noIterador.getProximoNo() == noARemover)
			{
				noAuxiliar = noARemover.getProximoNo();
				noIterador.setProximoNo(noAuxiliar);
				noARemover.setProximoNo(null);

				tamanho--;
				return true;
			}

			noIterador = noIterador.getProximoNo();
		}

		return false;
	}

	/**
	 * @param posicao
	 * @return O nó da posição desejada, ou <code>null</code> se não encontrou.
	 */
	public No get(byte posicao)
	{
		// Declaração de variáveis.
		No noIterador;
		byte contador;

		// Verifica condições de obtenção.
		if (posicao >= tamanho)
			return null;

		// Obtém um nó da lista.
		noIterador = noPrimeiro;
		contador = 0;

		// // Pesquisa o nó da lista, e ao encontrar interrompe a busca.
		for (contador = 0; noIterador != null && contador <= posicao; contador++)
		{
			if (contador == posicao)
				break;
			noIterador = noIterador.getProximoNo();
		}

		return noIterador;
	}

	/**
	 * @return O primeiro nó da lista, ou <code>null</code> se não existir.
	 */
	public No getPrimeiro()
	{
		return noPrimeiro;
	}

	/**
	 * @param noIterador
	 * @return O próximo nó da lista, ou <code>null</code> se não existir.
	 */
	public No getProximo(No noIterador)
	{
		return noIterador.getProximoNo();
	}

	/**
	 * @return O tamanho da lista.
	 */
	public byte getTamanho()
	{
		return tamanho;
	}

}
