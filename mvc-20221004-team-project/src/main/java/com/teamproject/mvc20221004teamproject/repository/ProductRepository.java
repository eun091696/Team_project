package com.teamproject.mvc20221004teamproject.repository;

import com.teamproject.mvc20221004teamproject.domain.GoodsProduct;
import com.teamproject.mvc20221004teamproject.dto.ProductListRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {

    public List<GoodsProduct> getProductList(Map<String, Object> map) throws Exception;
}
