package com.investment.investment.service;

import com.investment.investment.dto.mapper.HoldingMapper;
import com.investment.investment.entity.HoldingEntity;

import java.math.BigDecimal;
import java.util.List;

public interface HoldingService {

    public void create(HoldingEntity holdingEntity);

    List<HoldingMapper> findAllHoldingByUserId(Long userId);

    List<HoldingMapper> findAllHolding();

    String delete(Long holdingId);

    String createJual(Long holdingId);
}
