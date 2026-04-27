package Class19OOP2SingletonPattern;

// When to use Singleton Pattern?
// 核心判断一句话：
// 👉 这个对象在整个系统中“只应该有一个实例”

// 1️⃣ 全局唯一资源（最典型）
// ✔ 配置管理器
// ConfigManager.getInstance().get("db.url");
// 👉 整个系统只需要一个配置源
// 否则：配置不一致 ❌ 
//      多份缓存 ❌

// 2️⃣ 共享状态（需要全局访问）
// ✔ 缓存（Cache）
//      Cache.getInstance().put(key, value);
//      👉 如果不是单例：
//          每个地方一份缓存 ❌
//          内存爆炸 ❌
//          数据不一致 ❌
// ✔ 连接池（数据库 / 线程池）
//      比如：数据库连接池, 线程池
//      👉 本质：
//          资源昂贵
//          需要统一管理

// 3️⃣ 资源访问控制（避免冲突）
// ✔ 打印机 / 文件系统 / 硬件资源
// 👉 例子：
//      只有一个打印机
//      同时多个线程访问
// 👉 用单例：
//      统一入口
//      控制并发

// 4️⃣ 工具类（无状态但统一入口）
// public class IdGenerator {
//     private static final IdGenerator INSTANCE = ...
// }
// 👉 比 static 方法更灵活（可以扩展）

// 5️⃣ 系统级组件（框架里很常见）
// 在：
//      Spring
//      后端服务
// 👉 很多 Bean 默认就是单例

// Eager Initialization
// 当开销比较大的时候用eagerSing
public class Logger {
    private static final Logger INSTANCE = new Logger();

    // private String msg;

    // 核心：private constructor
    private Logger() {
        System.out.println("My logger is created");
    }

    public void logMessage(String msg) {
        System.out.println(msg);
    }

    // public String getMsg() {
    //     return msg;
    // }

    public static Logger getInstance() {
        return INSTANCE;
    }
}

