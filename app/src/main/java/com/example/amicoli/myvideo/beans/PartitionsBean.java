package com.example.amicoli.myvideo.beans;

import android.util.Log;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Amicoli on 2017/4/17.
 * author 李丰华
 * qq:739574055
 * sina:wallamico
 */

public class PartitionsBean implements MultiItemEntity, Serializable {
    /**
     * partition : {"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?201704051400","height":"63","width":"63"},"count":68}
     * lives : [{"owner":{"face":"http://i0.hdslb.com/bfs/face/3d23ca395683fcfcdfa9421583eadb8196d3ed56.jpg","mid":1348074,"name":"译水"},"cover":{"src":"http://i0.hdslb.com/bfs/live/c158ac31184e478347c7dd46c21db85aebab00c3.jpg","height":180,"width":320},"title":"摸人设","room_id":49064,"check_version":0,"online":184,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/878210/live_1348074_332_c521e483.flv?wsSecret=0695af41edb703d4d70c5fa7eff8fd10&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/8430048b48f37a8929e9aa41d0f297de23ba0442.jpg","mid":332280,"name":"LL的盛夏日"},"cover":{"src":"http://i0.hdslb.com/bfs/live/b2098c48265cf9e8ad5aaf1057078a1102a907ea.jpg","height":180,"width":320},"title":"弄了2个小时的驱动 总算又能画了","room_id":3701690,"check_version":0,"online":11,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/157158/live_332280_5031410.flv?wsSecret=86e5db522175df313ec925166b46e2ce&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/39eb7a524f7789be401beb6bad41fc82ea137c01.jpg","mid":28642912,"name":"沙画师半透明"},"cover":{"src":"http://i0.hdslb.com/bfs/live/214d7200e1c420f0a363839c8f7f872b3f6df945.jpg","height":180,"width":320},"title":"将进酒 杯莫停！","room_id":109506,"check_version":0,"online":213,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/345/live_28642912_8551809.flv?wsSecret=3de4ec53ce9c61344f5db7c2a0174a90&wsTime=58cccc69","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/834ba0637478d2fbafe0857ec735648d3d37b57e.jpg","mid":294270,"name":"米饭mikufan"},"cover":{"src":"http://i0.hdslb.com/bfs/live/02dc09b2fb820c81026f1aaeb8babe3957326539.jpg","height":180,"width":320},"title":"米饭直播 才不知道什么埃罗芒阿老师","room_id":57690,"check_version":0,"online":1956,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/733985/live_294270_2393526.flv?wsSecret=4b8f6c0b9362c47526ba51e44b15df3b&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/9e25bf4b9dbcb71e73d53860eea52f6d33a6059a.jpg","mid":27975769,"name":"-今止-"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f5f5d9209ceea3a6053dd94951e52cc3900e8848.jpg","height":180,"width":320},"title":"如果看见地狱 我就不怕魔鬼","room_id":1549452,"check_version":0,"online":4454,"area":"绘画专区","area_id":9,"playurl":"http://xl.live-play.acgvideo.com/live-xl/880239/live_27975769_5023736.flv?wsSecret=a9fead0a19d416eda54fb93a1e34c424&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/f31acd0c5e26dacc5f3d897ebaa9f6ba8989e21a.gif","mid":9811119,"name":"-Asaki-"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a5a5929a1e446199755f94954556fab77d8322ce.jpg","height":180,"width":320},"title":"摸。鱼","room_id":57345,"check_version":0,"online":97,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/899301/live_9811119_8014342.flv?wsSecret=70f41d56afa1c083e6a123efa8e6d388&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/0eff516a85d36400ce70ded1a26c98685d516b9d.jpg","mid":26916676,"name":"橙光游戏有毒"},"cover":{"src":"http://i0.hdslb.com/bfs/live/5b6b3fd01e658748a08528172c16ddba3c8820cb.jpg","height":180,"width":320},"title":"橙光出品-精美立绘","room_id":100903,"check_version":0,"online":85,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/270850/live_26916676_3389089.flv?wsSecret=15288d44323caa1ce0cb975ffbf1d7bd&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/f4bb3cbab8b0d954b5123490e8617d2126b7a8e3.jpg","mid":149498,"name":"Asan猫"},"cover":{"src":"http://i0.hdslb.com/bfs/live/3f5c91f2b074b16a7c76fde0b417d3a1c468da5c.jpg","height":180,"width":320},"title":"阿三其实很想偷懒\u2014苍蓝生产小黑屋","room_id":4043967,"check_version":0,"online":23,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/537/live_149498_2116022.flv?wsSecret=36bf1b4f9a704e1f33ef76a5b1eb8ac7&wsTime=58cccc69","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/4b6eb872d4c29352bcea4b110bd04aef022ddf58.jpg","mid":97249841,"name":"欢乐颂娜娜"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f16f42e320a2e0ce47ee27feda7b6ef29c38ec2a.jpg","height":180,"width":320},"title":"nana的手绘动漫","room_id":4095423,"check_version":0,"online":38,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/331320/live_97249841_9571498.flv?wsSecret=3905d7b2f4055e6687d930ebe4bb58a7&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/7d23a2233cddb1196951664ff9f44fb160ed0c18.jpg","mid":9870,"name":"小野咩子"},"cover":{"src":"http://i0.hdslb.com/bfs/live/840ce7b2e5c779d94d21dabdc1192ef5dfccdff2.jpg","height":180,"width":320},"title":"小海咩教你如何爆肝","room_id":31568,"check_version":0,"online":2457,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/832283/live_9870_2930831.flv?wsSecret=b8bbecdd281f88bc2e16657c0415b570&wsTime=1492406881","accept_quality":"4","broadcast_type":0,"is_tv":0}]
     */


    public static final int TITLE = 1;
    public static final int CONTNET = 2;
    public static final int MORE = 3;

    private int itemType;
    private PartitionBean partition;
    private List<LivesBean> lives;

    @Override
    public int getItemType() {
        Log.e("getItemType===is called?","  true");
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public PartitionBean getPartition() {
        return partition;
    }

    public void setPartition(PartitionBean partition) {
        this.partition = partition;
    }

    public List<LivesBean> getLives() {
        return lives;
    }

    public void setLives(List<LivesBean> lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "PartitionsBean{" +
                "partition=" + partition +
                ", lives=" + lives +
                '}';
    }
}
