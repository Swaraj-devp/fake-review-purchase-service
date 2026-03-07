package com.fake.review.purchase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "purchase")
public class Purchase {

    @Id
    private String id;

    private String userName;

    private Long itemId;

    private String itemType;

    private String status; // PENDING, COMPLETED, CANCELLED

    private LocalDateTime purchaseDate;


}
