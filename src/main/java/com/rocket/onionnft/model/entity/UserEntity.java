package com.rocket.onionnft.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@ToString
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
    private Set<LayerEntity> creations = new HashSet<>();
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
    private Set<NftEntity> ownerships = new HashSet<>();
}
