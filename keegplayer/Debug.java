import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Debug {

    static HashMap<String, Long> timers = new HashMap<>(50);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void printMap(){
        try {
            for (int y = 0; y < Map.width; y++) {
                for (int x = 0; x < Map.height; x++) {
                    if (Map.wall[x][y])
                        bw.write("X");
                    else
                        bw.write("  ");
                }
                bw.newLine();
            }

        } catch (Exception e){}
    }

    static void printBotInfo(Bot bot){
        try {
            bw.write(bot.toString());
            bw.newLine();
        } catch (Exception e){}
    }

    static void println(Object o){
        try {
            bw.write(o.toString());
            bw.newLine();
        } catch (Exception e){}
    }

    static void println(Object a, Object b){
        try {
            bw.write(a+"-> "+b);
            bw.newLine();
        } catch (Exception e){}
    }

    static void println(String desc, long val){
        try {
            bw.write(desc+"-> "+val);
            bw.newLine();
        } catch (Exception e){}
    }

    static void println(String desc, boolean bool){
        try {
            bw.write(desc+"-> "+bool);
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
