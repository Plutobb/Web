<template>
  <div id="micro" class="micro--3AMFh">
    <div id="garfish_app_for_content_ysugl47x">
      <div __garfishmockhtml__="">
        <div __garfishmockbody__="">
          <div id="root">
            <div class="card-container-creator-layout micro--2kLg8" style="">
              <div class="card--cdv2- full--3ADOq">
                <div class="title--2ZrJf">视频管理</div>
                <div>
                  <div>
                    <div style="padding-bottom: 0px;"></div>
                    <div class="content-header--38RgH" style="transform: translateZ(0px);">
                      <div class="content-header-op--3GYVM">
                        <div class="content-header-tabs--17dou">
                          <div class="tabs--2hbn4">
                            <div @click="allVideos">
                              <div v-if="allVideo" class="tab--3x6v2">
                                <div class="tab-item--1zwL9 active--36U4v">全部作品
                                </div>
                              </div>
                              <div v-if="!allVideo" class="tab--3x6v2">
                                <div class="tab-item--1zwL9">全部作品
                                </div>
                              </div>
                            </div>
                            <div @click="getRelease">
                              <div v-if="!release" class="tab--3x6v2">
                                <div class="tab-item--1zwL9">已发布
                                </div>
                              </div>
                              <div v-if="release" class="tab--3x6v2">
                                <div class="tab-item--1zwL9 active--36U4v">已发布
                                </div>
                              </div>
                            </div>
                            <div @click="getAuditing">
                              <div v-if="!auditing" class="tab--3x6v2">
                                <div class="tab-item--1zwL9">审核中
                                </div>
                              </div>
                              <div v-if="auditing" class="tab--3x6v2">
                                <div class="tab-item--1zwL9 active--36U4v">审核中
                                </div>
                              </div>
                            </div>
                            <div @click="getFail">
                              <div v-if="!fail" class="tab--3x6v2">
                                <div class="tab-item--1zwL9">未通过
                                </div>
                              </div>
                              <div v-if="fail" class="tab--3x6v2">
                                <div class="tab-item--1zwL9 active--36U4v">未通过
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="content-header-total--1RJRi">共 {{this.videos.length}} 个作品</div>
                      </div>
                    </div>
                  </div>
                  <div v-for="item in videos">
                    <div class="content-body--29zhI">
                      <div class="video-card--1404D">
                        <div class="video-card-cover--2Y2HT"
                             style="background-color: rgb(0, 0, 0); background-size: 100%; background-position-y: 50%; background-repeat: no-repeat;">
                          <a :href="item.videoUrl" target="_blank">
                            <img class="video-card-cover--2Y2HT" :src="item.videoImage">
                          </a>
                          <div class="video-card-top--1rA9T"></div>
                          <div class="video-card-bottom--33RnA"></div>
                          <span class="badge--1NU_M">00:24</span>
                        </div>
                        <div class="video-card-info--stqta">
                          <div>
                            <div class="info-title-text--kEYth info-title-small-desc--tW-Ce">{{item.videoIntroduce}}</div>
                          </div>
                          <div class="info-row--1OQ3-">
                            <div class="info-figure--2LJ6W">
                              <svg width="14" height="14" viewBox="0 0 14 14" fill="none">
                                <g clip-path="url(#eye_svg__clip0)">
                                  <path fill-rule="evenodd" clip-rule="evenodd"
                                        d="M13.956 7.244s-.058.184-.117.245c-.037.118-.1.237-.17.372-.04.074-.08.152-.122.239-.292.489-.702 1.1-1.286 1.772C11.151 11.156 9.397 12.5 7 12.5c-2.397 0-4.15-1.344-5.261-2.628A12.276 12.276 0 01.453 8.1l-.292-.611c-.059-.061-.117-.245-.117-.245-.059-.122-.059-.305 0-.488 0 0 .058-.184.117-.245.037-.118.1-.237.17-.372.04-.073.08-.152.122-.239.292-.489.701-1.1 1.286-1.772C2.849 2.844 4.603 1.5 7 1.5c2.397 0 4.15 1.344 5.261 2.628.585.672.994 1.283 1.286 1.772l.292.611c.059.061.117.245.117.245a.704.704 0 010 .488zM7 10a3 3 0 100-6 3 3 0 000 6z"
                                        fill="#1C1F23" fill-opacity="0.3"></path>
                                  <circle cx="7" cy="7" r="2" fill="#C4C4C4"></circle>
                                </g>
                                <defs>
                                  <clipPath id="eye_svg__clip0">
                                    <path fill="#fff" d="M0 0h14v14H0z"></path>
                                  </clipPath>
                                </defs>
                              </svg>
                              <span class="info-figure-text--2K5OJ">{{ item.videoPlayNum }}</span></div>
                            <!--                            <div class="info-figure&#45;&#45;2LJ6W">-->
                            <!--                              <svg width="14" height="14" viewBox="0 0 14 14" fill="none">-->
                            <!--                                <path fill-rule="evenodd" clip-rule="evenodd"-->
                            <!--                                      d="M11.32 10.42c1.25-1.26 1.98-2.574 1.98-4.103C13.3 3.215 10.48.7 7 .7S.7 3.215.7 6.318C.7 9.42 3.61 11.55 7.09 11.55v.932c0 .37.384.607.708.429.907-.5 2.484-1.445 3.52-2.491zM7.93 6.426a.944.944 0 11-1.889 0 .944.944 0 011.889 0zm-3.912.944a.944.944 0 100-1.889.944.944 0 000 1.889zm6.88-.944a.944.944 0 11-1.889 0 .944.944 0 011.89 0z"-->
                            <!--                                      fill="#1C1F23" fill-opacity="0.3"></path>-->
                            <!--                              </svg>-->
                            <!--                              <span class="info-figure-text&#45;&#45;2K5OJ">{{item.videoUpNum}}</span></div>-->
                            <div class="info-figure--2LJ6W">
                              <svg width="12" height="12" viewBox="0 0 12 12" fill="none">
                                <path fill-rule="evenodd" clip-rule="evenodd"
                                      d="M8.542.75c-.99 0-1.892.395-2.44 1.142C5.349 1.145 4.447.75 3.458.75 1.569.75 0 2.314 0 4.175c0 .126.006.184 0 .19.01.429.222 1.202.392 1.527 1.144 2.365 4.758 4.87 4.928 5.033.17.163.34.325.68.325s.51-.162.68-.325c.17-.162 3.329-2.442 4.71-4.658.06-.151.1-.226.203-.38.066-.16.132-.304.204-.38.125-.428.196-.751.203-1.142-.005-.011 0-.065 0-.19C12 2.315 10.43.75 8.542.75z"
                                      fill="#1C1F23" fill-opacity="0.3"></path>
                              </svg>
                              <span class="info-figure-text--2K5OJ">{{item.videoUpNum}}</span></div>
                          </div>
                          <div class="info-op--27SfJ info-row--1OQ3-">
                            <div class="info-op-left--3el-Y">
                              <div v-if="item.videoState === 1" class="info-status--15Tbn" style="color: rgb(57, 181, 74);">已发布</div>
                              <div v-if="item.videoState === 0" class="info-status--15Tbn" style="color: #E6A23C">审核中</div>
                              <div v-if="item.videoState === 2" class="info-status--15Tbn" style="color: #F56C6C">未通过</div>
                              <div class="info-time--1PtPa">{{ item.videoUploadTime }}</div>
                            </div>
                          </div>
                          <div class="op-btns--DxbEz">
                            <div v-if="item.videoState === 0" style="margin-bottom: 20px">
                              <div @click="pass(item.videoId,1)" class="ghost-btn--10MXQ op-btn--lDoCH" style="color: rgb(119, 120, 123);">
                                <i style="width: 16px ;height: 16px;color: rgb(57, 181, 74)" class="el-icon-check"></i>
                                <span style="color: rgb(57, 181, 74)">审核通过</span></div>
                              <div @click="pass(item.videoId,2)" class="ghost-btn--10MXQ op-btn--lDoCH" style="color: rgb(119, 120, 123);">
                                <i style="width: 16px ;height: 16px;color: #F56C6C" class="el-icon-close"></i>
                                <span style="color: #F56C6C">审核不通过</span></div>
                            </div>
                            <div @click="deleteVideo(item.videoId)" class="ghost-btn--10MXQ op-btn--lDoCH" style="color: rgb(254, 44, 85);">
                              <svg width="16" height="16" viewBox="0 0 16 16" fill="none">
                                <path fill-rule="evenodd" clip-rule="evenodd"
                                      d="M2.5 2a.5.5 0 00-.5.5v1a.5.5 0 00.5.5h11a.5.5 0 00.5-.5v-1a.5.5 0 00-.5-.5h-11zM13 6v7a2 2 0 01-2 2H5a2 2 0 01-2-2V6a.5.5 0 01.5-.5h9a.5.5 0 01.5.5z"
                                      fill="#FE2C55"></path>
                                <path d="M6 1a.5.5 0 01.5-.5h3a.5.5 0 01.5.5v1.5H6V1z" fill="#FE2C55"></path>
                              </svg>
                              <span>删除作品</span></div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminVideoManager",
  data(){
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      videos:[],
      allVideo:true,
      release:false,
      auditing:false,
      fail:false
    }
  },
  created() {
    this.getVideos()
  },
  methods:{
    getVideos(){
      this.request.post("http://localhost:9090/video/getAllUserVideo",JSON.stringify({
        "userId":this.user.userId
      })).then(res=>{
        this.videos = res.data;
      })
    },
    pass(videoId,videoState){
        this.request.post("http://localhost:9090/video/auditingVideo",JSON.stringify({
          "videoId":videoId,
          "videoState":videoState
        })).then(res=>{
          if (res.code === 200){
            this.$notify({
              title: '成功',
              message: '审核成功！',
              type: 'success',
              duration: 2000
            });
            this.allVideos();
          }else {
            this.$notify({
              title: '失败',
              message: '审核失败！',
              type: 'fail',
              duration: 2000
            });
          }
        })
    },
    deleteVideo(videoId){
      this.request.post("http://localhost:9090/video/deleteVideo",JSON.stringify({
        "videoId":videoId
      })).then(res=>{
        if (res.code === 200){
          this.$notify({
            title: '成功',
            message: '删除成功！',
            type: 'success',
            duration: 2000
          });
          this.allVideos();
        }else {
          this.$notify({
            title: '失败',
            message: '删除失败！',
            type: 'fail',
            duration: 2000
          });
        }
      })
    },
    allVideos(){
      this.getVideos();
      this.allVideo = true
      this.auditing = false
      this.release = false
      this.fail = false
    },
    getRelease(){
      this.allVideo = false
      this.auditing = false
      this.release = true
      this.fail = false
      this.request.post("http://localhost:9090/video/getReleaseVideoInfoAdmin",JSON.stringify({
        "userId":this.user.userId
      })).then(res=>{
        this.videos = res.data;
      })
    },
    getAuditing(){
      this.allVideo = false
      this.auditing = true
      this.release = false
      this.fail = false
      this.request.post("http://localhost:9090/video/getAuditingVideoInfoAdmin",JSON.stringify({
        "userId":this.user.userId
      })).then(res=>{
        this.videos = res.data;
      })
    },
    getFail(){
      this.allVideo = false
      this.auditing = false
      this.release = false
      this.fail = true
      this.request.post("http://localhost:9090/video/getFailVideoInfoAdmin",JSON.stringify({
        "userId":this.user.userId
      })).then(res=>{
        this.videos = res.data;
      })
    },
  }
}
</script>

