public class Constructors
{
  public static void double_constructor(double d)
  {
    Double wrapper = new Double(d);
    //@ assert wrapper.compareTo(new Double(d)) == 0;
    //@ assert !Double.isNaN(d) ==> d == wrapper.doubleValue();
    //@ assert Double.isNaN(d) ==> Double.isNaN(wrapper.doubleValue());
    //@ assert s.equals(new Double(s.toString()));
  }

  public static void string_constructor(String s)
  {
    Double wrapper = new Double(s);
    //@ assert s.equals("NaN") ==> Double.isNaN(wrapper.doubleValue());
    //@ assert s.equals("Infinity") ==> wrapper.doubleValue() == Double.POSITIVE_INFINITY;
    //@ assert s.equals("-Infinity") ==> wrapper.doubleValue() == Double.NEGATIVE_INFINITY;
    //@ assert wrapper.equals(new Double(wrapper.doubleValue()));
  }
}
