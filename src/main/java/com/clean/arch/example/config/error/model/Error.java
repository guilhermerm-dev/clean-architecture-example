package com.clean.arch.example.config.error.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * This model represents a single error operation
 */
@Builder
@Value
@JsonDeserialize(builder = Error.ErrorBuilder.class)
public class Error implements Serializable {

    private static final long serialVersionUID = -4123458179859354491L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cod")
    private ErrorCode code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("field")
    private String field;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("identifier")
    private Object identifier;

    public Error replace(final ErrorCode code) {
        return new ErrorBuilder().message(message)
                .field(field)
                .identifier(identifier)
                .code(code).build();
    }

    /**
     * Support to Jackson deserialization.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class ErrorBuilder {
    }

}
