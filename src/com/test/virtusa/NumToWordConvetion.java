package com.test.virtusa;

import java.util.HashMap;
import java.util.Map;

public class NumToWordConvetion {

	static Map<String, String> wordMapping;
	static Map<String, String> wordTenthPosition;

	public static void main(String[] args) {
		
		String inputNum = "56945711";
		convertTostr(inputNum.trim());
	}

	private static void convertTostr(String inputNum) {
		System.out.println(inputNum);
		StringBuilder inWords = new StringBuilder();
		String numReverse = "";
		createnumberMap();
		createTenthMap();

		if (inputNum.contains(" ")) {
			System.err.println("Not a valid number");
			System.exit(0);
		}

		try {
			for (int index = 0; index < inputNum.length(); index++) {
				numReverse = String.valueOf(inputNum.charAt(index) + numReverse);
			}
			for (int index = numReverse.length() - 1; index >= 0; index--) {
				if (numReverse.charAt(index) != '0')
					inWords.append(wordMapping(String.valueOf(numReverse.charAt(index)), index));
			}
			System.out.println(inWords);
		} catch (IndexOutOfBoundsException e) {
			System.err.println(" Error occured while traversing for loop ");
		} catch (Exception e) {
			System.err.println("Unexpected error while procesing num to word converter");

		}
	}

	/**
	 * 
	 * @param num
	 * @param index
	 * @return in words for number position
	 * @throws IndexOutOfBoundsException
	 */
	private static String wordMapping(String num, int index) throws IndexOutOfBoundsException {

		if (index == 1 || index == 4 || index == 7) {
			return wordTenthPosition.get(num);
		}
		if (index == 2 || index == 5) {
			return wordMapping.get(num) + " hundred and";
		}
		if (index == 3) {
			return wordMapping.get(num) + " thousand";
		}

		if (index == 6) {
			return wordMapping.get(num) + " million ";
		}

		return wordMapping.get(num);

	}

	/**
	 * method used to created map tenth number with word
	 */

	private static void createTenthMap() {
		wordTenthPosition.put("1", " one");
		wordTenthPosition.put("2", " twenty");
		wordTenthPosition.put("3", " thirty");
		wordTenthPosition.put("4", " fourty");
		wordTenthPosition.put("5", " fifty");
		wordTenthPosition.put("6", " sixty");
		wordTenthPosition.put("7", " seventy");
		wordTenthPosition.put("8", " eighty");
		wordTenthPosition.put("9", " ninety");
	}

	/**
	 * method used to created map number with word
	 */
	private static void createnumberMap() {
		wordMapping = new HashMap<String, String>();
		wordTenthPosition = new HashMap<String, String>();
		wordMapping.put("1", " one");
		wordMapping.put("2", " two");
		wordMapping.put("3", " three");
		wordMapping.put("4", " four");
		wordMapping.put("5", " five");
		wordMapping.put("6", " six");
		wordMapping.put("7", " seven");
		wordMapping.put("8", " eight");
		wordMapping.put("9", " nine");
	}

}
