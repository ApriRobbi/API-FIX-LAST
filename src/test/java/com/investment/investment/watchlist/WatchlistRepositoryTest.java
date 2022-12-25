package com.investment.investment.watchlist;

import com.investment.investment.dto.mapper.WatchlistMapper;
import com.investment.investment.repository.WatchlistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class WatchlistRepositoryTest {

    @Autowired
    WatchlistRepository watchlistRepository;

    @Test
    void findWatchlistByUserIdNativeSuccess(){
        List<WatchlistMapper> findWatchlistByUserId = watchlistRepository.findWatchlistByUserIdNative(1L);
        assertEquals(findWatchlistByUserId.size(), findWatchlistByUserId.size());
    }

    @Test
    void findWatchlistByUserIdNotSuccess(){
        List<WatchlistMapper> findWatchlistByUserId = watchlistRepository.findWatchlistByUserIdNative(5L);
        assertEquals(0, findWatchlistByUserId.size());
    }

}