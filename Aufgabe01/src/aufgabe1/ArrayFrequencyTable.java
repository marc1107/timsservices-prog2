package aufgabe1;

/**
 *
 * @author oliverbittel
 * @since 18.3.2019
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable
{
	private int size;
	Word fqTable[];
	private final int DefaultSize = 100;

	public ArrayFrequencyTable()
	{
		clear();
		this.size = 0;
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public void clear()
	{
		this.fqTable = new Word[this.DefaultSize];
		this.size = 0;
	}

	@Override
	public void add(String w, int f)
	{
		for (int i = 0; i < this.size; i++)
		{
			if (fqTable[i].getWord().equals(w))
			{
				fqTable[i].addFrequency(f);
				Sort(i);
				return;
			}
		}

		if (this.size >= this.fqTable.length)
		{
			Word[] temp = new Word[this.size + this.DefaultSize];
			System.arraycopy(this.fqTable, 0, temp, 0, this.size);
			this.fqTable = temp;
		}

		fqTable[this.size] = new Word(w, f);
		Sort(this.size);
		this.size++;
	}

	private void Sort(int i)
	{
		while (i > 0)
		{
			if (this.fqTable[i - 1].getFrequency() < this.fqTable[i].getFrequency())
			{
				Word tmp = this.fqTable[i - 1];
				this.fqTable[i - 1] = this.fqTable[i];
				this.fqTable[i] = tmp;
				i--;
			}
			else
				break;
		}
	}

	@Override
	public void add(String w)
	{
		this.add(w, 1);
	}

	@Override
	public Word get(int pos)
	{
		if (pos <= this.size && pos >= 0)
			return fqTable[pos];

		throw new IllegalArgumentException("Index out of bounds!");
	}

	@Override
	public int get(String w)
	{
		for (int i = 0; i < this.size; i++)
		{
			if (fqTable[i].getWord().equals(w))
				return fqTable[i].getFrequency();
		}

		return 0;
	}
}
