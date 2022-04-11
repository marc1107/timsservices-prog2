package teil1;

public class ParalleleTaetigkeit extends ZusammengesetzeTaetigkeit
{
	@Override
	public double getTime()
	{
		double time = 0;
		for (Taetigkeit t : super.meineTaetigkeitet)
		{
			if (t.getTime() > time)
				time = t.getTime();
		}
		return time;
	}
}
