import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryListManager4 {
    private Map<String, Double> groceryList = new HashMap<>();
    private Map<String, Integer> quantityMap = new HashMap<>();
    private Map<String, List<String>> categoryMap = new HashMap<>();

    // Add item and its cost to the grocery list
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

    // Add item with a category
    public void addItemWithCategory(String item, String category) {
        if (item != null && !item.trim().isEmpty() && category != null && !category.trim().isEmpty()) {
            if (!groceryList.containsKey(item)) {
                groceryList.put(item, 0.0);
                categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(item);
                System.out.println(item + " added to the grocery list under category \"" + category + "\".");
            } else {
                System.out.println("Item \"" + item + "\" already exists in the grocery list.");
            }
        } else {
            System.out.println("Invalid item or category. Please provide non-empty values for both.");
        }
    }

    // Add item with quantity
    public void addItemWithQuantity(String item, int quantity) {
        if (item != null && !item.trim().isEmpty() && quantity > 0) {
            quantityMap.put(item, quantity);
            System.out.println(item + " added to the grocery list with a quantity of " + quantity);
        } else {
            System.out.println("Invalid item or quantity. Please provide a non-empty item and a positive quantity.");
        }
    }

    // Update quantity of an item
    public void updateQuantity(String item, int newQuantity) {
        if (item != null && !item.trim().isEmpty() && newQuantity > 0) {
            if (quantityMap.containsKey(item)) {
                quantityMap.put(item, newQuantity);
                System.out.println("Quantity of \"" + item + "\" updated to " + newQuantity);
            } else {
                System.out.println("Item \"" + item + "\" not found in the grocery list.");
            }
        } else {
            System.out.println("Invalid item or quantity. Please provide a non-empty item and a positive quantity.");
        }
    }

    // Display available items with positive quantity
    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (Map.Entry<String, Integer> entry : quantityMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": Quantity " + entry.getValue());
            }
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

    // Display items by category
    public void displayByCategory(String category) {
        if (category != null && !category.trim().isEmpty()) {
            if (categoryMap.containsKey(category)) {
                System.out.println("Items in category \"" + category + "\":");
                List<String> itemsInCategory = categoryMap.get(category);
                for (String item : itemsInCategory) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Category \"" + category + "\" not found.");
            }
        } else {
            System.out.println("Invalid category. Please provide a non-empty category.");
        }
    }

    public static void main(String[] args) {
        GroceryListManager4 manager = new GroceryListManager4();

        manager.addItemWithCategory("Apples", "Fruits");
        manager.addItemWithCategory("Milk", "Dairy");
        manager.addItemWithCategory("Bread", "Bakery");

        manager.addItemWithQuantity("Apples", 10);
        manager.addItemWithQuantity("Milk", 5);
        manager.addItemWithQuantity("Bread", 3);

        manager.displayList();

        String categoryToDisplay = "Dairy";
        manager.displayByCategory(categoryToDisplay);

        String itemToCheck = "Milk";
        System.out.println("Is \"" + itemToCheck + "\" in the grocery list? " + manager.checkItem(itemToCheck));

        String itemToUpdate = "Apples";
        manager.updateQuantity(itemToUpdate, 15);

        manager.displayAvailableItems();
    }
}
