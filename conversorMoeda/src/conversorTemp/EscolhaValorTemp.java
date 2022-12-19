package conversorTemp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversorMoeda.OpcoesMoeda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EscolhaValorTemp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolhaValorTemp frame = new EscolhaValorTemp();
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
	public EscolhaValorTemp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Insira um valor  de temperatura :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 249, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char temperatura = e.getKeyChar();

				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
						|| e.getExtendedKeyCode() == KeyEvent.VK_DELETE ||e.getExtendedKeyCode()==KeyEvent.VK_SUBTRACT) {
					textField.setEditable(true);
				} else {
					textField.setEditable(false);
				}
			}
		});
		textField.setBounds(20, 44, 210, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = textField.getText();
				double total = Double.parseDouble(valor);

				dispose();
				new OpcoesTemp(valor).setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 81, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(170, 81, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
