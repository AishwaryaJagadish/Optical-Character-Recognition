package com.medicalrecordet.ETMedicalRecord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRecord{
    @Id
    public int id;
    public String invoiceNumber;
    public String orderNumber;
    public String amount;
}
