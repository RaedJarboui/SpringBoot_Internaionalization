package com.translate.controller;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

public class CommonFunctions {
	/**
	 * Convert JSON string to object.
	 * 
	 * @author HaythemBenizid
	 * @param jSONString the j SON string
	 * @param clazz      the clazz
	 * @return the object
	 */
	public static Object convertJSONStringtoObject(String jSONString, Class<?> clazz) {

		// Creating a Gson Object with Date config
		JsonDeserializer<Date> dateJsonDeserializer = (json, typeOfT, context) -> json == null ? null
				: new Date(json.getAsLong());
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, dateJsonDeserializer).create();
		// Converting json to object && returning object
		return gson.fromJson(jSONString, clazz);
	}

}
