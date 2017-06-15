import java.util.Scanner;

public class Ders7 {

	public static void main (String[] args) {

//        System.out.println("Hello World!");
//        System.out.println("Hello World!");
//        System.out.println("Hello World!");
//        System.out.println("Hello World!");
//        System.out.println("Hello World!");
//        System.out.println("Hello World!");
//
//        int i = 0;
//        while (i < 6) {
//            System.out.println("Hello World!");
//            i++;
//        }

        int i = 0;
        int number = 10;
        int total = 0;

        while(i < number) {
            total += i;
            i++;
        }

        System.out.println(total);

        /********************************************************/

        Scanner scan = new Scanner(System.in);

        int data = 0;
        int sum = 0;

        do {
            sum += data;
            System.out.println("Sayı gir (CIKIS = 0)=> ");
            data = scan.nextInt();
        } while (data != 0);

        System.out.println(sum);

        /********************************************************/

        Scanner input = new Scanner(System.in);

        System.out.println("Rakam gir=> ");
        int number = input.nextInt();

        for (int i = 1; number >= i; i++) {
            System.out.println(i);
        }

        int j = 1;
        while (number >= j) {
            System.out.println(j);
            j++;
        }

	}
}