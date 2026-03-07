package com.fake.review.purchase.controller;

import com.fake.review.purchase.dto.PurchaseRequest;
import com.fake.review.purchase.dto.PurchaseResponse;
import com.fake.review.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // Create Purchase
    @PostMapping
    public PurchaseResponse createPurchase(@RequestBody PurchaseRequest request) {
        return purchaseService.createPurchase(request);
    }

    // Update Purchase
    @PutMapping("/{id}")
    public PurchaseResponse updatePurchase(@PathVariable String id,
                                           @RequestBody PurchaseRequest request) {
        return purchaseService.updatePurchase(id, request);
    }

    // Delete Purchase
    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable String id) {
        purchaseService.deletePurchase(id);
    }

    // Get Purchase By Id
    @GetMapping("/{id}")
    public PurchaseResponse getPurchaseById(@PathVariable String id) {
        return purchaseService.getPurchaseById(id);
    }

    // Get All Purchases
    @GetMapping
    public List<PurchaseResponse> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    // Verify Purchase (Used by review-service)
    @GetMapping("/verify")
    public boolean verifyPurchase(
            @RequestParam String username,
            @RequestParam Long itemId,
            @RequestParam String itemType) {

        return purchaseService.verifyPurchase(username, itemId, itemType);
    }
}
