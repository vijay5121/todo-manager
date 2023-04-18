package com.practice.todo.service;

import com.practice.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);
    //create todo method
    List<Todo> todos =new ArrayList<>();
    public Todo createTodo(Todo todo){
        // create..

        todos.add(todo);
        logger.info("Todos{}",this.todos);
        return todo;
    }

    public List<Todo> getalltodos() {
        return todos;
    }
    public Todo gettodo(int todoId){
        Todo todo = todos.stream().filter(t -> todoId==t.getId()).findAny().get();
        logger.info("TODO : {} ",todo);
        return todo;
    }
   public Todo updatetodo(int todoId,Todo todo){
       List<Todo> newupdatelist= todos.stream().map(t->{
            if(t.getId()==todoId) {
                //performupdate
                t.setTitle(todo.getTitle());
                t.setContent(todo.getContent());
                t.setStatus(todo.getStatus());
                return t;
            }
            else {
                return t;
                  }
        }).collect(Collectors.toList());

       todos =newupdatelist;
       todo.setId(todoId);
       return todo;

   }

   public  void deletetodo(int todoId){
        logger.info("DELETING TODO");
        List<Todo> newlist=todos.stream().filter(t->t.getId()!=todoId).collect(Collectors.toList());
        todos=newlist;
   }
   }

