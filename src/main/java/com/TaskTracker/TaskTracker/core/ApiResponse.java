package com.TaskTracker.TaskTracker.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T>{
    private HttpStatusCode status;
    private String message;
    private T result;

    public ApiResponse(HttpStatusCode status, String message, T result){
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
