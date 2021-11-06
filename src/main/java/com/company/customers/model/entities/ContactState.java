package com.company.customers.model.entities;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum ContactState {
    VALID, NOT_VALID;

    public static ContactState fromName(String value) {
        return Arrays.stream(ContactState.values())
                .filter(status -> StringUtils.equalsIgnoreCase(status.name(), value))
                .findFirst()
                .orElse(null);
    }

}
