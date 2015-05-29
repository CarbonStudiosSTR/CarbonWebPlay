package com.carbonstr.spring.dao;

import com.carbonstr.spring.model.Person;

import java.util.List;

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);

}
