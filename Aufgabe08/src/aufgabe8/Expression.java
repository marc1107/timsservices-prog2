package aufgabe8;

import java.util.Map;
import java.util.Set;

public interface Expression
{
	public double Eval(Map<String, Double> varBel);

	public Set<String> GetVars();
}
