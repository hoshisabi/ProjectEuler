package aoc;

import java.util.HashMap;
import java.util.Map;

public class aoc2021_0301
{
  public static void incrCountMap(Map<Integer, Integer> countMap, int i)
  {
    Integer newCount = countMap.get(i);
    if (newCount == null)
    {
      newCount = 0;
    }
    newCount++;
    countMap.put(i, newCount);
  }

  public static int getGamma(Map<Integer, Integer> oneCountMap, Map<Integer, Integer> zeroCountMap, int wordSize)
  {
    int gamma = 0;
    String binaryString = "";
    for (int i = 0; i < wordSize; i++)
    {
      Integer ones = oneCountMap.get(wordSize - 1 - i);
      Integer zeros = zeroCountMap.get(wordSize - 1 - i);
      if (ones > zeros)
      {
        int mask = 1 << i;
        gamma |= mask;
        binaryString = "1" + binaryString;
      }
      else
      {
        binaryString = "0" + binaryString;
      }
    }
    System.out.println("binaryString = " + binaryString);
    return gamma;
  }

  public static int getEpsilon(int gamma, int wordSize)
  {
    int mask = (1 << wordSize) - 1;
    return mask ^ gamma;
  }

  public static int mcb(String arr[])
  {
    int wordSize = arr[0].length();

    Map<Integer, Integer> oneCount = new HashMap(wordSize);
    Map<Integer, Integer> zeroCount = new HashMap(wordSize);
    for (String item : arr)
    {
      System.out.println("item = " + item);
      for (int i = 0; i < wordSize; i++)
      {
        String oneChar = item.substring(i, i + 1);
        System.out.println(oneChar);
        if (oneChar.equals("0"))
        {
          incrCountMap(zeroCount, i);
        }
        else
        {
          incrCountMap(oneCount, i);
        }
      }
    }
    System.out.println("zeroCount = " + zeroCount);
    System.out.println("oneCount = " + oneCount);

    int gamma = getGamma(oneCount, zeroCount, wordSize);
    int epsilon = getEpsilon(gamma, wordSize);
    System.out.println(gamma);
    System.out.println(epsilon);
    System.out.println("Multiplied: " + gamma * epsilon);

    return 0;
  }


