package com.jiaz.util.aes;

public class AesException extends Exception{
    public AesException(){
        super();
    }
    public AesException(String msg, Exception e){
        super(msg,e);
    }
    public AesException(String msg){
        super(msg);
    }
}