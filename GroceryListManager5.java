import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class GroceryListManager5 {
    private Map<String, ShoppingList> lists = new HashMap<>();

    public static void main(String[] args) {
        GroceryListManager5 listManager = new GroceryListManager5();

        Scanner scanner = new Scanner(System.in);
        int answer;

        do {
            System.out.println("Settings");
            System.out.println("1. Add shopping list");
            System.out.println("2. Select shopping list");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            answer = scanner.nextInt();

            if (answer == 1) {
                System.out.print("Enter shopping list name: ");
                listManager.addShoppingList(scanner.next());
            } else if (answer == 2) {
                System.out.println("Available shopping lists: ");
                for (String listName : listManager.lists.keySet()) {
                    System.out.println(listName);
                }

                System.out.print("Enter shopping list name: ");
                listManager.selectShoppingList(scanner.next());
            } else if (answer == 3) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice");
            }
        } while (answer != 3);
    }

    public void addShoppingList(String name) {
        this.lists.put(name, new ShoppingList());
    }

    public void selectShoppingList(String name) {
        if (this.lists.containsKey(name)) this.lists.get(name).select();
    }

    class ShoppingList {
        private ArrayList<String> groceryList = new ArrayList<>();
        private Map<String, Double> costs = new HashMap<>();
        private Map<String, String> categories = new HashMap<>();
        private Map<String, Integer> quantities = new HashMap<>();

        public void select() {
            Scanner scanner = new Scanner(System.in);
            int answer;

            do {
                System.out.println("Settings");
                System.out.println("1. Add item");
                System.out.println("2. Remove item");
                System.out.println("3. Display list");
                System.out.println("4. Search item");
                System.out.println("5. Calculate total cost");
                System.out.println("6. Add item with category");
                System.out.println("7. Display by category");
                System.out.println("8. Add item with quantity");
                System.out.println("9. Update quantity");
                System.out.println("10. Display available items");
                System.out.println("11. Exit");
                System.out.print("Enter your choice: ");
                answer = scanner.nextInt();

                if (answer == 1) {
                    System.out.print("Enter item to add: ");
                    String itemName = scanner.next();
                    System.out.print("Enter item price: ");
                    double cost = scanner.nextDouble();
                    this.addItem(itemName, cost);
                } else if (answer == 2) {
                    System.out.print("Enter item to remove: ");
                    this.removeItem(scanner.next());
                } else if (answer == 3) {
                    this.displayList();
                } else if (answer == 4) {
                    System.out.print("Enter item to search: ");
                    System.out.println(this.checkItem(scanner.next()) ? "Item found" : "Item not found");
                } else if (answer == 5) {
                    System.out.printf("Total cost: %.2f\n", this.calculateTotalCost());
                } else if (answer == 6) {
                    System.out.print("Enter item to add: ");
                    String itemName = scanner.next();
                    System.out.print("Enter item category: ");
                    String category = scanner.next();
                    this.addItemWithCategory(itemName, category);
                } else if (answer == 7) {
                    System.out.print("Enter category: ");
                    this.displayByCategory(scanner.next());
                } else if (answer == 8) {
                    System.out.print("Enter item to add: ");
                    String itemName = scanner.next();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    this.addItemWithQuantity(itemName, quantity);
                } else if (answer == 9) {
                    System.out.print("Enter item to update: ");
                    String itemName = scanner.next();
                    System.out.print("Enter new quantity: ");
                    int quantity = scanner.nextInt();
                    this.updateQuantity(itemName, quantity);
                } else if (answer == 10) {
                    this.displayAvailableItems();
                } else if (answer == 11) {
                    System.out.println("Exiting...");
                } else {
                    System.out.println("Invalid choice");
                }
            } while (answer != 11);
        }

        public void addItem(String item, double cost) {
            this.groceryList.add(item);
            this.costs.put(item, cost);
        }

        public void removeItem(String item) {
            for (int i = 0; i < this.groceryList.size(); i++) {
                if (this.groceryList.get(i).equals(item)) {
                    this.groceryList.remove(i);
                    break;
                }
            }
        }

        public void displayList() {
            System.out.println("Grocery List:");
            for (int i = 0; i < this.groceryList.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, this.groceryList.get(i));
            }
            System.out.println();
        }

        public double calculateTotalCost() {
            double sum = 0;
            for (double value : this.costs.values()) {
                sum += value;
            }

            return sum;
        }

        public boolean checkItem(String item) {
            for (int i = 0; i < this.groceryList.size(); i++) {
                if (this.groceryList.get(i).equals(item)) {
                    return true;
                }
            }

            return false;
        }

        public void addItemWithCategory(String item, String category) {
            this.groceryList.add(item);
            this.categories.put(item, category);
        }

        public void displayByCategory(String category) {
            System.out.println("Grocery List:");
            for (int i = 0; i < this.groceryList.size(); i++) {
                String item = this.groceryList.get(i);
                if (this.categories.containsKey(item)) {
                    if (this.categories.get(item).equals(category)) {
                        System.out.printf("%d. %s\n", i + 1, item);
                    }
                }
            }
            System.out.println();
        }

        public void addItemWithQuantity(String item, int quantity) {
            this.groceryList.add(item);
            this.quantities.put(item, quantity);
        }

        public void updateQuantity(String item, int newQuantity) {
            this.quantities.put(item, newQuantity);
        }

        public void displayAvailableItems() {
            System.out.println("Available items:");
            for (int i = 0; i < this.groceryList.size(); i++) {
                String item = this.groceryList.get(i);
                if (this.quantities.containsKey(item)) {
                    int amount = this.quantities.get(item);
                    if (amount > 0) {
                        System.out.printf("%d. %s, amount: %d\n", i + 1, item, amount);
                    }
                }
            }
            System.out.println();
        }
    }
}
