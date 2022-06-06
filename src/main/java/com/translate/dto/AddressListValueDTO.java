package com.translate.dto;

import java.io.Serializable;

public class AddressListValueDTO implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8070943182841206878L;

	/** The address list value ID. */
	private Integer addressListValueID;

	/** The name. */
	private String name;

	/** The address list ID. */
	private Integer addressListID;

	/** The parent address list value ID. */
	private Integer parentAddressListValueID;

	/** The code. */
	private String code;

	/** The c U account portfolio id. */
	private Long cUAccountPortfolioId;

	/**
	 * Instantiates a new address list value DTO.
	 */
	public AddressListValueDTO() {

		/*
		 * EMPTY
		 */
	}

	/**
	 * Gets the address list value ID.
	 *
	 * @return the addressListValueID
	 */
	public Integer getAddressListValueID() {

		return addressListValueID;
	}

	/**
	 * Sets the address list value ID.
	 *
	 * @param addressListValueID the addressListValueID to set
	 */
	public void setAddressListValueID(Integer addressListValueID) {

		this.addressListValueID = addressListValueID;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * Gets the address list ID.
	 *
	 * @return the addressListID
	 */
	public Integer getAddressListID() {

		return addressListID;
	}

	/**
	 * Sets the address list ID.
	 *
	 * @param addressListID the addressListID to set
	 */
	public void setAddressListID(Integer addressListID) {

		this.addressListID = addressListID;
	}

	/**
	 * Gets the parent address list value ID.
	 *
	 * @return the parentAddressListValueID
	 */
	public Integer getParentAddressListValueID() {

		return parentAddressListValueID;
	}

	/**
	 * Sets the parent address list value ID.
	 *
	 * @param parentAddressListValueID the parentAddressListValueID to set
	 */
	public void setParentAddressListValueID(Integer parentAddressListValueID) {

		this.parentAddressListValueID = parentAddressListValueID;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {

		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {

		this.code = code;
	}

	/**
	 * Gets the c U account portfolio id.
	 *
	 * @return the cUAccountPortfolioId
	 */
	public Long getcUAccountPortfolioId() {

		return cUAccountPortfolioId;
	}

	/**
	 * Sets the c U account portfolio id.
	 *
	 * @param cUAccountPortfolioId the cUAccountPortfolioId to set
	 */
	public void setcUAccountPortfolioId(Long cUAccountPortfolioId) {

		this.cUAccountPortfolioId = cUAccountPortfolioId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "AddressListValueDTO [addressListValueID=" + addressListValueID + ", name=" + name + ", addressListID="
				+ addressListID + ", parentAddressListValueID=" + parentAddressListValueID + ", code=" + code
				+ ", cUAccountPortfolioId=" + cUAccountPortfolioId + "]";
	}
}
