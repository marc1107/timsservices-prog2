package aufgabe8;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Constant implements Expression
{
	private double value;

	public Constant(double d)
	{
		this.value = d;
	}

	@Override
	public double Eval(Map<String, Double> varBel)
	{
		return value;
	}

	@Override
	public Set<String> GetVars()
	{
		return new TreeSet<String>();
	}

	@Override
	public String toString()
	{
		return Double.toString(value);
	}
}
