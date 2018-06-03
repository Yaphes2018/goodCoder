<?php
//--------------------Q1php常见魔术方法-----------------------
class Q1_debug{
    //构造方法与析构方法__desctruct.
    public  $data = array();
    private $local = "beijing";
    public function __construct($par1,$par2)
    {
       $this->name = $par1;
        $this->age = $par2;
    }


    /*__call() 方法的作用：为了避免当调用的方法不存在时产生错误，而意外的导致程序中止，
    可以使用 __call() 方法来避免。该方法在调用的方法不存在时会自动调用，程序仍会继续执行下去。
    该方法有两个参数，第一个参数 $function_name 会自动接收不存在的方法名，第二个 $arguments
    则以数组的方式接收不存在方法的多个参数。*/
    public function __call($name, $arguments)
    {
        echo "你所调用的函数：" . $name . "(参数：" ; // 输出调用不存在的方法名
        print_r($arguments); // 输出调用不存在的方法时的参数列表
        echo ")不存在！<br>\n"; // 结束换行
    }


    /*在 php 面向对象编程中，类的成员属性被设定为 private 后，如果我们试图在外面调用它则会
    出现“不能访问某个私有属性”的错误。那么为了解决这个问题，我们可以使用魔术方法 __get()。
    魔术方法__get()的作用在程序运行过程中，通过它可以在对象的外部获取私有成员属性的值。*/
    public function __get($name)
    {
        return $this->name;
    }

    /*__set() 的作用：__set( $property, $value )` 方法用来设置私有属性， 给一个未定义
    的属性赋值时，此方法会被触发，传递的参数是被设置的属性名和值。*/
    public function __set($name, $value)
    {
        if ($name == "school");
        $this->$name = "beijingjiaotong";
    }

}

//--------------------Q1debug------------------
//__constract&&__get()
$persion = new Q1_debug("ning",12);

//__call()
echo $persion->reshen();
//__get()
echo $persion->local;
echo "<br>";
//__set()

$persion->school = "123";

echo $persion->school;
echo "<br>";



class learn78 {
    // -Q2：PHP加载文件有哪几种方式？请分别列举，且编写代码Demo说明。

    /*有4个文件加载语句：include，require，include_once，require_once。
    require函数通常放在 PHP 程序的最前面，PHP 程序在执行前，就会先读入 require 所指定引入的文件，使它变成 PHP 程序网页的一部份。
    include函数一般放在流程控制的处理部分中。PHP程序网页在读到 include的文件时，才将它读进来。这种方式，可以把程序执行时的流程简单化。
    include有返回值，而require没有。
    “require”的工作方式是为了让PHP程序得到更高的效率，当它在同一个PHP网页中解释过一次后，第二次出现便不会再解释，这是它的优点。
    不过严格来说，这也是它的唯一的缺点，因为它不会重复解释引入的文件，所以当PHP网页中使用循环或条件语句来引入文件时，“require”则不会做任何的改变。
    当有类似这样的情形时，就必须使用“include”命令来引入 文件了。
    当PHP遇到一个利用“include”方式引入的文件，它就会解释一次；遇到第二次时，PHP还是会重新解释一次。与“require”相比，“include”的执行效率则会下
    降许多；而且当引入文件中包含了用户自定义的函数时，PHP在解释的过程中会发生函数重复定义的问题。不过“include”也不是没有优点的，因为在PHP网页中，
    它会每遇到一次“include”命令就会重复解释一次，所以非常适合使用在循环或条件判断的语句里。
    “include_once()”函数和“require_once()” 函数，会先检查目标档案的内容是不是在之前就已经导入过了，如果是，便不会再次重复导入同样的内容。
    他们可以载入 php 或 html 文件。*/

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
    //post。
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
}

//------------------Q2debug---------------------

$ning = new learn78();

$result = $ning->file_load_function();
echo "<br>";
//------------------Q3debug---------------------

//echo $ning->simulation_get("http://www.baidu.com");

//echo $ning->simulation_post("http://www.baidu.com","");

//------------------Q4：cookie于session的区别？---
/*
cookie概念：Cookie实际上是一小段的文本信息。客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。客户端会把Cookie保存起来。cookie的内容主要包括：名字，值，过期时间，路径和域。路径与域一起构成cookie的作用范围。
session概念：Session是另一种记录客户状态的机制，不同的是Cookie保存在客户端浏览器中，而Session保存在服务器上。客户端浏览器访问服务器的时候，服务器把客户端信息以某种形式记录在服务器上。这就是Session。客户端浏览器再次访问时只需要从该Session中查找该客户的状态就可以了。每个用户访问服务器都会建立一个session，那服务器是怎么标识用户的唯一身份呢？事实上，用户与服务器建立连接的同时，服务器会自动为其分配一个SessionId。
区别：
    1、cookie数据存放在客户的浏览器上，session数据放在服务器上；
    2、cookie不是很安全，别人可以分析存放在本地的COOKIE并进行COOKIE欺骗考虑到安全应当使用session；
    3、session会在一定时间内保存在服务器上。当访问增多，会比较占用你服务器的性能考虑到减轻服务器性能方面，应当使用COOKIE；
    4、单个cookie保存的数据不能超过4K，很多浏览器都限制一个站点最多保存20个cookie。(Session对象没有对存储的数据量的限制，其中可以保存更为复杂的数据类型)
*/

//-------------------Q5：php自动加载有那几种方法， __autoload()自动加载的缺陷？
//__autoload()机制缺点：无法有多个autoload方法


//第一种方式
function __autoload($classname){
    $fileName = $classname.".php";
    if (file_exists($fileName)) {
        require_once("$fileName");
    } else {
        echo $fileName." doesn't exist!";
        }
}

$test_load = new auto_test();//自动加载类auto_test()


//第二种方式。自定义方法；
function loader($class){
    $file = $class . '.php';
    if (is_file($file)) {
        require_once ($file);
    }
}
spl_autoload_register('loader');//注册一个自定义加载方法。





