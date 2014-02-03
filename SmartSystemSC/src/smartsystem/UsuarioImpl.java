package smartsystem;

import java.rmi.RemoteException;

import javacard.framework.service.CardRemoteObject;

/**
 * Implementação de Usuario.
 * 
 * @author Tiago
 */
public class UsuarioImpl extends Login implements IUsuario
{
	/**
	 * vCard do usuário.
	 */
	private IVCard vCard;
	/**
	 * Indica se o usuário está ativo.
	 */
	private boolean ativo;
	/**
	 * Gerente do sistema.
	 */
	private GerenteImpl gerente;

	/**
	 * Construtor.
	 * 
	 * @param nome
	 * @param senha
	 * @param gerente
	 */
	public UsuarioImpl(byte[] nome, byte[] senha, GerenteImpl gerente)
	{
		super(nome, senha);

		// Exportação de objeto remoto.
		CardRemoteObject.export(this);

		this.gerente = gerente;

		modulo = new ModuloImpl(this, IModulo.USUARIO);
		vCard = new VCardImpl();
	}

	/**
	 * @see modelo.IUsuario#alterarNome(byte[])
	 */
	public void alterarNome(byte[] nome) throws RemoteException
	{
		this.id = nome;
	}

	/**
	 * @see modelo.IUsuario#alterarSenha(byte[], byte[])
	 */
	public boolean alterarSenha(byte[] antigaSenha, byte[] novaSenha)
			throws RemoteException
	{
		// Declaração de variáveis.
		boolean corresponde;
		byte i;

		// Verifica pré-condições.
		if (novaSenha.length < 6)
			return false;

		corresponde = true;

		// Verifica senha antiga.
		for (i = 0; i < antigaSenha.length && corresponde == true; i++)
		{
			if (antigaSenha[i] != senha[i])
				corresponde = false;
		}

		// Se corresponder, altera.
		if (corresponde == true)
		{
			senha = novaSenha;
			return true;
		}

		return false;
	}

	/**
	 * @see modelo.IUsuario#inserirPreferencia(byte, byte[], byte[])
	 */
	public byte inserirPreferencia(byte idAplicacao, byte[] nome, byte[] valor)
			throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao aplicacao;
		Preferencia novaPreferencia;
		byte proximoId;

		// Obtém aplicação.
		aplicacao = gerente.getAplicacao(idAplicacao);
		if (aplicacao == null)
			return -1;

		// Insere preferência.
		proximoId = nextId(aplicacao);
		novaPreferencia = new Preferencia(proximoId, nome, valor);

		aplicacao.getListaPreferencias().inserirNoFinal(novaPreferencia);
		return proximoId;
	}

	/**
	 * @see modelo.IUsuario#alterarPreferencia(byte, byte[], byte[])
	 */
	public boolean alterarPreferencia(byte idAplicacao, byte idPreferencia,
			byte[] novoValor) throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao aplicacao;
		Preferencia noIterador;

		//	Obtém aplicação.
		aplicacao = gerente.getAplicacao(idAplicacao);
		if (aplicacao == null)
			return false;

		// Busca preferência e altera.
		noIterador = (Preferencia) aplicacao.getListaPreferencias().getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getId() == idPreferencia)
			{
				noIterador.setValor(novoValor);
				return true;
			}

			noIterador = (Preferencia) aplicacao.getListaPreferencias()
					.getProximo(noIterador);
		}

		return false;
	}

	/**
	 * @see modelo.IUsuario#removerPreferencia(byte, byte[])
	 */
	public boolean removerPreferencia(byte idAplicacao, byte idPreferencia)
			throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao aplicacao;
		Preferencia noIterador;

		// Obtém aplicação.
		aplicacao = gerente.getAplicacao(idAplicacao);
		if (aplicacao == null)
			return false;

		// Busca preferência e remove.
		noIterador = (Preferencia) aplicacao.getListaPreferencias().getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getId() == idPreferencia)
				return aplicacao.getListaPreferencias().remover(noIterador);

			noIterador = (Preferencia) aplicacao.getListaPreferencias()
					.getProximo(noIterador);
		}

		return false;
	}

	/**
	 * @see modelo.IUsuario#isAtivo()
	 */
	public boolean isAtivo() throws RemoteException
	{
		return ativo;
	}

	/**
	 * @see modelo.IUsuario#setAtivo(boolean)
	 */
	public void setAtivo(boolean ativo) throws RemoteException
	{
		this.ativo = ativo;
	}

	public IVCard getVCard() throws RemoteException
	{
		return vCard;
	}

	private byte nextId(Aplicacao aplicacao)
	{
		// Declaração de variáveis.
		Preferencia noIterador;
		ListaLigada listaPreferencias;
		byte i, id;
		boolean encontrou = false;

		id = 0x00;
		listaPreferencias = aplicacao.getListaPreferencias();
		
		//	Busca o menor id disponível e retorna.
		do
		{
			encontrou = true;

			noIterador = (Preferencia) listaPreferencias.getPrimeiro();
			for (i = 0; i < listaPreferencias.getTamanho(); i++)
			{
				if (noIterador.getId() == id)
				{
					encontrou = false;
					id++;
					break;
				}
				noIterador = (Preferencia) listaPreferencias.getProximo(noIterador);
			}
		} while (encontrou == false);

		return (id);
	}

	/**
	 * @see smartsystem.IUsuario#getPreferenciaNome(byte, byte)
	 */
	public byte[] getPreferenciaNome(byte idAplicacao, byte idPreferencia)
			throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao aplicacao;
		Preferencia noIterador;
		ListaLigada listaPreferencias;
		byte i;

		//	Obtém aplicação.
		aplicacao = gerente.getAplicacao(idAplicacao);
		if (aplicacao == null)
			return null;

		// Busca preferência e obtém nome.
		listaPreferencias = aplicacao.getListaPreferencias();
		noIterador = (Preferencia) listaPreferencias.getPrimeiro();
		for (i = 0; i < listaPreferencias.getTamanho(); i++)
		{
			if (idPreferencia == noIterador.getId())
				return noIterador.getNome();

			noIterador = (Preferencia) listaPreferencias.getProximo(noIterador);
		}

		return null;
	}

	/**
	 * @see smartsystem.IUsuario#getPreferenciaIds(byte)
	 */
	public byte[] getPreferenciaIds(byte idAplicacao) throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao aplicacao;
		Preferencia noIterador;
		ListaLigada listaPreferencias;
		byte i;
		
		//	Obtém aplicação.
		aplicacao = gerente.getAplicacao(idAplicacao);
		if (aplicacao == null)
			return null;

		listaPreferencias = aplicacao.getListaPreferencias();
		byte[] ids = new byte[listaPreferencias.getTamanho()];

		// Percorre a lista e constrói o vetor de ids.
		noIterador = (Preferencia) listaPreferencias.getPrimeiro();
		for (i = 0; i < ids.length; i++)
		{
			ids[i] = noIterador.getId();

			noIterador = (Preferencia) listaPreferencias.getProximo(noIterador);
		}

		return ids;
	}
}
