import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class DaysBetweenTwoDates {


    // Minus oldDate from date of Today
    public long daysBetween(Date one, Date two){
        long difference = (one.getTime() - two.getTime())/86400000; // 8640000 is the number of millisecones in one day
        return Math.abs(difference);
    }

        public static void main(String[] args) {
            // Read from Console
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter Your Date (for example 31/10/2000) : ");
            String userDate = scan.next();

            // String to Array of Char
            char[] charVar = userDate.toCharArray();



            // Subtract each part of Date
            String dayVar = "", monthVar= "", yearVar= "", str = "";

            for (int i=0;i<charVar.length;i++){

                if (charVar[i]!= '/') str =  str + charVar[i] ;
                if (i==2) {
                    dayVar = str;
                    str = "";
                }
                if (i==5) {
                    monthVar = str;
                    str = "";
                }
                if (i<=charVar.length) {
                   yearVar = str;
                }

            }
            // String to Int
            int yV=Integer.parseInt(yearVar);
            int mV=Integer.parseInt(monthVar)-1;
            int dV=Integer.parseInt(dayVar);


            Date today = new Date();

            // initialing first date
            Calendar myNextCalender = Calendar.getInstance();
            myNextCalender.set(yV,mV,dV);
            Date nyd = myNextCalender.getTime();

            // call function of calculating time
            DaysBetweenTwoDates myObject = new DaysBetweenTwoDates();
            long days = myObject.daysBetween(today,nyd);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
            String todayDate = sdf.format(today);
            String newYearsDay = sdf.format(nyd);

            System.out.println(days + " days from " + newYearsDay + " until " + todayDate);
    }
}
