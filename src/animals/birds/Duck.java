package animals.birds;

import animals.AbsAnimal;

public class Duck extends AbsAnimal implements IFlying {
    public void fly(){
        System.out.println("Я лечу");

    }

    @Override
    public void say(){
        System.out.println("Кря");
    }
}
