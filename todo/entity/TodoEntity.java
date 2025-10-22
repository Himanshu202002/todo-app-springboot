package todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")
public class TodoEntity {
    @Id
    private String id;
    private String task;
    private boolean completed;

    //Constructor, getters, setters
//    public TodoEntity(){}
//
//    public TodoEntity(String task, boolean completed) {
//        this.task = task;
//        this.completed = completed;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTask() {
//        return task;
//    }
//
//    public void setTask(String task) {
//        this.task = task;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
//
  //   public void setCompleted(boolean completed) {
    //    this.completed = completed;
 //   }
}
