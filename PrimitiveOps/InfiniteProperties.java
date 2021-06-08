public /*@ pure @*/ class InfiniteProperties
{
  // possible axioms
  // @ axiom \forall double a; !Double.isNaN(a); a <= Double.POSITIVE_INFINITY;
  // @ axiom \forall double a; !Double.isNaN(a); a >= Double.NEGATIVE_INFINITY;
  // @ axiom \forall double a; a != Double.POSITIVE_INFINITY && a != Double.NEGATIVE_INFINITY && !Double.isNaN(a); Double.isFinite(a);
  // @ axiom \forall double a; a == Double.POSITIVE_INFINITY || a == Double.NEGATIVE_INFINITY; Double.isInfinite(a);



  // verify that finite constants can be compared to infinites correctly
  public static void constant_properties()
  {
    // @ show Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY;
    //@ assert Double.POSITIVE_INFINITY != Double.NEGATIVE_INFINITY;
    //@ assert Double.POSITIVE_INFINITY > Double.NEGATIVE_INFINITY;
    //@ assert Double.NEGATIVE_INFINITY < Double.POSITIVE_INFINITY;
    //@ assert 0.0 != Double.POSITIVE_INFINITY;
    //@ assert 0.0 != Double.NEGATIVE_INFINITY;
    //@ assert 0.0 < Double.POSITIVE_INFINITY;
    //@ assert 0.0 > Double.NEGATIVE_INFINITY;
    //@ assert Double.isFinite(0.0);

/*
    // use division by zero to get infinites instead of class fields
    // need to properly account for resulting exception
    //@ assert 0.0 != 1.0 / 0.0;
    //@ assert 0.0 != -(1.0 / 0.0);
    //@ assert 0.0 < 1.0 / 0.0;
    //@ assert 0.0 > -(1.0 / 0.0);
*/
  }

  //@ requires !Double.isNaN(a);
  public static void comparisons(double a){
    // @ show a, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY;
    //@ assert ((a != Double.POSITIVE_INFINITY) && (a != Double.NEGATIVE_INFINITY)) ==> Double.isFinite(a);
    //@ assert a <= Double.POSITIVE_INFINITY;
    //@ assert a >= Double.NEGATIVE_INFINITY;

    //@ assert Double.isFinite(a) ==> a < Double.POSITIVE_INFINITY;
    //@ assert Double.isFinite(a) ==> a > Double.NEGATIVE_INFINITY;
  }

  //@ requires !Double.isNaN(a) && !Double.isNaN(b);
  public static void basicOps(double a, double b)
  {
    // @ show a, b, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY;
    //@ assert (Double.isInfinite(a) || Double.isInfinite(b)) ==> Double.isInfinite(a + b);
    //@ assert (Double.isInfinite(a) || Double.isInfinite(b)) ==> Double.isInfinite(a - b);
    //@ assert (Double.isInfinite(a) && (b != 0.0)) ==> Double.isInfinite(a * b);
    //@ assert ((a != 0.0) && Double.isInfinite(b)) ==> Double.isInfinite(a * b);

    //@ assert (Double.isInfinite(a) && !Double.isInfinite(b)) ==> Double.isInfinite(a / b);
    //@ assert (!Double.isInfinite(a) && (b == 0)) ==> Double.isInfinite(a / b);
    //@ assert (!Double.isInfinite(a) && Double.isInfinite(b)) ==> (a / b) == 0.0;
  }

}
