> 作用：帮助你导出api到`yapi`/`postman`/`markdown` 基于javadoc&KDoc&ScalaDoc解析API文档
>

> 注意：你可以在保持代码零侵入的情况下得到相当完整的api文档, 但是特殊的需求还是需要部分特殊的注释/注解配合，与之相对的是, 你可以灵活的运用配置规则来适应你的项目特性以减少代码侵入.

> 官网地址 ： [http://easyyapi.com/](http://easyyapi.com/)

# 安装
Preferences → Plugins → Marketplace → 搜索“EasyYapi” → 安装该插件 → 重启IDE
![image.png](https://cdn.nlark.com/yuque/0/2021/png/1666959/1622686282731-253a3041-427e-428f-8dba-6536e903b647.png#clientId=u1a577dc0-c541-4&from=paste&height=706&id=udc490d25&margin=%5Bobject%20Object%5D&name=image.png&originHeight=706&originWidth=985&originalType=binary&size=75057&status=done&style=none&taskId=u86192b30-aa8d-45f6-bd82-695df0e958d&width=985)
# 配置EasyYapi

1. Settings -> Other Settings -> EasyYapi -> 勾选methodDoc  ->  设置Yapi 服务器地址 和 token -> apply

![image.png](https://user-images.githubusercontent.com/30682144/148865625-1db01396-a3d6-4c52-97e0-9cd2701d24b9.png)


2. Yapi信息获取

server : [https://yapi.xxx.cn](https://yapi.xxx.cn)
token :  设置 -> token设置 -> 复制token
![image.png](https://cdn.nlark.com/yuque/0/2021/png/1666959/1622686656462-fd376b9f-b5c2-4d8e-9e51-537df10de370.png#clientId=u1a577dc0-c541-4&from=paste&height=785&id=ube3c01f8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=785&originWidth=1263&originalType=binary&size=72486&status=done&style=none&taskId=u7ab5e844-cfd0-438b-85d9-3fc69986468&width=1263)
# 使用
## 注释规范
### 类注释
#### 例子
~~~java
/**
 * 测试分类4
 * 这是一个测试类哦~
 * @module easyyapi-demo
 * @author wangxt
 * @date 2021/06/01 15:11
 */
@RequestMapping("/demo/")
@RestController
public class DemoController {}
~~~
#### 模板
~~~java
/**
 *
 *
 * @module
 * @author
 * @date $date$ $time$
 */
~~~
- 第一行对应Yapi中的接口分类
- 第一行到第一个以@开头的行中间的 接口描述
- @module 为Yapi中的项目名称
### 方法注释
#### 例子
~~~java
/**
 * demoMethod
 * 这是一个测试方法哦~
 * @param userId 用户ID
 * @param name 用户昵称
 * @param userType 用户类型 {@link com.easyyapi.demo.domain.enumx.UserTypeEnum}
 * @author wangxt
 * @date 2021/6/1 0001 15:53
 * @return {@link DemoVo}
 */
@RequestMapping("demoMethod.do")
@ResponseBody
private ServerResponse<DemoVo> demoMethod(@RequestParam(required = true) Integer userId,
                                          @RequestParam(required = false, defaultValue = "") String name,
                                          @RequestParam(value = "user_type", required = false, defaultValue = "1") Integer userType){
    return ServerResponse.createBySuccess(new DemoVo());
}
~~~
#### 模板
~~~java
/**
 * 
 * 
 * @param
 * @param
 * @author 
 * @date $date$ $time$
 * @return
 */
~~~
- 第一行为在Yapi展示的接口名称
- 第二行为接口描述
- 入参要通过@RequestParam 详细描述
- 返回参数需要指定ServerResponse的泛型
### VO注释
#### 例子
~~~java
/**
 *
 * 测试 VO
 * @author wangxt
 * @date 2021/06/01 15:41
 */
public class DemoVo {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户余额
     */
    private Double amount;

    /**
     * 用户类型
     * @see com.easyyapi.demo.domain.enumx.UserTypeEnum#type
     */
    private Integer userType;

    /**
     * 用户昵称
     * @deprecated
     */
    private String name;

    /**
     * 用户性别
     */
    @NotNull
    private Integer sex;
}
~~~
- 每个属性需要详细进行描述，会展示到Yapi
- 废弃字段可以通过@deprecated注释或者 @Deprecated注解 标明
- 非空或者非NULL字段可通过@NotBlank@NotNull 注解标明
- 如果属性为枚举的话，可以通过 @see 注释关联到对应的枚举，并且需要通过 #{枚举属性值} 表名展示那个字段
# 展示
![image.png](https://cdn.nlark.com/yuque/0/2021/png/1666959/1622689954034-a10a3e3f-c0cb-4d32-a9d6-170109f05163.png#clientId=u6d7ed34e-2515-4&from=paste&height=867&id=ua8dc40a2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=867&originWidth=1668&originalType=binary&size=82469&status=done&style=none&taskId=u1d5a6d29-17b8-4d07-9d33-984b36f6aac&width=1668)
![image.png](https://cdn.nlark.com/yuque/0/2021/png/1666959/1622689989448-aa9c8e89-a32e-4874-9a2d-fd848505e363.png#clientId=u6d7ed34e-2515-4&from=paste&height=592&id=u0c0e3b43&margin=%5Bobject%20Object%5D&name=image.png&originHeight=592&originWidth=1519&originalType=binary&size=52256&status=done&style=none&taskId=u29f901df-47aa-4712-b84b-0f51e645d1e&width=1519)
# 其它
文中提到的 @NotNull @NotBlank 注解是引用的 javax.validation 包下的，需要在项目pom中引用
~~~xml
<dependency>    
    	<groupId>javax.validation</groupId>
    	<artifactId>validation-api</artifactId>
    	<version>1.1.0.Final</version>
</dependency>
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-validator</artifactId>
	<version>5.4.1.Final</version>
</dependency>
~~~



