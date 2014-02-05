package grinnell.csc207.doughert1.utils;

public class StringUtils
{
  public static String[] splitAt(String str, char ch)
  {
    // determining length of str without instances of ch
    int len = 1;
    for (int i = 0; i < str.length(); i++)
      {
        if (str.charAt(i) == ch)
          len++;
      }// for i

    String[] splitString = new String[len];
    int sep = str.indexOf(ch);
    int track = 0;
    for (int j = 0; j <= len; j++)
      {
        while (sep != -1)
          {
            splitString[j] = str.substring(track, sep);
            track = sep + 1;
            sep = str.indexOf(ch, track);
          } // while
      } // for j
    
    return splitString;
  }//splitAt (str, ch)
}
