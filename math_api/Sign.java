public class Sign
{
	//@ requires Math.isFinite(a);
	public static void absTestFloat(float a)
	{
		float c = Math.abs(a);
		//@ assert Math.isFinite(c);
		//@ assert (a > 0.0f) ==> (c > 0.0f);
		//@ assert (a < 0.0f) ==> (c > 0.0f);
	}

	//@ requires Math.isFinite(a);
	public static void absTestsDouble(double a)
	{
		double c = Math.abs(a);
		//@ assert Math.isFinite(c);
		//@ assert (a > 0.0) ==> (c > 0.0);
		//@ assert (a < 0.0) ==> (c > 0.0);
	}

	//@ requires Math.isFinite(a) && Math.isFinite(b);
	public static void copySignTestFloat(float a, float b)
	{
		float c = Math.copySign(a, b);
		//@ assert Math.isFinite(c);
		//@ assert (b < 0.0f) && (a > 0.0f) ==> (Float.compare(a, c) == 0);
		//@ assert (b < 0.0f) && (a < 0.0f) ==> (Float.compare(a, c) == 0);
		//@ assert (b > 0.0f) && (a < 0.0f) ==> (Float.compare(-a, c) == 0);
		//@ assert (b > 0.0f) && (a > 0.0f) ==> (Float.compare(a, c) == 0);
	}

	//@ requires Math.isFinite(a) && Math.isFinite(b);
	public static void copySignTestDouble(double a, double b)
	{
		double c = Math.copySign(a, b);
		//@ assert Math.isFinite(c);
		//@ assert (b < 0.0) && (a > 0.0) ==> (Double.compare(a, c) == 0);
		//@ assert (b < 0.0) && (a < 0.0) ==> (Double.compare(a, c) == 0);
		//@ assert (b > 0.0) && (a < 0.0) ==> (Double.compare(-a, c) == 0);
		//@ assert (b > 0.0) && (a > 0.0) ==> (Double.compare(a, c) == 0);
	}

	//@ requries Math.isFinite(a);
	public static void signumTestFloat(float a)
	{
		float c = Math.signum(a);
		//@ assert Math.isFinite(c);
		//@ assert (Float.compare(a, 0.0f) == 0) ==> (Float.compare(c, 0.0f) == 0);
		//@ assert (a < 0.0f) ==> (Float.compare(c, -1.0f) == 0);
		//@ assert (a > 0.0f) ==> (Float.compare(c, 1.0f) == 0);
	}

	//@ requries Math.isFinite(a);
	public static void signumTestDouble(double a)
	{
		double c = Math.signum(a);
		//@ assert Math.isFinite(c);
		//@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(c, 0.0) == 0);
		//@ assert (a < 0.0) ==> (Double.compare(c, -1.0) == 0);
		//@ assert (a > 0.0) ==> (Double.compare(c, 1.0) == 0);
	}
}