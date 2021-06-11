public class Exponentiation
{
	//@ requires Math.isFinite(a);
	public static void sqrtTest(double a)
	{
		double c = Math.sqrt(a);
		//@ assert (a > 0.0) ==> (Math.isFinite(a));
		//@ assert (a < 0.0) ==> (Double.isNaN(c));
	}

	//@ requires Math.isFinite(a);
	public static void cbrtTest(double a)
	{
		double c = Math.cbrt(a);
		//@ assert Math.isFinite(c);
	}

	//@ requires Math.isFinite(a);
	public static void expTest(double a)
	{
		double c = Math.exp(a);
		//@ assert Math.isFinite(c);
	}

	//@ requires Math.isFinite(a);
	public static void expm1(double a)
	{
		double c = Math.expm1(a);
		//@ assert Math.isFinite(c);
	}

	//@ requires Math.isFinite(a);
	public static void getExponent(double a)
	{
		double c = Math.getExponent(a);
		//@ assert Math.isFinite(c);
	}

	//@ requires Math.isFinite(a) && Math.isFinite(b);
	public static void pow(double a, double b)
	{
		double c = Math.pow(a, b);
		//@ assert Math.isFinite(c);
	}
}