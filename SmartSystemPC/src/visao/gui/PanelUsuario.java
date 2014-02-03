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
import javax.swing.JComboBox;

public class PanelUsuario extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JButton btnAdicionarPreferencia = null;
	private JButton btnRemoverPreferencia = null;
	private JButton btnAlterarPreferencia = null;
	private DefaultTableModel modelAplicacoes = null;
	private JScrollPane scrPreferencias = null;
	private JTable tblPreferencias = null;
	private JComboBox cmbAplicacoes = null;

	/**
	 * This is the default constructor
	 */
	public PanelUsuario()
	{
		super();
		
		String[] colunas = {"Id", "Nome", "Ativa?"};
		modelAplicacoes = new DefaultTableModel(colunas, 5);
		
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints11.gridy = 0;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.gridheight = 1;
		gridBagConstraints11.gridwidth = 1;
		gridBagConstraints11.gridx = 0;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.fill = GridBagConstraints.NONE;
		gridBagConstraints4.gridy = 1;
		gridBagConstraints4.weightx = 0.0;
		gridBagConstraints4.weighty = 0.0;
		gridBagConstraints4.gridheight = 4;
		gridBagConstraints4.ipadx = 0;
		gridBagConstraints4.ipady = 0;
		gridBagConstraints4.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints4.gridx = 0;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridy = 3;
		gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints2.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints2.ipadx = 30;
		gridBagConstraints2.gridx = 1;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridy = 2;
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints1.ipadx = 30;
		gridBagConstraints1.gridx = 1;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 30;
		gridBagConstraints.gridx = 1;
		this.setSize(600, 360);
		this.setLayout(new GridBagLayout());
		this.add(getScrPreferencias(), gridBagConstraints4);
		this.add(getBtnAdicionarPreferencia(), gridBagConstraints);
		this.add(getBtnRemoverPreferencia(), gridBagConstraints1);
		this.add(getBtnAlterarPreferencia(), gridBagConstraints2);
		this.add(getCmbAplicacoes(), gridBagConstraints11);
		
	}

	/**
	 * This method initializes btnAdicionarPreferencia	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtnAdicionarPreferencia()
	{
		if (btnAdicionarPreferencia == null)
		{
			btnAdicionarPreferencia = new JButton();
			btnAdicionarPreferencia.setPreferredSize(new Dimension(70, 25));
			btnAdicionarPreferencia.setText("Adicionar");
		}
		return btnAdicionarPreferencia;
	}

	/**
	 * This method initializes btnRemoverPreferencia	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtnRemoverPreferencia()
	{
		if (btnRemoverPreferencia == null)
		{
			btnRemoverPreferencia = new JButton();
			btnRemoverPreferencia.setPreferredSize(new Dimension(70, 25));
			btnRemoverPreferencia.setText("Remover");
		}
		return btnRemoverPreferencia;
	}

	/**
	 * This method initializes btnAlterarPreferencia	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtnAlterarPreferencia()
	{
		if (btnAlterarPreferencia == null)
		{
			btnAlterarPreferencia = new JButton();
			btnAlterarPreferencia.setPreferredSize(new Dimension(70, 25));
			btnAlterarPreferencia.setText("Alterar");
		}
		return btnAlterarPreferencia;
	}

	/**
	 * This method initializes scrPreferencias	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrPreferencias()
	{
		if (scrPreferencias == null)
		{
			scrPreferencias = new JScrollPane();
			scrPreferencias.setViewportView(getTblPreferencias());
		}
		return scrPreferencias;
	}

	/**
	 * This method initializes tblPreferencias	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTblPreferencias()
	{
		if (tblPreferencias == null)
		{
			tblPreferencias = new JTable();
			tblPreferencias.setModel(modelAplicacoes);
		}
		return tblPreferencias;
	}

	public DefaultTableModel getModelAplicacoes()
	{
		return modelAplicacoes;
	}

	/**
	 * This method initializes cmbAplicacoes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	public JComboBox getCmbAplicacoes()
	{
		if (cmbAplicacoes == null)
		{
			cmbAplicacoes = new JComboBox();
		}
		return cmbAplicacoes;
	}

}
