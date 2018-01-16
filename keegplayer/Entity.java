import bc.*;

class Entity {

    static GameController gc = Player.get_gc();

    int id = 0;
    short seen = -1;
    short hp = 0;
    Loc loc = new Loc();
    UnitType type = UnitType.Ranger;
    boolean myTeam = false;
    boolean dead = false;

    @Override
    public String toString() {
        return "Entity:"+id+","+loc+","+type+","+seen+","+hp;
    }

    Unit unit(){
        return gc.unit(id);
    }

}
