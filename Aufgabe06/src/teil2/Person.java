package teil2;

import java.util.ArrayList;
import java.util.List;

public class Person
{
	private String name;
	private List<Buch> ausgelieheneBuecher;

	public Person(String name)
	{
		this.name = name;
		this.ausgelieheneBuecher = new ArrayList<>();
	}

	public String getName()
	{
		return this.name;
	}

	public boolean leihtAus(Buch b)
	{
		if (this.ausgelieheneBuecher.contains(b))
			return false;

		if (b.getEntleiher() != null && b.getEntleiher() != this)
			return false;

		this.ausgelieheneBuecher.add(b);
		b.wirdAusgeliehen(this);

		return true;
	}

	public boolean gibtZurueck(Buch b)
	{
		if (!this.ausgelieheneBuecher.contains(b))
			return false;

		this.ausgelieheneBuecher.remove(b);
		b.wirdZurueckGegeben();
		return true;
	}

	public void print()
	{
		System.out.print(this.name + ": [ ");
		for (Buch b : this.ausgelieheneBuecher)
		{
			System.out.print("(" + b.getName() + ") ");
		}
		System.out.println("]");
	}
}
