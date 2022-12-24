package com.investment.investment.service;

import com.investment.investment.dto.mapper.WatchlistMapper;
import com.investment.investment.entity.WatchlistEntity;

import java.util.List;

public interface WatchlistService {

    WatchlistEntity create(Long userId, Long productId);

    List<WatchlistMapper> getListWatchlist(Long id);

    String delete(Long watchlistId);

    List<WatchlistMapper> findWatchlists();
}
