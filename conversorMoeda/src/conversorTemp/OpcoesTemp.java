package conversorTemp;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversorMoeda.DesejaContinuar;
import conversorMoeda.EscolhaValor;

public class OpcoesTemp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcoesTemp frame = new OpcoesTemp("");
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
	public OpcoesTemp(final String valor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Escolha uma opcções de conversão :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(92, 11, 236, 14);
		contentPane.add(lblNewLabel);

		String[] opcoesTemp = { "De graus Celsius a graus Fahrenheit", "De graus Fahrenheit a graus Celsius",
				"De graus Kelvin a graus Celsius", "De graus Celsius a graus Kelvin",
				 };

		final JComboBox comboBox = new JComboBox(opcoesTemp);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setBounds(92, 52, 236, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Double total = Double.parseDouble(valor);
				String tipoConversao = String.valueOf(comboBox.getSelectedItem());

				switch (tipoConversao) {
				case "De graus Celsius a graus Fahrenheit":
					converterCelsiusAFahren(total);
					break;
				case "De graus Fahrenheit a graus Celsius":
					converterFahrenACelsius(total);
					break;

				case "De graus Kelvin a graus Celsius":
					converterKelvinACelsius(total);
					break;

				case "De graus Celsius a graus Kelvin":
					converterCelsiusAKelvin(total);
					break;

				}
				dispose();
				new DesejaContinuar().setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 85, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				new EscolhaValor().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(335, 85, 89, 23);
		contentPane.add(btnNewButton_1);
	}																				//moedaDolar = (double) Math.round(moedaDolar * 100d) / 100;

	public void converterCelsiusAFahren(double valor) {
		double celcToFahren = valor * 1.8 + 32;
		celcToFahren = (double)Math.round(celcToFahren*100d)/100;
		JOptionPane.showMessageDialog(null, "O valor da conversão é de" + celcToFahren + " Graus Fahrenheit.");
	}

	public void converterFahrenACelsius(double valor) {
		double fahrenToCelc = (valor - 32) * 5 / 9;
		fahrenToCelc =(double)Math.round(fahrenToCelc*100d)/100;
		JOptionPane.showMessageDialog(null, "O valor da conversão é de " + fahrenToCelc + " Graus Celsius.");
	}

	public void converterKelvinACelsius(double valor) {
		double kelvinToCelc = valor - 273.15;
		kelvinToCelc = (double)Math.round(kelvinToCelc*100d)/100;
		JOptionPane.showMessageDialog(null, "O valor da conversão é de " + kelvinToCelc + " Graus Celsius.");
	}

	public void converterCelsiusAKelvin(double valor) {
		double celcToKelvin = valor + 273.15;
		JOptionPane.showMessageDialog(null, "Ovalor da conversão é de "+celcToKelvin + " Graus Kelvin. ");
	}
}
