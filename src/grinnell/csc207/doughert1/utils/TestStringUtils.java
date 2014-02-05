package grinnell.csc207.doughert1.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringUtils
{

  @Test
  public void test()
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
    assertArrayEquals ("full words", new String[] { "Bruce", "the", "brother" },
                       StringUtils.splitAt ("Bruce:the:brother", ':')); 
    assertArrayEquals ("multi-word strings", new String[] { "Bucky Barnes", "the Winter Soldier" },
                       StringUtils.splitAt ("Bucky Barnes:the Winter Soldier", ':')); 
  }

}
