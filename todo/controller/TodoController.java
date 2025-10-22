package todo.controller;

import todo.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.service.TodoService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    private List<TodoEntity> getAllTodos(){
        return todoService.gettAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoEntity> getTodoById(@PathVariable String id){
        Optional<TodoEntity> todo= todoService.getTodoById(id);
        return todo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TodoEntity> createTodo(@RequestBody TodoEntity todoEntity){
        TodoEntity createdTodo= todoService.createTodo(todoEntity);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable String id, @RequestBody TodoEntity todoEntity){
        TodoEntity updateTodo= todoService.updateTodo(id, todoEntity);
        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
