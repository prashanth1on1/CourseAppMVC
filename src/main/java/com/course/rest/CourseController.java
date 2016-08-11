package com.course.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.app.Course;
import com.course.app.Topic;
import com.course.service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {

 @Autowired
 private CourseService courseService;

 //create new course
 @RequestMapping(method = RequestMethod.POST)
 public ResponseEntity<Course> create(@RequestBody Course course) throws Exception {
  return new ResponseEntity<Course>(courseService.saveCourse(course), HttpStatus.CREATED);
 }

 //update course
 @RequestMapping(method = RequestMethod.PUT)
 public ResponseEntity<Course> update(@RequestBody Course course) throws Exception {
  return new ResponseEntity<Course>(courseService.saveCourse(course), HttpStatus.OK);
 }

 //get course by id
 @RequestMapping(value="{courseid}",method = RequestMethod.GET)
 public ResponseEntity<Course> update(@PathVariable("courseid") Long courseid) throws Exception {
  return new ResponseEntity<Course>(courseService.getCourseById(courseid), HttpStatus.OK);
 }

 //delete course by id
 @RequestMapping(value="{courseid}",method = RequestMethod.DELETE)
 public ResponseEntity<HttpStatus> delete(@PathVariable("courseid") Long courseid) throws Exception {
  courseService.deleteCourse(courseid);
  return new ResponseEntity<HttpStatus>(HttpStatus.OK);
 }
 
 //add User to course
 @RequestMapping(value="{courseid}/users/{userId}",method = RequestMethod.PUT)
 public ResponseEntity<Course> addUserToCourse(@PathVariable("courseid")Long courseid, @PathVariable("userId")String userId) throws Exception {
  return new ResponseEntity<Course>(courseService.addUserToCourse(courseid, userId), HttpStatus.OK);
 }
 
 //remove User from course
 @RequestMapping(value="{courseid}/users/{userId}",method = RequestMethod.DELETE)
 public ResponseEntity<Course> removeUserFromCourse(@PathVariable("courseid")Long courseid, @PathVariable("userId")String userId) throws Exception {
  return new ResponseEntity<Course>(courseService.removeUserFromCourse(courseid, userId), HttpStatus.OK);
 }
 
 //add Topic to a course
 @RequestMapping(value="{courseid}/topic",method = RequestMethod.PUT)
 public ResponseEntity<Course> addTopicToCourse(@PathVariable("courseid")Long courseid, @RequestBody Topic topic) throws Exception {
  
  return new ResponseEntity<Course>(courseService.addTopicToCourse(courseid, topic), HttpStatus.OK);
 }
 
 //remove Topic from a course
 @RequestMapping(value="{courseid}/topic",method = RequestMethod.DELETE)
 public ResponseEntity<Course> removeTopicFromACourse(@PathVariable("courseid")Long courseid, @RequestBody Topic topic) throws Exception {
  
  return new ResponseEntity<Course>(courseService.removeTopicFromCourse(courseid, topic), HttpStatus.OK);
 }



}