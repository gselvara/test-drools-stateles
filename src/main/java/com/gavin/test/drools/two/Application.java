package com.gavin.test.drools.two;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Application {
	private Date dateApplied;
	private boolean valid;

	public Application(Date dateApplied) {
		super();
		this.dateApplied = dateApplied;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
