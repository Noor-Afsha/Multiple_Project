class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class MethodOverrridng {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Cat();
        
        animal1.makeSound(); // prints "Generic animal sound"
        animal2.makeSound(); // prints "Meow"
    }
}
