package com.course.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.app.Course;
import com.course.app.User;
import com.course.service.UserService;



@RestController
@RequestMapping("user")
public class UserController {

 @Autowired
 private UserService userService;

 //create the  user
 @RequestMapping(method = RequestMethod.POST)
 public ResponseEntity<User> create(@Valid @RequestBody User user) throws Exception {
  return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
 }
 

 //update user
 @RequestMapping(method = RequestMethod.PUT)
 public ResponseEntity<User> update(@Valid @RequestBody User user) throws Exception {
  return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
 }
 
 //delete user
  @RequestMapping(value = "{user_name}", method = RequestMethod.DELETE)
  public ResponseEntity<HttpStatus> delete(@PathVariable("user_name") String user_name) throws Exception {
   if (!user_name.contains(".com")) {
    user_name += ".com";
   }

   userService.delete(user_name);
   return new ResponseEntity<HttpStatus>(HttpStatus.OK);
  }
  //get user by user_name 
  @RequestMapping(value = "{user_name}", method = RequestMethod.GET)
  public ResponseEntity<User> getByuser_name(@PathVariable("user_name") String user_name) throws Exception {
   if (!user_name.contains(".com")) {
    user_name += ".com";
   }

   return new ResponseEntity<User>(userService.findUserByName(user_name), HttpStatus.OK);
  }

  //get all courses for a user
  @RequestMapping(value = "/courses/{user_name}", method = RequestMethod.GET)
  public ResponseEntity<List<Course>> getAllCoursesForaUser(@PathVariable("user_name") String user_name)throws Exception {
   if (!user_name.contains(".com")) {
    user_name += ".com";
   }
   return new ResponseEntity<List<Course>>(userService.findUserByName(user_name).getCourses(), HttpStatus.OK);
  }

 }