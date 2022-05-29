package com.rocket.onionnft.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "layers")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class LayerEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer place;
    private String url;
    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "parent_nft_id", referencedColumnName = "id")
    private NftEntity parentNft;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private UserEntity userEntity;
    private Double price;

}