<style scoped>
html, body, #root {
  width: 100%;
  height: 100%;
  background: #f7f8f9;
  color: #161823;
}

.container--38fle {
  min-height: 100vh;
  min-width: 1300px;
}

.header-wrapper--1ulkm {
  background: #fff;
  box-shadow: 0 4px 12px rgb(42 50 58 / 3%);
  display: flex;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 20;
  box-sizing: border-box;
}

.header--3r3HD {
  position: relative;
  z-index: 31;
  height: 84px;
  display: flex;
  margin: auto;
  align-items: center;
  width: 1200px;
  padding: 0 50px;
  justify-content: space-between;
  box-sizing: content-box;
}

.header--3r3HD .logo--z3q0A {
  width: 176px;
  height: 40px;
  vertical-align: text-bottom;
  margin-right: 8px;
  cursor: pointer;
}

.dropdown-wrapper--1F0hA {
  position: relative;
  font-size: 12px;
  color: rgba(22, 24, 35, 0.5);
  cursor: pointer;
}

.semi-icons-default {
  width: 16px;
  height: 16px;
}

.header--3r3HD .footer--m3NLu {
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  align-items: center;
}

.dropdown-wrapper--1F0hA {
  position: relative;
  font-size: 12px;
  color: rgba(22, 24, 35, 0.5);
  cursor: pointer;
}

