package com.example.ascoresdosalimentos;

public class Food {
	int resource;
	String name;
	boolean state = false;
	
	public Food(int resource, String name){
		this.resource =resource;
		this.name = name;
	}
	
	public int getResource(){
		return resource;
	}
	
	public void setResource(int resource){
		this.resource = resource;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean state){
		this.state = state;
	}

}