package conversorMoeda;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EscolhaValor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolhaValor frame = new EscolhaValor();
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
	public EscolhaValor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String valor =  textField.getText();
				double total = Double.parseDouble(valor);
				
				dispose();
				new OpcoesMoeda(valor).setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 76, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Inicio().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(169, 76, 89, 23);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char dinheiro = e.getKeyChar();

				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
						|| e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
					textField.setEditable(true);
				} else {
					textField.setEditable(false);
				}
			}
		});
		textField.setBounds(20, 42, 210, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Insira um valor : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 162, 14);
		contentPane.add(lblNewLabel);
	}
}
