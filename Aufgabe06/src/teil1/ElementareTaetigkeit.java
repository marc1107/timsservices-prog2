package teil1;

public class ElementareTaetigkeit implements Taetigkeit
{
	private double time;
	private String beschr;

	public ElementareTaetigkeit(String beschr, double time)
	{
		this.beschr = beschr;
		this.time = time;
	}

	@Override
	public double getTime()
	{
		return this.time;
	}

	@Override
	public void add(Taetigkeit t)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(Taetigkeit t)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public int getAnzahl()
	{
		return 1;
	}

}
