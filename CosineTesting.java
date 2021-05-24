// written by Robert Moore 5/23/21

public class CosineTesting {

  //@ requires (! Double.isNaN(a));
  //@ ensures \result >= -1.0 && \result <= 1.0;
  static double foo(double{
    return Math.cos(a);
  }

  public static void main(String[] args){
    double a = 0.0;
    System.out.printf("%.2f\n",foo(a));
  }

}
