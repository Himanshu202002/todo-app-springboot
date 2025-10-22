package todo.service;

import todo.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.repository.TodoRepo;


import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    @Autowired
    public TodoService(TodoRepo todoRepo) {

        this.todoRepo = todoRepo;
    }

    public List<TodoEntity> gettAllTodos(){
        return todoRepo.findAll();
    }

    public Optional<TodoEntity> getTodoById(String id){
        return todoRepo.findById(id);
    }

    public TodoEntity createTodo(TodoEntity todoEntity){
        return todoRepo.save(todoEntity);
    }

    public TodoEntity updateTodo(String id, TodoEntity todoEntity){
        todoEntity.setId(id);
        return todoRepo.save(todoEntity);
    }

    public void deleteById(String id){
        todoRepo.deleteById(id);
    }


}
