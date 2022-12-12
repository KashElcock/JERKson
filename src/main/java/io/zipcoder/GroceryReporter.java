package io.zipcoder;

import io.zipcoder.utils.FileReader;

public class GroceryReporter {
    private final String originalFileText;
    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    public String getOriginalFileText() {
        return originalFileText;
    }
    public static void main(String[] args) {

      GroceryReporter groceryReporter = new GroceryReporter("RawInput.txt");
        System.out.println(groceryReporter);
    }

    public String getCleanReportText() {
        return null;
    }
}
