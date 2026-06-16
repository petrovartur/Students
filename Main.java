package main;

import model.Student;
import service.GradeBookService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GradeBookService service = new GradeBookService();

        while (true){

            System.out.println("\n===== MENU =====");
            System.out.println("1. Добавить студента");
            System.out.println("2. Добавить предмет");
            System.out.println("3. Добавить оценку");
            System.out.println("4. Средний балл по предмету");
            System.out.println("5. GPA студента");
            System.out.println("6. Предметы студента");
            System.out.println("7. Все оценки по предмету");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("ФИО: ");
                    String name = scanner.nextLine();

                    System.out.print("Группа: ");
                    String group = scanner.nextLine();

                    service.addStudent(
                            new Student(id, name, group)
                    );

                    break;

                case 2:

                    System.out.print("Код предмета: ");
                    String code = scanner.nextLine();

                    System.out.print("ID студента: ");
                    int studentId = scanner.nextInt();

                    System.out.print("Кредиты: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Название: ");
                    String subjectName =
                            scanner.nextLine();

                    service.addSubject(
                            code,
                            studentId,
                            subjectName,
                            credits
                    );

                    break;

                case 3:

                    System.out.print("Код предмета: ");
                    String subjCode =
                            scanner.nextLine();

                    System.out.print("Тип(EXAM/TEST/ASSIGNMENT): ");
                    String type =
                            scanner.nextLine();

                    System.out.print("Оценка: ");
                    double score =
                            scanner.nextDouble();

                    service.addGrade(
                            subjCode,
                            type,
                            score
                    );

                    break;

                case 4:

                    System.out.print("Код предмета: ");
                    String avgCode =
                            scanner.nextLine();

                    System.out.println(
                            service.getAverage(avgCode)
                    );

                    break;

                case 5:

                    System.out.print("ID студента: ");
                    int gpaId =
                            scanner.nextInt();

                    System.out.println(
                            service.getStudentGPA(gpaId)
                    );

                    break;

                case 6:

                    System.out.print("ID студента: ");
                    int subId =
                            scanner.nextInt();

                    System.out.println(
                            service.getSubjectsByStudent(subId)
                    );

                    break;

                case 7:

                    System.out.print("Код предмета: ");
                    String gradeCode =
                            scanner.next();

                    System.out.println(
                            service.getGradesBySubject(gradeCode)
                    );

                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Неверный пункт меню");
            }
        }
    }
}
