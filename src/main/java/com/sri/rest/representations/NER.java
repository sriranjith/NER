package com.sri.rest.representations;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class NER {

	@NotNull
	String type;

	@NotNull
	String entity;

	@NotNull
	@DecimalMax("1.00")
	@DecimalMin("0.00")
	double probablity;

	public NER(String type, String entity, double prob) {
		this.type = type;
		this.entity = entity;
		this.probablity = prob;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public double getProbablity() {
		return probablity;
	}

	public void setProbablity(double probablity) {
		this.probablity = probablity;
	}
}
