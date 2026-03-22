package com.fake.review.purchase.service;

import com.fake.review.purchase.Enum.PurchaseStatus;
import com.fake.review.purchase.dto.PurchaseRequest;
import com.fake.review.purchase.dto.PurchaseResponse;

import java.util.List;

public interface PurchaseService {

    PurchaseResponse createPurchase(PurchaseRequest request);

    PurchaseResponse updatePurchase(String id, PurchaseRequest request,PurchaseStatus purchaseStatus);

    void deletePurchase(String id);

    PurchaseResponse getPurchaseById(String id);

    List<PurchaseResponse> getAllPurchases();

    boolean verifyPurchase(String username, Long itemId, String itemType);

    List<PurchaseResponse> getPurchasesByUser(String username);
}
