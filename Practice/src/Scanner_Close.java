import java.io.Console;
import java.util.Scanner;

/**
 * java.io.Console (jdk 1.6) 
 * Invoking close() on the objects returned by the reader() and the writer() will not close the underlying stream of those objects. 
 * 
 * If this virtual machine has a console then it is represented by a unique instance of this class which can be obtained by invoking the  *

System.console() method. If no console device is available then an invocation of that method will return null. 
 *
 */
public class Scanner_Close
{
 public static void main(String[] args) throws Exception
 {
  try{
   TestConsole();
   TestStandardIn();
  }catch(Exception ex){
   System.out.println(ex+"");
  }

 }

 // Scanner.close() does not really close the Console.Reader().  
 private static void TestConsole() throws Exception
 {
  System.out.println("=======    TestConsole     =======");
  Console con = System.console(); // from jdk 1.6 
  Scanner scan = new Scanner(con.reader());
  
  System.out.println(scan.nextLine());
  // close scanner
  con.reader().close();
  scan.close();
  System.out.println(" Scanner = " + scan.hashCode());
  System.out.println(" Scanner = " + scan);
  System.out.println("======= Scanner closed. =======");


  System.out.println("======= Scanner recreate. =======");
  scan = new Scanner(con.reader());
  System.out.println(" Scanner = " + scan.hashCode());
  System.out.println(" Scanner = " + scan);
  System.out.println(scan.nextLine());

 }

 // Scanner.close() at last closes the System.in stream. 
 private static void TestStandardIn()
 {
  System.out.println("=======    TestConsole     =======");
  Scanner scan = new Scanner(System.in);
  
  System.out.println(scan.nextLine());
  // close scanner
  scan.close();
  System.out.println(" Scanner = " + scan.hashCode());
  System.out.println(" Scanner = " + scan);

  System.out.println("======= Scanner recreate. =======");
  System.out.println(" System.in = " + System.in);
  scan = new Scanner(System.in);
  System.out.println(scan.nextLine());
 }
}