<?php

class learn78 {

    // -Q1：请尽可能多的列举魔术方法，且编写代码说明其用法。
    public function magic_Function(){
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

    //有4个文件加载语句：include，require，include_once，require_once。
    //require函数通常放在 PHP 程序的最前面，PHP 程序在执行前，就会先读入 require 所指定引入的文件，使它变成 PHP 程序网页的一部份。
    //include函数一般放在流程控制的处理部分中。PHP程序网页在读到 include的文件时，才将它读进来。这种方式，可以把程序执行时的流程简单化。
    //include有返回值，而require没有。
    //“require”的工作方式是为了让PHP程序得到更高的效率，当它在同一个PHP网页中解释过一次后，第二次出现便不会再解释，这是它的优点。
    //不过严格来说，这也是它的唯一的缺点，因为它不会重复解释引入的文件，所以当PHP网页中使用循环或条件语句来引入文件时，“require”则不会做任何的改变。
    //当有类似这样的情形时，就必须使用“include”命令来引入 文件了。
    //当PHP遇到一个利用“include”方式引入的文件，它就会解释一次；遇到第二次时，PHP还是会重新解释一次。与“require”相比，“include”的执行效率则会下
    //降许多；而且当引入文件中包含了用户自定义的函数时，PHP在解释的过程中会发生函数重复定义的问题。不过“include”也不是没有优点的，因为在PHP网页中，
    //它会每遇到一次“include”命令就会重复解释一次，所以非常适合使用在循环或条件判断的语句里。
    //“include_once()”函数和“require_once()” 函数，会先检查目标档案的内容是不是在之前就已经导入过了，如果是，便不会再次重复导入同样的内容。
    //他们可以载入 php 或 html 文件。

    public function file_load_function(){
        $ret1 = include "./php-test";
        $ret2 = require "./test1.php";
        return [$ret1,$ret2];

    }

// -Q3：请编写函数，分别模拟实现Http请求（POST请求，GET请求）。
    public function simulation_get($_url){

        $html = file_get_contents($_url);
        return $html;

    }
    //post 待完善。
    public function simulation_post($url,$param){
        if (empty($url) || empty($param)) {
            return false;
        }

        $postUrl = $url;
        $curlPost = $param;
        $ch = curl_init();//初始化curl
        curl_setopt($ch, CURLOPT_URL,$postUrl);//抓取指定网页
        curl_setopt($ch, CURLOPT_HEADER, 0);//设置header
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);//要求结果为字符串且输出到屏幕上
        curl_setopt($ch, CURLOPT_POST, 1);//post提交方式
        curl_setopt($ch, CURLOPT_POSTFIELDS, $curlPost);
        $data = curl_exec($ch);//运行curl
        curl_close($ch);

        return $data;
    }

//    // -Q4：cookie于session的区别？
//    /*
//    cookie概念：Cookie实际上是一小段的文本信息。客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。客户端会把Cookie保存起来。cookie的内容主要包括：名字，值，过期时间，路径和域。路径与域一起构成cookie的作用范围。
//    session概念：Session是另一种记录客户状态的机制，不同的是Cookie保存在客户端浏览器中，而Session保存在服务器上。客户端浏览器访问服务器的时候，服务器把客户端信息以某种形式记录在服务器上。这就是Session。客户端浏览器再次访问时只需要从该Session中查找该客户的状态就可以了。每个用户访问服务器都会建立一个session，那服务器是怎么标识用户的唯一身份呢？事实上，用户与服务器建立连接的同时，服务器会自动为其分配一个SessionId。
//    区别：
//    1、cookie数据存放在客户的浏览器上，session数据放在服务器上；
//    2、cookie不是很安全，别人可以分析存放在本地的COOKIE并进行COOKIE欺骗考虑到安全应当使用session；
//    3、session会在一定时间内保存在服务器上。当访问增多，会比较占用你服务器的性能考虑到减轻服务器性能方面，应当使用COOKIE；
//    4、单个cookie保存的数据不能超过4K，很多浏览器都限制一个站点最多保存20个cookie。(Session对象没有对存储的数据量的限制，其中可以保存更为复杂的数据类型)
//    */
//
//    //-Q5：php自动加载有那几种方法， __autoload()自动加载的缺陷？

      //_autoload和spl_autoload_register
//



}

//------------------Q2debug---------------------

$ning = new learn78();

$result = $ning->file_load_function();
echo "<br>";
//------------------Q3debug---------------------

//echo $ning->simulation_get("http://www.baidu.com");

//echo $ning->simulation_post("http://www.baidu.com","");




