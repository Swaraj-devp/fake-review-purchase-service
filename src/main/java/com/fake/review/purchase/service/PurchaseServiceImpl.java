package com.fake.review.purchase.service;

import com.fake.review.purchase.Enum.PurchaseStatus;
import com.fake.review.purchase.dto.PurchaseRequest;
import com.fake.review.purchase.dto.PurchaseResponse;
import com.fake.review.purchase.mapper.PurchaseMapper;
import com.fake.review.purchase.model.Purchase;
import com.fake.review.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PurchaseServiceImpl implements PurchaseService{


    @Autowired
    private PurchaseRepository purchaseRepository;


    @Override
    public PurchaseResponse createPurchase(PurchaseRequest request) {

        Purchase purchase = PurchaseMapper.toEntity(request);

        Purchase savedPurchase = purchaseRepository.save(purchase);

        return PurchaseMapper.toResponse(savedPurchase);

    }

    @Override
    public PurchaseResponse updatePurchase(String id, PurchaseRequest request, PurchaseStatus PurchaseStatus) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);

        if (!optionalPurchase.isPresent()) {
            throw new RuntimeException("Purchase not found with id:  " + id);
        }
            Purchase purchase = optionalPurchase.get();
            purchase.setUserName(request.getUsername());
            purchase.setItemId(request.getItemId());
            purchase.setItemType(request.getItemType());
            purchase.setStatus(PurchaseStatus);

            Purchase updated = purchaseRepository.save(purchase);

            return PurchaseMapper.toResponse(updated);

    }


    @Override
    public void deletePurchase(String id) {
    purchaseRepository.deleteById(id);
    }

    @Override
    public PurchaseResponse getPurchaseById(String id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

        return PurchaseMapper.toResponse(purchase);
    }

    @Override
    public List<PurchaseResponse> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();

        return purchases.stream()
                .map(PurchaseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean verifyPurchase(String username, Long itemId, String itemType) {

        return purchaseRepository
                .existsByUserNameAndItemIdAndItemTypeAndStatus(
                        username,
                        itemId,
                        itemType,
                        PurchaseStatus.COMPLETED

                );
    }

    public List<PurchaseResponse> getPurchasesByUser(String username){
        return purchaseRepository.findByUserName(username)
                .stream()
                .map(PurchaseMapper::toResponse)
                .collect(Collectors.toList());
    }
}
