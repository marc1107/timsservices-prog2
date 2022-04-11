package aufgabe5;

public class PythagorasBaum
{
	public static void main(String[] args)
	{
		Point A = new Point(0.7, 0);

		double w = 2;
		StdDraw.setPenRadius(0.0018);

		StdDraw.setCanvasSize(1024, 1024);
		StdDraw.setXscale(-10, +10);
		StdDraw.setYscale(-5, +15);

		StdDraw.show(0);
		// Variante 1
		Draw(A, Math.toRadians(0), w);

		// Variante 2
		// DrawRandom(A, Math.toRadians(0), w);
		StdDraw.show(0);
	}

	private static void Draw(Point A, double gamma, double w)
	{
		if (w <= 0.01)
			return;

		double delta = Math.toRadians(30);

		double s = w * Math.sin(gamma);
		double c = w * Math.cos(gamma);

		Point B = new Point(A.x + c, A.y + s);
		Point C = new Point(A.x + c - s, A.y + s + c);
		Point D = new Point(A.x - s, A.y + c);

		if (w <= 0.20)
			StdDraw.setPenColor(StdDraw.GREEN);
		else
			StdDraw.setPenColor(StdDraw.BROWN);

		StdDraw.line(A.x, A.y, B.x, B.y);
		StdDraw.line(B.x, B.y, C.x, C.y);
		StdDraw.line(C.x, C.y, D.x, D.y);
		StdDraw.line(D.x, D.y, A.x, A.y);

		double u = w * Math.cos(delta);
		double v = w * Math.sin(delta);

		Point E = new Point(D.x + u * Math.cos(gamma + delta), D.y + u * Math.sin(gamma + delta));
		StdDraw.line(C.x, C.y, E.x, E.y);
		StdDraw.line(E.x, E.y, D.x, D.y);

		StdDraw.filledPolygon(new double[] { A.x, B.x, C.x, E.x, D.x }, new double[] { A.y, B.y, C.y, E.y, D.y });

		Draw(D, gamma + delta, u);
		Draw(E, gamma - Math.toRadians(90) + delta, v);
	}

	private static void DrawRandom(Point A, double gamma, double w)
	{
		if (w <= 0.01)
			return;

		double delta = Math.toRadians(Math.random() * (70 - 20));

		double sw = w * Math.sin(gamma);
		double cw = w * Math.cos(gamma);

		double h = Math.random() * 2 * w;
		double sh = h * Math.sin(gamma);
		double ch = h * Math.cos(gamma);

		Point B = new Point(A.x + cw, A.y + sw);
		Point C = new Point(A.x + cw - sh, A.y + sw + ch);
		Point D = new Point(A.x - sh, A.y + ch);

		if (w <= 0.20)
			StdDraw.setPenColor(StdDraw.GREEN);
		else
			StdDraw.setPenColor(StdDraw.BROWN);

		StdDraw.line(B.x, B.y, C.x, C.y);
		StdDraw.line(D.x, D.y, A.x, A.y);

		double u = w * Math.cos(delta);
		double v = w * Math.sin(delta);

		Point E = new Point(D.x + u * Math.cos(gamma + delta), D.y + u * Math.sin(gamma + delta));

		DrawRandom(D, gamma + delta, u);
		DrawRandom(E, gamma - Math.toRadians(90) + delta, v);
	}

	static class Point
	{
		public double x;
		public double y;

		public Point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
