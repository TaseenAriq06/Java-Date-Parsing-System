// Date212 class represents a date in the format yyyymmdd.
// The class implements Comparable<Date212> so it can be used as a key for the TreeMap to sort automatically
public class Date212 implements Comparable<Date212> { 
    private int year;
    private int month;
    private int day;

    public Date212(String date){        // Constructor that parses a String in yyyymmdd format
        if(date == null){               // checks for null input
            throw new IllegalDate212Exception("Date string is null.");
        }
        if(date.length() != 8){         // checks if input is 8 characters long exactly
            throw new IllegalDate212Exception("Date must be 8 digits in yyyymmdd format: " + date);
        }
        for(int i = 0; i < 8; i++){     // make sure every character is a digit
            if(!Character.isDigit(date.charAt(i))){
                throw new IllegalDate212Exception("Date contains non-digit characters: " + date);
            }
        }
        // extract year, month, dates, as actual integers from the string
        int y = Integer.parseInt(date.substring(0,4));
        int m = Integer.parseInt(date.substring(4, 6));
        int d = Integer.parseInt(date.substring(6, 8));

        if(m < 1 || m > 12){            // validate the month must be between 1-12
            throw new IllegalDate212Exception(date + ": Invalid month (must be between 1-12)" + ", " + date.substring(4,6) + " is not a valid month.");
        }

        // max days per month excluding leap year dates
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};   
        int maxDay = daysInMonth[m - 1]; // validates the index of the months to the # of days (Ex: Jan = month 1 index 0)

        if(d < 1 || d > maxDay){        // validate the day ranges
            throw new IllegalDate212Exception(date + ": Invalid day for this month" + ", " + date.substring(6,8) + " is not a valid day."); 
        }
        // save the valid dates
        this.year = y;
        this.month = m;
        this.day = d;
    }

    // Getter methods
    public int getYear(){
        return this.year;
    }
    public int getMonth(){
        return this.month;
    }
    public int getDay(){
        return this.day;
    }
    // Setter methods
    public void setYear(int y){
        this.year = y;
    }
    public void setMonth(int m){
        this.month = m;
    }
    public void setDay(int d){
        this.day = d;
    }
    // Checks if this date is equal to another Date212 object.
    public boolean isEqual(Date212 other){ 
        return (this.year == other.getYear() && this.month == other.getMonth() && this.day == other.getDay());
    }
    // Compares this date to another Date212 object.
    public int compareTo(Date212 other){
        if (!(this.isEqual(other))){
            if (this.year < other.getYear()) return -1;
            if (this.year > other.getYear()) return 1;
            if (this.month < other.getMonth()) return -1;
            if (this.month > other.getMonth()) return 1;
            if (this.day < other.getDay()) return -1;
            if (this.day > other.getDay()) return 1;
        }
        return 0; // dates are equal
    }
    // Converts a month number to its corresponding month name.
    public String intToMonth(int m){
        switch(m){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid"; // handles invalid month numbers
        }
    }
    // zellers congruence is used to return the day of the week in Date212 (Gregorgian Calendar)
    private String zellersCongruence(){ 
        int q = this.day;              // day of the month
        int m = this.month;            // month
        int Y = this.year;             // year

        if(m == 1 || m == 2){          
            m += 12;                   // january and february are considered months 13 and 14 (since March is month 1)
            Y -= 1;                    // zeller's congruence says to push them back to the previous year
        }

        int K = Y % 100;               // based on the year of the century and progression of the days of the week
        int J = Y / 100;               // zero based century such as 19 and 20 in the beginning of years

        // zeller's congruence formula which ends up becoming: 
        // 0 = Saturday, 1 = Sunday, 2 = Monday, 3 = Tuesday, 4 = Wednesday, 5 = Thursday, 6 = Friday
        
        int h = (q + (13*(m+1)) / 5 + K + K / 4 + J / 4 + 5*J) % 7; 

        switch(h){
            case 0: return "Saturday";  // according to zellers congruence, day of the week starts with saturday = 0
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            default: return "Unknown";
        }
    }
    public String toString(){
        String dayName = zellersCongruence(); // variable to hold the new days of the week and add it to the toString
        return dayName + ", " + this.intToMonth(this.month) + " " + this.day + ", " + this.year;
    }

    public static void selectionSort(Date212[] sortedDates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectionSort'");
    }
}