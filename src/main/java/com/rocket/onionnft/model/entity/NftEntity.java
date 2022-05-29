package com.rocket.onionnft.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "nfts")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class NftEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToMany(mappedBy = "parentNft", fetch = FetchType.EAGER)
    private Set<LayerEntity> layers = new HashSet<>();
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private UserEntity userEntity;
    @Column(name = "on_sale")
    private Boolean onSale;
    @Column(name = "sell_price")
    private Double sellPrice;
    @Column(unique = true)
    private String name;
    private String url;
}
