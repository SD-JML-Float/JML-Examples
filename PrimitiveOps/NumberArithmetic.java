
public class NumberArithmetic
{

    // This method tests floating point arithmetic and comparison ops
    // on a variety of literal constants
    public static void constant_tests()
    {
    //@ assert 3 < 4;
    //@ assert 3.0 < 4.0;
    //@ assert 3.0f < 4.0f;

    //@ assert 3 <= 3;
    //@ assert 3.0 <= 3.0;
    //@ assert 3.0f <= 3.0f;
    //@ assert 3 >= 3;
    //@ assert 3.0 >= 3.0;
    //@ assert 3.0f >= 3.0f;

    //@ assert 3.0 < 3.1;
    //@ assert 3.0f < 3.1f;
    //@ assert 3.0 < 3.01;
    //@ assert 3.0f < 3.01f;
    //@ assert 3.0 < 3.001;
    //@ assert 3.0f < 3.001f;
    //@ assert 3.0 < 3.0001;
    //@ assert 3.0f < 3.0001f;
    //@ assert 3.0 < 3.00001;
    //@ assert 3.0f < 3.00001f;
    //@ assert 3.0 < 3.000001;
    //@ assert 3.0f < 3.000001f;
    //@ assert 3.0 < 3.0000001;
    //@ assert 3.0f < 3.0000001f;

    //@ assert 3.0000001 < 3.0000002;
    //@ assert 3.0000001f < 3.0000002f;

    //@ assert 3.141592 == 3.141592;
    //@ assert 3.141592f == 3.141592f;
    }






    // testing equality of positive and negative zero
    public static void zero_tests()
    {
        //@ assert +0 == -0;
        //@ assert +0 == 0;
        //@ assert -0 == 0;

        //@ assert +0f == -0f;
        //@ assert +0f == 0f;
        //@ assert -0f == 0f;

        //@ assert 0 == 0.0;
        //@ assert 0 == 0.0f;
    }


    // This method tests OpenJML's ability to prove the basic properties
    // of the ==, <=, and < binary relations on numbers only
    //@ requires a == a && b == b && c == c; //a, b, c are numbers
    public static void binary_relation_tests(float a, float b, float c)
    {
	// == tests:
	//@ assert a == a; //reflexive
	//@ assert (a == b) <==> (b == a); //symmetric
	//@ assert (a == b && b == c) ==> a == c; //transitive
	//@ assert (a == b) <==> !(a != b); //partition of pairs of numbers into equal or not equal
	//@ assert a != b <==> b != a; //inequality is symmetric

	// <= tests:
	//@ assert a <= a; //reflexive
	//@ assert (a <= b && b <= c) ==> (a <= c); //transitive
	//@ assert (a <= b) || (b <= a); //all numbers are comparable
	//@ assert (a <= b) <==> (b >= a); //equivalence of <= and >=
	//@ assert (a <= b) <==> !(a > b); //partition of pairs a, b into <= and > relations

	// < tests:
	//@ assert !(a < a); //anti-reflexive
	//@ assert (a < b) ==> !(b < a); //anti-symmetric
	//@ assert (a < b && b < c) ==> a < c; //transitive

	// combined tests
	//@ assert a == b || a <= b || a > b;
        //@ assert a == b || a != b;
        //@ assert a <= b ==> (a == b || a < b);
	//@ assert a != b ==> (a > b || a < b);
        //@ assert a < b ==> a <= b;
        //@ assert !(a < b && b < a);
        //@ assert (a <= b && b <= a) ==> a == b;
    }

    // double version
    public static void binary_relation_tests(double a, double b, double c)
    {
        // == tests:
        //@ assert a == a; //reflexive
        //@ assert (a == b) <==> (b == a); //symmetric
        //@ assert (a == b && b == c) ==> a == c; //transitive
        //@ assert (a == b) <==> !(a != b); //partition of pairs of n>

        // <= tests:
        //@ assert a <= a; //reflexive
        //@ assert (a <= b && b <= c) ==> (a <= c); //transitive
        //@ assert (a <= b) || (b <= a); //all numbers are comparable
        //@ assert (a <= b) <==> (b >= a); //equivalence of <= and >=
        //@ assert (a <= b) <==> !(a > b); //partition of pairs a, b >

        // < tests:
        //@ assert !(a < a); //anti-reflexive
        //@ assert (a < b) ==> !(b < a); //anti-symmetric
        //@ assert (a < b && b < c) ==> a < c; //transitive

        // combined tests
        //@ assert a == b || a <= b || a > b;
        //@ assert a == b || a != b;
        //@ assert a <= b ==> (a == b || a < b);
        //@ assert a != b ==> (a > b || a < b);
        //@ assert a < b ==> a <= b;
        //@ assert !(a < b && b < a);
        //@ assert (a <= b && b <= a) ==> a == b;

    }


