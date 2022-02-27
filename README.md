# SimCitySimulation

## Electric Bike Share Simulation
This simulation uses real-time preference rating to determine which bike company a customer will choose. Based on compound ratings from previous customer trips, the preference rate towards a company will dynamically fluctuate. In the beginning, if company Blue has really good quality bikes, customers will tend to go to the good bikes. When the blue company starts running out of available stocks, then customers will start giving bad reviews leading to Red's ratings going up. After running the simulation for a longer time period, we can determine which is a better bike company.

To complete this simulation, initial assumptions had to be made to control the environment of the model. Company Blue has an initial stock of 50 electric bikes and each bike has a 0.90 quality rate. Company Red has an initial stock of 160 electric bikes with each bike having 0.60 quality rate. All the bikes are equally divided and stored in 4 major locations. Each location has its own "spawn rate" to mimic high and low population count. Manhattan has 0.35, Queens 0.30, Jones Beach 0.20, and Stony Brook 0.15. These numbers indicate that Stony Brook has half the population of Queens. When a customer chooses a company to use, that bike will become "unavailable" for some random time to mimic scarcity. Each customer trip provides a rating following this formula: successful trips is a random rating from 8 to 10, a bike breaking down is a random rating from 2 to 8 multiplied by the percentage of distance traveled, and unavailable bikes is a random rating from 0 to 2. 

All these parameters could be adjusted live while the simulation is active. You can also pause and unpause the simulation to adjust your data as needed.

![image](https://user-images.githubusercontent.com/32024479/155900677-63eef3a0-75c7-4c33-a9e5-7b9e6b70c6fc.png)

## Exporting Data
After completing couple simulations and finding the right parameters, you can export the entire simulation as a csv file. You can click "show console" and then enter "save data.csv". This will save all the customers and trips into a external file in the same directory. You can open it via excel to do some data analysis or import it into your Jupyter notebok for automatic data analysis.

![image](https://user-images.githubusercontent.com/32024479/155900753-3f2a373b-6222-4684-944b-c14e97d9b556.png)

## Analysis
Looking at the preference rating over time, 3/4th into the first day of launching, company Blue overtook company Red as a preferred bike. This correlates with the fact that Blue's bikes have a quality of 0.90 thus receiving better ratings. Near the end of the first day, customers started choosing company Blue more frequently for their trips. However, Blue's rein did not last long since they quickly ran out of inventory. Customers were not able to secure a bike therefore gave bad reviews which tanked Blue's overall rating. Half way through the second day, company Red took over significantly because they had an abundance of bikes. Even though Red's bikes broke down 60% of the time, customers preferred a company that provided a bike rather than one that did not.
The ratings are compounded over time which means results fluctuate in the early days but become steady closer to the end. The first set of customers are the "voices" for the remaining customers throughout the week. Their ratings matter because if they lead all their preference towards company Blue, the traction will pull in more customers towards Blue as well. But this hype will not last long because half way through the week, the ratings will start averaging out and enter into equilibrium. After day 3, it is shown what the true ratings look like for company Blue and Red.
![image2](https://user-images.githubusercontent.com/32024479/155901344-34cdfa4d-f5ec-4272-a9b6-5ea0b592fa39.png)


## Background
This is the background I spent about 13 hours putting together using Icograms. Each section is meant to take on a new theme revolving around NYC and Long Island. Starting with top right corner, that is Stony Brook seperated by forests to mimic it being far away from closest suburb. Next up, bottom right is Jones Beach. Right above it is Queens with resedential buildings. At the very left, the skyscrapers is Manhattan. Each of these locations produce customers that gets spawned and travels to its closest neighbor.
![image](https://user-images.githubusercontent.com/32024479/155900697-b3ac208a-c962-405d-a841-b308ca367438.png)




