package teil2;

public class Buch
{
	private String name;
	private Person entleiher;

	public Buch(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public Person getEntleiher()
	{
		return this.entleiher;
	}

	public boolean wirdAusgeliehen(Person p)
	{
		if (this.entleiher == null)
		{
			this.entleiher = p;
			p.leihtAus(this);

			return true;
		}
		return false;
	}

	public boolean wirdZurueckGegeben()
	{
		if (this.entleiher != null)
		{
			Person p = entleiher;
			entleiher = null;
			p.gibtZurueck(this);

			return true;
		}
		return false;
	}

	public void print()
	{
		try
		{
			System.out.println(this.name + " -> " + this.entleiher.getName());
		}
		catch (NullPointerException ex)
		{
			System.out.println(this.name + " -> keiner");
		}
	}
}
