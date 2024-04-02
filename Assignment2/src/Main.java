import Interfaces.Catalog;
import Interfaces.Item;
import Interfaces.User;
import classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Library();
        Service librarianService = new Service(catalog);
        Scanner scan = new Scanner(System.in);

        boolean session = true;
        while(session){
            System.out.println("Choose one of this: ");
            System.out.println("1. Login");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter username: ");
                    String username = scan.nextLine();
                    User user = authenfication(username);
                    if(user != null){
                        librarianService.setCurrUser(user);
                        System.out.println("Welcome to the library, " + username);

                        if(user.isLibrarian()){
                            System.out.println("You are signed in as a librarian!");
                        }else{
                            System.out.println("You are signed in as a user!");
                        }
                    }else{
                        System.out.println("Wrong username! Please try again!");
                    }
                    break;

                case 2:
                    System.out.println("Enter username:");
                    String newUsername = scan.nextLine();
                    System.out.println("Choose user type (0 for librarian, 1 for simple user):");

                    int userType = scan.nextInt();
                    scan.nextLine();

                    if (userType == 0) {
                        librarianService.setCurrUser(new Librarian(newUsername));
                        System.out.println("Librarian account created!");
                    } else if (userType == 1) {
                        librarianService.setCurrUser(new simpleUser(newUsername));
                        System.out.println("Simple user account created!");
                    } else {
                        System.out.println("Invalid user type.");
                    }
                    break;

                case 3:
                    session = false;
                    System.out.println("You are exit");
                    System.exit(0);
                default:
                    System.out.println("Wrong choice! Please try again!");
            }
            while (librarianService.isLogged()) {
                System.out.println("Choose an option:");
                System.out.println("1. View catalog");
                System.out.println("2. Logout");

                if (librarianService.getCurrUser().isLibrarian()) {
                    System.out.println("3. Add item to catalog");
                    System.out.println("4. Remove item from catalog");
                }

                int selection = scan.nextInt();
                scan.nextLine();

                switch (selection) {
                    case 1:
                        librarianService.getAllItems();
                        break;
                    case 2:
                        librarianService.setCurrUser(null);
                        break;
                    case 3:
                        if (librarianService.getCurrUser().isLibrarian()) {
                            System.out.println("Enter item type (book/magazine/cd):");
                            String itemType = scan.nextLine().toLowerCase();
                            Item newItem = createItem(itemType, scan);
                            if (newItem != null) {
                                librarianService.addItem(newItem);
                            }
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;
                    case 4:
                        if (librarianService.getCurrUser().isLibrarian()) {
                            System.out.println("Enter the title of the item to remove:");
                            String title = scan.nextLine();
                            removeItemByTitle(title, catalog, librarianService);
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        scan.close();
    }

    private static User authenfication(String username) {
        List<User> users = new ArrayList<>();
        users.add(new Librarian("librarian"));
        users.add(new simpleUser("user"));

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    private static Item createItem(String itemType, Scanner scanner) {
        switch (itemType) {
            case "book":
                System.out.println("Enter book title:");
                String bookTitle = scanner.nextLine();
                System.out.println("Enter book author:");
                String bookAuthor = scanner.nextLine();
                return new Book(bookTitle, bookAuthor);
            case "magazine":
                System.out.println("Enter magazine title:");
                String magazineTitle = scanner.nextLine();
                System.out.println("Enter magazine issue number:");
                int magazineIssueNumber = scanner.nextInt();
                scanner.nextLine();
                return new Magazine(magazineTitle, magazineIssueNumber);
            case "cd":
                System.out.println("Enter CD title:");
                String cdTitle = scanner.nextLine();
                System.out.println("Enter CD artist:");
                String cdArtist = scanner.nextLine();
                return new CD(cdTitle, cdArtist);
            default:
                System.out.println("Invalid item type.");
                return null;
        }
    }
    private static void removeItemByTitle(String title, Catalog catalog, Service librarianService) {
        if (!librarianService.getCurrUser().isLibrarian()) {
            System.out.println("You don't have permission to remove items from the catalog.");
            return;
        }

        List<Item> items = catalog.getAllItems();
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                librarianService.removeItem(item);
                return;
            }
        }
        System.out.println("Item not found in catalog: " + title);
    }
}