   // testing basic algebraic properties
   //@ requires a == a && b == b && c == c && d == d; //a, b, c, d are numbers
   public static void basic_algebra_tests(float a, float b, float c, float d)
   {

	// Algebraic Properties of Addition:
	////////////////////////////////////

	//@ assert (a + b) + c == a + (b + c); //associativity

	//@ assert a + 0 == a; //identity
	//@ assert a + 0.0 == a;
	//@ assert a + 0.0f == a;

	//@ assert a - a == 0; //inverse
	//@ assert a + -a == 0;

	//@ assert a + b == b + a; //commutative
	//@ assert (a < b && c < d) ==> (a + c) < (b + d); //ordering
	//@ assert ( a <= b && c <= d) ==> (a + c) <= (b + d); //ordering

	//@ assert a == b ==> a + c == b + c; //preservation of equality
	//@ assert ( a == b && c == d) ==> ( a + c == b + d && a + d == b + c);
	//@ assert a == b ==> a - c == b - c;

        //@ assert (a > 0 && b > 0) ==> (a + b > 0); //sign tests
        //@ assert (a < 0 && b < 0) ==> ( a + b < 0);
	//@ assert (a >= 0 && b >= 0) ==> a + b >= 0;
	//@ assert (a <= 0 && b <= 0) ==> a + b <= 0;
	//@ assert (a > 0 && b > 0) ==> a + b > 0;
	//@ assert (a < 0 && b < 0) ==> a + b < 0;
	//@ assert (a == 0 && a == b) ==> (b == 0 && a + b == 0);


	// Algebraic Properties of Multiplication:
	//////////////////////////////////////////

	//@ assert (a * b) * c == a * (b * c); //associativity

	//@ assert a * 1 == a;
	//@ assert a * 1.0 == a;
	//@ assert a * 1.0f == a;

	//@ assert a != 0 ==> a * (1 / a) == 1; //inverse

	//@ assert a * b == b * a; //commutative
	//@ assert a * b == 0 ==> (a == 0 || b == 0);

	//@ assert a < b && 0 < c ==> a * c < b * c; //ordering property
	//@ assert a <= b && 0 <= c ==> a * c <= b* c;

	//@ assert a == b ==> a * c == b * c; //preservation of equality
	//@ assert (a == b && c != 0) ==> a / c == b / c;
	//@ assert (a == b && c == d) ==> a * c == b * d;
	//@ assert (a * c == b * d && d != 0 && c != 0) ==> a / d == b / c;
        //@ assert (b != 0 && d != 0) ==> (a / b) * (c / d) == (a * c) / (b * d);

        //@ assert (a > 0 && b > 0) ==> (a * b > 0); //sign tests
        //@ assert (a > 0 && b < 0) ==> (a * b < 0);
        //@ assert (a < 0 && b < 0) ==> (a * b > 0);
        //@ assert (a < 0 && b > 0) ==> (a * b < 0);


	// Tests with Multiplication and Addition
	////////////////////////////////////////////
        //@ assert a * (b + c) == a * b + a * c; //distributivity
   }



