package utilities.applicationUtilities;

import managers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiscellaneousApplicationUtilities {

    protected final static Logger LOGGER = LogManager.getLogger(MiscellaneousApplicationUtilities.class);
    private static final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";

    public static void wait(int msec) throws Exception{
        Thread.sleep(msec);
    }

    public static boolean isListOfStringSorted(List<WebElement> listOfElements, String order){
        boolean sorted = true;
        int size = listOfElements.size();
        if(size == 0 || size == 1) return true;

        switch (order){
            case "ASC":
                for (int i = 1; i < size; i++) {
                    if (listOfElements.get(i-1).getText().compareTo(listOfElements.get(i).getText()) > 0) sorted = false;
                }
                break;
            case "DESC":
                for (int i = 1; i < size; i++) {
                    if (listOfElements.get(i-1).getText().compareTo(listOfElements.get(i).getText()) < 0) sorted = false;
                }
                break;
        }

        return sorted;
    }

    public static boolean isListOfNumbersSorted(List<WebElement> listOfElements, String order){
        boolean sorted = true;
        int size = listOfElements.size();
        if(size == 0 || size == 1) return true;

        switch (order){
            case "ASC":
                for (int i = 1; i < size; i++) {
                    if (Float.parseFloat(listOfElements.get(i-1).getText().replace("$", "")) > Float.parseFloat(listOfElements.get(i-1).getText().replace("$", ""))) sorted = false;
                }
                break;
            case "DESC":
                for (int i = 1; i < size; i++) {
                    if (Float.parseFloat(listOfElements.get(i-1).getText().replace("$", "")) < Float.parseFloat(listOfElements.get(i-1).getText().replace("$", ""))) sorted = false;
                }
                break;
        }

        return sorted;
    }

    public static String generateNames(int maxCharacters){
        StringBuilder sb = new StringBuilder(maxCharacters);

        for (int i = 0; i < maxCharacters; i++) {
            int index = (int)(alphaString.length() * Math.random());
            sb.append(alphaString.charAt(index));
        }

        return sb.toString();
    }

    public static String generatePostalCode(int maxCharacters){
        StringBuilder sb = new StringBuilder(maxCharacters);

        for (int i = 0; i < maxCharacters; i++) {
            int index = (int)(alphaString.length() * Math.random());
            sb.append(alphaString.charAt(index));
        }

        return sb.toString();
    }

    public static float returnSum(List<Float> list){
        float total = 0;
        for(Float number : list){
            total += number;
        }
        return total;
    }

    public static float calculatePrice(float tax, float price){
        float total = 0;
        total = Math.round((price + price * tax/100)*100)/100.0f;
        return total;
    }
}
