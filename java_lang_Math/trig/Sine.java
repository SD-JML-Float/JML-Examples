// written by Robert Moore 5/23/21

public class Sine {
  // requires (! Double.isNaN(a)) && (! Double.isInfinite(a));
  //@ requires Math.isFinite(a);
  //@ ensures \result >= -1.0 && \result <= 1.0;
  static double inBounds(double a){
    return Math.sin(a);
  }

  //@ ensures \result == 0.0;
  static double sinZero(){
    return Math.sin(0.0);
  }
}
