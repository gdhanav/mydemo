package com.arq.hub.es.dto.Impl;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ToStringFieldWatcher {

    private static final String[] EXCLUDED_FIELD_NAMES = new String[]{"password"};

    public ToStringFieldWatcher() {
    }

    @Override
    public String toString() {
        return (new ReflectionToStringBuilder(this))
                .setExcludeFieldNames(EXCLUDED_FIELD_NAMES).toString();
    }
}
