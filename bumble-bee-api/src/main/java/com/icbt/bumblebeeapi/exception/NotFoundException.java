package com.icbt.bumblebeeapi.exception;
/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/2/2023
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {

        super(message);
    }
}
