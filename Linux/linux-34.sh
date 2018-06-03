//Q1：请使用一条指令，一次性创建多层目录，如：/home/map/test/a/b/c 。
      mkdir -p /home/map/test/a/b/c

//Q2：请查找odp_cater目录下所有.log文件中存在ERROR字段的log文件，输出具体log文件名称。

      grep -l "ERROR" ~/odp_cater/*.log

//Q3：请统计odp_cater模块中access log访问量最多的1个IP。

    awk '{print $1}' access_log | sort -n |uniq -c | sort -rn | head -n 1

//Q4：按进程内存大小，从大到小排列。
      ps -eo rss,pmem,pcpu,vsize,args |  sort -k 1 -r -n | less

      解析一下：
      ps 都知道，是linux,unix显示进程信息的, -e 是显示所有进程, -o是定制显示信息的格式
      rss: resident set size, 表示进程占用RAM(内存)的大小，单位是KB
      pmem: %M, 占用内存的百分比
      pcpu：%C，占用cpu的百分比
      vsize: 表示进程占用的虚拟内存的大小，KB
      args：进程名（command）
      sort命令对ps结果进行排序
      -k 1 :按第一个参数 rss进行排序
      -r：逆序
      -n：numeric，按数字来排序


//Q5：根据端口(如：8086)列出进程名称。
    A:lsof -i :8086
      or
      1.根据端口号查询进程
       netstat -tunlp|grep 8086

       根据port查看是哪个程序
      2.ps aux | grep pid

//Q1：请问vi/vim 有哪几种模式？不同模式之间如何切换。
    A1：Vi/vim的工作模式有三种：命令模式、输入模式、末行模式。
      在命令模式下输入a、A、i、I、o、O等命令之一可以进入输入模式，
      在输入模式下按Esc键回到命令模式；
      在命令模式下输入：进入末行模式，末行命令执行完后回到命令模式。

//Q2：请问vi/vim移动光标的方法指令(如：上下移一页，第一行和最后一行)。
    A:上:k nk:向上移动n行 9999k或gg可以移到第一行
      下:j nj:向下移动n行
      左:h nh:向左移动n列
      G: 移到最后一行
      右:l nl:向右移动n列
      $:移动光标到行尾 n$:移动到第n行的行尾
      0（Num）：移动光标到行首
      ^:移动光标到行首第一个非空字符上去

//Q3：请问vi/vim查找和替换的方法指令(如：向上向下查找字符串为"ERROR"的字符串，从第一行到最后一行查找ERROR的字符串且将其替换为error)。
    A：／ERROR
       ？ERROR
       :1,%s/ERROR/error/g  会找到整个文件中的每个匹配串。
       :1,%s/ERROR/error/gc 会找到整个文件中的每个匹配串,并且对每个匹配串提示是否进行替换.


//Q4：请问vi/vim删除、复制、粘贴的方法指令（如：删除一整行，复制光标所在一行，将已复制的内容粘贴到光标的上一行等）。
    A:删除： dd 一行 ndd 多行
      复制： yy 一行 nyy 多行
      粘贴： yy P 复制粘贴到上一行，p复制粘贴到下一行

    y（d）1G：复制(删除)光标所在行到第一行的所有数据
    y（d）G：复制(删除)光标所在行到最后一行的所有数据
    y（d）0：复制(删除)光标所在的那个字符到改行行首的所有数据
    y（d）$：复制(删除)光标所在的那个字符到该行行尾的所有数据

