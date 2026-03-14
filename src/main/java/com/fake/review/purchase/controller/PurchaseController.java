package com.fake.review.purchase.controller;

import com.fake.review.purchase.Enum.PurchaseStatus;
import com.fake.review.purchase.dto.PurchaseRequest;
import com.fake.review.purchase.dto.PurchaseResponse;
import com.fake.review.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public PurchaseResponse createPurchase(@RequestBody PurchaseRequest request) {
        return purchaseService.createPurchase(request);
    }

    @PutMapping("/{id}")
    public PurchaseResponse updatePurchase(@PathVariable String id,
                                           @RequestBody PurchaseRequest request,
                                           @RequestParam PurchaseStatus PurchaseStatus) {
        return purchaseService.updatePurchase(id, request, PurchaseStatus);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable String id) {
        purchaseService.deletePurchase(id);
    }

    @GetMapping("/{id}")
    public PurchaseResponse getPurchaseById(@PathVariable String id) {
        return purchaseService.getPurchaseById(id);
    }

    @GetMapping
    public List<PurchaseResponse> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/verify")
    public boolean verifyPurchase(
            @RequestParam String username,
            @RequestParam Long itemId,
            @RequestParam String itemType) {

        return purchaseService.verifyPurchase(username, itemId, itemType);
    }
}
