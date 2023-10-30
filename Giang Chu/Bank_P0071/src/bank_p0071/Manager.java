/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Bank management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package bank_p0071;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * This class contains the main method for implementing employee management
 * project
 *
 * @author Chu Hoang Giang
 */
public class Manager {

    final static Logger logger = Logger.getLogger(Manager.class.getName());
    final static Scan sc = new Scan();
    final static ArrayList<Task> taskList = new ArrayList<>();
    final static ArrayList<TypeOfTask> typeOfTaskList = new ArrayList<>();

    /**
     * Add new task
     */
    public void addNewTask() {
        setTypeOfTask();
        Calendar c = Calendar.getInstance();
        int dayLimit = c.get(Calendar.DAY_OF_MONTH);
        int monthLimit = c.get(Calendar.MONTH + 1);
        int yearLimit = c.get(Calendar.YEAR);
        int id = taskList.size() + 1;
        String name = sc.nextLine("Requirement name: ");
        int type = sc.checkLimit(1, 4, "Task type: ");
        TypeOfTask taskTypeID = typeOfTaskList.get(type - 1);
        String[] temp = new String[9];
        String date = addDate();
        double workStart;
        double workEnd;
        do {
            workStart = checkTimeFormat("From: ");
            if (workStart < 8) {
                System.out.println("From time invalid, please work at 8h!");
            }
        } while (workStart < 8);
        do {
            workEnd = checkTimeFormat("To: ");
            if (workEnd > 17.5) {
                System.out.println("To time invalid, please end work before 17!");
            }
        } while (!checkWorkTime(workStart, workEnd) || workEnd > 17.5);

        String assignment = sc.nextLine("Assignment: ");
        String reviewer = sc.nextLine("Reviewer: ");
        taskList.add(new Task(id, taskTypeID, name, date, workStart, workEnd, assignment, reviewer));
        System.err.println("Add successfully");
    }

    /**
     * get and check time format
     *
     * @param inform to print
     * @return an double value
     */
    double checkTimeFormat(String inform) {
        double time;
        do {
            time = sc.nextDouble(inform);
            if (time % 0.5 != 0) {
                System.out.println("Wrong time format! ");
            }
            if (time < 0 || time > 24) {
                System.out.println("Wrong time format! ");
            }
        } while (time % 0.5 != 0 || time < 0 || time > 24);
        return time;
    }

    /**
     * check is start > end
     *
     * @param start to compare to end
     * @param end to compare to start
     * @return
     */
    public boolean checkWorkTime(double start, double end) {
        if (start > end) {
            System.out.println("Time not valid! ");
            return false;
        }
        return true;
    }

    /**
     * Remove task
     */
    public void removeTask() {
        int index;
        int id = getTaskID();
        index = findTaskById(id);
        if (!checkApprove("Do you want to delete? ")) {
            return;
        }
        taskList.remove(index);
        System.err.println("Delete successfully");
    }

    /**
     * check is day of birth is right format
     *
     * @param date
     * @return boolean if dob is valid
     */
    public boolean checkDate(String date) {
        Calendar c = Calendar.getInstance();
        int yearLimit = c.get(Calendar.YEAR);
        int monthLimit = c.get(Calendar.MONTH) + 1;
        int dayLimit = c.get(Calendar.DATE);

        String[] temp = date.split("-");

        int day = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);

        if (year < yearLimit) {
            return false;
        }

        if (month > 12 || month < monthLimit) {
            return false;
        }

        if (month == 2) {
            if ((checkLeapYear(year) && (day < 1 || day > 29)) || (!checkLeapYear(year) && (day < 1 || day > 28))) {
                return false;
            }
        }
        else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 || month == monthLimit) && (day < 1 || day > 31 || day < dayLimit)) {
            return false;
        }
        else if ((month == 4 || month == 6 || month == 9 || month == 11 || month == monthLimit) && (day < 1 || day > 30 || day < dayLimit)) {
            return false;
        }
        else if (month == monthLimit && day < dayLimit) {
            return false;
        }
        return true;

    }

    /**
     * add new day of birth to emplist
     *
     * @return string value
     */
    public String addDate() {
        String date;
        do {
            date = sc.nextLine("Enter date(dd-MM-yyyy): ");
            if (!date.matches("^(\\d)+(-)+(\\d)+(-)+(\\d)+$")) {
                System.out.println("Wrong format! ");
            } else {
                if (!checkDate(date)) {
                    System.out.println("Date is not valid");
                }
            }
        } while (!date.matches("^(\\d)+(-)+(\\d)+(-)+(\\d)+$") || !checkDate(date));
        return date;
    }

    /**
     * Check leap year
     *
     * @param year
     * @return boolean value
     */
    public boolean checkLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    /**
     * set type of task
     */
    public void setTypeOfTask() {
        String[] taskName = new String[]{"Code", "Test", "Design", "Learn"};
        for (int i = 0; i < taskName.length; i++) {
            typeOfTaskList.add(new TypeOfTask(i + 1, taskName[i]));
        }
    }

    /**
     * find task by id
     *
     * @param id to find task have same id
     * @return integer value
     */
    public int findTaskById(int id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Display taskList information
     */
    public void displayTask() {
        if (taskList.isEmpty()) {
            System.out.println("There is no task please ad more");
        }
        for (int i = 0; i < taskList.size(); i++) {
            System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%n", "ID", "Name", "Task Type", "Date", "Time", "Assignment", "Reviewer");
            System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%n", taskList.get(i).getId(), taskList.get(i).getName(), taskList.get(i).getTaskTypeID().getName(), taskList.get(i).getDate(),
                    taskList.get(i).getTo() - taskList.get(i).getFrom(), taskList.get(i).getAssignee(), taskList.get(i).getReviewer());
        }
    }

    public int getTaskID() {
        int id;
        do {
            id = sc.nextInt("Enter id: ");
            if (findTaskById(id) < 0) {
                logger.warning("Id not exsits! ");
            }
        } while (findTaskById(id) < 0);
        return id;
    }

    /**
     *
     * @param inform to normallize
     * @return inform after normallize
     */
    public String normallize(String inform) {
        String[] temp = inform.split(" ");
        String result = "";
        for (String data : temp) {
            result += data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase();
        }
        return result;
    }

    /**
     * Check the user for inputting y/Y or n/N
     *
     * @param inform to print
     * @return
     */
    public boolean checkApprove(String inform) {
        String data;
        do {
            data = sc.nextLine(inform).toLowerCase();
            if (data.equalsIgnoreCase("y")) {
                return true;
            } else if (data.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Enter 'y' or 'n'");
            }
        } while (!data.equalsIgnoreCase("y") || data.equalsIgnoreCase("n"));
        return true;
    }

}
