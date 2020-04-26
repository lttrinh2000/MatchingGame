package model;

public class Timer
{
    long startTime;

    public Timer()
    {
        startTime = System.nanoTime();
    }
    public long getTime()
    {
        long newTime = System.nanoTime();
        long timePassed = (newTime-startTime)/1000000000;
        return timePassed;
    }
    public long getTimeMilli()
    {
        long newTime = System.nanoTime();
        long timePassed = (newTime-startTime)/1000000;
        return timePassed;
    }
}