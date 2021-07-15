public class Sign
{

	//@ requires Double.isFinite(a);
	public static void absTestFloat(float a)
	{
		float result = Math.abs(a);
		//@ assert Double.isFinite(result);
		//@ assert (Float.compare(result, 0.0f) >= 0);
	}

	//@ requires ! Double.isFinite(a);
	public static void absTestAnomaliesFloat(float a)
	{
		float result = Math.abs(a);
		//@ assert ((Float.compare(a, Float.POSITIVE_INFINITY) == 0) || (Float.compare(a, Float.NEGATIVE_INFINITY) == 0)) ==> (Float.compare(result, Float.POSITIVE_INFINITY) == 0);
		//@ assert Float.isNaN(a) ==> Float.isNaN(result);
	}

	//@ requires Double.isFinite(a);
	public static void absTestDouble(double a)
	{
		double result = Math.abs(a);
		//@ assert Double.isFinite(result);
		//@ assert (Double.compare(result, 0.0) >= 0);
	}

	//@ requires ! Double.isFinite(a);
	public static void absTestAnomaliesDouble(double a)
	{
		double result = Math.abs(a);
		//@ assert ((Double.compare(a, Double.POSITIVE_INFINITY) == 0) || (Double.compare(a, Double.NEGATIVE_INFINITY) == 0)) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
		//@ assert Double.isNaN(a) ==> Double.isNaN(result);
	}

	/**
	 * Does not get anomaly testing due to either/or behavior with NaN
	 * See: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#copySign-float-float-
	 */
	//@ requires Double.isFinite(magnitude) && Double.isFinite(sign);
	public static void copySignTestFloat(float magnitude, float sign)
	{
		float result = Math.copySign(magnitude, sign);
		//@ assert Double.isFinite(result);
		//@ assert (sign < 0.0f) && (magnitude > 0.0f) ==> (Float.compare(magnitude, result) == 0);
		//@ assert (sign < 0.0f) && (magnitude < 0.0f) ==> (Float.compare(magnitude, result) == 0);
		//@ assert (sign > 0.0f) && (magnitude < 0.0f) ==> (Float.compare(-magnitude, result) == 0);
		//@ assert (sign > 0.0f) && (magnitude > 0.0f) ==> (Float.compare(magnitude, result) == 0);
	}

	/**
	 * Does not get anomaly testing due to either/or behavior with NaN.
	 * See: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#copySign-double-double-
	 */
	//@ requires Double.isFinite(magnitude) && Double.isFinite(sign);
	public static void copySignTestDouble(double magnitude, double sign)
	{
		double result = Math.copySign(magnitude, sign);
		//@ assert Double.isFinite(result);
		//@ assert (sign < 0.0) && (magnitude > 0.0) ==> (Double.compare(magnitude, result) == 0);
		//@ assert (sign < 0.0) && (magnitude < 0.0) ==> (Double.compare(magnitude, result) == 0);
		//@ assert (sign > 0.0) && (magnitude < 0.0) ==> (Double.compare(-magnitude, result) == 0);
		//@ assert (sign > 0.0) && (magnitude > 0.0) ==> (Double.compare(magnitude, result) == 0);
	}

	//@ requires Double.isFinite(a);
	public static void signumTestFloat(float a)
	{
		float result = Math.signum(a);
		//@ assert Double.isFinite(result);
		//@ assert (Float.compare(a, 0.0f) == 0) ==> (Float.compare(result, 0.0f) == 0);
		//@ assert (Float.compare(a, -0.0f) == 0) ==> (Float.compare(result, -0.0f) == 0);
		//@ assert (a < 0.0f) ==> (Float.compare(result, -1.0f) == 0);
		//@ assert (a > 0.0f) ==> (Float.compare(result, 1.0f) == 0);
	}

	//@ requires ! Double.isFinite(a);
	public static void signumTestAnomaliesFloat(float a)
	{
		float result = Math.signum(a);
		//@ assert Float.isNaN(a) ==> Float.isNaN(result);
		//@ assert (Float.compare(a, Float.POSITIVE_INFINITY) == 0) ==> (Float.compare(result, Float.POSITIVE_INFINITY) == 0);
		//@ assert (Float.compare(a, Float.NEGATIVE_INFINITY) == 0) ==> (Float.compare(result, Float.NEGATIVE_INFINITY) == 0);
	}

	//@ requires Double.isFinite(a);
	public static void signumTestDouble(double a)
	{
		double result = Math.signum(a);
		//@ assert Double.isFinite(result);
		//@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(result, 0.0) == 0);
		//@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, -0.0) == 0);
		//@ assert (a < 0.0) ==> (Double.compare(result, -1.0) == 0);
		//@ assert (a > 0.0) ==> (Double.compare(result, 1.0) == 0);
	}

	//@ requires ! Double.isFinite(a);
	public static void signumTestAnomaliesDouble(double a)
	{
		double result = Math.signum(a);
		//@ assert Double.isNaN(a) ==> Double.isNaN(result);
		//@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
		//@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
	}
}
