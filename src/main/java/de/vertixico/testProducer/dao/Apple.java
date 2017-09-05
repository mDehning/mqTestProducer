package de.vertixico.testProducer.dao;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Apple implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String redness;
	private Sorte sorte;
	
	public enum Sorte{
		altland, lecker, sauer
	}
	public Apple(){
		// Jackson
	}
	public Apple(String name, String redness, Sorte sorte){
		this.name = name;
		this.redness = redness;
		this.sorte = sorte;
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
	public String getRedness() {
		return redness;
	}
	@JsonProperty
	public void setRedness(String redness) {
		this.redness = redness;
	}
	@JsonProperty
	public Sorte getSorte() {
		return sorte;
	}
	@JsonProperty
	public void setSorte(Sorte sorte) {
		this.sorte = sorte;
	}
}
