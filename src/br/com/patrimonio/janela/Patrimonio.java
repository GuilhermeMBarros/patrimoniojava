package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.pojo.Locais1;
import br.com.patrimonio.pojo.Perfil;
import br.com.patrimonio.pojo.Status;
import br.com.patrimonio.pojo.Categorias;
import br.com.patrimonio.pojo.Cursos1;

public class Patrimonio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero_tombamento;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtValor_Aquisicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patrimonio frame = new Patrimonio();
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
	public Patrimonio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Patrimonio.class.getResource("/br/com/patrimonio/imagens/d.iconimage.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Patrimonio");
		setBounds(100, 100, 729, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 221, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumero_Tombamento = new JLabel("Número Tombamento:");
		lblNumero_Tombamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero_Tombamento.setBounds(10, 11, 168, 14);
		contentPane.add(lblNumero_Tombamento);
		
		txtNumero_tombamento = new JTextField();
		txtNumero_tombamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumero_tombamento.setBounds(10, 25, 267, 20);
		contentPane.add(txtNumero_tombamento);
		txtNumero_tombamento.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 56, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNome.setBounds(10, 68, 267, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(10, 109, 68, 14);
		contentPane.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescricao.setBounds(10, 124, 267, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurso.setBounds(10, 163, 86, 14);
		contentPane.add(lblCurso);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocal.setBounds(10, 212, 46, 14);
		contentPane.add(lblLocal);
		
		JLabel lblCategoeia = new JLabel("Categoria:");
		lblCategoeia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoeia.setBounds(10, 271, 73, 14);
		contentPane.add(lblCategoeia);
		
		JComboBox comboBoxCurso = new JComboBox();
		comboBoxCurso.setModel(new DefaultComboBoxModel(Cursos1.values()));
		comboBoxCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxCurso.setBounds(10, 179, 220, 22);
		contentPane.add(comboBoxCurso);
		
		JComboBox comboBoxLocais = new JComboBox();
		comboBoxLocais.setModel(new DefaultComboBoxModel(Locais1.values()));
		comboBoxLocais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxLocais.setBounds(10, 226, 220, 22);
		contentPane.add(comboBoxLocais);
		
		JComboBox comboBoxCriado_Por = new JComboBox();
		comboBoxCriado_Por.setModel(new DefaultComboBoxModel(Perfil.values()));
		comboBoxCriado_Por.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxCriado_Por.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxCriado_Por.setBounds(10, 344, 220, 22);
		contentPane.add(comboBoxCriado_Por);
		
		JComboBox comboBoxAtualizado_Por = new JComboBox();
		comboBoxAtualizado_Por.setModel(new DefaultComboBoxModel(Perfil.values()));
		comboBoxAtualizado_Por.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxAtualizado_Por.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxAtualizado_Por.setBounds(372, 24, 277, 22);
		contentPane.add(comboBoxAtualizado_Por);
		
		JLabel lblCriado_Por = new JLabel("Criado Por:");
		lblCriado_Por.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCriado_Por.setBounds(10, 330, 80, 14);
		contentPane.add(lblCriado_Por);
		
		JLabel lnlAtualizado_Por = new JLabel("Atualizado Por:");
		lnlAtualizado_Por.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnlAtualizado_Por.setBounds(372, 11, 110, 14);
		contentPane.add(lnlAtualizado_Por);
		
		JLabel lblValor_Aquisicao = new JLabel("Valor de Aquisição:");
		lblValor_Aquisicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor_Aquisicao.setBounds(359, 70, 161, 14);
		contentPane.add(lblValor_Aquisicao);
		
		txtValor_Aquisicao = new JTextField();
		txtValor_Aquisicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtValor_Aquisicao.setBounds(372, 85, 277, 20);
		contentPane.add(txtValor_Aquisicao);
		txtValor_Aquisicao.setColumns(10);
		
		JLabel lblIconWinxClub = new JLabel("");
		lblIconWinxClub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIconWinxClub.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/patrimonio/imagens/Winx.png")));
		lblIconWinxClub.setBounds(294, 152, 470, 281);
		contentPane.add(lblIconWinxClub);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(372, 127, 46, 14);
		contentPane.add(lblStatus);
		
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxStatus.setModel(new DefaultComboBoxModel(Status.values()));
		comboBoxStatus.setBounds(372, 144, 141, 22);
		contentPane.add(comboBoxStatus);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(Categorias.values()));
		comboBoxCategoria.setBounds(10, 286, 220, 22);
		contentPane.add(comboBoxCategoria);
		
		JLabel lblGato = new JLabel("");
		lblGato.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/patrimonio/imagens/gato.gif")));
		lblGato.setBounds(-21, 319, 348, 108);
		contentPane.add(lblGato);
		
		JLabel lblRosa1 = new JLabel("");
		lblRosa1.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/patrimonio/imagens/rosa-roja-rosa.gif")));
		lblRosa1.setBounds(483, 299, 412, 474);
		contentPane.add(lblRosa1);
		
		JLabel lblcoracoes = new JLabel("");
		lblcoracoes.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/patrimonio/imagens/coracoes.png")));
		lblcoracoes.setBounds(20, -22, 828, 436);
		contentPane.add(lblcoracoes);
		
		JLabel lblRosa2 = new JLabel("");
		lblRosa2.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/patrimonio/imagens/rosa-roja-rosa.gif")));
		lblRosa2.setBounds(-263, 330, 412, 474);
		contentPane.add(lblRosa2);

	}
}
