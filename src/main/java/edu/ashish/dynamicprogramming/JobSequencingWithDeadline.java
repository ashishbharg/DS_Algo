package edu.ashish.dynamicprogramming;

import edu.ashish.util.PrintingUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem Statement: Given an array of jobs where every job has a deadline and associated profit
 * if the job is finished before the deadline. It is also given that every job takes single unit of time,
 * so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be
 * scheduled at a time.
 *
 * Solution: Greedy Method approach. Start assigning the slot with index equivalent to its deadline. If
 * that slot is already booked, then start looking for any available slot in its previous index.This is
 * how one can achieve maximum profit based on given statement. This is also called maximized solution.
 *
 * Time Complexity : O(n^2)
 */
public class JobSequencingWithDeadline {

    public static void main(String[] args) {

        JobSequencingWithDeadline jswd = new JobSequencingWithDeadline();
        Job[] jobs = jswd.createJobs();
        int noOfMaxSlots = jswd.findMaxSlotsAvailable(jobs);
        System.out.println(noOfMaxSlots);
        Arrays.sort(jobs);
        PrintingUtil.print1DArray(jobs);

        int maxProfit = jswd.processJobsWithMaxProfit(jobs, noOfMaxSlots);
        System.out.println("Max Profit is " + maxProfit);
    }

    private int processJobsWithMaxProfit(Job[] jobs, int noOfMaxSlots) {

        String[] jobsSequence = new String[noOfMaxSlots];
        int maxProfit = 0;
        Job job;
        int nextAvailableSlot;
        for (int i = 0; i < jobs.length; i++) {
            job = jobs[i];
            nextAvailableSlot = fetchNextAvailableSlot(jobsSequence, job.deadline - 1);
            System.out.println("Next available slot is " + nextAvailableSlot);
            if (nextAvailableSlot == -1) {
                System.out.println("Slots are full. No more jobs can be accommodated.");
                break;
            }
            jobsSequence[nextAvailableSlot] = job.jobId;
            maxProfit += job.profit;
        }
        System.out.println("Jobs sequencing will be ");
        PrintingUtil.print1DArray(jobsSequence);
        return maxProfit;
    }

    private static int fetchNextAvailableSlot(String[] jobsSequence, int index) {

        if (index < 0) {
            return -1;
        }
        if (jobsSequence[index] == null) {
            return index;
        } else {
            return fetchNextAvailableSlot(jobsSequence, index - 1);
        }
    }

    private int findMaxSlotsAvailable(Job[] jobs) {

        Arrays.sort(jobs, new DeadlineComparator());
        return jobs[0].deadline;
    }

    private Job[] createJobs() {

        Job j1 = new Job("J1", 35, 3);
        Job j2 = new Job("J2", 5, 2);
        Job j3 = new Job("J3", 25, 4);
        Job j4 = new Job("J4", 15, 3);
        Job j5 = new Job("J5", 20, 2);
        Job j6 = new Job("J6", 30, 4);
        Job j7 = new Job("J7", 12, 1);

        Job[] jobs = new Job[] {j1, j2, j3, j4, j5 , j6, j7};
        return jobs;

    }

    private class Job implements Comparable<Job> {

        String jobId;
        int deadline;
        int profit;

        public Job(String jobId, int profit, int deadline) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return o.profit - this.profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "jobId='" + jobId + '\'' +
                    ", deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }
    }

    private class DeadlineComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o2.deadline - o1.deadline;
        }
    }
}
