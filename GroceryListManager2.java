import java.util.HashMap;
import java.util.Map;

public class GroceryListManager2 {
    private Map<String, Double> groceryList = new HashMap<>();
    public void addItem(String item, double cost) {
        if (item != null && !item.trim().isEmpty() && cost >= 0) {
            if (!groceryList.containsKey(item)) {
                groceryList.put(item, cost);
                System.out.println(item + " added to the grocery list with a cost of $" + cost);
            } else {
                System.out.println("Item \"" + item + "\" already exists in the grocery list.");
            }
        } else {
            System.out.println("Invalid item or cost. Please provide a non-empty item and a non-negative cost.");
        }
    }

    // Remove item from the grocery list
    public void removeItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            if (groceryList.containsKey(item)) {
                groceryList.remove(item);
                System.out.println("Removing \"" + item + "\" from the list...");
            } else {
                System.out.println("Item \"" + item + "\" not found in the grocery list.");
            }
        } else {
            System.out.println("Invalid item. Please provide a non-empty item.");
        }
    }

    // Display the grocery list with item costs
    public void displayList() {
        System.out.println("Grocery List:");
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Check if an item is in the grocery list
    public boolean checkItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            return groceryList.containsKey(item);
        }
        return false;
    }

    // Calculate and return the total cost of all items
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Double cost : groceryList.values()) {
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager2 manager = new GroceryListManager2();

        manager.addItem("Apples", 2.99);
        manager.addItem("Milk", 1.99);
        manager.addItem("Bread", 2.49);

        manager.displayList();

        String itemToCheck = "Milk";
        System.out.println("Is \"" + itemToCheck + "\" in the grocery list? " + manager.checkItem(itemToCheck));

        String itemToRemove = "Milk";
        manager.removeItem(itemToRemove);

        manager.displayList();

        double totalCost = manager.calculateTotalCost();
        System.out.println("Total cost of all items: $" + totalCost);
    }
}
