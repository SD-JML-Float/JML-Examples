public class Logarithm
{


    public void logTest1(double a) {
        double b = Math.log(a);
        //@ assert Double.isNaN(a) || a < 0 <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> Double.POSITIVE_INFINITY == b;
        //@ assert a == 0 <==> Double.NEGATIVE_INFINITY == b;
        //@ assert Double.isFinite(a) && a > 0 ==> Math.exp(b)-a < .01d;
    }
    public void log10Test1(double a) {
        double b = Math.log10(a);
        //@ assert Double.isNaN(a) || a < 0 <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> Double.POSITIVE_INFINITY == b;
        //@ assert a == 0 <==> Double.NEGATIVE_INFINITY == b;
        //@ assert Double.isFinite(a) && a > 0 ==> Math.pow(10,a)-b < .01d || Math.pow(10,a)-b > .01d;
    }
    public void loglpTest1(double a) {
        double b = Math.log1p(a);
        double c = Math.log10(1.0d + a);
        //@ assert Double.isNaN(a) || a < -1 <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> b == Double.POSITIVE_INFINITY;
        //@ assert a == -1 <==> b == Double.NEGATIVE_INFINITY;
        //@ assert Double.isFinite(a) && a > -1 <==> a-b < .01d || a-b > .01d;
    }



  //@ requires Double.isFinite(a);
  public static void logTest2(double a)
  {
    double result = Math.log(a);
    //@ assert ((Double.compare(a, 0.0) == 0) || (Double.compare(a, -0.0) == 0)) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, 0.0) == 1) ==> Double.isFinite(result);
  }

  //@ requires ! Double.isFinite(a);
  public static void logTestAnomalies(double a)
  {
    double result = Math.log(a);
    //@ assert Double.isNaN(a) || (Double.compare(a, -0.0) == -1) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
  }

  //@ requires Double.isFinite(a);
  public static void log10Test2(double a)
  {
    double result = Math.log10(a);
    //@ assert (Double.compare(a, 0.0) == 0) || (Double.compare(a, -0.0) == 0) ==> (Double.compare(result, Double.NEGATIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, -0.0) == -1) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, 0.0) == 1) && (Double.compare(a, Double.POSITIVE_INFINITY) == -1) ==> Double.isFinite(result);
  }

  //@ requires ! Double.isFinite(a);
  public static void log10TestAnomalies(double a)
  {
    double result = Math.log10(a);
    //@ assert Double.isNaN(a) ==> Double.isNaN(result);
    //@ assert (Double.compare(a, Double.POSITIVE_INFINITY) == 0) ==> (Double.compare(result, Double.POSITIVE_INFINITY) == 0);
    //@ assert (Double.compare(a, Double.NEGATIVE_INFINITY) == 0) ==> Double.isNaN(result);
  }
}
