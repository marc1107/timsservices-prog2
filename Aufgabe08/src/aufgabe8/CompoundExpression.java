package aufgabe8;

import java.util.Set;

public abstract class CompoundExpression implements Expression
{
	protected Expression exp1;
	protected Expression exp2;

	public CompoundExpression(Expression exp1, Expression exp2)
	{
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	@Override
	public Set<String> GetVars()
	{
		Set<String> set = this.exp1.GetVars();
		set.addAll(this.exp2.GetVars());
		return set;
	}
}
