<template>
  <div class="mod-home">
    <h3>项目介绍</h3>
    <ul>
      <li>
        “lost_and_found_forestage”：
        实现失物招领系统的前台功能
        ，用户使用的，也就是
        <a href="https://www.bfcod.cn:8081/" target="_blank"
          >前台用户系统</a
        >
      </li>
      <li>
        “lost_and_found_backstage”：
        实现失物招领系统的后台功能
        ，管理员使用的，也就是
        <a href="https://www.bfcod.cn:8082/" target="_blank"
          >后台管理系统</a
        >
      </li>
      <li>2个子系统都是前后端分离，通过token进行数据交互，可独立部署</li>
    </ul>
    <h3>链接</h3>
    <ul>
      <li>
        前台演示地址：<a href="https://www.bfcod.cn:8081/" target="_blank"
          >https://www.bfcod.cn:8081/</a
        >
        (账号密码：111/111)
      </li>
      <li>
        后台演示地址：<a href="https://www.bfcod.cn:8082/" target="_blank"
          >https://www.bfcod.cn:8082/</a
        >
        (账号密码：admin/admin)
      </li>
    </ul>
    <h3>技术介绍</h3>
    <ul>
      <li>前端是基于vue、element-ui、axios构建开发</li>
      <li>后端是基于springboot、mybatis-plus构建开发</li>
    </ul>
  </div>
</template>

<script>
export default {};
</script>

<style>
.mod-home {
  line-height: 1.5;
}
</style>

