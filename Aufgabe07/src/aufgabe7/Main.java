package aufgabe7;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aufgabe7.cards.BlackCard;
import aufgabe7.cards.Card;
import aufgabe7.cards.RedCard;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		TestRandomIntegerValues(100_000);

		TestKafka();

		TestCards(1000);

		// Performance Test
		Integer[] testArray1 = GenerateRandomIntArray(200_000);
		// QuickSort.QuickSort(testArray1, true);
		Integer[] testArray2 = testArray1.clone();
		Integer[] testArray3 = testArray1.clone();

		PerformanceTest.TestQuickSort(testArray1);
		PerformanceTest.TestQuickSortMedian(testArray2);
		PerformanceTest.TestArraysSort(testArray3);
	}

	private static void TestRandomIntegerValues(int amount)
	{
		Integer[] ia = GenerateRandomIntArray(amount);
		// QuickSort.QuickSort(ia, false);
		System.out.println(Arrays.toString(ia));
	}

	private static void TestKafka() throws IOException
	{
		List<String> list = new ArrayList<>();
		LineNumberReader in = new LineNumberReader(new FileReader("Kafka_Der_Prozess.txt"));
		String line;
		while ((line = in.readLine()) != null)
		{
			String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
			for (String w : wf)
			{
				if (w.length() == 0 || w.length() == 1)
					continue;
				list.add(w);
			}
		}
		String[] sa = list.toArray(new String[list.size()]);
		QuickSort.QuickSort(sa, true);
		System.out.println(Arrays.toString(sa));
		in.close();
	}

	private static void TestCards(int amount)
	{
		Card cards[] = GenerateRandomCards(amount);

		QuickSort.QuickSort(cards, true);
		System.out.println(Arrays.toString(cards));
	}

	private static Integer[] GenerateRandomIntArray(int amount)
	{
		Integer a[] = new Integer[amount];

		for (int x = 0; x < a.length; x++)
		{
			a[x] = (int) (Math.random() * a.length);
		}

		return a;
	}

	private static Card[] GenerateRandomCards(int amount)
	{
		int numberOfCards = (int) (Math.random() * amount);
		Card cards[] = new Card[numberOfCards];

		for (int i = 0; i < numberOfCards; i++)
		{
			if (Math.random() > 0.5)
				cards[i] = new RedCard();
			else
				cards[i] = new BlackCard();
		}

		return cards;
	}
}
