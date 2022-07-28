<template>
  <div class="userHome">
    <div class="_bEYe5zo">
      <div class="lvKnc_xA"></div>
      <div class="XM26psoY">
        <div class="_1mISMfK2">
          <div class="userInfo">
            <div class="userHeadImage">
              <el-image slot="reference" :src="user.headImage" style="width: 60px;height: 60px;border-radius: 50%"></el-image>
            </div>
            <div class="ojricq5F">
              <div class="ueM2zQtG MMH9nSAg">
                <div class="EqQ4719L">关注</div>
                <div class="hjwDKpez">{{this.follows.length}}</div>
              </div>
              <div class="ueM2zQtG MMH9nSAg">
                <div class="EqQ4719L">粉丝</div>
                <div class="hjwDKpez">{{ this.fans.length }}</div>
              </div>
              <div class="ueM2zQtG MMH9nSAg">
                <div class="EqQ4719L">获赞</div>
                <div class="hjwDKpez">{{this.totalUpNum}}</div>
              </div>
            </div>
          </div>
          <div class="_EYw0j54">
            <h1 class="OKOabD2C">
              <span class="Nu66P_ba">
                <span>{{ user.userName }}</span>
              </span>
            </h1>
          </div>
          <p class="nLpBdOIE"><span class="kbjj_psh">帐号： {{ user.userNum}}</span></p>
          <p class="iGjCnS2C"><span class="Nu66P_ba"><span><span><span><span>{{ user.userIntroduce }}</span></span></span></span></span>
          </p>
          <div class="J4nwkLQN">
            <div v-if="!isMyself">
              <button v-if="!isFollowed" type="button" class="B10aL8VQ s6mStVxD vMQD6aai gK58qq7e" @click="followUser(user.userId)">关注</button>
              <button v-if="isFollowed" type="button" class="B10aL8VQ s6mStVxD cFQVxkEQ gK58qq7e" @click="unFollowUser(user.userId)">已关注</button>
              <!--              <button type="button" class="B10aL8VQ s6mStVxD vMQD6aai vk7WaOg_ VjYdHyfR">私信</button>-->
            </div>
          </div>
        </div>
        <div class="EQk8nKXA"></div>
      </div>
      <div class="SC9Jc7jJ"></div>
      <div class="ckqOrial">
        <div class="mwbaK9mv">
          <div class="isaIlRLR">
            <div class="CANY1MjK GKO_f9Vh">作品<span class="MhR7TL6q">{{ this.videos.length }}</span></div>
            <div class="CANY1MjK GKO_f9Vh">收藏<span class="MhR7TL6q">0</span></div>
          </div>
          <div class="FeJSrpNN">
            <div>
              <ul class="ARNw21RN">
                <li v-for="video in videos" class="ECMy_Zdt">
                  <a :href="'http://localhost:8080/Videos?videoId='+video.videoId" class="B3AsdZT9 chmb2GX8 UwG3qaZV" target="_blank" rel="noopener noreferrer">
                    <div class="HKFI7GBq">
                    <div class="Z6bzLUc0 nVsDtWPX">
                      <img
                      :src="video.videoImage"
                      class="tt-img-loaded" flag="monitor">
                    </div>
                    <div class="rhqAcHmo"></div>
                      <div class="Dv1SqKif">
                        <svg width="14" height="17" fill="none" xmlns="http://www.w3.org/2000/svg">
                          <path
                            d="M1.89 13.3V2.963c0-.665 0-1.102.03-1.42.022-.248.056-.33.062-.342a.427.427 0 01.304-.16c.014.002.101.02.319.141.278.155.64.401 1.188.776l7.382 5.048c.432.295.706.483.895.64a.919.919 0 01.19.187.427.427 0 01.004.316.925.925 0 01-.186.192c-.186.16-.456.354-.88.658l-7.383 5.288c-.553.396-.918.656-1.2.822-.22.13-.31.15-.323.153a.427.427 0 01-.308-.159c-.005-.012-.04-.097-.064-.352-.03-.325-.03-.773-.03-1.453z"
                            stroke="#fff" stroke-width="1.778"></path>
                        </svg>
                        <span>{{ video.videoPlayNum }}</span>
                      </div>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
            <div class="kwodhZJl" style="width: 100%;"><div class="Bllv0dx6">暂时没有更多了</div></div>
          </div>
        </div>
        <div class="Ozn0OIpX"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserHomePage",
  data(){
    return {
      user:{},
      videos:[],
      userId:this.$route.query.userId,
      totalUpNum:0,
      isFollowed:false,
      loginUser:localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      fans:[],
      follows:[],
      isMyself:false
    }
  },
  created() {
    this.getUserInfo();
    this.getUserVideos();
    this.isFollow();
    this.getFans();
    this.getFollows();
    this.judgeMyself();
  },
  methods:{
    getUserInfo(){
      let formData = new FormData();
      formData.append("userId",this.userId);
      this.request.post("http://localhost:9090/userInfo",formData).then(res=>{
        this.user = res.data;
      })
    },
    getUserVideos() {
      this.request.post("http://localhost:9090/video/getVideoInfo",JSON.stringify({
        "userId":this.userId
      })).then(res=>{
        this.videos = res.data;
        let total = 0;
        for (let i = 0; i < res.data.length; i++) {
          total += res.data[i].videoUpNum;
        }
        this.totalUpNum = total;
      })
    },
    followUser(followId){
      this.request.post("http://localhost:9090/follow",JSON.stringify({
        "userId":this.loginUser.userId,
        "followUserId":followId
      })).then(res=>{
        if (res.code === 200){
          this.isFollowed = true;
        }
      })
    },
    unFollowUser(followId){
      this.request.post("http://localhost:9090/unfollow",JSON.stringify({
        "userId":this.loginUser.userId,
        "followUserId":followId
      })).then(res=>{
        if (res.code === 200){
          this.isFollowed = false;
        }
      })
    },
    isFollow(){
      this.request.post("http://localhost:9090/isFollow",JSON.stringify({
        "userId":this.loginUser.userId,
        "followUserId":this.userId
      })).then(res=>{
        this.isFollowed = res.code === 200;
      })
    },
    getFans(){
      this.request.post("http://localhost:9090/getFans",JSON.stringify({
        "userId":this.userId,
      })).then(res=>{
        if (res.code === 200){
          this.fans = res.data;
        }
      })
    },
    getFollows(){
      this.request.post("http://localhost:9090/getFollows",JSON.stringify({
        "userId":this.userId,
      })).then(res=>{
        if (res.code === 200){
          this.follows = res.data;
        }
      })
    },
    judgeMyself(){
      this.isMyself = this.loginUser.userId.toString() === this.userId.toString();
    }
  }
}
</script>

