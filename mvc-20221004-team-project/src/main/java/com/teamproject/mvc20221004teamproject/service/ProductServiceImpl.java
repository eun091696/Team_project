package com.teamproject.mvc20221004teamproject.service;

import com.teamproject.mvc20221004teamproject.dto.GoodListRespDto;
import com.teamproject.mvc20221004teamproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<GoodListRespDto> getProductList(String category, int page) throws Exception {
        List<GoodListRespDto> productList = new ArrayList<GoodListRespDto>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("category", category);
        map.put("index", (page - 1) * 16);

        productRepository.getProductList(map).forEach(goodsProduct -> {
            productList.add(goodsProduct.toDto());
        });
        return productList;
    }

}
