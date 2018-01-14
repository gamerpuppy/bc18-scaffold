public class Debug {

    static void printMap(){
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < Map724.width; y++){
            for(int x = 0; x < Map724.height; x++){
                if (Map724.passable[x][y])
                    sb.append("  ");
                else
                    sb.append('X');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void printPassableAt(int x, int y){
        boolean passable = Map724.passable[x][y];
        System.out.println("X: "+x+" Y: "+y+"is "+(passable ? "" : "not ")+"passable");
    }

}
