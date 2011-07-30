package br.com.somecodetopratice;

import java.util.ArrayList;
import java.util.List;

import br.com.somecodetopratice.beans.Person;


public class Main {
	
	public static void main(String[] args) {
		JsonFactory cj = new JsonFactory();
		List<Person> persons = new ArrayList<Person>();

		Person person = new Person("Valdilanio", "Cruz");
		persons.add(person);
		person = new Person("Blue", "Cruz");
		persons.add(person);
		
		cj.jsonOf(persons,Person.class.getPackage().getName());
		System.out.println(cj.getJson());
		
	}

}