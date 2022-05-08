package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Item {
	ArrayList<Texture> interaction;
	Texture cluePic;
	public Item( Texture t,ArrayList<Texture> i) {
		cluePic = t;
		interaction = i; //interaction is an arraylist so items can have no interactions
					// for an item with interactions, the arraylist will contain both the texture of 
					// the Item it reacts with and the texture of the Item they produce
	}
	public String toString() {
		return "" + (cluePic!=null);
	}
}
