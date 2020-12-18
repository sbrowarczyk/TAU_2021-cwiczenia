package lab3;


import static java.util.Arrays.asList;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.Immutable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.collections4.bag.HashBag;

public class SimpleMethods {

  public static String concatenate(String stringOne, String stringTwo) {
    return stringOne + stringTwo;
  }

  public static Integer add(Integer firstInt, Integer secondInt) {
    return firstInt + secondInt;
  }

  public static Integer minus(Integer firstInt, Integer secondInt) {
    return firstInt - secondInt;
  }

  public static Integer div(Integer firstInt, Integer secondInt) {
    return firstInt / secondInt;
  }


  public static Bag<String> addToBag(String element) {
    if (element == null) {
      return BagUtils.emptyBag();
    }
    Bag<String> bag = new HashBag<>();
    bag.add(element);
    return bag;

  }

  public static List<String> returnImmutableList() {
    return ImmutableList.of("Test1", "Test2");
  }


}

