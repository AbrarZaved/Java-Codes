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

class ReceiptItem {
    private Item item;
    private int quantity;

    public ReceiptItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Receipt {
    private List<ReceiptItem> items;
    private double totalAmount;

    public Receipt() {
        items = new ArrayList<>();
        totalAmount = 0.0;
    }

    public void addItem(Item item, int quantity) {
        items.add(new ReceiptItem(item, quantity));
        totalAmount += item.getPrice() * quantity;
    }

    public void generateReceipt() {
        System.out.println("-------- Receipt --------");
        for (ReceiptItem receiptItem : items) {
            Item item = receiptItem.getItem();
            int quantity = receiptItem.getQuantity();
            System.out.printf("%s - %.2f taka x %d\n", item.getName(), item.getPrice(), quantity);
        }
        System.out.println("-------------------------");
        System.out.printf("Total Amount: %.2f taka\n", totalAmount);
        System.out.println("-------------------------");
    }
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        // Item List
        Item item1 = new Item("Apple", 380, "Fruits");
        Item item2 = new Item("Banana", 40, "Fruits");
        Item item3 = new Item("Orange", 300, "Fruits");
        Item item4 = new Item("Mango", 100, "Fruits");
        Item item5 = new Item("Grapes", 400, "Fruits");
        Item item6 = new Item("Bread", 25, "Bakery");
        Item item7 = new Item("Milk", 80, "Dairy");
        Item item8 = new Item("Cheese", 100, "Dairy");
        Item item9 = new Item("Beef", 850, "Protein");
        Item item10 = new Item("Mutton", 1100, "Protein");
        Item item11 = new Item("Fish", 500, "Protein");
        Item item12 = new Item("Egg", 13, "Protein");
        Item item13 = new Item("Cauli Flower", 30, "Vegetable");
        Item item14 = new Item("Carrot", 45, "Vegetable");
        Item item15 = new Item("Spinach", 20, "Vegetable");
        Item item16 = new Item("Brocoli", 57, "Vegetable");
        Item item17 = new Item("Potato", 26, "Vegetable");
        Item item18 = new Item("Tomato", 120, "Vegetable");
        Item item19 = new Item("Onion", 100, "Vegetable");
        Item item20 = new Item("Cucumber", 80, "Vegetable");
        Item item21 = new Item("Cake", 550, "Bakery");
        Item item22 = new Item("Biscuit", 100, "Bakery");
        Item item23 = new Item("Sweet", 250, "Bakery");
        Item item24 = new Item("Coca Cola", 40, "Soft Drinks");
        Item item25 = new Item("Pepsi", 30, "Soft Drinks");
        Item item26 = new Item("Mountain Dew", 15, "Soft Drinks");
        Item item27 = new Item("Sprite",55 , "Soft Drinks");
        Item item28 = new Item("Chanachur", 10, "Snacks");
        Item item29 = new Item("Chips", 15, "Snacks");
        Item item30 = new Item("Paties", 25, "Snacks");
        Item item31 = new Item("Chocolate", 70, "Dairy");

        // Add more items and categories as needed

        Map<String, List<Item>> categoryMap = new HashMap<>();
        categoryMap.put("Fruits", Arrays.asList(item1, item2, item3, item4, item5));
        categoryMap.put("Bakery", Arrays.asList(item6,item21,item22,item23));
        categoryMap.put("Dairy", Arrays.asList(item7, item8,item31));
        categoryMap.put("Snacks", Arrays.asList(item28, item29,item30));
        categoryMap.put("Protein", Arrays.asList(item9, item10,item11,item12));
        categoryMap.put("Vegetables", Arrays.asList(item13, item14,item15,item16,item17,item18,item19,item20));
        categoryMap.put("Soft Drinks", Arrays.asList(item24, item25,item26,item27));
        // Add more categories and items to the categoryMap as needed

        // User Input
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();
        System.out.println("Welcome to AbShJa Supershop");
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
                    System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice()+" taka");
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
