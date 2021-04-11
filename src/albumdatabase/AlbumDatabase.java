
package albumdatabase;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class AlbumDatabase {

    
    public static void test() 
    {
        int a = 5, b = 34, c = 15;
        System.out.println("Testing Duration program");
        System.out.println(" ");
    Duration duration = new Duration("3:43:32");
        System.out.println(duration.toString());
    Duration duration2 = new Duration(a, b, c);
        System.out.println(duration2.toString());
    duration.add(duration2);
        System.out.println(duration.toString());
        System.out.println(" ");
        System.out.println("Test complete");
        System.out.println(" ");
        
        System.out.println("Testing Track program");
        System.out.println(" ");
    Duration duration3 = new Duration("3:43:32");
        System.out.println(duration3.toString());
    Track track = new Track("Alex", duration3);
        System.out.println(track.toString());
        System.out.println("Test complete");
        System.out.println(" ");
        
        System.out.println("Testing Album program");
        System.out.println(" ");    
    Album album = new Album("Norris", "My Song");
    album.AddTrack(track);
        System.out.println(album.toString());
        System.out.println("Test complete");
        System.out.println(" ");
        
        System.out.println("Testing Album Collection program");
        System.out.println(" ");
    AlbumCollection collection = new AlbumCollection("My first collection");
    collection.AddAlbum(album);
        System.out.println(collection.toString());
        System.out.println("Test complete");
        System.out.println(" ");
    }
    
    
    public static void main(String[] args) throws java.io.IOException 
    {
        Scanner scanner = new Scanner(System.in);
        String enter, ac;
        String albumLine = null; 
        ArrayList<String> tracks = new ArrayList();
        int a = 0;
        Album large = new Album();
        Track big = new Track();
        
        System.out.println("please enter Test to test the program or enter Add to create a new Album Collection");
        enter = scanner.nextLine();
        
        if (enter.equals("Test") || enter.equals("test"))
        {
            test();
        }
        else if (enter.equals("Add") || enter.equals("add"))
        {
            System.out.println(" ");
            System.out.println("Please enter Album Collection name");
            ac = scanner.nextLine();
            AlbumCollection collection = new AlbumCollection(ac);
        
            BufferedReader in =  new BufferedReader( new FileReader("album.txt")); //this does not work
    
            String line = in.readLine();
            if (!Character.isDigit(line.charAt(0))) 
                {
                    albumLine = line;
                }
            else {throw new IllegalArgumentException("Incorrectly formated file");}
            
            
            while((line = in.readLine()) != null)
            {
                 String[] splitAlbum = albumLine.split(" : ");
                 Album album = new Album(splitAlbum[0], splitAlbum[1]);
                 
                if (Character.isDigit(line.charAt(0))) 
                {
                    tracks.add(line);
                }
                else 
                { 
                    while ( a <= tracks.size() - 1)
                    {
                         String[] splitTracks = tracks.get(a).split(" - ");
                         Duration duration = new Duration(splitTracks[0]);
                         Track track = new Track(splitTracks[1], duration);
                         album.AddTrack(track);
                         a++;
                    }
                    collection.AddAlbum(album);
                    albumLine = line;
                }
            }
            System.out.println(" ");
            System.out.println("If you would like to view the added Collection enter View or if you would like to sort the Collection enter Sort");
            enter = scanner.nextLine();
            
            if (enter.equals("View") || enter.equals("view"))
            {
                System.out.println(" ");
                System.out.println(collection.toString());
            }
            else if (enter.equals("Sort") || enter.equals("sort"))
            {
                collection.sort();
                System.out.println(" ");
                System.out.println(collection.toString()); 
            }
            
            System.out.println(" ");
            System.out.println("would you like to see the total run time of Pink folds ablums. Yes or No");
            enter = scanner.nextLine();
            
            if (enter.equals("Yes") || enter.equals("yes"))
            {
                collection.totalRunTime();
                
            }
            else if (enter.equals("No") || enter.equals("no"))
            {
                System.out.println("To bad");       
            }
            
            System.out.println(" ");
            System.out.println("would you like to see the album with the largest number Of tracks. Yes or No");
            enter = scanner.nextLine();
            
             if (enter.equals("Yes") || enter.equals("yes"))
            {
                large = collection.numberTrack();
                System.out.println(large.toString());
                
            }
            else if (enter.equals("No") || enter.equals("no"))
            {
                System.out.println("To bad");       
            }
             
            System.out.println(" ");
             System.out.println("would you like to the longest track in the collection. Yes or No");
            enter = scanner.nextLine();
            
             if (enter.equals("Yes") || enter.equals("yes"))
            {
                big = collection.trackSort();
                System.out.println(big.toString());
            }
            else if (enter.equals("No") || enter.equals("no"))
            {
                System.out.println("To bad");       
            }
        }
    }
}
