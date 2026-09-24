package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.patrimonio.dao.DAOCursos;

public class ListarCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdCurso;
	private JTable JtableCursos; 
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JLabel lblListarCursos;
	private JLabel lblDigiteCodigoCurso;
	private JTable tableCursos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCursos frame = new ListarCursos();
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
	public ListarCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblListarCursos = new JLabel("Listar Cursos:");
		lblListarCursos.setBounds(10, 11, 92, 14);
		contentPane.add(lblListarCursos);
		
		lblDigiteCodigoCurso = new JLabel("Digite o código do curso:");
		lblDigiteCodigoCurso.setBounds(10, 45, 147, 14);
		contentPane.add(lblDigiteCodigoCurso);
		
		textIdCurso = new JTextField();
		textIdCurso.setBounds(155, 45, 139, 19);
		contentPane.add(textIdCurso);
		textIdCurso.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 453, 2);
		contentPane.add(separator);
		
		JButton btnRealizarBusca = new JButton("Realizar a Busca");
		btnRealizarBusca.setBounds(304, 41, 159, 23);
		contentPane.add(btnRealizarBusca);
		
		tableCursos = new JTable();
		tableCursos.setBounds(10, 81, 453, 169);
		contentPane.add(tableCursos);
		
		String cx = textIdCurso.getText();
		if(cx.equals("") || cx==null){
			carregarCursos(0);
		}
		else {
			carregarCursos(Integer.parseInt(cx));
		}
		
		
	}
	
	public void carregarCursos(Integer id) {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 36, 12, 202);
		contentPane.add(scrollPane);
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id","Nome do curso","Sigla do Curso","Criado Por","Criado Em"};
		
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dados da nossa JTable. O Modelo de dados organizar as informações que
		//serão apresentadas
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		//Instância da classe DAOCurso
		DAOCursos dc = new DAOCursos();
		//Receber a lista de todos os cursos do banco de dados em uma lista
		
		List<br.com.patrimonio.pojo.Cursos> lc;
		br.com.patrimonio.pojo.Cursos cs;
		
		if( id == 0) {
			lc =dc.listar();
			for(br.com.patrimonio.pojo.Cursos cr : lc) {
				Object[] dados = {
						cr.getId(),
						cr.getNome(),
						cr.getSigla(),
						cr.getCriado_por(),
						cr.getCriado_em()
				};
				model.addRow(dados);
			}
		}
		else {
			cs = dc.listarID(id);

			Object[] dados = {
					cs.getId(),
					cs.getNome(),
					cs.getSigla(),
					cs.getCriado_por(),
					cs.getCriado_em()
			};
			model.addRow(dados);
			}
		}

		
	
	}

