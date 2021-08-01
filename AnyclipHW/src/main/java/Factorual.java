public class Factorual {

    public static void main(String[] args) {
        System.out.println(func(3));
    }

    public static long func (int n) {
        //type long (8 bytes) can only contain at most 20!
        if (n > 20) throw new IllegalArgumentException(n + " is out of range");
        if (n <= 1) return 1;
        else {
            return n * func(n-1);
        }
    }
}
