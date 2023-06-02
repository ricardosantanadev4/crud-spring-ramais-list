package br.com.rsds.ramais.enums.converters;

import java.util.stream.Stream;

import br.com.rsds.ramais.enums.Paused;
import jakarta.persistence.AttributeConverter;

public class PausedConverter implements AttributeConverter<Paused, String> {

	@Override
	public String convertToDatabaseColumn(Paused attribute) {
		return attribute.getValue();
	}

	@Override
	public Paused convertToEntityAttribute(String dbData) {
		return Stream.of(Paused.values()).filter(paused -> paused.equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
