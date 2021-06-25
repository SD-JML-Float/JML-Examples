public class Abs
{
  /**
   * @requires (Math.isFinite(num));
   * @ensures \result = Math.abs(num);
   */
  public static float absFloat(float num)
  {
    return Math.abs(num);
  }

  /**
   * @requires (Math.isInfinite(num));
   * @ensures Math.isInfinite(\result);
   */
  public static float absFloatInfinite(float num)
  {
    return Math.abs(num);
  }

  /**
   * @requires (Float.NaN(num));
   * @ensures \result = Float.NaN;
   */
  public static float absFloatNaN(float num)
  {
    return Math.abs(num);
  }

  /**
   * @requires (Math.isFinite(num));
   * @ensures \result = Math.abs(num);
   */
  public static double absDouble(double num)
  {
    return Math.abs(num);
  }

  /**
   * @requires (Math.isInfinite(num));
   * @ensures Math.isInfinite(\result);
   */
  public static double absDoubleInfinite(double num)
  {
    return Math.abs(num);
  }

  /**
   * @requires (Double.NaN(num));
   * @ensures \result = Double.NaN;
   */
  public static double absDoubleNaN(double num)
  {
    return Math.abs(num);
  }
}
