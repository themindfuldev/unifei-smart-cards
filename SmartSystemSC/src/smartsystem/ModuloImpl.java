package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;


import javacard.framework.service.CardRemoteObject;

/**
 * Implementação de Modulo.
 * 
 * @author Tiago
 */
public class ModuloImpl extends CardRemoteObject implements IModulo
{
	/**
	 * Tipo de módulo.
	 */
	private byte tipo;
	/**
	 * Usuário relativo a este módulo (se houver).
	 */
	private IUsuario usuario;
	/**
	 * Gerente relativo a este módulo (se houver).
	 */
	private IGerente gerente;

	/**
	 * Construtor.
	 * 
	 * @param login
	 * @param tipo
	 */
	public ModuloImpl(Login login, byte tipo)
	{
		super();
		this.tipo = tipo;

		// Armazena o login corretamente.
		switch (tipo)
		{
			case GERENTE:
				gerente = (IGerente) login;
				break;
	
			case USUARIO:
				usuario = (IUsuario) login;
				break;
	
			default:
				// throw new Exception();
		}
	}

	/**
	 * @see modelo.IModulo#getGerente()
	 */
	public Remote getModulo() throws RemoteException
	{
		// Declaração de variáveis
		Remote modulo = null;

		// Obtém o login corretamente.
		switch (tipo)
		{
			case GERENTE:
				modulo = gerente;
				break;
	
			case USUARIO:
				modulo = usuario;
				break;
	
			default:
				// throw new Exception();
		}

		return modulo;
	}

	/**
	 * @see modelo.IModulo#getUsuario()
	 */
	public IUsuario getUsuario() throws RemoteException
	{
		return usuario;
	}

	/**
	 * @see modelo.IModulo#getTipo()
	 */
	public byte getTipo() throws RemoteException
	{
		return tipo;
	}

}
