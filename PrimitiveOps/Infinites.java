public class Infinites{
  public static final double POSITIVE_INFINITY = 10;//Double.POSITIVE_INFINITY;
  public static final double NEGATIVE_INFINITY = -10;//Double.NEGATIVE_INFINITY;
  //@ axiom \forall double a; !Double.isNaN(a); a <= POSITIVE_INFINITY;
  //@ axiom \forall double a; !Double.isNaN(a); a >= NEGATIVE_INFINITY;
  //@ axiom \forall double a; a < POSITIVE_INFINITY && a > NEGATIVE_INFINITY && !Double.isNaN(a); Double.isFinite(a);
  //@ axiom \forall double a; a == POSITIVE_INFINITY || a == NEGATIVE_INFINITY; Double.isInfinite(a);
  //@ axiom \forall double a; true; a != Double.NaN && Double.NaN != a;
  // @ axiom Double.isFinite(Double.MAX_VALUE);
  // @ axiom Double.isFinite(Double.MIN_VALUE);
  // @ axiom Double.isFinite(0.0);
  //@ axiom 0.0 != Double.NaN;

  //@ assignable \nothing;
  public static /*@ pure @*/ void basicOps(double a, double b){
    //@ assert 0.0 == 0.0;
    //@ assert 0.0 < 1.0;
    //@ assert 0.0 > -1.0;
    //@ assert -0.0 == 0.0;
    //@ assert 0.0 != POSITIVE_INFINITY;
    //@ assert 0.0 != NEGATIVE_INFINITY;
    //@ assert 0.0 != Double.NaN;
    //@ assert Double.isFinite(0.0);
    // @ assert Double.isInfinite(0.0);
    //@ assert 0.0 < Double.POSITIVE_INFINITY;
    //@ assert 0.0 > Double.NEGATIVE_INFINITY;
    //@ assert Double.isFinite(1.0);
    double c = a + b;
    //@ show a,b,c;
    //@ assert (!Double.isNaN(a) && !Double.isNaN(b)) ==> !Double.isNaN(c);
    //@ assert (Double.isFinite(a) && Double.isFinite(b)) ==> Double.isFinite(c);
  }



/*
  //@ signals (Exception e) false;
  public static void main (String[] args){
    double d = 0;
    try {
      d = 0 / 0;
    }
    catch(Exception e){
      System.out.println(e);
    }
    finally{
      //@ assert Double.isNaN(d);
      System.out.println(d);
    }
  }
*/
}
