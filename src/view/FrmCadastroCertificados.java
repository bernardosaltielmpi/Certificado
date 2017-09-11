package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import controller.Database;
import controller.MySql;
import controller.MySql_Certificado;
import model.Certificado;

@SuppressWarnings("serial")
public class FrmCadastroCertificados extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField txt_Descricao;
	private JTextField txt_Custo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCampoCusto;
	private JTextField txtCampoCusto_1;
	private JTable tabela_certificados;
	private JTextField txt_preco_venda;
	private JTextField txt_preco_comissao_contador;
	private JTextField txt_preco_vista;

	public FrmCadastroCertificados() {
		
		JButton btnCancelar = new JButton("Cancelar");
		JButton btnEditar = new JButton("Editar");
		JButton btnExcluir = new JButton("Excluir");
		
		btnCancelar.setEnabled(false);
		
		txt_preco_vista = new JTextField();
		setTitle("Cadastro Certificados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_Descricao = new JLabel("Descri\u00E7\u00E3o:");
		label_Descricao.setBounds(37, 51, 72, 14);
		contentPane.add(label_Descricao);
		
		JLabel label_Validade = new JLabel("Validade:");
		label_Validade.setBounds(422, 51, 71, 14);
		contentPane.add(label_Validade);
		
		JLabel label_Custo = new JLabel("Custo R$");
		label_Custo.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		label_Custo.setBounds(37, 87, 72, 14);
		contentPane.add(label_Custo);
		
		txt_Descricao = new JTextField();
		txt_Descricao.setToolTipText("EX: E-CPF A1 12 MESES  EX: E-CNPJ A3 24 MESES EX: APENAS NFE A3 36 MESES");
		txt_Descricao.setBounds(100, 48, 312, 20);
		contentPane.add(txt_Descricao);
		txt_Descricao.setColumns(10);
		
		txt_Custo = new JTextField();
		txt_Custo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				
				String caracteres="0987654321.";

			       if(! caracteres.contains(ev.getKeyChar()+"")){

			              ev.consume();

			       }
			       
			       int caracteres_maximo = 5;
				if (txt_Custo.getText().length()>caracteres_maximo ) {
			    	   ev.consume();
			    	   JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");
					
				}
			}
		});
		txt_Custo.setColumns(10);
		txt_Custo.setBounds(100, 84, 51, 20);
		contentPane.add(txt_Custo);
		
		JRadioButton rb_12 = new JRadioButton("12");
		buttonGroup.add(rb_12);
		rb_12.setBounds(499, 47, 40, 23);
		contentPane.add(rb_12);
		
		JRadioButton rb_24 = new JRadioButton("24");
		buttonGroup.add(rb_24);
		rb_24.setBounds(541, 47, 51, 23);
		contentPane.add(rb_24);
		
		JRadioButton rb_36 = new JRadioButton("36");
		buttonGroup.add(rb_36);
		rb_36.setBounds(594, 47, 51, 23);
		contentPane.add(rb_36);
		
		JLabel label_meses = new JLabel("Meses");
		label_meses.setBounds(651, 51, 67, 14);
		contentPane.add(label_meses);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String descricao = txt_Descricao.getText().toUpperCase();
				
				if (descricao.equalsIgnoreCase("")) {
					txt_Descricao.setBackground(Color.yellow );
					return;
				}else {
					txt_Descricao.setBackground(Color.white);
				}
				
				int validade = 0;
				
				if (rb_12.isSelected()) {
					validade = 12;
				}else if (rb_24.isSelected()) {
					validade = 24;
				}else if (rb_36.isSelected()) {
					validade = 36;
				}else if (! rb_12.isSelected() && ! rb_24.isSelected() && ! rb_36.isSelected()) {
					rb_12.setBackground(Color.yellow);
					rb_24.setBackground(Color.yellow);
					rb_36.setBackground(Color.yellow);
					return;					
				}
				
				
				
				if (txt_Custo.getText().equalsIgnoreCase("")) {
					txt_Custo.setBackground(Color.yellow );
					return;
				}else {
					txt_Custo.setBackground(Color.white);
				}
				double custo = Double.parseDouble(txt_Custo.getText());
				
				
				if (txt_preco_venda.getText().equalsIgnoreCase("")) {
					txt_preco_venda.setBackground(Color.yellow );
					return;
				}else {
					txt_preco_venda.setBackground(Color.white);
				}
				double valor_venda = Double.parseDouble(txt_preco_venda.getText());
				
				
				if (txt_preco_vista.getText().equalsIgnoreCase("")) {
					txt_preco_vista.setBackground(Color.yellow );
					return;
				}else {
					txt_preco_vista.setBackground(Color.white);
				}
				double valor_venda_vista = Double.parseDouble(txt_preco_vista.getText());
				
				
				if (txt_preco_comissao_contador.getText().equalsIgnoreCase("")) {
					txt_preco_comissao_contador.setBackground(Color.yellow );
					return;
				}else {
					txt_preco_comissao_contador.setBackground(Color.white);
				}
				double valor_comissao_contador = Double.parseDouble(txt_preco_comissao_contador.getText());
				
				
				
				
				try {
					MySql_Certificado.getInsereCertificado(descricao, validade, custo, valor_comissao_contador, valor_venda, valor_venda_vista);
					JOptionPane.showMessageDialog(null, "Cadastro Gravado");
					dispose();
					FrmCadastroCertificados f = new FrmCadastroCertificados();
					f.setVisible(true);
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "NAO PASSOU PELO METODO DE INSERIR \n"
							+ "PROBLEMA NA GRAVACAO NO BANCO");
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO CAPTURADO: \n"+e.toString());
				}	
				
			}
		});
		btnGravar.setBounds(10, 128, 177, 46);
		contentPane.add(btnGravar);
		
		txtCampoCusto = new JTextField();
		txtCampoCusto.setText("* Campo custo use somente valores ate 999.99 Reais");
		txtCampoCusto.setEditable(false);
		txtCampoCusto.setColumns(10);
		txtCampoCusto.setBounds(10, 182, 339, 20);
		contentPane.add(txtCampoCusto);
		
		txtCampoCusto_1 = new JTextField();
		txtCampoCusto_1.setText("* Campo custo operador decimal (ponto) \".\"");
		txtCampoCusto_1.setEditable(false);
		txtCampoCusto_1.setColumns(10);
		txtCampoCusto_1.setBounds(379, 182, 339, 20);
		contentPane.add(txtCampoCusto_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 708, 275);
		contentPane.add(scrollPane);
		
		tabela_certificados = new JTable();
		tabela_certificados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DESCRI\u00C7\u00C3O", "TEMPO", "CUSTO", "VENDA PRAZO","VENDA VISTA", "COMISSAO"
			}
		));
		
	DefaultTableModel minhaTabela = (DefaultTableModel) tabela_certificados.getModel();
		
	try {
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from certificado");
		ResultSet resultSet = statement.getResultSet();
		Certificado c = new Certificado();
		while (resultSet.next()) {
			
			c.setId(resultSet.getInt("id"));
			c.setTipo(resultSet.getString("descricao"));
			c.setTempoValidade(resultSet.getInt("validade"));
			c.setCustoCertificado(resultSet.getDouble("custo"));
			c.setPreco_prazo(resultSet.getDouble("valor_venda"));
			c.setCustoComissao(resultSet.getDouble("valor_comissao_contador"));
			c.setPreco_vista(resultSet.getDouble("valor_a_vista"));
			
			Object[] linha1 = { c.getId(), c.getTipo(),c.getTempoValidade()+" Meses","R$ "+c.getCustoCertificado(),"R$ "+c.getPreco_prazo(),"R$ "+c.getPreco_vista(),"R$ "+c.getCustoComissao(),};
			minhaTabela.addRow(linha1);

		}
		resultSet.close();
		statement.close();
		connection.close();
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		
		
		tabela_certificados.getColumnModel().getColumn(0).setMaxWidth(40);
		tabela_certificados.getColumnModel().getColumn(1).setMaxWidth(250);
		tabela_certificados.getColumnModel().getColumn(2).setMaxWidth(80);
		tabela_certificados.getColumnModel().getColumn(3).setMaxWidth(70);
		tabela_certificados.getColumnModel().getColumn(4).setMaxWidth(95);
		tabela_certificados.getColumnModel().getColumn(5).setMaxWidth(95);
		tabela_certificados.getColumnModel().getColumn(6).setMaxWidth(78);
		
		
		///////
		scrollPane.setViewportView(tabela_certificados);
		
		JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o parcelado R$");
		lblPreoDeVenda.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		lblPreoDeVenda.setBounds(181, 87, 127, 14);
		contentPane.add(lblPreoDeVenda);
		
		JLabel lblComissoContadorR = new JLabel("Comiss\u00E3o R$");
		lblComissoContadorR.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		lblComissoContadorR.setBounds(557, 87, 88, 14);
		contentPane.add(lblComissoContadorR);
		
		txt_preco_venda = new JTextField();
		txt_preco_venda.addKeyListener(new KeyAdapter() {

	@Override
			public void keyTyped(KeyEvent e) {
				
				String caracteres="0987654321.";

			       if(! caracteres.contains(e.getKeyChar()+"")){

			              e.consume();

			       }
			       
			       int caracteres_maximo = 5;
				if (txt_preco_venda.getText().length()>caracteres_maximo ) {
			    	   e.consume();
			    	   JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");
					
				}
				
				
			}
		});
		txt_preco_venda.setColumns(10);
		txt_preco_venda.setBounds(318, 84, 51, 20);
		contentPane.add(txt_preco_venda);
		
		txt_preco_comissao_contador = new JTextField();
		txt_preco_comissao_contador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				String caracteres="0987654321.";

			       if(! caracteres.contains(e.getKeyChar()+"")){

			              e.consume();

			       }
			       
			       int caracteres_maximo = 5;
				if (txt_preco_comissao_contador.getText().length()>caracteres_maximo ) {
			    	   e.consume();
			    	   JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");
					
				}
				
				
			}
		});
		txt_preco_comissao_contador.setColumns(10);
		txt_preco_comissao_contador.setBounds(637, 84, 51, 20);
		contentPane.add(txt_preco_comissao_contador);
		
		JLabel lblPreoVista = new JLabel("Pre\u00E7o \u00E0 vista R$");
		lblPreoVista.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		lblPreoVista.setBounds(379, 87, 111, 14);
		contentPane.add(lblPreoVista);
		
		
		txt_preco_vista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				String caracteres="0987654321.";

			       if(! caracteres.contains(e.getKeyChar()+"")){

			              e.consume();

			       }
			       
			       int caracteres_maximo = 5;
				if (txt_preco_vista.getText().length()>caracteres_maximo ) {
			    	   e.consume();
			    	   JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");
					
				}
				
				
				
				
			}
		});
		txt_preco_vista.setColumns(10);
		txt_preco_vista.setBounds(488, 84, 51, 20);
		contentPane.add(txt_preco_vista);
		
		JButton btnNewButton = new JButton("Imprimir Tabela");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				MessageFormat titulo = new MessageFormat("Listagem de Certificados\n");//Imprime um Titulo no cabeçalho da página.  
				MessageFormat numeroPaginas = new MessageFormat("Desenvolvido por www.mpiinformatica.com - Pagina - {0,number,integer}");//Imprime o numero de página no rodapé de cada página.  
				  
				try {  
				    // Imprime o coteudo da "jTable1":  
				    tabela_certificados.print(JTable.PrintMode.FIT_WIDTH, titulo, numeroPaginas);  
				  
				} catch (java.awt.print.PrinterException ex) {  
				    JOptionPane.showMessageDialog(null, "Erro de impressão: " + ex.getMessage(), "Erro de impressão", JOptionPane.ERROR_MESSAGE);  
				}
				
				
			}
		});
		btnNewButton.setBounds(557, 499, 161, 23);
		contentPane.add(btnNewButton);
		
		btnEditar.setBounds(422, 143, 89, 23);
		contentPane.add(btnEditar);
		
		
		btnCancelar.setBounds(526, 143, 89, 23);
		contentPane.add(btnCancelar);
		
		
		btnExcluir.setBounds(629, 143, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblCadastroDeCertificados = new JLabel("Cadastro de certificados d\u00EDsponiveis para venda");
		lblCadastroDeCertificados.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCertificados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCadastroDeCertificados.setBounds(10, 11, 708, 20);
		contentPane.add(lblCadastroDeCertificados);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{rb_12, rb_24, rb_36, label_meses, txt_Custo, btnGravar, label_Validade, label_Custo, txt_Descricao, label_Descricao}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_Descricao, rb_12, rb_24, rb_36, label_meses, txt_Custo, btnGravar, contentPane, label_Validade, label_Custo, label_Descricao}));
		
	}
}
