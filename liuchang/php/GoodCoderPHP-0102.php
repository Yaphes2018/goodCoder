<?php
/**
 * @author: liuchang05@iwaimai.baidu.com
 * @desc: GoodCoderPHP 01-02 Q1-Q5
 * @date: 2017/12/16 16:03
 */
Bd_Init::init();
class PricticeOne {

	//-Q1：请解释 == 与 ===的区别，且编写代码Demo说明。
	public function equal(){
	    //== 比较运算符，只比较值是否相等，不会比较条件表达式的类型
	    //=== 恒等运算符，即会比较值，也会比较类型
	    $a = 0;
	    $b = '0';
	    $c = 8;
        $d = 8.0;
        $e = false;
        $arr1 = array(0 => 'one',1 => 'two');
        $arr2 = array(1 => 'two',0 => 'one');
	    var_dump ($a==$b).PHP_EOL; //true
	    var_dump ($a===$b).PHP_EOL; //false
	    var_dump($a==$e).PHP_EOL; //ture
	    var_dump($a===$e).PHP_EOL; //false
	    var_dump($c==$d).PHP_EOL; //ture
	    var_dump($c===$d).PHP_EOL; //false
	    var_dump($arr1==$arr2).PHP_EOL; //true
        var_dump($arr1===$arr2).PHP_EOL; //false   
	}

	//-Q2：echo(),print(),print_r()的区别，且编写代码Demo说明。
	public function print(){
	    //echo(): 可以一次输出多个值，多个值之间用逗号分隔。echo不是一个函数，它是一种语言结构，因此你不一定要使用小括号来指名参数，单引号、双引号都可以。echo也不能作为表达式的一部分使用。
	    //print(): 同echo类似，它不是一个函数，它是一种语言结构；区别是print一次只能输出一个变量
	    //print_r(): 函数，只能打印数值、字符串；可以打印数组，但不会打印数组里的元素类型
	    //var_dump():函数，可以打印任意类型的变量；可以打印数组，会返回元素值、类型、长度，因为打印信息较多，因此调试时较长使用
	    //注意：ap框架中不允许使用以上语言和函数直接输出，会报错，还是要打印到日志中查看Bd_Log::warning('打印变量：'.var_export($test3,true));
        $test1 = "Hello";
        $test2 = array("World");
        $test3 = array('0',0,false,8.11,"Hello World");
	    echo '使用',"echo","输出：",$test1." ".$test2.PHP_EOL; //使用echo输出：Hello Array 
	    //print '使用',"print","输出：",$test1." ".$test2.PHP_EOL; //php-error
	    print '使用'."print"."输出：".$test1." ".$test2.PHP_EOL; //使用print输出：Hello Array
	    print_r($test3).PHP_EOL;
        /* Array
           (
             [0] => 0
             [1] => 0
             [2] =>
             [3] => 8.11
             [4] => Hello World
          )
        */	    
	    var_dump($test3).PHP_EOL;
	    /* array(5) {
           [0]=>
           string(1) "0"
           [1]=>
           int(0)
           [2]=>
           bool(false)
           [3]=>
           float(8.11)
           [4]=>
           string(11) "Hello World"
           }
        */
	}

	/*
	 -Q3：请写出如下程序的输出结果。
     请写出如下程序的输出结果。
     <?php
     $test = 'aaaaaa';
     $abc = &$test;
     unset($test);
     echo $abc;
     ?>
    */
    public function unsetVariable(){
        $test = 'aaaaaa';
        $abc = &$test;
        unset($test);
        echo $abc.PHP_EOL;
        //输出：aaaaaa。定义变量$test后，会给该变量在内存中分配一块空间存储'aaaaaa'，$test变量指向该内存空间。$abc = &$test；将$test指向'aaaaaa'的地址赋给$abc，使变量$abc也指向'aaaaaa'。unset($test)只是删除$test和'aaaaaa'的引用关系和$test变量，但是这块内存空间还在，因此仍然会输出'aaaaaa'
    }
        

    /*
     -Q4：请写出如下程序的输出结果。
     <?php 
     $count = 5; 
     function get_count(){ 
     static $count = 0; 
     return $count++; 
     } 
     echo $count; 
     ++$count; 
     echo get_count(); 
     echo get_count(); 
    ?>
    */
    public $count = 5;
    public function get_count(){
    	static $count = 0;
    	return $count++;
    }
    public function staticVariable(){
    	echo $this->count.PHP_EOL;    //输出5 输出全局变量
    	++$this->count;               //全局变量+1，变为6
    	echo $this->get_count().PHP_EOL;  //输出静态局部变量0，然后静态变量+1
    	echo $this->get_count().PHP_EOL;  //输出静态局部变量1
    }

