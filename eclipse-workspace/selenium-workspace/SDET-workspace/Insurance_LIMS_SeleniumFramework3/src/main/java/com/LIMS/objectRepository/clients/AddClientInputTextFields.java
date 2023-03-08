package com.LIMS.objectRepository.clients;

/**
 * This enum contains all the constant and its value related to add client input
 * text fields
 * 
 * @author kishore mallarapu
 *
 */
public enum AddClientInputTextFields {
	CLIENT_PASSWORD("client_password"), NAME("name"), IMAGE("fileToUpload"), GENDER("sex"), BIRTHDATE("birth_date"),
	MARRITAL_STATUS("maritial_status"), NATIONAL_ID("nid"), PHONE("phone"), ADDRESS("address"), POLICY_ID("policy_id"),
	NOMINEE_NAME("nominee_name"), NOMINEE_GENDER("nominee_sex"), NOMINEE_DOB("nominee_birth_date"),
	NOMINEE_NID("nominee_nid"), NOMINEE_RALATIONSHIP("nominee_relationship"), NOMINEE_PRIORITY("priority"),
	NOMINEE_PHONE("nominee_phone");

	private String inputTextField;

	private AddClientInputTextFields(String inputTextField) {
		this.inputTextField = inputTextField;

	}

	public String getInputField() {
		return inputTextField;

	}

}
