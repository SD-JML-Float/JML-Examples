public class Compare
{
  public static void compare_finite()
  {
    //@ assert Float.compare(0.0, 0.0) == 0;
    //@ assert Float.compare(0.0, 1.0) < 0;
    //@ assert Float.compare(0.0, -1.0) > 0;
    //@ assert Float.compare(0.0, Float.MAX_VALUE) < 0;
    //@ assert Float.compare(0.0, Float.MIN_VALUE) < 0;
    //@ assert Float.compare(0.0, -Float.MAX_VALUE) > 0;
    //@ assert Float.compare(0.0, -Float.MIN_VALUE) > 0;
    //@ assert Float.compare(Float.MAX_VALUE, Float.MIN_VALUE) > 0;
  }

  public static void compare_infinites()
  {
    //@ assert Float.compare(0.0, Float.POSITIVE_INFINITY) < 0;
    //@ assert Float.compare(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY) == 0;
    //@ assert Float.compare(Float.NaN, Float.NaN) == 0;
    //@ assert Float.compare(Float.NaN, 0.0) > 0;
    //@ assert Float.compare(Float.NaN, Float.POSITIVE_INFINITY) > 0;
    //@ assert Float.compare(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY) == 0;
    //@ assert Float.compare(Float.NEGATIVE_INFINITY, 0.0) < 0;
    //@ assert Float.compare(Float.NEGATIVE_INFINITY, Float.NaN) < 0;
  }

  public static void compare_zeros()
  {
    //@ assert Float.compare(0.0, -0.0) > 0;
    //@ assert Float.compare(-0.0, 0.0) < 0;
    //@ assert Float.compare(0.0, 0.0) == 0;
    //@ assert Float.compare(-0.0, -0.0) == 0;
  }
}
