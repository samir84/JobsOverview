package com.hs.eai.jobsoverview.model;

// Generated 2-jul-2012 15:30:42 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * NonWorkingDaysId generated by hbm2java
 */
@SuppressWarnings("serial")
public class NonWorkingDaysId implements java.io.Serializable {

	private Date date;
	private int salesOrganizationId;

	public NonWorkingDaysId() {
	}

	public NonWorkingDaysId(Date date, int salesOrganizationId) {
		this.date = date;
		this.salesOrganizationId = salesOrganizationId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSalesOrganizationId() {
		return this.salesOrganizationId;
	}

	public void setSalesOrganizationId(int salesOrganizationId) {
		this.salesOrganizationId = salesOrganizationId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NonWorkingDaysId))
			return false;
		NonWorkingDaysId castOther = (NonWorkingDaysId) other;

		return ((this.getDate() == castOther.getDate()) || (this.getDate() != null
				&& castOther.getDate() != null && this.getDate().equals(
				castOther.getDate())))
				&& (this.getSalesOrganizationId() == castOther
						.getSalesOrganizationId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result + this.getSalesOrganizationId();
		return result;
	}

}
