/*
-Q4：请解释建造者模式及其应用场景，且编写代码Demo说明。
 */
import java.util.*;
public class Java16_Q4 {
/*
　　构建者模式，又称建造者模式，将一部负责对象的构建分为许多小对象的构建，最后在整合构建的模式。

　　构建者模式一般用在构建流程或者组成部件固定的场合，将这些部件分开构建成为组件对象，再将这些组件对象整合成为目标对象。

　　最佳实例就是组装台式电脑的情况，我们可以分别购买主板、CPU、内存、硬盘等部件，然后将这些部件组装在一起就形成了一台完整的电脑。

　　成员分析：

　　　　Director：控制者类，这是控制整个组合过程，在这个类内部有个Construct()方法，这个方法的作用就是通过调用Builder内部的各个组件的生成方法来完成组装；

　　　　Builder：构建者接口，定义各部件生成的方法；

　　　　ConcreteBuilder：具体构建者类：实现Builder构建者接口，具体定义如何生成各个部件；依赖于Product成品类，其中还有获取成品组装结构的方法GetResult()方法；

　　　　Product：成品类
 */

    public static void main(String[] args){
        Builder builder = new ComputerBuilder();
        Director director = new Director();
        director.construct(builder);
        builder.getComputer().show();

    }
}

//Builder：构建接口
interface Builder {
     void build_CPU();
     void build_mainboard();
     void build_memory();
     void build_DISK();
     void build_power();
     Computer getComputer();
}

//ComputerBuilder：电脑构建类
class ComputerBuilder implements Builder {
      private Computer computer = new Computer();
      @Override
      public void build_CPU() {
          computer.parts.add("采用INTEL的CPU");
      }
      @Override
      public void build_mainboard() {
          computer.parts.add("采用大型主版");
      }
      @Override
      public void build_memory() {
          computer.parts.add("采用8G内存");
      }
      @Override
      public void build_DISK() {
          computer.parts.add("采用1TB固态硬盘");
      }
      @Override
      public void build_power() {
          computer.parts.add("采用XXX电源");
      }
      @Override
      public Computer getComputer() {
          return computer;
      }
}

//Director：组装类
class Director {
     public void construct(Builder builder){
         builder.build_CPU();
         builder.build_mainboard();
         builder.build_memory();
         builder.build_DISK();
         builder.build_power();
     }
}

//Computer：成品类
class Computer {
     List<String> parts = new ArrayList<String>();
     public void show(){
         for(String s:parts){
             System.out.println(s);
             }
     }
}



