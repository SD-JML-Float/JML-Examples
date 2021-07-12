/*
THIS PROGRAM TESTS THE FOLLOWING METHODS FROM java.lang.Double:

Double.isInfinite(double d)
Double.isFinite(double d)
Double.isNaN(double d)
Double.longBitsToDouble(double d)
.longBitsToDouble()
.longValue()
Double.max(double d1, double d2)
*/



public class DoubleMethodTests
{
  //@ requires Math.isFinite(a);
  public static void isInfiniteTest(double a)
  {
    boolean staticResult = Double.isInfinite(a);
    Double instance = a;
    boolean instanceResult = instance.isInfinite();
    //@ assert staticResult == false;
    //@ assert instanceResult == false;
  }

  //@ requires !Math.isFinite(a);
  public static void isInfiniteTestAnomalies(double a)
  {
    boolean staticResult = Double.isFinite(a);
    Double instance = a;
    boolean instanceResult = instance.isInfinite();
    //@ assert Double.isNaN(a) ==> (staticResult == false);
    //@ assert !Double.isNaN(a) ==> (staticResult == true);
    //@ assert instance.isNaN() ==> (instanceResult == false);
    //@ assert !instance.isNaN() ==> (instanceResult == true);
  }

  //@ requires Math.isFinite(a);
  public static void isNaNTest(double a)
  {
    boolean staticResult = Double.isNaN(a);
    Double instance = a;
    boolean instanceResult = instance.isNaN();
    //@ assert staticResult == false;
    //@ assert instanceResult == false;
  }

  //@ requires !Math.isFinite(a);
  public static void isNaNTestAnomalies(double a)
  {
    boolean staticResult = Double.isNaN(a);
    Double instance = a;
    boolean instanceResult = instance.isNaN();
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (staticResult == false);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (staticResult == false);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (instanceResult == false);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (instanceResult == false);
    // If we've reached this point, a must be NaN
    //@ assert staticResult == true;
    //@ assert instanceResult == true;
  }

  //@ requires Math.isFinite(a);
  public static void longBitsToDoubleTest(long a)
  {
    double staticResult = Double.longBitsToDouble(a);
    Double instance = 0.0;
    double instanceResult = instance.longBitsToDouble(a);
    //@ assert (a == 0x7ff8000000000000L) ==> Double.isNaN(staticResult);
    //@ assert (a == 0x7ff8000000000000L) ==> Double.isNaN(instanceResult);
    //@ assert (a == 0x7ff0000000000000L) ==> (Double.compare(staticResult, Double.POSITIVE_INFINITY) == 0);
    //@ assert (a == 0x7ff0000000000000L) ==> (Double.compare(instanceResult, Double.POSITIVE_INFINITY) == 0);
    //@ assert (a == 0xfff0000000000000L) ==> (Double.compare(staticResult, Double.NEGATIVE_INFINITY) == 0);
    //@ assert (a == 0xfff0000000000000L) ==> (Double.compare(instanceResult, Double.NEGATIVE_INFINITY) == 0);
  }

  //@ requires Math.isFinite(a);
  public static void longValueTest(double a)
  {
    Double instance = a;
    long instanceResult = instance.longValue();
    //@ assert instanceResult == Double.doubleToLongBits(a);
  }

  //@ requires !Math.isFinite(a);
  public static void longValueTestAnomalies(double a)
  {
    Double instance = a;
    long instanceResult = instance.longValue();
    //@ assert Double.isNaN(a) ==> (instanceResult == 0x7FF8000000000000L);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (instanceResult == 0x7ff0000000000000L);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (instanceResult == 0xfff0000000000000L);
  }

  //@ requires Math.isFinite(a) && Math.isFinite(b);
  public static void maxTest(double a, double b)
  {
    double result = Double.max(a, b);
    //@ assert (Double.compare(a, b) >= 0) ==> (Double.compare(result, a) == 0);
    //@ assert (Double.compare(a, b) < 0) ==> (Double.compare(result, b) == 0);
  }

  //@ requires !Math.isFinite(a) && Math.isFinite(b);
  public static void maxTestAAnomalies(double a, double b)
  {
    double result = Double.max(a, b);
    //@ assert (Double.isNaN(a)) ==> (Double.compare(result, b) == 0);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, a) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, b) == 0);
  }

  //@ requires Math.isFinite(a) && !Math.isFinite(b);
  public static void maxTestBAnomalies(double a, double b)
  {
    double result = Double.max(a, b);
    //@ assert (Double.isNaN(b)) ==> (Double.compare(result, a) == 0);
    //@ assert (Double.compare(b, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, b) == 0);
    //@ assert (Double.compare(b, Double.NEGATIVE_INFINITY) == 0) ==> (Double.compare(result, a) == 0);
  }

  //@ requires !Math.isFinite(a) && !Math.isFinite(b);
  public static void maxTestBothAnomalies(double a, double b)
  {
    double result = Double.max(a, b);
    //@ assert (Double.isNaN(a) && Double.isNaN(b)) ==> (Double.isNaN(result));
    //@ assert (Double.isNaN(a) && !Double.isNaN(b)) ==> (Double.compare(b, result) == 0);
    //@ assert (!Double.isNaN(a) && Double.isNaN(b)) ==> (Double.compare(a, result) == 0);
    //@ assert ((Double.compare(a, Double.POSITIVE_INFINITY) == 0) && (Double.compare(b, Double.POSITIVE_INFINITY) == 0)) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
    //@ assert ((Double.compare(a, Double.POSITIVE_INFINITY) == 0) && (Double.compare(b, Double.NEGATIVE_INFINITY) == 0)) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
    //@ assert ((Double.compare(a, Double.NEGATIVE_INFINITY) == 0) && (Double.compare(b, Double.NEGATIVE_INFINITY) == 0)) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
    //@ assert ((Double.compare(a, Double.NEGATIVE_INFINITY) == 0) && (Double.compare(b, Double.POSITIVE_INFINITY) == 0)) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
  }
}
