import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Clock> clocks = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static Clock extractTime(Clock clock1, Clock clock2) {
        int newHour, newMinute;

        if (clock1.getHour() > clock2.getHour() || (clock1.getHour() == clock2.getHour() && clock1.getMinute() > clock2.getMinute())) {
            newHour = clock1.getHour() - clock2.getHour();
            newMinute = clock1.getMinute() - clock2.getMinute();
        }
        else {
            newHour = clock2.getHour() - clock1.getHour();
            newMinute = clock2.getMinute() - clock1.getMinute();
        }

        Clock newClock = new Clock(newHour, newMinute);
        return newClock;
    }

    public static void printTimes() {
        for (int i = 0; i < clocks.size(); i++) {
            System.out.println(clocks.get(i).toString());
        }
    }

    public static void deleteTime(int index) {
        clocks.remove(index);
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String input = null;

        while (!exit) {
            System.out.println();
            System.out.println("┏━━━━━━━━━━━━━━━━━  MENU  ━━━━━━━━━━━━━━━━┓");
            System.out.println("┃ [0]  -  Exit                            ┃");
            System.out.println("┃ [1]  -  Add New Time                    ┃");
            System.out.println("┃ [2]  -  List Times                      ┃");
            System.out.println("┃ [3]  -  Delete a Time                   ┃");
            System.out.println("┃ [4]  -  Forward a Time                  ┃");
            System.out.println("┃ [5]  -  Backward a Time                 ┃");
            System.out.println("┃ [6]  -  Substract Times                 ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println();
            System.out.print(">>> Please choose a command from the menu: ");

            input = scanner.next();
            System.out.println();

            switch(input) {
                case "0":
                    exit = true;
                    System.out.println(">>> Quitting system.");
                    break;

                case "1":
                    System.out.print(">>> Please enter the time as HH:MM format: ");
                    String timeInput = scanner.next();
                    System.out.println();

                    String[] timeArray = timeInput.split("\\.");
                    int hour = Integer.parseInt(timeArray[0]);
                    int minute = Integer.parseInt(timeArray[1]);

                    Clock newClock = new Clock(hour, minute);
                    clocks.add(newClock);

                    System.out.println("> " + timeInput + " added as a new time.");
                    System.out.println();
                    break;

                case "2":
                    System.out.println(">>> Listing times:");
                    System.out.println();

                    printTimes();

                    System.out.println();
                    System.out.println("> All times have listed.");
                    System.out.println();
                    break;

                case "3":
                    System.out.print(">>> Please enter index number of the time you want to delete: ");
                    int indexInput = scanner.nextInt();
                    System.out.println();

                    deleteTime(indexInput);

                    System.out.println();
                    System.out.println("> The time with index number " + indexInput + " has been deleted.");
                    System.out.println();
                    break;

                case "4":
                    System.out.print(">>> Please enter index number of the time you want to forward: ");
                    int forwardInput = scanner.nextInt();
                    System.out.println();
                    System.out.print(">>> Please enter how many minutes you want to forward: ");
                    int forwardMinuteInput = scanner.nextInt();
                    System.out.println();

                    clocks.get(forwardInput).forwardTime(forwardMinuteInput);

                    System.out.println("> The time with index number " + forwardInput + " has been forwarded " + forwardMinuteInput + " minutes; new time: " + clocks.get(forwardInput));
                    System.out.println();
                    break;

                case "5":
                    System.out.print(">>> Please enter index number of the time you want to backward: ");
                    int backwardInput = scanner.nextInt();
                    System.out.println();
                    System.out.print(">>> Please enter how many minutes you want to backward: ");
                    int backwardMinuteInput = scanner.nextInt();
                    System.out.println();

                    clocks.get(backwardInput).backwardTime(backwardMinuteInput);

                    System.out.println("> The time with index number " + backwardInput + " has been backwarded " + backwardMinuteInput + " minutes; new time: " + clocks.get(backwardInput));
                    System.out.println();
                    break;

                case "6":
                    System.out.print(">>> Please enter index number of the time you want to subtract from: ");
                    int extractInput1 = scanner.nextInt();
                    System.out.println();
                    System.out.print(">>> Please enter index number of the time you want to subtract: ");
                    int extractInput2 = scanner.nextInt();
                    System.out.println();

                    Clock extractedClock = extractTime(clocks.get(extractInput1), clocks.get(extractInput2));

                    System.out.println("> The time with index number " + extractInput2 + " subtracted from " + extractInput1 + ", the difference: " + extractedClock);
                    System.out.println();
                    break;
            }
        }
    }
}
