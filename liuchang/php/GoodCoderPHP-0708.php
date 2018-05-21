<?php
/**
 * @author: liuchang05@iwaimai.baidu.com
 * @desc: GoodCoderPHP 07-08 Q1-Q5
 * @date: 2017/12/16 20:27
 */
Bd_Init::init();

class PricticeFour{

    // -Q1：请尽可能多的列举魔术方法，且编写代码说明其用法。
    public function magicFunction(){
    /*
    __construct()：类的构造函数
    __desctruct()：类的析构函数
    __get()：尝试访问一个不存在的属性时会被调用
    __set()：尝试修改一个不可访问的属性时会被调用
    __isset()：在对一个不可访问的属性调用isset()方法时会被调用
    __unset()：在调用unset()函数销毁一个不能访问的属性时会被调用
    __toString()：将对象当做字符串一样使用时会被调用
    __set_state()：使用var_export()函数输出对象时会调用该方法
    __clone()：当对象复制完成时调用
    __sleep()：在对一个对象序列化时（调用serialize()）会被调用
    __wakeup()：在对存储的对象反序列化时会被调用
    __call()：在调用不存在或不可访问的方法时会被调用
    __callStatic()：在调用不存在或不可访问的静态方法时会被调用
    __invoke()：尝试将对象作为函数使用时会被调用
    __autoload()：尝试加载未定义的类
    __debugInfo()，打印所需调试信息
    */

    /*
    class Device {
        public $name;           
        public $battery;        
        public $data = array(); 
        public $connection;   

        public function  __construct(Battery $battery, $name) {
            $this->battery = $battery;
            $this->name = $name;
            $this->connect();
        }

        public function  __get($name) {
            if(array_key_exists($name, $this->data)) {
                return $this->data[$name];
            }
            return null;
        }

        public function  __set($name, $value) {
            // use the property name as the array key
            $this->data[$name] = $value;
        }

        public function  __isset($name) {
            return array_key_exists($name, $this->data);
        }

        public function  __toString() {
            $connected = (isset($this->connection)) ? 'connected' : 'disconnected';
            $count = count($this->data);
            return $this->name . ' is ' . $connected . ' with ' . $count . ' items in memory' . PHP_EOL;
        }

        public static function  __set_state(array $array) {
            $obj = new self();
            $obj->setCharge($array['charge']);
            return $obj;
        }

        public function  __clone() {
            // copy our Battery object
            $this->battery = clone $this->battery;
        }

        public function  __sleep() {
            return array('name', 'battery', 'data');
        }

        public function  __wakeup() {
            // reconnect to the network
            $this->connect();
        }

        public function  __call($name, $arguments) {
            // make sure our child object has this method
            if(method_exists($this->connection, $name)) {
                // forward the call to our child object
                return call_user_func_array(array($this->connection, $name), $arguments);
            }
            return null;
        }

        public static function  __callStatic($name, $arguments) {
            // make sure our class has this method
            if(method_exists('Connection', $name)) {
                // forward the static call to our class
                return call_user_func_array(array('Connection', $name), $arguments);
            }
            return null;
        }

        public function __invoke($data) {
            echo $data;
        }  
 
        protected function connect() {
            $this->connection = 'resource';
            echo $this->name . ' connected' . PHP_EOL;
        }
 
        protected function disconnect() {
            $this->connection = null;
            echo $this->name . ' disconnected' . PHP_EOL;
        }
    }
 
    class Battery {
        private $charge = 0;

        public function  __get($name) {
            if(isset($this->$name)) {
                return $this->$name;
            }
            return null;
        }

        public function setCharge($charge) {
            $charge = (int)$charge;
            if($charge < 0) {
            $charge = 0;
            }
            elseif($charge > 100) {
                $charge = 100;
            }
            $this->charge = $charge;
        }
    }

    $device = new Device(new Battery(), 'iMagic');
    $device2 = clone $device;
 
    $device->battery->setCharge(65);
    echo $device2->battery->charge;
    // 65

    $device('test');
    // equiv to $device->__invoke('test')
    // Outputs: test
    */
    }

    // -Q2：PHP加载文件有哪几种方式？请分别列举，且编写代码Demo说明。

    // -Q3：请编写函数，分别模拟实现Http请求（POST请求，GET请求）。
    // 通过curl get数据
    public static function curl_get($url, $cookie, $header = array(), $timedout = 1){
        $curl = curl_init();//初始化
        $header =  array();
        curl_setopt($curl, CURLOPT_URL , $url);
        curl_setopt($curl , CURLOPT_RETURNTRANSFER , 1);
        curl_setopt($curl,CURLOPT_HTTPHEADER,$header); // 模拟的header头
        curl_setopt($curl, CURLOPT_CONNECTTIMEOUT, $timedout);
        curl_setopt($curl, CURLOPT_TIMEOUT, $timedout); 
        curl_setopt($curl , CURLOPT_COOKIE , $cookie);
        $result = curl_exec($curl);//执行并获取返回数据
        curl_close($curl);//释放
        $ret = json_decode($result,true);
        return $ret;
    }

    // 通过curl post数据
    public static function curl_post($url, $post_data = array(), $cookie='', $header = array(), $timedout = 1) {
        $post_string = is_array($post_data)?http_build_query($post_data):$post_data;
        $curl = curl_init();
        curl_setopt($curl, CURLOPT_POST, true);
        curl_setopt($curl, CURLOPT_POSTFIELDS, $post_string);
        curl_setopt($curl, CURLOPT_URL, $url);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($curl, CURLOPT_CONNECTTIMEOUT, $timedout);
        curl_setopt($curl, CURLOPT_TIMEOUT, $timedout);
        curl_setopt($curl, CURLOPT_HTTPHEADER, $header); // 模拟的header头
        //设置连接结束后保存cookie信息的文件
        curl_setopt($curl , CURLOPT_COOKIE , $cookie);
        $result = curl_exec($curl);
        curl_close($curl);
        $ret = json_decode($result,true);//返回的格式json串解码
        return $ret;
    }

    // -Q4：cookie于session的区别？
    /*
    cookie概念：Cookie实际上是一小段的文本信息。客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。客户端会把Cookie保存起来。cookie的内容主要包括：名字，值，过期时间，路径和域。路径与域一起构成cookie的作用范围。
    session概念：Session是另一种记录客户状态的机制，不同的是Cookie保存在客户端浏览器中，而Session保存在服务器上。客户端浏览器访问服务器的时候，服务器把客户端信息以某种形式记录在服务器上。这就是Session。客户端浏览器再次访问时只需要从该Session中查找该客户的状态就可以了。每个用户访问服务器都会建立一个session，那服务器是怎么标识用户的唯一身份呢？事实上，用户与服务器建立连接的同时，服务器会自动为其分配一个SessionId。
    区别：
    1、cookie数据存放在客户的浏览器上，session数据放在服务器上；
    2、cookie不是很安全，别人可以分析存放在本地的COOKIE并进行COOKIE欺骗考虑到安全应当使用session；
    3、session会在一定时间内保存在服务器上。当访问增多，会比较占用你服务器的性能考虑到减轻服务器性能方面，应当使用COOKIE；
    4、单个cookie保存的数据不能超过4K，很多浏览器都限制一个站点最多保存20个cookie。(Session对象没有对存储的数据量的限制，其中可以保存更为复杂的数据类型)
    */

    //-Q5：php自动加载有那几种方法， __autoload()自动加载的缺陷？
    
}








