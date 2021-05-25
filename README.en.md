# lost_and_found_backstage

#### Description
失物招领系统后台项目，“lost_and_found_backstage_frontEnd”为前端，“lost_and_found_backstage_backEnd”为后端。

#### Software Architecture
Software architecture description
软件架构说明：项目基于人人开源框架：https://gitee.com/renrenio

前端：Vue、element-ui、Vuex、vue-router、axios、webpack、gulpfile.js

后端：SpringBoot、mybatis-plus、Shiro、aliyun-oss

服务器：centOS7、docker、nginx

数据库：mysql、redis

#### Installation

前端：
  需要环境：node.js、vue.js、npm、cnpm (cnpm用于加快包下载速度，有助于解决npm下载包时的各种网路连接导致的错误)
  
后端：
  需要环境：jdk_1.8、maven
  
服务器：
  需要环境：mysql、redis、nginx、docker（docker也可以不用，但是建议使用，方便）

#### Instructions

前端：
1.  在终端输入“cnpm install”下载项目所需包（如果没有cnpm，用“npm install”也可，但是准备好面对各种因为网路问题而下载不完全导致的err）
2.  使用“npm run dev”运行dev环境
3.  如需构建到nginx或tomcat服务器，使用“npm run build”构建项目，会生成dist文件夹

4.  可以开启本地模式，在config/dev.env.js中，将OPEN_PROXY设置为true，则所有请求都走config/index.js中的接口（原理请阅读文件：src\utils\httpRequest.js）
5.  如果第4步OPEN_PROXY为false，则所有请求将使用static\config\里配置，dev环境将使用index.js，生产环境将使用index-prod.js，其他环境参考当前目录文件注释（原理请参考package.json中的scripts）

后端：
1.  先查看自己IDE的maven、jdk环境是否有误，请一定再检查一边自己IDE的mvn环境，如果mvn环境有问题那每次打开IDE都会将mvn设置为idea默认地址、仓库（之前遇到过还以为是ide的bug，结果是mvn环境配置有问题，ide检查了每次都会提醒，但我没管）

2.  使用mvn下载依赖包
3.  redis、oss等环境配置请查看application.yml，默认使用dev模式，对应数据源配置请查看application-dev.yml
4.  运行LostAndFoundApplication以启动项目

服务器：
1.  nginx: 请参考官方安装教程，并配置config，nginx端口配置、http转https以及https反向代理http后端等配置都在config\nginx目录下
1.  docker: 请搜索docker官方安装配置教程，并下载mysql、redis等镜像
2.  mySQL: 数据库构建sql在config\sql目录下，建议端口映射为非常用端口

3.  redis：启动命令在config目录下，请一定一定一定要设置密码、配置非常用端口（作者由于疏忽，没设置密码导致kdevtmpfsi挖矿病毒通过redis可更改本地定时任务的漏洞注入到服务器中，并被植入后面，改成非常用端口没啥用）
4.  如要设置docker远程访问2375端口，请一定要使用密钥登录，不然就是把服务器的root权限拱手送人，作者由于心大，被有心人士注入病毒镜像运行，导致服务器再次沦为别人的肉鸡和矿机，开启了长达十几天的服务器攻防战，我痛并快乐着同时身心疲惫
5.  docker远程访问配置请参考：https://blog.csdn.net/qq_39503880/article/details/107853966


#### Contribution

1.  系统基于人人开源框架开发：https://gitee.com/renrenio
2.  项目部分工具使用请参考：up主@尚硅谷的《谷粒商城》系列


#### Gitee Feature

1.  作者服务器：https://www.bfcod.cn
2.  前台项目：  https://www.bfcod.cn:8081
2.  后台项目：  https://www.bfcod.cn:8082

#### Attack and Defense

1.  如遇CPU100%，不要迷茫，不要慌乱，使用"top -c -n 1 -b"显示后台进程，请参考腾讯云、阿里云帮助文档排查是否被入侵，网上都有类似问题的分析和处理步骤，但不要盲目按照别人的教程走，不然又会进入另一个旋涡
2.  如确认是中病毒，先保存对方入侵痕迹（如果对方只是个脚本小子，那肯定会留下证据）、sh脚本、ip地址、域名等，在之后无聊的时候分析这些东西，你能学到很多知识
3.  正式开始排查问题，根据参考文档，排查被修改的关键文件，如：passwd、crontabs、authorized_keys等，最关键的就是对方的sh，从sh中能分析出对方动了你哪些文件
4.  如果你的docker是开放的，注意检查是否多了些奇奇怪怪的images、containers，也许containers里已经被注入了别人的程序
5.  病毒清除完了，可以松一口气了，但不要盲目放松，因为世上没有完美的盾
6.  对redis入侵脚本有兴趣，可以查看config/backup1.txt文件，这是注入到我的redis里的key下载的sh脚本，里面的chattr、2>/dev/null、iptables等命令让我收获颇多

7.  coders之后请主动关爱自己的服务器，给服务器穿上衣服（即使是三点式也比裸奔好）或战甲，不要你的这个“她”都变成了别人的形状了你还浑然不知
8.  搜索各种安全基线，将服务器加固；firewall、iptables等该加规则的加规则，将对方ip加入禁止规则中；多安装安全防护类程序，防止变成别人的肉鸡
9.  之后测试服务器这些安全规则是否生效，可以多用Nmap等嗅探工具分析端口是否是opened
10. 遇到被入侵，应该感到兴奋，因为这会让你成长，寻找问题、记录问题、分析问题、解决问题、总结问题
11. 请多关注代码方面的安全性，何为挂马、XSS、CSRF、XSS的多种分类等


#### Kill Bug

1.  如遇报错，请联系广大的coders和搜索引擎
2.  有时间我将我所遇到的问题，分析总结，通过项目分享出来
3.  啥时候我想了的话，感觉我所遇到的问题和解决办法网上都是有的，但是太乱了
4.  我需要的是条理清晰、明朗的分析总结，不仅仅是个解决步骤，相信你也是但我是个懒狗:)
