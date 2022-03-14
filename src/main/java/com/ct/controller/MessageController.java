package com.ct.controller;

import com.ct.api.BaseResponse;
import com.ct.api.StatusCode;
import com.ct.component.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
public class MessageController {

    @Autowired
    private WebSocketServer webSocketServer;

    @RequestMapping("/push/{toUserId}")
    public BaseResponse<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        webSocketServer.sendInfo(message,toUserId);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData("MSG SEND SUCCESS");
        return retMsg;
    }


}
