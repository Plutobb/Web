<template>
<el-container>

  <el-aside style="background-color: #060716;width: 172px">
    <Aside/>
  </el-aside>

  <el-container>
    <el-header>
      <Header/>
    </el-header>

    <el-main style="background: #161722;min-height: 2000px">
      <router-view/>
    </el-main>
  </el-container>

</el-container>
</template>
<style>
.searchInput{
  max-width: 400px;
}

.FenGeXian{
  border-bottom: 1px solid rgba(54,55,65,04);
  margin: 12px 58px 0 25px ;
}
.el-header {
  background-color: #161722;
  color: #ffffff;
  line-height: 60px;
  border-bottom: 1px solid rgba(54,55,65,04);
}

.el-aside {
  background-color: #060716;
  color: #000000;
}
.el-menu{

  border:0!important;

}


</style>

<script>
// eslint-disable-next-line
/* eslint-disable */
// import HelloWorld from './components/HelloWorld.vue'
import Aside from "../components/Aside";
import Header from "../components/Header";
export default {
  data: function () {
    return {
      input: '',
      count: 0,
      player: null,
      options: {
      },
      fits: ['fill'],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
    }
  },
  components: {
    Header,
    Aside
  },
  mounted() {

  },

  methods: {

  }
}
</script>

