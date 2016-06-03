package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.menu.AddConditionalRet;
import com.myf.weixin.entity.weixin.menu.MatchRet;
import com.myf.weixin.entity.weixin.menu.MenuCreateRequest;
import com.myf.weixin.entity.weixin.menu.MenuRet;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/2.
 */
public class MenuService {

    /**
     *自定义菜单创建接口
     * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
     * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
     * 3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，如果发现上一次拉取菜单的请求在5分钟以前，
     * 就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
     * **/
    public static WxJsonResult createMenu(String accessToken,MenuCreateRequest request)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  自定义菜单查询接口
     *  使用接口创建自定义菜单后，开发者还可使用接口查询自定义菜单的结构。
     *  另外请注意，在设置了个性化菜单后，使用本自定义菜单查询接口可以获取默认菜单和全部个性化菜单信息。
     * **/
    public static MenuRet getMenu(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/menu/get?access_token={0}",accessToken);
        String res = HttpUtil.Get(url,null);
        Gson gson = new Gson();
        return gson.fromJson(res,MenuRet.class);
    }

    /**
     * 自定义菜单删除接口
     * 在个性化菜单时，调用此接口会删除默认菜单及全部个性化菜单
     * **/
    public static WxJsonResult deleteMenu(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  创建个性化菜单
     *  创建个性化菜单之前必须先创建默认菜单（默认菜单是指使用普通自定义菜单创建接口创建的菜单）。如果删除默认菜单，个性化菜单也会全部删除
     *  个性化菜单的更新是会被覆盖的。
     *  例如公众号先后发布了默认菜单，个性化菜单1，个性化菜单2，个性化菜单3。那么当用户进入公众号页面时，将从个性化菜单3开始匹配，如果个性化菜单3匹配成功，则直接返回个性化菜单3，否则继续尝试匹配个性化菜单2，直到成功匹配到一个菜单。
     *  根据上述匹配规则，为了避免菜单生效时间的混淆，决定不予提供个性化菜单编辑API，开发者需要更新菜单时，需将完整配置重新发布一轮。
     * **/
    public static AddConditionalRet addConditional(String accessToken,MenuCreateRequest request)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,AddConditionalRet.class);
    }

    /**
     *  删除个性化菜单
     *  menuId 菜单id，可以通过自定义菜单查询接口获取。
     * **/
    public static WxJsonResult delConditional(String accessToken,String menuId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,String.format("{\"menuid\":\"%s\"}",menuId));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 测试个性化菜单匹配结果
     * user_id可以是粉丝的OpenID，也可以是粉丝的微信号。
     * **/
    public static MatchRet tryMatch(String accessToken,String user_id)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,String.format("{\"user_id\":\"%s\"}",user_id));
        return gson.fromJson(res,MatchRet.class);
    }
}
