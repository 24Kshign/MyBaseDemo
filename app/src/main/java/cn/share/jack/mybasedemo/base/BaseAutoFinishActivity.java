package cn.share.jack.mybasedemo.base;

/**
 * Created by jack on 2017/8/10
 */

public abstract class BaseAutoFinishActivity extends BaseMVPActivity {

    /**
     * 这里就可以根据你的功能来分Base了，比如这里LZ想要实现收到EventBus消息之后自动finish
     * 实战中如果你的项目中有多设备登陆被挤的功能，就可以使用这个全局的Base
     */
}
