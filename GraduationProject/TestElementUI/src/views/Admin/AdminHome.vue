<template>

  <div id="root">

    <div class="container--38fle">
      <el-header style="background: white">
        <UserAdminHeader></UserAdminHeader>
      </el-header>
      <div class="content--3ncCf creator-content">
        <div class="sidebar-popover-box--3Zhj7" id="sidebar-popover-box"></div>
        <div class="sider--137Dm creator-sidebar">
          <div class="semi-navigation semi-navigation-vertical">
            <div class="semi-navigation-inner">
              <div class="semi-navigation-header-list-outer">
                <div class="semi-navigation-header">
                  <el-row class="tac">
                    <el-col :span="24">
                      <el-menu
                        default-active="1-1"
                        class="el-menu-vertical-demo"
                        active-text-color="#fe2c55"
                        default-openeds="['1','2','3']"
                        router
                      >

                        <el-submenu index="1">
                          <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span >视频管理</span>
                          </template>
                          <el-menu-item-group>
                            <el-menu-item index="/admin/videoManager">视频审核</el-menu-item>
                          </el-menu-item-group>
                        </el-submenu>

                        <el-submenu index="2">
                          <template slot="title">
                            <i class="el-icon-s-custom"></i>
                            <span >用户管理</span>
                          </template>
                          <el-menu-item-group>
                            <el-menu-item index="/admin/userManager">用户管理</el-menu-item>
                          </el-menu-item-group>
                        </el-submenu>

                        <el-submenu index="3">
                          <template slot="title">
                            <i class="el-icon-s-order"></i>
                            <span >信息管理</span>
                          </template>
                          <el-menu-item-group>
                            <el-menu-item index="/admin/updateAdminInfo">修改管理员信息</el-menu-item>
                          </el-menu-item-group>
                        </el-submenu>

                      </el-menu>
                    </el-col>
                  </el-row>
                </div>
              </div>
            </div>
          </div>
        </div>

        <el-main style="height: 800px;padding: 0">
          <router-view/>
        </el-main>
      </div>
    </div>
  </div>
</template>

<script>
import UserAdminHeader from "../../components/UserAdminHeader";

export default {
  name: "AdminHome",
  components: {UserAdminHeader},
  methods:{
    uploadVideo(){
      this.$router.replace('/video/upload')
    }
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
  width: calc(100% - 260px);
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
