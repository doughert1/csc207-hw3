package grinnell.csc207.doughert1.utils;

import java.math.BigInteger;

public class Calculator
{
  public static BigInteger eval0(String math)
  {
    BigInteger num;
    int space;
    int track = 0;

    if (math.length() > 1)
      {
        space = math.indexOf(' ');
        num = BigInteger.valueOf(Long.valueOf(math.substring(0, space)));
        track = space + 1;
        space = math.indexOf(' ', track);
      }
    else
      {
        return BigInteger.valueOf(Long.valueOf(math));
      }

    BigInteger result = num;

    char operator = '0';
    String val;
    boolean haveOp = false;
    while (track < math.length() && space != -1)
      {
        val = math.substring(track, space);
        while (!haveOp)
          {
            operator = val.charAt(0);
            track = space + 1;
            space = math.indexOf(' ', track);
            haveOp = true;
          }// while to find operator
        if(space != -1)
          {
            num = BigInteger.valueOf(Long.valueOf(math.substring(track, space)));
          }
        else
          {
            num = BigInteger.valueOf(Long.valueOf(math.substring(track)));
          }
        switch (operator)
          {
            case '+':
              result = result.add(num);
              break;
            case '-':
              result = result.subtract(num);
              break;
            case '*':
              result = result.multiply(num);
              break;
            case '/':
              result = result.divide(num);
              break;
            case '^':
              result = result.pow(num.intValue());
              break;
            default:
              break;
          }// switch
        haveOp = false;
      }// while to evaluate expression

    return result;
  }// eval0(math)
}// Calculator class
