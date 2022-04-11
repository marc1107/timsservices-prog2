package aufgabe11.teil1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Map;
import java.util.TreeMap;

public class HaeufigkeitsanalyseEinesDeutschenTextes
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Map<String, Integer> haeufigkeit = ermittleHaufigekeiten("Kafka_Der_Prozess.txt");
		printTop100(haeufigkeit);
	}

	public static Map<String, Integer> ermittleHaufigekeiten(String fileName) throws FileNotFoundException, IOException
	{

		LineNumberReader in = new LineNumberReader(new FileReader(fileName));
		String line;

		Map<String, Integer> haeufigkeit = new TreeMap<>(); // enthaelt zu jedem Wort seine Haefigkeit

		while ((line = in.readLine()) != null)
		{
			String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
			for (String w : wf)
			{
				if (w.length() == 0 || w.length() == 1)
					continue;

				if (haeufigkeit.putIfAbsent(w, 1) != null)
					haeufigkeit.put(w, haeufigkeit.get(w) + 1);
			}
		}

		return haeufigkeit;
	}

	public static void printTop100(Map<String, Integer> h)
	{
		h.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(100)
				.forEach((w) -> System.out.println(w));

		/*
		 * Legacy version:
		 * 
		 * List<Map.Entry<String, Integer>> list = new LinkedList<>(h.entrySet());
		 * 
		 * list.sort(new Comparator<Map.Entry<String, Integer>>() {
		 * 
		 * @Override public int compare(Map.Entry<String, Integer> arg0,
		 * Map.Entry<String, Integer> arg1) { if (arg0.getValue() == arg1.getValue())
		 * return 0; else if (arg0.getValue() > arg1.getValue()) return -1; else return
		 * 1; } });
		 * 
		 * for (int x = 0; x < 100; x++) { System.out.println(list.get(x)); }
		 */
	}

}
