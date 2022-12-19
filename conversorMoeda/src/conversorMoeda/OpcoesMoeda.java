package conversorMoeda;

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

public class OpcoesMoeda extends JFrame {
	
	 
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcoesMoeda frame = new OpcoesMoeda("");
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
	public OpcoesMoeda(final String valor) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha a moeda para qual deseja converter :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(57, 11, 280, 14);
		contentPane.add(lblNewLabel);
		
		String[] opcoesmoedas = { "De Reais a Dólares", "De Reais a Euros",
				 "De Dólares a Reais", "De Euros a Reais", };
		
		
		
		final JComboBox comboBox = new JComboBox(opcoesmoedas);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(77, 36, 233, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double total = Double.parseDouble(valor);
				String tipoConversao = String.valueOf(comboBox.getSelectedItem());
				
				switch (tipoConversao) {
				case "De Reais a Dólares":
					converterRealADolar(total);
					break;
				case "De Reais a Euros":
					converterRealAEuro(total);
					break;
					
				case "De Dólares a Reais":
					converterDolarAReal(total);
					break;

				case "De Euros a Reais":
					converterEuroAReal(total);
					break;
				}
				
				
				dispose();
				new DesejaContinuar().setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 67, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				new EscolhaValor().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(292, 67, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public void converterRealADolar(double valor) {
		double moedaDolar = valor / 5.23;
		moedaDolar = (double) Math.round(moedaDolar * 100d) / 100;
		JOptionPane.showMessageDialog(null, "Você tem $ " + moedaDolar + " Dolares");
	}

	public void converterDolarAReal(double valor) {
		double moedaReal = valor / 0.19;
		moedaReal = (double) Math.round(moedaReal * 100d) / 100;
		JOptionPane.showMessageDialog(null, "Você tem $ " + moedaReal + " Reais");

	}

	public void converterRealAEuro(double valor) {
		double moedaEuro = valor / 5.53;
		moedaEuro = (double) Math.round(moedaEuro * 100d) / 100;
		JOptionPane.showMessageDialog(null, "Você tem $ " + moedaEuro + " Euros");
	}

	public void converterEuroAReal(double valor) {
		double moedaReal = valor / 0.18;
		moedaReal = (double) Math.round(moedaReal * 100d) / 100;
		JOptionPane.showMessageDialog(null, "Você tem $ " + moedaReal + " Reais");
	}

}
