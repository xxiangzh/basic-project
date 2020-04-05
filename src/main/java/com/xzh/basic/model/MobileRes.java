package com.xzh.basic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileRes {
    private String hRet;
    private String hit;
    private String retMsg;
    private List<Number> numbers;
}
