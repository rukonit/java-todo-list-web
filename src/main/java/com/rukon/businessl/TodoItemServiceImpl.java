package com.rukon.businessl;

import com.rukon.model.TodoData;
import com.rukon.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemsService {

    // == fields ==
    @Getter
    private final TodoData todoData = new TodoData();

    @Override
    public void addItem(TodoItem todoItem) {
        todoData.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        todoData.removeitem(id);
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
        return this.todoData;
    }
}
