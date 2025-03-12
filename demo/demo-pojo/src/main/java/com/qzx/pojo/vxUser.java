package com.qzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class vxUser {
    private String code;
    private String encryptedData;
    private String iv;
}
