package com.rukon.businessl;

import com.rukon.model.TodoData;
import com.rukon.model.TodoItem;

public interface TodoItemsService {
void addItem(TodoItem todoItem);
void removeItem(int id);
TodoItem getItem(int id);
void updateItem(TodoItem toUpdate);
TodoData getData();
}
