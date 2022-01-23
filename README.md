# Santa Claus is coming to ACS students Etapa 1

## About

Object Oriented Programming Course

January 2021

https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa1

Student: Ilie Dana Maria, 324CA

## Run tests

Class Main
    * runs checker on implementation
    * runs checkstyle


## Implementation

### Structure

src
|____
    |__commom
    |  |__Constants (useful for parsing)
    |
    |__database
    |  |__Database (Singleton database that stores all data)
    |
    |__entities
    |  |__Baby (implements IChild)
    |  |__Kid (implements IChild)
    |  |__Teen (implements IChild)
    |  |__YoungAdult (implements IChild)
    |  |__Gift (data of a gift)
    |
    |__enums
    |  |__Category (enum for gift categories )
    |  |__Cities (enum for cities) 
    |
    |__factories
    |  |__IChildFactory (factory to create children)
    |
    |__input
    |  |__AnnualChangesInputData (stores data about annual changes)
    |  |__ChildrenInputData (stores data about children)
    |  |__ChildUpdateInputData (stores data about a child's update)
    |  |__Input (all input data)
    |  |__InputLoader (input data parser)
    |  |__SantaGiftsInputData (stores data about gifts)
    |
    |__interfaces
    |  |__IChild (implemented by Baby, Kid, Teen, YoungAdult
    |
    |__main 
    |  |__Main
    |
    |__simulationflow
    |  |__InitialRound (the flow of the first round)
    |  |__StandardRound (the flow of the rest of the rounds) 
    |
    |__updates
    |  |__AnnualChange
    |  |__ChildUpdate
    |
    |__utils
    |  |__Utils
    |
    |__writer
    |  |__AnnualChildren (wrapper class)
    |  |__Children (wrapper class)
    |  |__Writer
    |
    

### Flow

Round 0:

As this is the first round of the game, initializations are required.
First of all, the average score for each child is calculated based on the age
group the child is part of. Each child is made part of an age group since the beggining, 
using a Factory Design Pattern. After that, the budget for each child's gifts is 
calculated.
Finally, the gifts for each child are distributed. Each child receives a gift
from each category of its gift preferences(cheapest from Santa's gifts list), 
as long as the budget is not overrun. In order to do that, each child's gift
preferences list is iterated, then for each category in that list, the cheapest
gift in Santa's list is searched. If a gift was found, it is checked if the 
price of it is within the budget. If so, the gift is assigned to the child.

Standard Round:
In the beggining, for each child that's on Santa's list the age is incremented.
The children who just became young adults (children who are oldren than 18) are
removed from Santa's list. Then, each child's age group is modified (if 
needed).
Next, each update from the updates list of that year is executed: Santa's budget
for that year is modified, new gifts(if they exist) are added to Santa's gifts 
list, new children (if they exist) are added to Santa's children list and 
existing children could be updated. To execute an update on an already existing
child, first it is checked that the child is still on Santa's list (search 
based on id), then the new Nice Score is added to the child's Nice Score History
list and new gift preferences are added to the child's gift preferences list. 
If the newly added category is already on the preferences list, the old occurence
of the category is removed from the list.
In the end, the same steps from Round 0 are executed.

### Design Patterns

In my implementation I have used the Singleton Design Pattern for the Database
and for the Children Factory, as there is no need for more than one instance of
these classes. 
I have also made use of the Factory Design Pattern for Baby, Kid,
Teen and YoungAdult, which extend IChild. I found this to be useful in case the
children will be split into different cateogries(ages groups) and we will have
to add some new entities.

