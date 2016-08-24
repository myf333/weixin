package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.redpack.EpayPack;
import com.myf.weixin.entity.weixin.redpack.EpayResult;
import com.myf.weixin.entity.weixin.redpack.RedPackResult;
import com.myf.weixin.entity.weixin.redpack.SendRedPack;
import com.myf.weixin.util.EncryptUtil;
import com.myf.weixin.util.HttpUtil;
import com.myf.weixin.util.OKHttpUtil;
import com.myf.weixin.util.XMLConvertUtil;
import org.jboss.logging.Message;

import java.text.MessageFormat;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by myf on 2016/8/23.
 */
public class RedPackService {
    public static RedPackResult sendRedPack(String wxappid, String apisecret,String re_openid, String mch_billno,
                                            String mch_id, String nick_name, String send_name, int total_amount,
                                            String wishing,String client_ip,String act_name,String remark,
                                            String logo_imgurl,String share_content, String share_url,String share_imgurl,
                                            String cerPath) throws Exception{
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
        SendRedPack pack = new SendRedPack();
        SortedMap<String, String> dic = new TreeMap<>();
        pack.setMch_billno(mch_billno);dic.put("mch_billno", mch_billno);
        pack.setMch_id(mch_id); dic.put("mch_id", mch_id);
        pack.setWxappid(wxappid);  dic.put("wxappid", wxappid);
        pack.setRe_openid(re_openid);  dic.put("re_openid", re_openid);
        pack.setNick_name(nick_name);  dic.put("nick_name", nick_name);
        pack.setSend_name(send_name);  dic.put("send_name", send_name);
        pack.setTotal_amount(total_amount); dic.put("total_amount", String.valueOf(total_amount));
        pack.setMin_value(total_amount); dic.put("min_value", String.valueOf(total_amount));
        pack.setMax_value(total_amount); dic.put("max_value", String.valueOf(total_amount));
        pack.setTotal_num(1); dic.put("total_num", "1");
        pack.setWishing(wishing); dic.put("wishing", wishing);
        pack.setClient_ip(client_ip); dic.put("client_ip", client_ip);
        pack.setAct_name(act_name); dic.put("act_name", act_name);
        pack.setRemark(remark);dic.put("remark", remark);
        if (logo_imgurl!=null&&!logo_imgurl.isEmpty())
        {
            pack.setLogo_imgurl(logo_imgurl);dic.put("logo_imgurl", logo_imgurl);
        }
        if (share_content!=null&&!share_content.isEmpty())
        {
            pack.setShare_content(share_content);dic.put("share_content", share_content);
        }
        if (share_url!=null&&!share_url.isEmpty())
        {
            pack.setShare_url(share_url);dic.put("share_url", share_url);
        }
        if (share_imgurl!=null&&!share_imgurl.isEmpty())
        {
            pack.setShare_imgurl(share_imgurl);dic.put("share_imgurl", share_imgurl);
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        pack.setNonce_str(uuid); dic.put("nonce_str", uuid);

        //第一步：对参数按照key=value的格式，并按照参数名ASCII字典序排序如下：
        String StringA = CreateLinkString(dic);
        //第二步：拼接API密钥：
        String StringSignTemp = MessageFormat.format("{0}&key={1}", StringA, apisecret);
        String sign = EncryptUtil.Encrypt(StringSignTemp, "MD5","UTF-8").toUpperCase();
        pack.setSign(sign);
        String xml = XMLConvertUtil.toXML(SendRedPack.class,pack);
        xml = xml.replaceAll("__","_");//_是XStream关键字会被转换成__,需要替换
        String res = OKHttpUtil.postXml(url,xml ,cerPath,mch_id);
        return XMLConvertUtil.convertToObject(RedPackResult.class,res);
    }

    /// <summary>
    /// 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
    /// </summary>
    /// <param name="sArray">需要拼接的数组</param>
    /// <returns>拼接完成以后的字符串</returns>
    public static String CreateLinkString(SortedMap<String, String> dicArray)
    {
        StringBuilder preStr = new StringBuilder();

        for (Map.Entry<String, String> temp : dicArray.entrySet())
        {
            preStr.append(temp.getKey() + "=" + temp.getValue() + "&");
        }
        //去掉最後一個&字符
        int nLen = preStr.length();
        preStr.deleteCharAt(nLen - 1);
        return preStr.toString();
    }

    public static EpayResult SendEnterprisePay(String mch_appid,String apisecret, String mchid, String partner_trade_no,
           String openid, int amount, String desc,String spbill_create_ip, String cerPath) throws Exception {
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        EpayPack pack = new EpayPack();
        SortedMap<String, String> dic = new TreeMap<>();
        pack.setPartner_trade_no(partner_trade_no); dic.put("partner_trade_no", partner_trade_no);
        pack.setMchid(mchid); dic.put("mchid", mchid);
        pack.setMch_appid(mch_appid); dic.put("mch_appid", mch_appid);
        pack.setOpenid(openid); dic.put("openid", openid);
        pack.setAmount(String.valueOf(amount)); dic.put("amount", String.valueOf(amount));
        pack.setDesc(desc); dic.put("desc", desc);
        pack.setSpbill_create_ip(spbill_create_ip); dic.put("spbill_create_ip", spbill_create_ip);
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        pack.setNonce_str(uuid);dic.put("nonce_str", uuid);
        pack.setCheck_name("NO_CHECK"); dic.put("check_name", pack.getCheck_name());

        //第一步：对参数按照key=value的格式，并按照参数名ASCII字典序排序如下： 
        String StringA = CreateLinkString(dic);
        //第二步：拼接API密钥： 
        String StringSignTemp = MessageFormat.format("{0}&key={1}", StringA, apisecret);
        String sign = EncryptUtil.Encrypt(StringSignTemp, "MD5","UTF-8").toUpperCase();
        pack.setSign(sign);

        String xml = XMLConvertUtil.toXML(EpayPack.class,pack);
        xml = xml.replaceAll("__","_");//_是XStream关键字会被转换成__,需要替换
        String res = OKHttpUtil.postXml(url,xml ,cerPath,mchid);
        return XMLConvertUtil.convertToObject(EpayResult.class,res);
    }
}
