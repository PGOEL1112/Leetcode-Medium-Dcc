public class DayofYear {
    public static int dayOfYear(String date) {
        int result = 0;
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int year = Integer.parseInt(date.substring(0, 4));
        int months = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));


        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days[1] = 29;
        }

        for (int i = 0; i < months-1; i++) {
            result += days[i];
        }
        
        result+= day;

        return result;
    }

    public static void main(String[] args) {
        String s = "2019-06-08";
        int result = dayOfYear(s);
        System.out.println("The Day Number is : " + result);
    }
}
