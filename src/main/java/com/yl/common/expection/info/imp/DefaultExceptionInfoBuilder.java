package com.yl.common.expection.info.imp;

import com.yl.common.expection.info.ExceptionInfoBuilder;
import com.yl.common.expection.info.ExceptionInfo;

/**
 * {@link ExceptionInfo}的默认建造者，实现了堆栈信息的建造与其它基础信息的建造。
 * 通过此建造者可以得到一个完整的异常信息。
 * @see ExceptionInfo
 * @author YuanLi
 */
public class DefaultExceptionInfoBuilder extends ExceptionInfoBuilder {

    public DefaultExceptionInfoBuilder() {
        super();
    }

    /**
     * 建造message, exceptionName, exceptionClassName, exceptionMethodName
     * @see ExceptionInfo
     * @param exception 指定异常对象
     */
    public void buildBasicInfo(Throwable exception) {
        //异常信息
        expInfo.setMessage(exception.getMessage());
        //异常类名
        expInfo.setExceptionName(exception.getClass().getName());

        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        //产生异常类
        expInfo.setExceptionClassName(stackTraceElements[0].getClassName());
        //产生异常方法
        expInfo.setExceptionMethodName(stackTraceElements[0].getMethodName());
    }

    /**
     * 建造堆栈信息
     * @param exception 指定异常对象
     */
    public void buildStackInfo(Throwable exception) {
        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        String[] stackTrace = new String[stackTraceElements.length];

        for(int i = 0; i < stackTraceElements.length; i++) {
            stackTrace[i] = stackTraceElements[i].toString();
        }
        expInfo.setStackTrace(stackTrace);
    }
}
