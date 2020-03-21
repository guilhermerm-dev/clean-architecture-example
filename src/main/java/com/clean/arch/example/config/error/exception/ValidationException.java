package com.clean.arch.example.config.error.exception;

import com.clean.arch.example.config.error.model.ErrorCode;
import com.clean.arch.example.config.error.model.Error;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Set;

/**
 * Exception to be thrown when controller parameters/payload validation fails.
 * All errors have the type attribute defined with the value {@link ErrorCode}
 */
@Getter
@ToString
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 6694944262917575043L;

    private final Set<Error> errors;

    public ValidationException(final Error error) {
        this(Collections.singleton(error));
    }

    /**
     * @param errors list of errors data
     */
    public ValidationException(final Set<Error> errors) {
        this(null, null, errors);
    }

    /**
     * @param message exception message
     * @param errors  list of errors data
     */
    public ValidationException(final String message,
                               final Set<Error> errors) {
        this(message, null, errors);
    }

    /**
     * @param cause  the cause (which is saved for later retrieval by the
     *               {@link #getCause()} method).  (A <tt>null</tt> value is
     *               permitted, and indicates that the cause is nonexistent or
     *               unknown.)
     * @param errors list of errors data
     */
    public ValidationException(final Throwable cause,
                               final Set<Error> errors) {
        this(null, cause, errors);
    }

    /**
     * @param message exception message
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @param errors  list of errors data
     */
    public ValidationException(final String message,
                               final Throwable cause,
                               final Set<Error> errors) {
        super(message, cause);
        Assert.notNull(errors, "Errors List must not be null");
        errors.forEach(error -> error = error.replace(ErrorCode.VALIDATION_ERROR));
        this.errors = errors;
    }

}

