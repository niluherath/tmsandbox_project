package com.api;

import org.testng.log4testng.Logger;

public abstract class BaseTest {

    protected static final int RESPONSE_CODE_200 = 200;
    protected static final int RESPONSE_CODE_400 = 400;
    protected static final int RESPONSE_CODE_404 = 404;
    protected static final int RESPONSE_CODE_415 = 415;

    protected static Logger logger = Logger.getLogger(BaseTest.class);

}
