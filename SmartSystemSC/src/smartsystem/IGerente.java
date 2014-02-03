package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javacard.framework.UserException;

/**
 * Interface de interação com um cliente Gerente.
 * 
 * @author Tiago
 */
public interface IGerente extends Remote
{
	/**
	 * Altera sua senha.
	 * 
	 * @param antigaSenha
	 * @param novaSenha
	 * @return Se a operação teve sucesso.
	 * @throws RemoteException
	 */
	public boolean alterarSenha(byte[] antigaSenha, byte[] novaSenha)
			throws RemoteException;

	/**
	 * Define um usuário e o ativa.
	 * 
	 * @param nome
	 * @return Se a operação teve sucesso.
	 * @throws RemoteException
	 */
	public boolean definirUsuario(byte[] nome) throws RemoteException;

	/**
	 * Insere uma aplicação a ser gerenciada.
	 * 
	 * @param nome
	 * @throws RemoteException
	 */
	public byte inserirAplicacao(byte[] nome) throws RemoteException;

	/**
	 * Remove uma aplicação.
	 * 
	 * @param id
	 * @return Se a operação teve sucesso.
	 * @throws RemoteException
	 */
	public boolean removerAplicacao(byte id) throws RemoteException;

	/**
	 * Obtém os ids de todas as aplicações.
	 * 
	 * @return Um vetor de ids, sendo um id por posição do vetor.
	 * @throws RemoteException
	 */
	public byte[] getIds() throws RemoteException;

	/**
	 * Obtém o nome de uma aplicação a partir de seu id.
	 * 
	 * @param id
	 * @return O nome da aplicação, ou <code>null</code> se não encontrou.
	 * @throws RemoteException
	 */
	public byte[] getNomeAplicacao(byte id) throws RemoteException;

	/**
	 * Ativa uma aplicação a partir de seu id.
	 * 
	 * @param id
	 * @param ativa
	 * @return Se a operação teve sucesso.
	 * @throws RemoteException
	 */
	public boolean ativarAplicacao(byte id, boolean ativa)
			throws RemoteException;
	
	/**
	 * @return Se o usuário está ativo. 
	 * @throws RemoteException
	 */
	public boolean isUsuarioAtivo() throws RemoteException, UserException;
}