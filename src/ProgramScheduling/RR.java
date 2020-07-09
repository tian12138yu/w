package ProgramScheduling;

import java.util.*;


public class RR {
    private int processNumber;
    private ArrayList<Process> processList;
    private int timeSlice;
    List<Integer> arrtime=new ArrayList<>();

    public RR() {
        init();
        calc();
        Tools.printResult(processList);
    }

    private void init() {
        Scanner sc = new Scanner(System.in);


        System.out.print("<RR> 请输入时间片大小:");
        timeSlice = sc.nextInt();
        System.out.print("<RR> 请输入进程数:");
        processNumber = sc.nextInt();

        processList = new ArrayList<Process>();
        for (int i = 0; i < processNumber; i++) {
            processList.add(new Process());
        }

        System.out.println("<RR> 请输入每个进程到达时间:");
        for (int i = 0; i < processNumber; i++) {
            System.out.print("    Process" + (i + 1) + ":");
            int a=sc.nextInt();
            processList.get(i).setArrivalTime(a);
            arrtime.add(a);
        }

        System.out.println("<RR> 请输入每个进程服务时间:");
        for (int i = 0; i < processNumber; i++) {
            System.out.print("    Process" + (i + 1) + ":");
            int servicesTime = sc.nextInt();

            processList.get(i).setServicesTime(servicesTime);
            processList.get(i).setRemainServiceTime(servicesTime);
        }
    }

    private void calc() {
        int timeNow = 0;
        Queue queue=new LinkedList();
        int processRemain = processNumber;
        boolean noProcessRunInThisTurn=true;
        Process opProcess;Process linshi=null;
        int extime=0;


        while (processRemain != 0) {

            if(arrtime.contains(timeNow)){
                queue.add(processList.get(arrtime.indexOf(timeNow)));
            }
            if(timeNow==extime&&linshi!=null){
                noProcessRunInThisTurn=true;
                if(timeNow!=0&&linshi.getRemainServiceTime()>0)
                    queue.add(linshi);
            }
            if(noProcessRunInThisTurn&&!queue.isEmpty()) {
                opProcess = (Process) queue.poll();
                linshi=opProcess;

                if ((opProcess.getRemainServiceTime() > 0)
                        && (timeNow >= opProcess.getArrivalTime())) {
                    // First time
                    if (opProcess.getServicesTime() == opProcess
                            .getRemainServiceTime()) {
                        int waitTime = timeNow - opProcess.getArrivalTime();

                        opProcess.setStartTime(timeNow);
                        opProcess.setWaitTime(waitTime);
                    }
                    noProcessRunInThisTurn = false;

                    // Calculating remain service time
                    int rs=opProcess.getRemainServiceTime();

                    int remainServiceTime = rs - timeSlice;
                    opProcess.setRemainServiceTime(remainServiceTime);

                    // Last time
                    if (remainServiceTime == 0) {
                        int completionTime = timeNow + timeSlice; // The process ends when the current slice is completed.
                        int turnAroundTime = completionTime
                                - opProcess.getArrivalTime();
                        double turnAroundTimeWithWeight = 1.0 * turnAroundTime
                                / opProcess.getServicesTime();

                        opProcess.setCompletionTime(completionTime);
                        opProcess.setTurnAroundTime(turnAroundTime);
                        opProcess.setTurnAroundTimeWithWeight(turnAroundTimeWithWeight);
                        processRemain--;
                        timeNow +=1;
                        extime +=timeSlice;

                    }
                    if (remainServiceTime < 0) {
                        int completionTime  ;   // The process ends when the current slice is completed.
                        completionTime = timeNow +  rs;
                        int turnAroundTime = completionTime
                                - opProcess.getArrivalTime();
                        double turnAroundTimeWithWeight = 1.0 * turnAroundTime
                                / opProcess.getServicesTime();

                        opProcess.setCompletionTime(completionTime);
                        opProcess.setTurnAroundTime(turnAroundTime);
                        opProcess
                                .setTurnAroundTimeWithWeight(turnAroundTimeWithWeight);
                        processRemain--;
                        timeNow += 1;
                        extime+=rs;

                    }
                    if (remainServiceTime > 0) {
                        timeNow += 1;
                        extime+=timeSlice;

                    }


//                    System.out.println("    #STEP# Process" + (i + 1)
//                            + " remain service time:"
//                            + opProcess.getRemainServiceTime()
//                            + " , timeBefore:" + (timeNow - 1) + ", timeNow:"
//                            + timeNow
//                            + ((remainServiceTime <= 0) ? " Finish" : ""));
                }
            }
            else {
                timeNow++;
//                extime++;
            }


            // Means no process could run, because they have arrived.

        }
    }


}