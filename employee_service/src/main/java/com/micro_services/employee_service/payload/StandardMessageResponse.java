package com.micro_services.employee_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 2023-11-24 21.42
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardMessageResponse {
    private Object data;
    private Integer status;
    private String message;
}
