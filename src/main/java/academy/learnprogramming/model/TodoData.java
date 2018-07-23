package academy.learnprogramming.model;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Component
public class TodoData {
    //==fields==
    private static int idValue=1;
    private final List<TodoItem> items= new ArrayList<>();
    //==constructor==
    public TodoData(){
        //Add some dummy data using addItem method to set id fields
        addItem(new TodoItem("first","first details",LocalDate.now()));
        addItem(new TodoItem("second","second details",LocalDate.now()));
        addItem(new TodoItem("third","third details",LocalDate.now()));
        addItem(new TodoItem("Fourth","Fourth description", LocalDate.now()));
    }
    //==puublic methods==
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }
    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }
    public void removeItem(int id){
        ListIterator<TodoItem> itemIterator= items.listIterator();
        while(itemIterator.hasNext()){
            TodoItem item = itemIterator.next();
            if(item.getId()==id){
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for(TodoItem item: items){
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){

        ListIterator<TodoItem> itemListIterator= items.listIterator();

        while(itemListIterator.hasNext()){
            TodoItem item= itemListIterator.next();
            if(item.getId()==toUpdate.getId()){
                itemListIterator.set(toUpdate);
                break;
            }

        }
    }
}
