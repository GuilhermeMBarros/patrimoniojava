package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Color;

public class TelaSplash extends JFrame {
	public TelaSplash() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					JFrame frame = new JFrame();
					//frame.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
					//Setar o fundo da tela como trasnparente. O comando new Color
					//aplica uma nova cor em três posiçõese a quarta é a opacidade,
					//onde opacidade é o nivel de transparência. Portanto
					//os valores 0.0f são aplicados nas posições RGB-->
					//R-->Red(vermelho)
					//G-->Green(verde)
					//B-->Blue(azul)
					//com seus respectivois valores variando entre0.0 até 255.0.
					//São valores com casa decimais, por esse motivo estamos usando
					//os números como float(f), então poderiamos ter, por exemplo
					// as cores ( 10.56f , 45.80f , 14.0f )
					
				
			
					frame.setType(Type.UTILITY);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 521, 441);
					
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null); //Isso fará a tela abrir no centro do monitor
		frame.setUndecorated(true);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 153, 255));
		progressBar.setValue(30);
		progressBar.setBounds(16, 373, 468, 14);
		contentPane.add(progressBar);
		
		JLabel lblSquash = new JLabel("Squash - Gestão de Patrimônio");
		lblSquash.setHorizontalAlignment(SwingConstants.CENTER);
		lblSquash.setFont(new Font("Clarendon BT", Font.PLAIN, 30));
		lblSquash.setBounds(6, 302, 489, 25);
		contentPane.add(lblSquash);
		
		JLabel lblLegenda = new JLabel("...");
		lblLegenda.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLegenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblLegenda.setBounds(180, 323, 141, 39);
		contentPane.add(lblLegenda);
		
		JLabel lblRosas1 = new JLabel("");
		lblRosas1.setLabelFor(lblRosas1);
		lblRosas1.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/patrimonio/imagens/rosssa.png")));
		lblRosas1.setBounds(24, -26, 399, 353);
		contentPane.add(lblRosas1);
		
		JLabel lblRosas2 = new JLabel("");
		lblRosas2.setLabelFor(lblRosas2);
		lblRosas2.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/patrimonio/imagens/rosass.png")));
		lblRosas2.setBounds(-441, -654, 1125, 959);
		contentPane.add(lblRosas2);
		
		JLabel lblcoracoes = new JLabel("");
		lblcoracoes.setBounds(206, 313, 46, 14);
		contentPane.add(lblcoracoes);
		
		JLabel lblcoracoes1 = new JLabel("\r\n");
		lblcoracoes1.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/patrimonio/imagens/coracoes.png")));
		lblcoracoes1.setBounds(216, 92, 481, 332);
		contentPane.add(lblcoracoes1);
		
		JLabel lblcoracoes2 = new JLabel("\r\n");
		lblcoracoes2.setFont(new Font("Clarendon BT", Font.PLAIN, 11));
		lblcoracoes2.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/patrimonio/imagens/coracoes.png")));
		lblcoracoes2.setBounds(-207, 92, 481, 332);
		contentPane.add(lblcoracoes2);

		frame.setVisible(true);
		
		try {
		for(int i = 0 ; i <=100; i++) {
			Thread.sleep(100);
			progressBar.setValue(i);
			
			if(i < 30) {
				lblLegenda.setText("Carregando ...");
			}
			else if(i < 60) {
				lblLegenda.setText("Carregando os modulos ...");
			}
			else if(i < 80) {
				lblLegenda.setText("Carregando os configurações ...");
			}
			else if(i < 90) {
				lblLegenda.setText("Iniciando a interface ...");
			}
			else {
				lblLegenda.setText("Tudo Pronto!");
			}
		}
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	frame.dispose();
	TelaPrincipal tp = new TelaPrincipal();
	tp.setVisible(true);
}}
