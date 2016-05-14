package functional.v01;

public interface QuantityOfInterest {

   String getName();

   /**
    * Expected value for a particular month.
    * 
    * @param time month, 1-12
    * @return The expected value
    */
   double valueAt(int time);

}
