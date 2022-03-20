package hamcrest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorHamcrestTest {

    CalculatorHamcrest calc;


    // *** around Tests ***

    @BeforeEach
    void setUp() {
//        System.out.println("\nBfre ich");
        calc = CalculatorHamcrest.instance.get();
//        fail("test not finished");
    }

    @AfterEach
    void tearDown() {
    }


    // *** Tests ***

//    @Test
//    public void contains() {
//        List<String> list = List.of("hello", "netology", "world");
//        assertThat(list, hasItems("hello", "netology"));                  // test теста?
//    }


    @Test
    @DisplayName("checkPlus")
    void checkPlus() {
        int a = 1;
        int b = 2;
        int expectd = 3;
        int reslt = calc.plus.apply(a, b);
        assertThat(expectd, equalTo(reslt));
        assertThat(Integer.toString(reslt), notNullValue());
        assertThat((calc.devide.apply(a, b) % 2 > 0), is(false));

    }


    @Test
    @DisplayName("devide by 0 Exception")
    void devideExc() {
        int a = 1, b = 0;
//        assertThat((calc.devide.apply(a, b)),  instanceOf(ArithmeticException.class));             //??
        //        assertThat(calc.devide.apply(a, b),  thrown(ArithmeticException.class));

    }


    @Test
    @DisplayName("checkMulty just usual")
    void checkMulty() {
        int x = 2;
        int y = 3;
        int z = 6;
        int rslt = calc.multiply.apply(x, y);
        assertThat(rslt, equalTo(z));

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

        assertThat(true, equalTo(rslt > 0));
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
        assertThat(rslt, equalTo(z));
//        fail("test not finished");
    }


    //ddt :)

    @Test
    @DisplayName("checkDevide doubleNew")
    void devide() {
        float x = 2.0f;
        float y = 1.0f;
        float rsltF = 1.0f;
        float devideF = x / y;

        assertThat(devideF, allOf(greaterThan(0.0f), lessThanOrEqualTo(3.0f), not(equalTo(1.0f))));
        assertThat((double) devideF, closeTo(2.0d, 0.005d));

//        assertThat(devideF.getClass(), sameInstance(Float.class));                        // ??
//        assertThat(devideF.getClass(), typeCompatibleWith(Number.class));                 // ??
        assertThat(devideF, instanceOf(Float.class));
        assertThat(devideF, isA(Float.class));

    }


}