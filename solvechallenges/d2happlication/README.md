Problem Statement
(Average time to write a solution 4-8 hrs)
- Direct to home (D2H) operator SatTV wants you to design a software system for
its customers.
- SatTV offers multiple predefined channel packages (called as base packs
henceforth) and multiple services. Base packs available to purchase are Gold and
Silver which comes with certain channels.
- User has an initial balance of 100 Rs. in his account.
- Whenever the base pack is subscribed, the base package price will be deducted
from the account balance.
- Users will receive a 10% discount on the base pack amount if the duration is at
least 3 months.
- Users can add the individual channel into the current subscription on which
amount will be deducted from the account balance.
- In addition to offering TV channels, SatTV also offers multiple special optional
services - Learn English Service and Learn Cooking service.
- If any of the services are purchased by the user, the corresponding amount will
be deducted from the balance.
- Whenever a user subscribes to any package or service, notifications should be
sent through email and SMS if the user has updated his email and phone number.
Notes:
1. Obviously we don’t expect from you to develop real Email and SMS
notification features. You should just show the message on the console that
Email and SMS are sent successfully. Although try to create a design it in
such a way that in future you should be able to integrate the real email/SMS
functionality without touching other parts of the system!
2. The list of packages, channels and prices are shown directly in sample
input/output

Please do not hesitate to reach out to us if you have any questions about any of the
points :)

Please create your project/solution in such a way that we should be able to

run it in IDE out of the box without any efforts.

D2H Coding Problem
Sample Input/Output for Console Application
Note: To save space, we haven’t shown the input options every time after the
processing is complete for the last selected option. Although you can show them if
you would like :-)
Welcome to SatTV
1. View current balance in the account
2. Recharge Account
3. View available packs, channels and services
4. Subscribe to base packs
5. Add channels to an existing subscription
6. Subscribe to special services
7. View current subscription details
8. Update email and phone number for notifications
9. Exit

Enter the option: 1
View current balance in the account
Current balance is 100 Rs.
======{Here you can show all the options each time if you’d like}==========
Enter the option: 2
Enter the amount to recharge: 500
Recharge completed successfully. Current balance is 600
============================================================
Enter the option: 3
View available packs, channels and services
Available packs for subscription
Silver pack: Zee, Sony, Star Plus: 50 Rs.
Gold Pack: Zee, Sony, Star Plus, Discovery, NatGeo: 100 Rs.
Available channels for subscription
Zee: 10 Rs.
Sony: 15 Rs.
Star Plus: 20 Rs.
Discovery: 10 Rs.
NatGeo: 20 Rs.
Available services for subscription
LearnEnglish Service: 200 Rs.
LearnCooking Service: 100 Rs.
============================================================

Please create your project/solution in such a way that we should be able to

run it in IDE out of the box without any efforts.

D2H Coding Problem

Enter the option: 4
Subscribe to channel packs
Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’): G
Enter the months: 3
You have successfully subscribed the following packs - Gold
Monthly price: 100 Rs.
No of months: 3
Subscription Amount: 300 Rs.
Discount applied: 30 Rs.
Final Price after discount: 270 Rs.
Account balance: 330 Rs.
Email notification sent successfully
SMS notification sent successfully
============================================================
Enter the option: 5
Add channels to existing subscription
Enter channel names to add (separated by commas): Discovery, Nat Geo
Channels added successfully.
Account balance: 300 Rs.
============================================================
Enter the option: 6
Subscribe to special services
Enter the service name: LearnEnglish
Service subscribed successfully
Account balance: 100 Rs.
Email notification sent successfully
SMS notification sent successfully
============================================================
Enter the option: 7
View current subscription details
Currently subscribed packs and channels: Gold + Discovery + Nat Geo
Currently subscribed services: LearnEnglish.
============================================================
Enter the option: 8
Update email and phone number for notifications
Enter the email: john@example.com
Enter phone: 9999999999
Email and Phone updated successfully