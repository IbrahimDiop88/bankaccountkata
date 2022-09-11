package com.bankaccountkata.serializers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeUTCSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // get the timestamp in the default timezone
        ZonedDateTime z = value.atZone(ZoneId.of("UTC"));
        String str = DateTimeFormatter.ISO_LOCAL_DATE.format(z);

        gen.writeString(str);
    }

}
