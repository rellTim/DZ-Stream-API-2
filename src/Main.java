import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long notExactlySummer = persons.stream().filter(person->person.getAge()<18).count();// несовершеннолетние
        System.out.println("Количество несовершенно летний составила по статисте - " + notExactlySummer);
        List<String> prizeWinners= persons.stream().filter(person -> person.getAge()>=18 && person.getAge()<=27&&person.getSex()==Sex.MAN).map(Person::getFamily).collect(Collectors.toList());// фамили призывников (парней)
        System.out.println(prizeWinners);
        List<Person> withHigherEducation = persons.stream().filter(person -> person.getEducation()==Education.HIGHER&&person.getAge()>=18&&person.getAge()<65)
                .sorted(Comparator.comparing(person -> person.getFamily())).collect(Collectors.toList());// Может работать + вышка
        System.out.println(withHigherEducation);
    }
}