public class SigNum
{
  /**
   * @requires Math.isFinite(num)
   * @result num > 0.0f ==> \result == 1.0f;
   * @result num < -0.0f ==> \result == -1.0f;
   */
  public static float sigNumFloat(float num)
  {
    return Math.signum(num);
  }

  /**
   * @ensures \result == Float.NaN;
   */
  public static float sigNumFloatNaN()
  {
    return Math.signum(Float.NaN);
  }

  /**
   * @ensures \result == -0.0f;
   */
  public static float sigNumFloatNegativeZero()
  {
    return Math.signum(-0.0f);
  }

  /**
   * @ensures \result == 0.0f;
   */
  public static float sigNumFloatPositiveZero()
  {
    return Math.signum(0.0f);
  }

  /**
   * @requires Math.isFinite(num)
   * @result num > 0.0 ==> \result == 1.0;
   * @result num < -0.0 ==> \result == -1.0;
   */
  public static double sigNumDouble(double num)
  {
    return Math.signum(num);
  }

  /**
   * @ensures \result == Double.NaN;
   */
  public static double sigNumDoubleNaN()
  {
    return Math.signum(Double.NaN);
  }

  /**
   * @ensures \result == -0.0f;
   */
  public static double sigNumDoubleNegativeZero()
  {
    return Math.signum(-0.0);
  }

  /**
   * @ensures \result == 0.0f;
   */
  public static double sigNumDoublePositiveZero()
  {
    return Math.signum(0.0);
  }
}
