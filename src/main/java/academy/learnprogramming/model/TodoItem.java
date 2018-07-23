package academy.learnprogramming.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

    //==fields==
    public int id;
    public String title;
    public String details;
    public LocalDate deadline;

    //==Constructor ==
    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

}
