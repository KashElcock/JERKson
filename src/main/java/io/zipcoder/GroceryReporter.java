package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.match.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryReporter {
    public static void main(String[] args) {
        String[] jerkItems = new GroceryReporter("RawInput.txt").splitFileIntoJerkItems();
        ArrayList<Item> mildItems = new ArrayList<>();
        for (String input : jerkItems) {
            Pattern p = Pattern.compile("(\\w+):([^^;*@!:%]+)");
            Matcher m = p.matcher(input);
            String nameValue = "";
            String priceValue = "";
            String typeValue = "";
            String expirationValue = "";
            while (m.find()) {
                switch (m.group(1).toLowerCase()) {
                    case "name":
                        nameValue = m.group(2);
                        break;
                    case "price":
                        priceValue = m.group(2);
                        break;
                    case "type":
                        typeValue = m.group(2);
                        break;
                    case "expiration":
                        expirationValue = m.group(2);
                        break;
                }
            } try{
                Item item = new Item(nameValue, Double.parseDouble(priceValue), typeValue, expirationValue);
                System.out.println(item);
                mildItems.add(item);
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }


        }
    }

    public String getCleanReportText() {
        return null;
    }
    //method to split the file into an array of strings representing each jerk item
    public String[] splitFileIntoJerkItems() {
        ArrayList<String> objects = new ArrayList<>(List.of(new GroceryReporter("RawInput.txt").getOriginalFileText().split("##")));
        System.out.println(objects);
        return objects.toArray(new String[0]);
    }
    private final String originalFileText;
    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    public String getOriginalFileText() {
        return originalFileText;
    }
}
