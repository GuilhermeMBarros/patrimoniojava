package br.com.patrimonio.janela;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;

import br.com.patrimonio.pojo.Locais;
import br.com.patrimonio.pojo.Locais1;

import javax.swing.event.AncestorEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Sistema de Gestão de Patrimônio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Obter a resolução da tela
		Dimension tamanho = getSize();
		
		setBounds(100, 100, 1920, 300);
		//Abrir a tela sempre maximizada
				setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setMnemonic('c');
		menuBar.add(mnCadastrar);
		
		JMenuItem ItemUsuario = new JMenuItem("Usuário");
		ItemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Usuarios formUsuario = new Usuarios();
				formUsuario.setVisible(true);
				
				
				
			}
		});
		mnCadastrar.add(ItemUsuario);
		
		JMenuItem ItemCursos = new JMenuItem("Cursos");
		ItemCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Cursos formCursos = new Cursos();
				formCursos.setVisible(true);
				
				
			}
		});
		mnCadastrar.add(ItemCursos);
		
		JMenuItem ItemLocais = new JMenuItem("Locais");
		ItemLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Locais formLocais = new Locais();
				
				
			}
		});
		mnCadastrar.add(ItemLocais);
		
		JMenuItem ItemCategorias = new JMenuItem("Categorias");
		mnCadastrar.add(ItemCategorias);
		
		JMenuItem ItemPatrimonio = new JMenuItem("Patrimônio");
		mnCadastrar.add(ItemPatrimonio);
		
		JMenuItem ItemMovimentacao = new JMenuItem("Movimentação");
		mnCadastrar.add(ItemMovimentacao);
		
		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setMnemonic('s');
		menuBar.add(mnConsulta);
		
		JMenu mnListarTudo = new JMenu("Listar Tudo");
		mnConsulta.add(mnListarTudo);
		
		JMenuItem ItemLstUsuario = new JMenuItem("Usuário");
		ItemLstUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnListarTudo.add(ItemLstUsuario);
		
		JMenuItem ItemLstCursos = new JMenuItem("Cursos");
		ItemLstCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Cursos().setVisible(true);
			}
		});
		ItemLstCursos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnListarTudo.add(ItemLstCursos);
		
		JMenuItem ItemLstPatrimonio = new JMenuItem("Patrimônio");
		mnListarTudo.add(ItemLstPatrimonio);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		mnListarTudo.add(menuItem);
		
		JMenu ItemPesquisarPorId = new JMenu("Pesquisar Por ID");
		mnConsulta.add(ItemPesquisarPorId);
		
		JMenuItem ItemPorIdMovimentacao = new JMenuItem("Movimentação");
		ItemPesquisarPorId.add(ItemPorIdMovimentacao);
		
		JMenuItem ItemPorIdBaixarPatrimonio = new JMenuItem("Baixar Patrimônio");
		ItemPesquisarPorId.add(ItemPorIdBaixarPatrimonio);
		
		JSeparator separator = new JSeparator();
		mnConsulta.add(separator);
		
		JMenu ItemConsultaUsuario = new JMenu("Usuário Por ...");
		mnConsulta.add(ItemConsultaUsuario);
		
		JMenuItem ItemConsultaPerfil = new JMenuItem("Perfil");
		ItemConsultaUsuario.add(ItemConsultaPerfil);
		
		JMenuItem ItemConsultaEmail = new JMenuItem("E-Mail");
		ItemConsultaUsuario.add(ItemConsultaEmail);
		
		JSeparator separator_1 = new JSeparator();
		mnConsulta.add(separator_1);
		
		JMenu mnConsultaMovimentacao = new JMenu("Movimentação");
		mnConsulta.add(mnConsultaMovimentacao);
		
		JMenuItem ItemConsultaTipo = new JMenuItem("Tipo");
		mnConsultaMovimentacao.add(ItemConsultaTipo);
		JPanel contentPane = new JPanel();
	
		contentPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, getWidth(), 25);
		toolBar.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		toolBar.setEnabled(false);
		toolBar.setBounds(0, 0, 404, 25);
		contentPane.add(toolBar);
		
		JButton btnAbrirUsuario = new JButton("");
		btnAbrirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuarios formUsuario = new Usuarios();
				formUsuario.setVisible(true);
			}
		});
		btnAbrirUsuario.setToolTipText("Abrir formulário de usuário");
		btnAbrirUsuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/d.iconimage.png")));
		toolBar.add(btnAbrirUsuario);
		
		JButton btnAbrirCursos = new JButton("");
		btnAbrirCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cursos formCursos = new Cursos();
				formCursos.setVisible(true);
			}
		});
		toolBar.add(btnAbrirCursos);
		btnAbrirCursos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/d.iconimage.png")));
		
		JButton btnAbrirLocais = new JButton("");
		btnAbrirLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				br.com.patrimonio.janela.Locais formLocais = new br.com.patrimonio.janela.Locais();
				formLocais.setVisible(true);
			}
		});
		btnAbrirLocais.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/d.iconimage.png")));
		toolBar.add(btnAbrirLocais);
		//Abrir a tela sempre maximizada
		setExtendedState(MAXIMIZED_BOTH);

	}
}
