package com.teamproject.mvc20221004teamproject.domain;

import com.teamproject.mvc20221004teamproject.dto.GoodListRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GoodsProduct {
    private int id;
    private String pdt_name;
    private int pdt_price;
    private String save_name;
    private int product_total_count;

    public GoodListRespDto toDto() {
        return GoodListRespDto.builder()
                .productId(id)
                .productName(pdt_name)
                .productPrice(pdt_price)
                .mainImg(save_name)
                .productTotalCount(product_total_count)
                .build();
    }
}
