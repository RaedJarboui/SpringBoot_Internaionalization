package com.translate.entity;

public enum SettingAddressTable {
	/** The address type. */
	ADDRESS_TYPE("AddressType"),

	/** The address list. */
	ADDRESS_LIST("AddressList"),

	/** The address list value. */
	ADDRESS_LIST_VALUE("AddressListValue"),

	/** The settings address. */
	SETTINGS_ADDRESS("SettingsAddress");

	/** The table name. */
	private String tableName;

	/**
	 * Instantiates a new setting address table.
	 *
	 * @param tableName the table name
	 */
	SettingAddressTable(String tableName) {

		this.tableName = tableName;
	}

	/**
	 * Table name.
	 *
	 * @return the string
	 */
	public String tableName() {

		return tableName;
	}

}
