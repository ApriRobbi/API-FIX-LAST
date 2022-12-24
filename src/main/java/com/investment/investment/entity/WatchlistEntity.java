package com.investment.investment.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class WatchlistEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlist_id")
    private Long watchlistId;

    @JoinColumn
    @ManyToOne
    private UserEntity userEntity;

    @JoinColumn
    @ManyToOne
    private ProductEntity productEntity;

    public WatchlistEntity(UserEntity userEntity, ProductEntity productEntity) {
        this.userEntity = userEntity;
        this.productEntity = productEntity;
    }

    public WatchlistEntity() {
    }

    public Long getWatchlistId() {
        return watchlistId;
    }

    public void setWatchlistId(Long watchlistId) {
        this.watchlistId = watchlistId;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
