/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingChallenge2;

/**
 *
 * @author wijebandara
 */
public class Player {
    int number=0;
    int location_x=0;
    int location_y=0;
    int direction=0;
    int isShot=0;
    int health=0;
    int coins=0;
    int points=0;

    public Player(int number,int location_x, int location_y , int direction , int isShot , int health,int coins ,int points) {
         this.coins = coins;
        this.direction =direction;
        this.health = health;
        this.isShot = isShot;
        this.location_x= location_x;
        this.location_y = location_y;
        this.number =number;
        this.points  = points;
    }

    
    public void update(int number,int location_x, int location_y , int direction , int isShot , int health,int coins ,int points)
    {
        this.coins = coins;
        this.direction =direction;
        this.health = health;
        this.isShot = isShot;
        this.location_x= location_x;
        this.location_y = location_y;
        this.number =number;
        this.points  = points;
                
                
    }
    
}

