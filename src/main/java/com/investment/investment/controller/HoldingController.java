package com.investment.investment.controller;

import com.investment.investment.dto.mapper.HoldingMapper;
import com.investment.investment.entity.HoldingEntity;
import com.investment.investment.repository.HoldingRepository;
import com.investment.investment.service.HoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HoldingController {

    @Autowired
    HoldingService holdingService;

//    @PostMapping("/holding")
//    public HoldingEntity create(@RequestBody HoldingEntity holdingEntity){
//        return holdingService.create(holdingEntity);
//    }

    @GetMapping("/holding/{userId}")
    public List<HoldingMapper> findByUserId(@PathVariable("userId") Long userId){
        return holdingService.findAllHoldingByUserId(userId);
    }

    @GetMapping("/holding")
    public List<HoldingMapper> findAllHolding(){
        return holdingService.findAllHolding();
    }

    @DeleteMapping("/holding/{holdingId}")
    String delete(@PathVariable("holdingId") Long holdingId){
        return holdingService.delete(holdingId);
    }

    @PostMapping("holding/{holdingId}/jual")
    String jual(@PathVariable("holdingId") Long holdingId){
        return holdingService.createJual(holdingId);
    }
}
