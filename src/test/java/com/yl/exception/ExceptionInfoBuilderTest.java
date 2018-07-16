package com.yl.exception;

import com.yl.expection.CalculateException;
import com.yl.expection.info.ExceptionInfo;
import com.yl.expection.info.ExceptionInfoBuilder;
import com.yl.expection.info.imp.DefaultExceptionInfoBuilder;
import junit.framework.TestCase;

public class ExceptionInfoBuilderTest extends TestCase {

    public void testExceptionInfoBuilder() {
        ExceptionInfoBuilder builder = new DefaultExceptionInfoBuilder();
        Throwable exception = new CalculateException("caculate exception");

        builder.buildBasicInfo(exception);
        builder.buildStackInfo(exception);
        ExceptionInfo info = builder.getExpInfo();

        System.out.println(info.getStackTrace()[0].toString());
    }
}
