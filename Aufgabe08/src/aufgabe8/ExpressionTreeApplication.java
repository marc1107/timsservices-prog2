package aufgabe8;

import java.util.Map;
import java.util.TreeMap;

import aufgabe8.expressions.Product;
import aufgabe8.expressions.Quotient;
import aufgabe8.expressions.Sum;

/**
 * Testprogramm für Aufgabe 8 (Bäume für arithmetische Ausdrücke).
 *
 * @author oliverbittel
 * @since 17.3.2019
 */
public class ExpressionTreeApplication
{
	public static void main(String[] args)
	{
		Var n = new Var("n"); // Variable n
		Var a = new Var("a"); // Variable a
		Var b = new Var("b"); // Variable b
		Constant one = new Constant(1.0); // Konstante 1.0
		Constant two = new Constant(2.0); // Konstante 2.0

		// Ausdruck e1 = a*a + b*b
		Expression e1 = new Sum(new Product(a, a), new Product(b, b));

		// Ausdruck e2 = n*(n+1)/2
		Expression e2 = new Quotient(new Product(n, new Sum(n, one)), two);

		// Belegung alle Variablen als Map:
		Map<String, Double> varBel = new TreeMap<>();
		varBel.put("a", 3.0);
		varBel.put("b", 4.0);
		varBel.put("n", 10.0);

		// Evaluiere e1 und e2:
		System.out.println(e1.Eval(varBel)); // 25.0
		System.out.println(e2.Eval(varBel)); // 55.0

		// Alle Variablen in e1:
		System.out.println(e1.GetVars()); // [a, b]

		// Pruefe, ob alle Variablen in e1 belegt sind:
		System.out.println(varBel.keySet().containsAll(e1.GetVars())); // true

		// e1 und e2 ausgeben (ueberschriebene toString-Methode):
		System.out.println(e1); // ((a * a) + (b * b))
		System.out.println(e2); // ((n * (n + 1.0)) / 2.0)
	}
}
