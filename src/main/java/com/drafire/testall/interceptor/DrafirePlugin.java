package com.drafire.testall.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * mybatis 自定义插件
 */

@Intercepts(value = {@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})

//@Intercepts(value = {@Signature(
//        type= StatementHandler.class,
//        method = "prepare",
//        args = {Connection.class, Integer.class})})

//这个不知道有什么用
//@Intercepts(value = {@Signature(
//        type= ResultSetHandler.class,
//        method = "handleResultSets",
//        args = {})})

//这个不知道有什么用
//@Intercepts(value = {@Signature(
//        type= ParameterHandler.class,
//        method = "setParameters",
//        args = {PreparedStatement.class})})

public class DrafirePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("mybatis插件打印了：");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    //下面这个代码对应StatementHandler，可以打印出sql等信息
    private String getStatementHandlerSql(Invocation invocation){
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        return sql;
    }
}
