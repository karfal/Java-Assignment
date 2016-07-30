# Java-Assignment

Here is my 2nd year degree OOP assignment.

These are the specs on which the app was to be created:

When a customer asks FlexBox to quote a price for an order they specify the following:

• The size of the box (width, length, and height);
• The grade of card;
• Whether they want any colour printing (no colour, or 1, or 2 colour printing);
• Whether they want any bottom and/or corner reinforcement;
• Whether the box has a sealable top;
• The quantity of boxes.

From this information, the order system should determine if the type of box requested can be supplied by FlexBox; if it
cannot, the system should display an appropriate message and reject the order. If the ordered box/boxes correspond to
any of the types given in Table 1, and can be supplied by FlexBox, the cost of the order must be calculated and quoted.
Customers should not be asked for the type of the box they order, since this is only used within the company to
calculate the cost: your application must determine the type of the ordered boxes (using Table 1).
If a customer is placing more than one order (say one order for 5 boxes (of type I) and another order of 10 boxes (of
type II)), then he/she should receive a quote with the total cost of the orders.
Your user interface should be a GUI (graphical user interface) using AWT/Swing. If no GUI is used, you will lose the
marks allocated for this part of your coursework.
Your
Task
• Write an application, which will allow the customer to enter the details of his/her order and will calculate the
cost of the order. Your application should verify that FlexBox can supply the type of box requested (the
customer should not be asked to specify the box type).
• Use an OO design approach (abstraction, inheritance and polymorphism) and create a class hierarchy that
describes the types of boxes FlexBox sells.
• Use proper level of abstraction, encapsulation and accessibility for the class attributes and methods.
• Devise a suitable test plan and data, and use it to test the performance of your ordering system.
