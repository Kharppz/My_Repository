import java.util.Scanner;

public class TepebasiDay2 {

	public static void main (String[] args) {
		
		// Scanner sınıfı ile sisteme giriş yapacağız
		Scanner input = new Scanner(System.in);
		
		// Değişkenleri yarattık
		String name;
		int age;
		String color;
		double height;
		
		// Tek tek komut vererek dışardan veri aldık
		System.out.println("İsmini gir=> ");
		name = input.next();

		System.out.println("Yaşını gir=> ");
		age = input.nextInt();

		System.out.println("Sevdiğin renk=> ");
		color = input.next();

		System.out.println("Boyunu gir=> ");
		height = input.nextDouble();
		
		// Aldığımız verileri konsola yazdırdık
		System.out.println("Senin ismin=> " + name);
		System.out.println("Doğum yılın=> " + (2016 - age));
		System.out.println("Sevdiğin renk=> " + color);
		System.out.println("Boyun=> " + height);

	}
}
