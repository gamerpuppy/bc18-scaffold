import bc.Direction;

class Loc {

    short x;
    short y;

    Loc(){
        x = 0;
        y = 0;
    }

    Loc(int x, int y){
        this.x = (short)x;
        this.y = (short)y;
    }


    @Override
    public String toString() {
        return "x: "+x+" y: "+y;
    }

    boolean isAdj(Loc loc){
        return loc.x - x >= -1 && loc.x - x <= 1
                && loc.y - y >= -1 && loc.y - y <= 1;
    }

    Loc locAt(Direction dir){
        Loc ret = new Loc(x,y);

        switch (dir) {
            case East: ret.x++; break;
            case West: ret.x--; break;
            case North: ret.y--; break;
            case South: ret.y++; break;
            case Northeast: ret.x++; ret.y--; break;
            case Northwest: ret.x--; ret.y--; break;
            case Southeast: ret.x++; ret.y++; break;
            case Southwest: ret.x--; ret.y++; break;
            default: break;
        }
        return ret;
    }

    Direction dirToAdj(Loc loc){
        if (x == loc.x) {
            if (y == loc.y)
                return Direction.Center;
            else if (y + 1 == loc.y)
                return Direction.South;
            else
                return Direction.North;
        } else if (x + 1 == loc.x) {
            if (y == loc.y)
                return Direction.East;
            else if (y + 1 == loc.y)
                return Direction.Southeast;
            else
                return Direction.Northeast;
        } else {
            if (y == loc.y)
                return Direction.West;
            else if (y + 1 == loc.y)
                return Direction.Southwest;
            else
                return Direction.Northwest;
        }
    }

}
