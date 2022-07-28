<template>
  <div class="cognizance-box">
    <div  class="reDian">热点视频</div>
    <div v-for="item in videos" :key="item.videoId" class="videoFor">
    <div class="videoDiv">
      <div style="margin-top: 10px;margin-left: 10px;max-width: 300px;position: relative;">
       <a :href="'http://localhost:8080/Videos?videoId='+item.videoId" style="text-decoration:none;" target="_blank">
         <div class="firstImage">
           <el-image style="width: 311.938px;height: 233.948px" :src="item.videoImage" fit="cover"></el-image>
         </div>
         <div class="playInfo">
            <div class="videoCard">
              <div class="videoCard_playInfo">
                <svg width="14" height="17" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M1.89 13.3V2.963c0-.665 0-1.102.03-1.42.022-.248.056-.33.062-.342a.427.427 0 01.304-.16c.014.002.101.02.319.141.278.155.64.401 1.188.776l7.382 5.048c.432.295.706.483.895.64a.919.919 0 01.19.187.427.427 0 01.004.316.925.925 0 01-.186.192c-.186.16-.456.354-.88.658l-7.383 5.288c-.553.396-.918.656-1.2.822-.22.13-.31.15-.323.153a.427.427 0 01-.308-.159c-.005-.012-.04-.097-.064-.352-.03-.325-.03-.773-.03-1.453z"
                    stroke="#fff" stroke-width="1.778"></path>
                </svg>
                <span>{{item.videoPlayNum}}</span>
              </div>
            </div>
         </div>
       </a>
      </div>
      <div style="margin-top: 8px">
        <span style="color: #fff;font-size: 16px;line-height: 24px;margin-left: 10px">{{ item.videoTitle }}</span>
      </div>
      <div class="VideoUserInfo">
          <a class="userImage" :href="'http://localhost:8080/userHomePage?userId='+item.userId">
          <el-image slot="reference" :src="item.headImage" style="width: 35px;height: 35px;border-radius: 50%"></el-image>
          <span class="userName" >{{item.userName}}</span>
          </a>
          <span class="videoUpTime" >{{item.videoUploadTime}}</span>
      </div>
    </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Hot",
  data(){
    return {
      videos:[]
    }
  },
  created() {
    this.getHotVideos()
  },
  methods:{
    getHotVideos(){
      this.request.post("http://localhost:9090/video/getHotVideo").then(res=>{
          this.videos = res.data;
      })
    }
  }
}
</script>

<style scoped>
.playInfo{
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.videoCard_playInfo{
  position: absolute;
  right: 20px;
  align-items: center;
  bottom: 5px;
  color: #fff;
  display: flex;
  flex-direction: row;
  font-family: PingFang SC,DFPKingGothicGB-Medium,sans-serif;
  font-size: 14px;
  font-weight: 500;
  justify-content: center;
  line-height: 22px;
}
.videoCard_playInfo span{
  margin-left: 8px;
}
.videoCard{
  position: absolute;
  bottom: 0;
  left: 0;
  padding: 16px 8px 6px;
  width: 100%;
  background-image: linear-gradient(180deg,rgba(0,0,0,0) 0%,rgba(0,0,0,.8) 100%);
}
.VideoUserInfo{
  align-items: center;
  display: flex;
  margin-top: 8px;
  margin-bottom: 100px;
}
.userImage{
  align-items: center;
  display: flex;
  text-decoration:none;
  margin-left: 10px;
}
.userName{
  color: hsla(0,0%,100%,.8);
  margin-left: 8px;
  font-family: PingFang SC,DFPKingGothicGB-Regular,sans-serif;
}
.videoUpTime{
  font-size: 14px;
  line-height: 22px;
  color: hsla(0,0%,100%,.5);
  flex: 1 0;
  /*flex-grow: 1;*/
  /*flex-shrink: 0;*/
  /*flex-basis: 0%;*/
  font-family: PingFang SC,DFPKingGothicGB-Regular,sans-serif;
  font-weight: 400;
  text-align: right;
  white-space: nowrap;
}
.reDian{
  color: white;
  font-size: 18px;
  padding: 0 0 20px 20px;
}
.videoDiv{
  display: inline-block;
}
.videos{
  width: 220px;
  height: 400px;
  object-fit: contain;
}
.videoFor{
  display: inline-block;
  margin-left: 40px;
  margin-bottom: 90px;
  width: 311.938px;
  height: 233.948px;
}
.cognizance-box {
  width: 100%;
  height: 100vh;
  overflow-y: auto;
  margin: 0 auto;
}
</style>
