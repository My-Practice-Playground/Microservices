package com.micro_services.user_service.payloads.response;

import lombok.Data;

/**
 * Author: shan
 * Created: 2023-11-24 10.44
 */
@Data
public class StandardMessageResponse {
    private Object data;
    private Integer status;
    private String message;
}
