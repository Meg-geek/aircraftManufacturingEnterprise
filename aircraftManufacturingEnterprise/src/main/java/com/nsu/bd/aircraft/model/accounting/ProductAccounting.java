package com.nsu.bd.aircraft.model.accounting;

import com.nsu.bd.aircraft.model.company.Site;
import com.nsu.bd.aircraft.model.product.Product;
import com.nsu.bd.aircraft.model.tests.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product_accounting")
public class ProductAccounting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_accounting_id_seq")
    @SequenceGenerator(name = "product_accounting_id_seq",
            sequenceName = "product_accounting_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;
}
