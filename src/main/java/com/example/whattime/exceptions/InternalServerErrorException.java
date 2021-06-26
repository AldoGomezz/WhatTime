package com.example.whattime.exceptions;

import com.example.whattime.DTO.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerErrorException extends WhatTimeExceptions
{
    public InternalServerErrorException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(String code, String message, Throwable cause) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, cause);
    }
}
