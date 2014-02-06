package grinnell.csc207.doughert1.utils;

import java.io.PrintWriter;

public class splitCSVExpt
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(StringUtils.splitCSV("a,b,c"));
    pen.close();
  } // main(String[]

} // class splitCSVExpt
