class Loc {
    short x;
    short y;

    Loc(){
        x = 0;
        y = 0;
    }

    @Override
    public String toString() {
        return "x: "+x+" y: "+y;
    }
}
