package de.vertixico.testProducer.dao;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Birne implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean saftig;
	private int reifegrad;
	
	public Birne(){
		
	}
	public Birne(String name, boolean saftig, int reifegrad){
		this.setName(name);
		this.setSaftig(saftig);
		this.setReifegrad(reifegrad);
	}
	@JsonProperty
	public String getName() {
		return name;
	}
	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty
	public boolean isSaftig() {
		return saftig;
	}
	@JsonProperty
	public void setSaftig(boolean saftig) {
		this.saftig = saftig;
	}
	@JsonProperty
	public int getReifegrad() {
		return reifegrad;
	}
	@JsonProperty
	public void setReifegrad(int reifegrad) {
		this.reifegrad = reifegrad;
	}
}
