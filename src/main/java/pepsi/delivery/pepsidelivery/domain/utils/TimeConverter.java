package pepsi.delivery.pepsidelivery.domain.utils;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TimeConverter implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime locTime) {
		return locTime != null ? Time.valueOf(locTime) : null;
		
	}

	@Override
	public LocalTime convertToEntityAttribute(Time dbData) {
		return dbData != null ? dbData.toLocalTime( ) : null;
	}

	
}
