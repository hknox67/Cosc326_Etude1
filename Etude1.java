import java.util.Scanner;
/**
 * @author Hayden Knox
 * 31/03/2022
 */

class Etude1{
    /* 
    * The String type data fields are used as variables which contain valid date entries for the day, month and year. 
    * Following each method call for cheackDay, checkMonth and checkYear and the various conditions to evaluate user input
    * validDay, validMonth and validYear hold Strings which are output to the terminal window.

    * The Boolean type data flieds are used as flags or condition operants to either allow or prevent output from being
    * printed to the terminal window. If any of flagDay, falgMonth or flagYear are true. Only the invalid details of date 
    * entries are printed

    * The string array of months contains all the acceptable month string characters which match the etude criteria. 
    * It eliminates the posibility of a spelling error being input into the month character section. 
    */
    static String validDay;
    static String validMonth;
    static String validYear;
    static boolean flagDay = false;
    static boolean flagMonth = false;
    static boolean flagYear = false;
    static boolean flagSep = false;
    static String[] monthList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    static String[][] months = {{"JAN", "Jan", "jan"}, {"FEB", "Feb", "feb"}, {"MAR", "Mar", "mar"}, {"APR", "Apr", "apr"}, {"MAY", "May", "may"}, {"JUN", "Jun", "jun"}, {"JUL", "Jul", "jul"}, {"AUG", "Aug", "aug"}, {"SEP", "Sep", "sep"}, {"OCT", "Oct", "oct"}, {"NOV", "Nov", "nov"}, {"DEC", "Dec", "dec"}}; 
    static String[][] oddmonths = {{"APR", "Apr"}, {"JUN", "Jun"}, {"SEP", "Sep"}, {"NOV", "Nov"}};
    /*
    * The main method repeatedly executes a instance of scanner to continually read input from the terminal 
    * command line. Using an int variable as a ocunter and a String array with a maximum of 3 elements. 
    * The three required parts of a date entry are paritiioned into each array element using the .splt()
    * string method. hTe key to the split() method is that it accepts one of the three valid date spacing
    * characters. 
    * 
    * Depending on which date spacing character is entered. The methods checkDay, checkMonth and checkYear are called.
    * in a sequence. If each method call doesnt alrer the value of tthe boolean flag datafileds. The valid output is 
    * printed to the terminal.
    */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            flagDay = false;
            flagMonth = false;
            flagYear = false;
            flagSep = false;
            validDay = null;
            validMonth = null;
            validYear = null;
            String date = input.nextLine();
            System.out.println("Date: " + date);
            String[] array = new String[2];
            int indx = 0;
            try{
                if(date.indexOf(" ") > -1){
                    array = date.split("\\s");
                    if(seperatorCount(date, ' ', indx) < 2){
                        System.out.println(" - INVALID: Date formatted incorrectly (Seperator characters missing, date not readable).");
                    }
                    if(seperatorCount(date, ' ', indx) > 2 /*&& (date.substring(date.length() -1).matches(".*[a-z].*") || date.substring(date.length() -1).matches(".*[a-z].*"))*/){
                        System.out.println(" - INVALID: Date formatted incorrectly (there cannot be a fourth date field).");
                        flagSep = true;
                    }
                    if(date.charAt(date.length() -1) == ' '){
                        System.out.println(" - INVALID: Date formatted incorrectly (Seperator characters cannot trail).");
                        flagSep = true;
                    }
                    checkDay(array[0]);
                    checkMonth(array[1]);
                    if(array.length > 2){
                        checkYear(array[2]);
                    }
                    shortMonth(validDay, validMonth, validYear);
                    if(flagSep == false && flagDay == false && flagMonth == false && flagYear == false && validDay != null && validMonth != null && validYear != null){
                        printConversion(validDay, validMonth, validYear);
                    }  
                }else if(date.indexOf("-") > -1){
                    array = date.split("-");
                    if(seperatorCount(date, '-', indx) < 2){
                        System.out.println(" - INVALID: Date formatted incorrectly (Seperator characters missing, date not readable).");
                    }
                    if(seperatorCount(date, '-', indx) > 2/*&& (date.substring(date.length() -1).matches(".*[a-z].*") || date.substring(date.length() -1).matches(".*[a-z].*"))*/){
                        System.out.println(" - INVALID: Date formatted incorrectly (there cannot be a fourth date field).");
                        flagSep = true;
                    }
                    if(date.charAt(date.length() -1) == '-'){
                        System.out.println(" - INVALID: Date formatted incorrectly (Seperator characters cannot trail).");
                        flagSep = true;
                    }
                    checkDay(array[0]);
                    checkMonth(array[1]);
                    if(array.length > 2){
                        checkYear(array[2]);
                    }            
                    shortMonth(validDay, validMonth, validYear);
                    if(flagSep == false && flagDay == false && flagMonth == false && flagYear == false && validDay != null && validMonth != null && validYear != null){
                        printConversion(validDay, validMonth, validYear);
                    }            
                }else if(date.indexOf("/") > -1){
                    array = date.split("/");
                    if(seperatorCount(date, '/', indx) < 2){
                        System.out.println(" - INVALID: Date formatted incorrectly (Seperator characters missing, date not readable).");
                        flagYear = false;
                    }
                    if(seperatorCount(date, '/', indx)  > 2/*&& (date.substring(date.length() -1).matches(".*[a-z].*") || date.substring(date.length() -1).matches(".*[a-z].*"))*/){
                        System.out.println(" - INVALID: Date formatted incorrectly (there cannot be a fourth date field).");
                        flagSep = true;
                    }
                    if(date.charAt(date.length() -1) == '/'){
                        System.out.println(" - INVALID: Date formatted incorrectly (Seperator characters cannot trail).");
                        flagSep = true;
                    }
                    checkDay(array[0]);
                    checkMonth(array[1]);
                    if(array.length > 2){
                        checkYear(array[2]);
                    }
                    shortMonth(validDay, validMonth, validYear);
                    if(flagSep == false && flagDay == false && flagMonth == false && flagYear == false && validDay != null && validMonth != null && validYear != null){
                        printConversion(validDay, validMonth, validYear);
                    }
                }else{
                    System.out.println(" - INVALID: date formatted incorrectly (Missing correct spacing character).");
                }
            }catch(Exception e) {
                System.out.println(" - INVALID: Entry is not a date");
        }
    }
    input.close();
}
    /* 
    * This method prints the evaluated input from the terminal to the screen. This method is called from
    * the main method if the boolean flags data field value remains unaltered. 
    */
    private static void printConversion(String validDay2, String validMonth2, String validYear2) {
        System.out.println(validDay + " " + validMonth + " " + validYear);
    }

    /* 
    * This java method is used to check the validity of the day field within the terminal input string.
    * based on the criteria given by the etude description. This method checkDay evaluates the 
    * following conditions:
    *   1) Day is not 0.
    *   2) Day doesn't exceed 31.
    *   3) Days character length is less than 3
    *   4) Days character is not null.
    */
    public static void checkDay(String day){
        if((day.matches(".*[a-z].*") || day.matches(".*[A-Z].*"))){
            System.out.println(" - INVALID: Date formatted incorrectly (day is not numerical). ");
            flagDay = true;

        }
        //checks if day is 0
        if(Integer.parseInt(day) == 0){
            System.out.println(" - INVALID: Date formatted incorrectly (day character cannot be 0).");
            flagDay = true;
        }
        else if(Integer.parseInt(day) > 31){
            System.out.println(" - INVALID: Date formatted incorrectly (day character exceeds 31st day).");
            flagDay = true;

        }
        else if(day.length() > 2){
            System.out.println(" - INVALID: Date formatted incorrectly (day character length exceeded).");
            flagDay = true;

        }
        else if(day.length() < 1){
            System.out.println(" - INVALID: Date formatted incorrectly (day character length not met).");
            flagDay = true;

        }
        validDay = day;
    }

    /* 
    * This java method is used to check the validity of the month field within the terminal input string.
    * based on the criteria given by the etude description. This method checkMonth evaluates the 
    * following conditions:
    *   1) Months character limit is not greater than 2 if the entry is numerical.
    *   2) Months character limit doesn't meet the minimum numerical character requirement.
    *   3) Months character value does not exceed the 12th numeric month.
    *   4) Days character is not 0 due to this month not existing in the calendar.
    * The switch condition at the end of the method is used to alter the month input numeric characters
    * into a 3 character string for correct output format.
    */
    public static void checkMonth(String month){
    if((month.matches(".*[a-z].*") || month.matches(".*[A-Z].*"))){
            monthCharCheck(month);
            return;
    } else {
        if(month.length() > 2){
            System.out.println(" - INVALID: Date formatted incorrectly (Month character length exceeded).");
            flagMonth = true;
        } 
        else if (month.length() < 1){
            System.out.println(" - INVALID: Date formatted incorrectly (Month character length not met).");
            flagMonth = true;
        }
        if(Integer.parseInt(month) > 12){
            System.out.println(" - INVALID: Date formatted incorrectly (Month character exceeds 12th month).");
            flagMonth = true;
        }
        if(Integer.parseInt(month) == 0){
            System.out.println(" - INVALID: Date formatted incorrectly (Month character number cannot be 0).");
            flagMonth = true;
        }
        int temp = (Integer.parseInt(month) -1);
        month = monthList[temp];
        
    }
    //This is the contested statment causing trouble
    validMonth = month;
    }
    /* 
    * This java method is used to check the validity of the year field within the terminal input string.
    * based on the criteria given by the etude description. This method checkYear evaluates the 
    * following conditions:
    *   1) That the year numeric value entered is not less than 2 characters.
    *   2) If the year values entered range from 49 to 0. The characters "20" are appended to the string
    *   3) If the year values entered range from 50 to 99. The characters "19" are appended to the string
    *   4) The year value entered must be between the numeric values of 3000 to 1753.
    *   5) The years characters entered cannot be greater than 4.
    */
    public static void checkYear(String year){
        if(year.length() < 2){
            System.out.println(" - INVALID: Year formatted incorrectly (Year character length not met).");
            flagDay = true;
        }
        if(year.length() == 2){
            if(Integer.parseInt(year) < 50){
                year = "20" + year;

            } else {
                year = "19" + year;
            }
        }
        if(Integer.parseInt(year) > 3000 || Integer.parseInt(year) < 1753){
            System.out.println(" - INVALID: Year entered incorrectly (Year of entry is outside valid range).");
            flagYear = true;
        }
        if(year.length() > 4){
            System.out.println(" - INVALID: Year formatted incorrectly (Year character length exceeded).");
            flagYear = true;
        } 
        validYear = year;
    }
    /*
    * The method monthCharCheck() itterates through the characters within the month parameter of the input string
    * and using the equals() method indicates if the Month string entered is correctly spelled. This method uses
    * the characters in the months array data field.
    */
    public static void monthCharCheck(String month){
        boolean flag = false;
        for(int i = 0; i < months.length; i++){
            for(int n = 0; n < months[i].length; n++){
                if(month.equals(months[i][n])){
                    flag = true;
                    flagMonth = false;
                    validMonth = months[i][1];
                }
            }
        }
    if(flag == false){
        System.out.println(" - INVALID: Month formatted incorrectly (Month characters label not valid).");
        flagMonth = true;
    }
        flagMonth = false;
    }
    /* 
    * The method shortMonth accepts two parameters from the input string from the split partitioning array. 
    * Corresponding to each individual month, this method ensures that if a date is entered the day numeric
    * value does not exceed its maximum day in the month calendar. Simultaneously if the month of FEB is entered this
    * method checks if the date entered is a leap year.
    */
    public static void shortMonth(String day, String month, String year){
        if(month.equals("Feb") || month.equals("FEB") || month.equals("02") || month.equals("2")){

            if(Integer.parseInt(day) > 28){
                checkLeapYear(day, month, year);
            } 
        }
        for(int i = 0; i < oddmonths.length; i++){
            for(int n = 0; n < oddmonths[i].length; n++){
                if(month.equals(oddmonths[i][n]))
                    if(Integer.parseInt(day) > 30){
                        System.out.println(" - INVALID: Day Entered Incorrectly (This month day cannot exceed 30.)");
                        flagMonth = true;
                    }
                }
            }

        validMonth = month;
    } 
        

    /*
    * This method checks if the date entered by the user is a leap year. Unlike many of the other methods entered
    * this method accepts all three date array partitions to determine a leap year. however if the condition of leap year
    * are not met. The checkLeapYear method ensures the month of feberuary day doesnt exceed the 29th day.
    */
    public static void checkLeapYear(String day, String month, String year){
        if(Integer.parseInt(year) % 4 == 0 && day.equals("29") && (month.equals("FEB") || month.equals("Feb") || month.equals("feb") ||month.equals("02") || month.equals("2"))){
            if(Integer.parseInt(year) % 100 == 0 && day.equals("29") && (month.equals("FEB") || month.equals("Feb") || month.equals("feb") || month.equals("02") || month.equals("2"))){
                if(Integer.parseInt(year) % 400 == 0 && day.equals("29") && (month.equals("FEB") || month.equals("Feb") || month.equals("feb") || month.equals("02") || month.equals("2"))){
                    flagYear = false;
                }else{
                    System.out.println(" - INVALID - Date entered is incorrect(The 29th of FEB is not within a leap year.");
                    flagYear = true;
                }
            }else{
                flagYear = false;
            }
        } else {
            System.out.println(" - INVALID - Date entered is incorrect(The 29th of FEB is not within a leap year.");
            flagYear = true;
        }
    }

    
    /*
    * This method is used to count the number of seperator characters entered by the user to form a valid
    * date entry. This method will then return the number of seperator characters to partition dates elements
    * into the string array in the main method. 
        @ return int counter
    */
    public static int seperatorCount(String date, char seperator, int indx){
        if(indx >= date.length()){
            return 0;
        }
        int counter = date.charAt(indx) == seperator ? 1 : 0;
            return counter + seperatorCount(date, seperator, indx + 1);
    }
}