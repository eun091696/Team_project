package com.teamproject.mvc20221004teamproject.service;

import com.teamproject.mvc20221004teamproject.dto.GoodListRespDto;

import java.util.List;

public interface ProductService {

    public List<GoodListRespDto> getProductList(String category, int page) throws Exception;
}
