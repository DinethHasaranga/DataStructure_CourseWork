package sample;

import java.util.Scanner;

public class Fibonacci1 {
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    public static void main (String args[])
    {
        int num;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number");
        num = input.nextInt();

        System.out.println(fib(num));

        //**************************************************************************************************************

        System.out.println(" ");

        int num1 = 0;
        int num2 = 1;
        int num3 = 0;
        int i;
        int count;

        System.out.println("Enter number");
        count = input.nextInt();
        input.close();

        for(i = 1; i < count; ++i)
        {
            num3 = num1 + num2;

            num1 = num2;
            num2 = num3;
        }
        System.out.println(num3);
    }
}
