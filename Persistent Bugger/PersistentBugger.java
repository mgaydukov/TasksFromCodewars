//https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec

import java.util.*;

public class PersistentBugger {
    public static void main(String[] args) {
        long n = 25;
        if(n/10 == 0) {
            System.out.println("0");
            System.exit(0);
        }

        List<Integer> list = new ArrayList<>(makeList((int) n));
        int counter = 0;

        while (list.size() > 1){
            int calc = list.stream()
                    .reduce((d1, d2) -> d1 * d2)
                    .get();
            counter++;
            list.clear();
            list = new ArrayList<>(makeList(calc));
        }
        System.out.println(counter);
    }

    private static List makeList(int n){
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(n%10);
            n = n/10;
        }
        return list;
    }
}

