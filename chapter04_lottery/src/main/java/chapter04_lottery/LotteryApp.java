package chapter04_lottery;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LotteryApp {
   
   protected final BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
   
   public void startDialog() throws Exception {
      System.out.println("Would you like to rename (n) the item or place a bid (b):");
      String action = userInput.readLine();
      if("purchase".equals(action)) {
         System.out.println("start purchase ticket");
      } else if("draw".equals(action)) {
         System.out.println("start draw");
      }
   }
   
   public static void main(String[] args) throws Exception {
      LotteryApp lotteryApp = new LotteryApp();
      lotteryApp.startDialog();
   }
   
   public void promptCommands() {
      
   }
}
