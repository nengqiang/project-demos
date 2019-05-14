
CREATE TABLE `baidu_hot` (
  `id`                    INT(11)       NOT NULL AUTO_INCREMENT   COMMENT '主键',
  `title_line1`           VARCHAR(255)  DEFAULT NULL              COMMENT '主标题',
  `title_line2`           INT(11)       DEFAULT NULL              COMMENT '副标题',
  `title_line3`           VARCHAR(255)  DEFAULT NULL              COMMENT '三级标题1',
  `title_line4`           VARCHAR(255)  DEFAULT NULL              COMMENT '三级标题2',
  `driving_thing`         TEXT                                    COMMENT '驱动事件',
  `hot_stock_name_1`      VARCHAR(255)  DEFAULT NULL              COMMENT '',
  `hot_stock_code_1`      VARCHAR(11)   DEFAULT NULL              COMMENT '',
  `hot_stock_price_1`     DOUBLE        DEFAULT NULL              COMMENT '',
  `hot_stock_increment_1` VARCHAR(20)   DEFAULT NULL              COMMENT '',
  `hot_stock_name_2`      VARCHAR(255)  DEFAULT NULL              COMMENT '',
  `hot_stock_code_2`      VARCHAR(11)   DEFAULT NULL              COMMENT '',
  `hot_stock_price_2`     DOUBLE        DEFAULT NULL              COMMENT '',
  `hot_stock_increment_2` VARCHAR(20)   DEFAULT NULL              COMMENT '',
  `hot_stock_name_3`      VARCHAR(255)  DEFAULT NULL              COMMENT '',
  `hot_stock_code_3`      VARCHAR(11)   NOT NULL                  COMMENT '',
  `hot_stock_price_3`     DOUBLE        DEFAULT NULL              COMMENT '',
  `hot_stock_increment_3` VARCHAR(20)   DEFAULT NULL              COMMENT '',
  `create_date`           TIMESTAMP     DEFAULT current_timestamp COMMENT '创建时间',
  `last_update_date`      TIMESTAMP     DEFAULT current_timestamp ON UPDATE current_timestamp
                                                                 COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '概要数据的数据抽象表，概要数据爬取的内容包含热点概念，驱动事件和具体的股票数据';


CREATE TABLE `stock` (
  `id`                INT(11)       NOT NULL AUTO_INCREMENT       COMMENT '主键',
  `stock_id`          VARCHAR(30)   DEFAULT NULL                  COMMENT '热点id',
  `data`              TEXT          DEFAULT NULL                  COMMENT '热点数据',
  `create_date`       TIMESTAMP     DEFAULT current_timestamp     COMMENT '创建时间',
  `last_update_date`  TIMESTAMP     DEFAULT current_timestamp ON UPDATE current_timestamp
                                                                 COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 COMMENT '百度股市的接口数据直接存为json数据表';