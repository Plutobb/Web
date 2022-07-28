<template>
  <div class="sider--137Dm creator-sidebar">
    <div class="semi-navigation semi-navigation-vertical">
      <div class="semi-navigation-inner">
        <div class="semi-navigation-header-list-outer">
          <div class="semi-navigation-header">
            <button @click="uploadVideo()" class="semi-button semi-button-primary semi-button-size-large semi-button-block" type="button"
                    style="margin: 0px;"><span class="semi-button-content">发布视频</span></button>
          </div>

          <div>
            <el-row class="tac">
              <el-col :span="24">
                <el-menu
                  default-active="1"
                  class="el-menu-vertical-demo"
                  active-text-color="#fe2c55"
                  default-openeds="['1','2','3']"
                >
                  <el-submenu index="1">
                    <template slot="title">
                      <i class="el-icon-location"></i>
                      <span >内容管理</span>
                    </template>
                    <el-menu-item-group>
                      <el-menu-item index="1-1">视频管理</el-menu-item>
                      <el-menu-item index="1-2">视频管理</el-menu-item>
                    </el-menu-item-group>
                  </el-submenu>

                  <el-submenu index="2">
                    <template slot="title">
                      <i class="el-icon-location"></i>
                      <span >互动管理</span>
                    </template>
                    <el-menu-item-group>
                      <el-menu-item index="2-1">关注管理</el-menu-item>
                      <el-menu-item index="2-2">粉丝管理</el-menu-item>
                    </el-menu-item-group>
                  </el-submenu>

                  <el-submenu index="3">
                    <template slot="title">
                      <i class="el-icon-location"></i>
                      <span >个人信息管理</span>
                    </template>
                    <el-menu-item-group>
                      <el-menu-item index="3-1">修改个人信息</el-menu-item>
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
</template>

<script>
export default {
  name: "UserAdminAside",
  methods:{
    goUpload(){
      this.$router.push('/video/upload');
    }
  }
}
</script>

<style scoped>
.aside{
  width: 200px;
}
</style>
