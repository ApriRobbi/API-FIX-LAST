package com.investment.investment.controller;

import com.investment.investment.dto.WatchlistDto;
import com.investment.investment.dto.mapper.WatchlistMapper;
import com.investment.investment.entity.WatchlistEntity;
import com.investment.investment.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @PostMapping("/watchlist")
    public WatchlistEntity create(@RequestBody WatchlistDto watchlistDto){
        return watchlistService.create(watchlistDto.getUserId(), watchlistDto.getProductId());
    }

    //fing watchlist by userId
    @GetMapping("/watchlist/{id}")
    public List<WatchlistMapper> findById(@PathVariable("id") Long id){
        return watchlistService.getListWatchlist(id);
    }

    @DeleteMapping("/watchlist/{watchlistId}")
    String delete(@PathVariable("watchlistId") Long wathlistId){
        return watchlistService.delete(wathlistId);
    }

    @GetMapping("/watchlist")
    public List<WatchlistMapper> findAll(){
        return watchlistService.findWatchlists();
    }
//    @GetMapping("/watchlist/")
//    public List<WatchlistEntity> findByUserId(Long userId){
//        return watchlistService.findByUserId(userId);
//    }
}
