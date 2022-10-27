package com.teamproject.mvc20221004teamproject.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GoodListRespDto {
    private int productId;
    private String productName;
    private int productPrice;
    private String mainImg;
    private int productTotalCount;
}
