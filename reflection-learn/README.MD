## 反射学习
链接：https://www.bilibili.com/video/BV1K4421w7zP/?spm_id_from=333.337.search-card.all.click&vd_source=63e8e933c318d4e88c60dd41ca03c54f
### 1. what is class object?
每个类都有一个类对象，是在类加载过程中生成的。\
获取的方式有三种:
1. 类的.class方法，在编译阶段就能确定类型
```java
Class<User> clazz = User.class;
```
2. 对象的getClass方法, 在运行时才能确定类型，因此类型只能用通配符表示
```java
Class<?> clazz = user.getClass();
```
3. Class的forName方法，在运行时才能确定类型，同时会执行静态代码块中的方法
```java
// 相当于手动 加载一个类对象
Class<?> clazz = Class.forName("com.kingpopen.model.User");
```
### 2. how to operator class object?
#### 2.1 get field, method ...
* getFields() 方法获取public 属性
* getMethods() 方法获取public 方法 
* ......
* getDeclaredFields() 方法获取所有 属性
* getDeclaredMethods() 方法获取所有 方法
* ......
#### 2.2 get field val, change field val, operator method
* 操作属性
```java
// 获取指定的属性
Field field = clazz.getField("username");
// 获取对应的值, 需要将具体的实例作为参数传入，如果是静态属性可以传入null
field.get(obj);
// 改变对应的属性
field.setAccessible(true);   
field.set(obj, "xxx");
```

* 操作方法
```java
// 获取一个带参数的私有方法 参数为String类型
Method method = clazz.getMethod("privateFuncWithParam", String.class);
// 进行调用
method.setAccessible(true);
method.invoke(obj, "xxx");
```
### 3. best practise
最佳实践
* Config类为配置类，其中可以定义存储在容器中的Bean
* Container类 通过反射 + 注解 生成生成相应的Bean