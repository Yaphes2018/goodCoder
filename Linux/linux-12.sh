//Q1、请简述linux系统加载过程。
  1、加载BIOS的硬件信息与进行自我测试，并依据设置取得第一个可启动的设备；
  2、读取并执行第一个启动设备被MBR（开机流程与主引导分区）的boot loader （grub spfdisk等程序）
  3、依据boot loader的设置加载kernel，kernel会开始检测硬件与加载驱动程序；
  4、在硬件执行成功之后，kernel会主动调用init进程，init会检测硬件与加载驱动程序；
  5、init执行／etc/rc.d/rc.sysinit文件来准备软件执行的操作环境（网络、时区等）；
  6、init执行run-level的各个服务的启动（script）；
  7、init执行／etc/rc.d/rc.local文件；
  8、init执行终端及模拟程序mingetty来启动login进程，最后等待用户登录。

//Q2、什么是swap分区？安装linux操作系统的时候，如何设置swap分区大小。
  A1：swap（内存交换空间），是用来应付在物理内存不足的情况下所造成的内存扩展记录的功能。
  swap分区最好是物理内存的1.5～2倍。通常1G就可以。

  A2：设置swap的过程（2G为例）
      1、dd if=/dev/zero of=/home/swap bs=1024 count=2048000
      //设置交换分区
      2、mkswap /home/swap
      //启动交换分区条件
      3、swapon /home/swap

  //Q3、请问题下面目录主要存放什么数据。 /etc，/etc/initd/，/boot，/usr/bin，/bin，/usr/sbin，/sbin，/dev，/var/ log
  A1：
      /etc        系统的配置文件，如人员账号密码文件，各种服务起始文件
      /etc/init.d 存放所有服务的默认启动脚本
      /boot       主要放置系统开机会使用到的文件，包括系统内核文件以及开机菜单与开机所需配置文件等
      /usr/bin    /usr/bin 存放应用程序
      /bin        放置执行文件的目录，放置的是单用户委会模式下还能够被操作的命令。
      /usr/sbin   非系统正常运行所需要的系统命令，给系统管理员root使用的命令，一般用户只能"查看"而不能设置和使用。
      /sbin       开机过程中开机、修复、还原系统所需要的命令。
      /dev        存放设备与接口的文件，访问这个目录下的某个文件，相当于访问某个设备。
      /var/log    登录文件放置的目录。

  //Q4、在系统中创建2个用户，test01、test02，创建1个用户组group01，且test01、test02对于group01有读写权限，其他之外的任何用户对group01都不可读。请列出实现该需求的相关完整指令。
  A1：
      useradd test01
      useradd test02
      groupadd  group01
      gpasswd -a test01 group01
      gpasswd -a test02 group01



  //Q5、找出/etc下面，文件容量大于50KB且文件所有者不是root的文件名，且将权限完整的列出。(ls -l)
  A：  find /etc -size +50k -a -not -user root -exec ls -l {} \;
       find /etc -size +50k ! -user root -exec ls -l {} \;