import java.util.*;

class Item {
    private String name;
    private double price;
    private String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

class Receipt {
    private List<Item> items;
    private double totalAmount;

    public Receipt() {
        items = new ArrayList<>();
        totalAmount = 0.0;
    }

    public void addItem(Item item, int quantity) {
        items.add(item);
        totalAmount += item.getPrice() * quantity;
    }

    public void generateReceipt() {
        System.out.println("-------- Receipt --------");
        for (Item item : items) {
            System.out.printf("%s - $%.2f\n", item.getName(), item.getPrice());
        }
        System.out.println("-------------------------");
        System.out.printf("Total Amount: $%.2f\n", totalAmount);
        System.out.println("-------------------------");
    }
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        // Item List
        Item item1 = new Item("Apple", 0.50, "Fruits");
        Item item2 = new Item("Banana", 0.40, "Fruits");
        Item item3 = new Item("Orange", 0.60, "Fruits");
        Item item4 = new Item("Mango", 1.20, "Fruits");
        Item item5 = new Item("Grapes", 0.80, "Fruits");
        Item item6 = new Item("Bread", 1.00, "Bakery");
        Item item7 = new Item("Milk", 2.50, "Dairy");
        Item item8 = new Item("Cheese", 3.50, "Dairy");
        // Add more items and categories as needed

        Map<String, List<Item>> categoryMap = new HashMap<>();
        categoryMap.put("Fruits", Arrays.asList(item1, item2, item3, item4, item5));
        categoryMap.put("Bakery", Collections.singletonList(item6));
        categoryMap.put("Dairy", Arrays.asList(item7, item8));
        // Add more categories and items to the categoryMap as needed

        // User Input
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

        while (true) {
            System.out.println("--------- Category List ---------");
            for (String category : categoryMap.keySet()) {
                System.out.println(category);
            }
            System.out.println("0. Generate Receipt");

            System.out.print("Enter category number (0 to generate receipt): ");
            String categoryChoice = scanner.nextLine();

            if (categoryChoice.equals("0")) {
                break;
            }

            if (!categoryMap.containsKey(categoryChoice)) {
                System.out.println("Invalid category choice. Please try again.");
                continue;
            }

            List<Item> itemList = categoryMap.get(categoryChoice);

            while (true) {
                System.out.println("--------- Item List ---------");
                for (int i = 0; i < itemList.size(); i++) {
                    Item item = itemList.get(i);
                    System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
                }
                System.out.println("0. Back");

                System.out.print("Enter item number (0 to go back): ");
                String itemChoice = scanner.nextLine();

                if (itemChoice.equals("0")) {
                    break;
                }

                int itemNumber = Integer.parseInt(itemChoice);
                if (itemNumber < 1 || itemNumber > itemList.size()) {
                    System.out.println("Invalid item choice. Please try again.");
                    continue;
                }

                Item selectedItem = itemList.get(itemNumber - 1);

                System.out.print("Enter quantity for item " + itemNumber + ": ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                receipt.addItem(selectedItem, quantity);
            }
        }

        receipt.generateReceipt();

        // Ask if the user wants to exit or continue buying more items
        System.out.print("Do you want to exit (Y/N)? ");
        String exitChoice = scanner.nextLine();

        if (exitChoice.equalsIgnoreCase("Y")) {
            System.out.println("Thank you for shopping with us. Goodbye!");
        } else {
            // Clear the receipt for the next round of shopping
            receipt = new Receipt();
            main(args); // Restart the program for buying more items
        }
    }
}
