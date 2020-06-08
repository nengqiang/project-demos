package com.hnq.fly.dao.repository;

import com.hnq.toolkit.tool.SnowflakeKeyGenerator;
import org.springframework.stereotype.Repository;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
@Repository
public abstract class BaseRepository {

    protected SnowflakeKeyGenerator generator = new SnowflakeKeyGenerator();

}
