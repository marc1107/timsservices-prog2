package aufgabe7;

import java.util.Arrays;

public class PerformanceTest
{
	private PerformanceTest()
	{
	}

	public static void TestQuickSort(Integer[] testArray)
	{
		long start = System.nanoTime();
		QuickSort.QuickSort(testArray, false);
		long end = System.nanoTime();
		double elapsedTime = (double) (end - start) / 1.0e06;
		System.out.println("QuickSort: \t\t" + elapsedTime + " ms");
	}

	public static void TestQuickSortMedian(Integer[] testArray)
	{
		long start = System.nanoTime();
		QuickSort.QuickSort(testArray, true);
		long end = System.nanoTime();
		double elapsedTime = (double) (end - start) / 1.0e06;
		System.out.println("QuickSortMedian: \t" + elapsedTime + " ms");
	}

	public static void TestArraysSort(Integer[] testArray)
	{
		long start = System.nanoTime();
		Arrays.sort(testArray);
		long end = System.nanoTime();
		double elapsedTime = (double) (end - start) / 1.0e06;
		System.out.println("ArraysSort: \t\t" + elapsedTime + " ms");
	}
}
