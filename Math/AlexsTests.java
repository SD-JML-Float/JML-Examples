public class AlexsTests {
    //@ axiom \forall float a; !Float.isNaN(a) && Float.isFinite(a); a >= Float.NEGATIVE_INFINITY;
    //@ axiom \forall float a; !Float.isNaN(a) && Float.isFinite(a); a <= Float.POSITIVE_INFINITY;
    //@ axiom \forall double a; !Double.isNaN(a) && Double.isFinite(a); a >= Double.NEGATIVE_INFINITY;
    //@ axiom \forall double a; !Double.isNaN(a) && Double.isFinite(a); a <= Double.POSITIVE_INFINITY;


    // Does not properly recognize that a is for a fact negative infinity even when the bit representation is as such that it is negative infinity
    public void floatToIntBitsTest(Float a) {

        int b = Float.floatToIntBits(a);
        int sign = ((b >>> 31) == 0) ? 1 : -1;
        int exponent = ((b >>> 23) & 0xff);
        int mantissa = (b & 0x007fffff);

        //@ assert a == Float.POSITIVE_INFINITY <==> (sign == 1) && exponent == 0xff && mantissa == 0;
        //@ assert a == Float.NEGATIVE_INFINITY <==>  b == 0xff800000;
        //@ assert Float.isNaN(a) <==> b == 0x7fc00000;
        //@ assert (Float.isFinite(a) && !Float.isNaN(a)) ==> ((b < 0x7f800001) || ( b < 0xff800001 && b > 0x7fffffff ));
    }


    // Float.isNaN appears to believe that a is a float when its raw bits are 0xff800000 which is indicitive of negative infinity
    public void floatToRawIntBitsTest(Float a) {

        int b = Float.floatToRawIntBits(a);
        //@ assert a == Float.POSITIVE_INFINITY ==> b == 0x7f800000;
        //@ assert a == Float.NEGATIVE_INFINITY ==>  b == 0xff800000;
        //@ assert Float.isNaN(a) ==> ((b & 0x7f800000) == 0x7f800000) && ((b & 0x007fffff) != 0x0)  ;
        //@ assert (!Float.isFinite(a) && !Float.isNaN(a)) ==> ((b > 0xff800000) && ( b < 0x7f800000));
    }


    // weird errors seeming to pertain to the idea of NaN existing
    // Does not convert a wrapper NaN to a primitive NaN
    public void floatValueTest(Float a) {
        float b = a.floatValue();
        //@ assert !Float.isNaN(a) ==> a == b;
        //@ assert Float.isNaN(a) <==> Float.isNaN(b);
    }

    // Works directly off of floatToIntBits same issue
    public void hashCodeFloatTest(Float a,Float b) {
        int hashA = Float.hashCode(a);
        int hashB = Float.hashCode(b);
        //@ assert a == Float.POSITIVE_INFINITY ==> hashA == 0x7f800000;
        //@ assert a == Float.NEGATIVE_INFINITY ==>  hashA == 0xff800000;
        //@ assert Float.isNaN(a) ==> hashA == 0x7fc00000;
        //@ assert (!Float.isFinite(a) && !Float.isNaN(a)) ==> ((hashA < 0x7f800001) || ( hashA < 0xff800001 && hashA > 0x7fffffff ));
        //@ assert  (a == b) ==> hashA == hashB;
    }

    // Weird issue where function produces an infinite loop in SMT code

    // May require more testing due to signanling NaNs on different processor as referenced https://docs.oracle.com/javase/7/docs/api/java/lang/Float.html#intBitsToFloat(int)
    public void intBitsToFloatTest(int a) {

        Float b = Float.intBitsToFloat(a);
        int sign = ((a >> 31) == 0) ? 1 : -1;
        int exponent = ((a >> 23) & 0xff);
        int mantissa = (exponent == 0) ? (a & 0x7fffff) << 1 : (a & 0x7fffff) | 0x800000;
        //@ assert exponent == 0xff && sign == 1 && mantissa == 0 ==> b == Float.NEGATIVE_INFINITY;
        //@ assert exponent == 0xff && sign == -1 && mantissa == 0 ==> b == Float.POSITIVE_INFINITY;
        //@ assert exponent == 0xff && mantissa != 0  ==> Float.isNaN(b);
        //@ assert exponent != 0xff ==> Math.abs(b - (2 * (sign | 0x800000)*Math.pow(2,exponent-150))) < .1;
    }

    // Should throw a warning about possible lossy of accuracy with Infinites
    // Seems to be that a is being rounded when the expected result is to truncate to b
    public void intValueFloatTest(float a) {
        int b = (int)a;
        //@ assert a == Float.POSITIVE_INFINITY ==> b == Integer.MAX_VALUE;
        //@ assert a == Float.NEGATIVE_INFINITY ==> b == Integer.MIN_VALUE;
        //@ assert Float.isFinite(a) && a > 0.0f ==> a-b < 1 && a-b >= 0;
        //@ assert Float.isFinite(a) && a < 0.0f ==> a-b >-1 && a-b <= 0;
    }

    // In verboseness 3: Weird error wher eit believes Float.NaN and Float.Negative_Infinity are the same
    public void isInfiniteFloatTest(float a) {
        boolean b = Float.isInfinite(a);
        //@ assert a == Float.POSITIVE_INFINITY ==> b;
        //@ assert a == Float.NEGATIVE_INFINITY ==> b;
        //@ assert Float.isNaN(a) ==> !b;
        //@ assert !Float.isNaN(a) && a != Float.POSITIVE_INFINITY && a != Float.NEGATIVE_INFINITY ==> !b;
    }




    // NaN case works here  but not for Floats?
    public void doubleValueTest(Double a) {
        double b = a.doubleValue();
        //@ assert !Double.isNaN(a) ==> a == b;
        //@ assert Double.isNaN(a) <==> Double.isNaN(b);
    }


    // Only needs to check fi the exact bit representation is the same
    public void equalsTest(Double a,Double b) {
        boolean c = a.equals(b);
        boolean d = Double.doubleToLongBits(a) == Double.doubleToLongBits(b);
        //@ assert  d == c;
    }


    // Need a way to compare float and doubles in order for this to work
    public void floatFromDoubleValueTest(Double a) {
        Float b = a.floatValue();
        // @ assert !Double.isNaN(a) ==> a == b;
    }


    // Getting different values than from documentation
    public void hashCodeDoubleTest(Double a) {
        long v = Double.doubleToLongBits(a);
        int longBitRep = (int)(v^(v>>>32));
        int hash = a.hashCode();
        //@ assert hash == longBitRep;
    }

    // Same issue as before
    public void hashCodeStaticTest(double a) {
        long v = Double.doubleToLongBits(a);
        int longBitRep = (int)((v & 0x00000000ffffffffL)^(v>>>32));
        int hash = Double.hashCode(a);
        //@ assert hash == longBitRep;
    }

    // Casting the true value of a not the representitave value which could be negative infinity
    public void intValueDoubleTest(double a) {
        int b = (int)a;
        //@ assert (a == Double.POSITIVE_INFINITY) || (a >= Integer.MAX_VALUE) ==> b == Integer.MAX_VALUE;
        //@ assert (a == Double.NEGATIVE_INFINITY) || (a <= Integer.MIN_VALUE) ==> b == Integer.MIN_VALUE;
        //@ assert Double.isFinite(a) && a > 0.0f && !(b == Integer.MAX_VALUE)  ==> a-b > -1 && a-b <= 0;
        //@ assert Double.isFinite(a) && a < 0.0f && !(b == Integer.MIN_VALUE) ==> a-b < 1 && a-b >= 0;
    }

    // All sorts of wrongness, turned a -1.0/10.0 int 1.0/4.0 which then was interpreted as NaN, As well rounding 1.0/4.0 to 5.0/4.0 which looks like a 1 up
    public void ceilTest(double a) {
        double b = Math.ceil(a);
        //@ assert Double.isNaN(a) <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> Double.POSITIVE_INFINITY == b;
        //@ assert Double.NEGATIVE_INFINITY == a <==> Double.NEGATIVE_INFINITY == b;
        //@ assert Double.isFinite(a) && (a < 0) <==> a-b >= 0.0d && a-b < 1.0d;
        //@ assert Double.isFinite(a) && (a > 0) <==> a-b <= 0.0d && a-b > -1.0d;
        //@ assert Double.isFinite(a) && (a > -1.0d && a < 0) <==> (new Double(b)).equals(-0.0d);

    }

    // Rounded a value down to negative infinity, that balue being -1.0/4.0, presumed issue with definition of Infinities and issue with flooring
    public void floorTest(double a) {
        double b = Math.floor(a);
        //@ assert Double.isNaN(a) <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> Double.POSITIVE_INFINITY == b;
        //@ assert Double.NEGATIVE_INFINITY == a <==> Double.NEGATIVE_INFINITY == b;
        //@ assert Double.isFinite(a) && (a < 0) <==> b-a >= 0.0d && b-a < 1.0d;
        //@ assert Double.isFinite(a) && (a > 0) <==> b-a <= 0.0d && b-a > -1.0d;
    }

    // Issues are found with the sepcification on rint Double.isNaN(a) thinks that result == a which is not true for NaN since NaN not comparable
    // DOes not round to the nearest Value correctly in SMT
    public void rintTest(double a) {
        double b = Math.rint(a);
        //@ assert Double.isNaN(a) <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> Double.POSITIVE_INFINITY == b;
        //@ assert Double.NEGATIVE_INFINITY == a <==> Double.NEGATIVE_INFINITY == b;
        //@ assert Double.isFinite(a) && (a-b > 0) ==> a-b <= 0.5d;
        //@ assert Double.isFinite(a) && (a-b < 0) ==> b-a < 0.5d;
    }
    public void roundTest(float a) {
        int b = Math.round(a);
        //@ assert Float.isNaN(a) <==> b == 0;
        //@ assert (Float.POSITIVE_INFINITY == a) || (a >= Integer.MAX_VALUE) <==> Integer.MAX_VALUE == b;
        //@ assert (Float.NEGATIVE_INFINITY == a) || (a >= Integer.MIN_VALUE) <==> Integer.MIN_VALUE == b;
        //@ assert Float.isFinite(a) && (a-b > 0) ==> a-b <= 0.5d;
        //@ assert Float.isFinite(a) && (a-b < 0) ==> b-a < 0.5d;
    }

    // floorDiv on min Int and min int gives 2 instead of 1
    //@ requires y != 0;
    public void floorDivIntTest(int x, int y) {
        int c = Math.floorDiv(x,y);
        int d = x/y;
        //@ assert (x == Integer.MIN_VALUE && y == -1) ==> c == Integer.MIN_VALUE;
        //@ assert (x < 0 ^ y < 0) <==> c == (d-1);
        //@ assert !(x < 0 ^ y < 0) && !( x == Integer.MIN_VALUE && y == -1) <==> c == d;
    }

    public void floorDivLongTest( long x, long y) {
        long c = Math.floorDiv(x,y);
        long d = x/y;
        //@ assert (x == Long.MIN_VALUE && y == -1) ==> c == Long.MIN_VALUE;
        //@ assert (x < 0 ^ y < 0) <==> c == (d-1);
        //@ assert !(x < 0 ^ y < 0) && !( x == Long.MIN_VALUE && y == -1) <==> c == d;
    }

    //@ requires y != 0;
    public void floorModIntTest(int x, int y) {
        int c = Math.floorMod(x,y);
        int d = c % y;
        //@ assert !(x < 0 ^ y < 0) <==> c == d;
        //@ assert (x < 0 && y > 0) <==> c == (d-1) * -1;
        //@ assert (x > 0 && y < 0) <==> c == (d+1) * -1;
    }

    public void floorModLongTest(long x, long y) {
        long c = Math.floorMod(x,y);
        long d = c % y;
        //@ assert !(x < 0 ^ y < 0) <==> c == d;
        //@ assert (x < 0 && y > 0) <==> c == (d-1) * -1;
        //@ assert (x > 0 && y < 0) <==> c == (d+1) * -1;
    }
    public void logTest(double a) {
        double b = Math.log(a);
        //@ assert Double.isNaN(a) || a < 0 <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> Double.POSITIVE_INFINITY == b;
        //@ assert a == 0 <==> Double.NEGATIVE_INFINITY == b;
        //@ assert Double.isFinite(a) && a > 0 ==> Math.exp(b)-a < .01d;
    }
    public void log10Test(double a) {
        double b = Math.log10(a);
        //@ assert Double.isNaN(a) || a < 0 <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> Double.POSITIVE_INFINITY == b;
        //@ assert a == 0 <==> Double.NEGATIVE_INFINITY == b;
        //@ assert Double.isFinite(a) && a > 0 ==> Math.pow(10,a)-b < .01d || Math.pow(10,a)-b > .01d;
    }
    public void loglpTest(double a) {
        double b = Math.log1p(a);
        double c = Math.log10(1.0d + a);
        //@ assert Double.isNaN(a) || a < -1 <==> Double.isNaN(b);
        //@ assert Double.POSITIVE_INFINITY == a <==> b == Double.POSITIVE_INFINITY;
        //@ assert a == -1 <==> b == Double.NEGATIVE_INFINITY;
        //@ assert Double.isFinite(a) && a > -1 <==> a-b < .01d || a-b > .01d;
    }



    /*@ public normal_behavior
      @   ensures \result <==> !Float.isNaN(v) && ( v == Float.POSITIVE_INFINITY
      @                       || v == Float.NEGATIVE_INFINITY);
      @*/
      public static /*@ pure helper @*/ boolean isInfinite(float v) {
          return (!Float.isNaN(v) && (v == Float.NEGATIVE_INFINITY || v == Float.POSITIVE_INFINITY)) ?  true :  false;}
          /*@ public normal_behavior
      @   ensures \result <==> !Double.isNaN(v) && ( v == Double.POSITIVE_INFINITY
      @                       || v == Double.NEGATIVE_INFINITY);
      @*/
      public static /*@ pure helper @*/ boolean isInfinite(double v) {
        return (!Double.isNaN(v) && (v == Double.NEGATIVE_INFINITY || v == Double.POSITIVE_INFINITY)) ?  true :  false;}

}
