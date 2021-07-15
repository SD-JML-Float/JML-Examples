public class AdjacencyOps
{


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


}
