package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface de interação com um cliente Usuario.
 * 
 * @author Tiago
 */
public interface IUsuario extends Remote
{
	/**
	 * Altera seu nome de usuário.
	 * 
	 * @param nome
	 * @throws RemoteException
	 */
	public void alterarNome(byte[] nome) throws RemoteException;

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
	 * Insere uma preferência em uma aplicação.
	 * 
	 * @param idAplicacao
	 * @param nome
	 * @param valor
	 * @return Se a operação teve sucesso.
	 * @throws RemoteException
	 */
	public byte inserirPreferencia(byte idAplicacao, byte[] nome, byte[] valor)
			throws RemoteException;

	/**
	 * Altera uma preferência de uma aplicação.
	 * 
	 * @param idAplicacao
	 * @param idPreferencia
	 * @param novoValor
	 * @return Se a operação teve sucesso.
	 * @throws RemoteException
	 */
	public boolean alterarPreferencia(byte idAplicacao, byte idPreferencia,
			byte[] novoValor) throws RemoteException;

	/**
	 * Remove uma preferência de uma aplicação.
	 * 
	 * @param idAplicacao
	 * @param idPreferencia
	 * @return Se a operação teve sucesso.
	 * @throws RemoteException
	 */
	public boolean removerPreferencia(byte idAplicacao, byte idPreferencia)
			throws RemoteException;

	/**
	 * Obtém os ids das preferências de uma aplicação.
	 * 
	 * @param idAplicacao
	 * @return Um vetor com ids, onde cada posição é um id.
	 * @throws RemoteException
	 */
	public byte[] getPreferenciaIds(byte idAplicacao) throws RemoteException;

	/**
	 * @param idAplicacao
	 * @param idPreferencia
	 * @return O nome da preferência de uma aplicação.
	 * @throws RemoteException
	 */
	public byte[] getPreferenciaNome(byte idAplicacao, byte idPreferencia)
			throws RemoteException;

	/**
	 * @return Se o usuário está ativo.
	 * @throws RemoteException
	 */
	public boolean isAtivo() throws RemoteException;

	/**
	 * Define a atividade de um usuário.
	 * 
	 * @param ativo
	 * @throws RemoteException
	 */
	public void setAtivo(boolean ativo) throws RemoteException;

	/**
	 * @return O vCard do usuário.
	 * @throws RemoteException
	 */
	public IVCard getVCard() throws RemoteException;
}