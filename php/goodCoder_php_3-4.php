<?php

//3-4GoodCoder面向对象设计

class learn34
{

//Q1：请写一个函数，尽可能高效的，从一个标准 url里取出文件的扩展名。如：http://www.baidu.com/abc/de/fg.php?id=1，需要取出php或.php。
    public function get_php($obj_url)
    {
        //利用explode方法
        $array_num = count(explode("/", $obj_url));
        $obj_php_source = explode("/", $obj_url)[$array_num - 1];
        $obj_php = explode("?", explode(".", $obj_php_source)[1])[0];
        return $obj_php;
    }

//Q2：请打印斐波那契数列10个， 1，1，2，3，5……（递归、循环）。
    public function generate_Fibonacci_num_loop($count_num)
    {//循环方法
        $a = array(1, 1);
        for ($i = 0; $i < ($count_num - 2); $i++) {
            $a[$i + 2] = $a[$i + 1] + $a[$i];
        }
        return $a;
    }

    public function generate_Fibonacci_num_recursion($Fibonacci_arr)
    {
        return $Fibonacci_arr[count($Fibonacci_arr) - 1] + $Fibonacci_arr[count($Fibonacci_arr) - 2];
    }

    /*Q3：假设订单号生成规则：10位时间戳+4位毫秒+2位随机数。已知函数isExist($orderId)可以判断订单号
    是否已经存在,重复可重新生成。写一个生成订单号的函数createOrderId()。*/

    public function createOrderId()
    {
        $timeStamp = microtime(true);
        $timeStampArr = explode('.', $timeStamp);
        $rand = mt_rand(0, 9) . mt_rand(0, 9);
        $orderId = $timeStampArr[0] . $timeStampArr[1] . $rand;

//        if(isExist($orderId)){
//          $this->createOrderId();
//        }
//        else{
//            return $orderId;
//        }
        return $orderId;
    }


// -Q5：请自己写一个函数，实现字符串的反转。
    public function reverseFun($str_obj){
        $res = "";
        if ($str_obj && gettype($str_obj)==='string'){
            for ($i = 0; $i < strlen($str_obj); $i++) {
                $res = $str_obj[$i].$res;
            }
            return $res;
        }else{return "type is wrong or the string is empty";}

    }
}

//----------------Q1debug--------------------
$ning = new learn34();
$result = $ning->get_php("http://www.baidu.com/abc/de/fg.php?id=1");
if (!empty($result) && $result === "php") {
    echo "wow!,we find a " . $result . " in this url";
    echo "<br>";
}
else{
    echo "sorry we cannot find php~";
    echo "<br>";
}

//----------------Q2debug--------------------
//打印前五个数字,循环方式。
print_r($ning->generate_Fibonacci_num_loop(5));
echo "<br>";
//打印前五个数字，递归方式。
$count_num1 = 5;
$arr_num = array(1,1);
for($i = 0;$i<($count_num1-2);$i++){
    $arr_num[$i+2] = $ning->generate_Fibonacci_num_recursion($arr_num);
}
print_r($arr_num);
echo "<br>";

//----------------Q3debug--------------------
print_r($ning->createOrderId());
echo "<br>";
//----------------Q4debug--------------------



//----------------Q5debug--------------------
//$result_reverse = $ning->reverseFun('wangning');
$result_reverse = $ning->reverseFun(array(1,1));
print_r($result_reverse);
echo "<br>";