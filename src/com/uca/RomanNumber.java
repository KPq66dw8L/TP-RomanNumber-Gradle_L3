package com.uca;

public class RomanNumber extends Number implements Comparable{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	
	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		// TODO
		Double d = new Double(this.value);
		return d;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {
		// TODO
		float f = this.value;
		return f;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		// TODO
		return this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		// TODO
		long l = this.value;
		return l;
	}

	@Override
	public String toString() {
		//TODO
		return this.roman;
	}

	@Override
	public int compareTo(Object o) {
		String type = o.getClass().getSimpleName();

		switch(type) {
			case "Integer":
				if (this.intValue() > (int) o) {
					return 1;
				}
				else {
					if (this.intValue() == (int) o) {
						return 0;
					}
					else {
						return -1;
					}
				}
			case "Long":
				if (this.longValue() > (long) o) {
					return 1;
				}
				else {
					if (this.longValue() == (long) o) {
						return 0;
					}
					else {
						return -1;
					}
				}
			case "Double":
				if (this.doubleValue() > (double) o) {
					return 1;
				}
				else {
					if (this.doubleValue() == (double) o) {
						return 0;
					}
					else {
						return -1;
					}
				}
			case "Float":
				if (this.floatValue() > (float) o) {
					return 1;
				}
				else {
					if (this.floatValue() == (float) o) {
						return 0;
					}
					else {
						return -1;
					}
				}
			case "String":
			case "RomanNumber":
				if (this.intValue() > RomanConverter.getNumberFromRoman((String) o)) {
					return 1;
				}
				else {
					if (this.toString().equals((String) o)) {
						return 0;
					}
					else {
						return -1;
					}
				}
		}
		return 0;
	}
}