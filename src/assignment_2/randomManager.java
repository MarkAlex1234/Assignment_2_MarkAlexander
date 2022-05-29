/*

Assignment 2 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.util.Random;

public final class RandomManager {

    public RandomManager() {
        this.generateNumber();
    }
    
    public int generateNumber() {
        Random generator = new Random();
        int i = generator.nextInt(15);
        while(i == 0){
            i = generator.nextInt(15);
        }
        return i;
    }
}