public class CopySign
{
  /**
   * @requires (Math.isFinite(magnitude)) && (! Float.NaN(sign))
   * 
   * Need to figure out how to include if/else in result
   */
  public static float copySignFloat(float magnitude, float sign)
  {
    return Math.copySign(magnitude, sign);
  }

  /**
   * @requires (Math.isFinite(magnitude)) && (! Double.NaN(sign))
   * 
   * Need to figure out how to include if/else in result
   */
  public static double copySignDouble(double magnitude, double sign)
  {
    return Math.copySign(magnitude, sign);
  }
}
