# Test
相关技术的测试


axis2的测试 TestAxis2

axis2 初步流程如下(2015-7-2)

1.准备工作
首先到官网下载Axis2的bin包和war包，名字如下：

axis2-1.6.2-bin.zip

axis2-1.6.2-war.zip

下载地址如下：

http://axis.apache.org/axis2/java/core/download.cgi


到官网下载Eclipse的axis2插件，插件包的名字如下：

axis2-eclipse-service-plugin-1.6.2.zip

axis2-eclipse-codegen-plugin-1.6.2.zip

下载地址如下：

http://axis.apache.org/axis2/java/core/tools/index.html

2.安装axis2的环境

2.1 安装axis2：

将axis2-1.6.2-bin.zip文件解压到任意文件夹下（我的解压到了D盘根目录）

2.2 配置Eclipse的axis2的环境

Window -> Preferences -> Web Services -> Axis2 Preferences,点击
Browse选择axis2的安装路径。具体请参见下图：

![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_1.jpg)

2.3 安装插件 解压axis2-eclipse-codegen-plugin-1.6.2.zip和axis2-eclipse-service-plugin-1.6.2.zip，
把得到的两个jar包放入eclipse目录下的\plugins\中，重启eclipse。如果安裝成功，点击new -> other ->Axis2 Wizards
文件夹下有两个选项，具体情况，请参见下图：

![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_2.png)

3.发布axis2


3.1实现一个零配置的webservice

3.1.1
编写一个 WebService类(要求这个类不能打包，即不能用package来打包)
public class HelloServices {
	public String sayHello(String name) {
		return "Hello," + name;
	}
}

3.1.2
编译这个类

3.1.3
将编译生成的.class 文件直接复制到%tomcat_home%\webapps\axis2\WEB-INF\pojo目录中，如果pojo目录不存在	，
建立这个目录


3.2  实现一个带包的webservice
 解压axis2-1.6.2-war.zip获得axis2.war并把它放到tomcat解压目录的webapps文件夹下，启动tomcat，浏览器中输入
 http://localhost:8080/axis2/，出现如下图所示，说明配置成功。
 
![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_3.png)

3.3 用Eclipse的axis2插件发布web任务
 3.3.1    在eclipse中new一个Dynamic Web Project，取名webserviceService。编写一个简单的webService服务器代码
 
package com.prd.axis;

public class HelloServices {
	public String sayHello(String name) {
		return "Hello," + name;
	}
}

 3.3.2 在eclipse的空白workspace处，右键new->Other,在弹出的对话框中，找到Axis2 Service Archiver,双击->选择
 HelloWorldService所在项目的class路径，如图所示：
 
 ![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_4.png)
 
 next->选中skip WSDL
 
 ![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_5.png)
 
 Next->什么都不填(这里填写你用到的一些jar包)
 
 ![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_6.png)
 
 NEXT->选中Generate the service xml automatically(这里是选择service.xml如果你已经定义了这个文件，就可以选择
 自己的定义的文件，如果没有的话，选中Generate the service xml automatically让插件帮你生成的service.xml文件。这里
 让插件生成。)
 
 ![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_7.png)
 
 NEXT->输入全类名，点击load。这里的操作如图所示：
 
 ![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_8.png)
 
 NEXT->输入输出路径和输出名字
 
  ![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_9.png)
  
  点击finsh结束。
  
 3.3.3 部署到tomcat中
 
 把此aar文件放到%tomcat_home%\webapps\axis2\WEB-INF\services下。浏览器中输入http://localhost:8080/axis2/services/HelloWorldService?wsdl，出现如图所示，说明发布成功。
 
![](https://raw.githubusercontent.com/lifuz/my_document/master/image/axis2_use_10.png)

 
 
