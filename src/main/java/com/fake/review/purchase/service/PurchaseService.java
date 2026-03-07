package com.fake.review.purchase.service;

import com.fake.review.purchase.dto.PurchaseRequest;
import com.fake.review.purchase.dto.PurchaseResponse;

import java.util.List;

public interface PurchaseService {

    PurchaseResponse createPurchase(PurchaseRequest request);

    PurchaseResponse updatePurchase(String id, PurchaseRequest request);

    void deletePurchase(String id);

    PurchaseResponse getPurchaseById(String id);

    List<PurchaseResponse> getAllPurchases();

    boolean verifyPurchase(String username, Long itemId, String itemType);

}
