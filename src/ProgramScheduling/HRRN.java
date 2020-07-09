package ProgramScheduling;

import java.util.*;
public class HRRN {
    private int processNumber;
    private ArrayList<Process> processList;
    private int timeSlice;
    List<Integer> arrtime=new ArrayList<>();

    public HRRN() {
        init();
        calc();
        System.out.println(processList.get(0).getCompletionTime());
        Tools.printResult(processList);
    }

    private void init() {
        Scanner sc = new Scanner(System.in);



        System.out.print("<HRRN> 请输入进程数:");
        processNumber = sc.nextInt();

        processList = new ArrayList<Process>();
        for (int i = 0; i < processNumber; i++) {
            processList.add(new Process());
        }

        System.out.println("<HRRN> 请输入每个进程到达时间:");
        for (int i = 0; i < processNumber; i++) {
            System.out.print("    Process" + (i + 1) + ":");
            int a=sc.nextInt();
            processList.get(i).setArrivalTime(a);
            arrtime.add(a);
        }

        System.out.println("<HRRN> 请输入每个进程服务时间:");
        for (int i = 0; i < processNumber; i++) {
            System.out.print("    Process" + (i + 1) + ":");
            int servicesTime = sc.nextInt();

            processList.get(i).setServicesTime(servicesTime);
            processList.get(i).setRemainServiceTime(servicesTime);
        }
    }
    private void calc() {
        int timeNow = 0;
        Process opProcess;
        sertimecomparator com=new sertimecomparator();
        PriorityQueue<Process> pr=new PriorityQueue(10,com);
        boolean extime=true;boolean run=true;
        int endtime=0;
        while(run){
            if(arrtime.contains(timeNow)){
                if(!pr.contains(processList.get(arrtime.indexOf(timeNow)))){
                    pr.add(processList.get(arrtime.indexOf(timeNow)));

                }
            }
            Process pro[]=new Process[pr.size()];
            int size=pr.size();
            for(int x=0;x<size;x++){
                pro[x]=pr.poll();
                pro[x].setWaitTime(timeNow-pro[x].getArrivalTime());
            }
            for(int y=0;y<size;y++){
                pr.offer(pro[y]);
            }


            if(pr.isEmpty()&&timeNow==endtime){
                run=false;
                break;
            }
            if(timeNow==endtime)extime=true;
            if(extime){
                extime=false;

                opProcess=pr.poll();
                int waitTime = timeNow - opProcess.getArrivalTime();
                int completionTime = timeNow + opProcess.getServicesTime();
                int turnAroundTime = completionTime
                        - opProcess.getArrivalTime();
                double turnAroundTimeWithWeight = (double) turnAroundTime
                        / opProcess.getServicesTime();

                opProcess.setStartTime(timeNow);
//                opProcess.setWaitTime(waitTime);
                opProcess.setCompletionTime(completionTime);
                opProcess.setTurnAroundTime(turnAroundTime);
                opProcess.setTurnAroundTimeWithWeight(
                        turnAroundTimeWithWeight);

                timeNow += 1;
                endtime += opProcess.getServicesTime();
            }
            else{
                timeNow++;

            }

        }

    }
    static class sertimecomparator implements Comparator<Process> {

        @Override
        public int compare(Process o1, Process o2) {
            if((o1.getServicesTime()+o1.getWaitTime())/o1.getServicesTime()
                    <(o2.getServicesTime()+o2.getWaitTime())/o2.getServicesTime()){
                return 1;
            }
            if((o1.getServicesTime()+o1.getWaitTime())/o1.getServicesTime()
                    >(o2.getServicesTime()+o2.getWaitTime())/o2.getServicesTime()){
                return -1;
            }
            else return 0;
        }
    }

}
