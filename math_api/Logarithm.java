public class Logarithm
{
  //@ requires Math.isFinite(a);
  public static void logTest(double a)
  {
    double result = Math.log(a);
    //@ assert ((Double.compare(a, 0.0) == 0) || (Double.compare(a, -0.0) == 0)) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, 0.0) == 1) ==> Math.isFinite(result);
  }

  //@ requires ! Math.isFinite(a);
  public static void logTestAnomalies(double a)
  {
    double result = Math.log(a);
    //@ assert Double.isNaN(a) || (Double.compare(a, -0.0) == -1) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
  }

  //@ requires Math.isFinite(a);
  public static void log10Test(double a)
  {
    double result = Math.log10(a);
    //@ assert (Double.compare(a, 0.0) == 0) || (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, -0.0) == -1) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, 0.0) == 1) && (Double.compare(a, Double.POSITIVE_INFINITY) == -1) ==> Math.isFinite(result);
  }

  //@ requires ! Math.isFinite(a);
  public static void log10TestAnomalies(double a)
  {
    double result = Math.log10(a);
    //@ assert Double.isNaN(a) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> Double.isNaN(result);
  }

  //@ requires ! Math.isFinite(a);
  public static void log1pTest(double a)
  {
    
  }
}
