package com.airtrips.MsFlight;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class UuidConverter implements Converter<String, UUID> {
    @Override
    public UUID convert(@NonNull String uuid) {
        return UUID.fromString(uuid);
    }
}
