package visao.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import visao.mediator.MediatorPrincipal;

public class JanelaPrincipal extends JFrame
{
	private MediatorPrincipal mediator;

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar mnbPrincipal = null;
	private JMenu mnuAplicacao = null;
	private JMenu mnuLogin = null;
	private JMenuItem mniSair = null;
	private JMenuItem mniLogout = null;
	private JMenuItem mniAlterarNome = null;
	private JMenuItem mniAlterarSenha = null;
	private JMenuItem mniAlterarDados = null;
	private JMenuItem mniVerDados = null;
	private JMenuItem mniDefinirUsuario = null;

	private JPanel pnlConteudo = null;
	
	/**
	 * This is the default constructor
	 * @param dialogoLogin 
	 * @param b 
	 */
	public JanelaPrincipal(byte b, DialogoLogin dialogoLogin)
	{
		super();
		mediator = new MediatorPrincipal(this, dialogoLogin, b);
		
		initialize();
		
		mediator.customize();
		mediator.registraEventos();
		
		this.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		this.setSize(620, 430);
		this.setJMenuBar(getMnbPrincipal());
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane()
	{
		if (jContentPane == null)
		{
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.ipadx = 580;
			gridBagConstraints.ipady = 350;
			gridBagConstraints.gridy = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new FlowLayout());
			jContentPane.add(getPnlConteudo(), null);
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes mnbPrincipal	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMnbPrincipal()
	{
		if (mnbPrincipal == null)
		{
			mnbPrincipal = new JMenuBar();
			mnbPrincipal.add(getMnuAplicacao());
			mnbPrincipal.add(getMnuLogin());
		}
		return mnbPrincipal;
	}

	/**
	 * This method initializes mnuAplicacao	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuAplicacao()
	{
		if (mnuAplicacao == null)
		{
			mnuAplicacao = new JMenu();
			mnuAplicacao.setText("Aplicacao");
			mnuAplicacao.add(getMniLogout());
			mnuAplicacao.add(getMniSair());
		}
		return mnuAplicacao;
	}

	/**
	 * This method initializes mnuLogin	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuLogin()
	{
		if (mnuLogin == null)
		{
			mnuLogin = new JMenu();
			mnuLogin.setText("Login");
			mnuLogin.add(getMniAlterarNome());
			mnuLogin.add(getMniAlterarSenha());
			mnuLogin.add(getMniAlterarDados());
			mnuLogin.add(getMniVerDados());
			mnuLogin.add(getMniDefinirUsuario());
		}
		return mnuLogin;
	}

	/**
	 * This method initializes mniSair	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getMniSair()
	{
		if (mniSair == null)
		{
			mniSair = new JMenuItem();
			mniSair.setText("Sair");
		}
		return mniSair;
	}

	/**
	 * This method initializes mniLogout	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getMniLogout()
	{
		if (mniLogout == null)
		{
			mniLogout = new JMenuItem();
			mniLogout.setText("Logout...");
		}
		return mniLogout;
	}

	/**
	 * This method initializes mniAlterarNome	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getMniAlterarNome()
	{
		if (mniAlterarNome == null)
		{
			mniAlterarNome = new JMenuItem();
			mniAlterarNome.setText("Alterar nome");
		}
		return mniAlterarNome;
	}

	/**
	 * This method initializes mniAlterarSenha	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getMniAlterarSenha()
	{
		if (mniAlterarSenha == null)
		{
			mniAlterarSenha = new JMenuItem();
			mniAlterarSenha.setText("Alterar senha");
		}
		return mniAlterarSenha;
	}

	/**
	 * This method initializes mniAlterarDados	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getMniAlterarDados()
	{
		if (mniAlterarDados == null)
		{
			mniAlterarDados = new JMenuItem();
			mniAlterarDados.setText("Alterar dados");
		}
		return mniAlterarDados;
	}

	/**
	 * This method initializes mniVerDados	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getMniVerDados()
	{
		if (mniVerDados == null)
		{
			mniVerDados = new JMenuItem();
			mniVerDados.setText("Ver dados");
		}
		return mniVerDados;
	}

	/**
	 * This method initializes mniDefinirUsuario	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public JMenuItem getMniDefinirUsuario()
	{
		if (mniDefinirUsuario == null)
		{
			mniDefinirUsuario = new JMenuItem();
			mniDefinirUsuario.setText("Definir usuário");
		}
		return mniDefinirUsuario;
	}

	/**
	 * This method initializes pnlConteudo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	public JPanel getPnlConteudo()
	{
		if (pnlConteudo == null)
		{
			pnlConteudo = new JPanel();
			pnlConteudo.setPreferredSize(new Dimension(600, 360));
		}
		return pnlConteudo;
	}

	public void setConteudoPnlConteudo(JPanel panel)
	{
		pnlConteudo.removeAll();
		pnlConteudo.add(panel);
	}
	
	public JPanel getConteudoPnlConteudo()
	{
		return (JPanel) pnlConteudo.getComponent(0);
	}

}
