package com.fake.review.purchase.dto;

import com.fake.review.purchase.Enum.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseRequest {

    private String username;
    private Long itemId;
    private String itemType;
    private PurchaseStatus status;
}
