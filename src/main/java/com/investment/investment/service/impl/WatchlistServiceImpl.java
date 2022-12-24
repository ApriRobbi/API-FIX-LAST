package com.investment.investment.service.impl;

import com.investment.investment.dto.mapper.WatchlistMapper;
import com.investment.investment.entity.ProductEntity;
import com.investment.investment.entity.UserEntity;
import com.investment.investment.entity.WatchlistEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.ProductRepository;
import com.investment.investment.repository.UserRepository;
import com.investment.investment.repository.WatchlistRepository;
import com.investment.investment.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public WatchlistEntity create(Long userId, Long productId) {

        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new BadRequestException("Produk dengan Id " + productId + " Tidak Ditemukan"));

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User dengan Id " + userId + " Tidak Ditemukan"));

        WatchlistEntity watchlistEntity;
        watchlistEntity = new WatchlistEntity();
        watchlistEntity.setProductEntity(productEntity);
        watchlistEntity.setUserEntity(userEntity);
        return watchlistRepository.save(watchlistEntity);
    }

    @Override
    public List<WatchlistMapper> getListWatchlist(Long id) {
        return watchlistRepository.findWatchlistByUserIdNative(id);
    }

    @Override
    public String delete(Long watchlistId) {
        if (userRepository.existsById(watchlistId)){
            userRepository.deleteById(watchlistId);
            return "Watchlist dengan Id " + watchlistId + " Telah Dihapus";
        } else {
            return "Watchlist dengan Id " + watchlistId + " Tidak Ditemukan";
        }
    }

    @Override
    public List<WatchlistMapper> findWatchlists() {
        return watchlistRepository.findWatchlists();
    }

//    @Override
//    public List<WatchlistEntity> findByUserId(Long userId) {
//        return watchlistRepository.findByUserId(userId);
//    }
}
