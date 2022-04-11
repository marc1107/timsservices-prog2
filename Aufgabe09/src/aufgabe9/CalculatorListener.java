package aufgabe9;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalculatorListener implements ActionListener, ItemListener
{
	private Calculator calc;

	public CalculatorListener(Calculator calc)
	{
		this.calc = calc;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		double op1 = 0;
		double op2 = 0;

		try
		{
			op1 = Double.parseDouble(calc.textFieldOp1.getText());
			op2 = Double.parseDouble(calc.textFieldOp2.getText());
		}
		catch (NumberFormatException ex)
		{
			System.out.println("Only numbers allowed!");
			return;
		}

		if (e.getSource() == calc.btnAdd)
			calc.textFieldResult.setText(String.valueOf(op1 + op2));
		if (e.getSource() == calc.btnMinus)
			calc.textFieldResult.setText(String.valueOf(op1 - op2));
		if (e.getSource() == calc.btnMult)
			calc.textFieldResult.setText(String.valueOf(op1 * op2));
		if (e.getSource() == calc.btnDiv)
			calc.textFieldResult.setText(String.valueOf(op1 / op2));
		if (e.getSource() == calc.btnPow)
			calc.textFieldResult.setText(String.valueOf(Math.pow(op1, op2)));
		if (e.getSource() == calc.btnSin)
		{
			if (calc.rdbtnDeg.isSelected())
				op1 = Math.toRadians(op1);

			calc.textFieldResult.setText(String.valueOf(Math.sin(op1)));
			calc.textFieldOp2.setText("0");
		}
		if (e.getSource() == calc.btnCos)
		{
			if (calc.rdbtnDeg.isSelected())
				op1 = Math.toRadians(op1);

			calc.textFieldResult.setText(String.valueOf(Math.cos(op1)));
			calc.textFieldOp2.setText("0");
		}
		if (e.getSource() == calc.btnLog)
		{
			calc.textFieldResult.setText(String.valueOf(Math.log(op1) / Math.log(2)));
			calc.textFieldOp2.setText("0");
		}
		if (e.getSource() == calc.btnClear)
		{
			calc.textFieldOp1.setText("0");
			calc.textFieldOp2.setText("0");
			calc.textFieldResult.setText("0");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getStateChange() == 1)
		{
			calc.textFieldOp1.setBackground(Color.WHITE);
			calc.textFieldOp2.setBackground(Color.WHITE);
			calc.textFieldResult.setBackground(Color.WHITE);

			calc.textFieldOp1.setForeground(Color.BLACK);
			calc.textFieldOp2.setForeground(Color.BLACK);
			calc.textFieldResult.setForeground(Color.BLACK);
		}
		else
		{
			calc.textFieldOp1.setBackground(Color.BLACK);
			calc.textFieldOp2.setBackground(Color.BLACK);
			calc.textFieldResult.setBackground(Color.BLACK);

			calc.textFieldOp1.setForeground(Color.WHITE);
			calc.textFieldOp2.setForeground(Color.WHITE);
			calc.textFieldResult.setForeground(Color.WHITE);
		}
	}
}
