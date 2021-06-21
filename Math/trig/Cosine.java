// written by Robert Moore 5/23/21

public class Cosine {

  // requires (! Double.isNaN(a)) && (! Double.isInfinite(a));
  //@ requires Math.isFinite(a);
  //@ ensures \result >= -1.0 && \result <= 1.0;
  static double inBounds(double a){
    return Math.cos(a);
  }

  //@ ensures \result == 1.0;
  static double cosZero(){
    return Math.cos(0.0);
  }
}
