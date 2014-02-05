package grinnell.csc207.doughert1.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringUtils
{

  @Test
  public void testSplitAt()
  {
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitAt ("a:b:c", ':'));
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitAt ("a b c", ' '));
    assertArrayEquals (new String[] { "a:b:c" },
                       StringUtils.splitAt ("a:b:c", ' '));
    assertArrayEquals ("one field", new String[] { "a" },
                       StringUtils.splitAt ("a", ':'));
    assertArrayEquals ("empty inner field", new String[] { "a", "", "c" },
                       StringUtils.splitAt ("a::c", ':'));
    assertArrayEquals ("leading empty field", new String[] { "", "a" },
                       StringUtils.splitAt (":a", ':'));
    assertArrayEquals ("trailing empty field", new String[] { "a", "" },
                       StringUtils.splitAt ("a:", ':')); 
    assertArrayEquals ("full words", 
                       new String[] { "Bruce", "the", "brother" },
                       StringUtils.splitAt ("Bruce:the:brother", ':')); 
    assertArrayEquals ("multi-word strings", 
                       new String[] { "Bucky Barnes", "the Winter Soldier" },
                       StringUtils.splitAt ("Bucky Barnes:the Winter Soldier", ':')); 
  }

  @Test
  public void testDeLeet()
  {
    assertEquals ("e", StringUtils.deLeet ("3"));
    assertEquals ("leet", StringUtils.deLeet ("133+"));
    assertEquals ("eat banana", 
                  StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
    assertEquals ("rock 'n' roll", 
                  StringUtils.deLeet ("r0ck '|\\|' r011"));
    assertEquals ("can you hear the people sing?", 
                  StringUtils.deLeet ("c@|\\| y0u #3@r +#3 p30p13 $i|\\|g?"));
    assertEquals ("sweet iced tea", 
                  StringUtils.deLeet ("$w33+ ic3d +3@"));
  }
  
  @Test
  public void testSplitCSV()
  {
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitCSV("a,b,c"));
    assertArrayEquals (new String[] { "a,b", "c" },
                       StringUtils.splitCSV("\"a,b\",c"));
    assertArrayEquals (new String[] { "a", "b,b\"", "c" },
                       StringUtils.splitCSV("a,\"b,b\"\"\",c"));
  }
}
