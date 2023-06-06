import java.util.*;

// Room class represents individual rooms in the game
class Room {
    private String name;
    private String description;
    private HashMap<String, Room> connections;
    private ArrayList<String> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.connections = new HashMap<>();
        this.items = new ArrayList<>();
    }

    // Getter methods

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Room> getConnections() {
        return connections;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    // Add a connection to another room
    public void addConnection(String direction, Room room) {
        connections.put(direction, room);
    }

    // Add an item to the room
    public void addItem(String item) {
        items.add(item);
    }

    // Remove an item from the room
    public void removeItem(String item) {
        items.remove(item);
    }
}

// AdventureModel class represents the game world and logic
class AdventureModel {
    private HashMap<String, Room> rooms;
    private Adventurer adventurer;

    public AdventureModel() {
        rooms = new HashMap<>();
        createRooms();
        adventurer = new Adventurer();
    }

    // Create rooms and define connections
    private void createRooms() {
        Room room1 = new Room("Room 1", "This is the starting room.");
        Room room2 = new Room("Room 2", "This room has a key.");
        Room room3 = new Room("Room 3", "This room has a locked door.");

        room1.addConnection("north", room2);
        room2.addConnection("south", room1);
        room2.addConnection("east", room3);
        room3.addConnection("west", room2);

        room2.addItem("key");

        rooms.put(room1.getName(), room1);
        rooms.put(room2.getName(), room2);
        rooms.put(room3.getName(), room3);
    }

    // Getter methods

    public Room getCurrentRoom() {
        return adventurer.getCurrentRoom();
    }

    public ArrayList<String> getCurrentItems() {
        return adventurer.getCurrentItems();
    }

    // Process the player's command
    public String processCommand(String command) {
        String[] words = command.split(" ");

        if (words[0].equalsIgnoreCase("go")) {
            return goCommand(words);
        } else if (words[0].equalsIgnoreCase("look")) {
            return lookCommand();
        } else if (words[0].equalsIgnoreCase("take")) {
            return takeCommand(words);
        } else if (words[0].equalsIgnoreCase("drop")) {
            return dropCommand(words);
        } else if (words[0].equalsIgnoreCase("use")) {
            return useCommand(words);
        } else if (words[0].equalsIgnoreCase("exit")) {
            return "Goodbye!";
        } else {
            return "Invalid command.";
        }
    }

    // Process the "go" command
    private String goCommand(String[] words) {
        if (words.length < 2) {
            return "Go where?";
        }

        String direction = words[1];
        Room currentRoom = adventurer.getCurrentRoom();
        HashMap<String, Room> connections = currentRoom.getConnections();

        if (connections.containsKey(direction)) {
            Room nextRoom = connections.get(direction);
            adventurer.setCurrentRoom(nextRoom);
            return nextRoom.getDescription();
        } else {
            return "You cannot go that way.";
        }
    }

    // Process the "look" command
    private String lookCommand() {
        return adventurer.getCurrentRoom().getDescription();
    }

    // Process the "take" command
    private String takeCommand(String[] words) {
        if (words.length < 2) {
            return "Take what?";
        }

        String item = words[1];
        Room currentRoom = adventurer.getCurrentRoom();
        ArrayList<String> items = currentRoom.getItems();

        if (items.contains(item)) {
            adventurer.addItem(item);
            currentRoom.removeItem(item);
            return "You took the " + item + ".";
        } else {
            return "That item is not here.";
        }
    }

    // Process the "drop" command
    private String dropCommand(String[] words) {
        if (words.length < 2) {
            return "Drop what?";
        }

        String item = words[1];
        ArrayList<String> items = adventurer.getCurrentItems();

        if (items.contains(item)) {
            adventurer.removeItem(item);
            adventurer.getCurrentRoom().addItem(item);
            return "You dropped the " + item + ".";
        } else {
            return "You don't have that item.";
        }
    }

    // Process the "use" command
    private String useCommand(String[] words) {
        // Implement your logic for using items here
        return "Not implemented.";
    }
}

// Adventurer class represents the player's character
class Adventurer {
    private Room currentRoom;
    private ArrayList<String> items;

    public Adventurer() {
        this.currentRoom = null;
        this.items = new ArrayList<>();
    }

    // Getter and setter methods

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<String> getCurrentItems() {
        return items;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }
}

public class TextAdventure {
    public static void main(String[] args) {
        AdventureModel model = new AdventureModel();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Text Adventure Game!");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();

            String result = model.processCommand(command);
            System.out.println(result);

            if (result.equals("Goodbye!")) {
                break;
            }
        }

        scanner.close();
    }
}
