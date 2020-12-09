/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussapp;

/**
 *
 * @author zaikin
 */
public class Buss {
    private int places, cost, occupied;
    
    public Buss(){
    }
    
    public Buss(int places,int cost,int occupied){
        this.places=places;
        this.cost=cost;
        this.occupied=occupied;
    }
    
    public Buss (Buss b){
        this.cost=b.cost;
        this.occupied=b.occupied;
        this.places=b.places;
    }
    
    public int getPlaces(){
        return places;
    }
    
    public void setPlaces(int places){
        if(places>0)
            this.places=places;
    }
    
    
    public int freePlaces(){
        return places-occupied;
    }
    
    public boolean full(){
        if(places<=occupied){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int occupiedPlaceCost(){
        return cost*occupied;
    }  
    
    }
