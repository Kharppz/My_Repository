public class Ders9_2 {

    public static void main(String[] args) {

        System.out.println(isPrime(245));

    }

    public static boolean isPrime(int number) {
        boolean prime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                prime = false;
                break;
            }
        }

        return prime;
    }
}
