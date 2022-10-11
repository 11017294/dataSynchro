# 工程简介
    项目使用了多数据源
    每个数据源单独使用一套代码
    缺点1：多套数据源的代码逻辑一致,造成了代码存在一定的冗余，缺乏灵活性
    缺点2：@Transactional不能实现跨库事务
        方法中涉及多个数据库的操作时，会出现错误：`No qualifying bean of type 'org.springframework.transaction.TransactionManager' available`
        单独操作数据库的方法可加@Transactional

# 延伸阅读

