# project-demos
![Spring Boot 2.0](https://img.shields.io/badge/Spring%20Boot-2.0-brightgreen.svg)
![Mysql 5.6](https://img.shields.io/badge/Mysql-5.6-blue.svg)
![JDK 1.8](https://img.shields.io/badge/JDK-1.8-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.5.0-yellowgreen.svg)
 * Contains some actual projects

### crawler-demo module
 * Write a stable crawler with spring boot
   * 1.reptile Baidu stock market pass  https://gupiao.baidu.com/concept/  summary data above
   * 2.Get today's price data for a stock:  
   https://gupiao.baidu.com/api/stocks/stocktimeline?from=pc&os_ver=1&cuid=xxx&vv=100&format=json&stock_code=sh600358&timestamp=
   * database tables see tables.sql under resources
    
### mail-sender module
### mail-sender02 module
 * A simple mail sender to send mail
 * Note： Pay attention to modify the account and password when using
 
### sms-sender module
 * A simple SMS sender to send phone message
 * Use this website: http://www.webchinese.com.cn/user/  
 * GBK coding send interface address：  
 http://gbk.api.smschinese.cn/?Uid=User name of this site&Key=Interface security key&smsMob=Phone number&smsText=Verification code:8888
 * UTF-8 coding send interface address：  
 http://utf8.api.smschinese.cn/?Uid=User name of this site&Key=Interface security key&smsMob=Phone number&smsText=Verification code:8888
 * Get the number of SMS interface addresses(UTF8)：  
 http://www.smschinese.cn/web_api/SMS/?Action=SMS_Num&Uid=User name of this site&Key=Interface security key
 * Get the number of SMS interface addresses(GBK)：  
 http://www.smschinese.cn/web_api/SMS/GBK/?Action=SMS_Num&Uid=User name of this site&Key=Interface security key
 * Note： When sending a text message, please add a signature after the content: 【XX company or XX network name】, 
 otherwise it will be blocked.  
 Pay attention to modify the uid, key and phoneNumber when using

