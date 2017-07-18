import java.util.Scanner;

public class FancyCMD implements Runnable {

  public static void main(String[] args) {
    System.out.println("Starting FancyCMD...");
    new Thread(new FancyCMD()).start();
  }

  @Override
  public void run() {
    boolean running = true;
    String in;

    Scanner sc = new Scanner(System.in);
    while (running && !Thread.interrupted()) {
      System.out.print("FancyCMD: ");
      in = sc.next().toLowerCase();

      switch (in) {
        case "exit": 
        case "shutdown": 
          running = false;
          break;
        case "genfancy":
          System.out.print("Enter PW: ");
          String origPW = sc.next();

          System.out.print("Your fancy PW is: ");
          System.out.println(genFancyPW(origPW));
          break;
        default:
          System.out.println("CMD not fancy enough!");
          break;
      }
    }

    System.out.println("Turning fanciness offfff :(");
  }

  /**
   * Creates a very fancy password.
   * 
   * @param DAT_PW normal password
   * @return fancy password
   */
  public static String genFancyPW(String DAT_PW) {
    StringBuilder revPW = new StringBuilder(DAT_PW);
    String silencePadding = "1!";

    return DAT_PW + revPW.reverse().toString();
  }
}
