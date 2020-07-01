package com.contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public boolean isValid(String name) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher test = pattern.matcher(name);
		if (test.matches()) {
			return true;
		}
		return false;
	}

	public boolean isValidNo(String number) {
		Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher test = pattern.matcher(number);
		if (test.matches()) {
			return true;
		}
		return false;
	}

	public boolean isValidHno(String number) {
		Pattern pattern = Pattern.compile("^[0-9]{10}$");
		Matcher test = pattern.matcher(number);
		if (test.matches()) {
			return true;
		}
		return false;
	}

	public boolean isValidEmail(String email) {
		Pattern pattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher test=pattern.matcher(email);
		if (test.matches()) {
			return true;
		}
		return false;
	}	
}
class Data{
	public boolean isValid(String name) {
	      if(name == null) {
	    	  return false;
	      }
	      for (int i = 0; i < name.length(); i++) {
	         char ch = name.charAt(i);
	         if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
	            return false;
	         }
	      }
	      return true;
	}
		
	public boolean isValidNo(String number) {
			for(int i = 0;i<number.length();i++) {
				char ch=number.charAt(i);
				if(!(ch >= '0' && ch <= '9') || number.length()!=10) {
					return false;
				}
		}
		return true;
	}

	public boolean isValidEmail(String email) {
	         if (email.contains("@") && email.contains(".")) {
	            return true;
	         }
	      return false;
	}
}
