package com.data;

import java.util.*;

class Screen {
	private String name;
	private String lname;
	Screen(String name,String lname){
		this.name=name;
		this.lname=lname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return name+" "+lname;
	}
}
class Odd implements Comparator<Screen> {
	public int compare(Screen o1, Screen o2) {
		if(o1.getName().equals(o2.getName())) {
			return o1.getLname().compareTo(o2.getLname());
		}else
		{
			return o1.getName().compareTo(o2.getName());
		}
	}
}
public class Name {
	public static void main(String[] args) {
		ArrayList<Screen> al = new ArrayList<Screen>();
		al.add(new Screen("Arun","Babu"));
		al.add(new Screen("Naran","Murali"));
		al.add(new Screen("Naran","Alpha"));
		al.add(new Screen("Zen","Kiran"));
		Collections.sort(al, new Odd());
		for(Screen per :al)	{
			System.out.println(per);
		}
	}

}
