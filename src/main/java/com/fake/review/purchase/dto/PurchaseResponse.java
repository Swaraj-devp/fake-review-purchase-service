package com.fake.review.purchase.dto;

import com.fake.review.purchase.Enum.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PurchaseResponse {

    private String username;
    private Long itemId;
    private String itemType;
    private String itemName;
    private PurchaseStatus status;
    private LocalDateTime purchaseDate;

}
