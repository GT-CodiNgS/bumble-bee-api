package com.icbt.bumblebeeapi.exception;
/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/2/2023
 */
public class ValidateException extends RuntimeException {
    public ValidateException(String message) {

        super(message);
    }
}