.header--3r3HD .avatar--1lU_a {
  width: 32px;
  height: 32px;
  border-radius: 32px;
}

.creator-header-msg--1unC7 {
  position: absolute;
  background: #fff8ea;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  justify-content: center;
  align-items: center;
  white-space: nowrap;
  width: 100%;
  height: 44px;
  padding: 0;
  margin: 0;
  top: 84px;
  left: 0;
  font-size: 14px;
  color: #1c1f23;
  transition: all 1s;
  opacity: 0;
  transform: translateY(-100%);
  z-index: 30;
}

.container--38fle .content--3ncCf:not(.fullScreen--121rZ) {
  padding: 20px 50px 0;
  width: 1300px;

  min-height: 100vh;
  margin: auto;
  box-sizing: border-box;
}

.sidebar-popover-box--3Zhj7 {
  position: fixed;
  top: 84px;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  pointer-events: none;
  z-index: 11;
}

.sider--137Dm {
  margin-right: 20px;
  border-radius: 8px;
  position: sticky;
  top: 20px;
  float: left;
  z-index: 10;
}

.semi-navigation {
  border-right: none;
  height: -moz-calc(100vh - 128px);
  height: calc(100vh - 128px);
  overflow-y: auto;

  box-sizing: border-box;
  display: inline-flex;
  width: 240px;
  outline: none;
  overflow-x: hidden;
  margin: 0;
  padding-left: 8px;
  padding-right: 8px;
  user-select: none;
  transition: padding-left .1s ease-out, width .2s cubic-bezier(.62, .05, .36, .95);
  background-color: rgb(255 255 255);
}
.semi-navigation-inner {
  flex-direction: column;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: space-between;
}
.semi-navigation-vertical .semi-navigation-header {
  width: 100%;
  padding: 12px 0!important;
  border-bottom: 1px solid rgba(0,0,0,.06);

  display: inline-flex;
  align-items: center;
  box-sizing: border-box;
}
.semi-navigation-vertical .semi-navigation-header-list-outer {
  height: 100%;
}
.semi-button-block {
  width: 100%;
  height: 40px;
  padding: 10px 16px;

  background-color: #fe2c55;
  color: #fff;
}
.semi-button {
  box-shadow: none;
  font-size: 14px;
  line-height: 20px;
  font-family: PingFang SC,Arial,Microsoft YaHei,sans-serif;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  user-select: none;
  border: 0 solid transparent;
  border-radius: 3px;
  font-weight: 700;
  outline: none;
  vertical-align: middle;
  white-space: nowrap;
}
.semi-navigation-vertical .semi-navigation-list-wrapper {
  padding-top: 12px;
  overflow-y: auto;
  overflow-x: hidden;
}
.semi-navigation-list {
  margin: 0;
  padding: 0;
  list-style: none;
}
.semi-navigation-list>.semi-navigation-item, .semi-navigation-list>.semi-navigation-item>.semi-navigation-sub-title {
  font-weight: 700;
}
.semi-navigation-list>.semi-navigation-item-normal {
  height: 36px;
}

