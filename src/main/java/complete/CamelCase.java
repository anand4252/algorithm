package complete;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  -> Clean the input string of *,-,%
 *  -> Camel case each of the word
 *  -> join them
 *
 *  Example:
 *     cats AND*Dogs-are Awesome  ==> catsAndDogsAreAwesome
 *     a b c d-e-f%g ==> aBCDEFG
 */
public class CamelCase {

    public static String camelCase(String input) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        final List<String> splittedElements = split(input);

        String output = splittedElements.get(0);
        for(int index =1; index<splittedElements.size(); index++){
            output = output.concat(capitalizeFirstChar(splittedElements.get(index)));
        }
        return output;
    }

    private static List<String> split(String input) {
        return Arrays.stream(input.split(" "))
                .flatMap(s1 -> Arrays.stream(s1.split("\\*")))
                .flatMap(s1 -> Arrays.stream(s1.split("-")))
                .flatMap(s1 -> Arrays.stream(s1.split("%")))
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static String capitalizeFirstChar(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(camelCase(s.nextLine()));
    }
}
