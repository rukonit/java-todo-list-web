package com.rukon.controller;

import com.rukon.businessl.TodoItemsService;
import com.rukon.model.TodoData;
import com.rukon.model.TodoItem;
import com.rukon.util.AttributeNames;
import com.rukon.util.Mappings;
import com.rukon.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {


    private final TodoItemsService todoItemService;
    // == model attribute section =

    @Autowired
    public TodoItemController(TodoItemsService todoData) {
        this.todoItemService = todoData;
    }

    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/TodoList/items

    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model){
        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);

        if(todoItem==null){
            todoItem = new TodoItem("abc", "", LocalDate.now());
        }

      model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM)  TodoItem todoItem){
      log.info("todoItem from form = {}", todoItem);
      if(todoItem.getId()==0){
          todoItemService.addItem(todoItem);
      }
      else {
          todoItemService.updateItem(todoItem);
      }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        model.addAttribute(AttributeNames.TODO_ITEM, todoItemService.getItem(id));
        return ViewNames.VIEW_ITEM;
    }
}
