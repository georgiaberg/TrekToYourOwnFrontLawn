//MyGdxGame.java

//
//GEORGIA BERG
//GAME BASICS
//Trek to your own Front Lawn is an escape - room style game
//The object is to get out of your house (basement and kitchen)
//there are puzzles (sliding numbers, twisting dials, keys to be played)
//objects and clues that interact can create new objects
//The puzzles need not be completed in any order, but the user will need
//the clues from past puzzles in order to move forward

//CODE OVERVIEW
//There are two hashmaps - one for each room that map integer values 
//onto puzzles. These puzzle objects contain a name (for debugging mostly),
//a Texture, and a pixmap. Variable "c" holds the integer value of the current
// puzzle at mouse position, and the program checks if this is also a value mapped onto 
// a puzzle option from that room's hash map. Specific puzzles are done within the game method.
//There is one inventory list that begins empty, Item objects are created when added


//WALKTHROUGH 
//basement
// get glass from pool table bottle
// use glass to cut open couch cushion
// grab remote
// use remote to turn on speaker
// music begins with 3-6-9
//set washer dials to position 3-6-9
// pick up key in washer
//pick up red book on shelf
//combine locked book with key
//use red book, read "escape" as well as key hints
//check window for morse code
//enter 'escape' in morse code into keyboard by hitting
// . ... -.-. .- .--. . (smaller keys are dashes, longer keys are dots)
//collect key thing from metronome
//use on door

//kitchen
// need the following to unlock door
//cheese:
	// collect cheese from trash, pick up knife from knife holder, combine
//calender:
	//solve microwave slide number puzzle, collect wrench
	// use wrench on pipes until connected
	// back out, get kettle from stove
	// sink water is now running if pipes correct. fill kettle
	// kettle placed on stove. will begin to boil
	//steam message will show what magnets to hit
	// hit car, raisin, superhero (on fridge)
//cereal:
	//go to shelf, see rainbow
	//organize cereal in rainbow order.
	// cereal noise will happen
	// go to cereal bowl, there will be cereal
	//click on bowl
//cup
	// cutting board, cup
//all of these items will fit onto the door buttons, which will open the door

