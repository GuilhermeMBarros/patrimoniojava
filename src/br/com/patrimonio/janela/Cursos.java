package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOCursos;
import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Usuarios;

public class Cursos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCurso;
	private JTextField txtSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cursos frame = new Cursos();
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
	public Cursos() {
		setResizable(false);
		setTitle("PedroSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cursos.class.getResource("/br/com/patrimonio/imagens/d.iconimage.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 32, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setForeground(new Color(255, 255, 255));
		lblSigla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSigla.setBounds(10, 78, 46, 31);
		contentPane.add(lblSigla);
		
		JLabel lblCriado_Por = new JLabel("Criado Por:");
		lblCriado_Por.setForeground(new Color(255, 255, 255));
		lblCriado_Por.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCriado_Por.setBounds(10, 150, 93, 14);
		contentPane.add(lblCriado_Por);
		
		txtNomeCurso = new JTextField();
		txtNomeCurso.setBounds(10, 47, 360, 20);
		contentPane.add(txtNomeCurso);
		txtNomeCurso.setColumns(10);
		
		txtSigla = new JTextField();
		txtSigla.setBounds(10, 105, 360, 20);
		contentPane.add(txtSigla);
		txtSigla.setColumns(10);
		
		DAOUsuario dau = new DAOUsuario();
		
		//A JComboBox foi tipada como Usuarios para
		//receber apenas objeto usuarios completo
		//com todos os seus dados.
		JComboBox<Usuarios> cbxCriadoPor = new JComboBox();
		cbxCriadoPor.setBounds(10, 169, 360, 22);
		contentPane.add(cbxCriadoPor);
		
		//Criamos uma lista de usuários que retorna do método
		//listaAtivos da classe DAoUsusario. Aqui estamos passadp
		//todos os usuários retornados para a lista lst que
		//está tipada como Usuarios, assim ela recebe apenas
		//dados de usuarios
		List<Usuarios> lst = dau.listaAtivos();
		//A estrutura for está pegando um item por vez dentro de
		//lst e passa para a variável us. O item que está sendo
		//passado é um ususário completo. Depois de passado para a 
		//variável us, estamos adicionando à JComboBox o ususário
		//com todos os seus dados.
		for(Usuarios us: lst) {
			cbxCriadoPor.addItem(us);
		}
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrar.setBounds(49, 247, 265, 71);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Cursos.class.getResource("/br/com/patrimonio/imagens/rosa3.iconimage.png")));
		lblNewLabel_1.setBounds(199, -130, 274, 309);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Cursos.class.getResource("/br/com/patrimonio/imagens/rosa3.iconimage.png")));
		lblNewLabel_2.setBounds(-138, 158, 433, 428);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Cursos.class.getResource("/br/com/patrimonio/imagens/circulo.icoimage.png")));
		lblNewLabel.setBounds(62, -83, 714, 428);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Cursos.class.getResource("/br/com/patrimonio/imagens/circulo.icoimage.png")));
		lblNewLabel_3.setBounds(-334, -34, 714, 428);
		contentPane.add(lblNewLabel_3);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instância da classe Cursos e Intância da classe DAO
				br.com.patrimonio.pojo.Cursos curso = new br.com.patrimonio.pojo.Cursos();
				DAOCursos dc = new DAOCursos();
				
				curso.setNome(txtNomeCurso.getText());
				curso.setSigla(txtSigla.getText());
				
				Usuarios u = (Usuarios)cbxCriadoPor.getSelectedItem();
				curso.setCriado_por(u.getId());
				
				String m = dc.cadastrar(curso);
				JOptionPane.showMessageDialog(null, m);
			}
		});
		
	}
}
