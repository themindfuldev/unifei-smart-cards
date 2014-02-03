package smartsystem;

import java.rmi.RemoteException;

import javacard.framework.UserException;
import javacard.framework.service.CardRemoteObject;

/**
 * Implementação de Gerente.
 * 
 * @author Tiago
 */
public class GerenteImpl extends Login implements IGerente
{
	/**
	 * Interface principal.
	 */
	private PrincipalImpl principal;
	/**
	 * Lista de aplicações gerenciadas.
	 */
	private ListaLigada listaAplicacoes;

	/**
	 * Construtor.
	 * 
	 * @param nome
	 * @param senha
	 * @param principal
	 */
	public GerenteImpl(byte[] nome, byte[] senha, PrincipalImpl principal)
	{
		super(nome, senha);
		CardRemoteObject.export(this);

		this.principal = principal;

		modulo = new ModuloImpl(this, IModulo.GERENTE);

		listaAplicacoes = new ListaLigada();
	}

	/**
	 * @see smartsystem.IGerente#alterarSenha(byte[], byte[])
	 */
	public boolean alterarSenha(byte[] antigaSenha, byte[] novaSenha)
			throws RemoteException
	{
		// Declaração de variáveis
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
	 * @see modelo.IGerente#definirUsuario(byte[])
	 */
	public boolean definirUsuario(byte[] nome) throws RemoteException
	{
		// Declaração de variáveis.
		Login noIterador;
		IUsuario usuario;

		// Busca o módulo de usuário na lista.
		noIterador = (Login) principal.getListaLogin().getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getModulo().getTipo() == IModulo.USUARIO)
			{
				// Ao encontrar, define o usuário e o ativa.
				noIterador.setId(nome);
				
				usuario = (IUsuario) noIterador;
				usuario.setAtivo(true);
				((VCardImpl) usuario.getVCard()).limpar();

				return true;
			}

			noIterador = (Login) principal.getListaLogin().getProximo(noIterador);
		}

		return false;
	}

	/**
	 * @see modelo.IGerente#inserirAplicacao(byte, byte[])
	 */
	public byte inserirAplicacao(byte[] nome) throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao novaAplicacao;
		byte proximoId;

		// Insere a aplicação.
		proximoId = nextId();
		novaAplicacao = new Aplicacao(proximoId, nome, false);
		listaAplicacoes.inserirNoFinal(novaAplicacao);
		
		return proximoId;
	}

	/**
	 * @see modelo.IGerente#removerAplicacao(byte)
	 */
	public boolean removerAplicacao(byte id) throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao noIterador;

		// Busca a aplicação e a remove.
		noIterador = (Aplicacao) listaAplicacoes.getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getId() == id)
				return listaAplicacoes.remover(noIterador);

			noIterador = (Aplicacao) listaAplicacoes.getProximo(noIterador);
		}

		return false;
	}

	/**
	 * @see modelo.IGerente#getIds()
	 */
	public byte[] getIds() throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao noIterador;
		byte[] ids = new byte[listaAplicacoes.getTamanho()];
		byte i;

		// Percorre a lista e constrói o vetor de ids.
		noIterador = (Aplicacao) listaAplicacoes.getPrimeiro();
		for (i = 0; i < ids.length; i++)
		{
			ids[i] = noIterador.getId();

			noIterador = (Aplicacao) listaAplicacoes.getProximo(noIterador);
		}

		return ids;
	}

	/**
	 * @see modelo.IGerente#getNomeAplicacao(byte)
	 */
	public byte[] getNomeAplicacao(byte id) throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao noIterador;

		// Busca a id e obtém o nome.
		noIterador = (Aplicacao) listaAplicacoes.getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getId() == id)
				return noIterador.getNome();

			noIterador = (Aplicacao) listaAplicacoes.getProximo(noIterador);
		}

		return null;
	}

	/**
	 * @see modelo.IGerente#ativarAplicacao(byte, boolean)
	 */
	public boolean ativarAplicacao(byte id, boolean ativa)
			throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao noIterador;

		// Busca a id e ativa a aplicação.
		noIterador = (Aplicacao) listaAplicacoes.getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getId() == id)
			{
				noIterador.setAtiva(ativa);
				return true;
			}

			noIterador = (Aplicacao) listaAplicacoes.getProximo(noIterador);
		}

		return false;
	}

	/**
	 * @param id
	 * @return A aplicação com tal id.
	 * @throws RemoteException
	 */
	Aplicacao getAplicacao(byte id) throws RemoteException
	{
		// Declaração de variáveis.
		Aplicacao noIterador;

		// Busca o id e obtém a aplicação.
		noIterador = (Aplicacao) listaAplicacoes.getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getId() == id)
				return noIterador;

			noIterador = (Aplicacao) listaAplicacoes.getProximo(noIterador);
		}

		return null;
	}

	/**
	 * @return O próximo id disponível para aplicações.
	 */
	private byte nextId()
	{
		// Declaração de variáveis.
		Aplicacao noIterador;
		byte i, id;
		boolean encontrou = false;

		id = 0x00;

		// Busca o menor id disponível e retorna.
		do
		{
			encontrou = true;

			noIterador = (Aplicacao) listaAplicacoes.getPrimeiro();
			for (i = 0; i < listaAplicacoes.getTamanho(); i++)
			{
				if (noIterador.getId() == id)
				{
					encontrou = false;
					id++;
					break;
				}
				noIterador = (Aplicacao) listaAplicacoes.getProximo(noIterador);
			}
		} while (encontrou == false);

		return (id);
	}

	/**
	 * @see smartsystem.IGerente#isUsuarioAtivo()
	 */
	public boolean isUsuarioAtivo() throws RemoteException, UserException
	{
		// Declaração de variáveis.
		Login noIterador;

		// Busca o módulo de usuário na lista.
		noIterador = (Login) principal.getListaLogin().getPrimeiro();
		while (noIterador != null)
		{
			if (noIterador.getModulo().getTipo() == IModulo.USUARIO)
			{
				// Ao encontrar, verifica se está ativo.
				return ((IUsuario) noIterador).isAtivo();
			}

			noIterador = (Login) principal.getListaLogin().getProximo(noIterador);
		}

		throw new UserException();	
	}

}
