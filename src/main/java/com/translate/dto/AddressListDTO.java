package com.translate.dto;

import java.io.Serializable;

public class AddressListDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1548345312349838312L;

	/** The address list ID. */
	private Integer addressListID;

	/** The name. */
	private String name;

	/** The parent address list ID. */
	private Integer parentAddressListID;

	/**
	 * Instantiates a new address list DTO.
	 */
	public AddressListDTO() {

		/*
		 * EMPTY
		 */
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
	 * Gets the parent address list ID.
	 *
	 * @return the parentAddressListID
	 */
	public Integer getParentAddressListID() {

		return parentAddressListID;
	}

	/**
	 * Sets the parent address list ID.
	 *
	 * @param parentAddressListID the parentAddressListID to set
	 */
	public void setParentAddressListID(Integer parentAddressListID) {

		this.parentAddressListID = parentAddressListID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "AddressListDTO [addressListID=" + addressListID + ", name=" + name + ", parentAddressListID="
				+ parentAddressListID + "]";
	}

}
