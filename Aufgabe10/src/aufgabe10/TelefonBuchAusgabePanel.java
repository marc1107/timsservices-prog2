package aufgabe10;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelefonBuchAusgabePanel extends JPanel
{
	private TelefonBuch telBuch;
	private JTextArea area;

	public TelefonBuchAusgabePanel(TelefonBuch telBuch)
	{
		this.telBuch = telBuch;
		this.setBorder(BorderFactory.createTitledBorder("Ausgabe"));

		area = new JTextArea(30, 42);
		area.setEditable(false);

		JScrollPane sp = new JScrollPane(area);
		this.add(sp);
	}

	public JTextArea GetTextArea()
	{
		return this.area;
	}
}
