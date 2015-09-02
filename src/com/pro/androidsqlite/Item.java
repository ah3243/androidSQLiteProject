package com.pro.androidsqlite;

public class Item {
	
	//private variables
	int _id;
	String _name;
	String _price;
	String _description ;
	// Empty constructor
	public Item(){
		
	}
	// constructor
	public Item(int id, String name, String _price , String description){
		this._id = id;
		this._name = name;
		this._price = _price;
		this._description = description ;
	}
	
	// constructor
	public Item(String name, String _price ,String _description ){
		this._name = name;
		this._price = _price;
		this._description = _description ;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getName(){
		return this._name;
	}
	
	// setting name
	public void setName(String name){
		this._name = name;
	}
	
	// getting price
	public String getPrice(){
		return this._price;
	}
	
	// setting price
	public void setPrice(String price){
		this._price = price;
	}
	
	// getting description
		public String getDescription(){
			return this._description ;
		}
		
		// setting description
		public void setDescription(String description){
			this._description = description;
		}
}
