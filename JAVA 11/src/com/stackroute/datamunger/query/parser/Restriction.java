package com.stackroute.datamunger.query.parser;

/*
 * This class is used for storing name of field, condition and value for 
 * each conditions
 * generate getter and setter for this class,
 * Also override toString method
 * */

public class Restriction {


	  	String		name;
	  	String		value;
	  	String		condition;

	// Write logic for constructor
	public Restriction(String name, String value, String condition) {
		this.name 		= name;
		this.value		= value;
		this.condition	= condition;
	}


	public void setName(String name){
		this.condition = name;
	}

	public void setValue(String value){
		this.condition = value;

	}

	public void setCondition(String condition){
		this.condition = condition;
	}

	public String getName(){
		return this.name;
	}

	public String getValue(){
		return this.value;
	}
	public String getCondition(){
		return this.condition;
	}



}