package com.micro_services.user_service.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Author: shan
 * Created: 2023-11-24 10.44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardMessageResponse {
    private Object data;
    private Integer status;
    private String message;
}
