package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Person implements Comparable<Person>{

	public static void main(String[] args) {
		
		ArrayList<Person> names = new ArrayList<Person>();
		Scanner in = new Scanner(System.in);
		
		for(int i=1;i<11;i++){
			System.out.print("Enter name" + i+":");
			Person a = new Person(in.nextLine());
			names.add(a);
		}//end for loop
		
		in.close();
		Collections.sort(names);
		System.out.println("First Person: " + names.get(0).toString());
		System.out.println("Last Person: " + names.get(names.size()-1));
	}//end main

	private String name;

	public String getName() {
		return name;
	}//end getName
	public void setName(String name) {
		this.name = name;
	}//end setName
	public Person(String name){
		this.setName(name);
	}//end Person constructor
	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}//end compareTo

	public String toString(){
		return name;
	}//end toString
}//end Person class