  public static void main(String[] arr)
  {
    System.out.println("mcb(new int[]{}) = " + mcb(new String[]{
        "010011001001",
        "110101011110",
        "111111000101",
        "100111111001",
        "000000011111",
        "111100100111",
        "011111100000",
        "001001011100",
        "101100111011",
        "010001010100",
        "111011001010",
        "010001100011",
        "110110011011",
        "011011000001",
        "001100101100",
        "001000101100",
        "100000001010",
        "001111110000",
        "100101000000",
        "010000100000",
        "010100110000",
        "110000111101",
        "000001011010",
        "000011011001",
        "011000101110",
        "100011100101",
        "110010010100",
        "001110110101",
        "100011000000",
        "110100111100",
        "100100001111",
        "010110011001",
        "000001111101",
        "100001000010",
        "110010101110",
        "000101001100",
        "100100010010",
        "111111101000",
        "001010111001",
        "100101000001",
        "001101101110",
        "101100011010",
        "100100011100",
        "111100000111",
        "101011000100",
        "110000101010",
        "101100111010",
        "101100010101",
        "001011111101",
        "011010000110",
        "001101000011",
        "110001001110",
        "011010101111",
        "001111111011",
        "001100100001",
        "111010110001",
        "011011111100",
        "001011111001",
        "111110111110",
        "011111001011",
        "110110011101",
        "111110011011",
        "101101010010",
        "110111011110",
        "111011110100",
        "111110001011",
        "110100000010",
        "000011111001",
        "100001001111",
        "101110101010",
        "000111111011",
        "011110110001",
        "000011110110",
        "011101001011",
        "010011001110",
        "101110011110",
        "110101010011",
        "111010100011",
        "010101011001",
        "011011010101",
        "000010110100",
        "010011001000",
        "110000010010",
        "101111111001",
        "000100111011",
        "011101010101",
        "100011101111",
        "001010110100",
        "101101000110",
        "011100111011",
        "000100010111",
        "010111100000",
        "100100111110",
        "110110001111",
        "010010010111",
        "001000001110",
        "001110000101",
        "001111101100",
        "101100111110",
        "111011010111",
        "110110111000",
        "000111110001",
        "111001101001",
        "011111001000",
        "001110100011",
        "111100100010",
        "010111101000",
        "111100110101",
        "111100111010",
        "010100110110",
        "100101111100",
        "101000011000",
        "011011111111",
        "010000111100",
        "101111000000",
        "100001011000",
        "110010010110",
        "111000011011",
        "010100110111",
        "100100110011",
        "000010011101",
        "010001100111",
        "011000110011",
        "100101001101",
        "110111011011",
        "000100001000",
        "011111100101",
        "110110111100",
        "100010010100",
        "110110110111",
        "111000111011",
        "101101111000",
        "000000110110",
        "101111111010",
        "000110000001",
        "011111000110",
        "110010100111",
        "111010101111",
        "101011000010",
        "011001010111",
        "010100111110",
        "110001111000",
        "110101101111",
        "011001000110",
        "111000111111",
        "010100100111",
        "100001100001",
        "110101011010",
        "000110111000",
        "101101001010",
        "010110100110",
        "111101101010",
        "110100011111",
        "101010010000",
        "001100001001",
        "001000000101",
        "111000010001",
        "100100101100",
        "001111100011",
        "110110010000",
        "011010111010",
        "011001110110",
        "000000100111",
        "011110111100",
        "011101000101",
        "011000111010",
        "110110100011",
        "101110101000",
        "111001111001",
        "010001000001",
        "111000111100",
        "001011101011",
        "110111111111",
        "010111011101",
        "110010001010",
        "011111000100",
        "011001100110",
        "011100000010",
        "000101100010",
        "000111111010",
        "000000010101",
        "010011110110",
        "000111111101",
        "101101000010",
        "101111010001",
        "011110001101",
        "100000000111",
        "110111111110",
        "000010011110",
        "111000010010",
        "110011110011",
        "101101101011",
        "011011101110",
        "101011011000",
        "000101101001",
        "010110100011",
        "011001100111",
        "011101000011",
        "001110010110",
        "001001010010",
        "111110101001",
        "001111001001",
        "010101001111",
        "100111100001",
        "011100010101",
        "100001110011",
        "010001110001",
        "101011010101",
        "000100000110",
        "100101110001",
        "100101110010",
        "111011011001",
        "100110101101",
        "101100110001",
        "101111100101",
        "001010000000",
        "011000100011",
        "010010001111",
        "011100011101",
        "001100110010",
        "000001011111",
        "101111000011",
        "111000111110",
        "011111100100",
        "100110000000",
        "011110110100",
        "001100101011",
        "110010101010",
        "010011100100",
        "011000010100",
        "001101100101",
        "101010101000",
        "011110011010",
        "010010001100",
        "010100010001",
        "010001011011",
        "110010011001",
        "010111000101",
        "111011010110",
        "111010111100",
        "011111101000",
        "100110010100",
        "010101011011",
        "010111001011",
        "011110010011",
        "011000011110",
        "100001000111",
        "000011111101",
        "111100101001",
        "000000100011",
        "110011100100",
        "101111100001",
        "010011110111",
        "101000001011",
        "001101111001",
        "100111000011",
        "000001000100",
        "100100010000",
        "000010010100",
        "000111111001",
        "000100100010",
        "011011011111",
        "010110011110",
        "001101010011",
        "110111101001",
        "111011101111",
        "100110000100",
        "001101110111",
        "010101101110",
        "011010100011",
        "010010100101",
        "101110110110",
        "111000001011",
        "010001101000",
        "111101100110",
        "100111010001",
        "100010011010",
        "101111001000",
        "011000100000",
        "111000010101",
        "100101011001",
        "011011110011",
        "110011001010",
        "000110010111",
        "101000010011",
        "100100111100",
        "001111000001",
        "001110101101",
        "100111100011",
        "011001011101",
        "111000000000",
        "101001010011",
        "000000111101",
        "000011000000",
        "001011000100",
        "011111111011",
        "000111101111",
        "101100011000",
        "111011000001",
        "101000000111",
        "111110000100",
        "101001110100",
        "010111000001",
        "010010101001",
        "110011001111",
        "100010000010",
        "001001001010",
        "100110010110",
        "101100110010",
        "111000111010",
        "101110011111",
        "110111111001",
        "011010110011",
        "111010100010",
        "110000011000",
        "011000101011",
        "001001000001",
        "000100110010",
        "111100000000",
        "001010100101",
        "101011010110",
        "110001010100",
        "101111010000",
        "000110000000",
        "111110011000",
        "110011110111",
        "011010111001",
        "001100110110",
        "111111111101",
        "001010010001",
        "101001111000",
        "000100110101",
        "000100111111",
        "100000110111",
        "001011100001",
        "001010111000",
        "100010101100",
        "110110000111",
        "100101010010",
        "101001001010",
        "110000011101",
        "111010010101",
        "001011011000",
        "101101101001",
        "010101111011",
        "101010011100",
        "000010000011",
        "001110110110",
        "111100001111",
        "011000000001",
        "000000111010",
        "000110011110",
        "010100110010",
        "000111010000",
        "110111110111",
        "110000000101",
        "011111111111",
        "010101000011",
        "110000101000",
        "000001110001",
        "010001010010",
        "100100010110",
        "000100101110",
        "100011011000",
        "000110010001",
        "100000001001",
        "011010010001",
        "010111101011",
        "101101101100",
        "001101100001",
        "010101111101",
        "001010101110",
        "001110001001",
        "100101110110",
        "001000110011",
        "010001011110",
        "100110011001",
        "010100101110",
        "101101111011",
        "001110110011",
        "000111001111",
        "100100110110",
        "101000111101",
        "100000111100",
        "111000101100",
        "000010010011",
        "001100001101",
        "111101011011",
        "001100101010",
        "001000010001",
        "011001010010",
        "111011101011",
        "010010001101",
        "000100100011",
        "111110001111",
        "110010001111",
        "010001100010",
        "101101110001",
        "101100110011",
        "110111111011",
        "011011010100",
        "011101100101",
        "111111000100",
        "101111001001",
        "010000000100",
        "011001111110",
        "110101111100",
        "111111100001",
        "111011000100",
        "100110100001",
        "101001110000",
        "001011010010",
        "011010001000",
        "110010001110",
        "000101111001",
        "010100100110",
        "011100110100",
        "000011111000",
        "100100000111",
        "110111001000",
        "111100001110",
        "001010101100",
        "010111111011",
        "111010100100",
        "101000011101",
        "110111100110",
        "111100110100",
        "000010011010",
        "000110101111",
        "001101010001",
        "010010000111",
        "011000100001",
        "110111100100",
        "010011100101",
        "011001001011",
        "101101010100",
        "010000010001",
        "001001110001",
        "100010000110",
        "111101111011",
        "011110100101",
        "000101001000",
        "111110011100",
        "000001101110",
        "111101000001",
        "100111000100",
        "011110100011",
        "110000101011",
        "000010011111",
        "000101011001",
        "101100111001",
        "011010000111",
        "000010001011",
        "010001111110",
        "000010111110",
        "101001111110",
        "000110001101",
        "001100101001",
        "000101111011",
        "110000100110",
        "110001000011",
        "000001111100",
        "010100111010",
        "011001000001",
        "110111000010",
        "110011101010",
        "001101101000",
        "100110100011",
        "000010101010",
        "101101111010",
        "111111100111",
        "010101000000",
        "011010011110",
        "011110100100",
        "100000110000",
        "011111011100",
        "011000001110",
        "000010000010",
        "101011010010",
        "010101110000",
        "110001000000",
        "011111111100",
        "101110110010",
        "111111011001",
        "100000110110",
        "111010100111",
        "000001100101",
        "101010010111",
        "010000110110",
        "001000010111",
        "101000100000",
        "100101000011",
        "111100011011",
        "010110001101",
        "101010100110",
        "101111111101",
        "100000111001",
        "011100001000",
        "110111011000",
        "100011101101",
        "101101110011",
        "000010101100",
        "000011000001",
        "011110110110",
        "001100011110",
        "010100111111",
        "011111101011",
        "000011110100",
        "001000100111",
        "010000000101",
        "111001111000",
        "111001010001",
        "001100000001",
        "110110111010",
        "101000011010",
        "010100111001",
        "000100111100",
        "110000100011",
        "100000101011",
        "001001001110",
        "101110111101",
        "110101001110",
        "101110110100",
        "001111110101",
        "100000010101",
        "110000011010",
        "111101100011",
        "101001100100",
        "100010100001",
        "011001010000",
        "111001110000",
        "101000100111",
        "100111011110",
        "000000101111",
        "101000110000",
        "110100001111",
        "001101101010",
        "010011001101",
        "000110011101",
        "101011110000",
        "100010011110",
        "101010100011",
        "000110111011",
        "000101110110",
        "001000000011",
        "011011111010",
        "101011101111",
        "000011010101",
        "010001011101",
        "001010011100",
        "011111111000",
        "111011100111",
        "010111010001",
        "010111101001",
        "101000110100",
        "000001010000",
        "010001000101",
        "000010111101",
        "010101101111",
        "010100001010",
        "100010011101",
        "011111011001",
        "111010001001",
        "000110011011",
        "000001001000",
        "100011011111",
        "110001011000",
        "001101011000",
        "000010001101",
        "100100101111",
        "110101111011",
        "000010010110",
        "001110011010",
        "100110101000",
        "100101101100",
        "110011101101",
        "000011011011",
        "110110010110",
        "001111011110",
        "100111010100",
        "011001000000",
        "011011100001",
        "101100111000",
        "010001000011",
        "010110010110",
        "101010110100",
        "101011100100",
        "110001110101",
        "110110001100",
        "000100011011",
        "110100010000",
        "101010110001",
        "110010111000",
        "110011100101",
        "010000100100",
        "101100000011",
        "111101111101",
        "000100001100",
        "000000101011",
        "101101100000",
        "000111000110",
        "010100001000",
        "011110100001",
        "101101110010",
        "110010001101",
        "011100001001",
        "001100111111",
        "000011011010",
        "001110011110",
        "000010011000",
        "111001100010",
        "110100010001",
        "100001000100",
        "000110100000",
        "111011110111",
        "001011110000",
        "000001100010",
        "001000110001",
        "110001000010",
        "010100000011",
        "010110001111",
        "100111001001",
        "011100011011",
        "011101101111",
        "110000101100",
        "101111011111",
        "101111000110",
        "111001101011",
        "011011101111",
        "010110010101",
        "100001001100",
        "011101110011",
        "000001100001",
        "001000110111",
        "011000110001",
        "111000000111",
        "000100101001",
        "101100101101",
        "000100010110",
        "110010101001",
        "100110011100",
        "000111010011",
        "110100000100",
        "101011001110",
        "010011110001",
        "010110110100",
        "111111001000",
        "010100101111",
        "101111101000",
        "011110101000",
        "001011111000",
        "111110010111",
        "101101010000",
        "111111010100",
        "100111010011",
        "011101010011",
        "100000111110",
        "100010111111",
        "011011100010",
        "111000011101",
        "010100001101",
        "010100001011",
        "001111101001",
        "011001111100",
        "111101000111",
        "000100000000",
        "110101111001",
        "111010011111",
        "010010011101",
        "001101101011",
        "110111101111",
        "001000111001",
        "100010110000",
        "000000000101",
        "101001000001",
        "001110001101",
        "110111001101",
        "111010101110",
        "101001000110",
        "000011100011",
        "010101001101",
        "000111000001",
        "001011011101",
        "111100011101",
        "111101000110",
        "101101001011",
        "101110010101",
        "110100111000",
        "000010101101",
        "000110000110",
        "100001110001",
        "011010010000",
        "110000011111",
        "101011011110",
        "000010001111",
        "100001100101",
        "111010000001",
        "010010001011",
        "011111110100",
        "000001010010",
        "110010010111",
        "011000001000",
        "011101010100",
        "111110111101",
        "111100010100",
        "001101111000",
        "011110000001",
        "111011111001",
        "111011011011",
        "001010010011",
        "011011001110",
        "101101111111",
        "001101011001",
        "010111001000",
        "101110001011",
        "111101100111",
        "001101110010",
        "100001100110",
        "010100010100",
        "110010111011",
        "110011110110",
        "010110011101",
        "101101011001",
        "001111110011",
        "100000001100",
        "110010000000",
        "001011001100",
        "001111111100",
        "110010100101",
        "100000101100",
        "011000101101",
        "000101000010",
        "100100110001",
        "010111111110",
        "101111110100",
        "100001101011",
        "111010100001",
        "100111101010",
        "100110110000",
        "000101011000",
        "100011110011",
        "110100101101",
        "010011011011",
        "011010000001",
        "010000100001",
        "001101111110",
        "110000000010",
        "011010000000",
        "100110111001",
        "101011000011",
        "100101010101",
        "001100110111",
        "001111011001",
        "110000110100",
        "111101000000",
        "110101010100",
        "011100110111",
        "001100100000",
        "111110010110",
        "101010111010",
        "110100011010",
        "110010010010",
        "101000101101",
        "111110010010",
        "100111001000",
        "110000101110",
        "100001101110",
        "100011010110",
        "000101000001",
        "000010110111",
        "000110000100",
        "011101110101",
        "111100011010",
        "000000010100",
        "111100011000",
        "110110101011",
        "001100010101",
        "000010010010",
        "010100110001",
        "001001010110",
        "100110000011",
        "110100100001",
        "000111110010",
        "011000011011",
        "111101001000",
        "001101110101",
        "001101110110",
        "010101101010",
        "110111000011",
        "011110000010",
        "011010011011",
        "111100110001",
        "010001001000",
        "000101100110",
        "010001110111",
        "010000101000",
        "000000100000",
        "100011001011",
        "100001111110",
        "100011111101",
        "101101001110",
        "101110110011",
        "100000011111",
        "001101010111",
        "111101100000",
        "011010001111",
        "101001010010",
        "100010100000",
        "011000100111",
        "101100100000",
        "011011000011",
        "001101001011",
        "001010001011",
        "110100000001",
        "111110001000",
        "101000010101",
        "100011000010",
        "010110101000",
        "011101011111",
        "000110001000",
        "101100000111",
        "110100101001",
        "101001101001",
        "010111000011",
        "011101000001",
        "101011001000",
        "110101001101",
        "010010100110",
        "111001110011",
        "010111010010",
        "010011101100",
        "001110111100",
        "010111011110",
        "000010001100",
        "111000001001",
        "001100101110",
        "111001100011",
        "010000011001",
        "111010111111",
        "010011111111",
        "011100100110",
        "001001101111",
        "001000111110",
        "010101111000",
        "011011001011",
        "101110001100",
        "010100010010",
        "000001011011",
        "000001100100",
        "000000010011",
        "000001110011",
        "010101001000",
        "110110100001",
        "001101101101",
        "011010001110",
        "101011100110",
        "110001100101",
        "110100100110",
        "101010110000",
        "110100110101",
        "011101000100",
        "101110001010",
        "001100110101",
        "000100011110",
        "101110111001",
        "011111101010",
        "010110001010",
        "110111110010",
        "001000101110",
        "100011001100",
        "010011010101",
        "100101001001",
        "111011001110",
        "101100000100",
        "000010111100",
        "111000101111",
        "010001001100",
        "010011110100",
        "010010110000",
        "001111101110",
        "111110110111",
        "101010000010",
        "010001101101",
        "111001000000",
        "100011001010",
        "100000111111",
        "110000001101",
        "000000111110",
        "010011100111",
        "010110110010",
        "010110010000",
        "011010001001",
        "101000110101",
        "111110001010",
        "100101001010",
        "011000001001",
        "011100010111",
        "111010111000",
        "011011001100",
        "001010000100",
        "011100001110",
        "001001110010",
        "110001000110",
        "100100010111",
        "101110001101",
        "000100001001",
        "001001011111",
        "100111100100",
        "100001100011",
        "000011011110",
        "101011111110",
        "111000011000",
        "000100001010",
        "011111010111",
        "011001010100",
        "011101110111",
        "001100000110",
        "100011011101",
        "011010111111",
        "010110100111",
        "011000111001",
        "000100111010",
        "011001001110",
        "111010001000",
        "110011000101",
        "110001101010",
        "001101100111",
        "101011101010",
        "000001001010",
        "110110010100",
        "100000000001",
        "000011011101",
        "010011101110",
        "101001100110",
        "111110011001",
        "110010100000",
        "100011000100",
        "111111000001",
        "010000100011",
        "000100010010",
        "010111000010",
        "011111101001",
        "101101100100",
        "011011000101",
        "111110010000",
        "001000000000",
        "011000001011",
        "111111110110",
        "011010110110",
        "000001111110",
        "011101001000",
        "110101010000",
        "110001010000",
        "101000100001",
        "111100001001",
        "000000000110",
        "100000011101",
        "101001011011",
        "000001001100",
        "110000010110",
        "110000001011",
        "000101101101",
        "001011000111",
        "100110011111",
        "011111011101",
        "110010101111",
        "000000000001",
        "000101110001",
        "100011000001",
        "100101010011",
        "100011010111",
        "001101100000",
        "001100111110",
        "100101000111",
        "100011110111",
        "100000110011",
        "111010000101",
        "010101110110",
        "101010001011",
        "011001100100",
        "111101110011",
        "110011000001",
        "111011101100",
        "110010011010",
        "111100010011",
        "001011011001",
        "000000000000",
        "001000001101",
        "001110010001",
        "000011010100",
        "100001010101",
        "101010001000",
        "110100011011",
        "011100111000",
        "111111111001",
        "100101001110",
        "100011100011",
        "101000101000",
        "010101110101",
        "011100011100"
    }));
//    System.out.println("mcb(new int[]{}) = "+ mcb(new String[]{
//        "00100",
//        "11110",
//        "10110",
//        "10111",
//        "10101",
//        "01111",
//        "00111",
//        "11100",
//        "10000",
//        "11001",
//        "00010",
//        "01010"}));
  }
}
