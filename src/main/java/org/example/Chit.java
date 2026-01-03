package org.example;

public class Chit {
    public static void main(String[] args) {
        String[] months = {"Chithirai", "Vaigasi", "Aani", "Aadi", "Aavani", "Purataasi", "Ipasi", "Kaarthigai", "Maargali", "Thai", "Maasi", "Panguni"};
        System.out.println(months.length);
        int year = 2025;
        int lim = 17;
        int start = 10;
        int n = 11;
        while (lim > 0) {
            System.out.println(months[start] + "-" + year);
            start += 4;
            if (start > 11) {
                start %= 12;
                year++;
            }
            lim--;
        }

    }
}
