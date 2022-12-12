package io.zipcoder;
public class GroceryReporter {
    private final String fileName;

    @Override
    public String toString() {
        return "GroceryReporter{}";
    }

    public GroceryReporter(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        GroceryReporter groceryReporter = new GroceryReporter("RawInput.txt");
     }
}
