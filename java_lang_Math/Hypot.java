import java.lang.Math;

public class Hypot
{

// //THE FOLLOWING THREE EXAMPLES SHOULD BE VALIDATED BY OPENJML

// // the square root of b^2 equals b
//@ requires a == 0.0;
//@ ensures \result == b;
public static double hypot_test_1(double a, double b)
{
	double c = Math.hypot(a, b);
	return c;
}

//@ requires a == 0.0 && b == 0.0;
//@ ensures \result == 0.0;
public static double hypot_test_2(double a, double b)
{
        double c = Math.hypot(a, b);
        return c;
}

//@ requires a == 1.0 && b == 0.0;
//@ ensures \result == 1.0;
public static double hypot_test_3(double a, double b)
{
        double c = Math.hypot(a, b);
        return c;
}

}
