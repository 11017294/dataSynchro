# 工程声明
    编写多套数据源，每套数据源代码独立，都拥有自己的mapper文件，需要使用某个数据源时，调用对应mapper即可
   
    缺点1：多套数据源的代码逻辑一致,造成了代码存在一定的冗余，缺乏灵活性
    缺点2：@Transactional不能实现跨库事务
        方法中涉及多个数据库的操作时，会出现错误：`No qualifying bean of type 'org.springframework.transaction.TransactionManager' available`
        单独操作数据库的方法可加@Transactional
---
> 暂未处理多数据源的事务管理