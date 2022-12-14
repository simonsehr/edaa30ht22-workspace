package set;

import java.util.HashSet;
import java.util.Set;

// Provkör även detta exempel då metoden hashCode är bortkommenterad i klassen Person.

public class PersonSetExample {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		set.add(new Person("Fili", 1)); 
		set.add(new Person("Balin", 2));
		set.add(new Person("Kili", 3));
		set.add(new Person("Dori", 4));
		
		// Finns person med idnummer 2 i mängden?
		Person searchedPerson = new Person(null, 2);
		System.out.println(set.contains(searchedPerson));
		System.out.println();
		
		for (Person p : set) {
			System.out.println(p.hashCode());
		}
		System.out.println(searchedPerson.hashCode());
	}
}
