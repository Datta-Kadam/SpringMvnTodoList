package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{
    //==fields==
    private final TodoData todoData;

    //==constructor==
    public TodoItemServiceImpl(TodoData todoData) {
        this.todoData = todoData;
    }

    @Override
    public void addItem(TodoItem toAdd) {
        todoData.addItem(toAdd);
    }

    @Override
    public void removeItem(int toRemove) {
        todoData.removeItem(toRemove);
    }

    @Override
    public TodoItem getItem(int id) {
        return todoData.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        todoData.updateItem(todoItem);
    }

    @Override
    public TodoData getData() {
        return todoData;
    }
}
