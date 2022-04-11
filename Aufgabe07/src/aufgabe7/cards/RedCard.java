package aufgabe7.cards;

public class RedCard extends Card
{
	public RedCard()
	{
		this.setFarbe(GenerateRandomColor(this));
		this.setWert(GenerateRandomValue());
	}
}
