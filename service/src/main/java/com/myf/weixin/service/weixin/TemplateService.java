package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.template.*;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/6.
 */
public class TemplateService {
    /**
     * 设置所属行业
     * 设置行业可在MP中完成，每月可修改行业1次，账号仅可使用所属行业中相关的模板，
     * 为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业
     * industry_id1 公众号模板消息所属行业编号
     * industry_id2 公众号模板消息所属行业编号
     * IT科技	互联网/电子商务	1
     * IT科技	IT软件与服务	2
     * IT科技	IT硬件与设备	3
     * IT科技	电子技术	4
     * IT科技	通信与运营商	5
     * IT科技	网络游戏	6
     * 金融业	银行	7
     * 金融业	基金|理财|信托	8
     * 金融业	保险	9
     * 餐饮	餐饮	10
     * 酒店旅游	酒店	11
     * 酒店旅游	旅游	12
     * 运输与仓储	快递	13
     * 运输与仓储	物流	14
     * 运输与仓储	仓储	15
     * 教育	培训	16
     * 教育	院校	17
     * 政府与公共事业	学术科研	18
     * 政府与公共事业	交警	19
     * 政府与公共事业	博物馆	20
     * 政府与公共事业	公共事业|非盈利机构	21
     * 医药护理	医药医疗	22
     * 医药护理	护理美容	23
     * 医药护理	保健与卫生	24
     * 交通工具	汽车相关	25
     * 交通工具	摩托车相关	26
     * 交通工具	火车相关	27
     * 交通工具	飞机相关	28
     * 房地产	建筑	29
     * 房地产	物业	30
     * 消费品	消费品	31
     * 商业服务	法律	32
     * 商业服务	会展	33
     * 商业服务	中介服务	34
     * 商业服务	认证	35
     * 商业服务	审计	36
     * 文体娱乐	传媒	37
     * 文体娱乐	体育	38
     * 文体娱乐	娱乐休闲	39
     * 印刷	印刷	40
     * 其它	其它	41
     * **/
    public static WxJsonResult setIndustry(String accessToken,String industry_id1,String industry_id2)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url,String.format("{\"industry_id1\":\"%s\",\"industry_id2\":\"%s\"}",industry_id1,industry_id2));
        Gson gson = new Gson();
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  获取设置的行业信息
     * **/
    public static IndustryRet getIndustry(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token={0}",accessToken);
        String res = HttpUtil.Get(url, null);
        Gson gson = new Gson();
        return gson.fromJson(res,IndustryRet.class);
    }

    /**
     *  获得模板ID
     *  template_id_short   模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * **/
    public static TemplateIdRet addTemplate(String accessToken,String template_id_short)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url, String.format("{\"template_id_short\":\"%s\"}",template_id_short));
        Gson gson = new Gson();
        return gson.fromJson(res,TemplateIdRet.class);
    }

    /**
     *  获取模板列表
     * **/
    public static TemplateListRet getAllTemplate(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token={0}",accessToken);
        String res = HttpUtil.Get(url, null);
        Gson gson = new Gson();
        return gson.fromJson(res,TemplateListRet.class);
    }

    /**
     *  删除模板
     * **/
    public static WxJsonResult deleteTemplate(String accessToken,String template_id)throws Exception{
        String url = MessageFormat.format("https://api,weixin.qq.com/cgi-bin/template/del_private_template?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url,String.format("{\"template_id\":\"%s\"}",template_id));
        Gson gson = new Gson();
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 发送模板消息
     * **/
    public static <T> SendTemplateRet sendTemplateMessage(String accessToken,SendTemplateMsgRequest<T> data)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(data));
        return gson.fromJson(res,SendTemplateRet.class);
    }
}
