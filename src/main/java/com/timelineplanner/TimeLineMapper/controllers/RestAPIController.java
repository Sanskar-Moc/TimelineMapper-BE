package com.timelineplanner.TimeLineMapper.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timelineplanner.TimeLineMapper.model.ExceptionResponse;
import com.timelineplanner.TimeLineMapper.model.TimeLine;
import com.timelineplanner.TimeLineMapper.model.User;
import com.timelineplanner.TimeLineMapper.service.TimeLineServiceInterface;

@RestController
public class RestAPIController {
	
	@Autowired
	private TimeLineServiceInterface service;
	
	
	
	//Below are TimLine APIs
	
	@GetMapping("/findall")
	public ResponseEntity<List<TimeLine>> getAllTimeLine() {
        List<TimeLine> timeline = service.findAll();
        return ResponseEntity.ok(timeline);
    }
	
	@PostMapping("/save")	
    public ResponseEntity<TimeLine> addTimeLine(@RequestBody TimeLine timeline) {
		TimeLine savedtimeline = service.save(timeline);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedtimeline);
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Object> getTimeLineById(@PathVariable int id) {
    	Optional<TimeLine> timelineOptional = service.findById(id);
        if (timelineOptional.isPresent()) {
            return ResponseEntity.ok(timelineOptional.get());
        } else {
            ExceptionResponse errorResponse = new ExceptionResponse
            		("Timeline not found", "TimeLine with ID " + id + " not found",new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<TimeLine> updateTimeLine(@PathVariable int id, @RequestBody TimeLine timeline) {
		timeline.setId(id);
    	TimeLine updatedtimeline = service.save(timeline);
        return ResponseEntity.ok(updatedtimeline);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTimeLine(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
	
	
	//Below are User APIs
	

	@GetMapping("/user/findall")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = service.findAllUsers();
		return ResponseEntity.ok(user);
	}

	@PostMapping("/user/save")	
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User saveduser = service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveduser);
	}

	@GetMapping("/user/find/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable String id) {
		Optional<User> userOptional = service.findUserById(id);
		if (userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.get());
		} else {
			ExceptionResponse errorResponse = new ExceptionResponse
					("User not found", "User with ID " + id + " not found",new Date());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}

	@PutMapping("/user/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
		user.setId(id);
		User updatedUser = service.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
