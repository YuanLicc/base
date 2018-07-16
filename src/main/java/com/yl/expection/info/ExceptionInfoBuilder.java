package com.yl.expection.info;

/**
 *
 * 异常信息类({@link ExceptionInfo})的抽象建造者(建造者模式)。
 * @author YuanLi
 */
public abstract class ExceptionInfoBuilder {
    /**
     * @see ExceptionInfo
     */
    protected ExceptionInfo expInfo;

    /**
     * 初始化 {@link ExceptionInfoBuilder#expInfo}
     */
    public ExceptionInfoBuilder(){
        this.expInfo = new ExceptionInfo();
    }

    /**
     * 获取异常信息对象
     * @return {@link ExceptionInfo}
     */
    public ExceptionInfo getExpInfo(){
        return expInfo;
    }

    /**
     * 通过指定异常对象建造{@link ExceptionInfoBuilder#expInfo} 对象除了堆栈以外的其它信息
     * @param exception 指定异常对象
     */
    public abstract void buildBasicInfo(Throwable exception);

    /**
     * 通过指定异常对象建造{@link ExceptionInfoBuilder#expInfo} 对象堆栈信息
     * @param exception 指定异常对象
     */
    public abstract void buildStackInfo(Throwable exception);
}
