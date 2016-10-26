public class TGMTest {

	public static void main (String[] args) {
		
		// Değişkenleri tanımlama
		int radius = 6;
		double perimeter = 2 * 3.14 * radius;
		double area = 3.14 * radius * radius;
		String color = "red";
		
		// Değişkenleri konsol ekranında yazdırma
		System.out.println(radius + 1);
		System.out.println(radius);
		System.out.println("Çevre " + perimeter);
		System.out.println("Alan " + area);
		System.out.println("Renk " + color + " : kırmızı");
		System.out.println("TepebaşıGençlik");
		
		// boolean değişkeni sadece true ve false değeri alır
		boolean bool = false;
		System.out.println(bool);
		
		// char değişkeni sadece karakter değerlerini alır
		char char1 = 'A';
		System.out.println(char1);
		
		// % operatörü bölümünden kalanı verir
		int no1 = 15;
		System.out.println(no1 % 2);
		
		// % operatörü için bir örnek
		int second = 500;
		int minute = 500 / 60;
		int remain = 500 % 60;
		
		System.out.println(minute + " DK " + remain + " SN");
	}

}
