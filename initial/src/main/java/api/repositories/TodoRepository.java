package repositories;

import org.springframework.data.repository.CrudRepository;

import classes.Todo;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TodoRepository extends CrudRepository<Todo, Integer> {
	Iterable<Todo> findByUid(int uid);
}
