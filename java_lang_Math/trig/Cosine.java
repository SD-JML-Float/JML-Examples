// written by Robert Moore 5/23/21

public class Cosine {

  //@ requires (! Double.isNaN(a)) && (! Double.isInfinite(a));
  //@ ensures \result >= -1.0 && \result <= 1.0;
  static double inBounds(double a){
    return Math.cos(a);
  }

  //@ requires (! Double.isNaN(a));
  //@ ensures \result >= -1.0 && \result <= 1.0;
  static double foo(double a){
    return Math.cos(a);
  }

  public static void main(String[] args){
    double a = 0.0;
    System.out.printf("%.2f\n",inBounds(a));
  }

}
