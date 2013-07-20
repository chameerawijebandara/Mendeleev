/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * 
 *  0 North
 *  1 East
 *  2 South 
 *  3 West 
 *
 * -------------------(palyer+1)*10+side  ----- IMPORTENT
 * Brick 4,3,2,1--- 4 - no damage 
 * Stone 5
 * Water 6
 * life = -2
 * coin = -1
 */
package ProgrammingChallenge2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wijebandara
 */
public class AI implements Observer, Runnable {

    private int gotCoins = 0;
    private int timeCounter = 0;
    private int gridLenth = 0;
    private int players = 1;
    private int data[][];
    private int initData[][];
    private int mendeleev = 10;
    private Player team[];
    private static String requst = "RIGHT#";
    private java.util.ArrayList<Coin> coins;
    private java.util.ArrayList<LifePack> lifes;
    private java.util.LinkedList<Cell> path;
    private int pathCount = 0;
    private boolean isKilled[];

    public AI() {
        System.out.println("\007");
        readPropFile();
        data = new int[gridLenth][gridLenth];
        initData = new int[gridLenth][gridLenth];
        team = new Player[players];
        coins = new java.util.ArrayList<Coin>();
        lifes = new java.util.ArrayList<LifePack>();
        path = new java.util.LinkedList<Cell>();
        isKilled = new boolean[players];
    }

    @Override
    public void run() {
        cal();

    }

    @Override
    public void update(Observable o, Object arg) {
        Thread thread = new Thread(this);
        thread.start();
    }

    private void cal() {
        responsHandler(Communicator.getMessage());
    }

