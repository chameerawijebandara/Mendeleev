/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingChallenge2;

/**
 *
 * @author wijebandara
 */
public class BreadthFirstSearchEnhansed {

    private int[][] data;
    private int[][] d;
    private Cell[][] pi;
    private int[][] state;
    private int size;
    private String ans;

    BreadthFirstSearchEnhansed(int data[][]) {
        this.size = data.length;
        this.data = new int[size][size];
        this.data = data;
        this.d = new int[size][size];
        this.pi = new Cell[size][size];
        this.state = new int[size][size];
        ans = "SHOOT#";

    }

    private int calCost(int x1, int y1, int dir, int x2, int y2) {
        java.util.LinkedList<Cell> q = new java.util.LinkedList<Cell>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                state[i][j] = -1;
                d[i][j] = 0;
            }
        }
        q.add(new Cell(x1, y1));
        state[y1][x1] = 0;
        pi[y1][x1] = new Cell(-1, -1);

        while (q.size() != 0) {
            int min = Integer.MAX_VALUE;
            int h = 0;
            for (int i = 0; i < q.size(); i++) {
                if (d[q.get(i).y][q.get(i).x] < min) {
                    min = d[q.get(i).y][q.get(i).x];
                    h = i;
                }
            }
            Cell hold = q.remove(h);
            if (hold.x == x2 && hold.y == y2) {
                return d[hold.y][hold.x];
            }
            int hx = hold.x - 1;
            int hy = hold.y;

            if (hx >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x1 && hold.y == y1) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x - 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;
            }

            hx = hold.x + 1;
            hy = hold.y;

            if (hx < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x1 && hold.y == y1) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x + 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }

                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;
            }

            hx = hold.x;
            hy = hold.y - 1;

            if (hy >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x1 && hold.y == y1) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y - 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);

                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }

                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;
            }

            hx = hold.x;
            hy = hold.y + 1;

            if (hy < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x1 && hold.y == y1) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y + 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }

                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;
            }
            state[hold.y][hold.x] = 1;
        }
        return 1;
    }

    public String AICollect(int x, int y, int dir, java.util.ArrayList<Coin> coins, java.util.ArrayList<LifePack> lifes, int time) {
        float hold[][] = new float[size][size];
        int hold1[][] = new int[size][size];
        for (int i = 0; i < coins.size(); i++) {
            hold1[coins.get(i).y][coins.get(i).x] = 1;
            for (int j = 0; j < coins.size(); j++) {
                if (i == j) {
                    int k = calCost(x, y, dir, coins.get(j).x, coins.get(j).y) + 1;
                    if ((time + k) <= coins.get(j).ETime) {
                        hold[coins.get(j).y][coins.get(j).x] += (float) coins.get(i).value / (k * 500);


                    }
                } else {
                    int k = calCost(coins.get(j).x, coins.get(j).y, dir, coins.get(i).x, coins.get(i).y) + 1;
                    int l = calCost(x, y, dir, coins.get(j).x, coins.get(j).y);
                    if ((time + k + l) <= coins.get(i).ETime) {

                        hold[coins.get(j).y][coins.get(j).x] += (float) (coins.get(i).value / ((k + l) * 500));
                    }
                }
            }
        }

        for (int i = 0; i < lifes.size(); i++) {
            hold1[lifes.get(i).y][lifes.get(i).x] = 1;
            for (int j = 0; j < lifes.size(); j++) {
                if (i == j) {
                    int k = calCost(x, y, dir, lifes.get(j).x, lifes.get(j).y + 1);
                    if ((time + k) <= lifes.get(j).ETime) {
                        hold[lifes.get(j).y][lifes.get(j).x] += 0.1 / k;
                    }
                } else {
                    int k = calCost(lifes.get(j).x, lifes.get(j).y, dir, lifes.get(i).x, lifes.get(i).y);
                    int l = calCost(x, y, dir, lifes.get(j).x, lifes.get(j).y);
                    if ((time + k + l) <= lifes.get(j).ETime) {
                        hold[lifes.get(j).y][lifes.get(j).x] += 0.1 / (k + l);
                    }
                }
            }

        }

        float max = 0;
        int xm = 0, ym = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                hold[i][j] = hold[i][j] * hold1[i][j];
                if (max < hold[i][j]) {
                    max = hold[i][j];
                    xm = i;
                    ym = j;
                }
            }
        }
        return gotoPointx(x, y, dir, ym, xm);



    }

    public String LetsCollectCoins(int x, int y, int dir, int coin, int life, java.util.ArrayList<Coin> coins, java.util.ArrayList<LifePack> lifes, int time) {
        java.util.LinkedList<Cell> q = new java.util.LinkedList<Cell>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                state[i][j] = -1;
                d[i][j] = 0;
            }
        }
        q.add(new Cell(x, y));
        state[y][x] = 0;
        pi[y][x] = new Cell(-1, -1);

        while (q.size() != 0) {
            int min = Integer.MAX_VALUE;
            int h = 0;
            for (int i = 0; i < q.size(); i++) {
                if (d[q.get(i).y][q.get(i).x] < min) {
                    min = d[q.get(i).y][q.get(i).x];
                    h = i;
                }
            }
            Cell hold = q.remove(h);

            int hx = hold.x - 1;
            int hy = hold.y;

            if (hx >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x && hold.y == y) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x - 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }

                state[hy][hx] = 0;

                if (data[hy][hx] == coin || data[hy][hx] == life) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();
                    boolean isok = false;

                    if (data[hy][hx] == -1) {
                        for (int i = 0; i < coins.size(); i++) {
                            if (coins.get(i).x == hx && coins.get(i).y == hy && coins.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                                break;
                            }
                        }
                    } else {
                        for (int i = 0; i < lifes.size(); i++) {
                            if (lifes.get(i).x == hx && lifes.get(i).y == hy && lifes.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                                break;
                            }
                        }
                    }

                    if (!isok) {
                        Cell holdCell = new Cell(hx, hy);

                        while (pi[holdCell.y][holdCell.x].x != -1) {
                            l.addFirst(holdCell);
                            holdCell = pi[holdCell.y][holdCell.x];
                        }
                        l.addFirst(holdCell);

                        if (l.get(1).x == l.get(0).x + 1) {
                            ans = "RIGHT#";

                        } else if (l.get(1).x == l.get(0).x - 1) {
                            ans = "LEFT#";

                        } else if (l.get(1).y == l.get(0).y + 1) {
                            ans = "DOWN#";

                        } else {
                            ans = "UP#";

                        }
                        return ans;

                    }
                }

            }

            hx = hold.x + 1;
            hy = hold.y;

            if (hx < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x && hold.y == y) {
                    if (dir == 1) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x + 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (data[hy][hx] == coin || data[hy][hx] == life) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();
                    boolean isok = false;

                    if (data[hy][hx] == -1) {
                        for (int i = 0; i < coins.size(); i++) {
                            if (coins.get(i).x == hx && coins.get(i).y == hy && coins.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                            }
                        }
                    } else {
                        for (int i = 0; i < lifes.size(); i++) {
                            if (lifes.get(i).x == hx && lifes.get(i).y == hy && lifes.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                            }
                        }
                    }

                    if (!isok) {
                        Cell holdCell = new Cell(hx, hy);

                        while (pi[holdCell.y][holdCell.x].x != -1) {
                            l.addFirst(holdCell);
                            holdCell = pi[holdCell.y][holdCell.x];
                        }
                        l.addFirst(holdCell);

                        if (l.get(1).x == l.get(0).x + 1) {
                            ans = "RIGHT#";

                        } else if (l.get(1).x == l.get(0).x - 1) {
                            ans = "LEFT#";

                        } else if (l.get(1).y == l.get(0).y + 1) {
                            ans = "DOWN#";

                        } else {
                            ans = "UP#";

                        }
                        return ans;
                    }
                }

            }


            hx = hold.x;
            hy = hold.y - 1;

            if (hy >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 0) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y - 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (data[hy][hx] == coin || data[hy][hx] == life) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();
                    boolean isok = false;

                    if (data[hy][hx] == -1) {
                        for (int i = 0; i < coins.size(); i++) {
                            if (coins.get(i).x == hx && coins.get(i).y == hy && coins.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                            }
                        }
                    } else {
                        for (int i = 0; i < lifes.size(); i++) {
                            if (lifes.get(i).x == hx && lifes.get(i).y == hy && lifes.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                            }
                        }
                    }

                    if (!isok) {
                        Cell holdCell = new Cell(hx, hy);

                        while (pi[holdCell.y][holdCell.x].x != -1) {
                            l.addFirst(holdCell);
                            holdCell = pi[holdCell.y][holdCell.x];
                        }
                        l.addFirst(holdCell);

                        if (l.get(1).x == l.get(0).x + 1) {
                            ans = "RIGHT#";

                        } else if (l.get(1).x == l.get(0).x - 1) {
                            ans = "LEFT#";

                        } else if (l.get(1).y == l.get(0).y + 1) {
                            ans = "DOWN#";

                        } else {
                            ans = "UP#";

                        }
                        return ans;
                    }
                }
            }



            hx = hold.x;
            hy = hold.y + 1;

            if (hy < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 2) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y + 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (data[hy][hx] == coin || data[hy][hx] == life) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();
                    boolean isok = false;

                    if (data[hy][hx] == -1) {
                        for (int i = 0; i < coins.size(); i++) {
                            if (coins.get(i).x == hx && coins.get(i).y == hy && coins.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                            }
                        }
                    } else {
                        for (int i = 0; i < lifes.size(); i++) {
                            if (lifes.get(i).x == hx && lifes.get(i).y == hy && lifes.get(i).ETime - time < d[hy][hx] + 2) {
                                isok = true;
                            }
                        }
                    }

                    if (!isok) {
                        Cell holdCell = new Cell(hx, hy);

                        while (pi[holdCell.y][holdCell.x].x != -1) {
                            l.addFirst(holdCell);
                            holdCell = pi[holdCell.y][holdCell.x];
                        }
                        l.addFirst(holdCell);

                        if (l.get(1).x == l.get(0).x + 1) {
                            ans = "RIGHT#";

                        } else if (l.get(1).x == l.get(0).x - 1) {
                            ans = "LEFT#";

                        } else if (l.get(1).y == l.get(0).y + 1) {
                            ans = "DOWN#";

                        } else {
                            ans = "UP#";

                        }
                        return ans;
                    }
                }
            }
            state[hold.y][hold.x] = 1;
        }
        return ans;
    }

    public String LetsKillSomeBitches(int x, int y, int py, int dir, Player[] team) {
        java.util.LinkedList<Cell> q = new java.util.LinkedList<Cell>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                state[i][j] = -1;
                d[i][j] = 0;
            }
        }
        q.add(new Cell(x, y));
        state[y][x] = 0;
        pi[y][x] = new Cell(-1, -1);

        while (q.size() != 0) {
            int min = Integer.MAX_VALUE;
            int h = 0;
            for (int i = 0; i < q.size(); i++) {
                if (d[q.get(i).y][q.get(i).x] < min) {
                    min = d[q.get(i).y][q.get(i).x];
                    h = i;
                }
            }
            Cell hold = q.remove(h);

            int hx = hold.x - 1;
            int hy = hold.y;

            if (hx >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x && hold.y == y) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x - 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }

                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (data[hy][hx] > 9) {
                    int p = data[hy][hx] / 10 - 1;

                    if (team[p].direction == 0) {
                        if (hy - 1 >= 0) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 2) {
                        if (hy + 1 < data.length) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 1) {
                        if (hx + 1 < data.length) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 3) {
                        if (hx - 1 >= 0) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }

                }

            }

            hx = hold.x + 1;
            hy = hold.y;

            if (hx < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x && hold.y == y) {
                    if (dir == 1) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x + 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }

                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (data[hy][hx] > 9) {
                    int p = data[hy][hx] / 10 - 1;

                    if (team[p].direction == 0) {
                        if (hy - 1 >= 0) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 2) {
                        if (hy + 1 < data.length) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 1) {
                        if (hx + 1 < data.length) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 3) {
                        if (hx - 1 >= 0) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }
                    return ans;
                }


            }


            hx = hold.x;
            hy = hold.y - 1;

            if (hy >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 0) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y - 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (data[hy][hx] > 9) {
                    int p = data[hy][hx] / 10 - 1;

                    if (team[p].direction == 0) {
                        if (hy - 1 >= 0) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 2) {
                        if (hy + 1 < data.length) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 1) {
                        if (hx + 1 < data.length) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 3) {
                        if (hx - 1 >= 0) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }
                    return ans;
                }

            }



            hx = hold.x;
            hy = hold.y + 1;

            if (hy < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 2) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y + 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (data[hy][hx] > 9) {
                    int p = data[hy][hx] / 10 - 1;

                    if (team[p].direction == 0) {
                        if (hy - 1 >= 0) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 2) {
                        if (hy + 1 < data.length) {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointy(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 1) {
                        if (hx + 1 < data.length) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }
                    if (team[p].direction == 3) {
                        if (hx - 1 >= 0) {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        } else {
                            ans = gotoPointx(x, y, dir, hx, hy);
                        }
                    }
                    return ans;
                }


            }
            state[hold.y][hold.x] = 1;
        }
        return ans;
    }

    public String gotoPointx(int x, int y, int dir, int x1, int y1) {
        java.util.LinkedList<Cell> q = new java.util.LinkedList<Cell>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                state[i][j] = -1;
                d[i][j] = 0;
            }
        }
        q.add(new Cell(x, y));
        state[y][x] = 0;
        pi[y][x] = new Cell(-1, -1);

        while (q.size() != 0) {
            int min = Integer.MAX_VALUE;
            int h = 0;
            for (int i = 0; i < q.size(); i++) {
                if (d[q.get(i).y][q.get(i).x] < min) {
                    min = d[q.get(i).y][q.get(i).x];
                    h = i;
                }
            }
            Cell hold = q.remove(h);

            int hx = hold.x - 1;
            int hy = hold.y;

            if (hx >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x && hold.y == y) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x - 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();
                    Cell holdCell = new Cell(hx, hy);
                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;


                }

            }

            hx = hold.x + 1;
            hy = hold.y;

            if (hx < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x && hold.y == y) {
                    if (dir == 1) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x + 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();

                    Cell holdCell = new Cell(hx, hy);

                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;
                }


            }


            hx = hold.x;
            hy = hold.y - 1;

            if (hy >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {
                if (hold.x == x && hold.y == y) {
                    if (dir == 0) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y - 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();

                    Cell holdCell = new Cell(hx, hy);

                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;
                }

            }



            hx = hold.x;
            hy = hold.y + 1;

            if (hy < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 2) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y + 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();
                    Cell holdCell = new Cell(hx, hy);

                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;
                }


            }
            state[hold.y][hold.x] = 1;
        }
        return ans;
    }

    public String gotoPointy(int x, int y, int dir, int x1, int y1) {
        java.util.LinkedList<Cell> q = new java.util.LinkedList<Cell>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                state[i][j] = -1;
                d[i][j] = 0;
            }
        }
        q.add(new Cell(x, y));
        state[y][x] = 0;
        pi[y][x] = new Cell(-1, -1);

        while (q.size() != 0) {
            int min = Integer.MAX_VALUE;
            int h = 0;
            for (int i = 0; i < q.size(); i++) {
                if (d[q.get(i).y][q.get(i).x] < min) {
                    min = d[q.get(i).y][q.get(i).x];
                    h = i;
                }
            }
            Cell hold = q.remove(h);

            int hx = hold.x;
            int hy = hold.y - 1;

            if (hy >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {

                if (hold.x == x && hold.y == y) {
                    if (dir == 0) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y - 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();
                    Cell holdCell = new Cell(hx, hy);
                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;
                }
            }
            hx = hold.x;
            hy = hold.y + 1;

            if (hy < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 2) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].y + 1 == hold.y) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;

                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();

                    Cell holdCell = new Cell(hx, hy);

                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;
                }


            }
            hx = hold.x - 1;
            hy = hold.y;

            if (hx >= 0 && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 3) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x - 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;


                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();

                    Cell holdCell = new Cell(hx, hy);

                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;
                }
            }
            hx = hold.x + 1;
            hy = hold.y;

            if (hx < size && (data[hy][hx] <= 0 || data[hy][hx] > 9) && state[hy][hx] != 1) {


                if (hold.x == x && hold.y == y) {
                    if (dir == 1) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                } else {
                    if (pi[hold.y][hold.x].x + 1 == hold.x) {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 1) {
                            d[hy][hx] = d[hold.y][hold.x] + 1;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    } else {
                        if (state[hy][hx] == -1 || d[hy][hx] > d[hold.y][hold.x] + 2) {
                            d[hy][hx] = d[hold.y][hold.x] + 2;
                            pi[hy][hx] = new Cell(hold.x, hold.y);
                        }
                    }
                }
                if (state[hy][hx] == -1) {
                    q.add(new Cell(hx, hy));
                }
                state[hy][hx] = 0;


                if (hy == y1 && hx == x1) {
                    java.util.LinkedList<Cell> l = new java.util.LinkedList<Cell>();

                    Cell holdCell = new Cell(hx, hy);

                    while (pi[holdCell.y][holdCell.x].x != -1) {
                        l.addFirst(holdCell);
                        holdCell = pi[holdCell.y][holdCell.x];
                    }
                    l.addFirst(holdCell);

                    if (l.get(1).x == l.get(0).x + 1) {
                        ans = "RIGHT#";

                    } else if (l.get(1).x == l.get(0).x - 1) {
                        ans = "LEFT#";

                    } else if (l.get(1).y == l.get(0).y + 1) {
                        ans = "DOWN#";

                    } else {
                        ans = "UP#";

                    }
                    return ans;
                }
            }
            state[hold.y][hold.x] = 1;
        }
        return ans;
    }

    public int likeMinMax(int x1, int y1, int dir1, int x2, int y2, int dir2, int data[][], Player[] team, boolean isMax, int count) {
        if (isMax) {
            int a = 0, b, c, d, e;
            switch (dir1) {
                case 0:
                    if (x1 - 1 >= 0) {
                        a = likeMinMax(x1-1, y1, dir1, x2, y2, dir2, data, team, false, count+1);
                    }
                    break;
                case 1:
                    if (y1 + 1 < size) {
                        a = likeMinMax(x1, y1 + 1, 0, x2, y2, dir2, data, team,false,count+1);
                    }
                    break;
                case 2:
                    if (x1 + 1 < size) {
                        a = likeMinMax(x1 + 1, y1, 2, x2, y2, dir2, data, team,false,count+1);
                    }
                    break;
                case 3:
                    if (y1 - 1 < size) {
                        a = likeMinMax(x1, y1-1, 2, x2, y2, dir2, data, team,false,count+1);
                    }
                    break;
            }
            int m=a;
            if(m!=100)
            {
                b = likeMinMax(x1, y1, 1, x2, y2, dir2, data, team,false,count+1);
                m=Math.max(m, b);
                if(m!=100)
                {
                    c = likeMinMax(x1, y1, 2, x2, y2, dir2, data, team,false,count+1);
                    m=Math.max(m, c);
                    if(m!=100)
                    {
                        d = likeMinMax(x1, y1, 3, x2, y2, dir2, data, team,false,count+1);
                        m=Math.max(m, d);
                        if(m!=100)
                        {
                            e = likeMinMax(x1, y1, 0, x2, y2, dir2, data, team,false,count+1);
                            m=Math.max(m, e);
                        }
                    }
                }
            }
            return m;

        }
        else
        {
            int a = 0, b, c, d, e;
            switch (dir2) {
                case 0:
                    if (x2 - 1 >= 0) {
                        a = evaluateFunction(x1, y1, dir1, x2-1, y2, 0, data, team);
                    }
                    break;
                case 1:
                    if (y2 + 1 < size) {
                        a = evaluateFunction(x1, y1 , dir1, x2, y2+1, 1, data, team);
                    }
                    break;
                case 2:
                    if (x2 + 1 < size) {
                        a = evaluateFunction(x1, y1, dir1, x2+1, y2, 2, data, team);
                    }
                    break;
                case 3:
                    if (y2 - 1 < size) {
                        a = evaluateFunction(x1, y1, dir1, x2, y2-1, 3, data, team);
                    }
                    break;
            }
            b = evaluateFunction(x1, y1, 1, x2, y2, dir2, data, team);
            c = evaluateFunction(x1, y1, 2, x2, y2, dir2, data, team);
            d = evaluateFunction(x1, y1, 3, x2, y2, dir2, data, team);
            e = evaluateFunction(x1, y1, 0, x2, y2, dir2, data, team);
            
            int m=Math.min(a, b);
            m=Math.min(m,c);
            m=Math.min(m,d);
            return m;
        }
    }

    static int evaluateFunction(int x1, int y1, int dir1, int x2, int y2, int dir2, int data[][], Player[] team) {
        return 0;
    }
}

class Cell {

    int x = 0;
    int y = 0;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}