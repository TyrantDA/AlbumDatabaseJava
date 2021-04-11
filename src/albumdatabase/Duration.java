
package albumdatabase;
import java.text.DecimalFormat;

public class Duration implements Comparable<Duration>
{
    private int seconds;
    private int minutes;
    private int hour;
    
    public Duration()
    {
        seconds = 0;
        minutes = 0;
           hour = 0;
        
    }
    
    public Duration(int hou, int min, int sec)
    {
        seconds = sec;
        minutes = min;
           hour = hou;
    }
    
    // breaks up a string in the form hh:mm:ss into hour minuties and seconds
    public Duration(String time)
    {
        String[] splitTime = time.split(":");
           hour = Integer.parseInt(splitTime[0]);
        minutes = Integer.parseInt(splitTime[1]);
        seconds = Integer.parseInt(splitTime[2]);
    }
    
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("00");
        String hourFormated = df.format(hour);
        String minutesFormated = df.format(minutes);
        String secondsFormated = df.format(seconds);
        
        return hourFormated + ":" + minutesFormated + ":" + secondsFormated;
    }
    
    public int getHours()
    {
        return hour;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
    
    public int getSeconds()
    {
        return seconds;
    }
    
    public void add(Duration duration)
    {
        int h, m, s, overflow = 0;
        s = this.seconds + duration.getSeconds();
        if (s >= 60)
        {
            overflow = s / 60;
            s = s % 60;
            
            
        }
        
        m = (this.minutes + duration.getMinutes()) + overflow;
        if (m >= 60)
        {
            overflow = m / 60;
            m = m % 60;
        }
        
        h = (this.hour + duration.getHours()) + overflow;
        
        
        this.seconds = s; 
        this.minutes = m;
           this.hour = h;
    }
  
    @Override
    public int compareTo(Duration t) 
    {
       int a = 0;
       a = Integer.compare(this.hour, t.hour);
       if (a == 0)
       {
           a = Integer.compare(this.minutes, t.minutes);
           if ( a == 0)
           {
               a = Integer.compare(this.minutes, t.minutes);
           }
       }
       return a;
    }
}

