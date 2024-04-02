package Interfaces;

import java.util.List;

public interface Catalog {
    void addItem(Item item);
    void removeItem(Item item);
    List<Item> getAllItems();
}
