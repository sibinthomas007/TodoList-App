package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Scanner;

import org.json.JSONObject;

import classes.User;
import repositories.UserRepository;
@CrossOrigin(origins="http://localhost:3000")
@Controller    // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
	@Autowired 
	private UserRepository userRepository;

	
	@PostMapping(path="/addUser", consumes="application/json") 
	public @ResponseBody String addNewUser (@RequestBody String jsonString) {

		JSONObject obj = new JSONObject(jsonString);
		String username = obj.getString("username");

		User userobject = userRepository.findByUsername(username);
		System.out.println(userobject);

		if(userobject==null){
			userobject = new User();
			userobject.setUsername(username);
			String password = obj.getString("password");
			userobject.setPassword(password);
			userRepository.save(userobject);
			return "User Added";
		}
		else
			return "User Already Exists";


	}

	@PostMapping(path="/authUser", consumes="application/json")
	public @ResponseBody String deleteTodo(@RequestBody String jsonString){
		JSONObject obj = new JSONObject(jsonString);
		String username = obj.getString("username");
		String password = obj.getString("password");



		User userobject = userRepository.findByUsername(username);
		if(userobject == null)
			return "UserDoesNotExist:";
		else{
			userobject = userRepository.findByUsernameAndPassword(username,password);
			if(userobject == null)
				return "Username or Password Incorrect:";
			else
				return "Authenticated:"+userobject.getId();
		}
	}



	@GetMapping(path="/getTodos")
	public @ResponseBody Iterable<User> getAllTodo() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@PutMapping(path="/updateTodo", consumes="application/json")
	public @ResponseBody String updateTodo(@RequestBody String jsonString){
		
		return "Updated";
	}

	@PutMapping(path="/updateStatus", consumes="application/json")
	public @ResponseBody String updateStatus(@RequestBody String jsonString){
		
		return "Updated Status";
	}

	
}
