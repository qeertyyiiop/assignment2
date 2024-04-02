package classes;

import Interfaces.Catalog;
import Interfaces.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Library implements Catalog {
    private List<Item> catalog;

    public Library() {
        this.catalog = new ArrayList<>();
    }

    @Override
    public void addItem(Item item) {
        catalog.add(item);
        System.out.println("New item added to catalog! Title is: " + item.getTitle());
    }

    @Override
    public void removeItem(Item item) {
        catalog.remove(item);
        System.out.println("Item removed from catalog! Title is: " + item.getTitle());
    }

    @Override
    public List<Item> getAllItems() {
        return Collections.unmodifiableList(catalog);
    }
}
