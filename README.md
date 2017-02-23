Motivation:
==============================================

To understand and implement state design pattern.

The game has the following rules:
==============================================

1. The monkey can move horizontally and vertically. This is controlled by the up, down, left and right keys
   of the keyboard. These keys can be pressed or clicked to advance the monkey continuously or one step at
   a time. The monkey moves from one small square to another. For this homework, set N=50.
2. The monkey needs time to move from one small square to another.
3. The monkey must get and eat the banana in a preset period of time, measured from the occurrence of the
   banana. If the monkey does not get the banana within this time period, the banana is placed at another
   randomly determined position, and the time is recounted .
4. The game finishes with:
   (a) success if the monkey eats K bananas within a given time period, or
   (b) failure otherwise
5. In either of above case, the total score is displayed, and optionally appropriate sound is played and/or
   pictures are displayed.