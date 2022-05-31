# Period 3 Punchout😮🥊
## Bella Santos and Henry Lemersal
Hey y'all! Here is our legendary game: Period 3 Punchout. Unlike typical fighting games, this one features OUR AWESOME CLASS! Look out for familiar faces, locations, and more. We hope you enjoy :)

<img width="771" alt="Screen Shot 2022-05-30 at 11 31 22 PM" src="https://user-images.githubusercontent.com/90801629/171107485-896a11d0-ac8e-4c9b-9cc5-3f91771980d0.png">

![E2B08EF7-B9F4-48AF-9ABB-A5A6469D7C2E](https://user-images.githubusercontent.com/70670835/171136345-e416d2f9-989a-4cda-9a95-1f67715e75d0.png)

## How to Play
To get started, press the space key and you'll be sent to the Character Select Screen. Click through the characters using the left or right arrows and select the two you want to choose for game play! Character 1 uses A and D for left and right movement, W for jump, and Z for punch. Character 2 uses J and L for left and right movement, W for jump, and M for punch. Each character starts with a certain hp of health and speed, but each received punch causes damage and reduces that damaged character's hp by 10. You can view each character's hp score at the top left and right of the screen. Whichever character's hp reaches zero first loses and an endgame winner screen appears!

## Overview
Our classes include Frame class as the GUI, Background, and the Character parent classes. There are Character subclasses that extend Character include Aak, Belluh, HennyBaby, MD, and Vyane since each character has their own!

## Our Code: Key Methods
### Paint
In our paint method, we included code to paint the given backgrounds for start, character select, and game over, use switch cases to show certain characters on the Character Select Screen, and utilize fonts to create text updates for the Timer and HP score. Scroll for some paint code snippets!

<img width="341" alt="Screen Shot 2022-05-31 at 6 17 46 AM" src="https://user-images.githubusercontent.com/90801629/171183039-e63d93e0-1892-49fb-b068-6b76afc3e303.png">


<img width="387" alt="Screen Shot 2022-05-31 at 6 18 05 AM" src="https://user-images.githubusercontent.com/90801629/171183056-79ecf613-8bcf-4c04-ae19-f10b05dd7d6b.png">

### Character Select Screen 
In the Character Class, we initialized and filled an array with values to organize character selections to keep track of which ones were picked as noted below. As seen in paint above, we also included a method called preview for cycling between characters using a switch statement in Paint so each character's name is drawn on screen at the same time their image shows up. 

<img width="301" alt="Screen Shot 2022-05-31 at 7 15 09 AM" src="https://user-images.githubusercontent.com/90801629/171195016-5fcc23c3-75b3-4b68-8ba6-bec014ffe984.png">

### Sprite Transitions 
We used sprite transitions for direction changes and when punch is called. We created a method in Character called sprite that takes in a String of image and sets it to img using getImage(). In each individual character subclass constructor, these are assigned to correlate each character with certain images.  

<img width="879" alt="Screen Shot 2022-05-31 at 7 23 12 AM" src="https://user-images.githubusercontent.com/90801629/171197011-52fdaed0-b3ee-483a-bc8b-8b5b3ea9122a.png">

In Frame, we used the KeyPressed method to set if FaceRight and punching were true or false. We used these booleans in the Character classes to figure out which Sprite to transition to based on direction facing and if punching!

<img width="383" alt="Screen Shot 2022-05-31 at 7 22 02 AM" src="https://user-images.githubusercontent.com/90801629/171196766-aacc7479-bae7-45ef-87bc-0fd99d25c402.png">

In Frame, we used the KeyPressed method to set if FaceRight and punching were true or false. We used these booleans in the Character classes to figure out which Sprite to transition to based on direction facing and if punching!

<img width="310" alt="Screen Shot 2022-05-31 at 7 20 30 AM" src="https://user-images.githubusercontent.com/90801629/171196361-1caf88a2-2ddd-4072-8756-59fc56f276bf.png">


### Punch, HP, and Damage
We declared a punch method in the Character class that takes in parameters for opponent, right direction, and damage. Inside, the method checks if the opponent is in range and they are facing the right way using the x and y coordinates, then subtracts damage. As mentioned earlier, the KeyPressed method calls the punch method for each character if that given key is pressed.

<img width="770" alt="Screen Shot 2022-05-31 at 7 28 30 AM" src="https://user-images.githubusercontent.com/90801629/171198278-ba418b55-6552-4736-8000-f26eba0e25e6.png">

### Game Over and Play Again
Each character starts with a unique health number that reduces by 10 hp when punched. The first character that reaches zero hp loses. A Game Over screen is shown using bg.gameOver and we print out "Congratulations" to whoever wins aka survives the longest. You are then able to click space again for the Character Select Screen and to restart the game!

<img width="416" alt="Screen Shot 2022-05-31 at 7 32 49 AM" src="https://user-images.githubusercontent.com/90801629/171199262-71f328f1-a996-4389-ae55-38524abbe6d8.png">

<img width="548" alt="Screen Shot 2022-05-31 at 7 33 40 AM" src="https://user-images.githubusercontent.com/90801629/171199426-246fe882-f107-4a90-a37e-30716df6a116.png">


## Support and Roadmap
For support, reach out to Bella for graphics, sprite paint implementation, damage, sprite transitions, and setters/getters. Reach out to Henry for suppport on Character subclasses, background implementation, Character selection, game sequencing, and physics movement. We do not plan on actively updating our game in the future, but do think it would be cool to integrate more player options so more people could be included or to create object features such as throws with personalized projectiles for each character.  


## Authors & Acknowledgment
All objects, sprites, and backgrounds were created by Bella on PixilArt with inspiration from our class. Thanks to everyone who helped contribute to the success of our game!

## THANK YOU!
### sincerely, bella santos and henry lemersal :) #yassification #girlBosses #compSciQueens

<img width="310" alt="Screen Shot 2022-05-31 at 8 09 47 AM" src="https://user-images.githubusercontent.com/90801629/171207736-c3e84484-b764-490f-9726-2d49adffaf61.png">

