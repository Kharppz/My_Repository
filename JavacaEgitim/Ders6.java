import java.util.Scanner;

public class Ders6 {

	public static void main (String[] args) {

		Scanner input = new Scanner(System.in);

		int month;

		System.out.println("Ay gir=> ");
		month = input.nextInt();
		
		// switch-case kullanımında break komutlarını unutmuyoruz
		switch (month) {
			case 1: System.out.println("Ocak"); break;
			case 2: System.out.println("Şubat"); break;
			case 3: System.out.println("Mart"); break;
			default: System.out.println("Yanlış değer");
		}
		
		// switch-case bölümünün if else şeklinde yazımı kod aynı
		if (month == 1) {
			System.out.println("Ocak");
		} else if (month == 2) {
			System.out.println("Şubat");
		} else if (month == 3) {
			System.out.println("Mart");
		} else {
			System.out.println("Yanlış değer");
		}
		
		// if else kullanımını tek satırda gösterme
		int number = 6;
		int no1;

		if (number > 5) {
			no1 = 1;
		} else {
			no1 = -1;
		}
		
		// tek değişkene bağlı bir durum varsa
		// aşağıdaki gibi bir görünümle yapabiliriz
		// true ise ? işaretinden sonra false ise : işaretinden 
		// sonraki değer atanır
		no1 = (number > 5) ? 1 : -1;

		System.out.println(no1);

	}
}