<style scoped>
/*.userHome {*/
/*  flex: 1 1 0%;*/
/*  display: flex;*/
/*  flex-direction: column;*/
/*  overflow-y: scroll;*/
/*  min-height: 100%;*/
/*}*/
.userHome{
  width: 100%;
  height: 100%;
  /*margin: 0 auto;*/
}

._bEYe5zo {
  margin: 0 auto;
  width: 1424px;
  display: flex;
  padding: 0 52px;
  flex: 1 1;
  min-height: 100%;
  height: 100vh;
  /*overflow: auto;*/
  --card-background-horizontal: linear-gradient(270deg, rgba(16, 16, 20, .87), #161722 17.15%);
  --card-background-vertical: linear-gradient(0deg, rgba(16, 16, 20, .87), #161722 17.15%);
}

._bEYe5zo .lvKnc_xA, ._bEYe5zo .Ozn0OIpX, ._bEYe5zo .SC9Jc7jJ {
  flex-basis: 4.16%;
  flex-grow: 0;
  flex-shrink: 0;
  width: 4.16%;
}

.XM26psoY {
  background-image: var(--card-background-horizontal);
  padding: 36px 8px 0;
  width: 29.16%;
}

._1mISMfK2 {
  width: 100%;
}
.kwodhZJl {
  flex-shrink: 0;
  margin-bottom: 40px;
  margin-top: 40px;
  text-align: center;
}
.Bllv0dx6 {
  color: hsla(0,0%,100%,.5);
  font-size: 12px;
  line-height: 20px;
  text-align: center;
}
.ECMy_Zdt {
  display: inline-block;
  font-size: 0;
  justify-content: space-between;
  padding: 0 8px 16px;
  width: 30%;
}
.Dv1SqKif span, .jjKJTf4P span {
  display: inline-block;
  margin-left: 5px;
}
.rhqAcHmo {
  background: linear-gradient(180deg,transparent,rgba(0,0,0,.75));
  bottom: 0;
  height: 48px;
  opacity: .4;
  position: absolute;
  width: 100%;
}
.Dv1SqKif, .jjKJTf4P {
  align-items: center;
  bottom: 10px;
  color: #fff;
  display: flex;
  flex-direction: row;
  font-family: PingFang SC,DFPKingGothicGB-Medium,sans-serif;
  font-size: 14px;
  font-weight: 500;
  justify-content: center;
  left: 15px;
  line-height: 22px;
  position: absolute;
}
.B3AsdZT9, .wBikGyzB {
  position: relative;
}

.UwG3qaZV {
  border: 1px solid rgba(231,231,236,.03);
}
.chmb2GX8 {
  border-radius: 4px;
  cursor: pointer;
  display: inline-block;
  overflow: hidden;
  position: relative;
  width: 100%;
}
.chmb2GX8 .HKFI7GBq {
  padding-bottom: 133%;
}
.chmb2GX8 .nVsDtWPX {
  height: 100%;
  position: absolute;
  width: 100%;
}
.chmb2GX8 .nVsDtWPX img {
  height: 100%;
  -o-object-fit: cover;
  object-fit: cover;
  width: 100%;
}

.Z6bzLUc0 img {
  max-height: 100%;
  max-width: 100%;
  position: relative;
}
.Z6bzLUc0 {
  align-items: center;
  display: flex;
  justify-content: center;
  position: relative;
}
.EQk8nKXA {
  width: 100%;
}

.userInfo {
  align-items: center;
  display: flex;
  flex-direction: row;
  font-family: PingFang SC, DFPKingGothicGB-Regular, sans-serif;
  font-weight: 400;
  justify-content: flex-start;
  position: relative;
  user-select: none;
}

.userHeadImage {
  flex: 0 0 62px;
}

.ojricq5F {
  flex: 1 1;
  align-items: center;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}

.ueM2zQtG {
  align-items: center;
  display: flex;
  flex-basis: 71px;
  flex-direction: column;
  flex-grow: 1;
  justify-content: center;
  position: relative;
}

.MMH9nSAg {
  cursor: pointer;
}

.ueM2zQtG .EqQ4719L {
  color: hsla(0, 0%, 100%, .5);
  /*font-size: 12px;*/
  line-height: 20px;
}

.ueM2zQtG .hjwDKpez {
  color: hsla(0, 0%, 100%, .9);
  font-family: PingFang SC, DFPKingGothicGB-Medium, sans-serif;
  font-size: 20px;
  font-weight: 500;
  line-height: 20px;
  margin-top: 2px;
}

._EYw0j54 {
  align-items: center;
  display: flex;
  justify-content: flex-start;
  margin-top: 13px;
  position: relative;
}

._EYw0j54 .OKOabD2C, ._EYw0j54 .OKOabD2C span {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

._EYw0j54 .OKOabD2C span {
  color: hsla(0, 0%, 100%, .9);
  display: block;
  flex-shrink: 0;
  font-family: PingFang SC, DFPKingGothicGB-Medium, sans-serif;
  font-size: 20px;
  font-weight: 500;
  line-height: 28px;
  max-width: 300px;
}

.nLpBdOIE {
  align-items: center;
  color: hsla(0, 0%, 100%, .9);
  display: flex;
  font-family: PingFang SC, DFPKingGothicGB-Regular, sans-serif;
  font-size: 12px;
  font-weight: 400;
  line-height: 20px;
  margin: 8px 0;
}

.iGjCnS2C span {
  color: hsla(0, 0%, 100%, .8);
  font-family: PingFang SC, DFPKingGothicGB-Regular, sans-serif;
  font-size: 14px;
  font-weight: 400;
  line-height: 22px;
  word-break: break-all;
}

.J4nwkLQN .gK58qq7e, .J4nwkLQN .JVy8_H4z, .J4nwkLQN .VjYdHyfR {
  margin-top: 20px;
  position: relative;
  margin-left: 0;
}


.J4nwkLQN .gK58qq7e, .J4nwkLQN .JVy8_H4z, .J4nwkLQN .VjYdHyfR {
  margin-top: 20px;
  position: relative;
}

.J4nwkLQN .gK58qq7e {
  margin-left: 0;
}

/*关注按钮颜色*/
.vMQD6aai {
  background-color: #fe2c55;
  color: #fff;
}

/*已关注按钮颜色*/
.cFQVxkEQ {
  background-color: #363741;
  color: hsla(0, 0%, 100%, .8);
}

.s6mStVxD {
  border-radius: 4px;
  font-size: 14px;
  font-family: ”Microsoft YaHei”, Arial, Helvetica, sans-serif, ”宋体”;
  font-weight: 500;
  height: 36px;
  line-height: 22px;
  min-width: 88px;
}

.B10aL8VQ {
  align-items: center;
  border: 0;
  cursor: pointer;
  display: inline-flex;
  justify-content: center;
  margin: 0 8px;
  outline: none;
  padding: 0 16px;
  position: relative;
}

._bEYe5zo .ckqOrial {
  display: flex;
  margin: 0;
  width: 62.5%;
}
.ARNw21RN, .mwbaK9mv {
  width: 100%;
  padding: 0;
}
.isaIlRLR {
  align-items: center;
  display: flex;
  justify-content: flex-start;
  margin-bottom: 24px;
  padding: 0 8px;
  position: relative;
}
._bEYe5zo .ckqOrial {
  padding-top: 36px;
}
.CANY1MjK.GKO_f9Vh, .CANY1MjK.GKO_f9Vh .MhR7TL6q {
  font-family: PingFang SC,DFPKingGothicGB-Medium,sans-serif;
  font-weight: 500;
  position: relative;
}
.CANY1MjK.GKO_f9Vh {
  color: hsla(0,0%,100%,.9);
  font-size: 18px;
  line-height: 26px;
}
.CANY1MjK.GKO_f9Vh .MhR7TL6q {
  display: inline-block;
  font-size: 19px;
  line-height: 22px;
  margin-left: 4px;
}
.CANY1MjK, .CANY1MjK .MhR7TL6q {
  font-weight: 400;
  position: relative;
}
.CANY1MjK {
  align-items: center;
  color: hsla(0,0%,100%,.7);
  cursor: pointer;
  display: flex;
  font-family: PingFang SC,DFPKingGothicGB-Regular,sans-serif;
  font-size: 18px;
  justify-content: center;
  line-height: 26px;
  margin-right: 40px;
}
</style>
