
package albumdatabase;
import java.util.ArrayList;


public class Album implements Comparable <Album> 
{
    String artist;
    String title;
    ArrayList<Track> tracks; 

public Album()
{
    artist = null;
    title = null;
    tracks = new ArrayList();
}

public Album(String art, String t)
{
    artist = art;
    title = t;
    this.tracks = new ArrayList();
}

public void AddTrack(Track t)
{
    tracks.add(t);
}

public String toString()
{
    StringBuilder trackList = new StringBuilder();
    trackList.append(artist).append(" : ").append(title).append(System.lineSeparator());
    //append track, append line break. 
    for(Track track : tracks)
    {
        trackList.append(track.toString()).append(System.lineSeparator());
    }
    
    
    return trackList.toString();
}

    @Override
    public int compareTo(Album t) 
    {
        int a;
        a = this.artist.compareTo(t.artist);
        if (a == 0)
        {
            a = this.title.compareTo(t.title);
        }
        return a;
    }












    
}
