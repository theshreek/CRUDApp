package com.shreek.crudapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
@Data

public class ExceptionDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer httpStatusCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ExceptionDTO() {
        timestamp = LocalDateTime.now();
    }

    public ExceptionDTO(Integer httpStatusCode, String errorMessage) {
        this();
        this.httpStatusCode = httpStatusCode;
        this.errorMessage = errorMessage;
    }
}