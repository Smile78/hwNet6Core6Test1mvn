package hamcrest;

public class Main {

    public static void main(String[] args) {

        CalculatorHamcrest calc = CalculatorHamcrest.instance.get();

        int a = calc.plus.apply(1, 2);
         int b = calc.minus.apply(1, 1);
//        int c = calc.devide.apply(a, b);
//        calc.println.accept(c);

        int abs2 = calc.abs.apply(-5);
        calc.println.accept(abs2);

        boolean isPositiF = calc.isPositive.test(2);
        calc.println2.accept(isPositiF);



        //Tst




    }
}
