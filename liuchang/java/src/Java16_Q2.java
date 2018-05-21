/*
-Q2：请解释工厂模式及其应用场景，且编写代码Demo说明。
 */
public class Java16_Q2 {
/*
工厂模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类
核心工厂类不再负责产品的创建，这样核心类成为一个抽象工厂角色，仅负责具体工厂子类必须实现的接口，这样进一步抽象化的好处是使得工厂方法模式可以使系统在不修改具体工厂角色的情况下引进新的产品。

工厂方法模式由4种角色组成：
（1）抽象工厂(Creator)角色：是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口。
（2）具体工厂(Concrete Creator)角色：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建产品对象。
（3）抽象产品(Product)角色：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口。
（4）具体产品(Concrete Product)角色：这个角色实现了抽象产品角色所定义的接口。某具体产品有专门的具体工厂创建，它们之间往往一一对应。
 */

    public static void main(String[] args){
        try{
            Food f = FactoryFood.getFood(FactoryFood.APPLE);
            f.eat();

            Food f2 = FactoryFood2.getFood("Chicken");
            f2.eat();

        } catch(Exception e){
        }

        //普通工厂方法
        FactoryAb factory = new AppleFactory();
        factory.create();

        //抽象工厂方法
        AbstractFoodFactory ab1 = new BeijingFactory();
        AbstractFoodFactory ab2 = new KFCFactory();
        ab1.createFood().eaat();
        ab1.createDrinks().price();
        ab2.createFood().eaat();
        ab2.createDrinks().price();

    }
}

//简单工厂模式

//定义一个食物抽象接口
interface Food{
    void eat();
}

//定义具体的产品：苹果和鸡
class Apple implements Food{
    public void eat(){
        System.out.println("eat apple");
    }
}

class Chicken implements Food{
    public void eat(){
        System.out.println("eat chicken");
    }
}

//定义一个食品加工厂
class FactoryFood{
    public static final int APPLE = 1;
    public  static final int CHICKEN = 2;
    public static Food getFood(int type){
        switch(type){
            case APPLE: return new Apple();
            case CHICKEN: return new Chicken();
        }
        return null;
    }
}

//或者可以通过反射模式创建
class FactoryFood2{
    public static Food getFood(String type) throws Exception{
        Class food = Class.forName(type);
        return (Food)food.newInstance();
    }
}

//普通工厂模式
abstract class FactoryAb{
    public abstract Food create();
}

class AppleFactory extends FactoryAb{
    @Override
    public Food create(){
        System.out.println("eat apple");
        return new Apple();
    }
}

class ChickenFactory extends FactoryAb{
    @Override
    public Food create(){
        System.out.println("eat chicken");
        return new Chicken();
    }
}

//抽象工厂模式
//再定义一个产地抽象接口
interface Place{
    void inPlace();
}

//定义具体的产品：苹果和鸡
class Beijing implements Place{
    public void inPlace(){
        System.out.println("in beijing");
    }
}

class Shanghai implements Place{
    public void inPlace(){
        System.out.println("in shanghai");
    }
}

//定义一个抽象产品
abstract class IFood{
    abstract void eaat();
}

//定义具体产品
class AppleFood extends IFood{
    public void eaat(){
        System.out.println("吃苹果，不好吃");
    }
}

class ChickenFood extends IFood{
    public void eaat(){
        System.out.println("大吉大利，今日吃鸡");
    }
}

//定义另一个抽象产品
abstract class IDrinks{
    abstract void price();
}

//定义具体产品
class ColaDrinks extends IDrinks{
    public void price(){
        System.out.println("可乐三块五");
    }
}

class WaterDrinks extends IDrinks{
    public void price(){
        System.out.println("矿泉水一块");
    }
}

//定义抽象工厂
abstract class AbstractFoodFactory{
    abstract IFood createFood();
    abstract IDrinks createDrinks();
}

//定义具体工厂类
class BeijingFactory extends AbstractFoodFactory{
    public IFood createFood(){
        return new AppleFood();
    }
    public IDrinks createDrinks(){
        return new WaterDrinks();
    }
}

class KFCFactory extends AbstractFoodFactory{
    public IFood createFood(){
        return new ChickenFood();
    }
    public IDrinks createDrinks(){
        return new ColaDrinks();
    }
}