.semi-navigation-item, .semi-navigation-sub-wrap .semi-navigation-sub-title {
  cursor: pointer;
  display: flex;
  border-radius:3px;
  padding: 8px 12px;
  box-sizing: border-box;
  margin-top: 0;
  margin-bottom: 8px;
  font-size: 14px;
  line-height: 20px;
  font-family: PingFang SC,Arial,Microsoft YaHei,sans-serif;
  font-weight: 400;
  color: rgb(35 28 31);
  width: 100%;
}
.semi-navigation-item-icon:first-child {
  margin-right: 12px;
  min-width: 20px;
}
.semi-navigation-item-icon {
  display: inline-flex;
  color: rgb(35 28 31 / 60%);
}
.semi-navigation-item-text, .semi-navigation-sub-wrap .semi-navigation-sub-title-text {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  transition: opacity .2s cubic-bezier(.5,-.1,1,.4);
  opacity: 1;
}
.semi-navigation-list>.semi-navigation-item, .semi-navigation-list>.semi-navigation-item>.semi-navigation-sub-title {
  font-weight: 700;
}

.semi-navigation-sub-wrap {
  display: block;
  padding: 0;
  margin-top: 0;
  height: inherit;
}
.semi-navigation-item, .semi-navigation-sub-wrap .semi-navigation-sub-title {
  cursor: pointer;
  display: flex;
  border-radius: 3px;
  padding: 8px 12px;
  box-sizing: border-box;
  margin-top: 0;
  margin-bottom: 8px;
  font-size: 14px;
  line-height: 20px;
  font-family: PingFang SC,Arial,Microsoft YaHei,sans-serif;
  font-weight: 400;
  color: rgb(35 28 31);
  width: 100%;
}
.semi-navigation-vertical .semi-navigation-list>.semi-navigation-sub-wrap>.semi-navigation-sub-title {
  color: rgb(35 28 31);
  background-color: transparent;
}
.semi-navigation-list>.semi-navigation-item, .semi-navigation-list>.semi-navigation-item>.semi-navigation-sub-title {
  font-weight: 700;
}
.semi-navigation-sub-wrap .semi-navigation-sub-title {
  display: flex;
  justify-content: flex-start;
  height: 36px;
  align-items: center;
}
.semi-navigation .semi-navigation-sub-title {
  margin-bottom: 0;
}
.semi-navigation-item, .semi-navigation-sub-wrap .semi-navigation-sub-title {
  cursor: pointer;
  border-radius: 3px;
  padding: 8px 12px;
  box-sizing: border-box;
  margin-top: 0;
  font-size: 14px;
  line-height: 20px;
  font-family: PingFang SC,Arial,Microsoft YaHei,sans-serif;
  font-weight: 400;
  width: 100%;
}
.semi-navigation-sub-wrap .semi-navigation-sub-title>.semi-navigation-item-inner {
  display: flex;
}
.semi-navigation-item-inner {
  align-items: center;
  width: 100%;
  flex: 0 0 auto;
}
.semi-navigation-item-icon:first-child {
  margin-right: 12px;
  min-width: 20px;
}
.semi-navigation-item-icon {
  display: inline-flex;
  color: rgb(35 28 31 / 60%);
}
.sider--137Dm .nav-icon--HHAMV {
  width: 20px;
  height: 20px;
}
.semi-navigation-item-text, .semi-navigation-sub-wrap .semi-navigation-sub-title-text {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  transition: opacity .2s cubic-bezier(.5,-.1,1,.4);
  opacity: 1;
}
.semi-navigation-item-icon:last-child {
  margin-left: auto;
  transition: opacity .2s cubic-bezier(.5,-.1,1,.4);
  opacity: 1;
}
.semi-navigation-item-icon {
  display: inline-flex;
  color: rgb(35 28 31 / 60%);
}
i {
  font-style: italic;
}
.semi-icons-default {
  width: 16px;
  height: 16px;
}

