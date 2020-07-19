package com.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * This utility class has several static methods available
 * to perform various operations on strings.  See the individual
 * method javadocs for specific usage directions
 * 
 * @author Student's Name
 * @since 2020-04-14
 * @version 1.0
 */
public class StringUtil
{
  /**
   * This method can be used to test if string
   * variable is either null nor empty.  If the string
   * is null or empty then this returns true else false
   * @param str String - This is the value you want to check
   * @return boolean true if the parameter is null or empty else false
   */
  public static boolean isNullOrEmpty(String str) {
    return (str == null) || (str.isEmpty());
  }

  /**
   * This method will evaluate a string, and; if it is NOT
   * null all the extraneous spaces will be removed and then 
   * the resulting string will be tested to see if it empty
   * 
   * @param str String - This is the string value to test
   * @return booean - true if the value is null or empty
   */
  public static boolean isNullOrWhitespace(String str) {
    return (str == null) || (str.trim().isEmpty());
  }

  /**
   * This method will test to see if the string value is
   * a phone number in the format of ###-###-###.
   * @param str String The value to check
   * @return boolean Returns true if the input is a properly formatted number else false
   */
  public static boolean isValidPhoneNumber(String str) {
    String trimmed = str.trim();

    return trimmed.matches("[2-9]\\d{2}-\\d{3}-\\d{4}");
  }

  /**
   * This method can be used to be sure a date is properly formatted in
   * uuuu-MM-dd format.
   * @param birthday String value to test
   * @return Boolean Returns true if the string is in the proper format else false
   */
  public static boolean isValidBirthday(String birthday) {
    // https://stackoverflow.com/a/39649815/673393
    try {
      LocalDate.parse(
          birthday,
          DateTimeFormatter
              .ofPattern("uuuu-MM-dd")
              .withResolverStyle(ResolverStyle.STRICT)
      );
    } catch (Exception e) {
      return false;
    }

    return true;
  }
}