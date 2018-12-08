package com.yaorange.service;

import org.springframework.ui.Model;

public interface ProductSkuService {
    void findSkuByProductId(Long id, Model model);
}
