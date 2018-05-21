/*
-Q2：创建啮齿动物（Rodent）：老鼠（Mouse）、鼹鼠（Gerbil）、大颊鼠（Hamster）这样一个继承结构，在基类中提供通用的方法，并在子类中根据特定的Rodent类型覆盖这些方法，以便执行不同的行为，
创建一个Rodent数组并填充不同的Rodent类型，执行基类的方法，观察结果。
*/

public class Java04_05_Q2{
    public static void main(String[] args){
        Rodent rodent[] = new Rodent[3];
        rodent[0] = new Mouse();
        rodent[1] = new Gerbil();
        rodent[2] = new Hamster();
        for(int i=0; i<=2; i++){
            rodent[i].say();
        }
    }
}

class Rodent{
    void say(){
        System.out.println("who are you?");
    }
}

class Mouse extends Rodent{
    @Override
    void say() {
        System.out.println("mouse say zizi");
    }
}

class Gerbil extends Rodent{
    @Override
    void say() {
        System.out.println("gerbil say jiji");
    }
}

class Hamster extends Rodent{
    @Override
    void say() {
        System.out.println("hamster say jiujiu");
    }
}





