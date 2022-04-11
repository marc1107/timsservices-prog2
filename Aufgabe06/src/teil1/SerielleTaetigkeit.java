package teil1;

public class SerielleTaetigkeit extends ZusammengesetzeTaetigkeit
{
	@Override
	public double getTime()
	{
		double time = 0;
		for (Taetigkeit t : super.meineTaetigkeitet)
		{
			time += t.getTime();
		}
		return time;
	}
}
