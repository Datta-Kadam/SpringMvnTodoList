package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
public class TodoItemController {

    //==fields===
    private final TodoData todoDataService;
    //==constructor==
    @Autowired
    public TodoItemController(TodoData todoDataService) {
        this.todoDataService = todoDataService;
    }

    //==model attribute section==
    //Model attributes can be method invoking as below or it can be a list or other objects
   @ModelAttribute
   public TodoData todoData(){
      return this.todoDataService;
   }

    //==handler method==
    //http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(Model model){
        model.addAttribute("itemList",todoDataService.getItems());
        log.info("***********List items default***********", todoDataService,todoDataService.getItems());
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model){
        TodoItem todoItem;
        if(id == -1){
            todoItem = new TodoItem("","",LocalDate.now());

        } else{
            todoItem = todoDataService.getItem(id);
        }

        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        //check if id of the todoItem passsed using model Attribute "todoItem" is present
        //if present update the existing item
        boolean valuePresent=false;
           for(TodoItem item : todoDataService.getItems()){
               if(item.equals(todoItem)){
                   valuePresent=true;
                   System.out.println("value is present"+ item);
                   break;
               }
           }
        //if not present add new item to the items list
            if(!valuePresent) {
                todoDataService.addItem(todoItem);
            } else {
                todoDataService.updateItem(todoItem);
            }

        log.info("todoitem from Form = {}",todoItem);
       // todoDataService.addItem(todoItem);
        return "redirect:/"+Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoDataService.getItem(id);
        log.info("Viewing the solo item ={} ",todoItem);
        model.addAttribute("todoItem",todoItem);
        return ViewNames.VIEW_ITEM;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
     log.info("Logging from deleteItem {} =",id);
     todoDataService.removeItem(id);
     return "redirect:/"+Mappings.ITEMS;
    }

}
