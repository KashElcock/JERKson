package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        List<Item> parseItemList = new ArrayList<>();
        String[] splitString = valueToParse.split("##");
        try {
            for (String input : splitString) {
                Pattern p = Pattern.compile("(\\w+)+[;%:*^@!]([^^;*@!:%#]+)");
                Matcher m = p.matcher(input);
                String nameValue = "";
                String priceValue = "";
                String typeValue = "";
                String expirationValue = "";
                while (m.find()) {
                    switch (m.group(1).toLowerCase()) {
                        case "name" -> {
                            nameValue = m.group(2);
                            nameValue = nameValue.toLowerCase();
                        }
                        case "price" -> {
                            priceValue = m.group(2);
                            priceValue = priceValue.toLowerCase();
                        }
                        case "type" -> {
                            typeValue = m.group(2);
                            typeValue = typeValue.toLowerCase();
                        }
                        case "expiration" -> expirationValue = m.group(2);
                    }
                }
                try {
                    Item item = new Item(nameValue, Double.parseDouble(priceValue), typeValue, expirationValue);
                    System.out.println(item);
                    if(nameValue.equals("") || priceValue.equals("") || typeValue.equals("") || expirationValue.equals("")){
                        throw new ItemParseException();
                    }
                    parseItemList.add(item);
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseItemList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        Pattern p = Pattern.compile("(\\w+)+[;:%*^@!]([^^;*@!:%#]+)");
        Matcher m = p.matcher(singleItem);
        String nameValue = "";
        String priceValue = "";
        String typeValue = "";
        String expirationValue = "";
        Item item = null;
        try {
        while (m.find()) {
            switch (m.group(1).toLowerCase()) {
                case "name" -> {
                    nameValue = m.group(2);
                    nameValue = nameValue.toLowerCase();
                }
                case "price" -> {
                    priceValue = m.group(2);
                    priceValue = priceValue.toLowerCase();
                }
                case "type" -> {
                    typeValue = m.group(2);
                    typeValue = typeValue.toLowerCase();
                }
                case "expiration" -> expirationValue = m.group(2);
            }
        }
            item = new Item(nameValue, Double.parseDouble(priceValue), typeValue, expirationValue);
            System.out.println(item);
        } catch (NumberFormatException e) {
            throw new ItemParseException();
        }
        if(nameValue.equals("") || priceValue.equals("") || typeValue.equals("") || expirationValue.equals("")){
            throw new ItemParseException();
        }
            return item;
    }
}
