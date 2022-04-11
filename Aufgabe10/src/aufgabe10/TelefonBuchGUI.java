// O. Bittel
// 10.03.2017

package aufgabe10;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelefonBuchGUI extends JFrame
{
	private TelefonBuch telBuch;

	public static void main(String[] args)
	{
		new TelefonBuchGUI();
	}

	public TelefonBuchGUI()
	{
		// TelefonBuch anlegen:
		telBuch = new TelefonBuch();

		// Menuleiste einbauen:
		this.setJMenuBar(new TelefonBuchMenuBar(telBuch));

		// mainPanel mit Umrandung versehen und das
		// Einfuegen- und SuchenLoeschenPanel einbauen:
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		mainPanel.add(new TelefonBuchEinfuegenPanel(telBuch));

		TelefonBuchAusgabePanel ausgabePanel = new TelefonBuchAusgabePanel(telBuch);

		mainPanel.add(new TelefonBuchSuchenLoeschenPanel(telBuch, ausgabePanel.GetTextArea()));
		mainPanel.add(ausgabePanel);

		this.setContentPane(mainPanel);

		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				if (JOptionPane.showConfirmDialog(TelefonBuchGUI.this, "Confirm exit?", "Exit",
						JOptionPane.YES_NO_OPTION) == 0)
					System.exit(0);
			}
		});

		// Sonstige Eigenschaften des Hauptfenster setzen:
		this.setTitle("Telefonbuch");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}