package aufgabe7;

public class QuickSort
{
	public static <T extends Comparable<T>> void QuickSort(T[] a, boolean median)
	{
		QuickSort_R(a, median, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void QuickSort_R(T[] a, boolean median, int left, int right)
	{
		if (left < right)
		{
			if (right - left <= 100)
			{
				InsertionSort.InsertionSort(a, left, right + 1);
				return;
			}

			int pivot = Partition(a, median, left, right);

			QuickSort_R(a, median, left, pivot - 1);
			QuickSort_R(a, median, pivot, right);
		}
	}

	private static <T extends Comparable<T>> int Partition(T[] a, boolean median, int left, int right)
	{
		T pivot;

		if (median)
			pivot = a[Median(a, left, right)];
		else
			pivot = a[(left + right) / 2];
		while (left <= right)
		{
			while (a[left].compareTo(pivot) < 0)
				left++;

			while (right >= left && a[right].compareTo(pivot) > 0)
				right--;

			if (left <= right)
			{
				Swap(a, left, right);
				left++;
				right--;
			}
		}

		return left;
	}

	private static <T extends Comparable<T>> int Median(T[] a, int left, int right)
	{
		int mid = (left + right) / 2;

		if (a[left].compareTo(a[right]) > 0)
			Swap(a, left, right);
		if (a[mid].compareTo(a[right]) > 0)
			Swap(a, mid, right);
		if (a[left].compareTo(a[mid]) > 0)
			Swap(a, left, mid);

		return mid;
	}

	private static <T extends Comparable<T>> void Swap(T[] a, int first, int second)
	{
		T tmp = a[first];
		a[first] = a[second];
		a[second] = tmp;
	}
}
