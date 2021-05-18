import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.sieve(11);
        main.sieve(20);
        main.sieve(2);
        main.sieve(100);
    }

    public void sieve(int n) {

        // 1. Create a list of all numbers from 2 to the maximum limit n.
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }

        // 2. Let p be the lowest number remaining in the list.
        int p = list.get(0);

        while (p < n) {
            for (int i = p; i < n; i++) {
                // 3. Remove every multiple of p from the list, starting with 2p and ending at n.
                int m = i * p;
                if (m <= n) {
                    list.remove(Integer.valueOf(m));
                } else {
                    // 4. If there are numbers remaining in the list greater than p but smaller than n, go to step 2 and repeat the process.
                    p++;
                    i = p - 1;
                }
            }
        }

        // Your function/method should print every prime number from 2 to the maximum specified, separated by ", " (a single comma and a single space).
        // The last number should have no comma or space after it.
        System.out.println(list.toString().replace("[","").replace("]",""));
    }
}
