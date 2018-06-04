05-06
//Q1：创建一个函数，能接受两个参数：
//1)第一个参数为URL，即可下载的文件；第二个参数为目录，即下载后保存的位置；
//2)如果用户给的目录不存在，则提示用户是否创建；如果创建就继续执行，否则，函数返回一个55的错误值给调用脚本；
//3)如果给的目录存在，则下载文件；下载命令执行结束后测试文件下载成功与否；如果成功，则返回0给调用脚本，否则，返回56给调用脚本；
#/bin/bash
url=$1;
dir=$2;
echo $url;
echo $dir;
if [ ! -d "$dir" ];then
    read -p  "the dir is not exist,do you want to make a new dir auto named $dir,pleas enter Y or N" youranswer
    if [ $youranswer = "Y" ];then
        mkdir -p ./$dir
        cd ./$dir
        wget $url
        if [ $? -ne 0 ];then
            echo "56,can not download"
        else
        echo "0,successfully dowaload"
        fi
    else
    echo "55,sorry you choose no make a new $dir"
    fi
else
wget $url
        if [ $? -ne 0 ];then
            echo "56,can not download"
        else
        echo "0,successfully dowaload"
        fi
fi
//-Q2：写一个脚本，实现判断10.8.99.0/24网络里，当前在线的IP有哪些，能ping通则认为在线。
#/bin/bash
for ip in $(seq 1 255)
do
{
ping -c 1 10.19.16.$ip  > /dev/null 2>&1
if [ $? -eq 0 ]; then
	echo 10.19.16.$ip UP
else
	echo 10.19.16.$ip DOWN
fi
}

//-Q3：批量创建5个系统用户test01-test05并设置密码（密码为test后面跟3个随机字符），用户名和密码按行写入userinfo文件。


#/bin/bash
userlist=[]
temp='test'
for i in $(seq 1 5);do
    userlist[$i]=$temp$i
done
#echo ${userlist[4]}
for j in ${userlist[@]};do
    if [ -n $j ];then
        useradd $j;
        pwd=$(cat /dev/urandom | head -1|md5sum |head -c 3)
        echo $j$pwd | passwd --stdin $j
        echo $j $pwd >> userinfo
        echo "add a new user named $j,and passward has been changed!"
    else
        echo "failed to add a new user"
    fi
done



-Q4：在/home/map目录下通过随机小写5个字母加固定字符串test批量创建10个html文件，名称列如：abcdetest.html （使用for循环）。
#!/bin/bash
cd ~/
j=0
for i in {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};do
    b[$j]=$i
    let j++
done
var='test.html'
for j in $(seq 1 10);do
    file_name_part=''
    for k in $(seq 1 5);do
        n=$(echo $RANDOM%26|bc)
        m=${b[$n-1]}
        file_name_part=$file_name_part$m
    done
    touch $file_name_part$var
done

