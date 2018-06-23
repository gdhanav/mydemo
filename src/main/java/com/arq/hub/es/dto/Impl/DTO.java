package com.arq.hub.es.dto.Impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class DTO extends ToStringFieldWatcher implements Serializable {

    public DTO() {
    }


    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj,false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,new String[0]);
    }
}
