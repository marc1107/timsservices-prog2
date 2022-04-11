package teil1;

import java.util.ArrayList;
import java.util.List;

public abstract class ZusammengesetzeTaetigkeit implements Taetigkeit
{
	protected List<Taetigkeit> meineTaetigkeitet = new ArrayList<Taetigkeit>();

	public abstract double getTime();

	@Override
	public void add(Taetigkeit t)
	{
		this.meineTaetigkeitet.add(t);
	}

	@Override
	public void remove(Taetigkeit t)
	{
		this.meineTaetigkeitet.remove(t);
	}

	@Override
	public int getAnzahl()
	{
		int count = 0;
		for (Taetigkeit t : this.meineTaetigkeitet)
		{
			count += t.getAnzahl();
		}
		return count;
	}
}
