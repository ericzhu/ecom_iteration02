package functional.v01;

public class Profit implements QuantityOfInterest {

   private final Sales            sales;
   private final FixedCosts       fixedCosts;
   private final IncrementalCosts incrementalCosts;

   public Profit(Sales sales, FixedCosts fixedCosts, IncrementalCosts incrementalCosts) {
      this.sales = sales;
      this.fixedCosts = fixedCosts;
      this.incrementalCosts = incrementalCosts;
   }

   @Override
   public String getName() {
      return "profit";
   }

   @Override
   public double valueAt(int time) {
      // return sales.valueAt(time) - (fixedCosts.valueAt(time) + incrementalCosts.valueAt(time));
      return 0.0;
   }

}
