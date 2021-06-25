/*
THIS PROGRAM TESTS THE FOLLOWING METHODS FROM java.lang.Math:

Math.max(double d1, double d2)
Math.min(double d1, double d2)
Math.random()
Math.nextUp(double d)
Math.nextDown(double d)
Math.nextAfter(double d1, double d2)
Math.IEEEremainder(double d1, double d2)
Math.hypot(double d1, double d2)
*/

public class Misc
{

public static void max_literal_tests()
{
	double c;
	// integer inputs
	c = Math.max(31, 26);
	//@ assert c == 31.0;
	c = Math.max(-16, -23);
	//@ assert c == -16.0;
	c = Math.max(0, 0);
	//@ assert c == 0.0;
	
	// floats
	c = Math.max(0.0f, 0.0f);
	//@ assert c == 0.0;
	c = Math.max(-0.0f, -0.0f);
	//@ assert c == 0.0;
	c = Math.max(24.13f, 13.73f);
	//@ assert c == 24.13;
	c = Math.max(-11.56f, -12.10f);
	//@ assert c == -11.56;
	c = Math.max(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
	//@ assert c == Double.POSITIVE_INFINITY;
	c = Math.max(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
	//@ assert c == Double.NEGATIVE_INFINITY;
	c = Math.max(Float.NaN, Float.NaN);
	//@ assert c != c;
	
	// doubles
	c = Math.max(0.0, 0.0);
	//@ assert c == 0;
	c = Math.max(-0.0, -0.0);
	//@ assert c == 0;
	c = Math.max(182.28, 582.2004);
	//@ assert c == 582.2004;
	c = Math.max(-19258.4, -404.234);
	//@ assert c == -404.234;
	c = Math.max(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
	//@ assert c == Double.POSITIVE_INFINITY;
	c = Math.max(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
	//@ assert c == Double.NEGATIVE_INFINITY;
	c = Math.max(Double.NaN, Double.NaN);
	//@ assert c != c;
}



//@ requires Double.isFinite(a) && Double.isFinite(b);
public static void max_test_1(double a, double b)
{
	double c = Math.max(a, b);
	//@ assert a <= b ==> c == b;
	//@ assert b <= a ==> c == a;
}

//@ requires Double.isFinite(a) && Double.isFinite(b);
public static void max_test_2(double a, double b) 
{
        double c = Math.max(a, b);
	//@ assert c >= a && c >= b;
	//@ assert c == a || c == b;
}

//@ requires Double.isFinite(a) && Double.isFinite(b);
public static void max_test_3(double a, double b) 
{
	double c = Math.max(5 * a - 4, -2 * b + 3);
	//@ assert c >= 5 * a - 4 && c >= -2 * b + 3;
	//@ assert c == 5 * a - 4 || c == -2 * b + 3;
}


// if either input is NaN, then output is NaN
public static void max_NaN_tests(double a, double b)
{
	double c = Math.max(Double.NaN, Double.NaN);
	//@ assert Double.isNaN(c);
	
	c = Math.max(Double.NaN, a);
	//@ assert Double.isNaN(c);

	c = Math.max(a, b);
	//@ assert (Double.isNaN(a) || Double.isNaN(b)) ==> Double.isNaN(c);
}


public static void max_inf_tests(double a, double b)
{
	double c = Math.max(Double.POSITIVE_INFINITY, a);
	//@ assert Double.isInfinite(c);
	
	c = Math.max(Double.NEGATIVE_INFINITY, a);
	//@ assert Double.isFinite(a) ==> Double.isFinite(c);
	//@ assert (a < Double.POSITIVE_INFINITY) ==> Double.isFinite(c);

	c = Math.max(a, b);
	//@ assert (Double.isFinite(a) && Double.isFinite(b)) ==> Double.isFinite(c);

}




public static void min_literal_tests()
{
	double c;
	// integer inputs
	c = Math.min(31, 26);
	//@ assert c == 26.0;
	c = Math.min(-16, -23);
	//@ assert c == -23.0;
	c = Math.min(0, 0);
	//@ assert c == 0.0;
	
	// floats
	c = Math.min(0.0f, 0.0f);
	//@ assert c == 0.0;
	c = Math.min(-0.0f, -0.0f);
	//@ assert c == 0.0;
	c = Math.min(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
	//@ assert c == Double.POSITIVE_INFINITY;
	c = Math.min(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
	//@ assert c == Double.NEGATIVE_INFINITY;
	c = Math.min(Float.NaN, Float.NaN);
	//@ assert c != c;
	
	// doubles
	c = Math.min(0.0, 0.0);
	//@ assert c == 0;
	c = Math.min(-0.0, -0.0);
	//@ assert c == 0;
	c = Math.min(182.28, 582.2004);
	//@ assert c == 182.28;
	c = Math.min(-19258.4, -404.234);
	//@ assert c == -19258.4;
	c = Math.min(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
	//@ assert c == Double.POSITIVE_INFINITY;
	c = Math.min(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
	//@ assert c == Double.NEGATIVE_INFINITY;
	c = Math.min(Double.NaN, Double.NaN);
	//@ assert c != c;
}


//@ requires Double.isFinite(a) && Double.isFinite(b);
public static void min_test_1(double a, double b)
{
	double c = Math.min(a, b);
	//@ assert a <= b ==> c == a;
	//@ assert b <= a ==> c == b;
}


//@ requires Double.isFinite(a) && Double.isFinite(b);
public static void min_test_2(double a, double b) 
{
        double c = Math.min(a, b);
	//@ assert c <= a && c <= b;
	//@ assert c == a || c == b;
}


//@ requires Double.isFinite(a) && Double.isFinite(b);
public static void min_test_3(double a, double b) 
{
	double c = Math.min(5 * a - 4, -2 * b + 3);
	//@ assert c <= 5*a - 4 && c <= -2*b + 3;
	//@ assert c == 5*a - 4 || c == -2*b + 3;
}


public static void min_NaN_tests(double a, double b)
{
	double c = Math.min(Double.NaN, Double.NaN);
	//@ assert Double.isNaN(c);
	
	c = Math.min(Double.NaN, a);
	//@ assert Double.isNaN(c);
	
	c = Math.min(a, b);
	//@ assert (Double.isNaN(a) || Double.isNaN(b)) ==> Double.isNaN(c);
	//@ assert (!Double.isNaN(a) && !Double.isNaN(b)) ==> !Double.isNaN(c);
}

public static void min_inf_tests(double a, double b)
{
	double c = Math.min(Double.NEGATIVE_INFINITY, a);
	//@ assert Double.isInfinite(c);
	
	c = Math.min(Double.POSITIVE_INFINITY, a);
	//@ assert Double.isFinite(a) ==> Double.isFinite(c);
	//@ assert (a > Double.NEGATIVE_INFINITY) ==> Double.isFinite(c);

	c = Math.min(a, b);
	//@ assert (Double.isFinite(a) && Double.isFinite(b)) ==> Double.isFinite(c);
	//@ assert (Double.isInfinite(a) && Double.isInfinite(b)) ==> Double.isInfinite(c);
	//@ assert Double.isInfinite(c) ==> (Double.isInfinite(a) || Double.isInfinite(b));
}


// // Here we simply ensure that the output of the random call is >= 0 and < 1 as specified by java.lang.Math.random
//@ ensures 0.0 <= \result  &&  \result < 1.0;
public static double random_test_1()
{
	double a = Math.random();
	return a;
}

// //This is a slightly more complicated example involving Math.random that should still evaluate to true
//@ ensures -5.0 <= \result  &&  \result < 5.0;
public static double random_test_2()
{
        double a = Math.random();
	a = 10 * a;
	a = a - 5;
        return a;
}




//@ requires !Double.isNaN(a) && a != Double.NEGATIVE_INFINITY && a != Double.POSITIVE_INFINITY;
//@ ensures \result > a;
public static double nextUp_test_1(double a)
{
	double c = Math.nextUp(a);
	return c;
}


//@ requires !Double.isNaN(a) && a != Double.NEGATIVE_INFINITY && a != Double.POSITIVE_INFINITY;
//@ ensures \result == 0;
public static double nextUp_test_2(double a)
{
        double c = 0 + 0 * Math.nextUp(a);
        return c;
}



//@ requires !Double.isNaN(a) && a != Double.NEGATIVE_INFINITY && a != Double.POSITIVE_INFINITY;
//@ ensures \result < a;
public static double nextDown_test_1(double a)
{
	double c = Math.nextDown(a);
	return c;
}

//@ requires !Double.isNaN(a) && a != Double.NEGATIVE_INFINITY && a != Double.POSITIVE_INFINITY;
//@ ensures \result == 0;
public static double nextDown_test_2(double a)
{
        double c = 0 + 0 * Math.nextDown(a);
        return c;
}

//@ requires b > a;
//@ ensures \result > a;
public static double nextAfter_test_1(double a, double b)
{
	double c = Math.nextAfter(a, b);
	return c;
}

//@ ensures \result == 0;
public static double nextAfter_test_2(double a, double b)
{
        double c = Math.nextAfter(a, b);
	return 0 + c * 0;
}



//@ requires a > b;
//@ ensures \result < a;
public static double nextAfter_test_3(double a, double b)
{
        double c = Math.nextAfter(a, b);
        return c;
}



//@ requires a >= 0 && b >= 0;
//@ ensures \result >= 0;
public static double IEEEremainder_test_1(double a, double b)
{
	double c = Math.IEEEremainder(a, b);
	return c;
}

//@ ensures \result == 0;
public static double IEEEremainder_test_2(double a, double b)
{
        double c = Math.IEEEremainder(a, b);
	return 0 + c * 0;
}



//@ requires a > 0 && b < 0;
//@ ensures \result < 0;
public static double IEEEremainder_test_3(double a, double b)
{
        double c = Math.IEEEremainder(a, b);
        return c;
}



//@ requires a == 0.0;
public static void hypot_test_1(double a, double b)
{
	double c = Math.hypot(a, b);
	//@ assert c == b;
}

//@ requires a == 0.0 && b == 0.0;
public static void hypot_test_2(double a, double b)
{
        double c = Math.hypot(a, b);
	//@ assert c == 0.0;
}

//@ requires a == 1.0 && b == 0.0;
public static void hypot_test_3(double a, double b)
{
        double c = Math.hypot(a, b);
        //@ assert a == 1.0;
}


// If either argument is infinite, the result is positive infinity
public static void inf_test(double a, double b)
{
	double c = Math.hypot(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
	//@ assert Double.isInfinite(c);

	c = Math.hypot(a, Double.POSITIVE_INFINITY);
	//@ assert Double.isInfinite(c);
	
	c = Math.hypot(Double.POSITIVE_INFINITY, b);
	//@ assert Double.isInfinite(c);
	
	c = Math.hypot(a, Double.NEGATIVE_INFINITY);
	//@ assert Double.isInfinite(c);
	
	c = Math.hypot(Double.NEGATIVE_INFINITY, b);
	//@ assert Double.isInfinite(c);
	
	c = Math.hypot(a, b);
	//@ assert (Double.isInfinite(a) || Double.isInfinite(b)) ==> Double.isInfinite(c);
}

// If either argument is NaN and no arguments are infinite, the result is NaN
public static void nan_test(double a, double b)
{
	double c = Math.hypot(Double.NaN, Double.NaN);
	//@ assert Double.isNaN(c);
	
	c = Math.hypot(a, Double.NaN);
	//@ assert !Double.isInfinite(a) ==> Double.isNaN(c);
	
	c = Math.hypot(Double.NaN, b);
	//@ assert !Double.isInfinite(b) ==> Double.isNaN(c);
	
	c = Math.hypot(a, b);
	//@ assert ( (Double.isNaN(a) || Double.isNaN(b)) &&  !Double.isInfinite(a) && !Double.isInfinite(b) )  ==> Double.isNaN(c);
}



}