//Sounds are used:
//when object is picked up
//when speaker, piano, water, cereal, ect is being interacted with
package com.mygdx.game;
import java.awt.Rectangle;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Pixmap;
import java.util.*;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	Texture menu;
	Texture instructions;
	Texture noCupZO;
	boolean down;
	boolean move;
	boolean bookOpen;
	boolean gameStart;
	boolean help;
	Texture cheese;
	Texture cheeseSmall;
	boolean knifeUp;
	Texture kitchenSteam;
	boolean bookUp;
	boolean calanderUp;
	Rectangle playRect;
	Rectangle helpRect;
	boolean kettleFilled;
	boolean cPlayed;
	boolean won;
	Texture cheeseOn;
	Texture calanderOn;
	Texture cerealOn;
	Texture cupOn;
	Texture endScreen;
	Texture calander;
	boolean calanderIn;
	boolean cerealIn;
	boolean cheeseIn;
	boolean cupIn;
	boolean noCup;
	Texture rainbow;
	boolean steamTime;
	Texture knifeNoKnife;
	Pixmap sinkMasking;
	ArrayList<Pipe> pipes;
	ArrayList<Integer> magnets;
	boolean cheeseUp;
	Texture kettle;
	Sound a;
	Texture knifeItem;
	Sound[] pianoSounds;
	Sound b;
	Sound waterNoise;
	Sound cerealNoise;
	Sound kettleNoise;
	boolean cerealMatch;
	int currentEmpty;
	Sprite elbowPipe1;
	Sprite elbowPipe2;
	Sprite elbowPipe3;
	Texture cerealBowl1;
	Texture cerealBowl2;
	Sprite elbowPipe4;
	Sprite elbowPipe5;
	Sprite straightPipe1;
	Sprite straightPipe2;
	Sprite tPipe1;
	Sprite tPipe2;
	Sprite tPipe3;
	Sprite tPipe4;
	Sprite tPipe5;
	boolean tapOn;
	Texture fridgeNoCal;
	boolean wrenchPicked;
	Texture stoveKettleOff;
	Texture wrench;
	Texture shelfNoBook;
	ArrayList<Integer> pipeAL1;
	ArrayList<Integer> pipeAL2;
	ArrayList<Integer> pipeAL3; //arrays for each pipe
	ArrayList<Integer> pipeAL4; //at any given index, the integer for that pipe's goal rotations will create a possible path
	ArrayList<Integer> pipeAL5;
	ArrayList<Integer> pipeAL6;
	ArrayList<Integer> pipeAL7;
	ArrayList<Integer> pipeAL8;
	ArrayList<Integer> pipeAL9;
	ArrayList<Integer> pipeAL10;
	ArrayList<Integer> pipeAL11;
	ArrayList<Integer> pipeAL12;
	Texture shreddedWheat;
	Texture noKettle;
	Texture cup;
	Sound bb;
	Sound c;
	Sound c2;
	Sound d;
	Sound e;
	Sound eb;
	Sound f;
	Sound f2;
	Sound g;
	Sound g2;
	Box box1;
	Box box2;
	Box box3;
	Box box4;
	Box box5;
	Box box6;
	Box box7;
	Box box8;

	Pixmap cerealMasking;
	Texture bricks;
	Texture book;
	Texture openBook;
	// fridge stove microwave trash
	Texture stove;
	Pixmap stoveMasking;
	Texture microwave;
	Pixmap microwaveMasking;
	Texture trash;
	Pixmap trashMasking;
	Pixmap buttonMasking;
	Texture cuttingBoardCup;
	Texture cuttingBoardNoCup;
	Pixmap cuttingBoardMasking;
	Texture buttons;
	Texture fridge;
	Pixmap fridgeMasking;
	Texture kitchen;
	Pixmap kitchenMasking;
	Texture knife;
	Pixmap knifeMasking;
	Texture shelf;
	Pixmap shelfMasking;
	Texture key;
	Texture keyThing;
	boolean metClick;
	Texture baseDoor;
	Texture sink;
	Texture bigPipe;
	Pixmap baseDoorMasking;
	boolean kettlePU;
	int morseStage;
	Texture metronome1;
	Texture metronome2;
	Texture metronome3;
	Texture washerOpen;
	boolean[] dialClicked;
	boolean click;
	boolean upstairs;
	int puzzle;
	int[] ox;
	/*
	 * Sprite num0; Sprite num1; Sprite num2; Sprite num3; Sprite num4; Sprite num5;
	 * Sprite num6; Sprite num7; Sprite num8; Sprite num9;
	 */
	boolean kitchenDoor;
	int[] oy;
	boolean codeUp;
	Box beingDragged;
	SpriteBatch batch;
	Texture arrowDown;
	boolean mouseUp;
	Texture baseBasement;
	Pixmap basementMasking;
	Texture bookShelfTexture;
	boolean washerOpened;
	Pixmap bookShelfMasking;
	Texture pianoTexture;
	Texture arrow;
	Pixmap pianoMasking;
	Texture openInventory;
	Texture inventory;
	Texture couchTexture;
	Pixmap couchMasking;
	Texture pooltableTexture;
	Pixmap pooltableMasking;
	Texture speakerTexture;
	Pixmap speakerMasking;
	Texture windowTexture;
	Texture microPadCover;
	Pixmap windowMasking;
	Texture redBook;
	HashMap<Integer, Puzzle> basePuzzleMapping;
	HashMap<Integer, Puzzle> kitchenPuzzleMapping;
	ArrayList<Item> inventoryList;
	boolean inventoryCheck = false;
	Texture bottlecap;
	Item selected;
	Texture kitchenDoorOpen;
	boolean itemInUse;
	boolean remoteRev;
	Texture fluff;
	Texture remote;
	int[] dashes = { -270225153, -1183164417, -1, -2013260289, -917249 }; // colours of dashes on pianomasking
	int[] dots = { -5322241, -8443905, -1243210241, 1061735679 }; // colours of dots on pianomasking
	int[] morse = { 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1 }; // whether the thing is dot (1) or dash (0)
	ArrayList<Integer> keys;
	boolean pressed;
	boolean pressed2;
	Texture codeSheet;
	Sound openSound;
	Sound addSound;
	Texture washerTexture;
	Texture washerDial;
	Texture wa;
	float bsx;
	float bsy;
	Sprite[] dials;
	Sprite washerArrow1;
	Sprite washerArrow2;
	Sprite washerArrow3;
	Box[] boxes;
	Texture microwavePad;
	Music fakeId;
	int rowE;
	int colE;

	Sprite numSprite0;
	Sprite numSprite1;
	Sprite numSprite2;
	Sprite numSprite3;
	Sprite numSprite4;
	Sprite numSprite5;
	Sprite numSprite6;
	Sprite numSprite7;
	Sprite numSprite8;

	ArrayList<Sprite> numSprite;

	boolean keyPlayed;
	public static final int SPIN = 8388863;
	public static final int SPEAKER = -16744193;
	public static final int PIANO = 16777215;
	public static final int OPENWASHER = 519981;
	public static final int BASEDOOR = -5322241;
	public static final int DOOR = -864160257;
	public static final int BUTTONS = 549280255;
	public static final int TRASH = -1557122817;
	public static final int CUTTINGBOARD = -230702849;
	public static final int KNIVES = 589410559;
	public static final int STOVE = 535994367;
	public static final int MICROWAVE = -739894017;
	public static final int SHELF = -1426147841;
	public static final int KITCHEN = -1;
	public static final int PIPES = 4;
	public static final int SINK = -2055120385;
	public static final int KDOOR = -864160257;
	public static final int FRIDGE = -1996463105;
	public static final int MICROWAVEPAD = -332715009;
	public static final int CEREAL = -1705635329;
	public static final int BOOKSHELF = -9437185;
	public static final int COUCH =  -16776961;
	public static final int POOLTABLE  = 8421631;
	public static final int  WINDOW = -39169;
	public static final int  WASHEROPEN = 519981;
	ArrayList<Box> bxList1;
	ArrayList<Box> bxList2;
	ArrayList<Box> bxList3;
	ArrayList<Box> bxList4;
	ArrayList<Box> bxList5;
	ArrayList<Box> bxList6;
	ArrayList<Box> bxList7;
	ArrayList<Box> bxList8;

	int x;
	int y;
	float goalX;
	float goalY;
	Texture sinkOn;

	@Override
	public void create() {
		menu = new Texture("menuScreen.png");
		instructions = new Texture("instructions.png");
		waterNoise = Gdx.audio.newSound(Gdx.files.internal("pour_glass_water-Mike-Koenig-123.mp3"));
		cerealNoise = Gdx.audio.newSound(Gdx.files.internal("Pouring Bowl Cereal-SoundBible.com-447772767.mp3"));
		cerealBowl1 = new Texture("cerealBowl1.png");
		cerealBowl2 = new Texture("cerealBowl2.png");
		wrenchPicked = false;
		sinkOn = new Texture("sinkOn.png");
		noKettle = new Texture("kitchenNoKettle.png");
		numSprite = new ArrayList<Sprite>();

		numSprite0 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_1.png"));
		numSprite1 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_2.png"));
		numSprite2 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_3.png"));
		numSprite3 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_4.png"));
		numSprite4 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_5.png"));
		numSprite5 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_6.png"));
		numSprite6 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_7.png"));
		numSprite7 = new Sprite(new Texture("Number_Blocks_01_Set_4_256x256_8.png"));
		numSprite8 = new Sprite(new Texture("emptyBox.png"));
		shelfNoBook = new Texture("bookShelfNoBook.png");
		numSprite.add(numSprite2);
		numSprite.add(numSprite6);
		numSprite.add(numSprite4);
		numSprite.add(numSprite8);
		numSprite.add(numSprite1);
		numSprite.add(numSprite3);
		numSprite.add(numSprite5);
		numSprite.add(numSprite0);
		numSprite.add(numSprite7);
		sinkMasking = new Pixmap(Gdx.files.internal("sinkMasking.png"));
		for (int i = 0; i < 9; i++) {
			numSprite.get(i).setSize(50, 50);
			int row = i / 3;
			int col = i % 3;
			numSprite.get(i).setCenterX(730 + col * 55);
			numSprite.get(i).setCenterY(410 + row * 55);
		}
		currentEmpty = 3;
		calanderUp = false;
		move = false;
		goalX = 0;
		goalY = 0;
		microPadCover = new Texture("microPadCover.jpg");
		beingDragged = null;
		cupOn = new Texture("cupOn.png");
		calanderOn = new Texture("calanderOn.png");
		cerealOn = new Texture("cerealOn.png");
		cheeseOn = new Texture("cheeseOn.png");

	
		playRect = new Rectangle (188, 76, 434, 93);
		helpRect = new Rectangle (827, 76, 434, 93);
		box1 = new Box(287 + 42, 250, new Sprite(new Texture("box1.png")));
		box2 = new Box(372 + 43, 250, new Sprite(new Texture("box2.png")));
		box3 = new Box(457 + 42, 250, new Sprite(new Texture("box3.png")));
		box4 = new Box(542 + 43, 250, new Sprite(new Texture("box4.png")));
		box5 = new Box(627 + 42, 250, new Sprite(new Texture("box5.png")));
		box6 = new Box(712 + 43, 250, new Sprite(new Texture("box6.png")));
		box7 = new Box(881 + 42, 250, new Sprite(new Texture("box8.png")));
		kettlePU = false;
		bigPipe = new Texture("bigPipe.png");
		cerealMasking = new Pixmap(Gdx.files.internal("cerealMasking.png"));
		pipeAL1 = new ArrayList<Integer>();
		pipeAL2 = new ArrayList<Integer>();
		pipeAL3 = new ArrayList<Integer>();
		pipeAL4 = new ArrayList<Integer>();
		pipeAL5 = new ArrayList<Integer>();
		pipeAL6 = new ArrayList<Integer>();
		pipeAL7 = new ArrayList<Integer>();
		pipeAL8 = new ArrayList<Integer>();
		pipeAL9 = new ArrayList<Integer>();
		pipeAL10 = new ArrayList<Integer>();
		pipeAL11 = new ArrayList<Integer>();
		pipeAL12 = new ArrayList<Integer>();
		sink = new Texture("sink.png");
		bricks = new Texture("bricks.jpg");
		steamTime = false;
		wrench = new Texture("wrench.png");
		noCupZO = new Texture ("noCupZoomedOut.png");
		bookUp = false;
		noCup = false;
		shreddedWheat = new Texture("cerealPiece.png");
		rainbow = new Texture("rainbow.png");
		fridgeNoCal = new Texture("fridgeNoCal.png");
		kettle = new Texture("kettle.png");
		cup = new Texture("cup.png");
		pipeAL1.add(1);
		pipeAL2.add(4);
		pipeAL3.add(4);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(1);
		pipeAL9.add(4);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(1);

		pipeAL1.add(4);
		pipeAL2.add(4);
		pipeAL3.add(4);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(1);
		pipeAL9.add(0);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(1);

		pipeAL1.add(4);
		pipeAL2.add(4);
		pipeAL3.add(4);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(3);
		pipeAL9.add(0);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(1);

		pipeAL1.add(4);
		pipeAL2.add(1);
		pipeAL3.add(2);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(3);
		pipeAL7.add(2);
		pipeAL8.add(1);
		pipeAL9.add(4);
		pipeAL10.add(4);
		pipeAL11.add(4);
		pipeAL12.add(4);

		cPlayed = false;
		pipeAL1.add(4);
		pipeAL2.add(0);
		pipeAL3.add(0);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(0);
		pipeAL8.add(1);
		pipeAL9.add(4);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(2);
		stoveKettleOff = new Texture("stoveKettleOff.png");
		pipeAL1.add(4);
		pipeAL2.add(4);
		pipeAL3.add(4);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(3);
		pipeAL9.add(4);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(2);
		microwavePad = new Texture("microwavePad.png");
		pipeAL1.add(4);
		pipeAL2.add(1);
		pipeAL3.add(2);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(3);
		pipeAL7.add(2);
		pipeAL8.add(2);
		pipeAL9.add(0);
		pipeAL10.add(4);
		pipeAL11.add(4);
		pipeAL12.add(4);
		kitchenDoorOpen = new Texture ("kitchenDoorOpen.png");
		pipeAL1.add(4);
		pipeAL2.add(4);
		pipeAL3.add(4);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(1);
		pipeAL9.add(0);
		pipeAL10.add(3);
		pipeAL11.add(1);
		pipeAL12.add(1);

		pipeAL1.add(4);
		pipeAL2.add(0);
		pipeAL3.add(0);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(0);
		pipeAL8.add(1);
		pipeAL9.add(4);
		pipeAL10.add(3);
		pipeAL11.add(1);
		pipeAL12.add(2);

		pipeAL1.add(4);
		pipeAL2.add(4);
		pipeAL3.add(3);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(1);
		pipeAL9.add(0);
		pipeAL10.add(3);
		pipeAL11.add(1);
		pipeAL12.add(2);

		pipeAL1.add(3);
		pipeAL2.add(1);
		pipeAL3.add(2);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(3);
		pipeAL7.add(2);
		pipeAL8.add(1);
		pipeAL9.add(4);
		pipeAL10.add(3);
		pipeAL11.add(3);
		pipeAL12.add(1);

		pipeAL1.add(4);
		pipeAL2.add(1);
		pipeAL3.add(2);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(3);
		pipeAL7.add(3);
		pipeAL8.add(1);
		pipeAL9.add(4);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(1);

		pipeAL1.add(3);
		pipeAL2.add(1);
		pipeAL3.add(2);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(3);
		pipeAL7.add(3);
		pipeAL8.add(2);
		pipeAL9.add(4);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(1);

		pipeAL1.add(4);
		pipeAL2.add(4);
		pipeAL3.add(4);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(3);
		pipeAL9.add(4);
		pipeAL10.add(2);
		pipeAL11.add(1);
		pipeAL12.add(2);

		pipeAL1.add(4);
		pipeAL2.add(4);
		pipeAL3.add(4);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(2);
		pipeAL7.add(4);
		pipeAL8.add(3);
		pipeAL9.add(4);
		pipeAL10.add(3);
		pipeAL11.add(1);
		pipeAL12.add(2);

		pipeAL1.add(4);
		pipeAL2.add(1);
		pipeAL3.add(2);
		pipeAL4.add(1);
		pipeAL5.add(1);
		pipeAL6.add(3);
		pipeAL7.add(3);
		pipeAL8.add(1);
		pipeAL9.add(0);
		pipeAL10.add(4);
		pipeAL11.add(4);
		pipeAL12.add(4);

		colE = 0;
		rowE = 2;

		box1.spr.setCenterX(box1.x);
		box2.spr.setCenterX(box2.x);
		box3.spr.setCenterX(box3.x);
		box4.spr.setCenterX(box4.x);
		box5.spr.setCenterX(box5.x);
		box6.spr.setCenterX(box6.x);
		box7.spr.setCenterX(box7.x);
		kitchenSteam = new Texture("kitchenSteam.png");
		box1.spr.setY(box1.y);
		box2.spr.setY(box2.y);
		box3.spr.setY(box3.y);
		box4.spr.setY(box4.y);
		box5.spr.setY(box5.y);
		box6.spr.setY(box6.y);
		box7.spr.setY(box7.y);
		boxes = new Box[7];
		boxes[0] = box1;
		boxes[1] = box2;
		boxes[2] = box3;
		boxes[3] = box4;
		boxes[4] = box5;
		boxes[5] = box6;
		boxes[6] = box7;
		tPipe1 = new Sprite(new Texture("tPipe.png"));
		tPipe2 = new Sprite(new Texture("tPipe.png"));
		tPipe3 = new Sprite(new Texture("tPipe.png"));
		tPipe4 = new Sprite(new Texture("tPipe.png"));
		tPipe5 = new Sprite(new Texture("tPipe.png"));

		elbowPipe1 = new Sprite(new Texture("elbowPipe.png"));
		elbowPipe2 = new Sprite(new Texture("elbowPipe.png"));
		elbowPipe3 = new Sprite(new Texture("elbowPipe.png"));
		elbowPipe4 = new Sprite(new Texture("elbowPipe.png"));
		elbowPipe5 = new Sprite(new Texture("elbowPipe.png"));

		straightPipe1 = new Sprite(new Texture("straightPipe.png"));
		straightPipe2 = new Sprite(new Texture("straightPipe.png"));

		pipes = new ArrayList<Pipe>();
		pipes.add(new Pipe(pipeAL1, 0, tPipe1, true));
		pipes.add(new Pipe(pipeAL2, 0, elbowPipe1, true));
		pipes.add(new Pipe(pipeAL3, 0, elbowPipe2, true));
		pipes.add(new Pipe(pipeAL4, 0, elbowPipe3, true));
		pipes.add(new Pipe(pipeAL5, 0, elbowPipe4, true));
		pipes.add(new Pipe(pipeAL6, 0, elbowPipe5, true));
		pipes.add(new Pipe(pipeAL7, 0, tPipe2, true));
		pipes.add(new Pipe(pipeAL8, 0, tPipe3, true));
		pipes.add(new Pipe(pipeAL9, 0, straightPipe1, true));
		pipes.add(new Pipe(pipeAL10, 0, tPipe4, true));
		pipes.add(new Pipe(pipeAL11, 0, straightPipe2, false));
		pipes.add(new Pipe(pipeAL12, 0, tPipe5, true));
		keyPlayed = false;
		a = Gdx.audio.newSound(Gdx.files.internal("68437__pinkyfinger__piano-a.wav"));
		b = Gdx.audio.newSound(Gdx.files.internal("68438__pinkyfinger__piano-b.wav"));
		bb = Gdx.audio.newSound(Gdx.files.internal("68439__pinkyfinger__piano-bb.wav"));
		c = Gdx.audio.newSound(Gdx.files.internal("68440__pinkyfinger__piano-c.wav"));
		c2 = Gdx.audio.newSound(Gdx.files.internal("68441__pinkyfinger__piano-c.wav"));
		d = Gdx.audio.newSound(Gdx.files.internal("68442__pinkyfinger__piano-d.wav"));
		e = Gdx.audio.newSound(Gdx.files.internal("68443__pinkyfinger__piano-e.wav"));
		eb = Gdx.audio.newSound(Gdx.files.internal("68444__pinkyfinger__piano-eb.wav"));
		f = Gdx.audio.newSound(Gdx.files.internal("68445__pinkyfinger__piano-f.wav"));
		f2 = Gdx.audio.newSound(Gdx.files.internal("68446__pinkyfinger__piano-f.wav"));
		g = Gdx.audio.newSound(Gdx.files.internal("68447__pinkyfinger__piano-g.wav"));
		g2 = Gdx.audio.newSound(Gdx.files.internal("68448__pinkyfinger__piano-g.wav"));
		kettleNoise = Gdx.audio.newSound(Gdx.files.internal("Kettle Whistle-SoundBible.com-1233180335.mp3"));
		pianoSounds = new Sound[12];
		pianoSounds[0] = a;
		pianoSounds[1] = b;
		pianoSounds[2] = bb;
		pianoSounds[3] = c;
		pianoSounds[4] = c2;
		pianoSounds[5] = d;
		pianoSounds[6] = e;
		pianoSounds[7] = eb;
		pianoSounds[8] = f;
		pianoSounds[9] = f2;
		pianoSounds[10] = g;
		pianoSounds[11] = g2;
		cheese = new Texture("cheeseBig.png");
		cheeseSmall = new Texture("cheeseBlocks.png");
		calander = new Texture("calander.png");
		tapOn = false;
		kitchen = new Texture("kitchen.png");
		kitchenMasking = new Pixmap(Gdx.files.internal("kitchenMasking.png"));
		bookOpen = false;
		baseDoor = new Texture("baseDoor.png");
		baseDoorMasking = new Pixmap(Gdx.files.internal("baseDoorMasking.png"));
		book = new Texture("redBook.png");
		keyThing = new Texture("keyThing.png");
		metClick = false;
		openBook = new Texture("bookOpen.png");
		washerOpen = new Texture("openWasher.png");
		keys = new ArrayList<Integer>();
		click = false;
		down = false;
		washerOpened = false;
		cheeseUp = false;
		fridge = new Texture("fridge.png");
		fridgeMasking = new Pixmap(Gdx.files.internal("fridgeMasking.png"));
		metronome1 = new Texture("metronome.png");
		metronome2 = new Texture("morseDone.png");
		metronome3 = new Texture("morseDonePicked.png");
		arrowDown = new Texture("arrow copy.png");
		dialClicked = new boolean[3];
		dialClicked[0] = false;
		dialClicked[1] = false;
		dialClicked[2] = false;
		won = false;
		x = Gdx.input.getX();
		y = Gdx.graphics.getHeight() - Gdx.input.getY();
		ox = new int[3];
		oy = new int[3];
		ox[0] = ox[1] = ox[2] = x;
		oy[0] = oy[1] = oy[2] = y;
		mouseUp = false;
		magnets = new ArrayList();
		knifeUp = false;
		knifeNoKnife = new Texture("knifeNoKnife.png");
		knifeItem = new Texture("knifeItem.png");
		key = new Texture("key.png");
		washerDial = new Texture("washerDial.png");
		openSound = Gdx.audio.newSound(Gdx.files.internal("little_robot_sound_factory_fantasy_Inventory_Open_01.mp3"));
		addSound = Gdx.audio.newSound(Gdx.files.internal("little_robot_sound_factory_fantasy_Inventory_Open_00.mp3"));
		fakeId = Gdx.audio.newMusic(Gdx.files.internal("Riton & Kah-Lo - Fake I.D. (Official Video).mp3"));
		washerArrow1 = new Sprite(washerDial);
		washerArrow1.setX(240);
		washerArrow1.setY(160);
		washerArrow1.setScale((float) 0.29);
		washerArrow2 = new Sprite(washerDial);
		washerArrow2.setX(440);
		washerArrow2.setY(140);
		washerArrow2.setScale((float) 0.29);
		washerArrow3 = new Sprite(washerDial);
		washerArrow3.setX(640);
		washerArrow3.setY(120);
		washerArrow3.setScale((float) 0.29);
		dials = new Sprite[3];
		dials[0] = washerArrow1;
		kitchenDoor = false;
		cerealMatch = false;
		dials[1] = washerArrow2;
		dials[2] = washerArrow3;
		gameStart = false;
		help = false;
		morseStage = 0;
		pressed = false;
		codeUp = false;
		pressed2 = true;
		kettleFilled = false;
		washerTexture = new Texture("washerTexture.png");
		Gdx.graphics.setWindowedMode(1440, 854);
		batch = new SpriteBatch();
		fluff = new Texture("fluff.png");
		remote = new Texture("remote.png");
		baseBasement = new Texture("Screen Shot 2019-04-24 at 12.34.21 PM.png");
		basementMasking = new Pixmap(Gdx.files.internal("back457.png"));
		bookShelfTexture = new Texture("bookShelf.png");
		bookShelfMasking = new Pixmap(Gdx.files.internal("bookShelfMasking.png"));
		couchTexture = new Texture("couch.png");
		couchMasking = new Pixmap(Gdx.files.internal("couchMasking.png"));
		redBook = new Texture("book.png");
		pooltableTexture = new Texture("pooltable.png");
		pooltableMasking = new Pixmap(Gdx.files.internal("pooltableMasking.png"));
		speakerTexture = new Texture("speakerTexture.png");
		speakerMasking = new Pixmap(Gdx.files.internal("speakerMasking.png"));
		windowTexture = new Texture("windowTexture.png");
		windowMasking = new Pixmap(Gdx.files.internal("windowMasking.png"));
		pianoTexture = new Texture("pianoTexture.png");
		codeSheet = new Texture("codeSheet.png");
		// redo masking piano
		arrow = new Texture("arrow.png");
		pianoMasking = new Pixmap(Gdx.files.internal("pianoMasking.png"));
		basePuzzleMapping = new HashMap<Integer, Puzzle>(); //hashmap was made for both rooms to map colour values of the masking onto puzzle objects with
															// a name (name mostly for debugging), texture, and pixmap (masking).
		kitchenPuzzleMapping = new HashMap<Integer, Puzzle>();
		bottlecap = new Texture("bottlecap.png");
		inventoryList = new ArrayList<Item>();

		basePuzzleMapping.put(0, new Puzzle("basement", baseBasement, basementMasking));
		basePuzzleMapping.put(BOOKSHELF, new Puzzle("bookshelf", bookShelfTexture, bookShelfMasking));
		basePuzzleMapping.put(PIANO, new Puzzle("piano", pianoTexture, pianoMasking));
		basePuzzleMapping.put(POOLTABLE, new Puzzle("pooltable", pooltableTexture, pooltableMasking));
		basePuzzleMapping.put(SPEAKER, new Puzzle("speaker", speakerTexture, speakerMasking));
		basePuzzleMapping.put(COUCH, new Puzzle("couch", couchTexture, couchMasking));
		basePuzzleMapping.put(WINDOW, new Puzzle("window", windowTexture, windowMasking));
		basePuzzleMapping.put(SPIN, new Puzzle("washer", washerTexture, windowMasking));
		basePuzzleMapping.put(WASHEROPEN, new Puzzle("washerOpen", washerOpen, windowMasking));
		basePuzzleMapping.put(BASEDOOR, new Puzzle("baseDoor", baseDoor, baseDoorMasking));
		// go back n fix nasmes
		endScreen = new Texture ("endScreen.png");
		trashMasking = new Pixmap(Gdx.files.internal("trashMasking.png"));
		buttonMasking = new Pixmap(Gdx.files.internal("button.png"));
		cuttingBoardMasking = new Pixmap(Gdx.files.internal("cuttingBoardMasking.png"));
		knifeMasking = new Pixmap(Gdx.files.internal("knifeMasking.png"));
		stoveMasking = new Pixmap(Gdx.files.internal("stoveMasking.png"));
		microwaveMasking = new Pixmap(Gdx.files.internal("microwaveMasking.png"));
		shelf = new Texture("shelf.png");
		trash = new Texture("trash.png");
		buttons = new Texture("doorButtons.png");
		cuttingBoardCup = new Texture("cuttingBoardCup.png");
		cuttingBoardNoCup = new Texture("cuttingBoardNoCup.png");
		knife = new Texture("knife.png");
		stove = new Texture("stove.png");
		microwave = new Texture("microwave.png");
		shelf = new Texture("shelf.png");
		shelfMasking = new Pixmap(Gdx.files.internal("shelfMasking.png"));
		kitchenPuzzleMapping.put(KITCHEN, new Puzzle("kitchen", kitchen, kitchenMasking)); 
		kitchenPuzzleMapping.put(BUTTONS, new Puzzle("buttons", buttons, buttonMasking)); 
		kitchenPuzzleMapping.put(TRASH, new Puzzle("trash", trash, trashMasking)); 
		kitchenPuzzleMapping.put(CUTTINGBOARD, new Puzzle("cb", cuttingBoardCup, cuttingBoardMasking)); 
		kitchenPuzzleMapping.put(KNIVES, new Puzzle("knife", knife, knifeMasking)); 
		kitchenPuzzleMapping.put(STOVE, new Puzzle("stove", stove, stoveMasking)); 
		kitchenPuzzleMapping.put(MICROWAVE, new Puzzle("mic", microwave, microwaveMasking)); 
		kitchenPuzzleMapping.put(SHELF, new Puzzle("shelf", shelf, shelfMasking));
		kitchenPuzzleMapping.put(PIPES, new Puzzle("pipes", bricks, shelfMasking));
		kitchenPuzzleMapping.put(FRIDGE, new Puzzle("fridge", fridge, fridgeMasking));
		kitchenPuzzleMapping.put(SINK, new Puzzle("pipes", sink, shelfMasking));
		kitchenPuzzleMapping.put(MICROWAVEPAD, new Puzzle("microwave pad", microwavePad, shelfMasking));
		kitchenPuzzleMapping.put(CEREAL, new Puzzle("CEREAL BOWL", cerealBowl1, cerealMasking));

		puzzle = 0;
		upstairs = false;
		openInventory = new Texture("openInventory.png");
		inventory = new Texture("inventory.png");
		itemInUse = false;

		Gdx.input.setInputProcessor(this);

	}

	public boolean boxMove() {
		//Purpose: see if cereal box sprites are movable to that pos (are not overlapping at all), or need to be put in the spot before they were dragged)
		for (Box b : boxes) { //checks all
			if (b != beingDragged) { //for those not currently being dragged (to stop from shooting back to old pos while being dragged)
				if (b.spr.getBoundingRectangle().contains(beingDragged.spr.getX(), 255) 
						|| b.spr.getBoundingRectangle().contains(beingDragged.spr.getX() + beingDragged.spr.getWidth(),
								255)
						|| b.spr.getBoundingRectangle()
								.contains(beingDragged.spr.getX() + beingDragged.spr.getWidth() / 2, 255)) { // if the boxes overlap at all
					return true;
				}
			}
		}
		return false;
	}

	public boolean pipesConnected() { // overloaded method
		for (int i = 0; i < 16; i++) { //overloaded because must check for all possible combos/pathways of pipes
			if (pipesConnected(i)) { //if any path works
				return true;
			}
		}
		return false;

	}

	public boolean doneCheck() {
		//purpose: check to see if microwave puzzle is solved by seeing where in the arraylist each sprite is
		if (numSprite.get(6) != numSprite0 || numSprite.get(7) != numSprite1 || numSprite.get(8) != numSprite2
				|| numSprite.get(3) != numSprite3 || numSprite.get(4) != numSprite4 || numSprite.get(5) != numSprite5
				|| numSprite.get(0) != numSprite6 || numSprite.get(1) != numSprite7 || numSprite.get(2) != numSprite8) {
			return false; // checking to see if all the sprites match the desired index position
		}
		return true;
	}

	public boolean pipesConnected(int i) {
		//Purpose: check if pipes connected
		for (Pipe p : pipes) {
			if (p.goalRotations.get(i) != 4) { //4 was the number used on pipes for which their position was irrelevant
				if (p.goalRotations.get(i) != p.rotations % 4) { //%4 because any rotation + or - 4 is the same position as the pipes
					//rotate 90 degrees in the same direction each time
					return false;
				}
			}
		}
		tapOn = true; //the water turns on if the pipes work
		return true;
	}

	public boolean inInventory(Texture t) { 
		//purpose: checks if an item is in the inventory by texture 
		for (Item i : inventoryList) {
			if (i.cluePic == t) {
				return true;
			}
		}
		return false;
	}

	public void removeFromInventory(Item t) {
		//Purpose: remove an item from inventory
		if (selected != null) { //if theres an item currently selected
			if (t == selected) { //if its the item to remove
				selected = null; // make selected thing null before removing to avoid errors
				itemInUse = false;
			}
		}
		Item k = null;
		for (Item i : inventoryList) {
			if (i == t) {
				k = i; // turning a null Item object into the referenced obeject that needs to be removed then 
				//using the remove() method on it prevents errors
			}
		}
		inventoryList.remove(k);

	}
	public void game() {

		int x = Gdx.input.getX();
		int y = Gdx.graphics.getHeight() - Gdx.input.getY(); //inverted to account for inversion of libgdx
		int c = basementMasking.getPixel(x, 854 - y); //checks what the current puzzle's masking colour is at that pixel
		if (!gameStart) {
			if(playRect.contains(x,y)&& click) {
				gameStart = true;
			}
			if(helpRect.contains(x, y) && click) {
				help = true;
			}
			if(help) {
				if (x > 20 && x < 95 && y < Gdx.graphics.getHeight() - 5 && y > Gdx.graphics.getHeight() - 55 && click) {
					help = false;
				}
			}
	
		} else {
			if (!upstairs) { // if basement
				for (HashMap.Entry<Integer, Puzzle> entry : basePuzzleMapping.entrySet()) { //puzzle selection
					if (puzzle == entry.getKey()) {
						c = entry.getValue().masking.getPixel(x, 854 - y); //y subtracted to account for inversion
					}
				}

				if (puzzle == 0 && inventoryCheck != true) { // if the puzzle is the main view and inventory isn't up
					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
						for (HashMap.Entry<Integer, Puzzle> entry : basePuzzleMapping.entrySet()) { // if the c value is a puzzle 
							if (c == entry.getKey()) {
								puzzle = c; //current puzzle has the same colour value as current part on masking being clicked
							}
						}

					}
				}

				if (puzzle == BOOKSHELF && inventoryCheck != true) {
					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
						if (c == 1061735679) {
							pickUp(redBook, key, book); 
							bookUp = true; // needed to see whether images with that book in it should show
						}
					}
				}
				if (puzzle == WINDOW && inventoryCheck != true) {
					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && c == -1243210241) {
						codeUp = true;
					}
				}
				if (puzzle == SPIN && inventoryCheck != true) { //washer puzzle
					Rectangle[] rects = new Rectangle[3];
					rects[0] = new Rectangle(400, 320, 130, 130);
					rects[1] = new Rectangle(600, 300, 130, 130);
					rects[2] = new Rectangle(800, 280, 130, 130);
					for (int r = 0; r < 3; r++) {
						if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && rects[r].contains(x, y)) {
							ox[r] = x; //original x for that dial is when the dial is first pressed
							oy[r] = y; //original y for that dial is when the dial is first pressed
							dialClicked[r] = true;
						}
					}
					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) == false && dials[0].getRotation() > -108.58
							&& dials[0].getRotation() < -67.88 && dials[1].getRotation() > -206.9119
							&& dials[1].getRotation() < -148.58362 && dials[2].getRotation() > 58.570435
							&& dials[2].getRotation() < 119.61242) { //checking to see if each dial is in the right rotation
						washerOpened = true;
					}

					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) == false) {
						for (int r = 0; r < 3; r++) {
							dialClicked[r] = false; //if the mouse isn't down, the dial being clicked is false
						}
					}
					if (washerOpened && x > 1000 && y > 200 && x < 1060 && y < 265
							&& Gdx.input.isButtonPressed(Input.Buttons.LEFT)) { // if the down arrow is pressed
						puzzle = OPENWASHER; // puzzle is the open washer
					}
				}
				if (puzzle == OPENWASHER) {
					Rectangle keyRect = new Rectangle(725, 300, 70, 40);
					if (keyRect.contains(x, y) && click) {
						pickUp(key, redBook, book);
					}

				}
				if (puzzle == PIANO && inventoryCheck != true) { 
					int kl = keys.size();
					if (click) {
						keyPlayed = false;//the key has not already been played
						//(sound effect)
						for (int d = 0; d < 4; d++) {
							if (c == dashes[d]) { //dashes is an array of colour values
								//of all the dashes in the piano puzzle masking
								keys.add(1); //dashes are represented as 1s
								int n = 2 * (d + 1);
								pianoSounds[n].play();
								keyPlayed = true;
							}
						}
						for (int dot = 0; dot < 4; dot++) { 
							if (c == dots[dot]) {
								//dots is an array of colour values
								//of all the dots in the piano puzzle masking
								keys.add(0); //dots are 2s
								int n = (2 * dot - 1);
								if (n < 0) {
									n = 0;
								}

								pianoSounds[n].play(); // sound effect
								keyPlayed = true;  // sound effect plated
							}
						}
						if (checkMorse() && !metClick) { //right code but not clicked
							morseStage = 1; // metronome stick off
						}
						if (x > 300 && y > 400 && x < 500 && y < 650 && checkMorse()) { //click already checked
							metClick = true; // metronome has been clicked 
							morseStage = 2;	//changes what image should be there	
							pickUp(keyThing);
						}
						if (!keyPlayed && keys.size() > kl) {

							if (x < 200) {
								pianoSounds[0].play(); //sounds if the area was checked
							} else {					//but didn't make sound 
								pianoSounds[12].play();
							}
						}

					}
				}
				codeUp = exitCheck(codeUp);
				if (puzzle == POOLTABLE && inventoryCheck != true) { // pool
					if (click) {
						if (c == -5322241) {
							pickUp(bottlecap);
						}
					}

				}
				if (puzzle == SPEAKER && inventoryCheck != true) { // speaker
					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
						if (selected != null) {
							if (selected.cluePic == remote && c == -1243210241 && fakeId.isPlaying() == false
									&& mouseUp) {
								fakeId.play(); // hint here is 3-6-9 (put those coordinates)
								//					into washer dials (clock positions)
								mouseUp = false; 
							}
							if (selected.cluePic == remote && c == -1243210241 && fakeId.isPlaying() && mouseUp) {
								fakeId.pause();
								mouseUp = false;
							}
						}
					} else {
						mouseUp = true;
					}
				}
				if (puzzle == COUCH && inventoryCheck != true) { // couch
					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
						if (c == -1243210241 && selected != null) {
							if (selected.cluePic == bottlecap) {
								remoteRev = true;
							}

						}
						if (c == -1243210241 && selected == null && remoteRev) { // pillow
							pickUp(remote);
						}
					}

				}
				if (bookOpen && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) { 
					Rectangle r = new Rectangle(25, 725, 65, 60);
					if (r.contains(x, y)) {
						bookOpen = false; //back button (close book)
						selected = null;
						itemInUse = false;
					}

				}
				if (puzzle == BASEDOOR && c == -340386561 && selected != null && click) { //got out of basement
					if (selected.cluePic == keyThing) {
						puzzle = -1; //kitchen
						upstairs = true; //uses the different hashmap
					}
				}
			}
			if (upstairs) {
				for (HashMap.Entry<Integer, Puzzle> entry : kitchenPuzzleMapping.entrySet()) {
					if (puzzle == entry.getKey()) {
						c = entry.getValue().masking.getPixel(x, 854 - y);
					}
				}
				if (puzzle == -1 && inventoryCheck != true) {
					if (click) {
						for (HashMap.Entry<Integer, Puzzle> entry : kitchenPuzzleMapping.entrySet()) {
							if (c == entry.getKey()) {
								puzzle = c;
							}
						}

					}
				}
				if (puzzle == KNIVES && click && c == -495421185) {
					pickUp(knifeItem, cheese, cheeseSmall);
					knifeUp = true;
				}
				if (puzzle == CEREAL && cerealMatch && click && c == 630542079) {
					pickUp(shreddedWheat);

				}
				if (puzzle == SINK) {
					Rectangle r = new Rectangle(670, 320, 732 - 670, 480 - 320);
					if (click && r.contains(x, y) && selected != null && pipesConnected()) {
						if (selected.cluePic == kettle) {
							waterNoise.play();
							kettleFilled = true;
						}
					}
					if (!r.contains(x, y) && selected != null) {
						if (selected.cluePic == kettle) {
							waterNoise.pause(); // don't want it to keep going after the kettle has been removed from 
							//water area
						}
					}
					Rectangle arr = new Rectangle(1000, 200, 60, 65);
					if (arr.contains(x, y) && click) {
						puzzle = PIPES;
					}
				}
				if (puzzle == CUTTINGBOARD) {
					if (click && c == -2058794497) {
						pickUp(cup); 
						noCup = true;

					}
				}
				if (puzzle == FRIDGE) {
					if (click) {
						magnets.add(c); //magnents is just a record of all the numbers
										// the user hits on the fridge
					}
					if (magnets.size() > 3) { 
						int last = magnets.size() - 1;
						if (magnets.get(last - 2) == 412634111 && magnets.get(last - 1) == -469983233
								&& magnets.get(last) == -1032311041) { //similar to checkmorse, checking if each 
																		//looking to see if the masking values match that of the goal magnents
							pickUp(calander);
							calanderUp = true;
						}
					}
				}
				if(puzzle == PIPES) {
					if(!pipesConnected()) { //only if they aren't already connected
						for (int i = 0; i < 12; i++) {//check each pipe
							int col = i % 4; 
							int row;
							if (i < 4) {
								row = 1;
							} else {
								if (i < 8) {
									row = 2;
								} else {
									row = 3;
								}

							}
							pipes.get(i).t.setX(col * 170 + 300); //spacing
							pipes.get(i).t.setY(row * 170 - 100);
							if (selected != null) { //first check to make sure no nullPointerException
								if (click && pipes.get(i).t.getBoundingRectangle().contains(x, y) //if being hit with wrench
										&& selected.cluePic == wrench) {
									pipes.get(i).rotate(); //use rotate method on pipe
								}
							}
						}
					}

				}
				if (puzzle == STOVE) {
					if (c == -1364682497 && click && kettleFilled == false) {
						kettlePU = true;
						pickUp(kettle);
					}
					if (c == -1364682497 && click && kettleFilled && selected != null) {
						if (selected.cluePic == kettle) {
							kettleNoise.play();
							steamTime = true;
							removeFromInventory(selected);
							kettlePU = false;
						}
					}
				}
				if (puzzle == SHELF) {
					if (cerealMatch && !cPlayed) {
						cerealNoise.play(); 
						cPlayed = true;
					}
					if (boxes[1].spr.getX() < boxes[2].spr.getX() && boxes[2].spr.getX() < boxes[5].spr.getX()
							&& boxes[5].spr.getX() < boxes[0].spr.getX() && boxes[0].spr.getX() < boxes[4].spr.getX()
							&& boxes[4].spr.getX() < boxes[6].spr.getX() && boxes[6].spr.getX() < boxes[3].spr.getX()) { //this just checks to make sure boxes in right order
						cerealMatch = true;

					}
					for (Box b : boxes) {
						if (b.spr.getBoundingRectangle().contains(x, y) && beingDragged == null && click) {

							beingDragged = b; // have to check if being dragged so that it only snaps boxes dropped to the right spot

							bsx = beingDragged.spr.getX(); 
							bsy = beingDragged.spr.getY();

						}
						if (beingDragged != null) { // if something is being dragged
							if (beingDragged.spr.getX() < 260) { //makes sure box isn't outside of shelf limits
								if (x >= beingDragged.spr.getX() + beingDragged.spr.getWidth() / 2) {
									beingDragged.spr.setCenterX(x);
								}

							}
							if (beingDragged.spr.getX() + beingDragged.spr.getWidth() > 1000) {
								if (x <= beingDragged.spr.getX() + beingDragged.spr.getWidth() / 2) {
									beingDragged.spr.setCenterX(x);
								}
							}
							if (beingDragged.spr.getX() + beingDragged.spr.getWidth() <= 1000
									&& beingDragged.spr.getX() >= 260) {
								beingDragged.spr.setCenterX(x);
							}

						}

						if (beingDragged != null) {
							if (boxMove() && Gdx.input.isButtonPressed(Input.Buttons.LEFT) == false) { //checks boxmove to see
																									//if valid position
								beingDragged.spr.setX(bsx);
								beingDragged.spr.setY(bsy);
								beingDragged = null;
							}
						}
						if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) == false) {
							beingDragged = null;

						}

					}

				}
				if (puzzle == BUTTONS && selected != null && click) { 
					//there are so many else statements because selected can be made null after the check to see if it
					//is null, creating a possibility of a nullPointerException
					if (selected.cluePic == calander && c == 762918911) {
						calanderIn = true; 
						removeFromInventory(selected);
					} else {
						if (selected.cluePic == shreddedWheat && c == 409999359) {
							cerealIn = true;
							removeFromInventory(selected);
						} else {
							if (selected.cluePic == cheeseSmall && c == 1501583871) {
								cheeseIn = true;
								removeFromInventory(selected);
							} else {
								if (selected.cluePic == cup && c == -1579767553) {
									cupIn = true;
									removeFromInventory(selected);
								}
							}
						}
					}
					if(calanderIn&& cerealIn && cheeseIn && cupIn) {
						kitchenDoor = true; //if all buttom items are in
					}
				}
				if (puzzle == MICROWAVE) {
					if (c == MICROWAVEPAD && click) {
						puzzle = MICROWAVEPAD;
					}
				}
				if (puzzle == TRASH && c == 235558655 && click) {
					cheeseUp = true;
					pickUp(cheese, knifeItem, cheeseSmall);
				}
				if(kitchenDoor&& c == -864160257 && click) {
					won = true;
				}
				if (puzzle == MICROWAVEPAD) {
					//Purpose: sliding puzzle done by seeing if an immediate box is empty,
					//if so, exchanging position data of the two sprites.
					if (!doneCheck()) {
						for (int i = 0; i < 9; i++) {
							if (numSprite.get(i).getBoundingRectangle().contains(x,
									y + numSprite.get(i).getHeight() / 2)) {
								int row;
								if (i < 3) {
									row = 1;
								} else {
									if (i < 6) { //positions of each num sprite
										row = 2;
									} else {
										row = 3;
									}

								}
								int col = i % 3;
								if (click) {
									if ((((Math.abs(row - rowE) == 1 && colE - col == 0) //this checks to see if either directly beside/on top /on bottom
											|| (Math.abs(col - colE) == 1 && rowE - row == 0)) && !move)) {
										numSprite.set(currentEmpty, numSprite.get(i)); //sets the sprite moved at the current empty spot

										numSprite.set(i, numSprite8); // sets empty block to moved sprite pos
										currentEmpty = i; // currently empty number is current block pos
										rowE = row; // used for new difference checking
										colE = col;
										move = true; //it is moved!!
									} 
								}

							}
						}
					} else {
						Rectangle r = new Rectangle(150, 50, 150, 100); //if done, wrench can be picked up
						if (click && r.contains(x, y)) {
							wrenchPicked = true;
							pickUp(wrench);
						}
					}
				}
			}
			if ((inventoryCheck == false && puzzle != 1 && puzzle != -1)) {
				if (x > 25 && x < 90 && y < Gdx.graphics.getHeight() - 10 && y > Gdx.graphics.getHeight() - 50
						&& Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
					inventoryCheck = false;
					if (upstairs) {
						puzzle = -1;
					} else {
						puzzle = 0;
					}
				}
			}

			if (x > Gdx.graphics.getWidth() - 200 && x < Gdx.graphics.getWidth() - 110 && y < 145 && y > 70
					&& Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				if (inventoryCheck == false) {
					pressed = true; //pressed is basically a "click" just for inventoryCheck
				}
			}
			if (pressed) {
				if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) == false) {
					pressed = false;
					openSound.play();
					inventoryCheck = true;
				}
			}
			if (x > Gdx.graphics.getWidth() - 200 && x < Gdx.graphics.getWidth() - 110 && y < 145 && y > 70
					&& Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				if (inventoryCheck == true) {
					pressed2 = true;
				}
			}
			if (pressed2) {
				if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) == false) {
					pressed2 = false;
					inventoryCheck = false;
				}
			}
			if (inventoryCheck) {
				
				Rectangle bCase = new Rectangle(397, 191, 1076 - 397, 330);
				Rectangle exit = new Rectangle(Gdx.graphics.getWidth() - 200, 70, 90, 90);
				for (int i = 0; i < inventoryList.size(); i++) { //check in whole inventory
					int row = i / 3;
					int col = i % 3;
					Rectangle rect = new Rectangle(398 + row * 100, 193 + col * 100, 100, 100);
					if (click && rect.contains(x, y) && itemInUse && selected != null) {
						if (selected.interaction.size() > 0) { // if theres an interacting item
							//Purpose: find interacting item, add what they are listed to produce, delete previous items used to produce
							Rectangle[] spots = new Rectangle[inventoryList.size()]; //all spots
							for (int k = 0; k < inventoryList.size(); k++) {
								int r = k / 3;
								int co = k % 3;
								Rectangle rec = new Rectangle(398 + r * 100, 193 + co * 100, 100, 100);
								spots[k] = rec;
							}
							for (int k = 0; k < inventoryList.size(); k++) {
								if (spots[k].contains(x, y)) { //check all spots for interacting item
									if (selected.interaction.get(0) == inventoryList.get(k).cluePic) { //if the thing the selected item will interact with is that item
										pickUp(selected.interaction.get(1)); // pickUp that item
										removeFromInventory(inventoryList.get(k)); //remove both other items
										removeFromInventory(selected);
										itemInUse = true; // an item is in use!
									}
								}
							}
						}
					}
				}
				for (int i = 0; i < inventoryList.size(); i++) { // works
					int row = i / 3;
					int col = i % 3;
					Rectangle rect = new Rectangle(398 + row * 100, 193 + col * 100, 100, 100);
					if (click && bCase.contains(x, y) && itemInUse == true) { //returns item to case
						selected = null;
						itemInUse = false;

					}
				}

				for (int i = 0; i < inventoryList.size(); i++) { // works
					int row = i / 3;
					int col = i % 3;
					Rectangle rect = new Rectangle(398 + row * 100, 193 + col * 100, 100, 100);

					if (click && Gdx.input.isButtonPressed(Input.Buttons.LEFT) && rect.contains(x, y)
							&& itemInUse == false) {
						selected = inventoryList.get(i); //iterated Item was clicked while contained mouse pos, is selected 
						itemInUse = true; //used mostly within the inventory check methods / peices of code
					}
				}

				if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && exit.contains(x, y)) {
					inventoryCheck = false;

				}
			}

			if (selected != null && inventoryCheck == false && click) {
				if (click && selected.cluePic == book) {
					bookOpen = true;
					selected = null;
				} else {
					bookOpen = false;
				}

			}
		}

		if (click) {
			click = false; //reset click variable to false
		}

	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (!gameStart) { //if game hasn't started yet
			batch.draw(menu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
			if (help) { //instructions
				batch.draw(instructions, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
				batch.draw(arrow, 25, Gdx.graphics.getHeight() - 10, 65, 60);
				
			}
		} else {
			if (!upstairs) { // basement
				for (HashMap.Entry<Integer, Puzzle> entry : basePuzzleMapping.entrySet()) {
					if (puzzle == entry.getKey()) { //the way the puzzles are selected is if the integer puzzle is equal to a masking integer for a puzzle
						batch.draw(entry.getValue().texture, 0, 0, Gdx.graphics.getWidth(),
								Gdx.graphics.getHeight() + 100);
					}
					if (puzzle == -16776961 && remoteRev) {
						batch.draw(fluff, 550, 330, 150, 250);
						if (inInventory(remote) == false) {
							batch.draw(remote, 580, 370, 43, 77);
						}
					}
				}

				if (codeUp) { //morse code sheet
					batch.draw(codeSheet, 100, 100);
				}
				if (puzzle == OPENWASHER) { //the open washing machine
					if (!inInventory(key)) { // if we dont have key 
						batch.draw(key, 725, 300, 70, 40);
					}
				}

				if (puzzle == SPIN) { //washing machine
					for (int i = 0; i < 3; i++) { // look at all dials
						if (dialClicked[i]) {

							double current = Math.toDegrees(Math.atan2(x - (400 + 65 + i * 200), y - (320 + 65 - i * 20))); // current is the rotation relative to the centre of the current pos 
							double old = Math.toDegrees(Math.atan2(ox[i] - (400 + 65 + i * 200), oy[i] - (320 + 65 - i * 20))); // old angle measure
	
							dials[i].setRotation((float) (current - old)); // subtract old to only get new part of rotation
						}
						dials[i].draw(batch); 
					}
				}
				if (puzzle == PIANO) {
					if (morseStage == 0) { // first state metronome is in
						batch.draw(metronome1, 300, 400, 200, 250);
					}
					if (morseStage == 1) { //after the code but before "key" is picked up
						batch.draw(metronome2, 300, 400, 200, 250);
					}
					if (morseStage == 2) { //after "key" is picked up 
						batch.draw(metronome3, 300, 400, 200, 250);
					}
				}
				if (bookUp && puzzle == BOOKSHELF) {
					batch.draw(shelfNoBook, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
				}
				if (washerOpened && puzzle == SPIN) {
					batch.draw(arrowDown, 1000, 200, 60, 65);
				}
				if (inventoryCheck == false) { 
					batch.draw(inventory, Gdx.graphics.getWidth() - 200, 70, 90, 90); //draw lil' suitcase
					if (bookOpen) {
						itemInUse = false;
						batch.draw(openBook, 0, 0, 800, 400);

					}

				} else {
					batch.draw(openInventory, 265, -50, 950, 700);
					batch.draw(openInventory, Gdx.graphics.getWidth() - 200, 70, 90, 90);
					for (int i = 0; i < inventoryList.size(); i++) {

						int row = i / 3;
						int col = i % 3;
						if (selected != inventoryList.get(i)) {
							batch.draw(inventoryList.get(i).cluePic, 398 + row * 100, (193 + col * 100), 100, 100);
						}
					}
				}
				if (itemInUse && selected != null) {
					batch.draw(selected.cluePic, Gdx.input.getX() - 5, Gdx.graphics.getHeight() - Gdx.input.getY(), 70,
							70);
				}
			}
			
			if (upstairs) {
				for (HashMap.Entry<Integer, Puzzle> entry : kitchenPuzzleMapping.entrySet()) {
					if (puzzle == entry.getKey()) {
						batch.draw(entry.getValue().texture, 0, 0, Gdx.graphics.getWidth(),
								Gdx.graphics.getHeight() + 100);
					}
				}
				if (puzzle == TRASH && !cheeseUp) {
					batch.draw(cheese, 530, 200, 100, 100);
				}
				if (puzzle == CUTTINGBOARD) {
					if (noCup) {
						batch.draw(cuttingBoardNoCup, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
					}
				}
				if (puzzle == BUTTONS) {
					if (cupIn) { //drawing each!
						batch.draw(cupOn, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
					}
					if (calanderIn) {
						batch.draw(calanderOn, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
					}
					if (cerealIn) {
						batch.draw(cerealOn, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
					}
					if (cheeseIn) {
						batch.draw(cheeseOn, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
					}

				}
				
				if (puzzle == CEREAL) {
					if (cerealMatch) {
						batch.draw(cerealBowl2, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
					}
				}
				if (puzzle == STOVE && kettlePU) {
					batch.draw(stoveKettleOff, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
				}
				if (puzzle == KITCHEN && kettlePU) {
					batch.draw(noKettle, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
				}

				if (puzzle == SHELF) {

					for (Box b : boxes) {
						if (b != beingDragged) {
							b.spr.draw(batch);
						}
					}
					if (beingDragged != null) {
						beingDragged.spr.draw(batch);
					}
					batch.draw(rainbow, 500, 500);

				}
				if (puzzle == FRIDGE && calanderUp) {
					batch.draw(fridgeNoCal, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
				}
				if (puzzle == KITCHEN && steamTime) {
					batch.draw(kitchenSteam, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
				}
				if (puzzle == PIPES) {
					int x = Gdx.input.getX();
					int y = Gdx.graphics.getHeight() - Gdx.input.getY();
					for (int i = 0; i < 12; i++) {
	

						batch.draw(bigPipe, -320, 555, 750, 275);
						batch.draw(bigPipe, 960, -85, 750, 275);
						pipes.get(i).t.draw(batch);

					}
				}
				if (puzzle == SINK) {
					batch.draw(arrowDown, 1000, 200, 60, 65);
					if (tapOn) {
						batch.draw(sinkOn, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
					}
				}
				if (noCup && puzzle == KITCHEN) {
					batch.draw(noCupZO, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
				}
				if (puzzle == MICROWAVEPAD) {
					if (doneCheck() && !wrenchPicked) {
						batch.draw(wrench, 150, 50, 150, 100);
					}
					move = false;
					for (int i = 0; i < 9; i++) {

						numSprite.get(i).setSize(50, 50);
						int row = i / 3;
						int col = i % 3;
						numSprite.get(i).setCenterX(730 + col * 55);
						numSprite.get(i).setCenterY(410 + row * 55);
						numSprite.get(i).draw(batch);
					}

				}
				if (puzzle == KNIVES && knifeUp) {
					batch.draw(knifeNoKnife, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);

				}
				if (inventoryCheck == false) {
					batch.draw(inventory, Gdx.graphics.getWidth() - 200, 70, 90, 90);
				} else {
					batch.draw(openInventory, 265, -50, 950, 700);
					batch.draw(openInventory, Gdx.graphics.getWidth() - 200, 70, 90, 90);
					for (int i = 0; i < inventoryList.size(); i++) {
						int row = i / 3; // how items are displayed in inventory
						int col = i % 3;
						if (selected != inventoryList.get(i)) {
							batch.draw(inventoryList.get(i).cluePic, 398 + row * 100, (193 + col * 100), 100, 100);
						}
					}
				}
				if (itemInUse) {
					batch.draw(selected.cluePic, Gdx.input.getX() - 5, Gdx.graphics.getHeight() - Gdx.input.getY(), 70,
							70);
				}

			}
			if ((puzzle != 0 && puzzle != 1 && puzzle != -1 || bookOpen) && inventoryCheck == false) {
				// 1000, 200, 60, 65
				batch.draw(arrow, 25, Gdx.graphics.getHeight() - 10, 65, 60);
			}
		}

		if(kitchenDoor) {
			puzzle = KITCHEN;
			batch.draw(kitchenDoorOpen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
		}
		if(won) { // won! basically, if the buttons work and the door was hit
			batch.draw(endScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 100);
		}

		batch.end();
		game();
	}

	@Override
	public void dispose() {
		basementMasking.dispose();
		batch.dispose();
		addSound.dispose();
		fakeId.dispose();
		openSound.dispose();
		baseBasement.dispose();
		a.dispose();
		b.dispose();
		bb.dispose();
		c.dispose();
		c2.dispose();
		d.dispose();
		e.dispose();
		eb.dispose();
		f.dispose();
		f2.dispose();
		g.dispose();
		g2.dispose();
		kettleNoise.dispose();
		waterNoise.dispose();
		cerealNoise.dispose();

	}

	public boolean checkMorse() {
		//Purpose: check if the last keys hit by the player
		//are the right code to make stick thing fall off
		if (keys.size() < 15) { //if there's fewer keys played total than checking for,
								// false right off the bat
			return false;
		}
		for (int i = 14; i > -1; i--) {
			int k = keys.size() - (15 - i); //have to check the last 15 because those are the most recent,
											// and if the user messes up they can just restart and carry on
			if (keys.get(k) != morse[i]) {
				return false;
			}
		}
		return true;
	}

	public void pickUp(Texture t) {// overloaded: this one for objects with no interactions
		for (int i = 0; i < inventoryList.size(); i++) {
			if (inventoryList.get(i).cluePic == t) { //if already in inventorylist
				return; // don't continue
			}
		}
		ArrayList<Texture> interactions = new ArrayList<Texture>(); // empty arraylist
		Item n = new Item(t, interactions); 
		addSound.play(); //interaction sound for adding something to inventory
		inventoryList.add(n);
	}

	public void pickUp(Texture a, Texture b, Texture c) { // overloaded: this one for objects with interactions
		for (int i = 0; i < inventoryList.size(); i++) { 
			if (inventoryList.get(i).cluePic == a) {
				return;
			}
		}
		ArrayList<Texture> interactions = new ArrayList<Texture>(); //interactions array, this time with textures to
											//make interaction work
		interactions.add(b); //what texture it combines with
		interactions.add(c); //what they produce
		Item n = new Item(a, interactions); // create new Item
		addSound.play(); //interaction sound for adding something to inventory
		inventoryList.add(n); 

	}

	public boolean exitCheck(boolean b) { //exit check for codeUp
		int x = Gdx.input.getX(); //boolean for codeUp (morsecode), as you don't exit if the thing that needs to be
								// exited isn't active
		int y = Gdx.graphics.getHeight() - Gdx.input.getY();
		if (b && x > 20 && x < 95 && y < Gdx.graphics.getHeight() - 5 && y > Gdx.graphics.getHeight() - 55
				&& Gdx.input.isButtonPressed(Input.Buttons.LEFT)) { //checks to see if exit rect was hit
			return false;
		}
		return b;
	}



	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		click = true;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		click = false;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}

