
package albumdatabase;


public class Track 
{
    String track;
    Duration duration;


public Track()
    {
       track = "";
       duration = new Duration("00:00:00");
    }

public Track(String t, Duration d)
{
    track = t;
    duration = d;
}

public String toString()
{
    return duration.toString() + " - " + track;
}
}