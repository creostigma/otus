package animals;

public abstract class AbsAnimal{
    private String name = "";
    private int age = -1;
    private int weight = -1;
    private String color = "";

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say(){
        System.out.println("Я говорю");
    }

    public void go(){
        System.out.println("Я иду");
    }

    public void drink(){
        System.out.println("Я пью");
    }

    public void eat(){
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s", name, age,correctYearForm(age), weight, color);
    }

    private String correctYearForm(int age){
        int modulo = age % 10;

        if (modulo >=5 || modulo == 0 || (age >= 11 && age < 15)){
            return "лет";
        }
        if (modulo == 1){
            return "год";
        }

        return "года";
    }
}
