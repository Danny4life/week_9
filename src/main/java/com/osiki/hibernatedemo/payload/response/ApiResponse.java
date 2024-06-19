package com.osiki.hibernatedemo.payload.response;

import com.osiki.hibernatedemo.utils.DateUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ApiResponse<T> {

    private String responseMessage;
    private T responseData;
    private String responseTime = DateUtils.toDateString(LocalDateTime.now());

    public ApiResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ApiResponse(String responseMessage, T responseData) {
        this.responseMessage = responseMessage;
        this.responseData = responseData;
    }
}
