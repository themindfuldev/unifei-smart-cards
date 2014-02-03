package visao.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import visao.mediator.MediatorLogin;

public class DialogoLogin extends JDialog
{
	private MediatorLogin mediator;
	
	private static final long serialVersionUID = 1L;
	private JPanel pnlContainer = null;
	private JLabel lblUsuario = null;
	private JTextField txtUsuario = null;
	private JLabel lblSenha = null;
	private JTextField txtSenha = null;
	private JPanel pnlBotoes = null;
	private JButton btnLogin = null;
	private JButton btnSair = null;
	
	/**
	 * @param owner
	 */
	public DialogoLogin(Frame owner)
	{
		super(owner, true);

		try
		{
			mediator = new MediatorLogin(this);
		}
		catch (IllegalStateException e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		initialize();
		mediator.registraEventos();
		
		setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		this.setSize(240, 160);
		this.setTitle("SmartSystem Login");
		this.setContentPane(buildPnlContainer());
		
		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel buildPnlContainer()
	{
		if (pnlContainer == null)
		{
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridwidth = 2;
			gridBagConstraints11.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.insets = new Insets(0, 30, 0, 0);
			gridBagConstraints2.gridy = 1;
			lblSenha = new JLabel();
			lblSenha.setText("Senha:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(0, 30, 0, 0);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 2;
			gridBagConstraints.gridwidth = 1;
			gridBagConstraints.anchor = GridBagConstraints.CENTER;
			gridBagConstraints.gridx = 0;
			lblUsuario = new JLabel();
			lblUsuario.setText("Usuário:");
			pnlContainer = new JPanel();
			pnlContainer.setLayout(new GridBagLayout());
			pnlContainer.add(lblUsuario, gridBagConstraints);
			pnlContainer.add(buildTxtUsuario(), gridBagConstraints1);
			pnlContainer.add(lblSenha, gridBagConstraints2);
			pnlContainer.add(buildTxtSenha(), gridBagConstraints3);
			pnlContainer.add(buildPnlBotoes(), gridBagConstraints11);
		}
		return pnlContainer;
	}

	/**
	 * This method initializes txtUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField buildTxtUsuario()
	{
		if (txtUsuario == null)
		{
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
		}
		return txtUsuario;
	}

	/**
	 * This method initializes txtSenha	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField buildTxtSenha()
	{
		if (txtSenha == null)
		{
			txtSenha = new JTextField();
			txtSenha.setColumns(10);
		}
		return txtSenha;
	}

	/**
	 * This method initializes pnlBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel buildPnlBotoes()
	{
		if (pnlBotoes == null)
		{
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.insets = new Insets(15, 0, 0, 0);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.insets = new Insets(15, 5, 0, 0);
			pnlBotoes = new JPanel();
			pnlBotoes.setLayout(new GridBagLayout());
			pnlBotoes.add(buildBtnLogin(), gridBagConstraints5);
			pnlBotoes.add(buildBtnSair(), gridBagConstraints4);
		}
		return pnlBotoes;
	}

	/**
	 * This method initializes btnLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton buildBtnLogin()
	{
		if (btnLogin == null)
		{
			btnLogin = new JButton();
			btnLogin.setText("Login");
			btnLogin.setMnemonic(KeyEvent.VK_L);
			btnLogin.setName("");
		}
		return btnLogin;
	}

	/**
	 * This method initializes btnSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton buildBtnSair()
	{
		if (btnSair == null)
		{
			btnSair = new JButton();
			btnSair.setText("Sair");
			btnSair.setMnemonic(KeyEvent.VK_S);
		}
		return btnSair;
	}

	public JButton getBtnLogin()
	{
		return btnLogin;
	}

	public JButton getBtnSair()
	{
		return btnSair;
	}

	public JTextField getTxtSenha()
	{
		return txtSenha;
	}

	public JTextField getTxtUsuario()
	{
		return txtUsuario;
	}

	public MediatorLogin getMediator()
	{
		return mediator;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
