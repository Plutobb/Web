<template>
  <el-container>

    <el-container>
      <el-header>
          <Header/>
      </el-header>

      <el-main class="main">
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
.main{
  flex: 1 1 0%;
  display: flex;
  flex-direction: column;
  overflow-y: scroll;
  min-height: 100%;
  background: #161722
}


</style>

<script>
// eslint-disable-next-line
/* eslint-disable */
// import HelloWorld from './components/HelloWorld.vue'
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
  },
  mounted() {

  },

  methods: {

  }
}
</script>

