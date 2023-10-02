//Завдання 1
//        Дано текстовий файл file.txt, в якому є список номерів телефонів (один рядок - один телефон).
//
//        Необхідно написати метод, який буде читати файл, і виводити в консоль всі валідні номери телефонів.
//
//        Телефон вважається валідним, якщо він відповідає одному з двох форматів (x - це одна цифра):
//
//        (xxx) xxx-xxxx
//        xxx-xxx-xxxx

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
        readFile(file);
    }

    public static void readFile(File file) {
        ArrayList<String> lines = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Pattern pattern2 = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                if(pattern.matcher(line).matches() || pattern2.matcher(line).matches())
                    lines.add(line);
            }
            for(String phoneNumber : lines)
                System.out.println(phoneNumber);
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}