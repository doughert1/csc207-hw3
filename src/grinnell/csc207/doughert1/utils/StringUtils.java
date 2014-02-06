package grinnell.csc207.doughert1.utils;

import java.util.ArrayList;
import java.io.PrintWriter;

public class StringUtils
{

  // Part A:
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

    for (int j = 0; j < len; j++)
      {
        if (sep == -1)
          {
            splitString[j] = str.substring(track);
          }// if sep == -1
        else
          {
            splitString[j] = str.substring(track, sep);
            track = sep + 1;
            sep = str.indexOf(ch, track);
          }// else
      }// for j

    return splitString;
  }// splitAt (str, ch)

  // Part B:
  public static String[] splitCSV(String str)
  {
    ArrayList<String> csv = new ArrayList<String>();

    boolean quotation = false;
    int count = 1;
    int j = 0;
    while (j < str.length())
      {
        if (str.charAt(j) != ',')
          {
            if (str.charAt(j) == '\"' && str.charAt(j + 1) != '\"')
              {
                quotation = true;
                j++;
              }// if quote begins
            while (quotation)
              {
                count++;
                if (count < str.length())
                  {
                    if (str.charAt(count) == '\"'
                        && str.charAt(count + 1) != '\"')
                      quotation = false;
                  }// if quote ends
                else if (str.charAt(count) == '\"')
                  quotation = false;
              }// while
          }// if not comma
        if (count < str.length())
          csv.add(str.substring(j, count));
        else
          csv.add(str.substring(j));
        count++;
        j = count;
      }// while
    csv.trimToSize();
    String[] csvString = new String[csv.size()];
    csv.toArray(csvString);
    return csvString;
  } // splitCSV (str, ch)

  // Part C:
  public static String deLeet(String str)
  {
    int len = str.length();

    for (int j = 0; j < str.length(); j++)
      {
        if (str.charAt(j) == '|')
          len--;
      } // for j

    StringBuffer deLeeted = new StringBuffer(len);

    char index;

    for (int i = 0; i < str.length(); i++)
      {
        index = str.charAt(i);

        switch (index)
          {
            case '@':
              deLeeted.append('a');
              break;
            case '|':
              if (str.charAt(i + 1) == '3')
                {
                  deLeeted.append('b');
                }
              else if (str.charAt(i + 1) == '\\')
                {
                  deLeeted.append('n');
                }
              break;
            case '3':
              if ((i - 1) >= 0)
                {
                  if (str.charAt(i - 1) != '|')
                    {
                      deLeeted.append('e');
                    }// if not at beginning
                }// test if at beginning
              else
                deLeeted.append('e');
              break;
            case '#':
              deLeeted.append('h');
              break;
            case '1':
              deLeeted.append('l');
              break;
            case '0':
              deLeeted.append('o');
              break;
            case '$':
              deLeeted.append('s');
              break;
            case '+':
              deLeeted.append('t');
              break;
            default:
              if (index != '\\')
                deLeeted.append(index);
              break;
          } // switch
      } // for i

    return deLeeted.toString();
  } // deLeet (str)

  public static void nameGame(String name)
  {
    String bname = "B";
    String fname = "F";
    String mname = "M";

    char firstLet = name.charAt(0);
    int i = 0;
    while (i < name.length() && firstLet != 'a' && firstLet != 'e'
           && firstLet != 'i' && firstLet != 'o' && firstLet != 'u')
      {
        i++;
      } // while
    fname = fname.concat(name.substring(i));
    bname = bname.concat(name.substring(i));
    mname = mname.concat(name.substring(i));

    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(name + "!");
    pen.println(name + ", " + name + " bo " + bname + " Bonana fanna fo "
                + fname);
    pen.println("Fee fy mo " + mname + ", " + name);
    pen.close();
  } // nameGame
}// class StringUtils
