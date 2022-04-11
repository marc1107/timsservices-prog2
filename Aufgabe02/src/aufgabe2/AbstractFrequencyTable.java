package aufgabe2;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable implements FrequencyTable
{
	@Override
	public boolean isEmpty()
	{
		return this.size() == 0;
	}

	@Override
	public void addAll(FrequencyTable fq)
	{
		for (int i = 0; i < fq.size(); i++)
		{
			this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
		}
	}

	@Override
	public void copyMostFrequent(FrequencyTable fq)
	{
		for (int i = 0; i < this.size(); i++)
		{
			if (this.get(i).getFrequency() == this.get(0).getFrequency())
				fq.add(this.get(i).getWord(), this.get(i).getFrequency());
			else
				break;
		}
	}

	@Override
	public void copyLeastFrequent(FrequencyTable fq)
	{
		int i = 0;
		while (this.get(i).getFrequency() > this.get(this.size() - 1).getFrequency())
			i++;

		while (i < this.size())
		{
			fq.add(this.get(i).getWord(), this.get(i).getFrequency());
			i++;
		}
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * 
	 * @return String-Darstellung.
	 */
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder("");
		s.append("{");
		for (int i = 0; i < this.size(); i++)
		{
			s.append(this.get(i)).append(", ");
		}
		s.append("} size = ").append(this.size());

		return s.toString();
	}
}