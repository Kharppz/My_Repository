public class Ders8 {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            if (sum > 10) break;
            sum += i;
        }

        System.out.println(sum);

        int total = 0;

        for (int i = 1; i <= 10; i++) {
            if (i == 5 || i == 6) continue;
            total += i;
        }

        System.out.println(total);

    }
}
