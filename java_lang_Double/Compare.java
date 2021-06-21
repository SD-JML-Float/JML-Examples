public class Compare
{
  public static void compare_finite()
  {
    //@ assert Double.compare(0.0, 0.0) == 0;
    //@ assert Double.compare(0.0, 1.0) < 0;
    //@ assert Double.compare(0.0, -1.0) > 0;
    //@ assert Double.compare(0.0, Double.MAX_VALUE) < 0;
    //@ assert Double.compare(0.0, Double.MIN_VALUE) < 0;
    //@ assert Double.compare(0.0, -Double.MAX_VALUE) > 0;
    //@ assert Double.compare(0.0, -Double.MIN_VALUE) > 0;
    //@ assert Double.compare(Double.MAX_VALUE, Double.MIN_VALUE) > 0;
  }

  public static void compare_infinites()
  {
    //@ assert Double.compare(0.0, Double.POSITIVE_INFINITY) < 0;
    //@ assert Double.compare(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY) == 0;
    //@ assert Double.compare(Double.NaN, Double.NaN) == 0;
    //@ assert Double.compare(Double.NaN, 0.0) > 0;
    //@ assert Double.compare(Double.NaN, Double.POSITIVE_INFINITY) > 0;
    //@ assert Double.compare(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY) == 0;
    //@ assert Double.compare(Double.NEGATIVE_INFINITY, 0.0) < 0;
    //@ assert Double.compare(Double.NEGATIVE_INFINITY, Double.NaN) < 0;
  }

  public static void compare_zeros()
  {
    //@ assert Double.compare(0.0, -0.0) > 0;
    //@ assert Double.compare(-0.0, 0.0) < 0;
    //@ assert Double.compare(0.0, 0.0) == 0;
    //@ assert Double.compare(-0.0, -0.0) == 0;
  }
}
