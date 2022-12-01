package com.learning.springjpa.product.data.Models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table
// The transaction class implements the CustomIdGenerator ID Generator serializable generate method.
public class Transactions {
    //The strategy attribute is the full path of the implementation of the generator
    @GenericGenerator(name="trans_id",strategy = "com.learning.springjpa.product.data.Util.CustomIdGenerator")
    @GeneratedValue(generator = "trans_id")
    @Id
    private int id;
    private String transactionType;
    private LocalDateTime date = LocalDateTime.now();
    private String Status;
}
