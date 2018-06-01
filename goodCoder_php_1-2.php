<?php

//**********Q1：请解释 == 与 ===的区别，且编写代码Demo说明。**********

function equal_diff(){
    $a = 10;
    $b = '10';
    $c = 3;
    $d = 3.0;
    $e = false;
    $g = 0;
    $arr1 = array(0 => 'one',1 => 'two');
    $arr2 = array(1 => 'two',0 => 'one');
    //var_dump返回表达式的类型与值而print_r仅返回结果，相比调试代码使用var_dump更便于阅读。
    var_dump ($a==$b).PHP_EOL; //true
    var_dump ($a===$b).PHP_EOL; //false

    var_dump($a==$e).PHP_EOL; //ture
    var_dump($a===$e).PHP_EOL; //false

    var_dump($c==$d).PHP_EOL; //ture
    var_dump($c===$d).PHP_EOL; //false

    var_dump($arr1==$arr2).PHP_EOL; //true
    var_dump($arr1===$arr2).PHP_EOL; //false

//重要bool值对比
    var_dump ($e==$g).PHP_EOL; //true
    var_dump ($e===$g).PHP_EOL; //false

}

//equal_diff();

//*****Q2:  echo(),print(),print_r()的区别，且编写代码Demo说明。******
//echo(): 可以一次输出多个值，多个值之间用逗号分隔。echo不是一个函数，它是一种语言结构，因此你不一定要使用小括号来指名参数，单引号、双引号都可以。echo也不能作为表达式的一部分使用。
//print(): 同echo类似，它不是一个函数，它是一种语言结构；区别是print一次只能输出一个变量
//print_r(): 函数，只能打印数值、字符串；可以打印数组，但不会打印数组里的元素类型
//var_dump():函数，可以打印任意类型的变量；可以打印数组，会返回元素值、类型、长度。

function printdiff(){
    $test1 = "Hello";
    $test2 = array("wangning","world");
    $test3 = array('0',189,8.11,"Hello World",True);
    echo '使用',"echo","输出：",$test1." ".$test2[0].PHP_EOL."<br>";
    //print '使用',"print","输出：",$test1." ".$test2.PHP_EOL; //php-error
    print '使用'."print"."输出：".$test1." ".$test2[1].PHP_EOL."<br>";//最多只能打印一个，所以只能拼接。
    print_r($test3).PHP_EOL."<br>";
    echo "<br>";
    var_dump($test3).PHP_EOL."<br>";
    echo "<br>";

}
printdiff();

//******Q3：请写出如下程序的输出结果。*******
$test = 'aaaaaa';
$abc = &$test;
unset($test);
echo $abc;//'aaaaaa'
//&是地址引用，res1和tes引用内容相同。
$tes = 10;
$res1 = &$tes;
$tes+=10;
echo $tes;//20
echo $res1;//20

$count = 5;//全局变量
function get_count(){
    static $count = 0;//静态变量。局部变量
    return $count++;
}
echo $count;//5
++$count;
echo get_count();//0
echo get_count();//1

function variableType(){
    echo "---------------------isset()-------------------"."\n";
    echo "<br>";
    //isset()：判断变量是否存在，如果变量不存在，或者存在并指向null，则返回false；对数组元素的判断同样有效
    $type1 = "ning";
    $type2 = "wang";
    var_dump(isset($type1)).PHP_EOL;      // TRUE
    var_dump(isset($type1, $type2)).PHP_EOL; // TRUE
    unset ($type1);
    var_dump(isset($type1));     // FALSE
    var_dump(isset($type1, $type2)); // FALSE
    $foo = NULL;
    var_dump(isset($foo));   // FALSE
    $arrtype = array(NULL);
    //指向空。
    var_dump(isset($arrtype[0])).PHP_EOL."<br>";
    echo "<br>";


    echo "---------------------empty()-------------------"."\n";
    echo "<br>";
    //empty()：判断一个变量是否为空。当变量存在，并且是一个非空非零的值时返回false否则返回true。以下的值被认为是空。
    $var1 = "";
    $var2 = 0;
    $var3 = 0.0;
    $var4 = null;
    $var5 = false;
    $var6 = array();
    $var7;
    $var8 = "ning";
    var_dump(empty($var1)).PHP_EOL;  //true
    var_dump(empty($var2)).PHP_EOL;  //true
    var_dump(empty($var3)).PHP_EOL;  //true
    var_dump(empty($var4)).PHP_EOL;  //true
    var_dump(empty($var5)).PHP_EOL;  //true
    var_dump(empty($var6)).PHP_EOL;  //true
    var_dump(empty($var7)).PHP_EOL;  //ture
    var_dump(empty($var8)).PHP_EOL;  //flase

    echo "<br>";
    echo "---------------------boolvar()-------------------"."\n";
    echo "<br>";


    //boolvar()：获取变量的布尔值，0，null，空数组，空字符串都返回false，其他返回true
    echo "<br>";

    echo "---------------------intval()-------------------"."\n";
    //intval()：获取变量的整数值。通过使用的指定进制base转换（默认十进制），返回变量var的integer数值。如果base是0，则通过检测变量的格式来决定使用的进制。“0x”前缀：16进制，“0”前缀：8进制，否则：10进制
    echo intval(42)."\n";                      // 42
    echo intval(9.3)."\n";                     // 9
    echo "<br>";
    echo "---------------------0|null|false-------------------"."\n";
    echo "<br>";
    //php中,空字符串、null、false都是以值为0存储的，空字符串的类型是string，null类型是null，false类型是boolean
    $n1 = 0;
    $n2 = null;
    $n3 = false;
    $n4 = "";
    if (!$n1){
        print "ning";
    } //true
    //以下类似
//    var_dump($n1 === fasle)."\n";	  //false
//    var_dump($n1 == null)."\n";	  //true
//    var_dump($n2 == fasle)."\n";	  //false
//    var_dump($n2 === fasle)."\n";	  //false
//    var_dump($n2 == null)."\n";	  //true
//    var_dump($n3 == fasle)."\n";	  //false
//    var_dump($n3 === fasle)."\n";	  //false
//    var_dump($n3 == null)."\n";	  //true
//    var_dump($n4 == fasle)."\n";	  //false
//    var_dump($n4 === fasle)."\n";	  //false
//    var_dump($n4 == null)."\n";	  //true
}
variableType();