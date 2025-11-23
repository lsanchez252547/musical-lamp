import java.util.HashMap;
import java.util.Map;

class Main {
  public static void main(String[] args) {
    // Step 1: Create a map called creditHours
    Map<String, Integer> creditHours = new HashMap<>();

    // Step 2: put() the given key-value pairs
    creditHours.put("IT-1025", 3);
    creditHours.put("IT-1050", 3);
    creditHours.put("IT-1150", 3);
    creditHours.put("IT-2310", 3);
    creditHours.put("IT-2320", 4);
    creditHours.put("IT-2351", 4);
    creditHours.put("IT-2650", 4);
    creditHours.put("IT-2660", 4);
    creditHours.put("IT-2030", 4);

    // Step 3: Check for specific keys
    System.out.println("Contains IT-1025? " + creditHours.containsKey("IT-1025"));
    System.out.println("Contains IT-2110? " + creditHours.containsKey("IT-2110"));

    // Step 4: Print all content (key and value)
    System.out.println("\nAll course credit hours:");
    for (Map.Entry<String, Integer> entry : creditHours.entrySet()) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

    // Step 5: Remove IT-2030 and IT-1150
    creditHours.remove("IT-2030");
    creditHours.remove("IT-1150");

    // Step 6: Print all values only
    System.out.println("\nRemaining credit hours (values only):");
    for (Integer value : creditHours.values()) {
      System.out.println(value);
    }
  }
}
