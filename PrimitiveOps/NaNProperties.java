public /*@ pure @*/ class NaNProperties
{
    // compare constants to NaN values
    public static void constant_properties()
    {
      //@ assert !Double.isNaN(0.0);
      //@ assert 0.0 != Double.NaN;
      //@ assert Double.NaN != 0.0;
      //@ assert !(0.0 < Double.NaN);
      //@ assert !(0.0 > Double.NaN);
      //@ assert !(Double.NaN < 0.0);
      //@ assert !(Double.NaN > 0.0);
    }

    public static void comparisons(double a)
    {
      //@ assert a != Double.NaN;
      //@ assert Double.NaN != a;
      //@ assert !(a < Double.NaN);
      //@ assert !(a > Double.NaN);
      //@ assert !(Double.NaN < a);
      //@ assert !(Double.NaN > a);
    }

    public static void basicOps(double a, double b){
      //@ assert (!Double.isNaN(a) && !Double.isNaN(b)) ==> !Double.isNaN(a + b);
      //@ assert (Double.isNaN(a) || Double.isNaN(b)) ==> Double.isNaN(a + b);
      //@ assert (!Double.isNaN(a) && !Double.isNaN(b)) ==> !Double.isNaN(a - b);
      //@ assert (Double.isNaN(a) || Double.isNaN(b)) ==> Double.isNaN(a - b);

      //@ assert (Double.isNaN(a) || Double.isNaN(b)) ==> Double.isNaN(a * b);
      //@ assert (Double.isInfinite(a) && (b == 0.0)) ==> Double.isNaN(a * b);
      //@ assert ((a == 0.0) && Double.isInfinite(b)) ==> Double.isNaN(a * b);

      //@ assert (Double.isNaN(a) || Double.isNaN(b)) ==> Double.isNaN(a / b);
      //@ assert (Double.isInfinite(a) && Double.isInfinite(b)) ==> Double.isNaN(a / b);
      //@ assert ((a == 0.0) && (b == 0.0)) ==> Double.isNaN(a / b);
    }
}
