import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;

class Debug {

    private static HashMap<String, Long> timers = new HashMap<>(50);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void printMap(){
        try {
            for (int y = 0; y < Map.height; y++) {
                for (int x = 0; x < Map.width; x++) {
                    if (Map.pass[x][y])
                        bw.write("  ");
                    else
                        bw.write("X");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e){}
    }

    static void showPath(Path path){
        HashSet<Loc> pathSet = new HashSet<>(path.locList);
        try {
            Loc loc = new Loc(0,0);
            for (loc.y = 0; loc.y < Map.height; loc.y++) {
                for (loc.x = 0; loc.x < Map.width; loc.x++) {
                    if(pathSet.contains(loc)) {
                        bw.write("P");
                    } else {
                        if (Map.pass[loc.x][loc.y])
                            bw.write("  ");
                        else
                            bw.write("X");
                    }
                }
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e){}
    }

    static void printPath(Path path){
        try {
            bw.write("Path Starting ->>>>>>>>>>>\n");
            for(int i = 0; i < path.locList.size(); i++) {
                bw.write(path.locList.get(i).toString());
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e){}
    }

    static void println(Object o){
        try {
            bw.write(o.toString());
            bw.newLine();
            bw.flush();
        } catch (Exception e){}
    }

    static void println(Object a, Object b){
        try {
            bw.write(a+"->"+b);
            bw.newLine();
            bw.flush();
        } catch (Exception e){}
    }

    static void startTime(String s){
        if(timers.get(s) == null)
            timers.put(s, System.nanoTime());
        else {
            try {
                bw.write("DEBUG_WARNING:("+s+")TIMER ALREADY EXISTS\n");
                bw.flush();
            } catch (Exception e){}
        }
    }

    static void endTime(String s){
        Long time = timers.get(s);
        try {
            if (time == null) {
                bw.write("DEBUG_WARNING:("+s+")TIMER WAS NOT STARTED\n");
            } else {
                bw.write(s+"->time(ms): "+(double)(System.nanoTime()-time)/1000000+'\n');
                timers.remove(s);
            }
            bw.flush();
        } catch (Exception e){}
    }

}
