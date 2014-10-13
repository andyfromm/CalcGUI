package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import CalcEngine.Calculator;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class CalculatorGUI {

	private JFrame frame;
	private JTextField InvestAmtText;
	private JTextField YearsText;
	private JTextField AnnIntRateText;
	private JTextField CalcText;
	private JLabel lblFutureValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		InvestAmtText = new JTextField();
		InvestAmtText.setText("0");
		InvestAmtText.setBounds(241, 54, 113, 20);
		panel.add(InvestAmtText);
		InvestAmtText.setColumns(10);
		
		YearsText = new JTextField();
		YearsText.setText("0");
		YearsText.setBounds(241, 85, 113, 20);
		panel.add(YearsText);
		YearsText.setColumns(10);
		
		AnnIntRateText = new JTextField();
		AnnIntRateText.setText("0");
		AnnIntRateText.setBounds(241, 116, 113, 20);
		panel.add(AnnIntRateText);
		AnnIntRateText.setColumns(10);
		
		JLabel InvestLabel = new JLabel("Investment Amount");
		InvestLabel.setBounds(129, 57, 113, 14);
		panel.add(InvestLabel);
		
		JLabel YearsLabel = new JLabel("Years");
		YearsLabel.setBounds(204, 88, 38, 14);
		panel.add(YearsLabel);
		
		JLabel InterestLabel = new JLabel("Annual Interest Rate");
		InterestLabel.setBounds(124, 119, 118, 14);
		panel.add(InterestLabel);
		
		JButton CalcButton = new JButton("CALCULATE");
		CalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				double Amount = Double.parseDouble(InvestAmtText.getText());
				double Years = Double.parseDouble(YearsText.getText());
				double Interest = Double.parseDouble(AnnIntRateText.getText());
				double FV;
				
				Calculator GUIwork = new Calculator();
				
				FV = GUIwork.Calculator(Amount, Years, Interest);
								
				CalcText.setText(Double.toString(FV));
			}
		});
		CalcButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CalcButton.setBounds(238, 178, 116, 23);
		panel.add(CalcButton);
		
		CalcText = new JTextField();
		CalcText.setEditable(false);
		CalcText.setBounds(241, 147, 113, 20);
		panel.add(CalcText);
		CalcText.setColumns(10);
		
		lblFutureValue = new JLabel("Future Value");
		lblFutureValue.setBounds(168, 150, 74, 14);
		panel.add(lblFutureValue);
	}
}
