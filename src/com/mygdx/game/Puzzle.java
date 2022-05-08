package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Puzzle {
		//Purpose: creating a Puzzle object for easy checking of current puzzles and their own 
		//texture / masking
		String name; 
		Texture texture;
		Pixmap masking;		
		public Puzzle(String n, Texture t, Pixmap m) {
			name = n;
			texture = t;
			masking = m;
		}
		@Override
		public String toString() {
			return name;
		}
}
