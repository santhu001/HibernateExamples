package com.santhu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiradiousTest {

	public static void main(String[] args) {
		HiradiousTest test = new HiradiousTest();
		String mydata = "(* 5 2) (- 6 3)";
		Pattern pattern = Pattern.compile("\\(([^?m)]+)\\)");
		Matcher matcher = pattern.matcher(mydata);
		if (matcher.find())
		{
		    System.out.println(matcher.group(0));
		}
		//System.out.println(test.parse("(/ (+ 5 (* 4 7 (- 8 3)) 5) 3)"));
		//System.out.println(test.parse("(+ 3 (* 5 2) (- 6 3))"));
	}

	public int parse(String input) {
		int output = 0;
		switch (input.charAt(1)) {
		case '+':
			input = input.substring(2, input.length() - 1).trim();
			if (input.contains("(")) {
				int f = input.indexOf("(");
				int l = input.lastIndexOf(")");
				String min = input.substring(0, f) + input.substring(l + 1);

				for (String str : min.split(" ")) {
					output += !str.isEmpty() ? Integer.parseInt(str) : 0;
				}
				output += parse(input.substring(f, l + 1));
			} else {
				for (String str : input.split(" ")) {
					output += !str.isEmpty() ? Integer.parseInt(str) : 0;
				}
			}
			break;
		case '-':
			input = input.substring(2, input.length() - 1).trim();
			if (input.contains("(")) {
				int f = input.indexOf("(");
				int l = input.lastIndexOf(")");
				String min = input.substring(0, f) + input.substring(l + 1);
				if (output == 0) {
					output = parse(input.substring(f, l + 1));
				} else {
					output -= parse(input.substring(f, l + 1));
				}
				for (String str : min.split(" ")) {
					if (output == 0) {
						output = !str.isEmpty() ? Integer.parseInt(str) : 0;
					} else {
						output -= !str.isEmpty() ? Integer.parseInt(str) : 0;
					}
				}

			} else {
				for (String str : input.split(" ")) {
					if (output == 0) {
						output = !str.isEmpty() ? Integer.parseInt(str) : 0;
					} else {
						output -= !str.isEmpty() ? Integer.parseInt(str) : 0;
					}
				}
			}
			break;
		case '*':
			output = 1;
			input = input.substring(2, input.length() - 1).trim();
			if (input.contains("(")) {
				int f = input.indexOf("(");
				int l = input.lastIndexOf(")");
				String min = input.substring(0, f) + input.substring(l + 1);

				for (String str : min.split(" ")) {
					output *= !str.isEmpty() ? Integer.parseInt(str) : 1;
				}
				output *= parse(input.substring(f, l + 1));
			} else {
				for (String str : input.split(" ")) {
					output *= !str.isEmpty() ? Integer.parseInt(str) : 1;
				}
			}
			break;
		case '/':
			input = input.substring(2, input.length() - 1).trim();
			if (input.contains("(")) {
				int f = input.indexOf("(");
				int l = input.lastIndexOf(")");
				String min = input.substring(0, f) + input.substring(l + 1);
				if (output == 0) {
					output = parse(input.substring(f, l + 1));
				} else {
					output /= parse(input.substring(f, l + 1));
				}
				for (String str : min.split(" ")) {
					if (output == 0) {
						output = !str.isEmpty() ? Integer.parseInt(str) : 1;
					} else {
						output /= !str.isEmpty() ? Integer.parseInt(str) : 1;
					}
				}

			} else {
				for (String str : input.split(" ")) {
					if (output == 0) {
						output = !str.isEmpty() ? Integer.parseInt(str) : 1;
					} else {
						output /= !str.isEmpty() ? Integer.parseInt(str) : 1;
					}
				}
			}
			break;
		default:
			break;
		}
		return output;
	}

}
