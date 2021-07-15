public class Exponentiation
{

	//@ requires Double.isFinite(a);
	public static void sqrtTest(double a)
	{
		double result = Math.sqrt(a);
		//@ assert (Double.compare(a, 0.0) >= 0) ==> (Double.isFinite(a) && (Double.compare(result, 0.0) >= 0));
		//@ assert (Double.compare(a, -0.0) <= 0) ==> Double.isNaN(result);
	}

	//@ requires ! Double.isFinite(a);
	public static void sqrtTestAnomalies(double a)
	{
		double result = Math.sqrt(a);
		//@ assert (Double.isNaN(a) || (Double.compare(a, Double.NEGATIVE_INFINITY) == 0)) ==> Double.isNaN(result);
		//@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
	}

	//@ requires Double.isFinite(a);
	public static void cbrtTest(double a)
	{
		double result = Math.cbrt(a);
		//@ assert Double.isFinite(result);
	}

	//@ requires ! Double.isFinite(a);
	public static void cbrtTestAnomalies(double a)
	{
		double result = Math.cbrt(a);
		//@ assert Double.isNaN(a) ==> Double.isNaN(result);
		//@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
		//@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
	}

	//@ requires Double.isFinite(a);
	public static void expTest(double a)
	{
		double result = Math.exp(a);
		//@ assert Double.isFinite(result);
	}

	//@ requires ! Double.isFinite(a);
	public static void expTestAnomalies(double a)
	{
		double result = Math.exp(a);
		//@ assert Double.isNaN(a) ==> Double.isNaN(result);
		//@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
		//@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, 0.0) == 0);
	}

	//@ requires Double.isFinite(a);
	public static void expm1Test(double a)
	{
		double result = Math.expm1(a);
		//@ assert Double.isFinite(result);
		//@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(a, 0.0) == 0);
		//@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(a, -0.0) == 0);
	}

	//@ requires ! Double.isFinite(a);
	public static void exmp1TestAnomalies(double a)
	{
		double result = Math.expm1(a);
		//@ assert Double.isNaN(a) ==> Double.isNaN(result);
		//@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
		//@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, -1.0)) == 0;
	}

	//@ requires Double.isFinite(a);
	public static void getExponentTest(double a)
	{
		double result = Math.getExponent(a);
		//@ assert Double.isFinite(result);
		//@ assert (Double.compare(a, 0.0) == 0) || (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, Double.MIN_EXPONENT - 1.0) == 0);
	}

	//@ requires ! Double.isFinite(a);
	public static void getExponentTestAnomalies(double a)
	{
		double result = Math.getExponent(a);
		//@ assert Double.isNaN(a) ==> (Double.compare(result, Double.MAX_EXPONENT - 1.0) == 0);
		//@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.MAX_EXPONENT + 1) == 0);
		//@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, Double.MAX_EXPONENT + 1) == 0);
	}

	//@ requires Double.isFinite(a) && Double.isFinite(b);
	public static void powTest(double a, double b)
	{
		double result = Math.pow(a, b);
		//@ assert Double.isFinite(result);
	}
}
