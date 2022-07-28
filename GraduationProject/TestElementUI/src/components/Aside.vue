<template>
  <div style="margin-left: 25px">
  <el-menu
    default-active="2"
    class="el-menu-vertical-demo"
    background-color="#060716"
    text-color="#fff"
    active-text-color="#ffd04b"
    router>
    <el-menu-item index="/home">
      <i class="el-icon-menu"></i>
      <span slot="title">Mopo</span>
    </el-menu-item>
    <el-menu-item index="/video/hot">
      <i class="el-icon-sunny"></i>
      <span class="asideSpan" slot="title">热点</span>
    </el-menu-item>
    <el-menu-item index="/video/recommend">
      <i class="el-icon-star-off"></i>
      <span class="asideSpan" slot="title">推荐</span>
    </el-menu-item>
    <div class="FenGeXian"></div>
    <el-menu-item index="/video/entertainment">
      <i class="el-icon-user"></i>
      <span class="asideSpan" slot="title">娱乐</span>
    </el-menu-item>
    <el-menu-item index="/video/sports">
      <i class="el-icon-basketball"></i>
      <span class="asideSpan" slot="title">体育</span>
    </el-menu-item>
    <el-menu-item index="/video/game">
      <i class="el-icon-mouse"></i>
      <span class="asideSpan" slot="title">游戏</span>
    </el-menu-item>
    <el-menu-item index="/video/music">
      <i class="el-icon-headset"></i>
      <span class="asideSpan" slot="title">音乐</span>
    </el-menu-item>
  </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>
.asideSpan{
  font-size: 16px;
}
</style>
