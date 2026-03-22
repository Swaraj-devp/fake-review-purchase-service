package com.fake.review.purchase.repository;

import com.fake.review.purchase.Enum.PurchaseStatus;
import com.fake.review.purchase.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, String> {

    boolean existsByUserNameAndItemIdAndItemTypeAndStatus(
            String userName,
            Long itemId,
            String itemType,
            PurchaseStatus status
    );

    List<Purchase> findByUserName(String userName);
}
