<?php
/**
 * @author: liuchang05@iwaimai.baidu.com
 * @desc: GoodCoderPHP 03-04 Q1-Q5
 * @date: 2017/12/16 18:22
 */
Bd_Init::init();



class PricticeTwo{

    //-Q1：请写一个函数，尽可能高效的，从一个标准 url里取出文件的扩展名。如：http://www.baidu.com/abc/de/fg.php?id=1，需要取出php或.php。
    public function getExtension($file){
        $arrExtension = preg_match("/(\.(\w+)\?)|(\.(\w+)$)/",$file,$str);
        if(isset($str[0]) && !empty($str[0])) {
            $split = preg_split("/\?/",$str[0]);
            return $split[0];
        }
        else return false;
    }

    //-Q2：请打印斐波那契数列10个， 1，1，2，3，5……（递归、循环）。
    //F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
    public function recursion(){
        $arr = array();
        $arr[0] = 0;
        $arr[1] = 1;
        for($i=2; $i<=9; $i++){
            $arr[$i] = $arr[$i-1] + $arr[$i-2];
        }
        return $arr;
    }

    //-Q3：假设订单号生成规则：10位时间戳+4位毫秒+2位随机数。已知函数isExist($orderId)可以判断订单号是否已经存在,重复可重新生成。写一个生成订单号的函数createOrderId()。
    public function createOrderId(){
        $timeStamp = microtime(true);
        $timeStampArr = explode('.', $timeStamp);
        $rand = mt_rand(0,9).mt_rand(0,9);
        $orderId = $timeStampArr[0].$timeStampArr[1].$rand;
//      if(isExist($orderId)){
//          $this->createOrderId();
//      }
//      else return $orderId;
        return $orderId;
    }

    //-Q4：PHP实现类继承：要求有基类普通订单，包含属性订单类型(orderType)、方法打印订单信息(打印类型-单号)、Q3所述方法，子类有外卖订单，商超订单，质享订单，并覆盖基类属性、方法。要求正确使用abstract、final。
    /*

    //订单基类：
    abstract class Order{
        abstract $orderType;
        public $orderId;
        abstract function printOrder($orderType,$orderId){
            //打印订单信息（类型-单号）
            echo $orderType.'--'.$orderId;
        }
        final function createOrderId(){
            $timeStamp = microtime(true);
            $timeStampArr = explode('.', $timeStamp);
            $rand = mt_rand(0,9).mt_rand(0,9);
            $orderId = $timeStampArr[0].$timeStampArr[1].$rand;
            if(isExist($orderId)){
                $this->createOrderId();
            }
            else return $orderId;    
        }
    }

    //外卖订单：
    public class dishOrder extends Order{
        $orderType = 0;
        $orderTypeName = 'DishOrder';
        public function printOrder($orderType,$orderId){
            //打印外卖订单信息（订单类型名称--型号--单号）
            echo $orderTypeName.'--'.$orderType.'--'.$orderId;
        }  
    }

    //商超订单：
    public class commodityOrder extends Order{
        $orderType = 1;
        $orderTypeName = 'Commodity';
        public function printOrder($orderType,$orderId){
            //打印商超订单信息（订单类型名称--型号--单号）
            echo $orderTypeName.'--'.$orderType.'--'.$orderId;
        }  
    }

    //质享订单：
    public class zhixiangOrder extends Order{
        $orderType = 2;
        $orderTypeName = 'Zhixiang';
        public function printOrder($orderType,$orderId){
            //打印质享订单信息（订单类型名称--型号--单号）
            echo $orderTypeName.'--'.$orderType.'--'.$orderId;
        }  
    }

    */

    //-Q5：请自己写一个函数，实现字符串的反转。
    public function reverse($str){
        $revStr = "";
        if(isset($str) && !empty($str)){
            for($i=0;$i<strlen($str);$i++){
                $revStr = $str[$i].$revStr;
            }
            return $revStr;
        }
        else return false;
    }
}

$file = "http://www.baidu.com/abc/de/fg.php?id=1";
$str = "zifuchuanfanzhuan";
$pricticeTwo = new PricticeTwo();
$pricticeTwo -> getExtension($file);
$pricticeTwo -> recursion();
$pricticeTwo -> createOrderId();
$pricticeTwo -> reverse($str);



