package jUnit;

import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;


    BinaryOperator<Integer> devide = (x, y) -> {
        int z =0;
        z= x/y;


//        try {
//            z= x/y;
//         } catch (ArithmeticException exc){
//            System.out.println("Йохохоу АрифметикException....\n" +
//                    "нельзя делить на 0 и похорошему тут наверно надо все это заново вводить ... \n" +
//                    "но какбы в задании такого нет... \n" );
//        }
//        finally {
//            System.out.println(
//                    "такчто...\n" +
//                            "Файнали ...\n" +
//                            " у=1 (ну какбы b) и какбы Thats All Folks!\n ");
//            if (y==0)  z= x/1;
//        }
        return z;
        };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0; //

    Consumer<Integer> println = System.out::println;
    Consumer<Boolean> println2 = System.out::println;


}