    private void printData() {
        for (int i = 0; i < gridLenth; i++) {
            for (int j = 0; j < gridLenth; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    int responsHandler(String input) {
        //System.out.println(input);
        if (input == null) {
            return -1;
        }
        switch (input.charAt(0)) {

            case 'S':   //S:P<num>: < player location  x>,< player location  y>:<Direction>#
                initMendeleev(input);
                new RequestHandler().start();
                break;

            case 'I':
                switch (input.charAt(1)) {
                    case ':':
                        initGrid(input);
                        break;

                    case 'N':   //INVALID_CELL#  
                        System.out.println("INVALID_CELL");
                        System.out.println("NEVER_HAPPEN");
                        break;
                }
                break;

            case 'G':

                if (input.charAt(1) == ':') {
                    genaralInput(input);
                    go();

                    break;
                }
                switch (input.charAt(5)) {
                    case 'N':    //GAME_NOT_STARTED_YET#
                        System.out.println("GAME_NOT_STARTED_YET");
                        break;

                    case 'H':   //GAME_HAS_FINISHED#            
                    case 'A':    //GAME_ALREADY_STARTED#
                        System.out.println("GOOD_BYE...");
                        System.exit(0);
                        break;
                }
                break;
            case 'C':
                if (input.charAt(1) == ':') {
                    coin(input);
                    break;
                }
                //CELL_OCCUPIED#
                System.out.println("CELL_OCCUPIED");
                System.out.println("NEVER_HAPPEN");
                break;
            case 'L':
                life(input);
                break;

            case 'P':   //PLAYERS_FULL#
                System.out.println("PLAYERS_FULL");
                RequestHandler.send("JOIN#");
                break;


            case 'A':   //ALREADY_ADDED#
                System.out.println("ALREADY_ADDED");
                break;

            case 'T':   //TOO_QUICK#
                System.out.println("TOO_QUICK");

                break;

            case 'O':   //OBSTACLE#                   
            case 'N':   //NOT_A_VALID_CONTESTANT#
                System.out.println("NOT_A_VALID_CONTESTANT");
                System.out.println("NEVER_HAPPEN");
                break;

            case 'D':   //DEAD# 
                System.out.println("THANK_YOU_FOR_VISIT_MENDELEEV");
                System.out.println("GOOD_BYE...");
                System.exit(0);
                break;
            default:
                System.out.println("NO...");
        }
        return 0;
    }

    private void genaralInput(String in) //G:P0;0,0;0;1;100;0;0:P1;0,9;0;0;100;0;0:P2;9,0;0;0;100;0;0:P3;9,9;0;0;100;0;0:P4;5,5;0;0;100;0;0:9,2,0;6,8,0#
    {
        //System.out.println("Count : " + timeCounter);
        java.util.StringTokenizer st = new java.util.StringTokenizer(in, ":");
        st.nextToken();
        String s = st.nextToken();
        java.util.StringTokenizer st1, st2;

        for (int i = 0; i < gridLenth; i++) {
            System.arraycopy(initData[i], 0, data[i], 0, gridLenth);
        }

        while (s.charAt(0) == 'P') {
            st1 = new java.util.StringTokenizer(s, ";");
            int h = (st1.nextToken().charAt(1) - 47) * 10; //player
            st2 = new java.util.StringTokenizer(st1.nextToken(), ",");

            int a = Integer.parseInt(st2.nextToken());  //player location  x 
            int b = Integer.parseInt(st2.nextToken());  //player location  y


            int c = Integer.parseInt(st1.nextToken());  //Direction



            int d = Integer.parseInt(st1.nextToken());  //whether shot
            int e = Integer.parseInt(st1.nextToken());  //health
            int f = Integer.parseInt(st1.nextToken());  //coins
            int g = Integer.parseInt(st1.nextToken());  //points

            if (e != 0) {
                data[b][a] = h;
            } else if (!isKilled[h / 10 - 1]) {
                coin("C:" + Integer.toString(a) + "," + Integer.toString(b) + ":1000000:1000#");
                isKilled[h / 10 - 1] = true;
            }
            team[h / 10 - 1].update(h / 10 - 1, a, b, c, d, e, f, g);
            s = st.nextToken();
        }
        st1 = new java.util.StringTokenizer(s.substring(0, s.length() - 1), ";");
        while (st1.hasMoreTokens()) {
            st2 = new java.util.StringTokenizer(st1.nextToken(), ",");
            int a = Integer.parseInt(st2.nextToken());  //location  x 
            int b = Integer.parseInt(st2.nextToken());  //location  y

            int c = Integer.parseInt(st2.nextToken());  // damage
            data[b][a] = 4 - c;
        }

        for (int i = 0; i < coins.size(); i++) {// remove expired coins 
            if (coins.get(i).ETime <= timeCounter) {
                Coin h = coins.remove(i);
                i--;
                data[h.y][h.x] = 0;
                initData[h.y][h.x] = 0;
                data[h.y][h.x] = 0;
            } else {
                // remove coins which got by oposits

                if (data[coins.get(i).y][coins.get(i).x] > 0) {
                    Coin h = coins.remove(i);
                    i--;
                    initData[h.y][h.x] = 0;
                    data[h.y][h.x] = 0;
                }

            }
        }

        for (int i = 0; i < lifes.size(); i++) {// remove expired Lifes 
            if (lifes.get(i).ETime <= timeCounter) {
                LifePack h = lifes.remove(i);
                i--;
                data[h.y][h.x] = 0;
                initData[h.y][h.x] = 0;
                data[h.y][h.x] = 0;
            } else {
                // remove lifes which got by oposits
                if (data[lifes.get(i).y][lifes.get(i).x] > 0) {
                    LifePack h = lifes.remove(i);
                    i--;
                    initData[h.y][h.x] = 0;
                    data[h.y][h.x] = 0;
                }
            }

        }
        timeCounter++;
    }

    private void life(String in) //L:<x>,<y>:<LT>#
    {
        java.util.StringTokenizer st = new java.util.StringTokenizer(in.substring(0, in.length() - 1), ":");
        st.nextToken();
        java.util.StringTokenizer st1 = new java.util.StringTokenizer(st.nextToken(), ",");
        int a = Integer.parseInt(st1.nextToken());   //x
        int b = Integer.parseInt(st1.nextToken());   //y

        int c = Integer.parseInt(st.nextToken()) / 1000;    //time

        lifes.add(new LifePack(a, b, timeCounter, timeCounter + c));
        initData[b][a] = -2;
    }

    private void coin(String in) {   //C:<x>,<y>:<LT>:<Val>#
        System.out.println(in);
        java.util.StringTokenizer st = new java.util.StringTokenizer(in.substring(0, in.length() - 1), ":");
        st.nextToken();
        java.util.StringTokenizer st1 = new java.util.StringTokenizer(st.nextToken(), ",");
        int a = Integer.parseInt(st1.nextToken());   //x
        int b = Integer.parseInt(st1.nextToken());   //y

        int c = Integer.parseInt(st.nextToken()) / 1000;    //time
        int d = Integer.parseInt(st.nextToken());   //value

        coins.add(new Coin(a, b, timeCounter, timeCounter + c, d));
        initData[b][a] = -1;

    }

    private void initMendeleev(String in) {      //S:P1; 1,1;0#
        //S:P0;0,0;0:P1;0,19;0:P2;19,0;0:P3;19,19;0:P4;5,5;0#


        java.util.StringTokenizer st = new java.util.StringTokenizer(in, ":");
        st.nextToken();
        java.util.StringTokenizer st1, st2;
        while (st.hasMoreTokens()) {
            st1 = new java.util.StringTokenizer(st.nextToken(), ";");

            int a = st1.nextToken().charAt(1) - 48;

            st2 = new java.util.StringTokenizer(st1.nextToken(), ",");

            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            int d = st1.nextToken().charAt(0) - 48;

            team[a] = new Player(a, b, c, d, 0, 0, 0, 0);

        }

    }

    private void initGrid(String in) //I:P0:1,3;3,2;0,4:8,6;0,8;2,3;7,1;3,8;2,4;3,1;3,6:4,8;6,8;1,4;9,8;7,2;8,4;7,6;8,1;5,3;2,1#
    {
        java.util.StringTokenizer st = new java.util.StringTokenizer(in.substring(0, in.length() - 1), ":");
        java.util.StringTokenizer st1, st2;
        st.nextToken();

        mendeleev = (st.nextToken().charAt(1) - 47) * 10;
        for (int i = 4; i < 7; i++) {
            st1 = new java.util.StringTokenizer(st.nextToken(), ";");
            while (st1.hasMoreTokens()) {
                st2 = new java.util.StringTokenizer(st1.nextToken(), ",");
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());

                initData[b][a] = i;
            }

        }

    }

    private void readPropFile() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        gridLenth = Integer.parseInt(prop.getProperty("MapSize"));
        players = 2;//Integer.parseInt(prop.getProperty("Players"));
    }

    synchronized public static String getRequest() {
        String hold = requst;
        requst = "SHOOT#";
        return hold;
    }

    synchronized public static void putRequest(String in) {
        requst = in;
    }

    private void CoinCollectoer() {

        int x = team[mendeleev / 10 - 1].location_x;
        int y = team[mendeleev / 10 - 1].location_y;
        int i = 0;
        int minDis = 5;
        if (team[mendeleev / 10 - 1].health > 40) {

            switch (team[mendeleev / 10 - 1].direction) {
                case 0:
                    i = y - 1;
                    while (i >= 0 && y - i < minDis) {

                        if (data[i][x] > 9) {
                            return;
                        }
                        if (data[i][x] > 0) {
                            break;
                        }
                        i--;
                    }
                    break;
                case 1:
                    i = x + 1;
                    while (i < gridLenth && i - x < minDis) {
                        if (data[y][i] > 9) {
                            return;
                        }
                        if (data[y][i] > 0) {
                            break;
                        }
                        i++;
                    }

                    break;
                case 2:

                    i = y + 1;
                    while (i < gridLenth && i - y < minDis) {
                        if (data[i][x] > 9) {
                            return;
                        }
                        if (data[i][x] > 0) {
                            break;
                        }
                        i++;
                    }
                    break;
                case 3:
                    i = x - 1;
                    while (i >= 0 && x - i < minDis) {
                        if (data[y][i] > 9) {
                            return;
                        }
                        if (data[y][i] > 0) {
                            break;
                        }
                        i--;
                    }

                    break;
            }
        }
        BreadthFirstSearchEnhansed b = new BreadthFirstSearchEnhansed(data);
        String s = "SHOOT#";
        boolean w=true;
        for (int j = 0; j < players; j++) {
            if(!isKilled[j])
            {
                w=false;
            }
        }
        if(w)
        {
            
            //s = b.LetsCollectCoins(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, -1, -1, coins, lifes, timeCounter);
            s = b.AICollect(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, coins, lifes, timeCounter);
        }
        else
        {
            if (coins.isEmpty() && lifes.isEmpty()) {
                letsKill();
            } else if (coins.isEmpty()) {
                s = b.LetsCollectCoins(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, -2, -2, coins, lifes, timeCounter);
            } else {
                if (team[mendeleev / 10 - 1].health < 40) {
                    s = b.LetsCollectCoins(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, -2, -2, coins, lifes, timeCounter);
                } else if (team[mendeleev / 10 - 1].health > 150) {
                    s = b.AICollect(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, coins, lifes, timeCounter);
                    // s = b.LetsCollectCoins(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, -1, -1, coins, lifes, timeCounter);
                } else {
                    s = b.AICollect(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, coins, lifes, timeCounter);
                    // s = b.LetsCollectCoins(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, team[mendeleev / 10 - 1].direction, -1, -2, coins, lifes, timeCounter);
                }
            }
        }
        putRequest(s);
    }

    private void go() {
        int x = team[mendeleev / 10 - 1].location_x;
        int y = team[mendeleev / 10 - 1].location_y;
        int i = 0;
        int minDis = 10;
        boolean isInTrouble[]=new boolean[3];

            switch (team[mendeleev / 10 - 1].direction) {
                case 0:
                    i = y - 1;
                    while (i >= 0 && y - i < minDis) {

                        if (data[i][x] > 9 && team[data[i][x]/10-1].isShot==1) {
                            isInTrouble[0]=true;
                            break;
                        }
                        if (data[i][x] > 0 && data[i][x]!=6) {
                            break;
                        }
                        i--;
                    }
                    break;
                case 1:
                    i = x + 1;
                    while (i < gridLenth && i - x < minDis) {
                        if (data[y][i] > 9 && team[data[y][i]/10-1].isShot==1) {
                            isInTrouble[0]=true;
                            break;
                        }
                        if (data[y][i] > 0 && data[y][i]!=6) {
                            break;
                        }
                        i++;
                    }

                    break;
                case 2:

                    i = y + 1;
                    while (i < gridLenth && i - y < minDis) {
                        if (data[i][x] > 9 && team[data[i][x]/10-1].isShot==1) {
                            isInTrouble[0]=true;
                            break;
                        }
                        if (data[i][x] > 0 && data[i][x]!=6) {
                            break;
                        }
                        i++;
                    }
                    break;
                case 3:
                    i = x - 1;
                    while (i >= 0 && x - i < minDis) {
                        if (data[y][i] > 9 && team[data[y][i]/10-1].isShot==1) {
                            isInTrouble[0]=true;
                            break;
                        }
                        if (data[y][i] > 0 && data[y][i]!=6) {
                            break;
                        }
                        i--;
                    }

                    break;
            
        }
/*
 * Write hear fire defend code
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             * 
             *  
             * 
             * 
             *  
             * 
             * 
             * 
             * 
 */
  
        if (timeCounter < 200) {
            for (int j = 0; j < players; j++) {
                if (team[j].number != mendeleev / 10 - 1 && team[j].health != 0) {
                    letsKill();
                    System.out.println("kill...");
                    return;
                }
            }
        }
        System.out.println("Collect...");
        CoinCollectoer();
    }

    private void letsKill() {

        int x = team[mendeleev / 10 - 1].location_x;
        int y = team[mendeleev / 10 - 1].location_y;
        int i = 0;
        int minDis = 10;
        if (team[mendeleev / 10 - 1].health > 40) {

            switch (team[mendeleev / 10 - 1].direction) {
                case 0:
                    i = y - 1;
                    while (i >= 0 && y - i < minDis) {

                        if (data[i][x] > 9) {
                            return;
                        }
                        if (data[i][x] > 0 && data[i][x]!=6) {
                            break;
                        }
                        i--;
                    }
                    break;
                case 1:
                    i = x + 1;
                    while (i < gridLenth && i - x < minDis) {
                        if (data[y][i] > 9) {
                            return;
                        }
                        if (data[y][i] > 0 && data[y][i]!=6) {
                            break;
                        }
                        i++;
                    }

                    break;
                case 2:

                    i = y + 1;
                    while (i < gridLenth && i - y < minDis) {
                        if (data[i][x] > 9) {
                            return;
                        }
                        if (data[i][x] > 0 && data[i][x]!=6) {
                            break;
                        }
                        i++;
                    }
                    break;
                case 3:
                    i = x - 1;
                    while (i >= 0 && x - i < minDis) {
                        if (data[y][i] > 9) {
                            return;
                        }
                        if (data[y][i] > 0 && data[y][i]!=6) {
                            break;
                        }
                        i--;
                    }

                    break;
            }
        }

        BreadthFirstSearchEnhansed b = new BreadthFirstSearchEnhansed(data);
        String s = b.LetsKillSomeBitches(team[mendeleev / 10 - 1].location_x, team[mendeleev / 10 - 1].location_y, 0, team[mendeleev / 10 - 1].direction,team);
        putRequest(s);
    }
}
