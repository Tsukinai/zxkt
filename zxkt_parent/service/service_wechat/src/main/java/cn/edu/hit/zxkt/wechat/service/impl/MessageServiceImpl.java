package cn.edu.hit.zxkt.wechat.service.impl;

import cn.edu.hit.zxkt.client.course.CourseFeignClient;
import cn.edu.hit.zxkt.model.vod.Course;
import cn.edu.hit.zxkt.wechat.service.MessageService;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Override
    public String receiveMessage(Map<String, String> param) {
        String content = "";
        String msgType = param.get("MsgType");
        switch(msgType){
            case "text":    //普通文本类型，输入关键字java
                content = this.search(param);
                break;
            case "event":   //关注 取消关注 点击关于我们
                String event = param.get("Event");
                String eventKey = param.get("EventKey");
                if("subscribe".equals(event)){
                    content = this.subscribe(param);
                } else if("unsubscribe".equals(event)){
                    content = this.unsubscribe(param);
                } else if("CLICK".equals(event) && "aboutUs".equals(eventKey)) { //关于我们
                    content = this.aboutUs(param);
                } else {
                    content = "success";
                }
                break;
            default:    //其他情况
                content = "success";
        }
        return content;
    }

    private String aboutUs(Map<String, String> param) {
        StringBuffer msg = this.text(param, "这只是一个测试号");
        return msg.toString();
    }

    private String unsubscribe(Map<String, String> param) {
        return "success";
    }

    private String subscribe(Map<String, String> param) {
        StringBuffer msg = this.text(param,"感谢您的关注");
        return msg.toString();
    }

    /**
     * 处理关键字搜索事件
     */
    private String search(Map<String, String> param) {
        String fromusername = param.get("FromUserName");
        String tousername = param.get("ToUserName");
        String content = param.get("Content");
        //单位为秒，不是毫秒
        Long createTime = new Date().getTime() / 1000;
        StringBuffer text = new StringBuffer();
        List<Course> courseList = courseFeignClient.findByKeyword(content);
        if(CollectionUtils.isEmpty(courseList)) {
            text = this.text(param, "请重新输入关键字，没有匹配到相关视频课程");
        } else {
            //一次只能返回一个
            Random random = new Random();
            int num = random.nextInt(courseList.size());
            Course course = courseList.get(num);
            StringBuffer articles = new StringBuffer();
            articles.append("<item>");
            articles.append("<Title><![CDATA["+course.getTitle()+"]]></Title>");
            articles.append("<Description><![CDATA["+course.getTitle()+"]]></Description>");
            articles.append("<PicUrl><![CDATA["+course.getCover()+"]]></PicUrl>");
            articles.append("<Url><![CDATA[http://glkt.atguigu.cn/#/liveInfo/"+course.getId()+"]]></Url>");
            articles.append("</item>");

            text.append("<xml>");
            text.append("<ToUserName><![CDATA["+fromusername+"]]></ToUserName>");
            text.append("<FromUserName><![CDATA["+tousername+"]]></FromUserName>");
            text.append("<CreateTime><![CDATA["+createTime+"]]></CreateTime>");
            text.append("<MsgType><![CDATA[news]]></MsgType>");
            text.append("<ArticleCount><![CDATA[1]]></ArticleCount>");
            text.append("<Articles>");
            text.append(articles);
            text.append("</Articles>");
            text.append("</xml>");
        }
        return text.toString();
    }

    /**
     * 回复文本
     */
    private StringBuffer text(Map<String, String> param, String content) {
        String fromusername = param.get("FromUserName");
        String tousername = param.get("ToUserName");
        //单位为秒，不是毫秒
        Long createTime = new Date().getTime() / 1000;
        StringBuffer text = new StringBuffer();
        text.append("<xml>");
        text.append("<ToUserName><![CDATA["+fromusername+"]]></ToUserName>");
        text.append("<FromUserName><![CDATA["+tousername+"]]></FromUserName>");
        text.append("<CreateTime><![CDATA["+createTime+"]]></CreateTime>");
        text.append("<MsgType><![CDATA[text]]></MsgType>");
        text.append("<Content><![CDATA["+content+"]]></Content>");
        text.append("</xml>");
        return text;
    }
}
