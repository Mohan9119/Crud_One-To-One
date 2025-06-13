package com.example.Crud_One_To_One;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
@CrossOrigin
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<Person> save(@RequestBody Person person)
	{
		return ResponseEntity.ok(personService.save(person));
	}
	
	
	@GetMapping
	public ResponseEntity<Iterable<Person>>list()
	{
		return ResponseEntity.ok(personService.list());
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable Integer id, @RequestBody Person person) {
	    return ResponseEntity.ok(personService.update(id, person));
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Person> read(@PathVariable Integer id)
	{
		return ResponseEntity.ok(personService.read(id));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> delete(@PathVariable Integer id)
	{
		return ResponseEntity.ok(personService.delete(id));
	}
}
