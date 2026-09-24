package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Perfil;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Usuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSenha;
	private JTextField txtUsuario;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Usuarios() {
		setBackground(new Color(51, 51, 153));
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 444);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNome.setBounds(10, 11, 84, 24);
		lblNome.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNome);
		
		JComboBox cbxPerfil = new JComboBox();
		cbxPerfil.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxPerfil.setForeground(new Color(255, 128, 192));
		cbxPerfil.setBackground(new Color(255, 225, 240));
		cbxPerfil.setModel(new DefaultComboBoxModel(Perfil.values()));
		cbxPerfil.setBounds(10, 208, 414, 22);
		contentPane.add(cbxPerfil);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenha.setBounds(10, 67, 176, 25);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(0, 0, 0));
		txtSenha.setBounds(10, 93, 416, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setBounds(10, 36, 416, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblAreaDeTrabalho = new JLabel("Areá de Trabalho:");
		lblAreaDeTrabalho.setForeground(new Color(0, 0, 0));
		lblAreaDeTrabalho.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAreaDeTrabalho.setBounds(10, 186, 197, 24);
		contentPane.add(lblAreaDeTrabalho);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setBounds(10, 124, 65, 24);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setBounds(10, 149, 414, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		
		JCheckBox chkAtivo = new JCheckBox("Usuário Ativo");
		chkAtivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAtivo.setBounds(10, 244, 189, 23);
		contentPane.add(chkAtivo);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCadastrar.setBounds(50, 293, 326, 79);
		contentPane.add(btnCadastrar);
		
		JLabel lblBolinho = new JLabel("");
		lblBolinho.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/patrimonio/imagens/bolinho.gif")));
		lblBolinho.setBounds(-42, 11, 532, 488);
		contentPane.add(lblBolinho);
		
		JLabel lblCBolos = new JLabel("");
		lblCBolos.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/patrimonio/imagens/BolosRedVelvetFundo.png")));
		lblCBolos.setBounds(-82, -14, 612, 447);
		contentPane.add(lblCBolos);
		

		
		
		//Vamos isntanciar a camada Pojo e passar os dados para
		//o usuário, por meio do comando set
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Vamos instânciar a camada Pojo e passar os dados
				//para o usuário por meio do comando set.
 
				br.com.patrimonio.pojo.Usuarios us = new br.com.patrimonio.pojo.Usuarios();
				
				us.setNome(txtUsuario.getText());
				us.setEmail(txtEmail.getText());
				us.setSenha_hash(txtSenha.getText());
				us.setPerfil((Perfil)cbxPerfil.getSelectedItem());
				us.setAtivo(chkAtivo.isSelected());
				
				DAOUsuario dau = new DAOUsuario();
				String rs = dau.cadastrar(us);
				
				
				JOptionPane.showMessageDialog(null, rs, "Aviso",JOptionPane.WARNING_MESSAGE);
				
			}
		});
 
	}
}
 
 