.semi-icons {
  fill: currentColor;
}
svg:not(:root) {
  overflow: hidden;
}

.semi-navigation-sub-wrap {
  display: block;
  padding: 0;
  margin-top: 0;
  height: inherit;
}
.semi-navigation-sub {
  font-weight: 400;
  font-size: 14px;
  list-style: none;
  outline: none;
  padding: 0;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
.micro--3AMFh {
  width: calc(100%);
  display: inline-block;
  min-height: 400px;
}
.micro--2kLg8 {
  font-size: 14px;
  min-height: 845px;
  background-color: #fff;
}
.card--cdv2-.full--3ADOq {
  min-height: 100%;
}
.card--cdv2- {
  flex: 1;
  background-color: #fff;
  border-radius: 8px;
  padding: 40px;
  overflow: hidden;
  margin-bottom: 20px;
}
.title--2ZrJf {
  font-style: normal;
  font-weight: bold;
  font-size: 24px;
  line-height: 28px;
  color: #323538;
  margin-bottom: 16px;
}
.content-header--38RgH {
  padding-top: 20px;
  background-color: #fff;
  z-index: 9;
  border-bottom: 1px rgba(51,51,51,.1) solid;
}
.content-header-op--3GYVM {
  display: flex;
  justify-content: space-between;
}
.content-header-tabs--17dou {
  flex: 1;
}
.tabs--2hbn4 {
  display: inline-flex;
  user-select: none;
  color: #161823;
}

.tabs--2hbn4 .tab--3x6v2 {
  flex-grow: 1;
  display: flex;
  justify-content: center;
  margin-right: 20px;
  cursor: pointer;
  font-size: 16px;
  line-height: 22px;
  color: #161823;
}
.tabs--2hbn4 .tab-item--1zwL9.active--36U4v {
  color: #252729;
  font-weight: bold;
  border-bottom: 3px solid #fe2c55;
}
.tabs--2hbn4 .tab-item--1zwL9 {
  position: relative;
  padding-bottom: 13px;
  padding-right: 4px;
  padding-left: 4px;
  color: #6b7075;
  font-size: 14px;
}
.content-body--29zhI {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-bottom: 32px;
  position: relative;
  left: -16px;
  padding-top: 16px;
  width: 104%;
}
.video-card--1404D {
  display: flex;
  padding: 16px;
  width: 100%;
  background-color: #fff;
  font-size: 14px;
  transition: background-color .15s ease-out;
  position: relative;
  border-radius: 4px;
}
.video-card-cover--2Y2HT {
  flex: 0 0 auto;
  position: relative;
  height: 200px;
  width: 150px;
  border-radius: 4px;
  background-color: rgba(22,24,35,.3);
  overflow: hidden;
  cursor: pointer;
}
.video-card-info--stqta {
  display: flex;
  flex-direction: column;
  padding-left: 20px;
  overflow: hidden;
  width: 100%;
}
.video-card--1404D .info-title-text--kEYth {
  font-size: 16px;
  line-height: 22px;
  color: #161823;
  white-space: pre-wrap;
  overflow: hidden;
  text-overflow: ellipsis;
  word-break: break-all;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.video-card--1404D .info-row--1OQ3- {
  display: flex;
  align-items: center;
  margin-top: 10px;
}
.video-card--1404D .info-figure--2LJ6W:first-of-type {
  margin-left: 0;
}
.video-card--1404D .info-figure--2LJ6W {
  display: inline-flex;
  align-items: center;
  margin: 0 8px;
  color: rgba(28,31,35,.6);
}
.video-card--1404D .info-figure-text--2K5OJ {
  font-size: 14px;
  line-height: 20px;
  margin-left: 4px;
  color: rgba(28,31,35,.6);
}
.video-card--1404D .info-op--27SfJ {
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 12px;
  line-height: 20px;
  color: rgba(22,24,35,.5);
}
.video-card--1404D .info-row--1OQ3- {
  margin-top: 10px;
}
.video-card--1404D .info-op-left--3el-Y {
  display: flex;
  align-items: center;
  color: rgba(28,31,35,.55);
}
.info-status--15Tbn {
  display: flex;
  align-items: center;
  margin-right: 12px;
}
.video-card--1404D .info-op--27SfJ .info-time--1PtPa, .video-card--1404D .info-op--27SfJ .info-from--2ypa1 {
  line-height: 2;
}
.video-card--1404D:hover .op-btns--DxbEz {
  visibility: visible;
  opacity: 1;
}
.video-card--1404D .op-btns--DxbEz {
  margin-top: auto;
  transition: all .15s ease-in;
}
.video-card--1404D .op-btns--DxbEz .op-btn--lDoCH {
  padding-right: 12px;
  margin-right: 20px;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  display: inline-flex;
}

</style>
