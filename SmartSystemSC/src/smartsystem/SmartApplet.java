package smartsystem;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.service.Dispatcher;
import javacard.framework.service.RMIService;
import javacard.framework.service.RemoteService;

/**
 * Applet de acesso à aplicação.
 * 
 * @author Tiago
 * 
 */
public class SmartApplet extends Applet
{
	/**
	 * Dispatcher do serviço RMI.
	 */
	private Dispatcher dispatcher;

	/**
	 * Construtor.
	 */
	private SmartApplet()
	{
		// Declaração de variáveis.
		RemoteService rmiPrincipal;

		// Aloca um dispatcher RMI.
		dispatcher = new Dispatcher((short) 1);

		// Inicia um serviço RMI definindo a referência inicial.
		rmiPrincipal = new RMIService(new PrincipalImpl());

		dispatcher.addService(rmiPrincipal, Dispatcher.PROCESS_COMMAND);
	}

	public static void install(byte[] buffer, short offset, byte length)
	{
		// Aloca e registra o applet.
		(new SmartApplet()).register();
	}

	public void process(APDU apdu)
	{
		// Processa as requisições APDU.
		dispatcher.process(apdu);
	}
}
