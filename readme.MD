# promotion-code-app
Problem Statement
Create a Service to call Third-party API and run a Scheduler based Job

Features
Get the Result from API: https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest
Find a way to convert the Currency to INR
Run a Timely Promotion only one at a time :
Promotion Set A:
There will be a 7% discount on the price if the origin of the products in Africa
There will be a discount of 4% if the product rating is equal to 2 and 8 % if the product rating is below 2
Promotion Set B:
There will be a 12% discount on the prices if the inventory is more than 20
There will be a discount of 7% if the product arrival status is new
Common Rules:
There can only be one discount applied at a time for each Promotion Set
You have to apply the discount which provides the highest discount to the customer
There will be a default discount of 2% if the price of the item exceeds Rs 1000 and no other discount was applied.