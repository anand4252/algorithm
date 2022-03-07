package complete;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class EqualsAndHashcodeQuiz {

    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Employee {
        private String name;
        private int age;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("anand", 34);
        Employee employee2 = new Employee("appu", 25);

        Map<Employee, String> map = new HashMap<>();
        map.put(employee1, "ONE_VAL");
        map.put(employee2, "TWO_VAL");
        System.out.println("complete.Employee 1::" + map.get(employee1));
        System.out.println("complete.Employee 2::" + map.get(employee2));

        // Set employee2 object to hold the same values as 1st.
        employee2.setName("anand");
        employee2.setAge(34);
        System.out.println("complete.Employee 2 value altered... ");
        System.out.println("Hashcode:: " + employee2.hashCode());


        System.out.println("complete.Employee 1::" + map.get(employee1));
        System.out.println("complete.Employee 2::" + map.get(employee2));//what will be the value returned?
    }
}

