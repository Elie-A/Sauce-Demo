package utilities.applicationUtilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiscellaneousApplicationUtilities {

    protected final static Logger LOGGER = LogManager.getLogger(MiscellaneousApplicationUtilities.class);


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

    private static boolean isDateListSorted(List<Date> dates, String order) {
        if(order.equalsIgnoreCase("DESC")){
            for (int i = 1; i < dates.size(); i++) {
                if (dates.get(i - 1).compareTo(dates.get(i)) < 0) {
                    return false;
                }
            }
        }else if(order.equalsIgnoreCase("ASC")){
            for (int i = 1; i < dates.size(); i++) {
                if (dates.get(i - 1).compareTo(dates.get(i)) > 0) {
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
}
