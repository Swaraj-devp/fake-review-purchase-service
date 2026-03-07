package com.fake.review.purchase.dto;

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

    private String id;
    private String username;
    private Long itemId;
    private String itemType;
    private String status;
    private LocalDateTime purchaseDate;

}
