// O. Bittel
// 10.03.2017

package aufgabe10;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelefonBuchSuchenLoeschenPanel extends JPanel implements ActionListener
{
	private TelefonBuch tb;
	private JComboBox<String> box;
	private JTextField nameField;
	private JTextField zusatzField;

	private JTextArea area;

	public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb, JTextArea area)
	{
		this.tb = tb;
		this.area = area;

		this.setLayout(new FlowLayout());
		Border border = BorderFactory.createTitledBorder("Einfügen");
		this.setBorder(border);

		JPanel leftPanel = new JPanel(new GridLayout(2, 2));

		JLabel nameLbl = new JLabel("Name");
		JLabel zusatzLbl = new JLabel("Zusatz");
		nameField = new JTextField(10);
		zusatzField = new JTextField(10);

		leftPanel.add(nameLbl);
		leftPanel.add(nameField);
		leftPanel.add(zusatzLbl);
		leftPanel.add(zusatzField);

		this.add(leftPanel);

		JPanel rightPanel = new JPanel(new GridLayout(1, 2));

		box = new JComboBox<String>();

		box.addItem("Exakte Suche");
		box.addItem("Prefix-Suche");
		box.addItem("Löschen");

		JButton btn = new JButton("Anwenden");
		btn.addActionListener(this);

		rightPanel.add(box);
		rightPanel.add(btn);

		this.add(rightPanel);
	}

	public void actionPerformed(ActionEvent e)
	{
		String data = "";
		this.area.setText("");

		if (box.getSelectedItem().toString().contains("Exakte"))
		{
			data = this.tb.exactSearch(nameField.getText(), zusatzField.getText()) + "\n";
		}
		else if (box.getSelectedItem().toString().contains("Prefix"))
		{
			List<String> list = this.tb.prefixSearch(nameField.getText());
			for (String name : list)
			{
				data += name + "\n";
			}
		}
		else
		{
			if (this.tb.remove(nameField.getText(), zusatzField.getText()))
				JOptionPane.showMessageDialog(this, "Successful");
			else
				JOptionPane.showMessageDialog(this, "No entry existing");
			return;
		}

		if (data.equals("null\n"))
		{
			JOptionPane.showMessageDialog(this, "No entry existing!");
			return;
		}

		this.area.append(data);
	}
}
