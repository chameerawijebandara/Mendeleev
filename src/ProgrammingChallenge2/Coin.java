/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingChallenge2;

/**
 *
 * @author wijebandara
 */
public class Coin {
    int x;
    int y;
    int STime;
    int ETime;
    int value;
    
    Coin(int x,int y,int STime ,int ETime,int value)
    {
        this.STime=STime;
        this.ETime= ETime;
        this.value = value;
        this.x=x;
        this.y=y;
    }
    
}
