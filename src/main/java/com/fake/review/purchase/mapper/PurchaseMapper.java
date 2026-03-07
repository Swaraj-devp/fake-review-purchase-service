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
        purchase.setUserName(request.getUsername());
        purchase.setItemId(request.getItemId());
        purchase.setItemType(request.getItemType());
        purchase.setStatus(request.getStatus());
        purchase.setPurchaseDate(LocalDateTime.now());

        return purchase;
    }

    public static PurchaseResponse toResponse(Purchase purchase) {

        return new PurchaseResponse(
                purchase.getId(),
                purchase.getUserName(),
                purchase.getItemId(),
                purchase.getItemType(),
                purchase.getStatus(),
                purchase.getPurchaseDate()
        );
    }
}