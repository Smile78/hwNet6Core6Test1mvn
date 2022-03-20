package jUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class MainCalcTest {

    Calculator calc;

    @BeforeAll
    static void beforeAll() {
        System.out.println("DB connect");
        //        fail("test not finished");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\nDB disconnect");
        //        fail("test not finished");
    }

    @BeforeEach
    void setUp() {
//        System.out.println("mock on");
//        System.out.println("\nBfre ich");
        calc = Calculator.instance.get();
        //        fail("test not finished");
    }

    @AfterEach
    void tearDown() {
//        System.out.println("mock off");
        //        fail("test not finished");
    }


//    @Rule                                                  // junit4 ??
//    public TestRule timeout = new Timeout(100);


    @Test
    @DisplayName("checkPlus")
    void checkPlus() {
        int a = 1;
        int b = 2;
        int expectd = 3;

        int reslt = calc.plus.apply(a, b);
        assertEquals(expectd, reslt);
//        fail("test not finished");

        assertNotNull(Integer.toString(reslt));
//        assertDoesNotThrow(ArithmeticException.class, ()->calc.plus.apply(a, b)); //??
        assertFalse(calc.devide.apply(a, b) % 2 > 0);
//        assertInstanceOf(reslt,int); //??

    }


    @Test
    @DisplayName("devide by 0 Exception")
    void devideExc() {
        int a = 1;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> calc.devide.apply(a, b));  // 1 если  нет ошибки выдает ошибку!!!  2  не видит  если есть файнели!!
//        fail("test not finished");
    }


    @Test
    @DisplayName("checkMulty just usual")
    void checkMulty() {
        int x = 2;
        int y = 3;
        int z = 6;
        int rslt = calc.multiply.apply(x, y);
        assertEquals(z, rslt);
//        fail("test not finished");
    }

    @ParameterizedTest()
    @DisplayName("checkMultyPositive  svrl param")
    //    @ValueSource(ints={{1,1},{1,1},{1,1}})
    @ValueSource(ints = {-1, -2, -3})
        //запускается неск раз!!  только один параметр???
    void checkMulty(int x) {
//    void checkMulty(int x,int y,int z){
        int y = -1;
        int rslt = calc.multiply.apply(x, y);
        assertEquals(true, rslt > 0);
//        fail("test not finished");
    }


    // method sours
    private static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(5, 2, 3),
                Arguments.of(50, 10, 40)
        );
    }

    @ParameterizedTest()
    @DisplayName("checkMinus  real svrl params")
    @MethodSource("testSource")
    void checkMinus(/*ХоуХоуХоу*/int x, int y, int z) {
        int rslt = calc.minus.apply(x, y);
        assertEquals(z, rslt);
//        fail("test not finished");
    }


//    @Test
//    @DisplayName("ignore test")
//    @Ignore("bcs rule not 4 all")                           // junit4 ??
//    void dis() {
//        System.out.println("ignore");
//        //        fail("test not finished");
//    }
//


    @Test
    @DisplayName("disabled test")
    @Disabled("bcs not ready smth")
    void dis() {
        System.out.println("Disabled");
        //        fail("test not finished");
    }


    @Test
    @DisplayName("notFinished test")
    void notFin() {
//         fail("test not finished");            // выдает как ошибку
    }


}