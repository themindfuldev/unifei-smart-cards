package visao.gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelGerente extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JButton btnAdicionarAplicacao = null;
	private JButton btnRemoverAplicacao = null;
	private JButton btnAtivarAplicacao = null;
	private JButton btnDesativarAplicacao = null;
	private DefaultTableModel modelAplicacoes = null;
	private JScrollPane scrAplicacoes = null;
	private JTable tblAplicacoes = null;

	/**
	 * This is the default constructor
	 */
	public PanelGerente()
	{
		super();
		
		String[] colunas = {"Id", "Nome", "Ativa?"};
		modelAplicacoes = new DefaultTableModel(colunas, 0);
		
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.fill = GridBagConstraints.NONE;
		gridBagConstraints4.gridy = 0;
		gridBagConstraints4.weightx = 0.0;
		gridBagConstraints4.weighty = 0.0;
		gridBagConstraints4.gridheight = 4;
		gridBagConstraints4.ipadx = 0;
		gridBagConstraints4.ipady = 0;
		gridBagConstraints4.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints4.gridx = 0;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridy = 3;
		gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints3.anchor = GridBagConstraints.NORTH;
		gridBagConstraints3.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints3.ipadx = 30;
		gridBagConstraints3.gridx = 1;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridy = 2;
		gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints2.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints2.ipadx = 30;
		gridBagConstraints2.gridx = 1;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints1.ipadx = 30;
		gridBagConstraints1.gridx = 1;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 30;
		gridBagConstraints.gridx = 1;
		this.setSize(600, 360);
		this.setLayout(new GridBagLayout());
		this.add(getScrAplicacoes(), gridBagConstraints4);
		this.add(getBtnAdicionarAplicacao(), gridBagConstraints);
		this.add(getBtnRemoverAplicacao(), gridBagConstraints1);
		this.add(getBtnAtivarAplicacao(), gridBagConstraints2);
		this.add(getBtnDesativarAplicacao(), gridBagConstraints3);
		
	}

	/**
	 * This method initializes btnAdicionarAplicacao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtnAdicionarAplicacao()
	{
		if (btnAdicionarAplicacao == null)
		{
			btnAdicionarAplicacao = new JButton();
			btnAdicionarAplicacao.setPreferredSize(new Dimension(70, 25));
			btnAdicionarAplicacao.setText("Adicionar");
		}
		return btnAdicionarAplicacao;
	}

	/**
	 * This method initializes btnRemoverAplicacao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtnRemoverAplicacao()
	{
		if (btnRemoverAplicacao == null)
		{
			btnRemoverAplicacao = new JButton();
			btnRemoverAplicacao.setPreferredSize(new Dimension(70, 25));
			btnRemoverAplicacao.setText("Remover");
		}
		return btnRemoverAplicacao;
	}

	/**
	 * This method initializes btnAtivarAplicacao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtnAtivarAplicacao()
	{
		if (btnAtivarAplicacao == null)
		{
			btnAtivarAplicacao = new JButton();
			btnAtivarAplicacao.setPreferredSize(new Dimension(70, 25));
			btnAtivarAplicacao.setText("Ativar");
		}
		return btnAtivarAplicacao;
	}

	/**
	 * This method initializes btnDesativarAplicacao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtnDesativarAplicacao()
	{
		if (btnDesativarAplicacao == null)
		{
			btnDesativarAplicacao = new JButton();
			btnDesativarAplicacao.setPreferredSize(new Dimension(70, 25));
			btnDesativarAplicacao.setText("Desativar");
		}
		return btnDesativarAplicacao;
	}

	/**
	 * This method initializes scrAplicacoes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrAplicacoes()
	{
		if (scrAplicacoes == null)
		{
			scrAplicacoes = new JScrollPane();
			scrAplicacoes.setViewportView(getTblAplicacoes());
		}
		return scrAplicacoes;
	}

	/**
	 * This method initializes tblAplicacoes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTblAplicacoes()
	{
		if (tblAplicacoes == null)
		{
			tblAplicacoes = new JTable();
			tblAplicacoes.setModel(modelAplicacoes);
		}
		return tblAplicacoes;
	}

	public DefaultTableModel getModelAplicacoes()
	{
		return modelAplicacoes;
	}

}
