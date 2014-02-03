package visao.mediator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import visao.gui.DialogoLogin;
import visao.gui.JanelaPrincipal;
import controle.FacadeCartao;

public class MediatorLogin
{
	private DialogoLogin dialogoLogin;
	private FacadeCartao facadeCartao;

	public MediatorLogin(DialogoLogin dialogoLogin) throws IllegalStateException
	{
		super();
		this.dialogoLogin = dialogoLogin;
		
		try
		{
			facadeCartao = new FacadeCartao();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}
	}

	public void registraEventos()
	{
		dialogoLogin.getBtnLogin().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				// Validar login
				String usuario = dialogoLogin.getTxtUsuario().getText();
				String senha = dialogoLogin.getTxtSenha().getText();
				
				// Pintura dos campos
				dialogoLogin.getTxtUsuario().setBackground(Color.WHITE);
				dialogoLogin.getTxtSenha().setBackground(Color.WHITE);

				// Validação
				if (usuario.length() == 0)
				{
					dialogoLogin.getTxtUsuario().setBackground(Color.ORANGE);
					return;
				}
					
				if (senha.length() == 0)
				{
					dialogoLogin.getTxtSenha().setBackground(Color.ORANGE);
					return;
				}
				
				try
				{
					// Entrada no sistema
					boolean resposta = facadeCartao.fazerLogin(usuario, senha);
					
					if (resposta)
					{
						dialogoLogin.dispose();

						new JanelaPrincipal(facadeCartao.getTipo(), dialogoLogin);
					}
					else
					{
						dialogoLogin.getTxtUsuario().setBackground(Color.ORANGE);
						dialogoLogin.getTxtSenha().setBackground(Color.ORANGE);
					}
				} catch (Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					facadeCartao.sair();
					System.exit(0);
				}
			}
		});
		
		dialogoLogin.getBtnSair().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				facadeCartao.sair();
				System.exit(0);
			}
		});
	}

	public FacadeCartao getFacadeCartao()
	{
		return facadeCartao;
	}
	
}
