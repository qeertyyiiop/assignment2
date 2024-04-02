import Interfaces.Catalog;
import Interfaces.Item;
import Interfaces.User;

import java.util.List;

public class Service {
    private Catalog catalog;
    private User currUser;

    public Service(Catalog catalog) {
        this.catalog = catalog;
        this.currUser = null;
    }

    public void setCurrUser(User currUser) {
        this.currUser = currUser;
    }


    public boolean isLogged(){
        return currUser!=null;
    }
    public boolean isLibrarian(){
        return isLogged() && currUser.isLibrarian();
    }
    public User getCurrUser() {
        return currUser;
    }
    public void addItem(Item item){
        if(!isLogged()){
            System.out.println("Please login to add item!");
            return;
        }
        if(!isLibrarian()){
            System.out.println("Only librarian can add item!");
            return;
        }

        catalog.addItem(item);
    }
    public void removeItem(Item item){
        if(!isLogged()){
            System.out.println("Please login to remove item!");
            return;
        }
        if(!isLibrarian()){
            System.out.println("Only librarian can remove item!");
            return;
        }

        catalog.removeItem(item);
    }
    public void getAllItems(){
        if(!isLogged()){
            System.out.println("Please login to view the catalog!");
            return;
        }

        List<Item> items = catalog.getAllItems();
        System.out.println("Catalog:");
        int i = 0;
        for(Item item : items){
            i++;
            System.out.println(i + ") " + item.getTitle());
        }
    }

}
