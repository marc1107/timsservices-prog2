package aufgabe8.expressions;

import java.util.Map;

import aufgabe8.CompoundExpression;
import aufgabe8.Expression;

public class Sum extends CompoundExpression
{
	public Sum(Expression exp1, Expression exp2)
	{
		super(exp1, exp2);
	}

	@Override
	public double Eval(Map<String, Double> varBel)
	{
		return super.exp1.Eval(varBel) + super.exp2.Eval(varBel);
	}

	@Override
	public String toString()
	{
		return "(" + exp1.toString() + " + " + exp2.toString() + ")";
	}
}
