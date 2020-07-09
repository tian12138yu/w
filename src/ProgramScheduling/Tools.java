package ProgramScheduling;

import java.util.ArrayList;

public class Tools {

    public static double calcAverageTurnAroundTime(
            ArrayList<Process> processList) {
        double sum = 0;
        for (int i = 0; i < processList.size(); i++) {
            sum += processList.get(i).getTurnAroundTime();
        }
        return Math.round(sum / processList.size() * 100) / 100.0;
    }

    public static double calcAverageTurnAroundTimeWithWeight(
            ArrayList<Process> processList) {
        double sum = 0;
        for (int i = 0; i < processList.size(); i++) {
            sum += processList.get(i).getTurnAroundTimeWithWeight();
        }
        return Math.round(sum / processList.size() * 100) / 100.0;
    }

    public static void printResult(ArrayList<Process> processList) {
        System.out.println("\t#结果#");

        System.out.print("\t到达时间:\t");
        for (int i = 0; i < processList.size(); i++) {
            System.out.print(processList.get(i).getArrivalTime() + "\t");
        }
        System.out.println();

        System.out.print("\t服务时间:\t");
        for (int i = 0; i < processList.size(); i++) {
            System.out.print(processList.get(i).getServicesTime() + "\t");
        }
        System.out.println();

        System.out.print("\t开始时间:\t");
        for (int i = 0; i < processList.size(); i++) {
            System.out.print(processList.get(i).getStartTime() + "\t");
        }
        System.out.println();

        System.out.print("\t等待时间:\t");
        for (int i = 0; i < processList.size(); i++) {
            System.out.print(processList.get(i).getWaitTime() + "\t");
        }
        System.out.println();

        System.out.print("\t完成时间:\t");
        for (int i = 0; i < processList.size(); i++) {
            System.out.print(processList.get(i).getCompletionTime() + "\t");
        }
        System.out.println();

        System.out.print("\t周转时间:\t");
        for (int i = 0; i < processList.size(); i++) {
            System.out.print(processList.get(i).getTurnAroundTime() + "\t");
        }
        System.out.println();

        System.out.print("\t带权周转时间:\t");
        for (int i = 0; i < processList.size(); i++) {
            System.out.print(Math.round(processList.get(i)
                    .getTurnAroundTimeWithWeight() * 100) / 100.0 + "\t");
        }
        System.out.println();

        System.out.println("\t平均周转时间:"
                + Tools.calcAverageTurnAroundTime(processList) + "\t");
        System.out.println("\t平均带权周转时间:"
                + Tools.calcAverageTurnAroundTimeWithWeight(processList));

        System.out.println();
    }
}
