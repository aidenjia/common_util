package com.jia.demo.flowdemo;

public class ExtractionException extends RuntimeException {


    //TODO: this 3 methods will be deleted after all error code refactor completed.
    public ExtractionException(String msg) {
        super(msg);
    }

    public ExtractionException(Exception e) {
        super(e);
    }

    public ExtractionException(String msg, Exception e) {
        super(msg, e);
    }

}

