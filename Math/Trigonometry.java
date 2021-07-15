public class Trigonometry
{

  //@ requires Double.isFinite(a);
  public static void acosTest(double a)
  {
    double result = Math.acos(a);
    //@ assert ((Double.compare(a, 1.0) <= 0) && (Double.compare(a, -1.0) >= 0)) ==> !Double.isNaN(result);
    //@ assert ((Double.compare(a, 1.0) >= 0) && (Double.compare(a, -1.0) <= 0)) ==> Double.isNaN(result);
  }

  //@ requires !Double.isFinite(a);
  public static void acosTestAnomalies(double a)
  {
    double result = Math.acos(a);
    //@ assert Double.isNaN(result);
  }

  //@ requires Double.isFinite(a);
  public static void asinTest(double a)
  {
    double result = Math.asin(a);
    //@ assert ((Double.compare(a, 0.0) != 0) && (Double.compare(a, -0.0) != 0)) && ((Double.compare(a, 1.0) <= 0) && (Double.compare(a, -1.0) >= 0)) ==> !Double.isNaN(result);
    //@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(result, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(a, -0.0) == 0);
    //@ assert ((Double.compare(a, 1.0) >= 0) && (Double.compare(a, -1.0) <= 0)) ==> Double.isNaN(result);
  }

  //@ requires !Double.isFinite(a);
  public static void asinTestAnomalies(double a)
  {
    double result = Math.asin(a);
    //@ assert Double.isNaN(result);
  }

  //@ requires Double.isFinite(a);
  public static void atanTest(double a)
  {
    double result = Math.atan(a);
    //@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(a, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(a, -0.0) == 0);
    //@ assert Double.isFinite(result);
  }

  //@ requires !Double.isFinite(a);
  public static void atanTestAnomalies(double a)
  {
    double result = Math.atan(a);
    //@ assert Double.isNaN(a) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
  }

  //@ requires Double.isFinite(a) && Double.isFinite(b);
  public static void atan2Test(double a, double b)
  {
    double result = Math.atan2(a, b);
    //@ assert (Double.compare(a, 0.0) == 0) && (Double.compare(b, 0.0) > 0) ==> (Double.compare(result, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) && (Double.compare(b, 0.0) > 0) ==> (Double.compare(result, -0.0) == 0);
    //@ assert (Double.compare(a, 0.0) == 0) && (Double.compare(b, -0.0) < 0) ==> (Double.compare(result, Math.PI) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) && (Double.compare(b, -0.0) < 0) ==> (Double.compare(result, -Math.PI) == 0);
    //@ assert (Double.compare(a, 0.0) > 0) && ((Double.compare(b, 0.0) == 0) || (Double.compare(b, -0.0) == 0)) ==> (Double.compare(result, Math.PI / 2.0) == 0);
    //@ assert (Double.compare(a, -0.0) < 0) && ((Double.compare(b, 0.0) == 0) || (Double.compare(b, -0.0) == 0)) ==> (Double.compare(result, -Math.PI / 2.0) == 0);
  }

  //@ requires !Double.isFinite(a) && Double.isFinite(b);
  public static void atan2TestAAnomalies(double a, double b)
  {
    double result = Math.atan2(a, b);
    //@ assert Double.isNaN(a) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Math.PI / 2.0) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, -Math.PI / 2.0) == 0);
  }

  //@ requires Double.isFinite(a) && !Double.isFinite(b);
  public static void atan2TestBAnomailes(double a, double b)
  {
    double result = Math.atan2(a, b);
    //@ assert Double.isNaN(b) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, 0.0) > 0) && (Double.compare(b, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) < 0) && (Double.compare(b, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, -0.0) == 0);
    //@ assert (Double.compare(a, 0.0) > 0) && (Double.compare(b, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, Math.PI) == 0);
    //@ assert (Double.compare(a, -0.0) < 0) && (Double.compare(b, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, -Math.PI) == 0);
  }

  //@ requires !Double.isFinite(a) && !Double.isFinite(b);
  public static void atan2TestBothAnomailes(double a, double b)
  {
    double result = Math.atan2(a, b);
    //@ assert (Double.isNaN(a) || Double.isNaN(b)) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) && (Double.compare(b, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Math.PI / 4.0) == 0);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) && (Double.compare(b, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, 3.0 * (Math.PI / 4.0)) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) && (Double.compare(b, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, -Math.PI / 4.0) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) && (Double.compare(b, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, 3.0 * (-Math.PI / 4.0)) == 0);
  }

  //@ requires Double.isFinite(a);
  public static void cosTest(double a)
  {
    double result = Math.cos(a);
    //@ assert Double.isFinite(result) && ((Double.compare(result, 1.0) <= 0) || (Double.compare(result, -1.0) >= 0));
  }

  //@ requires !Double.isFinite(a);
  public static void cosTestAnomalies(double a)
  {
    double result = Math.cos(a);
    // result should be NaN in all cases of non-real input
    //@ assert Double.isNaN(result);
  }

  //@ requires Double.isFinite(a);
  public static void coshTest(double a)
  {
    double result = Math.cosh(a);
    //@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(result, 1.0) == 0);
    //@ assert Double.isFinite(result);
  }

  //@ requires !Double.isFinite(a);
  public static void coshTestAnomalies(double a)
  {
    double result = Math.cosh(a);
    //@ assert Double.isNaN(a) ==> Double.isNaN(result);
    //@ assert !Double.isFinite(a) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
  }

  //@ requires Double.isFinite(a);
  public static void sinTest(double a)
  {
    double result = Math.sin(a);
    //@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(result, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, -0.0) == 0);
    //@ assert Double.isFinite(result);
  }

  //@ requires !Double.isFinite(a);
  public static void sinTestAnomalies(double a)
  {
    double result = Math.sin(a);
    // result should be NaN in all cases of non-real input
    //@ assert Double.isNaN(result);
  }

  //@ requires Double.isFinite(a);
  public static void sinhTest(double a)
  {
    double result = Math.sinh(a);
    //@ assert Double.isFinite(result);
    //@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(result, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, -0.0) == 0);
  }

  //@ requires !Double.isFinite(a);
  public static void sinhTestAnomalies(double a)
  {
    double result = Math.sinh(a);
    //@ assert Double.isNaN(a) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
  }

  //@ requires Double.isFinite(a);
  public static void tanTest(double a)
  {
    double result = Math.tan(a);
    //@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(result, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, -0.0) == 0);
  }

  //@ requires !Double.isFinite(a);
  public static void tanTestAnomalies(double a)
  {
    double result = Math.tan(a);
    // result should be NaN in all cases of non-real input
    //@ assert Double.isNaN(result);
  }

  //@ requires Double.isFinite(a);
  public static void tanhTest(double a)
  {
    double result = Math.tanh(a);
    //@ assert (Double.compare(a, 0.0) == 0) ==> (Double.compare(result, 0.0) == 0);
    //@ assert (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, -0.0) == 0);
  }

  //@ requires !Double.isFinite(a);
  public static void tanhTestAnomalies(double a)
  {
    double result = Math.tanh(a);
    //@ assert Double.isNaN(a) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, 1.0) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, -1.0) == 0);
  }

  //@ requires Double.isFinite(a);
  public static void toDegreesTest(double a)
  {
    double result = Math.toDegrees(a);
    //@ assert Double.isFinite(result);
  }

  //@ requires Double.isFinite(a);
  public static void toRadiansTest(double a)
  {
    double result = Math.toRadians(a);
    //@ assert Double.isFinite(result);
  }
}
