import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Debug {

    static HashMap<String, Long> timers = new HashMap<>(50);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void printMap(){
        try {
            for (int y = 0; y < Map.width; y++) {
                for (int x = 0; x < Map.height; x++) {
                    if (Map.passable[x][y])
                        bw.write("  ");
                    else
                        bw.write('X');
                }
                bw.newLine();
            }

        } catch (Exception e){}
    }

    static void printPassableAt(int x, int y){
        try {
            boolean passable = Map.passable[x][y];
            bw.write("X: "+x+" Y: "+y+"is "+(passable ? "" : "not ")+"passable\n");
        } catch (Exception e){}

    }

    static void printBotInfo(Bot bot){
        try {
            bw.write(bot.toString());
            bw.newLine();
        } catch (Exception e){}
    }

    static void println(String s){
        try {
            bw.write(s);
            bw.newLine();
        } catch (Exception e){}
    }

    static void println(String desc, int val){
        try {
            bw.write(desc+"-> "+val);
            bw.newLine();
        } catch (Exception e){}
    }

    static void startTime(String s){
        if(timers.get(s) == null)
            timers.put(s, System.nanoTime());
        else {
            try {
                bw.write("DEBUG_WARNING:("+s+")TIMER ALREADY EXISTS\n");
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
        } catch (Exception e){}
    }

}
