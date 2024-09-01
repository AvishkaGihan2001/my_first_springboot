package com.ijse.Hello.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    List<Long> productIDs;
}
