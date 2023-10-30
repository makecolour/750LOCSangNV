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

import java.util.Map;

/**
 * The class act as an equivalent table for every base
 *
 * @author Nguyen Hoang Manh
 */
public class EquivalentTable {

    /**
     * Constructor allow this class to be called through object
     */
    public EquivalentTable() {

    }

    /**
     * The method is public static so it is allow to be called from other class
     * by class name Create Map of Binary string and its equivalent Hexadecimal
     * value
     *
     * @param binaryMap a map need to be created. It is a
     * <code>java.util.Map</code> object
     */
    public static void createBinaryToHexaMap(Map<String, Character> binaryMap) {
        binaryMap.put("0000", '0');
        binaryMap.put("0001", '1');
        binaryMap.put("0010", '2');
        binaryMap.put("0011", '3');
        binaryMap.put("0100", '4');
        binaryMap.put("0101", '5');
        binaryMap.put("0110", '6');
        binaryMap.put("0111", '7');
        binaryMap.put("1000", '8');
        binaryMap.put("1001", '9');
        binaryMap.put("1010", 'A');
        binaryMap.put("1011", 'B');
        binaryMap.put("1100", 'C');
        binaryMap.put("1101", 'D');
        binaryMap.put("1110", 'E');
        binaryMap.put("1111", 'F');
    }

    /**
     * The method is public static so it is allow to be called from other class
     * by class name Create Map of Hexadecimal value and its equivalent Binary
     * string
     *
     * @param hexaMap a map need to be created. It is a
     * <code>java.util.Map</code> object
     */
    public static void createHexaToBinaryMap(Map<Character, String> hexaMap) {
        hexaMap.put('0', "0000");
        hexaMap.put('1', "0001");
        hexaMap.put('2', "0010");
        hexaMap.put('3', "0011");
        hexaMap.put('4', "0100");
        hexaMap.put('5', "0101");
        hexaMap.put('6', "0110");
        hexaMap.put('7', "0111");
        hexaMap.put('8', "1000");
        hexaMap.put('9', "1001");
        hexaMap.put('A', "1010");
        hexaMap.put('B', "1011");
        hexaMap.put('C', "1100");
        hexaMap.put('D', "1101");
        hexaMap.put('E', "1110");
        hexaMap.put('F', "1111");
    }
}
