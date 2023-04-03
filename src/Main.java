import animals.AbsAnimal;
import data.AnimalColorData;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;

import java.util.*;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);



    public static void main(String... args) {
        List<AbsAnimal> animals = new ArrayList();

        while (true) {
            String commandStr = "";
            boolean invalidCommand = Arrays.stream(CommandsData.values()).toList().contains(commandStr);
            do {
                System.out.println("Введите комманду add/list/exit");
                commandStr = scanner.next().toUpperCase().trim();
            } while (invalidCommand);
            CommandsData commandsData = CommandsData.valueOf(commandStr);
            switch (commandsData) {
                case ADD -> {
                    String animalTypeStr = "";
                    do {
                        System.out.println("Введите тип животного cat/dog/duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();
                    } while (!animalTypeStr.equals("CAT") && !animalTypeStr.equals("DOG") && !animalTypeStr.equals("DUCK"));
                    AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalTypeStr);
                    AnimalFactory animalFactory = new AnimalFactory();

                    AbsAnimal animal = fillAnimalData(animalFactory.create(animalTypeData));

                    animals.add(animal);
                    animal.say();
                }
                case LIST -> animals.forEach((AbsAnimal animal) -> System.out.println(animal.toString()));
                case EXIT -> System.exit(0);
                default -> System.out.println("Некоректное значение");
            }
        }
    }

    private static AbsAnimal fillAnimalData(AbsAnimal animal) {
        System.out.println("Введите имя животного (до 10 символов):");
        String name = scanner.next().trim();
        while (name.length() > 10) {
            System.out.println("Имя должно содержать не более 10 символов. Пожалуйста, введите имя животного еще раз:");
            name = scanner.next().trim();
        }
        animal.setName(name);

        System.out.println("Введите возраст животного (от 0 до 20)");
        while (true) {
            try {
                int age = scanner.nextInt();
                if (age >= 0 && age <= 20) {
                    animal.setAge(age);
                    break;
                } else {
                    System.out.println("Возраст должен быть в диапазоне от 0 до 20. Попробуйте еще раз:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число от 0 до 20:");
                scanner.next();
            }
        }

        System.out.println("Введите вес животного (от 0 до 50)");
        while (true) {
            try {
                int weight = scanner.nextInt();
                if (weight >= 0 && weight <= 50) {
                    animal.setWeight(weight);
                    break;
                } else {
                    System.out.println("Вес должен быть в диапазоне от 0 до 50. Попробуйте еще раз:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число от 0 до 50:");
                scanner.next();
            }
        }

        System.out.println("Введите цвет животного (допустимые значения: " + Arrays.toString(AnimalColorData.values()) + "):");
        String colorName = scanner.next();

        while (true) {
            try {
                AnimalColorData color = AnimalColorData.valueOf(colorName.toUpperCase());
                animal.setColor(String.valueOf(color));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Недопустимое значение цвета. Пожалуйста, введите цвет животного еще раз:");
                colorName = scanner.next();
            }
        }
        return animal;
    }
}
