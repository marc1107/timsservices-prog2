package aufgabe7.cards;

public class BlackCard extends Card
{
	public BlackCard()
	{
		this.setFarbe(GenerateRandomColor(this));
		this.setWert(GenerateRandomValue());
	}

}
