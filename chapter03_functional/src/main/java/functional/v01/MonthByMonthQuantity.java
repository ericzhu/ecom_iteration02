package functional.v01;

public abstract class MonthByMonthQuantity implements QuantityOfInterest {
   private final double[] values;

   public MonthByMonthQuantity(final double[] values) {
      this.values = values;
   }

   @Override
   public double valueAt(int time) {
      return values[time - 1];
   }
}
