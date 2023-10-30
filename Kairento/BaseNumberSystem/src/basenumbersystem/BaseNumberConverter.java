/*							
 * Copyright(C) 2023,  FPT University.							
 * Base Number Converter :							
 * Convert Number from a base to another base.								
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-23>       <2.0>          <Nguyen Hoang Manh>   <Convert number from given input base to given output base>							
 */
package basenumbersystem;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is for developer/programmer to write function for the program: Base
 * Number Converter This class contains method checkValidNumber and method
 * convertNumeber, more details for each method in header method comment below
 *
 *
 * @author Nguyen Hoang Manh
 */
public class BaseNumberConverter {

    /**
     * Constructor allow this class to be called through object
     */
    public BaseNumberConverter() {

    }

    /**
     * Convert from the base(inBase) that user input the number(numberIn) to the
     * base that user chose after(outBase). Return a String being number that
     * has been converted to (outBase).
     *
     * @param numberIn number that user input. It is a
     * <code>java.lang.String</code> object
     * @param inBase base of number for input. It is a
     * <code>java.lang.Integer</code> object
     * @param outBase base of number for output. It is a
     * <code>java.lang.Integer</code> object
     *
     * @return a String. It is a <code>java.lang.String</code> object
     */
    public String convertNumber(String numberIn, int inBase, int outBase) {
        if (inBase == outBase) {
            return numberIn;
        } else if (outBase == 10) {
            return convertToDecimal(numberIn, inBase);
        }

        switch (inBase) {
            case 2:
                return convertFromBinaryToHexa(numberIn);

            case 10:
                return convertFromDecimal(Integer.valueOf(numberIn), outBase);

            case 16:
                return convertFromHexaToBinary(numberIn);
        }

        return "Failed to convert. Something was wrong";
    }

    /**
     * Convert from the base 10 to user's desired base Return a String being
     * number that has been converted
     *
     * @param number number in base 10. It is a <code>java.lang.Integer</code>
     * object
     * @param outBase the base that the number will be converted to. It is a
     * <code>java.lang.Integer</code> object
     *
     * @return a String. It is a <code>java.lang.String</code> object
     */
    private String convertFromDecimal(int number, int outBase) {
        StringBuilder numberString = new StringBuilder();
        int remainder = 0;
        char letter;

        do {
            remainder = number % outBase;
            //This condition is for hexa base
            if (remainder >= 10 && remainder <= 15) {
                //Get character correspoding to the ASCII value
                letter = (char) (remainder + 55);
                numberString = numberString.append(letter);
            } else {
                numberString = numberString.append(remainder);
            }
            number = number / outBase;
        } while (number != 0);

        return numberString.reverse().toString();
    }

    /**
     * Convert number in binary base to number in hexadecimal base
     *
     * @param number binary number. It is a <code>java.lang.String</code> object
     * @return a hexadecimal string. It is a <code>java.lang.String</code>
     * object
     */
    private String convertFromBinaryToHexa(String number) {
        // Add min 0's in the beginning to make
        // left substring length divisible by 4
        int missingZeros = (4 - number.length() % 4) % 4;
        for (int i = 0; i < missingZeros ; i++) {
            number = '0' + number;
        }

        Map<String, Character> binaryToHexaMap = new HashMap<>();

        EquivalentTable.createBinaryToHexaMap(binaryToHexaMap);

        int index = 0;
        String hexaString = "";

        while (true) {
            if (index == number.length()) {
                break;
            }
            // One by one extract from left, substring of size 4 and add its hexaString code
            hexaString += binaryToHexaMap.get(number.substring(index, index + 4));
            index += 4;
            if (index == number.length()) {
                break;
            }
        }
        return hexaString;
    }

    /**
     * Convert number in hexadecimal base to number in binary base
     *
     * @param number hexadecimal number. It is a <code>java.lang.String</code>
     * object
     * @return a binary string. It is a <code>java.lang.String</code> object
     */
    private String convertFromHexaToBinary(String number) {
        Map<Character, String> hexaToBinaryMap = new HashMap<>();

        EquivalentTable.createHexaToBinaryMap(hexaToBinaryMap);

        String binaryString = "";

        int index;
        char ch;

        // loop to iterate through the length
        // of the Hexadecimal String
        for (index = 0; index < number.length(); index++) {
            // extracting each character
            ch = number.charAt(index);

            // checking if the character is
            // present in the keys
            if (hexaToBinaryMap.containsKey(ch)) {
                // Adding to the Binary Sequence the corresponding value of the key
                binaryString += hexaToBinaryMap.get(ch);
                // Returning error String if the character is not present in the keys
            } else {
                binaryString = "Invalid Hexadecimal String";
                return binaryString;
            }
        }

        // returning the converted Binary
        return binaryString;
    }

    /**
     * Convert from the given input base to number in base 10. Return a String
     * being number that has been converted
     *
     * @param number number. It is a <code>java.lang.Integer</code> object
     * @param inBase the base that the number in. It is a
     * <code>java.lang.Integer</code> object
     * @return a String. It is a <code>java.lang.String</code> object
     */
    private String convertToDecimal(String number, int inBase) {
        int power = 0;
        int sumOfDigits = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            if (Character.isDigit(number.charAt(i))) {
                //Need to minus for 0 to get the actual integer
                sumOfDigits += (number.charAt(i) - '0') * Math.pow(inBase, power);
            } else {
                //Need to minus for 0 to get the actual integer
                //Minus 55 to get 10 which mean A in base 16
                sumOfDigits += (number.charAt(i) - 55) * Math.pow(inBase, power);
            }
            power += 1;
        }
        //The sum is already in base 10
        return Integer.toString(sumOfDigits);
    }

}
