import java.lang.Math;

public class Max
{

// // THE FOLLOWING THREE TESTS SHOULD BE EVALUATED AS VALID BY OPENJML


//@ requires a <= b;
//@ ensures \result == b;
//@ also
//@ requires b <= a;
//@ ensures \result == a;
public static double max_test_1(double a, double b)
{
	double c = Math.max(a, b);
	return c;
}

//@ensures \result >= a && \result >= b;
//@ensures \result <= a || \result <= b;
public static double max_test_2(double a, double b) 
{
        double c = Math.max(a, b);
        return c;
}

//@ensures \result >= 5*a - 4 && \result >= -2*b + 3;
//@ensures \result <= 5*a - 4 || \result <= -2*b + 3;
public static double max_test_3(double a, double b) 
{
	double c = Math.max(5 * a - 4, -2 * b + 3);
	return c;
}

public static double max_test_4(double a, double b)
{
	double c = Math.max(a, b);
	return c;
}



}
