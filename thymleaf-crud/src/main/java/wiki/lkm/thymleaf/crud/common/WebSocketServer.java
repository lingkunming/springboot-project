package wiki.lkm.thymleaf.crud.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
// 你的WebSocket访问地址
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocketServer {
    private Session session;
    //定义Websocket容器，储存session
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    //对应前端的一些事件
    //建立连接
    @OnOpen
    public void opOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
    }

    //关闭连接
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
    }

    //接收消息
    @OnMessage
    public void onMessage(String message) {
    }

    //发送消息
    public void sendMessage(String message) {
        //遍历储存的Websocket
        for (WebSocketServer webSocket : webSocketSet) {
            //发送
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
