package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import br.com.patrimonio.pojo.Locais1;
import java.awt.Color;

public class Locais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locais frame = new Locais();
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
	public Locais() {
		setResizable(false);
		setTitle("Locais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocais = new JLabel("Locais:");
		lblLocais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocais.setBounds(10, 11, 46, 14);
		contentPane.add(lblLocais);
		
		JComboBox comboBoxLocais = new JComboBox();
		comboBoxLocais.setModel(new DefaultComboBoxModel(Locais1.values()));
		comboBoxLocais.setBounds(10, 36, 46, 22);
		contentPane.add(comboBoxLocais);

	}
}
