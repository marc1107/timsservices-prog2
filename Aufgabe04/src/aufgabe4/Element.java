package aufgabe4;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public class Element<T>
{
	final private T content;
	private int frequency;

	/**
	 * Konstruktor.
	 * 
	 * @param word Wort
	 * @param f    H&auml;ufgkeit
	 */
	public Element(T data, int f)
	{
		this.content = data;
		this.frequency = f;
	}

	/**
	 * Liefert Wort zur&uuml;ck.
	 * 
	 * @return Wort
	 */
	public T getContent()
	{
		return content;
	}

	/**
	 * Liefert H&auml;ufgkeit zur&uuml;ck.
	 * 
	 * @return H&auml;ufgkeit
	 */
	public int getFrequency()
	{
		return frequency;
	}

	/**
	 * Addiert zur H&auml;ufgkeit f dazu.
	 * 
	 * @param f H&auml;ufgkeits&auml;nderung.
	 */
	public void addFrequency(int f)
	{
		frequency += f;
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * 
	 * @return String-Darstellung.
	 */
	@Override
	public String toString()
	{
		return content + ":" + frequency;
	}
}
