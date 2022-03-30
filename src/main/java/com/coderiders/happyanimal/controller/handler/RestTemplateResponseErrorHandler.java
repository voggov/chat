package com.coderiders.happyanimal.controller.handler;

import com.coderiders.happyanimal.exceptions.InternalServerException;
import com.coderiders.happyanimal.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (clientHttpResponse.getStatusCode().series() == CLIENT_ERROR
                || clientHttpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            throw new InternalServerException(getMessage(clientHttpResponse));
        } else {
            if (clientHttpResponse.getStatusCode()
                    .series() == HttpStatus.Series.CLIENT_ERROR) {
                if (clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new NotFoundException(getMessage(clientHttpResponse));
                }
            }
        }
    }

    private String getMessage(ClientHttpResponse clientHttpResponse) throws IOException {
        return new BufferedReader(new InputStreamReader(clientHttpResponse.getBody()))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
