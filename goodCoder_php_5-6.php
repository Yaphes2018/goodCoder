<?php
//-Q1：将下面的数组用一行拼装成一个字符串 i am qa ! day day up!

$arr = array(
    'I', 'AM', 'QA!', 'DAY', 'DAY', 'UP!'
);
class learn56{

    public function arr_joint($arr_obj){
        $ret = '';
        if (!empty($arr_obj)){
            for($i = 0;$i < count($arr_obj);$i++){
                $ret = $ret.' '.$arr_obj[$i];
            }
        }
        return $ret;
    }

//-Q2：unset用法demo
    public function get_arr_ref(&$arr){
//        unset($arr[0]);
//        unset($arr[1]);
        unset($arr);
    }
    public function get_arr($arr){
        unset($arr[0]);
    }

//-Q3：请写一个函数遍历目录下的所有文件和文件夹。
    public function traverse_dir($_dir)
    {
        $nv = [];
        if (!is_dir($_dir)) {
            return 'this is not a dir';
        } else{
            $nv = scandir($_dir);
        }

            for ($i = 0; $i < count($nv); $i++)
            {
                echo $nv[$i]."<br>";
            }

    }
//Q4：求数组中最大数的下标。
//方法一
    public function find_maxnumber_index($arr){
        $ret = 0;
        $max_num = $arr[0];
        for($i = 1;$i<count($arr);$i++){
            if($arr[$i]>$max_num){
                $ret = $i;
                $max_num = $arr[$i];
            }
        }
        return $ret;
    }
//方法二,利用arr_search方法。
    public function find_max_index($arr){

        return array_search(max($arr),$arr);

    }

//Q5：请写一个函数，将一个长度超过10 的数组最后5项直接截取，不改变顺序变为前5项，
//如{1,2,3,4,5,6,7,8,9,10}变为{6,7,8,9,10,1,2,3,4,5}。
    public function arr_reverse_joint($arr){
        $arr1 = [];
        if (count($arr)<10){
            return 'the length of array is not enough';
        }else{
            $arr1 = array_slice($arr,count($arr)-5,5);

             $ret = array_merge($arr1,array_slice($arr,0,count($arr)-5));
        }
        return $ret;
    }
}

// -----------------------------Q1debug----------------------

$res = new learn56();
echo $res->arr_joint($arr);
echo "<br>";

// -----------------------------Q2debug----------------------
$arr1 = array(1, 2);
$arr2 = array(1, 2);
$res->get_arr_ref($arr1);
$res->get_arr($arr2);
echo count($arr1)."<br>";
echo count($arr2)."<br>";

//如果在函数中 unset() 一个通过引用传递的变量，则只是局部变量被销毁，
//而在调用环境中的变量将保持调用 unset() 之前一样的值。PHP unset()
//函数是用来销毁变量的，但很多时候，这个函数只把变量给销毁了，内存中
//存放的该变量的值仍然没有销毁.

//-----------------------------Q3debug-----------------------
$res->traverse_dir('/Users/baidu/')."<br>";

//-----------------------------Q4debug-----------------------

echo $res->find_maxnumber_index(array(1,9,5,1,4))."<br>";
echo $res->find_max_index(array(1,3,5,1))."<br>";

//-----------------------------Q4debug-----------------------

$key = $res->arr_reverse_joint(array(1,2,3,4,5,6,7,8,9,10,11));
for ($i = 0;$i<count($key);$i++){
    echo $key[$i]."<br>";
}