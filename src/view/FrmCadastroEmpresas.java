package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FrmCadastroEmpresas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public FrmCadastroEmpresas() {
		setTitle("Cadastro de Empresas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Fantasia:");
		lblNewLabel.setBounds(10, 11, 131, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(10, 34, 131, 14);
		contentPane.add(lblRazoSocial);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 61, 131, 14);
		contentPane.add(lblCnpj);
		
		JLabel lblTelefones = new JLabel("Telefones:");
		lblTelefones.setBounds(10, 86, 131, 14);
		contentPane.add(lblTelefones);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 113, 131, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSite = new JLabel("Site:");
		lblSite.setBounds(10, 140, 131, 14);
		contentPane.add(lblSite);
		
		JLabel lblRespLegalNa = new JLabel("Resp. Legal na RF 1:");
		lblRespLegalNa.setBounds(10, 169, 131, 14);
		contentPane.add(lblRespLegalNa);
		
		JLabel lblRespLegalNa_1 = new JLabel("Resp. Legal na RF 2:");
		lblRespLegalNa_1.setBounds(10, 198, 131, 14);
		contentPane.add(lblRespLegalNa_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(165, 166, 259, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 195, 259, 20);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(165, 8, 259, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 31, 259, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 58, 259, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 83, 259, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(165, 110, 259, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(165, 137, 259, 20);
		contentPane.add(textField_5);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(335, 265, 89, 23);
		contentPane.add(btnGravar);
	}
}
