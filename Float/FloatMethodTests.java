/*
THIS PROGRAM TESTS THE FOLLOWING METHODS FROM java.lang.Float:

Float.isInfinite(float a)
Float.isNaN(float a)
.isNaN()
.longValue()
Float.max(float f1, float f2)
Float.floatToIntBits(float f)
*/



public class FloatMethodTests
{
  public static void isInfiniteTest(float a)
  {
    boolean result = Float.isInfinite(a);
    //@ assert (Float.compare(a, Float.POSITIVE_INFINITY) == 0) ==> (result == true);
    //@ assert (Float.compare(a, Float.NEGATIVE_INFINITY) == 0) ==> (result == true);
    // if we've gotten to this point, a is finite
    //@ assert result == false;
  }

  public static void isNaNTestInstance(float a)
  {
    Float instance = a;
    boolean result = instance.isNaN();
    //@ assert Float.isFinite(a) ==> (result == false);
    //@ assert (Float.floatToIntBits(a) == 0x7fc00000) ==> (result == true);
  }

  public static void isNaNTestStatic(float a)
  {
    boolean result = Float.isNaN(a);
    //@ assert Float.isFinite(a) ==> (result == false);
    //@ assert (Float.floatToIntBits(a) == 0x7fc00000) ==> (result == true);
  }

  public static void longValueTest(float a)
  {
    Float instance = a;
    long result = instance.longValue();
    // figure out how to assert expected values
  }

  //@ requires Math.isFinite(a) && Math.isFinite(b);
  public static void maxTest(float a, float b)
  {
    float result = Float.max(a, b);
    //@ assert (Float.compare(a, b) >= 0) ==> (Float.compare(result, a) == 0);
    //@ assert (Float.compare(a, b) < 0) ==> (Float.compare(result, b) == 0);
  }

  //@ requires !Math.isFinite(a) && Math.isFinite(b);
  public static void maxTestAAnomalies(float a, float b)
  {
    float result = Float.max(a, b);
    //@ assert (Float.isNaN(a)) ==> (Float.compare(result, b) == 0);
    //@ assert (Float.compare(a, Float.POSITIVE_INFINITY) == 0) ==> (Float.compare(result, a) == 0);
    //@ assert (Float.compare(a, Float.NEGATIVE_INFINITY) == 0) ==> (Float.compare(result, b) == 0);
  }

  //@ requires Math.isFinite(a) && !Math.isFinite(b);
  public static void maxTestBAnomalies(float a, float b)
  {
    float result = Float.max(a, b);
    //@ assert (Float.isNaN(b)) ==> (Float.compare(result, a) == 0);
    //@ assert (Float.compare(b, Float.POSITIVE_INFINITY) == 0) ==> (Float.compare(result, b) == 0);
    //@ assert (Float.compare(b, Float.NEGATIVE_INFINITY) == 0) ==> (Float.compare(result, a) == 0);
  }

  //@ requires !Math.isFinite(a) && !Math.isFinite(b);
  public static void maxTestBothAnomalies(float a, float b)
  {
    float result = Float.max(a, b);
    //@ assert (Float.isNaN(a) && Float.isNaN(b)) ==> (Float.isNaN(result));
    //@ assert (Float.isNaN(a) && !Float.isNaN(b)) ==> (Float.compare(b, result) == 0);
    //@ assert (!Float.isNaN(a) && Float.isNaN(b)) ==> (Float.compare(a, result) == 0);
    //@ assert ((Float.compare(a, Float.POSITIVE_INFINITY) == 0) && (Float.compare(b, Float.POSITIVE_INFINITY) == 0)) ==> (Float.compare(result, Float.POSITIVE_INFINITY) == 0);
    //@ assert ((Float.compare(a, Float.POSITIVE_INFINITY) == 0) && (Float.compare(b, Float.NEGATIVE_INFINITY) == 0)) ==> (Float.compare(result, Float.POSITIVE_INFINITY) == 0);
    //@ assert ((Float.compare(a, Float.NEGATIVE_INFINITY) == 0) && (Float.compare(b, Float.NEGATIVE_INFINITY) == 0)) ==> (Float.compare(result, Float.NEGATIVE_INFINITY) == 0);
    //@ assert ((Float.compare(a, Float.NEGATIVE_INFINITY) == 0) && (Float.compare(b, Float.POSITIVE_INFINITY) == 0)) ==> (Float.compare(result, Float.POSITIVE_INFINITY) == 0);
  }
}
