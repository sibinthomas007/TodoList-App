package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;



import org.json.JSONObject;

import classes.Todo;
import repositories.TodoRepository;



@CrossOrigin(origins="http://localhost:3000")
@RestController    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class TodoController {
	@Autowired 
	private TodoRepository todoRepository;



	@PostMapping(path="/addTodo", consumes="application/json") 
	public @ResponseBody ResponseEntity<String> addNewTodo (@RequestBody Todo obj) {

		Todo n = new Todo();
		n.setTitle(obj.getTitle());
		n.setCompleted(obj.getCompleted());
		n.setUid(obj.getUid());
		todoRepository.save(n);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("value","value");

		return new ResponseEntity<String>("je",new HttpHeaders(),HttpStatus.CREATED);

	}

	@DeleteMapping(path="/deleteTodo", consumes="application/json")
	public @ResponseBody String deleteTodo(@RequestBody Todo obj){
		Integer id = obj.getId();
		Todo todoobject = todoRepository.findById(id).get();
		todoRepository.delete(todoobject);
		return "Deleted";
	}

	@GetMapping(path="/getTodos")
	public @ResponseBody Iterable<Todo> getAllTodo(@RequestParam(value="uid") Integer uid) {
		// This returns a JSON or XML with the users
		return todoRepository.findByUid(uid);
	}


	@PutMapping(path="/updateStatus", consumes="application/json")
	public @ResponseBody String updateStatus(@RequestBody Todo obj){
		Integer id = obj.getId();
		Boolean comp = obj.getCompleted();
		Todo todoobject = todoRepository.findById(id).get();
		todoobject.setCompleted(!comp);
		todoRepository.save(todoobject);
		return "Updated Status";
	}

	
}
