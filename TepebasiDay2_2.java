import java.util.Scanner;

public class TepebasiDay2_2 {

	public static void main (String[] args) {

		Scanner input = new Scanner(System.in);

		int grade;

		System.out.println("Notunu gir(0-100)=> ");
		grade = input.nextInt();
		
		// if else örneğine güzel bir örnek
		if (grade > 100 || grade < 0) {
			System.out.println("Tekrar dene");
		} else if (grade <= 100 && grade >= 80) {
			System.out.println("AA");
		} else if (grade <= 79 && grade >= 50) {
			System.out.println("BB");
		} else if (grade <= 49 && grade >= 30) {
			System.out.println("CC");
		} else {
			System.out.println("FF");
		}
	}
}
