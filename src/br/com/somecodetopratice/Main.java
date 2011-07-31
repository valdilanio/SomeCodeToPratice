package br.com.somecodetopratice;

import java.util.ArrayList;
import java.util.List;

import br.com.somecodetopratice.beans.Person;


public class Main {
	
	public static void main(String[] args) {
		JsonFactory json = new JsonFactory();
		List<Person> persons = new ArrayList<Person>();

		Person person = new Person("Valdilanio", "Cruz");
		persons.add(person);
		person = new Person("Blue", "Color");
		persons.add(person);
		json.setExcludeFields(new String[] {"firstName"});
		json.jsonOf(person, "person");
		json.jsonOf(persons,Person.class.getPackage().getName());
		System.out.println(json.getJson());
		
	}

}