
import bc.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Path {


    ArrayList<Loc> locList;

    Path () {
        locList = new ArrayList<>();
    }

    Path (ArrayList<Loc> arr) {
        locList = arr;
    }

    static Path getPathBFS(Loc start, Loc finish){
        ArrayList<Loc> queue = new ArrayList<>();
        HashSet<Loc> visited = new HashSet<>();
        HashMap<Loc,Loc> map = new HashMap<>();

        queue.add(start);
        Loc cur = null;
        boolean found = false;
        while (!found) {
            if (queue.isEmpty())
                break;

            map.put(cur, queue.get(0));
            cur = queue.remove(0);
            visited.add(cur);

            for(Direction dir :Direction.values()){
                Loc loc = cur.locAt(dir);
                if (!Map.onMap(loc)) {
                    continue;
                } else if (loc.equals(finish)) {
                    found = true;
                    break;
                } else if (Map.pass[loc.x][loc.y] && !visited.contains(loc)) {
                    queue.add(loc);
                }
            }
        }

        Path path = new Path();
        path.locList.add(finish);

        while (cur != null){
            path.locList.add(cur);
            cur = map.get(cur);
        }
        return path;

    }



}