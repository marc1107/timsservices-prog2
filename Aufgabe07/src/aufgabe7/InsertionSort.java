package aufgabe7;

public class InsertionSort
{
	public static <T extends Comparable<T>> void InsertionSort(T[] a, int left, int right)
	{
		int i = left;
		while (i < right)
		{
			int j = i;
			while (j > 0 && a[j - 1].compareTo(a[j]) > 0)
			{
				T tmp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = tmp;

				j--;
			}
			i++;
		}
	}
}