   // testing basic algebraic properties
   //@ requires a == a && b == b && c == c && d == d; //a, b, c, d are numbers
   public static void basic_algebra_tests(double a, double b, double c, double d)
   {

	// Algebraic Properties of Addition:
	////////////////////////////////////

	//@ assert (a + b) + c == a + (b + c); //associativity

	//@ assert a + 0 == a; //identity
	//@ assert a + 0.0 == a;
	//@ assert a + 0.0f == a;

	//@ assert a - a == 0; //inverse
	//@ assert a + -a == 0;

	//@ assert a + b == b + a; //commutative
	//@ assert (a < b && c < d) ==> (a + c) < (b + d); //ordering
	//@ assert ( a <= b && c <= d) ==> (a + c) <= (b + d); //ordering

	//@ assert a == b ==> a + c == b + c; //preservation of equality
	//@ assert ( a == b && c == d) ==> ( a + c == b + d && a + d == b + c);
	//@ assert a == b ==> a - c == b - c;

        //@ assert (a > 0 && b > 0) ==> (a + b > 0); //sign tests
        //@ assert (a < 0 && b < 0) ==> ( a + b < 0);
        //@ assert (a >= 0 && b >= 0) ==> a + b >= 0;
	//@ assert (a <= 0 && b <= 0) ==> a + b <= 0;
	//@ assert (a > 0 && b > 0) ==> a + b > 0;
	//@ assert (a < 0 && b < 0) ==> a + b < 0;
	//@ assert (a == 0 && a == b) ==> (b == 0 && a + b == 0);



	// Algebraic Properties of Multiplication:
	//////////////////////////////////////////

	//@ assert (a * b) * c == a * (b * c); //associativity

	//@ assert a * 1 == a;
	//@ assert a * 1.0 == a;
	//@ assert a * 1.0f == a;

	//@ assert a != 0 ==> a * (1 / a) == 1; //inverse

	//@ assert a * b == b * a; //commutative
	//@ assert a * b == 0 ==> (a == 0 || b == 0);

	//@ assert a < b && 0 < c ==> a * c < b * c; //ordering property
	//@ assert a <= b && 0 <= c ==> a * c <= b* c;

	//@ assert a == b ==> a * c == b * c; //preservation of equality
	//@ assert (a == b && c != 0) ==> a / c == b / c;
	//@ assert (a == b && c == d) ==> a * c == b * d;
	//@ assert (a * c == b * d && d != 0 && c != 0) ==> a / d == b / c;
        //@ assert (b != 0 && d != 0) ==> (a / b) * (c / d) == (a * c) / (b * d);

        //@ assert (a > 0 && b > 0) ==> (a * b > 0); //sign tests
        //@ assert (a > 0 && b < 0) ==> (a * b < 0);
        //@ assert (a < 0 && b < 0) ==> (a * b > 0);
        //@ assert (a < 0 && b > 0) ==> (a * b < 0);


	// Tests with Multiplication and Addition
	////////////////////////////////////////////
        //@ assert a * (b + c) == a * b + a * c; //distributivity
   }


   // testing advanced algebraic equalities
   //@ requires a == a && b == b && c == c && d == d; //a, b, c, d are numbers
   public static void advanced_algebra_tests(float a, float b, float c, float d, float e, float f)
   {

	// quadratic expansions
	//@ assert (a + b) * (c + d) == a * c + a * d + b * c + b * d;
	//@ assert (a + b) * (c - d) == a * c - a * d + b * c - b * d;
	//@ assert (a + b) * (a - b) == a * a - b * b;

	// cubic expansions
	//@ assert a * a * a + b * b * b == (a + b) * (a * a - a * b + b * b); //sum of cubes
	//@ assert a * a * a - b * b * b == (a - b) * (a * a + a * b  + b * b); //difference of cubes

	// linear equations
	//@ assert (a == b * c + d && b != 0 ) ==>  c == (a - d) / b;

	// quadratic equations
	//@ assert ( ( a - b) * (a - b) == 0) ==> a == b;
	//@ assert ( (a - b) * (c - d) == 0 ) ==> (a == b || c == d);

	// system of linear equations
	//@ assert (1 == a * e + b * f && 1 == c * e + d * f && a * d != b * c ) ==> ( e == 1 / (a * d - b * c) * (d - b) && f == 1 / (a * d - b * c) * ( a - c)  );

   }

   // testing advanced algebraic equalities
   //@ requires a == a && b == b && c == c && d == d; //a, b, c, d are numbers
   public static void advanced_algebra_tests(double a, double b, double c, double d, double e, double f)
   {

       // quadratic expansions
        //@ assert (a + b) * (c + d) == a * c + a * d + b * c + b * d;
        //@ assert (a + b) * (c - d) == a * c - a * d + b * c - b * d;
        //@ assert (a + b) * (a - b) == a * a - b * b;

        // cubic expansions
        //@ assert a * a * a + b * b * b == (a + b) * (a * a - a * b + b * b); //sum of cubes
        //@ assert a * a * a - b * b * b == (a - b) * (a * a + a * b  + b * b); //difference of cubes

        // linear equations
        //@ assert (a == b * c + d && b != 0 ) ==>  c == (a - d) / b;

        // quadratic equations
        //@ assert ( ( a - b) * (a - b) == 0) ==> a == b;
        //@ assert ( (a - b) * (c - d) == 0 ) ==> (a == b || c == d);

        // system of linear equations
	//@ assert (1 == a * e + b * f && 1 == c * e + d * f && a * d != b * c ) ==> ( e == 1 / (a * d - b * c) * (d - b) && f == 1 / (a * d - b * c) * ( a - c)  );

   }
}
