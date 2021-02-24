Bacteria simulation
------------
By emilssipols11 and leokruglikov

# Description
This is a project which attempts to simulate the life of two types of bacteria. There is food spawning at random locations and there exist two types of bacteria: one of them 
only eats the food (purlple) that spaws and the other one eats only the first bacteria (green). Both of them have a different field of vision and movement speed. 

If there is no source of food in the bacterias field of vision they move in random directions (the direction of movement changes after a specified amount of time has passed). If any of the bacteria has eaten 
enough source of food, it multiplies. The contrary is also true: if the bacteria has not eaten for long enough, it dies. There is also a graph representing the population 
size of both bacteria (for each bacteria the graph is in the corresponding color).

![GIF](https://raw.githubusercontent.com/emilssipols11/bacteria-sim/master/simulation.gif)


# Setup
 Download the folder app and move it into your projects source directory. The project also uses a C++ based library sfml that was rewritten in java as jsfml. Download the jsfml.jar file and add it as a library to your project. After that run the main method in App.java.
 
 
