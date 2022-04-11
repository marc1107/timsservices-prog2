package aufgabe11.teil2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Person
{
	private String vorname;
	private String nachname;
	private LocalDate geburtsdatum;

	private Person(String v, String n, LocalDate d)
	{
		this.vorname = v;
		this.nachname = n;
		this.geburtsdatum = d;
	}

	public LocalDate getGeburtsdatum()
	{
		return geburtsdatum;
	}

	public void setGeburtsdatum(LocalDate geburtsdatum)
	{
		this.geburtsdatum = geburtsdatum;
	}

	public String getNachname()
	{
		return nachname;
	}

	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}

	public String getVorname()
	{
		return vorname;
	}

	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	@Override
	public String toString()
	{
		return String.format("%s %s ist am %s geboren", this.vorname, this.nachname, this.geburtsdatum);
	}

	public static void main(String[] args)
	{
		List<Person> persList = new LinkedList<>();
		persList.add(new Person("Roland", "Burke", LocalDate.of(2000, 2, 18)));
		persList.add(new Person("Niklas", "Pelz", LocalDate.of(1998, 11, 13)));
		persList.add(new Person("Tim", "Köhler", LocalDate.of(1997, 11, 30)));
		persList.add(new Person("Jannis", "Pelz", LocalDate.of(2003, 3, 18)));
		persList.add(new Person("Christina", "Pelz", LocalDate.of(1969, 2, 4)));
		persList.add(new Person("Andreas", "Pelz", LocalDate.of(1962, 5, 21)));
		persList.add(new Person("Benjamin", "Mannsdörfer", LocalDate.of(1998, 2, 10)));
		persList.add(new Person("Yuanyuan", "Wu", LocalDate.of(1999, 8, 8)));
		persList.add(new Person("Olivia", "Hye", LocalDate.of(2001, 11, 13)));
		persList.add(new Person("Yannick", "May", LocalDate.of(1869, 5, 12)));
		persList.add(new Person("Annika", "Dorf", LocalDate.of(1987, 3, 14)));
		persList.add(new Person("Anton", "Kopf", LocalDate.of(2011, 4, 5)));
		persList.add(new Person("Oliver", "Bittel", LocalDate.of(1963, 10, 26)));
		persList.add(new Person("Alexandra", "Stegmiller", LocalDate.of(1997, 1, 24)));
		persList.add(new Person("Anna", "Marx", LocalDate.of(1998, 6, 21)));
		persList.add(new Person("Adeltraud", "Berger", LocalDate.of(1956, 2, 13)));
		persList.add(new Person("Max", "Finkler", LocalDate.of(1995, 8, 24)));

		Predicate<Person> isAdult = p -> (p.getGeburtsdatum().isBefore(LocalDate.now().minusYears(18)));

		System.out.println(Person.isEveryoneAdult(persList, isAdult));
		System.out.println(persList);
		Person.sortBirthday(persList);
		System.out.println(persList);
		Person.sortBirthdayReversed(persList);
		System.out.println(persList);
		Person.printAdults(persList, isAdult);
		Person.printOldestStartingWithA(persList);
	}

	public static boolean isEveryoneAdult(List<Person> list, Predicate<Person> isVolljaehrig)
	{
		for (Person p : list)
		{
			if (!isVolljaehrig.test(p))
				return false;
		}
		return true;
	}

	public static void sortBirthday(List<Person> list)
	{
		list.sort((Person p1, Person p2) -> p1.getGeburtsdatum().compareTo(p2.getGeburtsdatum()));
	}

	public static void sortBirthdayReversed(List<Person> list)
	{
		list.sort(Comparator.comparing(Person::getGeburtsdatum).reversed());
	}

	public static void printAdults(List<Person> list, Predicate<Person> p)
	{
		list.stream().filter(p).sorted((Person p1, Person p2) -> p1.getGeburtsdatum().compareTo(p2.getGeburtsdatum()))
				.forEach((Person pers) -> System.out.println(pers.getGeburtsdatum()));
	}

	private static void printOldestStartingWithA(List<Person> persList)
	{
		persList.stream().filter((p) -> p.getVorname().startsWith("A"))
				.sorted((p1, p2) -> p1.getGeburtsdatum().compareTo(p2.getGeburtsdatum())).limit(3)
				.forEach((p) -> System.out.println(p.getVorname()));
	}
}
