package lab3;

import java.util.List;
import lab3.SimpleMethods;
import org.apache.commons.collections4.Bag;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class SimpleMethodsTest {

  @Test
  public void passTwoCorrectStringToConcatenate() {
    String stringOne = "Lorem";
    String stringTwo = " ipsum";
    String actual = stringOne + stringTwo;
    String concatenate = SimpleMethods.concatenate(stringOne, stringTwo);
    assertEquals(concatenate, actual);

  }

  @Test
  public void passNullAsParameterToConcatenate() {
    String stringOne = "Lorem";
    String stringTwo = null;
    String actual = stringOne + stringTwo;
    String concatenate = SimpleMethods.concatenate(stringOne, stringTwo);
    assertEquals(concatenate, actual);
  }

  @Test
  public void passTwoCorrectIntToAdd() {
    Integer intOne = 10;
    Integer intTwo = 5;
    Integer actual = intOne + intTwo;
    Integer add = SimpleMethods.add(intOne, intTwo);
    assertEquals(add, actual);

  }

  @Test
  public void passNullAsParameterToAdd() {
    Integer intOne = 10;
    Integer intTwo = null;
    assertThrows(NullPointerException.class, () -> SimpleMethods.add(intOne, intTwo));

  }

  @Test
  public void passTwoCorrectIntToMinus() {
    Integer intOne = 10;
    Integer intTwo = 5;
    Integer actual = intOne - intTwo;
    Integer minus = SimpleMethods.minus(intOne, intTwo);
    assertEquals(minus, actual);
  }

  @Test
  public void passNullAsParameterToMinus() {
    Integer intOne = 10;
    Integer intTwo = null;
    assertThrows(NullPointerException.class, () -> SimpleMethods.minus(intOne, intTwo));

  }

  @Test
  public void passTwoCorrectToDiv() {
    Integer intOne = 10;
    Integer intTwo = 5;
    Integer actual = intOne / intTwo;
    Integer div = SimpleMethods.div(intOne, intTwo);
    assertEquals(div, actual);

  }

  @Test
  public void tryToAddElementToImmutableList() {
    List<String> immutableList = SimpleMethods.returnImmutableList();
    assertThrows(UnsupportedOperationException.class, () -> immutableList.add("element"));
  }

  @Test
  public void passCorrectParameterToAddToBag() {
    Bag<String> bag = SimpleMethods.addToBag("Test");
    assertEquals(1, bag.size());
  }

  @Test
  public void passNullAsParameterToAddToBag() {
    Bag<String> bag = SimpleMethods.addToBag(null);
    assertTrue(bag.isEmpty());
  }

}
