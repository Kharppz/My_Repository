import java.util.Scanner;

public class TepebasiDay2_1 {

	public static void main (String[] args) {
			
		Scanner input = new Scanner(System.in);

		int number;

		System.out.println("Sayı gir=> ");
		number = input.nextInt();
		
		// if ifadesiyle girilen sayıyı kontrol ederek
		// O duruma uygun ifadeleri konsola yazdırdık
		if (number % 5 == 0) {
			System.out.println("Sayı 5 e bölünür");
		}
		if (number % 2 == 0) {
			System.out.println("Sayı 2 ye bölünüyor");
		}

		System.out.println("Sayı gir=> ");
		number = input.nextInt();
		
		// if else kullanımına güzel bir örnek
		if (number < 0) {
			System.out.println("Sayı negatif");
		} else if (number > 0) {
			System.out.println("Sayı pozitif");
		} else {
			System.out.println("Sayı sıfır");
		}
	}
}
