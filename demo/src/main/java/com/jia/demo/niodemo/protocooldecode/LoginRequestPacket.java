package com.jia.demo.niodemo.protocooldecode;

import lombok.Data;

import static com.jia.demo.niodemo.protocooldecode.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
