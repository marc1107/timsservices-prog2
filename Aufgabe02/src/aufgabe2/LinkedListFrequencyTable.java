package aufgabe2;

public class LinkedListFrequencyTable extends AbstractFrequencyTable
{
	private Node head;
	private Node tail;
	private int size;

	public LinkedListFrequencyTable()
	{
		clear();
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public void clear()
	{
		this.head = new Node(new Word("", 0), null, null);
		this.tail = new Node(new Word("", 0), this.head, null);
		this.head.next = this.tail;
		this.size = 0;
	}

	@Override
	public void add(String w, int f)
	{
		Node n = this.head.next;
		while (n != this.tail)
		{
			if (n.word.getWord().equals(w))
			{
				n.word.addFrequency(f);
				Sort(n);
				return;
			}
			n = n.next;
		}

		// Select last valid Node
		n = n.prev;

		Node newNode = new Node(new Word(w, f), n, this.tail);
		n.next = newNode;
		this.tail.prev = newNode;

		Sort(newNode);

		this.size++;
	}

	private void Sort(Node n)
	{
		if (n.prev == head)
			return;

		while (n.prev != this.head && n.prev.word.getFrequency() < n.word.getFrequency())
		{
			if (n.next != null)
			{
				// Aushaengen
				n.prev.next = n.next;
				n.next.prev = n.prev;
			}
			else
			{
				// Aushaengen
				n.prev.next = null;
			}

			// Einhaengen
			Node nPre = n.prev;

			n.prev = nPre.prev;
			n.next = nPre;

			nPre.prev.next = n;
			nPre.prev = n;
		}
	}

	@Override
	public void add(String w)
	{
		this.add(w, 1);
	}

	@Override
	public Word get(int pos)
	{
		if (pos < 0 || pos > this.size)
			throw new IndexOutOfBoundsException();

		Node current = this.head.next;
		for (int i = 0; i < pos; i++)
		{
			current = current.next;
		}
		return current.word;
	}

	@Override
	public int get(String w)
	{
		Node current = this.head.next;

		while (!current.word.getWord().equals(w))
		{
			current = current.next;

			if (current == this.tail)
				return 0;

		}
		return current.word.getFrequency();
	}

	static class Node
	{
		Word word;
		Node prev;
		Node next;

		public Node(Word word, Node prev, Node next)
		{
			this.word = word;
			this.prev = prev;
			this.next = next;
		}
	}
}
