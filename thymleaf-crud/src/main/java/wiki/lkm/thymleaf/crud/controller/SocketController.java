package wiki.lkm.thymleaf.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wiki.lkm.thymleaf.crud.common.WebSocketServer;
import java.io.IOException;

/**
 * @author baibing
 * @project: springboot-socket
 * @package: com.sailing.websocket.controller
 * @Description: websocket测试controller
 * @date 2018/12/20 10：11
 */
@Controller
public class SocketController {

    @Autowired
    private WebSocketServer webSocketServer;

    /**
     * 给所有用户推送消息
     * @throws IOException
     */
    @RequestMapping(value = "/socket/all", method = RequestMethod.GET)
    public void testSocket2(){
        webSocketServer.sendMessage("hello");
    }

    @RequestMapping("/client")
    public String client(){
        return "client";
    }
    @RequestMapping("/indexs")
    public String indexs(){
        return "client";
    }
}