import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        //int number = 4, result;
        int result;
        System.out.print("number :");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();
        result = factorial(number);
        System.out.println(number + " factorial = " + result);
    }
    static int factorial( int n ) {
        if (n != 0)  // termination condition
            return n * factorial(n-1); // recursive call
        else
            return 1;
    }
}