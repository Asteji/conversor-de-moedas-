package conversorMoeda;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversorTemp.EscolhaValorTemp;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] opcoes = { "Conversor de Moedas", "Conversor de Temperatura" };

		final JComboBox comboBox = new JComboBox(opcoes);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setBounds(123, 38, 182, 29);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Avançar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				String tipoConversor = String.valueOf(comboBox.getSelectedItem());

				switch (tipoConversor) {
				case "Conversor de Moedas":
					dispose();
					new EscolhaValor().setVisible(true);
					break;
				case "Conversor de Temperatura":
					dispose();
					new EscolhaValorTemp().setVisible(true);
					break;

				}
			}
		});
		btnNewButton.setBounds(10, 79, 87, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ProgramFinalizado().setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setBounds(337, 79, 87, 29);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Selecione um Conversor : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(123, 13, 164, 14);
		contentPane.add(lblNewLabel);
	}
}