    //-Q5：isset($val), empty($val)，boolval($val), intval($val) $val == false , $val === false, $val == null 的区别，且编写代码Demo说明。
	public function variableType(){
		echo "---------------------isset()-------------------"."\n";
	//isset()：判断变量是否存在，如果变量不存在，或者存在并指向null，则返回false；对数组元素的判断同样有效
		$type1 = "test";
        $type2 = "anothertest";
        var_dump(isset($type1)).PHP_EOL;      // TRUE
        var_dump(isset($type1, $type2)).PHP_EOL; // TRUE
        unset ($type1);
        var_dump(isset($type1));     // FALSE
        var_dump(isset($type1, $type2)); // FALSE

        $foo = NULL;
        var_dump(isset($foo));   // FALSE

        $arrtype = array('Hello',NULL,123);
        var_dump(isset($arrtype[1])).PHP_EOL;

        echo "---------------------empty()-------------------"."\n";
    /*empty()：判断一个变量是否为空。当变量存在，并且是一个非空非零的值时返回false否则返回true。以下的值被认为是空的
    * "" (空字符串)
    * 0 (作为整数的0)
    * 0.0 (作为浮点数的0)
    * "0" (作为字符串的0)
    * NULL
    * FALSE
    * array() (一个空数组)
    * $var; (一个声明了，但是没有值的变量)
    */
        $e1 = "";
        $e2 = 0;
        $e3 = 0.0;
        $e4 = null;
        $e5 = false;
        $e6 = array();
        $e7;
        var_dump(empty($e1)).PHP_EOL;  //true
        var_dump(empty($e2)).PHP_EOL;  //true
        var_dump(empty($e3)).PHP_EOL;  //true
        var_dump(empty($e4)).PHP_EOL;  //true
        var_dump(empty($e5)).PHP_EOL;  //true
        var_dump(empty($e6)).PHP_EOL;  //true
        var_dump(empty($e7)).PHP_EOL;  //true

        echo "---------------------boolvar()-------------------"."\n";
    //boolvar()：获取变量的布尔值，0，null，空数组，空字符串都返回false，其他返回true
        echo '0:        '.(boolval(0) ? 'true' : 'false')."\n";          //false
        echo '42:       '.(boolval(42) ? 'true' : 'false')."\n";         //true
        echo '0.0:      '.(boolval(0.0) ? 'true' : 'false')."\n";        //false
        echo '4.2:      '.(boolval(4.2) ? 'true' : 'false')."\n";		//true
        echo '"":       '.(boolval("") ? 'true' : 'false')."\n";		    //fasle
        echo '"string": '.(boolval("string") ? 'true' : 'false')."\n";	//true
        echo '"0":      '.(boolval("0") ? 'true' : 'false')."\n";		//fasle
        echo '"1":      '.(boolval("1") ? 'true' : 'false')."\n";		//true
        echo '[1, 2]:   '.(boolval([1, 2]) ? 'true' : 'false')."\n";		//true
        echo '[]:       '.(boolval([]) ? 'true' : 'false')."\n";			//false
        echo 'stdClass: '.(boolval(new stdClass) ? 'true' : 'false')."\n";	//true

        echo "---------------------intval()-------------------"."\n";
    //intval()：获取变量的整数值。通过使用的指定进制base转换（默认十进制），返回变量var的integer数值。如果base是0，则通过检测变量的格式来决定使用的进制。“0x”前缀：16进制，“0”前缀：8进制，否则：10进制
        echo intval(42)."\n";                      // 42
		echo intval(4.2)."\n";                     // 4
		echo intval('42')."\n";                    // 42
		echo intval('+42')."\n";                   // 42
		echo intval('-42')."\n";                   // -42
		echo intval(042)."\n";                     // 34
		echo intval('042')."\n";                   // 42
		echo intval(1e10)."\n";                    // 1410065408    实际输出：10000000000
		echo intval('1e10')."\n";                  // 1
		echo intval(0x1A)."\n";                    // 26
		echo intval(42000000)."\n";                // 42000000      
		echo intval(420000000000000000000)."\n";   // 0				实际输出：-4275113695319687168
		echo intval('420000000000000000000')."\n"; // 2147483647	实际输出：9223372036854775807
		echo intval(42, 8)."\n";                   // 42
		echo intval('42', 8)."\n";                 // 34
		echo intval(array())."\n";                 // 0
		echo intval(array('foo', 'bar'))."\n";     // 1

		echo "---------------------0|null|false-------------------"."\n";
		//php中变量是以C语言结构体存储的，空字符串、null、false都是以值为0存储的，空字符串的类型是string，null类型是null，false类型是boolean
		$em1 = 0;
		$em2 = null;
		$em3 = false;
		$em4 = "";
		var_dump($em1 == fasle)."\n";     //true
		var_dump($em1 === fasle)."\n";	  //false
		var_dump($em1 == null)."\n";	  //true
		var_dump($em2 == fasle)."\n";	  //false
		var_dump($em2 === fasle)."\n";	  //false
		var_dump($em2 == null)."\n";	  //true
		var_dump($em3 == fasle)."\n";	  //false
		var_dump($em3 === fasle)."\n";	  //false
		var_dump($em3 == null)."\n";	  //true
		var_dump($em4 == fasle)."\n";	  //false
		var_dump($em4 === fasle)."\n";	  //false
		var_dump($em4 == null)."\n";	  //true
	}

}

$priticeOne = new PricticeOne();
$priticeOne->equal();
$priticeOne->print();
$priticeOne->unsetVariable();
$priticeOne->staticVariable();
$priticeOne->variableType();
