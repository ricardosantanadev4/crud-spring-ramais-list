package br.com.rsds.ramais.enums;

public enum Paused {
	PAUSED_SIM("SIM"), PAUSED_NAO("NAO");

	private String value;

	private Paused(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

}
