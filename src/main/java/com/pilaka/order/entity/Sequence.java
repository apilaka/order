package com.pilaka.order.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "sequence")
//@Document(collection = "sequence")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {
    @Id
    private String id;
    private int sequenceId;

    public int getSeq() {
        return sequenceId;
    }
}