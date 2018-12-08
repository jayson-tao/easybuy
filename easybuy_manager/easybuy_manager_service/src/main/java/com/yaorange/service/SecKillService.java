package com.yaorange.service;

import com.yaorange.util.Page;
import org.springframework.ui.Model;
import com.yaorange.pojo.TSeckill;

public interface SecKillService {

	void saveSecKill(TSeckill seckill);

	void echo(Long id, Model model);

	Page<TSeckill> getSeckillPage(Integer page, Integer rows);

	void updateSecKill(long secKillId);

}
