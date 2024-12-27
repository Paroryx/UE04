class HouseChecker {
    static final int BUILDING_SIZE = 10;
    public static void main(String[] args) {
        
        char[][] ground = new char[BUILDING_SIZE][BUILDING_SIZE];
        char[][] first = new char[BUILDING_SIZE][BUILDING_SIZE];

        In.open("../data/ground.txt");
        for (int line = 0; line < BUILDING_SIZE; line++) {
            for (int col = 0; col < BUILDING_SIZE; col++) {
                ground[line][col] = In.readChar();
            }
            // col >= BUILDING_SIZE
        }
        // line >= BUILDING_SIZE
        In.close();
        In.open("first.txt");
        for (int line = 0; line < BUILDING_SIZE; line++) {
            for (int col = 0; col < BUILDING_SIZE; col++) {
                first[line][col] = In.readChar();
            }
            // col >= BUILDING_SIZE
        }
        // line >= BUILDING_SIZE
        In.close();

        for (int line = 0; line < BUILDING_SIZE; line++) {
            for (int col = 0; col < BUILDING_SIZE; col++) {
                if(first[line][col]=='W'){
                    boolean statement1 = false;
                    boolean statement2 = false;
                    boolean statement3 = false;
                    boolean statement4 = false;
                    boolean statement5 = false;

                    //neither Wall nor Door is directly under Wall
                    if (ground[line][col] == 'F')                           statement1 = true;

                    //neither Wall nor Door is col-1 under Wall
                    if (col-1 > 0 && ground[line][col-1] == 'F')            statement2 = true;

                    //neither Wall nor Door is col+1 under Wall
                    if (col+1<BUILDING_SIZE && ground[line][col+1] == 'F')  statement3 = true;

                    //neither Wall nor Door is line-1 under Wall
                    if (line-1 > 0 && ground[line-1][col] == 'F')           statement4 = true;

                    //neither Wall nor Door is line+1 under Wall
                    if (line+1<BUILDING_SIZE && ground[line+1][col] == 'F') statement5 = true;

                    if (statement1 && statement2 && statement3 && statement4 && statement5){
                        StringBuilder errormsg = new StringBuilder();
                        errormsg.append("Error at ");
                        errormsg.append(String.format("[%d, %d]:",line,col));
                        errormsg.append(" First floor WALL is not on or neighboring ground floor DOOR or WALL");
                        Out.println(errormsg.toString());
                    }

                }else if(first[line][col]=='D'){
                    //first[line][col]!='W' && first[line][col]=='D'
                    if(ground[line][col]=='F'){
                        StringBuilder errormsg = new StringBuilder();
                        errormsg.append("Error at ");
                        errormsg.append(String.format("[%d, %d]:",line,col));
                        errormsg.append(" First floor DOOR is not on ground floor DOOR or WALL");
                        Out.println(errormsg.toString());
                    }
                }
            }
            // col >= BUILDING_SIZE
        }
        // line >= BUILDING_SIZE
    }
}