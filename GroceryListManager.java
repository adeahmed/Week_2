import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            if (!groceryList.contains(item)) {
                groceryList.add(item);
                System.out.println(item + " added to the grocery list.");
            } else {
                System.out.println("Item \"" + item + "\" already exists in the grocery list.");
            }
        } else {
            System.out.println("Invalid item. Please provide a non-empty item.");
        }
    }

    public void removeItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            if (groceryList.contains(item)) {
                groceryList.remove(item);
                System.out.println("Removing \"" + item + "\" from the list...");
            } else {
                System.out.println("Item \"" + item + "\" not found in the grocery list.");
            }
        } else {
            System.out.println("Invalid item. Please provide a non-empty item.");
        }
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }
    public boolean checkItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            return groceryList.contains(item);
        }
        return false;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        manager.displayList();

        String itemToCheck = "Milk";
        System.out.println("Is \"" + itemToCheck + "\" in the grocery list? " + manager.checkItem(itemToCheck));

        String itemToRemove = "Milk";
        manager.removeItem(itemToRemove);

        manager.displayList();
    }
}
