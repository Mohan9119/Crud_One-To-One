package com.example.Crud_One_To_One;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person save(Person person)
	{
		return personRepository.save(person);
	}
	
	public Iterable<Person>list()
	{
		return personRepository.findAll();
	}
	
	public Person read(Integer id)
	{
		return personRepository.findById(id).get();
	}
	
	public Integer delete(Integer id)
	{
		personRepository.deleteById(id);
		return id;
	}
	
	public Person update(Integer id, Person updatedPerson) {
	    Person existingPerson = personRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
	    
	   
	    existingPerson.setFirstName(updatedPerson.getFirstName());
	    existingPerson.setLastName(updatedPerson.getLastName());	    
	    existingPerson.setAge(updatedPerson.getAge());
	   
	    return personRepository.save(existingPerson);
	}


}
