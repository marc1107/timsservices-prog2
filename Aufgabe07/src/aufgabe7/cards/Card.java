package aufgabe7.cards;

public abstract class Card implements Comparable<Card>
{
	private Farbe farbe;
	private Wert wert;

	public Farbe getFarbe()
	{
		return farbe;
	}

	public void setFarbe(Farbe farbe)
	{
		this.farbe = farbe;
	}

	public Wert getWert()
	{
		return wert;
	}

	public void setWert(Wert wert)
	{
		this.wert = wert;
	}

	protected Wert GenerateRandomValue()
	{
		return Wert.values()[(int) (Math.random() * Wert.values().length)];
	}

	protected Farbe GenerateRandomColor(Card card)
	{
		int color = (int) (Math.random() * 2 + 1);

		if (card instanceof BlackCard)
		{
			if (color == 1)
				return Farbe.Kreuz;
			else
				return Farbe.Pique;
		}
		else
		{
			if (color == 1)
				return Farbe.Herz;
			else
				return Farbe.Karo;
		}
	}

	@Override
	public int compareTo(Card c)
	{
		if (this.farbe.compareTo(c.farbe) == 0)
			return this.wert.compareTo(c.wert);
		else if (this.farbe.compareTo(c.farbe) > 0)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString()
	{
		return this.getFarbe() + "/" + this.getWert();
	}

	public enum Farbe
	{
		Karo, Herz, Pique, Kreuz
	}

	public enum Wert
	{
		Sieben, Acht, Neun, Zehn, Bube, Dame, Koenig, Ass
	}

}
