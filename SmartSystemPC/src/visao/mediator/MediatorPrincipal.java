package visao.mediator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import smartsystem.IModulo;
import visao.gui.DialogoLogin;
import visao.gui.JanelaPrincipal;
import visao.gui.PanelGerente;
import visao.gui.PanelUsuario;
import controle.FacadeCartao;

public class MediatorPrincipal
{
	private DialogoLogin dialogoLogin;
	private JanelaPrincipal janela;
	private byte tipo;
	private FacadeCartao facadeCartao;
	
	public MediatorPrincipal(JanelaPrincipal principal, DialogoLogin dialogoLogin, byte tipo)
	{
		janela = principal;
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.dialogoLogin = dialogoLogin;
		this.facadeCartao = dialogoLogin.getMediator().getFacadeCartao();
		this.tipo = tipo;
	}

	public void registraEventos()
	{
		janela.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				facadeCartao.sair();
			}
		});
		
		janela.getMniSair().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				facadeCartao.sair();
				System.exit(0);
			}
		});
		
		janela.getMniLogout().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				janela.dispose();

				dialogoLogin.getTxtUsuario().setText("");
				dialogoLogin.getTxtUsuario().setBackground(Color.WHITE);
				dialogoLogin.getTxtSenha().setText("");
				dialogoLogin.getTxtSenha().setBackground(Color.WHITE);
				
				dialogoLogin.setVisible(true);
			}
		});
		
		janela.getMniAlterarSenha().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String antigaSenhaStr = JOptionPane.showInputDialog("Entre com a antiga senha:");
				String novaSenhaStr = JOptionPane.showInputDialog("Entre com a nova senha:");
				
				try
				{
					boolean retorno = facadeCartao.alterarSenha(antigaSenhaStr, novaSenhaStr);
					String mensagem;
					
					if (retorno)
						mensagem = "Sucesso!";
					else
						mensagem = "Não foi possível realizar a operação.";
					JOptionPane.showMessageDialog(null, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		switch (tipo)
		{
			case IModulo.GERENTE:
				janela.getMniDefinirUsuario().addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							if (facadeCartao.isUsuarioAtivo() == true)
								if (JOptionPane.showConfirmDialog(null, "Usuário está ativo. Tem certeza?") == 1)
									return;
							
							String nomeStr = JOptionPane.showInputDialog("Entre com o nome do usuário:");
							
							boolean retorno = facadeCartao.definirUsuario(nomeStr);
							String mensagem;
							
							if (retorno)
								mensagem = "Sucesso!";
							else
								mensagem = "Não foi possível realizar a operação.";
							JOptionPane.showMessageDialog(null, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);

						} catch (Exception ex)
						{
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
				final PanelGerente panelGerente = (PanelGerente) janela.getConteudoPnlConteudo();
				
				panelGerente.getBtnAdicionarAplicacao().addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						String nomeStr = JOptionPane.showInputDialog("Entre com o nome da aplicação:");
						
						try
						{
							String aid = facadeCartao.inserirAplicacao(nomeStr);
							
							panelGerente.getModelAplicacoes().addRow(new Object[]{aid, nomeStr, false});
							
						} catch (Exception ex)
						{
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				
				break;
		
			case IModulo.USUARIO:
				janela.getMniVerDados().addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						janela.dispose();
		
						dialogoLogin.getTxtUsuario().setText("");
						dialogoLogin.getTxtUsuario().setBackground(Color.WHITE);
						dialogoLogin.getTxtSenha().setText("");
						dialogoLogin.getTxtSenha().setBackground(Color.WHITE);
						
						dialogoLogin.setVisible(true);
					}
				});
				break;
		}
	}

	public void customize()
	{
		switch(tipo)
		{
			case IModulo.GERENTE:
				janela.setTitle("SmartSystem - Gerente");
				janela.getMniAlterarDados().setEnabled(false);
				janela.getMniVerDados().setEnabled(false);
				janela.getMniAlterarNome().setEnabled(false);
				
				janela.setConteudoPnlConteudo(new PanelGerente());
				break;
				
			case IModulo.USUARIO:
				janela.setTitle("SmartSystem - Usuario");
				janela.getMniDefinirUsuario().setEnabled(false);
				
				janela.setConteudoPnlConteudo(new PanelUsuario());
				break;
		}
		
	}
}
