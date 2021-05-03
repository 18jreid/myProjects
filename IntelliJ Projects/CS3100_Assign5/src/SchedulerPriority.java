// Justin Reid
// A02276642
// OS & Concurrency
// Assignment 5

import java.util.Comparator;
import java.util.PriorityQueue;

public class SchedulerPriority extends SchedulerBase implements Scheduler {
    private Platform platform;
    private PriorityQueue<Process> queue;

    public SchedulerPriority(Platform platform) {
        /***
         * Compares objects added to queue and places them accordingly.
         * @param o1 process1
         * @param o2 process2
         * @return
         */
        this.platform = platform;
        this.queue = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return Integer.compare(o1.getPriority(), o2.getPriority());
            }
        });
    }

    /***
     * gets number of context switches.
     * @return number of context switches.
     */
    @Override
    public int getNumberOfContextSwitches() {
        return contextSwitches;
    }

    /***
     * Adds new process to queue.
     * @param p process to be added.
     */
    @Override
    public void notifyNewProcess(Process p) {
        queue.add(p);
    }

    /***
     * Updates the cpu based on the Priority algorithm.
     * @param cpu cpu to be updated.
     * @return returns the state of the cpu.
     */
    @Override
    public Process update(Process cpu) {
        Process nextProcess = null;

        if (cpu != null) {
            // Check if burst is completed
            if (cpu.isBurstComplete()) {
                platform.log("Process " + cpu.getName() + " burst complete");
                contextSwitches++;

                // Check if execution is completed
                if (!cpu.isExecutionComplete()) {
                    queue.add(cpu);
                }
                else {
                    platform.log("Process " + cpu.getName() + " execution complete");
                }

                // Grab next process to be updated
                if (queue.peek() != null) {
                    platform.log("Scheduled:" + queue.peek().getName());
                    nextProcess = queue.poll();
                    contextSwitches++;
                }
            }
            else {
                nextProcess = cpu;
            }
        }
        else if (queue.peek() != null) {
            platform.log("Scheduled: " + queue.peek().getName());
            nextProcess = queue.poll();
            contextSwitches++;
        }

        return nextProcess;
    }
}