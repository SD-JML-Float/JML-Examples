public class AdditionProperties {
  //@ requires Math.isFinite(a) && Math.isFinite(b) && Math.isFinite(a+b);
  public static void finiteAddition(double a, double b){
    double c = a + b;
    //@ assert Math.isFinite(c);
    // @ assert (Math.abs(a) < (Double.MAX_VALUE / 2.0) && Math.abs(b) < (Double.MAX_VALUE / 2.0)) ==> Math.isFinite(c);
  }
}
