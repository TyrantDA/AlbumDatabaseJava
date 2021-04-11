package albumdatabase;

import java.util.ArrayList;
import java.util.Collections;

public class AlbumCollection {

    String name;
    ArrayList<Album> album;

    public AlbumCollection() {
        name = null;
        album = new ArrayList();
    }

    public AlbumCollection(String n) {
        name = n;
        this.album = new ArrayList();
    }

    public void AddAlbum(Album a) {
        album.add(a);
    }

    public String toString() {

        StringBuilder collectionList = new StringBuilder();
        collectionList.append(name).append("\n");
        for (Album album : album) {
            collectionList.append(album.toString());
        }

        return collectionList.toString();
    }

    public void sort() {
        Collections.sort(album);
    }

    public void totalRunTime() {
        int a = 0, b = 0;
        ArrayList<Album> pink = new ArrayList();
        ArrayList<Duration> time = new ArrayList();
        String hold;
        // while loop finds all pink Floyd ablums and puts them in pink
        while (a <= album.size() - 1) {
            hold = album.get(a).artist;
            if (hold.equals("Pink Floyd")) {
                pink.add(album.get(a));
            }
            a++;
        }
        a = 0;
        // loop puts all durations of pink into time
        while (a <= pink.size() - 1) {
            while (b <= pink.get(a).tracks.size() - 1) {
                time.add(pink.get(a).tracks.get(b).duration);
                b++;
            }
            a++;
        }
        a = 0;
        b = 1;
        // adds all durations together 
        while (a < time.size() - 1) {
            time.get(0).add(time.get(b));
            a++;
            b++;
        }
        System.out.println(time.get(0));
    }

    public Album numberTrack() 
    {
        Album hold = new Album();
        int mostTracks = 0; 
        for (int a = 0; a <= album.size() - 1; a++) 
        {
            if (album.get(a).tracks.size() > mostTracks) 
            {
                mostTracks = album.get(a).tracks.size();
                hold = album.get(a);
            }
        }
        return hold;
    }
    
    public Track trackSort()
    {
        Track hold = new Track();
        Track temp = new Track();
        Duration c = new Duration();
        Duration d = new Duration();
        Duration largest = new Duration("00:00:00");
        int size;
        for (int a = 0; a <= album.size() - 1; a++) 
        {
           for (int b = 0; b < album.get(a).tracks.size() - 1; b++)
           {
               c =  album.get(a).tracks.get(b).duration;
               d = album.get(a).tracks.get(b + 1).duration;
               size = c.compareTo(d);
               if (size == 1)
               {
                   temp = album.get(a).tracks.get(b);
               }
               else if (size == -1)
               {
                   temp = album.get(a).tracks.get(b + 1);
               }
               size = largest.compareTo(temp.duration);
               if (size == -1)
               {
                   largest = temp.duration;
                   hold = temp;
               }
           }
        }
        return hold;
    }
    
    
    
    
}
