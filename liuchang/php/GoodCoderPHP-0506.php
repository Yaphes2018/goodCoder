<?php
/**
 * @author: liuchang05@iwaimai.baidu.com
 * @desc: GoodCoderPHP 03-04 Q1-Q5
 * @date: 2017/12/17 13:15
 */
Bd_Init::init();



class PricticeThree{

    /*-Q1：将下面的数组用一行拼装成一个字符串 i am qa ! day day up!
    <?php 
        $arr = array( 
        'I', 'AM', 'QA!', 'DAY', 'DAY', 'UP!' 
        ); 
    */
    public function combineStr($arr){
        if(isset($arr) && !empty($arr) && is_array($arr)){
            return strtolower(implode(' ',$arr));
        }
        else return false;
    }

    /*-Q2：请写出以下程序的输出结果。
    <?php 
        function get_arr_ref(&$arr){ unset($arr[0]); }
        function get_arr($arr){ unset($arr[0]); }
            $arr1 = array(1, 2); $arr2 = array(1, 2); 
            get_arr_ref($arr1); get_arr($arr2); 
            echo count($arr1); echo count($arr2); ?>
    */
    function get_arr_ref(&$arr){
        unset($arr[0]);
    }
    function get_arr($arr){
        unset($arr[0]);
    }
    public function result(){
        $arr1 = array(1,2);
        $arr2 = array(1,2);
        $this -> get_arr_ref($arr1);
        $this -> get_arr($arr2); 
        echo count($arr1).PHP_EOL;  //1 函数的传址调用，直接用变量的内存地址作为参数，因此会直接修改内存的值。
        echo count($arr2).PHP_EOL;  //2
    }

    //-Q3：请写一个函数遍历目录下的所有文件和文件夹。
    public function scanDir($dir){
        $files = array();
        if($handle = opendir($dir)){
            while(($file = readdir($handle)) !== false){
                if($file != '..' && $file != '.'){
                    if(is_dir($dir.'/'.$file)){
                        $files[$file] = scanDir($dir.'/'.$file);
                    } else {
                        $files[] = $file;
                    }
                }
            }
            closedir($handle);
            return $files;
        }
    }

    //-Q4：求数组中最大数的下标。
    public function mixIndex($arr){
        $index = 0;
        $max = $arr[0];
        if(isset($arr) && !empty($arr) && is_array($arr)){
            for($i=1; $i<count($arr); $i++){
                if(!is_numeric($arr[$i])){
                    return false;
                }
                if($arr[$i] > $max){
                    $max = $arr[$i];
                    $index = $i;
                }
            }
            return $index;          
        }
        else return false;
    }

    //-Q5：请写一个函数，将一个长度超过10 的数组最后5项直接截取，不改变顺序变为前5项，如{1,2,3,4,5,6,7,8,9,10}变为{6,7,8,9,10,1,2,3,4,5}。
    public function splitArr($arr){
        //不借助其他数组实现
        if(isset($arr) && !empty($arr) && is_array($arr)){
            if(count($arr)>10){
                //前5项和后五项替换
                for($i=0,$j=count($arr)-5 ;$j<count($arr); $i++,$j++){
                    $temp = $arr[$i];
                    $arr[$i] = $arr[$j];
                    $arr[$j] = $temp;
                }
                print_r($arr).PHP_EOL;
                //后五项反转
                for($i=count($arr)-5,$j=count($arr)-1; $i<$j; $i++,$j--){
                    $temp = $arr[$i];
                    $arr[$i] = $arr[$j];
                    $arr[$j] = $temp;
                }
                print_r($arr).PHP_EOL;
                //除前5项以外的部分反转
                for($i=5,$j=count($arr)-1; $i<$j; $i++,$j--){
                    $temp = $arr[$i];
                    $arr[$i] = $arr[$j];
                    $arr[$j] = $temp;
                }
                print_r($arr).PHP_EOL;
                return $arr;
            }
            return false;
        }
        return false;
    }

}

$arr = array('I', 'AM', 'QA!', 'DAY', 'DAY', 'UP!' );
$dir = "/home/map/odp_commodity/app/commodity/library";
$numArr = array(23,55,0,9,3,108,22);
$splitArr = array(1,2,3,4,5,6,7,8,9,10,11,12);
$pricticeThree = new PricticeThree();
$pricticeThree -> combineStr($arr);
$pricticeThree -> result();
$pricticeThree -> scanDir($dir);
$pricticeThree -> mixIndex($numArr);
$pricticeThree -> splitArr($splitArr);






