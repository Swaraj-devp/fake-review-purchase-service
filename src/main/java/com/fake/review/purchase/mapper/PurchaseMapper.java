package com.fake.review.purchase.mapper;

import com.fake.review.purchase.dto.PurchaseRequest;
import com.fake.review.purchase.dto.PurchaseResponse;
import com.fake.review.purchase.model.Purchase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class PurchaseMapper {

    public static Purchase toEntity(PurchaseRequest request) {

        Purchase purchase = new Purchase();
        purchase.setId(request.getId());
        purchase.setUserName(request.getUsername());
        purchase.setItemId(request.getItemId());
        purchase.setItemType(request.getItemType());
        purchase.setItemName(request.getItemName());
        purchase.setStatus(request.getStatus());
        purchase.setPurchaseDate(LocalDateTime.now());

        return purchase;
    }

    public static PurchaseResponse toResponse(Purchase purchase) {

        PurchaseResponse response = new PurchaseResponse();

        response.setId(purchase.getId());
        response.setUsername(purchase.getUserName());
        response.setItemId(purchase.getItemId());
        response.setItemType(purchase.getItemType());
        response.setItemName(purchase.getItemName());
        response.setStatus(purchase.getStatus());
        response.setPurchaseDate(purchase.getPurchaseDate());

        return response;
    }
}