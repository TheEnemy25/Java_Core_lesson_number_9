package com.company;

import java.util.Scanner;

/**
 * @author andri
 * @since 1.8
 * @see Menu,Months,Seasons
 */

/* Name of class*/
public class Calendar extends Menu {

    public static void main(String[] args) throws WrongInputConsoleParametersException {

        Months[] mas = Months.values();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            /**
             * @since 1.8
             * @author andri
             * @see Menu;
             * */
            menu();

            switch (scanner.next()) {

//              Перевірити чи є такий місяць (місяць вводимо з консолі, передбачити, щоб регістр букв був не важливим)
                case "1": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = messageOutPut(scanner.next());

                    boolean flag = isFirstScan(mas, scan);

                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }

//              Вивести всі місяці з такою ж порою року
                case "2": {
                    System.out.println("Введіть пору року");
                    scanner = new Scanner(System.in);
                    String scan = messageOutPut(scanner.next());

                    boolean flag = false;

                    for (Months result : mas) {

                        if (result.getSeasons().name().equals(scan)) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        for (Months result2 : mas) {
                            if (result2.getSeasons().toString().equals(scan)) {
                                System.out.println(result2);
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }

//              Вивести всі місяці які мають таку саму кількість днів
                case "3": {
                    System.out.println("Введіть цифри (28,30,31) ");
                    scanner = new Scanner(System.in);
                    String scan = scanner.next();

                    boolean flag = false;

                    for (Months result : mas) {

                        if (result.getDays() == Integer.parseInt(scan)) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        for (Months result2 : mas) {
                            if (result2.getDays() == Integer.parseInt(scan)) {
                                System.out.println(result2);
                            }
                        }
                    }
                    if (!flag) {
                        /**
                         * @since 1.8
                         * @author andri
                         * @see WrongInputConsoleParametersException
                         * @exception WrongInputConsoleParametersException
                         * */
                        throw new WrongInputConsoleParametersException("неправильно введені дані");
                    }
                    break;
                }

//              Вивести на екран всі місяці які мають меншу кількість днів
                case "4": {
                    for (Months result : mas) {
                        if (result.getDays() == minValue(mas)) {
                            System.out.println(result.name());
                        }
                    }
                    break;
                }

//              Вивести на екран всі місяці які мають більшу кількість днів
                case "5": {
                    for (Months result : mas) {
                        if (result.getDays() == maxValue(mas)) {
                            System.out.println(result.name());
                        }
                    }
                    break;
                }

//              Вивести на екран наступну пору року
                case "6": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = messageOutPut(scanner.next());

                    boolean flag = isFirstScan(mas, scan);

                    if (flag) {
                        Months result2 = Months.valueOf(scan);
                        int ordinal = result2.ordinal();

                        if (ordinal == mas.length - 1) {
                            ordinal = 0;
                            System.out.println(mas[ordinal]);
                        } else {
                            System.out.println(mas[ordinal + 1]);
                        }
                    }
                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }

//              Вивести на екран попередню пору року
                case "7": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = messageOutPut(scanner.next());

                    boolean flag = isFirstScan(mas, scan);

                    if (flag) {
                        Months result2 = Months.valueOf(scan);
                        int ordinal = result2.ordinal();

                        if (ordinal == mas.length + 1) {
                            ordinal = 0;
                            System.out.println(mas[ordinal]);
                        } else if (ordinal == 0) {
                            int maxOrdinal = 0;
                            for (Months result : mas) {
                                if (result.ordinal() > maxOrdinal) {
                                    maxOrdinal = result.ordinal();
                                }
                            }
                            System.out.println(mas[maxOrdinal]);
                        } else {
                            System.out.println(mas[ordinal - 1]);
                        }
                    }
                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }

//              Вивести на екран всі місяці які мають парну кількість днів
                case "8": {
                    for (Months result : mas) {
                        if (result.getDays() % 2 == 0) {
                            System.out.println(result.name());
                        }
                        break;
                    }
                }

//              Вивести на екран всі місяці які мають непарну кількість днів
                case "9": {
                    for (Months result : mas) {
                        if (result.getDays() % 2 == 1) {
                            System.out.println(result.name());
                        }
                    }
                    break;
                }

//              Вивести на екран чи введений з консолі місяць має парну кількість днів
                case "0": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = messageOutPut(scanner.next());

                    for (Months result : mas) {
                        if (result.name().equals(scan)) {
                            if (result.getDays() % 2 == 0) {
                                System.out.println("Парний " + result.valueOf(scan));
                            } else {
                                System.out.println("Не парний " + result.name());
                            }
                        }
                        break;
                    }
                }
            }
        }
    }


    private static boolean isFirstScan(Months[] mas, String scan) {

        boolean flag = false;

        for (Months result : mas) {

            if (result.name().equals(scan)) {
                System.out.println("Існує");
                flag = true;
            }
        }
        return flag;
    }

    /**
     * @author andri
     * @see java code convention
     * @since 1.8
     * @param message
     */

    /* Method for case of entered any letters */
    private static String messageOutPut(String message) {
        return message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase();
    }


    /**
     * @author andri
     * @since 1.8
     * @param months
     */

    /* Determination of the minimum value */
    private static int minValue(Months[] months) {
        int minValue = months[0].getDays();
        for (Months m : months) {
            if (minValue > m.getDays()) {
                minValue = m.getDays();
            }
        }
        return minValue;
    }

    /**
     * @author andri
     * @see java code convention
     * @since 1.8
     * @param months
     */

    /* Determination of the maximum value  */
    private static int maxValue(Months[] months) {
        int maxValue = months[0].getDays();
        for (Months m : months) {
            if (maxValue < m.getDays()) {
                maxValue = m.getDays();
            }
        }
        return maxValue;
    }
}
