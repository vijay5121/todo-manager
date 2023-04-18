package com.practice.todo.controllers;
import com.practice.todo.models.Todo;
import com.practice.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class Todocontroller{
    Logger logger = LoggerFactory.getLogger(Todocontroller.class);
    @Autowired
        private TodoService todoService;

    Random random =new Random();


    //create
    @PostMapping
    public ResponseEntity<Todo> CreateToHandler(@RequestBody Todo todo){
        //create todo
        int id=random.nextInt(99999);
        todo.setId(id);
        Date currentdate =new Date();
        logger.info("curent date: {}",currentdate);
        todo.setAddeddate(currentdate);
        logger.info("create Todo");
        //service call

        Todo todo1=todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);

    }

    //get all todos

    @GetMapping


    public ResponseEntity<List<Todo>> getalltodoHandler(){
        List<Todo> alltodos=todoService.getalltodos();
        return new ResponseEntity<>(alltodos,HttpStatus.OK);
    }
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getsingleTodoHandler(@PathVariable int todoId){

        Todo todo =todoService.gettodo(todoId);
        return ResponseEntity.ok(todo);
    }


    //update todo
    @PutMapping("/{todoId}")
    public  ResponseEntity<Todo> updatetodohandler(@RequestBody Todo todowithnewdetails,@PathVariable int todoId){

        Todo todo=todoService.updatetodo(todoId,todowithnewdetails);
        return ResponseEntity.ok(todo);
        }

        //delete the todo
    @DeleteMapping("/{todoId}")
     public ResponseEntity<String> deletetodo(@PathVariable int todoId){
        todoService.deletetodo(todoId);
    return ResponseEntity.ok("todo deleted successfully");
    }
}
