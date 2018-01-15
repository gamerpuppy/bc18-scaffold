import bc.GameController;
import bc.MapLocation;
import bc.Unit;

class Entity {

    static GameController gc = Player.get_gc();

    int id = 0;
    Loc loc = new Loc();

    void set(int id, MapLocation map_loc){
        loc.x = (short) map_loc.getX();
        loc.y = (short) map_loc.getY();
    }

    @Override
    public String toString() {
        return "Entity: "+id+" "+loc;
    }

    Unit unit(){
        return gc.unit(id);
    }

}
