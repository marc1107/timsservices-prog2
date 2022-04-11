package aufgabe8;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Var implements Expression
{
	private String name;

	public Var(String name)
	{
		this.name = name;
	}

	@Override
	public double Eval(Map<String, Double> varBel)
	{
		return varBel.get(name);
	}

	@Override
	public Set<String> GetVars()
	{
		TreeSet<String> set = new TreeSet<>();
		set.add(name);
		return set;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
