import bc.GameController;
import bc.Unit;
import bc.UnitType;

class Bot {

    static GameController gc = Player.get_gc();

    int id;
    boolean myTeam;
    short last_seen;
    short hp;
    UnitType type;
    Loc loc;
    short move_cd;
    short attack_cd;
    short active_cd;

    Bot() {
        id = 0;
        myTeam = true;
        last_seen = 0;
        hp = 0;
        type = UnitType.Ranger;
        loc = new Loc();
        move_cd = 0;
        attack_cd = 0;
        active_cd = 0;
    }

    void createBot(Unit unit) {
        id = unit.id();
        myTeam = (unit.team() == Player.team);
        last_seen = Player.turn;
        hp = (short) unit.health();
        type = unit.unitType();
        loc.x = (short) unit.location().mapLocation().getX();
        loc.y = (short) unit.location().mapLocation().getY();
        move_cd = (short) unit.movementHeat();
        attack_cd = (short) unit.attackHeat();
        active_cd = (short) unit.abilityHeat();
    }

    @Override
    public String toString() {
        return "id: "+id
                +" myTeam: "+myTeam
                +" seen: "+last_seen
                +" hp: "+hp
                +" type: "+type
                +" loc: "+loc
                +" movCd: "+move_cd
                +" atkCd: "+active_cd
                +" speCd: "+active_cd;
    }

    public Unit unit(){
        return gc.unit(id);
    }


}