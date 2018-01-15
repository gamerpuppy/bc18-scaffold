import bc.Unit;

class Bot extends Entity{

    short move_cd;
    short attack_cd;
    short active_cd;

    Bot() {
        super();
        move_cd = 0;
        attack_cd = 0;
        active_cd = 0;
    }

    void init(Unit unit) {
        super.init(unit);
            move_cd = (short) unit.movementHeat();
            attack_cd = (short) unit.attackHeat();
            active_cd = (short) unit.abilityHeat();
    }

    @Override
    public String toString() {
        return super.toString()
                +" movCd: "+move_cd
                +" atkCd: "+active_cd
                +" speCd: "+active_cd;
    }

}