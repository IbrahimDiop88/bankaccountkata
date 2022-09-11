package com.bankaccountkata.serializers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeUTCDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		// parse to a LocalDateTime
		var dt = ZonedDateTime.parse(jsonParser.getText(), DateTimeFormatter.ISO_LOCAL_DATE)
				.withZoneSameInstant(ZoneId.of("UTC"));
		// the datetime is in the default timezone
		return dt.toLocalDateTime();
	}

}
