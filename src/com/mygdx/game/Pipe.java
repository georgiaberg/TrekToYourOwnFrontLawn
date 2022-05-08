package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
//purpose: a class to construct a Pipe to be used within the puzzle that can easily be used to check rotations compared to
//goal rotations and updating the sprite position at the same time
public class Pipe {
	ArrayList<Integer> goalRotations;
	int rotations;
	Sprite t;
	boolean straightPipe;
	public Pipe(ArrayList<Integer> g, int r, Sprite te, boolean c) {
		goalRotations = g; //arraylist of all goal rotations
		rotations = r; // actual rotation counter
		t = te; //sprite
		straightPipe = c; //whether or not a straight pipe (symetrical rotations)
	}
	public Sprite getSprite() {
		return t;
	}
	public void rotate() {
		t.rotate(90); // rotate the sprite 90 degrees
		rotations+=1; // add onto rotation counter
		if(!straightPipe) { //symmetry rotation issue
			if(rotations%2==0) {
				rotations = 0;
			}
		}
		

	}

}
