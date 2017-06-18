public class Ders9_1 {

    public static void main(String[] args) {
        print();
        
        printText("Hi!", 5);
        
        int number = showNumber();
        System.out.println(number);
        
        System.out.println(toplam(5.5,6.7));
    }

    public static void print() {
        String text = "Hello YouTube!";
        System.out.println(text);
    }

    public static void printText(String text, int no) {
        System.out.println(text);
        System.out.println(no * 10);
    }

    public static int showNumber() {
        int no = 30;
        no += 10;
        return no;
    }

    public static double toplam(double no1, double no2){
        return no1 + no2;
    }

}
