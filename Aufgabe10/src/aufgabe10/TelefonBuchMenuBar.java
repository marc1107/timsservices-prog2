// O. Bittel
// 10.03.2017

package aufgabe10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelefonBuchMenuBar extends JMenuBar implements ActionListener
{

	private TelefonBuch telBuch;

	private JMenuItem readItem;
	private JMenuItem saveItem;
	private JMenuItem exitItem;

	public TelefonBuchMenuBar(TelefonBuch tb)
	{
		this.telBuch = tb;

		JMenu menu = new JMenu("File");

		readItem = new JMenuItem("TelefonBuch lesen...");
		saveItem = new JMenuItem("TelefonBuch speichern...");
		exitItem = new JMenuItem("TelefonBuch beenden");

		readItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);

		menu.add(readItem);
		menu.add(saveItem);
		menu.add(exitItem);

		this.add(menu);
	}

	public void actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("./"));
		if (e.getSource() == readItem)
		{
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

			int returnVal = fc.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION)
				this.telBuch.read(fc.getSelectedFile());
		}
		else if (e.getSource() == saveItem)
		{
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

			int returnVal = fc.showSaveDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION)
				this.telBuch.save(fc.getSelectedFile());
		}
		else if (e.getSource() == exitItem)
		{
			if (JOptionPane.showConfirmDialog(this, "Confirm exit?", "Exit", JOptionPane.YES_NO_OPTION) == 0)
				System.exit(0);
		}
	}
}
