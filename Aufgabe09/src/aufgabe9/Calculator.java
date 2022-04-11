package aufgabe9;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculator extends JFrame
{
	private JPanel contentPane;

	public JTextField textFieldOp1;
	public JTextField textFieldOp2;
	public JTextField textFieldResult;
	public JButton btnAdd;
	public JButton btnMult;
	public JButton btnMinus;
	public JButton btnDiv;
	public JButton btnSin;
	public JButton btnCos;
	public JButton btnPow;
	public JButton btnLog;

	public JButton btnClear;

	public JCheckBox chckbxBrightTheme;
	public JRadioButton rdbtnRad;
	public JRadioButton rdbtnDeg;

	private CalculatorListener cl;

	public static void main(String[] args)
	{
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}

	public Calculator()
	{
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 407, 462);

		this.cl = new CalculatorListener(this);

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 1));
		setContentPane(contentPane);

		JPanel upperPanel = new JPanel();
		contentPane.add(upperPanel);
		upperPanel.setLayout(null);

		BuildLabels(upperPanel);

		BuildTextBoxes(upperPanel);

		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1, 0));
		contentPane.add(middlePanel);

		BuildRadioButtonsAndCheckBox(middlePanel);

		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new GridLayout(2, 4));
		contentPane.add(lowerPanel);

		BuildButtons(lowerPanel);

		JPanel clearPanel = new JPanel();
		contentPane.add(clearPanel);
		clearPanel.setLayout(null);

		btnClear = new JButton("Clear");
		btnClear.setBounds(150, 12, 114, 25);
		btnClear.addActionListener(this.cl);
		clearPanel.add(btnClear);
	}

	private void BuildLabels(JPanel upperPanel)
	{
		JLabel lblOperand = new JLabel("Operand x");
		lblOperand.setBounds(65, 12, 95, 15);
		upperPanel.add(lblOperand);

		JLabel lblOperand_1 = new JLabel("Operand y");
		lblOperand_1.setBounds(65, 42, 95, 15);
		upperPanel.add(lblOperand_1);

		JLabel lblResultat = new JLabel("Resultat");
		lblResultat.setBounds(65, 79, 95, 15);
		upperPanel.add(lblResultat);
	}

	private void BuildTextBoxes(JPanel upperPanel)
	{
		textFieldOp1 = new JTextField();
		textFieldOp1.setBounds(194, 10, 162, 19);
		textFieldOp1.setText("0");
		upperPanel.add(textFieldOp1);

		textFieldOp2 = new JTextField();
		textFieldOp2.setBounds(194, 40, 162, 19);
		textFieldOp2.setText("0");
		upperPanel.add(textFieldOp2);

		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setBounds(194, 77, 162, 19);
		upperPanel.add(textFieldResult);
	}

	private void BuildRadioButtonsAndCheckBox(JPanel middlePanel)
	{
		ButtonGroup group = new ButtonGroup();

		rdbtnRad = new JRadioButton("Rad");
		rdbtnDeg = new JRadioButton("Deg");

		group.add(rdbtnDeg);
		group.add(rdbtnRad);

		rdbtnDeg.setSelected(true);

		chckbxBrightTheme = new JCheckBox("Bright Theme");
		chckbxBrightTheme.setSelected(true);
		chckbxBrightTheme.addItemListener(this.cl);

		middlePanel.add(rdbtnRad);
		middlePanel.add(rdbtnDeg);
		middlePanel.add(chckbxBrightTheme);
	}

	private void BuildButtons(JPanel lowerPanel)
	{
		btnAdd = new JButton("+");
		btnAdd.addActionListener(this.cl);
		lowerPanel.add(btnAdd);

		btnMult = new JButton("*");
		btnMult.addActionListener(this.cl);
		lowerPanel.add(btnMult);

		btnMinus = new JButton("-");
		btnMinus.addActionListener(this.cl);
		lowerPanel.add(btnMinus);

		btnDiv = new JButton("/");
		btnDiv.addActionListener(this.cl);
		lowerPanel.add(btnDiv);

		btnSin = new JButton("sin");
		btnSin.addActionListener(this.cl);
		lowerPanel.add(btnSin);

		btnCos = new JButton("cos");
		btnCos.addActionListener(this.cl);
		lowerPanel.add(btnCos);

		btnPow = new JButton("x^y");
		btnPow.addActionListener(this.cl);
		lowerPanel.add(btnPow);

		btnLog = new JButton("log2");
		btnLog.addActionListener(this.cl);
		lowerPanel.add(btnLog);
	}
}
